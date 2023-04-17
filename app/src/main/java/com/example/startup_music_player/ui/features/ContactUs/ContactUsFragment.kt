package com.example.startup_music_player.ui.features.ContactUs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentContactUsBinding
import com.example.startup_music_player.model.Adapter.TicketTitleAdapter
import com.example.startup_music_player.model.Contract.ContractTitleTicket
import com.example.startup_music_player.model.InteFaces.OnClickConteactUs
import com.example.startup_music_player.model.InteFaces.OnClickTicketTitle
import com.example.startup_music_player.model.data.TitleTicket
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresnterTitleTicket
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker

class ContactUsFragment : Fragment() , OnClickTicketTitle  , ContractTitleTicket.View{
    lateinit var binding:FragmentContactUsBinding
    lateinit var presenter: ContractTitleTicket.PresenterTitle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContactUsBinding.inflate(layoutInflater , container , false)
        presenter = PresnterTitleTicket(
            createApiService(),
            NetworkChecker(binding.root.context).isInternetConnected
        )
        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@ContactUsFragment)
        }
        return binding.root
    }


    override fun titleTicket(ticket: List<TitleTicket>) {
        val adapter = TicketTitleAdapter(ticket , this)
        binding.recTitleTicket.layoutManager = GridLayoutManager(context ,1 , RecyclerView.VERTICAL , false)
        binding.recTitleTicket.adapter = adapter
    }

    private fun transform (fragment: Fragment) {
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.commit()
    }

    override fun onClickTicketTitle(data: TitleTicket) {
        MyApp.idTicket = data.id.toString()
        transform(ContactUsDetailFragment())
        Log.v("itemClicked" , data.title)

    }
    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, ProfileFragment())
        transform.commit()
    }

}