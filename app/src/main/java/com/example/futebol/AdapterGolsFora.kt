package com.example.futebol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futebol.databinding.GolsForaLayoutBinding

class AdapterGolsFora(private val gols: List<Gol>): RecyclerView.Adapter<AdapterGolsFora.ViewHolder>() {

    inner class ViewHolder(private val binding: GolsForaLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(gol: Gol) {
            binding.linhaGol.text = "${gol.tempo}' ${gol.jogador}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GolsForaLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(gols[position])
    }

    override fun getItemCount(): Int {
        return gols.size
    }

}