package com.example.labora1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.labora1.databinding.FragmentTrailerBinding
import com.example.labora1.ui.clases.Peli

class TrailerFragment : Fragment() {
    lateinit var binding: FragmentTrailerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrailerBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tmp = arguments?.getSerializable("peli") as Peli
        binding.tvNombre.text = tmp.nombre
        binding.tvGenero.text = tmp.genero
        binding.tvLanzamiento.text = tmp.estreno
        binding.tvSipnosis.text = tmp.sipnosis

        when (tmp.poster) {
            "posterjurassicworld" -> {
                binding.ivPoster.setImageResource(R.drawable.likemike_post)
                binding.ivBaner.setImageResource(R.drawable.banner)
                binding.vvTrailer.setVideoPath("android.resource://"+activity?.getPackageName()+"/"+R.raw.likemike_vid)
            }
            "posterspidy"->{
                binding.ivPoster.setImageResource(R.drawable.spacejam_post)
                binding.ivBaner.setImageResource(R.drawable.banner)
                binding.vvTrailer.setVideoPath("android.resource://"+activity?.getPackageName()+"/"+R.raw.spacejam_vid)
            }
            "posterstrange"->{
                binding.ivPoster.setImageResource(R.drawable.thunderstruck_post)
                binding.ivBaner.setImageResource(R.drawable.banner)
                binding.vvTrailer.setVideoPath("android.resource://"+activity?.getPackageName()+"/"+R.raw.thunderstruck_vid)
            }
            "posteranimales"->{
                binding.ivPoster.setImageResource(R.drawable.coachcarter_post)
                binding.ivBaner.setImageResource(R.drawable.banner)
                binding.vvTrailer.setVideoPath("android.resource://"+activity?.getPackageName()+"/"+R.raw.coachcarter_vid)
            }
        }
        val mc: MediaController = MediaController(requireContext())
        mc.setAnchorView(binding.vvTrailer)
        binding.vvTrailer.setMediaController(mc)
    }


}
