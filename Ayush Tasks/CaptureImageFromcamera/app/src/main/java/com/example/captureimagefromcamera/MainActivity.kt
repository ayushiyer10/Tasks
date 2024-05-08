package com.example.captureimagefromcamera

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var imageview: ImageView
    private lateinit var btnChange: Button
    private lateinit var btnCamera: Button
    private val CAMERA_REQUEST_CODE = 101



    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                showToast("Permission granted!")
                launchGallery()
            } else {
                showToast("Permission denied!")
            }
        }
    private val cameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            showToast("Camera Permission granted!")
            launchCamera()
        } else {
            showToast("Camera Permission denied!")
        }
    }


    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageview.setImageURI(null)
        imageview.setImageURI(uri)
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imageview = findViewById(R.id.imageview)
        btnChange = findViewById(R.id.btnChange)
        btnCamera = findViewById(R.id.btnCamera)


        btnChange.setOnClickListener {
            if (checkPermissions()) {
                launchGallery()
            } else {
                requestPermissions()
            }
        }

        btnCamera.setOnClickListener {
            if (checkCameraPermissions()) {
                launchCamera()
            } else {
                requestCameraPermissions()
            }
        }

    }

    private fun checkCameraPermissions(): Boolean {
        return (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED)
    }


    private fun checkPermissions(): Boolean {
        return (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermissions() {
        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    private fun launchGallery() {
        contract.launch("image/*")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun launchCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        } else {
            showToast("Camera Not Available")
        }
        }
    private fun requestCameraPermissions() {
        cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
    }


}

