import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matrimony_project.activity.ProfileDetailsActivity
import com.example.matrimony_project.databinding.HomeItemProfileBinding
import com.example.matrimony_project.livedata.ProfileData

class HomeAdapter(private var profileList: List<ProfileData>) : RecyclerView.Adapter<HomeAdapter.ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = HomeItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profileList[position]
        holder.bind(profile)
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    inner class ProfileViewHolder(private val binding: HomeItemProfileBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: ProfileData) {
            binding.binding2 = profile
            binding.executePendingBindings()
            itemView.setOnClickListener{
                v ->
                val intent = Intent(v.context,ProfileDetailsActivity::class.java)
                intent.putExtra("photo",profile)
                v.context.startActivity(intent)

            }
        }
    }

    fun updateProfiles(newProfiles: List<ProfileData>) {
        profileList = newProfiles
        notifyDataSetChanged()
    }
}


