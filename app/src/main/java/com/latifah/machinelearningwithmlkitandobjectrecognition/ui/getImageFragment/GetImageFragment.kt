package com.latifah.machinelearningwithmlkitandobjectrecognition.ui.getImageFragment

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import com.latifah.machinelearningwithmlkitandobjectrecognition.data.model.Label
import com.latifah.machinelearningwithmlkitandobjectrecognition.databinding.GetImageBinding
import kotlin.math.roundToInt


/*
* STEP 3: SETUP FRAGMENT
* STEP 4: CREATE THE TAKE PICTURE INTENT*/
const val TAG = "GET IMAGE FRAGMENT"

class GetImageFragment : Fragment() {
    private var _binding: GetImageBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageBitmap : Bitmap

    private lateinit var barChart: BarChart

    private var labels = ArrayList<Label>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GetImageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLaunchCamera.setOnClickListener{
            Log.i("button", "onViewCreated: the camera was launched")
            dispatchTakePictureIntent()
        }

//        barChart = binding.barChart

//        labels = getLabels()

        Log.i(TAG, "onViewCreate $labels")
//        initBarChart()
//
//
//        //now draw bar chart with dynamic data
//        val entries: ArrayList<BarEntry> = ArrayList()
//
//        //you can replace this data object with  your custom object
//        for (label in labels.indices) {
//            val confidence = labels[label].confidence
////            entries.add(BarEntry(confidence, confidence))
//            return confidence
//        }
//
//        val barDataSet = BarDataSet(entries, "")
//        barDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
//
//        val data = BarData(barDataSet)
//        barChart.data = data
//
//        barChart.invalidate()
    }



    //New way of using onActivityResult the camera https://stackoverflow.com/questions/62671106/onactivityresult-method-is-deprecated-what-is-the-alternative
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result -> //This launches the camera
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            imageBitmap = data!!.extras!!.get("data") as Bitmap
            imageLabeling(imageBitmap)

            Log.d("RESULT LAUNCHER METHOD", "Setting Image $data" )
//            binding.ivCameraImage.setImageBitmap(imageBitmap)
        }
    }

    private fun dispatchTakePictureIntent() { //This gets the image from the camera app
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(takePictureIntent)
    }

    private fun imageLabeling(imageFromBitmap: Bitmap) {
        val labeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS) //use the on-device image labeler
        val image = InputImage.fromBitmap(imageFromBitmap, 0)
        var labelText = ""
        binding.ivCameraImage.setImageBitmap(imageFromBitmap)
        labeler.process(image) //pass the image to the process method
            .addOnSuccessListener { labels ->
                for (label in labels) {
                    val text = label.text
                    val confidence = label.confidence
                    labelText += "$text : ${(confidence * 100).roundToInt()}%\n"

                    Log.i(TAG, "label text: $labelText")
                    binding.textLabel.text = labelText
                }
            }
            .addOnFailureListener { e ->
                Log.e(TAG, "imageLabeling: There was an error labeling the image: $e", )
            }

    }


    private fun initBarChart() {


//        hide grid lines
        barChart.axisLeft.setDrawGridLines(false)
        val xAxis: XAxis = barChart.xAxis
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)

        //remove right y-axis
        barChart.axisRight.isEnabled = false

        //remove legend
        barChart.legend.isEnabled = false


        //remove description label
        barChart.description.isEnabled = true


        //add animation
        barChart.animateY(3000)

        // to draw label on xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        xAxis.valueFormatter = MyAxisFormatter()
        xAxis.setDrawLabels(true)
        xAxis.granularity = 1f
        xAxis.labelRotationAngle = +90f

    }

    inner class MyAxisFormatter : IndexAxisValueFormatter() {

        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            val index = value.toInt()
//            Log.d(TAG, "getAxisLabel!!!!: index $index")
            return if (index < labels.size) {
                labels[index].label
            } else {
                ""
            }
        }
    }

    private fun getLabels(): ArrayList<Label> {
        labels.add(Label("Smile", 40.5f))
        labels.add(Label("Glasses", 75.4f))
        labels.add(Label("Dog", 85.8f))
        labels.add(Label("Cool", 5.8f))
        labels.add(Label("Room", 8.8f))
        return labels
    }


}