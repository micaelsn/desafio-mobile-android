package com.marvel.app.presentation.presenters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.marvel.app.R
import com.marvel.app.databinding.FragmentCarouselBinding
import com.marvel.app.presentation.controllers.MainActivityController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CharactersCarousel : Fragment() {

    private var _binding: FragmentCarouselBinding? = null
    private val controller = MainActivityController()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        controller.getCarouselCharacters()
        _binding = FragmentCarouselBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}