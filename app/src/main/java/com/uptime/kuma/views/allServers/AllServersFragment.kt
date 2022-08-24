package com.uptime.kuma.views.allServers

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uptime.kuma.R
import com.uptime.kuma.databinding.FragmentAllServersBinding
import com.uptime.kuma.views.adapters.MonitorItemAllServersAdapter
import com.uptime.kuma.views.main.MainFragmentDirections
import com.uptime.kuma.views.mainActivity.MainActivity
import java.util.*

class AllServersFragment : Fragment(R.layout.fragment_all_servers),
    MonitorItemAllServersAdapter.OnClickLister {
    companion object {
        lateinit var allRecycler: RecyclerView
    }

    private lateinit var itemAdapter: MonitorItemAllServersAdapter

    private lateinit var binding: FragmentAllServersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentAllServersBinding.bind(view)
        allRecycler = view.findViewById(R.id.all_server_recycler)
        itemAdapter = activity?.let { MonitorItemAllServersAdapter(it, this) }!!
        allRecycler.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        observeMonitors()
        searchViewListener()
    }

    private fun observeMonitors() {
        MainActivity.sharedViewModel.monitorCalculLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                itemAdapter.setData(it)
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        MainActivity.sharedViewModel.monitorCalculLiveData.removeObservers(viewLifecycleOwner)
    }

    //search for a monitor in monitors
    private fun searchViewListener() {
        binding.searchEditTextAllServersFragment.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val searchText = binding.searchEditTextAllServersFragment.text.toString()
                    .toLowerCase(Locale.getDefault())
                itemAdapter.filter.filter(searchText)

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }


    override fun onItemClick(position: Int) {
        val serverId = MainActivity.sharedViewModel.monitorCalcul[position].monitor_id.toString()
        val action = MainFragmentDirections.actionMainFragmentToServerFragment(serverId)
        MainActivity.navController.navigate(action)
    }


}