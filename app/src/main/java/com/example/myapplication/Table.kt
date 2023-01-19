package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class Table : Fragment(R.layout.fragment_table) {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("Order_List")

    private lateinit var order: String

    private lateinit var layout1: LinearLayout
    private lateinit var layout2: LinearLayout
    private lateinit var layout3: LinearLayout
    private lateinit var layout4: LinearLayout
    private lateinit var layout5: LinearLayout
    private lateinit var layout6: LinearLayout
    private lateinit var layout7: LinearLayout
    private lateinit var layout8: LinearLayout
    private lateinit var layout9: LinearLayout
    private lateinit var layout10: LinearLayout
    private lateinit var layout11: LinearLayout
    private lateinit var layout12: LinearLayout
    private lateinit var layout13: LinearLayout
    private lateinit var layout14: LinearLayout
    private lateinit var layout15: LinearLayout
    private lateinit var layout16: LinearLayout
    private lateinit var layout17: LinearLayout
    private lateinit var layout18: LinearLayout
    private lateinit var layout19: LinearLayout
    private lateinit var layout20: LinearLayout
    private lateinit var layout21: LinearLayout
    private lateinit var layout22: LinearLayout
    private lateinit var layout23: LinearLayout
    private lateinit var layout24: LinearLayout


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layout1 = view.findViewById(R.id.table1)
        layout2 = view.findViewById(R.id.table2)
        layout3 = view.findViewById(R.id.table3)
        layout4 = view.findViewById(R.id.table4)
        layout5 = view.findViewById(R.id.table5)
        layout6 = view.findViewById(R.id.table6)
        layout7 = view.findViewById(R.id.table7)
        layout8 = view.findViewById(R.id.table8)
        layout9 = view.findViewById(R.id.table9)
        layout10 = view.findViewById(R.id.table10)
        layout11 = view.findViewById(R.id.table11)
        layout12 = view.findViewById(R.id.table12)
        layout13 = view.findViewById(R.id.table13)
        layout14 = view.findViewById(R.id.table14)
        layout15 = view.findViewById(R.id.table15)
        layout16 = view.findViewById(R.id.table16)
        layout17 = view.findViewById(R.id.table17)
        layout18 = view.findViewById(R.id.table18)
        layout19 = view.findViewById(R.id.table19)
        layout20 = view.findViewById(R.id.table20)
        layout21 = view.findViewById(R.id.table21)
        layout22 = view.findViewById(R.id.table22)
        layout23 = view.findViewById(R.id.table23)
        layout24 = view.findViewById(R.id.table24)

        order = ""

        db.child(auth.currentUser?.uid!!).get().addOnSuccessListener {

            if (it.exists()) {
                order = it.child("order").value.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
        }

        layout1.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N1"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout2.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N2"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout3.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N3"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        layout4.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N4"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout5.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N5"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout6.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N6"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout7.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N7"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout8.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N8"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout9.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N9"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout10.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N10"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout11.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N11"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout12.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N12"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout13.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N13"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout14.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N14"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout15.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N15"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout16.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N16"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout17.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N17"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout18.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N18"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout19.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N19"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout20.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N20"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout21.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N21"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout22.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N22"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout23.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N23"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        layout24.setOnClickListener {

            if (order == "") {
                Toast.makeText(
                    this.requireContext(),
                    "კაფეტერიაში საკვების შეკვეთის გარეშე ვერ დაჯავშნით მაგიდას!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val table = "მაგიდა N24"
                val personalInfo = Order_list(order, table)

                db.child(auth.currentUser?.uid!!).setValue(personalInfo).addOnSuccessListener {
                    val intent = TableDirections.actionTableToOrder()
                    findNavController().navigate(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.requireContext(), "ხარვეზი!", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }
}