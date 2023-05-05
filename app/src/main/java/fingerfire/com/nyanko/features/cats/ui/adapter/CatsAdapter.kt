package fingerfire.com.nyanko.features.cats.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.nyanko.databinding.ItemCatBinding
import fingerfire.com.nyanko.features.cats.data.response.CatResponse

class CatsAdapter(
    private var catList: List<CatResponse> = emptyList()
) : RecyclerView.Adapter<CatsAdapter.CatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemCatBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        with(holder) {
            with(catList[position]) {
                binding.item.load(url)
            }
        }
    }

    override fun getItemCount(): Int {
        return catList.size
    }

    fun updateList(cats: List<CatResponse>) {
        this.catList = cats
        notifyDataSetChanged()
    }

    class CatViewHolder(val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root)

}