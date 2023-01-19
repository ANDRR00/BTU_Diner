package com.example.myapplication.inner


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.OrderDirections
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class OrderFragment : Fragment(R.layout.fragment_order2) {

    private lateinit var foodView: TextView
    private lateinit var tableView: TextView
    private lateinit var btnClear: Button

    private lateinit var Builder: AlertDialog.Builder

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("Order_List")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClear = view.findViewById(R.id.clear_order_btn)
        foodView = view.findViewById(R.id.foodView)
        tableView = view.findViewById(R.id.tableView)

        Builder = AlertDialog.Builder(this.requireContext())

        db.child(auth.currentUser?.uid!!).get().addOnSuccessListener {

            if (it.exists()) {

                val order = it.child("order").value
                val table = it.child("table").value

                foodView.text = order.toString()
                tableView.text = table.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
        }


        btnClear.setOnClickListener {

            Builder.setTitle("Alert!")
                .setMessage("ნამდვილად გსურთ შეკვეთის გაუქმება?")
                .setCancelable(true)
                .setPositiveButton("Yes") { dialogInterface, it ->
                    db.child(auth.currentUser?.uid!!).removeValue()
                    foodView.text = ""
                    tableView.text = ""
                }
                .setNegativeButton("NO") { dialogInterface, it ->
                    dialogInterface.cancel()
                }.show()

        }
    }
}
