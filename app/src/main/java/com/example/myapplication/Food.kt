package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class Food : Fragment(R.layout.fragment_food), AdapterFoods.OnItemClickListener {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("Order_List")

    private lateinit var nextbtn: Button
    private lateinit var adapter: AdapterFoods
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodArrayList: ArrayList<Foods>

    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    private var order = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextbtn = view.findViewById(R.id.foodnxt_btn)
        nextbtn.setOnClickListener {
            val intent = FoodDirections.actionFoodToTable()
            findNavController().navigate(intent)
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterFoods(foodArrayList, this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        val clickedItem = foodArrayList[position]
        adapter.notifyItemChanged(position)
        val name = clickedItem.heading
        order = " $order\n $name"

        val table = ""
        val personInfo = Order_list(order, table)
        db.child(auth.currentUser?.uid!!).setValue(personInfo).addOnSuccessListener {
        }.addOnFailureListener {
            Toast.makeText(this.requireContext(), "დაფიქსირდა შეცდომა!", Toast.LENGTH_SHORT).show()
        }
    }



    private fun dataInitialize() {

        foodArrayList = arrayListOf<Foods>()

        imageId = arrayOf(
            R.drawable.food_1,
            R.drawable.food_2,
            R.drawable.food_3,
            R.drawable.food_4,
            R.drawable.food_5,
            R.drawable.food_6,
            R.drawable.food_7,
            R.drawable.food_8,
            R.drawable.food_9,
            R.drawable.food_10,

            R.drawable.drink_1,
            R.drawable.drink_2,
            R.drawable.drink_3,
            R.drawable.drink_4,
            R.drawable.drink_5,
            R.drawable.drink_6,
            R.drawable.drink_7,
            R.drawable.drink_8
        )

        heading = arrayOf(
            getString(R.string.food_1),
            getString(R.string.food_2),
            getString(R.string.food_3),
            getString(R.string.food_4),
            getString(R.string.food_5),
            getString(R.string.food_6),
            getString(R.string.food_7),
            getString(R.string.food_8),
            getString(R.string.food_9),
            getString(R.string.food_10),

            getString(R.string.drink_1),
            getString(R.string.drink_2),
            getString(R.string.drink_3),
            getString(R.string.drink_4),
            getString(R.string.drink_5),
            getString(R.string.drink_6),
            getString(R.string.drink_7),
            getString(R.string.drink_8),
        )

        for (i in imageId.indices) {

            val food = Foods(imageId[i], heading[i])
            foodArrayList.add(food)
        }
    }

}