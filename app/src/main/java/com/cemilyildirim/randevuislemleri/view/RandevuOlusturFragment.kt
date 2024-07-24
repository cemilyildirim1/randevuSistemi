package com.cemilyildirim.randevuislemleri.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.PointerIcon
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.cemilyildirim.randevuislemleri.adapter.RandevuAdapter
import com.cemilyildirim.randevuislemleri.databinding.FragmentRandevuOlusturBinding
import com.cemilyildirim.randevuislemleri.di.NetworkModule
import com.cemilyildirim.randevuislemleri.repoPattern.VeriCekme
import com.cemilyildirim.randevuislemleri.view.service.DataAPI
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class RandevuOlusturFragment : Fragment() {
    private var _binding: FragmentRandevuOlusturBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var veriCekme: VeriCekme


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandevuOlusturBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randevuOlusturRecyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch{
            val data = veriCekme.veriCekme()
            val resultObject = data.result.resultObject
            binding.randevuOlusturRecyclerView.adapter = RandevuAdapter(resultObject)

        }


        binding.randevularimButton.setOnClickListener{
            toRandevularim(it)
        }

        binding.randevularimButton.setOnHoverListener{ v : View , event : MotionEvent ->
            when(event.action){
                MotionEvent.ACTION_HOVER_ENTER -> {
                    v.pointerIcon = PointerIcon.getSystemIcon(requireContext(), PointerIcon.TYPE_HAND)
                    true
                }
                MotionEvent.ACTION_HOVER_EXIT -> {
                    v.pointerIcon = PointerIcon.getSystemIcon(requireContext(), PointerIcon.TYPE_ARROW)
                    true
                }
                else ->false
            }
        }

        }
    fun toRandevularim(view : View){
        val action = RandevuOlusturFragmentDirections.actionRandevuOlusturFragmentToRandevularimFragment()
        Navigation.findNavController(view).navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}