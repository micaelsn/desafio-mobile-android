package com.marvel.app.presentation.presenters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.marvel.app.R
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.app.databinding.FragmentHomeBinding
import com.marvel.app.presentation.controllers.MainActivityController
import com.marvel.app.presentation.presenters.adapters.HomeAdapter
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Home : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val controller = MainActivityController()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext()
        init()
    }

   private fun init(){
        CoroutineScope(Dispatchers.IO).launch {
            val requestCarousel = async {
                controller.getCarouselCharacters()
            }
            requestCarousel.await()
            val requestList = async {
                controller.getListCharacters()
            }
            requestList.await()
        }

        setFragment()
    }

    private fun setFragment(){
        binding.recyclerHome.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )

        binding.recyclerHome.adapter = HomeAdapter(controller.homeState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}