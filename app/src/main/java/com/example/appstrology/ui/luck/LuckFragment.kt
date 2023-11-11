package com.example.appstrology.ui.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.appstrology.R.*
import com.example.appstrology.databinding.FragmentLuckBinding
import com.example.appstrology.ui.core.OnSwipeTouchListener
import com.example.appstrology.ui.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {
    @Inject
    lateinit var randomCardProvider: RandomCardProvider

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initListeners()
        preparePrediction()
    }
    @SuppressLint("ClickableViewAccessibility") // PARA Q NO DE PROBLEMAS EN ESTE CASO
    private fun initListeners() {
        //	binding.ivRoulette.setOnClickListener{ spinRoulette() }

        binding.ivRoulette.setOnTouchListener(object: OnSwipeTouchListener(requireContext()){

            override fun onSwipeRight(){
                spinRoulette()
            }

        })
    }
     fun preparePrediction(){
        val currentLuck = randomCardProvider.getLucky()
        currentLuck?.let{ luck->
            val currentPrediction = getString(luck.text)
            binding.tvPrediction.text = currentPrediction
            binding.tvCardName.text = getString(luck.title)
            binding.ivLuckyCard.setImageResource(luck.image)
            binding.tvShare.setOnClickListener {  
                sharedResult(currentPrediction)
            }

        }
    }

    private fun sharedResult(currentPrediction: String) {
        val sendIntent: Intent = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentPrediction)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Share")
        startActivity(shareIntent)
    }

    private fun spinRoulette() {
        val random = Random()
        val degrees = random.nextInt(1440) + 360
        val animator = ObjectAnimator.ofFloat(
            binding.ivRoulette,
            View.ROTATION,
            0f,
            degrees.toFloat()
        )
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.start()
        animator.doOnEnd {
            slideCard()
        }
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), anim.slide_up)
        slideUpAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                binding.reverse.isVisible = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                growUpCard()
            }

            override fun onAnimationRepeat(p0: Animation?) {}


        })

        binding.reverse.startAnimation(slideUpAnimation)
    }

    private fun growUpCard(){
        val growUpCardAnimation = AnimationUtils.loadAnimation(requireContext(), anim.grow_up)
        growUpCardAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                disappearRoulette()
            }

            override fun onAnimationEnd(p0: Animation?) {
                // cositas
                binding.reverse.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })
        binding.reverse.startAnimation(growUpCardAnimation)
    }

    private fun disappearRoulette() {

        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 300
        disappearAnimation.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?){ }
            override fun onAnimationEnd(p0: Animation?){
                binding.ivRoulette.isVisible = false
            }
            override fun onAnimationRepeat(p0: Animation?){ }}
        )

        binding.ivRoulette.startAnimation(disappearAnimation)
    }

    private fun showPremonitionView() {

        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)

        disappearAnimation.duration = 200
         disappearAnimation.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?){}
            override fun onAnimationEnd(p0: Animation?){

                binding.preview.isVisible = false

                binding.premonition.isVisible = true}
            override fun onAnimationRepeat(p0: Animation?){ }}
        )

        binding.preview.startAnimation(disappearAnimation)
    }

}

