package com.example.mechat

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.individual_box.view.*

class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    fun bind(user:User)=with(itemView){
         countTv.isVisible=false
         timeTv.isVisible=false
        titleTv.text=user.name
        subTitleTv.text=user.status
        Picasso.get()
            .load(user.thumbImage)
            .placeholder(R.drawable.defaultavatar)
            .error(R.drawable.defaultavatar)
            .into(userimg)
    }
}