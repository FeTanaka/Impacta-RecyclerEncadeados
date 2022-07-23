package com.example.futebol

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.futebol.databinding.PartidaLayoutBinding

class AdapterPartida(private val listaPartidas: List<Jogo>): RecyclerView.Adapter<AdapterPartida.ViewHolder>() {

    inner class ViewHolder(private val context: Context ,private val binding: PartidaLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(partida: Jogo) {
            binding.casaTextView.text = partida.timeCasa.nome
            binding.foraTextView.text = partida.timeFora.nome
            binding.placarTextView.text = "${partida.timeCasa.listaGol.size} x ${partida.timeFora.listaGol.size}"
            binding.rvGolsCasa.layoutManager = LinearLayoutManager(context)
            binding.rvGolsCasa.adapter = AdapterGolsCasa(partida.timeCasa.listaGol)
            binding.rvGolsFora.layoutManager = LinearLayoutManager(context)
            binding.rvGolsFora.adapter = AdapterGolsFora(partida.timeFora.listaGol)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PartidaLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(listaPartidas[position])
    }

    override fun getItemCount(): Int {
        return listaPartidas.size
    }
}