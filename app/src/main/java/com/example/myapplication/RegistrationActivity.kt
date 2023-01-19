package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class RegistrationActivity : AppCompatActivity() {
    private lateinit var PersonName: TextView
    private lateinit var PersonEmail: TextView
    private lateinit var PersonPassword: TextView
    private lateinit var btnSignUp: Button

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("Users")

    private lateinit var email: String
    private lateinit var Password: String
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportActionBar?.hide()

        PersonName = findViewById(R.id.registration_name)
        PersonEmail = findViewById(R.id.registration_email)
        PersonPassword = findViewById(R.id.registration_password)

        btnSignUp = findViewById(R.id.signup_btn)

        btnSignUp.setOnClickListener {
            email = PersonEmail.text.toString()
            Password = PersonPassword.text.toString()
            username = PersonName.text.toString()

            if (username.isEmpty() || email.isEmpty() || Password.isEmpty()) {
                Toast.makeText(this, "გრაფა ცარიელია!", Toast.LENGTH_SHORT).show()
            } else {

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, Password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val personInfo = PersonInfo(username, email)
                            db.child(auth.currentUser?.uid!!).setValue(personInfo).addOnSuccessListener {
                                Toast.makeText(
                                    this,
                                    "თქვენი ანგრიში წარმატებით შეიქმნა",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            }.addOnFailureListener {
                                Toast.makeText(this, "დაფიქსირდა შეცდომა!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
            }
        }
    }
}