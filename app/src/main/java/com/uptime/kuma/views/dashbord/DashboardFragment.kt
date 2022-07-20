package com.uptime.kuma.views.dashbord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.uptime.kuma.Adapters.DashbordRecyclerAdapter
import com.uptime.kuma.R
import com.uptime.kuma.databinding.FragmentDashboardBinding
import com.uptime.kuma.models.DashbordItems


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentDashboardBinding.bind(view)

        val dashbordRecyclerAdapter = DashbordRecyclerAdapter(requireContext())
        binding.apply {
        dashbordRecycler.apply {
            adapter=dashbordRecyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            dashbordRecyclerAdapter?.submitList(getData())
        }
        }
    }
    private fun getData():List<DashbordItems>{
        val data = arrayListOf<DashbordItems>()
        data.add(DashbordItems(1,"Inwi",true,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
        data.add(DashbordItems(2,"Orange",false,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(3,"Wana",true,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(4,"Miditel",true,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(5,"MarocTelecom",false,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(6,"2M",false,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(7,"Mobiblanc",true,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(8,"MobiblancVPN",false,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(9,"Test404",false,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        data.add(DashbordItems(10,"ValarMorghulis",true,"2022-07-20 02:07:49","connect EHOSTUNREACH 41.214.190.232:9090"))
        return data
    }
}