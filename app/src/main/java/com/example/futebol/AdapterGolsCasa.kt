package com.example.futebol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futebol.databinding.GolsCasaLayoutBinding

class AdapterGolsCasa(private val gols: List<Gol>): RecyclerView.Adapter<AdapterGolsCasa.ViewHolder>() {

    inner class ViewHolder(private val binding: GolsCasaLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(gol: Gol) {
            binding.linhaGol.text = "${gol.jogador} ${gol.tempo}'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GolsCasaLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(gols[position])
    }

    override fun getItemCount(): Int {
        return gols.size
    }

}