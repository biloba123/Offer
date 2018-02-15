package com.lvqingyang.offer


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class MyFragment : Fragment() {

    companion object {
        fun newInstance(): MyFragment {
            val fragment = MyFragment()
            val args = Bundle()

            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onCreate: ")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
     if (BuildConfig.DEBUG) Log.d("MyFragment", "onCreateView: ")
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_my, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        if (BuildConfig.DEBUG) Log.d("MyFragment", "onDetach: ")
    }

}// Required empty public constructor
