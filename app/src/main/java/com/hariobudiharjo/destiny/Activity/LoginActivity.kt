package com.hariobudiharjo.destiny.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.hariobudiharjo.destiny.R
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import android.app.ProgressDialog
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log


class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var progress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        actionBar?.title = "Login"
        mAuth = FirebaseAuth.getInstance()

        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Wait while loading...")
        progress.setCancelable(false)

        btn_login.setOnClickListener {
            progress.show()
            login(edtEmail?.text.toString(), edtPassword?.text.toString())
        }
        btn_txt_signup.setOnClickListener {
            val intent = Intent(this, SIgnUpActivity::class.java)
            startActivity(intent)
        }
    }

    fun login(email: String, password: String) {

        Log.d("DEBUG", "MASUK LOGIN")
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                progress.dismiss()
                if (it.isSuccessful) {
                    Log.d("DEBUG", "signInWithEmail:success")
                    val user = mAuth.getCurrentUser()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.w("DEBUG", "signInWithEmail:failure", it.exception)
                    Toast.makeText(this@LoginActivity, "Authentication failed  = " + it.exception?.message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }
}
