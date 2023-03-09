import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.latifah.machinelearningwithmlkitandobjectrecognition.databinding.BarChartBinding
import okhttp3.internal.Util


class BarChartFragment : Fragment() {
//    private var chart: BarChart? = null
//    private var _binding: BarChartBinding? = null
//    private val binding get() = _binding!!
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = BarChartBinding.inflate(inflater)
////            chart = binding.fragmentHorizontalbarchartChart
//        setBarGraph()
//
//        return binding.root
//    }
//
//    private fun setBarGraph() {
//        //This is where we add the label from the view holder
//        val xValues = ArrayList<String>()
//        xValues.add("selfie")
//        xValues.add("cool")
//        xValues.add("glasses")
//
//
//    }
//    private fun configureChartAppearance() {
//        chart!!.description.isEnabled = false
//        chart!!.setDrawValueAboveBar(false)
//        val xAxis = chart!!.xAxis
//        xAxis.valueFormatter = object : ValueFormatter() {
//            override fun getFormattedValue(value: Float): String {
//                return DAYS[value.toInt()]
//            }
//        }
//        val axisLeft = chart!!.axisLeft
//        axisLeft.granularity = 10f
//        axisLeft.axisMinimum = 0f
//        val axisRight = chart!!.axisRight
//        axisRight.granularity = 10f
//        axisRight.axisMinimum = 0f
//    }

//    private fun createChartData(): BarData? {
//        val values: ArrayList<BarEntry> = ArrayList()
////        for (i in 0 until MAX_X_VALUE) {
////            val x = i.toFloat()
////            val y: Float = Util().randomFloatBetween(MIN_Y_VALUE, MAX_Y_VALUE)
////            values.add(BarEntry(x, y))
////        }
//        val set1 = BarDataSet(values, SET_LABEL)
//        val dataSets: ArrayList<IBarDataSet> = ArrayList()
//        dataSets.add(set1)
//        return BarData(dataSets)
//    }
//
//
//    companion object {
//        private const val MAX_X_VALUE = 7
//        private const val MAX_Y_VALUE = 50
//        private const val MIN_Y_VALUE = 5
//        private const val SET_LABEL = "App Downloads"
//        private val DAYS = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
//    }
}