package com.example.myapplication.inner

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Forgot_Password
import com.example.myapplication.LoginActivity
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment(R.layout.fragment_profile2) {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("Users")

    private lateinit var Builder: AlertDialog.Builder

    private lateinit var resultUsername: TextView
    private lateinit var resultEmail: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val passchangebtn = view.findViewById<Button>(R.id.changepassbtn)
        val btnlogout = view.findViewById<Button>(R.id.logoutbtn)

        Builder = AlertDialog.Builder(this.requireContext())

        resultUsername = view.findViewById(R.id.profilename)
        resultEmail = view.findViewById(R.id.profilemail)

        db.child(auth.currentUser?.uid!!).get().addOnSuccessListener {

            if (it.exists()) {

                val username = it.child("username").value
                val email = it.child("email").value

                resultUsername.text = "სახელი: " + username.toString()
                resultEmail.text = "თქვენი ელფოსტა: " + email.toString()

            } else {
                Toast.makeText(
                    this.requireContext(),
                    "მომხმარებელი არ არებობს!",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
        }

        passchangebtn.setOnClickListener {

            Builder.setTitle("Alert!")
                .setMessage("ნამდვილად გსურთ პაროლის შეცვლა?")
                .setCancelable(true)
                .setPositiveButton("Yes") { dialogInterface, it ->
                    val intent = Intent(this.requireContext(), Forgot_Password::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("NO") { dialogInterface, it ->
                    dialogInterface.cancel()
                }.show()
        }

        btnlogout.setOnClickListener {

            Builder.setTitle("Alert!")
                .setMessage("ნამდვილად გსურთ ანგარიშიდან გასვლა?")
                .setCancelable(true)
                .setPositiveButton("Yes") { dialogInterface, it ->
                    Firebase.auth.signOut()
                    val intent = Intent(this.requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("NO") { dialogInterface, it ->
                    dialogInterface.cancel()
                }.show()
        }
    }
}