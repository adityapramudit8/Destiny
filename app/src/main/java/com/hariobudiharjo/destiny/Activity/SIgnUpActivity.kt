package com.hariobudiharjo.destiny.Activity

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hariobudiharjo.destiny.R
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_up.*


class SIgnUpActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var progress: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        actionBar?.title = "Sign Up"
        mAuth = FirebaseAuth.getInstance()

        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Wait while loading...")
        progress.setCancelable(false)

        btn_signup.setOnClickListener {
            progress.show()
            signup(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }

    fun signup(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                progress.dismiss()
                if (task.isSuccessful) {
                    Log.d("DEBUG", "createUserWithEmail:success")
                    val user = mAuth.currentUser
                    finish()
                } else {
                    Log.w("DEBUG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this@SIgnUpActivity, "Authentication failed.", Toast.LENGTH_SHORT).show()

                }
            }
    }

    fun suksesSignup() {

    }

    fun gagalSignup() {

    }
}
