package com.example.mechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth= FirebaseAuth.getInstance()
        if(auth.currentUser==null){
             GoToLogin()
        }
        else{
            GoToMain()
        }
    }

   private fun GoToMain(){
       startActivity(Intent(this,MainActivity::class.java))
   }

    private fun GoToLogin(){
        startActivity(Intent(this,LoginActivity::class.java))
    }
}