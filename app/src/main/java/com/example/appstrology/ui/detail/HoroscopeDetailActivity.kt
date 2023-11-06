package com.example.appstrology.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.appstrology.R
import com.example.appstrology.databinding.ActivityHoroscopeDetailBinding
import com.example.appstrology.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect() {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)


                    }


                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
        when (state.horoscopeModel) {
            HoroscopeModel.Aries -> binding.ivDetail.setImageResource(R.drawable.aries_sign)
            HoroscopeModel.Taurus -> binding.ivDetail.setImageResource(R.drawable.taurus_sign)
            HoroscopeModel.Gemini -> binding.ivDetail.setImageResource(R.drawable.gemini_sign)
            HoroscopeModel.Cancer -> binding.ivDetail.setImageResource(R.drawable.cancer_sign)
            HoroscopeModel.Leo -> binding.ivDetail.setImageResource(R.drawable.leo_sign)
            HoroscopeModel.Virgo -> binding.ivDetail.setImageResource(R.drawable.virgo_sign)
            HoroscopeModel.Libra -> binding.ivDetail.setImageResource(R.drawable.libra_sign)
            HoroscopeModel.Scorpio -> binding.ivDetail.setImageResource(R.drawable.scorpio_sign)
            HoroscopeModel.Sagittarius -> binding.ivDetail.setImageResource(R.drawable.sagittarius_sign)
            HoroscopeModel.Capricorn -> binding.ivDetail.setImageResource(R.drawable.capricornus_sign)
            HoroscopeModel.Aquarius -> binding.ivDetail.setImageResource(R.drawable.aquarius_sign)
            HoroscopeModel.Pisces -> binding.ivDetail.setImageResource(R.drawable.pisces_sign)
        }
    }

    private fun errorState() {
        binding.pb.isVisible = false //POR AHORA LO DEJAMOS ASI
    }

    private fun loadingState() {
        binding.pb.isVisible = true //POR AHORA LO DEJAMOS ASI
    }
}