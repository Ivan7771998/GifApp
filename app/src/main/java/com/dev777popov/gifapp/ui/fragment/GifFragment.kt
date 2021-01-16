package com.dev777popov.gifapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev777popov.gifapp.R
import com.dev777popov.gifapp.adapter.AdapterGifsList
import com.dev777popov.gifapp.vm.VmGifFragment
import kotlinx.android.synthetic.main.fragment_gif.*

class GifFragment : Fragment() {

    private var vmGifFragment: VmGifFragment? = null
    private var adapterGifsList: AdapterGifsList? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gif, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmGifFragment = ViewModelProvider(this).get(VmGifFragment::class.java)
        initList()
        initHeader()
    }

    private fun initHeader() {
        btn_search.setOnClickListener {
            if (!text_input_gif.text.isNullOrEmpty())
                reqGif(text_input_gif.text.toString())
            else
                Toast.makeText(
                    requireContext(),
                    "Поле поиска пустое! Введите запрос!",
                    Toast.LENGTH_SHORT
                ).show()
        }
        reqGif("Android kotlin")
    }

    private fun initList() {
        list_gif.layoutManager =
            GridLayoutManager(requireContext(), 2)

    }

    private fun reqGif(search: String) {
        vmGifFragment?.getListData(search)?.observe(viewLifecycleOwner, Observer {
            adapterGifsList = AdapterGifsList(it.data)
            list_gif.adapter = adapterGifsList
        })
    }

    companion object {
        fun newInstance() = GifFragment()
    }
}