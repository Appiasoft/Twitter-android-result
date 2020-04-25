package com.appiadev.twitteranalytics.ui.main.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.chart.common.listener.Event
import com.anychart.chart.common.listener.ListenersInterface
import com.anychart.enums.Align
import com.anychart.enums.LegendLayout

import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.ui.main.model.Data
import com.twovehiculo.android.helpers.FirestoreViewModel
import kotlinx.android.synthetic.main.fragment_devices.*

/**
 * A simple [Fragment] subclass.
 */
class DevicesFragment : Fragment() {
    private lateinit var viewModel: FirestoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirestoreViewModel::class.java)
        val pie = AnyChart.pie()

        pie.setOnClickListener(object :
            ListenersInterface.OnClickListener(arrayOf("x", "value")) {
            override fun onClick(event: Event) {
                Toast.makeText(
                    context,
                    event.data["x"].toString() + ":" + event.data["value"],
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        val dataKpi2: MutableList<DataEntry> = ArrayList()
        viewModel.getTweetsDevices().observeForever {
            for(dataModel: Data in it){
                dataKpi2.add(ValueDataEntry(dataModel.name,dataModel.total))
            }

            pie.data(dataKpi2)

            pie.title("Dispositivos mas usados")

            pie.labels().position("outside")

            pie.legend().title().enabled(true)
            pie.legend().title()
                .text("Retail channels")
                .padding(0.0, 0.0, 10.0, 0.0)

            pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER)

            any_chart_view_kpi2.setProgressBar(view.findViewById(R.id.progress_bar))
            any_chart_view_kpi2.setChart(pie)
        }

    }

}
