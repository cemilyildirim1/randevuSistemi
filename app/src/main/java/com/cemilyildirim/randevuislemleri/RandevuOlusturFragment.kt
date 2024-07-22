package com.cemilyildirim.randevuislemleri

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cemilyildirim.randevuislemleri.adapter.RandevuAdapter
import com.cemilyildirim.randevuislemleri.databinding.FragmentRandevuOlusturBinding
import com.cemilyildirim.randevuislemleri.repoPattern.VeriCekme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RandevuOlusturFragment : Fragment() {
    private var _binding: FragmentRandevuOlusturBinding? = null
    private val binding get() = _binding!!


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
        binding.randevuOlusturButton.isEnabled = false
        binding.randevuOlusturRecyclerView.layoutManager = LinearLayoutManager(context)
        val veriCekme = VeriCekme()

        CoroutineScope(Dispatchers.Main).launch{
            val response = withContext(Dispatchers.IO){veriCekme.veriCekme()}
            val resultObject = response.result.resultObject
            binding.randevuOlusturRecyclerView.adapter = RandevuAdapter(resultObject)
        }




//        val deneme = OkHttpClient.Builder()
//
//            .readTimeout(60, TimeUnit.SECONDS)
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .writeTimeout(60, TimeUnit.SECONDS)
//            .build()
////            .retryOnConnection
//
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://raw.githubusercontent.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(deneme as OkHttpClient)
//            .build()
//            .create(DataAPI::class.java)
//
//        //hilt retrofit tutorial
//        //view model implementation
//
//        CoroutineScope(Dispatchers.IO).launch(){
//            val veriler = retrofit.getData()
//            println(veriler.result)
//            binding.textView.setText(veriler.errorCode.toString())
//        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}