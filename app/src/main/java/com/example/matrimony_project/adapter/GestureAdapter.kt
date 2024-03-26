package com.example.matrimony_project.adapter

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.matrimony_project.R
import com.example.matrimony_project.databinding.GestureProfileBinding
//import com.example.matrimony_project.livedata.GestureProfile


/*class GestureAdapter(private var gestureprofile: List<GestureProfile>) : RecyclerView.Adapter<GestureAdapter.GestureViewHolder>()
   {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): GestureViewHolder {

        val binding = GestureProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GestureViewHolder(binding)
        }

    override fun onBindViewHolder(holder: GestureViewHolder, position: Int) {
        holder.bind(gestureprofile[position])

    }
      override  fun getItemCount(): Int {
            return gestureprofile.size
        }

    fun updateList(profiles: List<GestureProfile>) {
            gestureprofile = profiles
            notifyDataSetChanged()
    }


    class GestureViewHolder(private val binding: GestureProfileBinding): RecyclerView.ViewHolder(binding.root) {
        private val image: ImageView = itemView.findViewById(R.id.overflowIcon)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvAge: TextView = itemView.findViewById(R.id.tvAge)
        private val tvOccupation: TextView = itemView.findViewById(R.id.tvOccupation)

        fun bind(profile: GestureProfile) {
            image.setImageResource(profile.image)
            tvName.text = profile.name
            tvAge.text = profile.age.toString()
            tvOccupation.text = profile.occupation
            binding.executePendingBindings()

        }*/

/*
class GestureAdapter(private var gestureprofile: List<GestureProfile>) : Adapter{
    override fun registerDataSetObserver(p0: DataSetObserver?) {

    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {

    }

    override fun getCount(): Int {
       return gestureprofile.size
    }

    override fun getItem(p0: Int): Any {
        return gestureprofile[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_profile, parent, false)
        // Here, your_item_layout should be the layout file for each item in the StackView
        // Bind data to your views here based on the position
        val item = gestureprofile[position]
        val imageView: ImageView = view.findViewById(R.id.overflowIcon)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAge: TextView = view.findViewById(R.id.tvAge)
        val tvOccupation: TextView = view.findViewById(R.id.tvOccupation)

        imageView.setImageResource(item.image)
        tvName.text = item.name
        tvAge.text = item.age.toString()
        tvOccupation.text = item.occupation

        return view
    }

    override fun getItemViewType(p0: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
       return 1
    }

    override fun isEmpty(): Boolean {
        return gestureprofile.isEmpty()
    }

    fun updateProfiles(newProfiles: List<GestureProfile>) {
        gestureprofile = newProfiles
    }
}
*/
