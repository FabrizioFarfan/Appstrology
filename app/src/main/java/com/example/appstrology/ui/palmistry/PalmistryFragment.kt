package com.example.appstrology.ui.palmistry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.example.appstrology.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGaranted->
        if(isGaranted){
            startCamera()
        }else{
            //SI PROPRIO RECHAZA EL PERMISO LE MANDAMOS UN TOAST CON UN MENSAJE
            Toast.makeText(requireContext(),"ACEPTAAA",Toast.LENGTH_LONG).show()
        }
    }

    companion object{
        const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(checkCameraPermission()){
            startCamera()
        }else{
            //Pedimos permiso
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }
    }

    private fun checkCameraPermission():Boolean{

        return PermissionChecker.checkSelfPermission(
            requireContext(), CAMERA_PERMISSION
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    private fun startCamera(){
        // Creamos un objeto ProcessCameraProvider Q NOS PERMITE Q EL CICLO DE VIDA
        // SE ENGANCHE AL cameraProvider ASI CUANDO SE MUERE EL FRAGMENT ESTO TMB
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also{ //NUESTRO PREVIEW NECESITA ESTE SURFACEPROVIDER PARA FUNCIONAR
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }
            // AQI PONEMOS Q POR DEFECTO USE LA CAMARA DE ATRAS
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            //AQI VIENE LA PARTE DELICADA Q METEMOS EN UN try/catch

            try{
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            }catch(e:Exception){
                Log.e("Fabri","Paso eto ${e.message}")
            }
        }, ContextCompat.getMainExecutor(requireContext())	)
    }
}

