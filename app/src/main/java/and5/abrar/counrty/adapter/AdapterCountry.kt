package and5.abrar.counrty.adapter

import and5.abrar.counrty.R
import and5.abrar.counrty.model.GetCountryItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country.view.*

class AdapterCountry(private  val listdatacountry : List<GetCountryItem>):RecyclerView.Adapter<AdapterCountry.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.namaNegara.text = listdatacountry[position].name
        Glide.with(holder.itemView.context)
            .load(listdatacountry[position].flags.png)
            .into(holder.itemView.gambarNegara)
        holder.itemView.timezone.text = "waktu : " + listdatacountry[position].timezones.toString()
        holder.itemView.populasi.text = "populasi : " + listdatacountry[position].population.toString()
    }

    override fun getItemCount(): Int {
        return listdatacountry.size
    }
}