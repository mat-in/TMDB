package com.example.tmdb.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.view.MyAdapter
import com.example.tmdb.viewmodel.MovieViewModel
import kotlinx.coroutines.launch

class TopRatedFragment : Fragment() {
    var movieViewModel = MovieViewModel()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top_rated, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        var myAdapter = MyAdapter(arrayListOf())

        lifecycleScope.launch {
            recyclerView.adapter = myAdapter

            movieViewModel.movieLiveData.observe(viewLifecycleOwner) {movies ->
                myAdapter.itemsList.clear()
                myAdapter.itemsList.addAll(movies)
                myAdapter.notifyDataSetChanged()
            }

            movieViewModel.errorLiveData.observe(viewLifecycleOwner) {error ->
                Log.v("Err: ", error)
            }

            movieViewModel.getTopRated()
        }


        return view
    }
}