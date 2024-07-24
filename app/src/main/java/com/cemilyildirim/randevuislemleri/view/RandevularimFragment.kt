package com.cemilyildirim.randevuislemleri.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cemilyildirim.randevuislemleri.databinding.FragmentRandevularimBinding
import android.view.MotionEvent
import android.view.PointerIcon
import androidx.fragment.app.Fragment

class RandevularimFragment : Fragment() {
    private var _binding: FragmentRandevularimBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandevularimBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.randevuOlusturButton.setOnClickListener{
            toRandevuOlustur(it)
        }
        binding.randevularimButton.setOnHoverListener(){ v , event ->
            when(event.action){
                MotionEvent.ACTION_HOVER_ENTER -> {
                    v.pointerIcon = PointerIcon.getSystemIcon(requireContext(), PointerIcon.TYPE_HAND)
                }
                MotionEvent.ACTION_HOVER_EXIT -> {
                    v.pointerIcon = PointerIcon.getSystemIcon(requireContext(), PointerIcon.TYPE_ARROW)
                }
            }
            false
        }

    }
    fun toRandevuOlustur(view: View) {
        val action = RandevularimFragmentDirections.actionRandevularimFragmentToRandevuOlusturFragment()
        Navigation.findNavController(view).navigate(action)
    }

}