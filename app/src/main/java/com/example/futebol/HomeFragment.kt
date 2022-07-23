package com.example.futebol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futebol.databinding.FragmentHomeBinding
import kotlin.random.Random


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val listaJogos = mutableListOf<Jogo>()
    private var contador = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterPartida(listaJogos)
        context?.let { ctx ->
            binding.rvPartidas.layoutManager = LinearLayoutManager(ctx)
            binding.rvPartidas.adapter = adapter
        }

        binding.floatingActionButton.setOnClickListener {
            listaJogos.add(0, generateJogo())
            adapter.notifyItemInserted(0)
            binding.rvPartidas.smoothScrollBy(0,0)
        }
    }

    fun generateJogo(): Jogo {
        val timeCasa = generateTime("TimeCasa")
        val timeFora = generateTime("TimeFora")

        contador++

        return Jogo(timeCasa, timeFora)
    }

    private fun generateGol(): Gol {
        return Gol("Jogador #${Random.nextInt(1, 12)}")
    }

    private fun generateTime(prefixo: String): Time {
        val nomeTime = "$prefixo$contador"
        val qGols = Random.nextInt(0, 10)
        val listaGols = mutableListOf<Gol>()
        if (qGols > 0) {
            for (i in 0 until qGols) {
                listaGols.add(generateGol())
            }
        }
        return Time(nomeTime, listaGols.sortedBy { it.tempo }.toList())
    }

}