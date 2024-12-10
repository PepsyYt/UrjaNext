package com.ravimaurya.urjanext.data.repository_impl

import android.app.AuthenticationRequiredException
import android.util.Log
import androidx.collection.emptyIntSet
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.ravimaurya.urjanext.domain.model.UserModel
import com.ravimaurya.urjanext.domain.repository.AuthenticationRepository
import com.ravimaurya.urjanext.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resumeWithException

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthenticationRepository {

    private val TAG = AuthRepositoryImpl::class.java.toString()

    override suspend fun checkUserExist() = flow {
        val currentUser = firebaseAuth.currentUser
        Log.d("CurrentUserRepo", "User: ${currentUser!!.email}")
        if (currentUser != null){
            emit(Resource.Success(true))
        }
        else{
            emit(Resource.Success(false))
            emit(Resource.Error("User Not found!"))
        }
    }

    override suspend fun register(userModel: UserModel) = flow {
        try {

            emit(Resource.Loading)

            val user = suspendCancellableCoroutine { continuation ->
                firebaseAuth.createUserWithEmailAndPassword(userModel.email, userModel.userPassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            continuation.resume(firebaseAuth){}
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            continuation.resumeWithException(task.exception ?: Exception("Unknown error"))
                        }
                    }
            }.currentUser
            Log.d(TAG, "User: ${user!!.email} - ${user.uid}")
            emit(Resource.Success(userModel))

        }catch (e: Exception){
            Log.w(TAG, "Ex: Registration failed!")
            emit(Resource.Error(e.message ?: "Registration failed!"))
        }

    }

    override suspend fun login(userModel: UserModel) = flow {
        try {

            emit(Resource.Loading)

            val user = suspendCancellableCoroutine { continuation ->
                firebaseAuth.signInWithEmailAndPassword(userModel.email, userModel.userPassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInUserWithEmail:success")
                            continuation.resume(firebaseAuth){}
                        }
                        else{
                            Log.w(TAG, "LoginRepo: Unknown error: ${userModel.email} - ${userModel.userPassword}")
                            continuation.resumeWithException(task.exception ?: Exception("Unknown error!"))
                        }
                    }

            }.currentUser

            Log.d(TAG, "User: ${user!!.email} - ${user.uid}")
            emit(Resource.Success(userModel))

        } catch (e: Exception){
            Log.w(TAG, "REpoException: Login Failed")
            emit(Resource.Error(e.message ?: "EmitREpo: Login failed!"))
        }
    }

    override suspend fun deleteAccount(): Flow<Resource<String>> {
        TODO("Not yet implemented")
    }
}