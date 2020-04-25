package com.appiadev.twitteranalytics.ui.main.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.core.cartesian.series.Column
import com.anychart.enums.Anchor
import com.anychart.enums.HoverMode
import com.anychart.enums.Position
import com.anychart.enums.TooltipPositionMode

import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.ui.main.model.Data
import com.twovehiculo.android.helpers.FirestoreViewModel
import kotlinx.android.synthetic.main.fragment_locations.*

/**
 * A simple [Fragment] subclass.
 */
class LocationsFragment : Fragment() {

    private lateinit var viewModel: FirestoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_locations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirestoreViewModel::class.java)

        any_chart_view_kpi1.setProgressBar(view.findViewById(R.id.progress_bar))

        //KPI - 1
        val cartesian: Cartesian = AnyChart.column()
        val data: MutableList<DataEntry> = ArrayList()
        var column: Column? = null
        viewModel.getTweetsLocation().observeForever {
            for(dataModel: Data in it){
                data.add(ValueDataEntry(dataModel.name,dataModel.total))
            }
            column = cartesian.column(data)

            column!!.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0.0)
                .offsetY(5.0)
                .format("\${%Value}{groupsSeparator: }")

            cartesian.animation(true)
            cartesian.title("Top de ubicaciones")

            cartesian.yScale().minimum(0.0)

            cartesian.yAxis(0).labels().format("\${%Value}{groupsSeparator: }")

            cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
            cartesian.interactivity().hoverMode(HoverMode.BY_X)

            cartesian.xAxis(0).title("Localizacion")
            cartesian.yAxis(0).title("Repeticiones")


            any_chart_view_kpi1.setChart(cartesian)
        }

    }

}
