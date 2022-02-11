package com.example.mechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.paging.FirestorePagingAdapter
import com.firebase.ui.firestore.paging.FirestorePagingOptions

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.fragment_chats.*


class ContactsFragment:Fragment() {
  private lateinit var adapter: FirestorePagingAdapter<User, UserViewHolder>
  private lateinit var auth:FirebaseAuth
 val db by lazy {
       FirebaseFirestore.getInstance().collection("users")
           .orderBy("name",Query.Direction.DESCENDING)
 }
    override fun onCreateView(
        inflater: LayoutInflater,v:ViewGroup?,
        savedInstanceState:Bundle?
    ) :View?{
        setAdapter()
         return inflater.inflate(R.layout.fragment_chats,v,false)
    }

    private fun setAdapter() {
        val pg= PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .setPrefetchDistance(2)
            .build()

        val options=FirestorePagingOptions.Builder<User>()
            .setLifecycleOwner (viewLifecycleOwner)
            .setQuery(db,pg,User::class.java)
            .build()
            adapter=object : FirestorePagingAdapter<User,UserViewHolder>(options){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
                  return UserViewHolder( layoutInflater.inflate(R.layout.individual_box,parent,false) )
            }

            override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: User) {
                holder.bind(user=model)
            }


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcViewChat.adapter=adapter
        rcViewChat.layoutManager=LinearLayoutManager(requireContext())
    }
}