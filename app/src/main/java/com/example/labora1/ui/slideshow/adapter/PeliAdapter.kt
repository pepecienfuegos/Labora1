package com.example.labora1.ui.slideshow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labora1.R
import com.example.labora1.databinding.EstrenoItemBinding
import com.example.labora1.ui.clases.Peli

class PeliAdapter(
    val datos: ArrayList<Peli>,
    val onItemListener: OnItemListener
) : RecyclerView.Adapter<PeliAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = EstrenoItemBinding.inflate(layoutInflater)
        val binding = EstrenoItemBinding.inflate(layoutInflater)
        return ViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: PeliAdapter.ViewHolder, position: Int) {
        holder.bindData(datos[position])
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    interface OnItemListener {
        fun onItemClick(peli: Peli)
    }
    class ViewHolder(binding: EstrenoItemBinding , onItemListener: OnItemListener) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        private val binding = binding
        private val onItemListener = onItemListener
        private lateinit var peli: Peli

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemListener.onItemClick(peli)
        }

        fun bindData(item: Peli) {
            with(binding) {
                tvName.text = item.nombre
                tvgenero.text = item.genero
                when (item.poster){
                    "likemike_post" -> {
                        ivEstreno.setImageResource(R.drawable.likemike_post)
                    }
                    "spacejam_post"->{
                        ivEstreno.setImageResource(R.drawable.spacejam_post)
                    }
                    "thunderstruck_post"->{
                        ivEstreno.setImageResource(R.drawable.thunderstruck_post)
                    }
                    "coachcarter_post"->{
                        ivEstreno.setImageResource(R.drawable.coachcarter_post)
                    }
                }

            }
            peli = item
        }
    }
}