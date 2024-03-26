import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matrimony_project.R
import com.example.matrimony_project.databinding.HomeItemProfileBinding
import com.example.matrimony_project.databinding.ProfilephotoBinding
import com.example.matrimony_project.livedata.ProfileData
import java.util.ArrayList

class ProfilePhotoAdapter(private var relatedImages: List<Int>?) :
    RecyclerView.Adapter<ProfilePhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ProfilephotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val imageResId = relatedImages?.get(position)
        holder.bind(imageResId)
    }

    override fun getItemCount(): Int = relatedImages?.size ?: 0


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(images: List<Int>?) {
        relatedImages = images
        notifyDataSetChanged()
    }


    class PhotoViewHolder(private val binding: ProfilephotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(imageResId: Int?) {
            imageResId?.let {
                Glide.with(itemView.context)
                    .load(it)
                    .into(binding.overflowIcon)
            }
           /* imageResId?.let { binding.overflowIcon.setImageResource(it) }*/
            binding.executePendingBindings()



            /*imageResId?.let {
                Glide.with(itemView.context)
                    .load(it)
                    .into(imageView)
            }*/
            // Load image using imageResId (e.g., using Glide or setImageResource)
            //imageView.setImageResource(imageResId)
        }
    }
}
