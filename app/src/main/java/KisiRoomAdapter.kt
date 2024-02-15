import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egitim.softverseeducation.databinding.KisiKartRoomBinding
import demo_db.User

class KisiRoomAdapter: RecyclerView.Adapter<KisiRoomAdapter.KisiRoomViewHolder>(){

    private var kisiList: ArrayList<User> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): KisiRoomAdapter.KisiRoomViewHolder {
        val binding = KisiKartRoomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return KisiRoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KisiRoomAdapter.KisiRoomViewHolder, position: Int) {
        holder.degerleriBas(kisiList[position])
    }

    override fun getItemCount(): Int = kisiList.size
    inner class KisiRoomViewHolder(val binding: KisiKartRoomBinding) : RecyclerView.ViewHolder(binding.root){

        fun degerleriBas(kisi: User){
            binding.tvKisiID.text = kisi.uid.toString()
            binding.tvIsim.text = kisi.firstName
            binding.tvSoyisim.text = kisi.lastName
        }


    }
    fun setKisiList(kisiList: ArrayList<User>){
        this.kisiList = kisiList
        notifyDataSetChanged()
    }

}

