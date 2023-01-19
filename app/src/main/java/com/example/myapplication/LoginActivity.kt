package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var check: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        check = findViewById(R.id.checkBox)
        val emaillgn = findViewById<EditText>(R.id.loginemail)
        val passwordlgn = findViewById<EditText>(R.id.loginpassword)
        val lgn_btn = findViewById<Button>(R.id.login_btn)
        val signUp_btn = findViewById<Button>(R.id.signup_btn)
        val forgotPass = findViewById<TextView>(R.id.forgotpass)

        loadData()

        if (check.isChecked){
            if (FirebaseAuth.getInstance().currentUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


        signUp_btn.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

        forgotPass.setOnClickListener {
            val intent = Intent(this, Forgot_Password::class.java)
            startActivity(intent)
            finish()
        }

        lgn_btn.setOnClickListener {
            val lgn_email = emaillgn.text.toString()
            val lgn_password = passwordlgn.text.toString()

            if (lgn_email.isEmpty() || lgn_password.isEmpty()) {
                Toast.makeText(this, "გრაფა ცარიელია!", Toast.LENGTH_SHORT).show()
            } else {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(lgn_email, lgn_password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
            }
        }
        check.setOnClickListener{
            saveData()
        }
    }

    private fun saveData() {
        val sharedPreference=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor=sharedPreference.edit()
        editor.apply {
            putBoolean("CHECK_KEY",check.isChecked)
        }.apply()
    }

    private fun loadData() {
        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedCheck=sharedPreferences.getBoolean("CHECK_KEY", false)
        check.isChecked=savedCheck
    }



}