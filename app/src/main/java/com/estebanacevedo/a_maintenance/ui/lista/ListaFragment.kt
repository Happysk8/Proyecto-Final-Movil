package com.estebanacevedo.a_maintenance.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estebanacevedo.a_maintenance.Activo
import com.estebanacevedo.a_maintenance.ActivosAdapter
import com.estebanacevedo.a_maintenance.R

/**
 * A placeholder fragment containing a simple view.
 */
class ListaFragment : Fragment() {

    private lateinit var listaViewModel: ListaViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listaViewModel = ViewModelProviders.of(this).get(ListaViewModel::class.java).apply {
//            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        PageViewModel=
        val root = inflater.inflate(R.layout.fragment_lista, container, false)
//        val textView: TextView = root.findViewById(R.id.txdashboard)
//        listaViewModel.text.observe(this, Observer<String> {
//            textView.text = it
//        })
        var activo:MutableList<Activo> = ArrayList()

        activo.add(Activo("PTN1", "Pelton 1", "Turbina", "Porce1",R.drawable.pelton))
        activo.add(Activo("PTN2", "Pelton 2", "Turbina", "Porce1",R.drawable.pelton))
        activo.add(Activo("PTN3", "Pelton 3", "Turbina", "Porce1",R.drawable.pelton))
        activo.add(Activo("FCS1", "Francis 1", "Turbina", "Porce1",R.drawable.francis))
        activo.add(Activo("FCS2", "Francis 2", "Turbina", "Porce1",R.drawable.francis))
        activo.add(Activo("FCS3", "Francis 3", "Turbina", "Porce1",R.drawable.francis))

        recyclerView = root.findViewById(R.id.recycler) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)
        val activosAdapter  = ActivosAdapter(activo!!,this.context)
        recyclerView.adapter = activosAdapter
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): ListaFragment {
            return ListaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}