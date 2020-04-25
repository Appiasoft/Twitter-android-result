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
import kotlinx.android.synthetic.main.fragment_hashtags.*

/**
 * A simple [Fragment] subclass.
 */
class HashtagsFragment : Fragment() {

    private lateinit var viewModel: FirestoreViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hashtags, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirestoreViewModel::class.java)
        val cartesian_kpi3: Cartesian = AnyChart.column()
        val data_kpi3: MutableList<DataEntry> = ArrayList()
        var column_kpi3: Column
        viewModel.getTweetsHashtags().observeForever {
            for (dataModel: Data in it) {
                data_kpi3.add(ValueDataEntry(dataModel.name, dataModel.total))
            }
            column_kpi3 = cartesian_kpi3.column(data_kpi3)

            column_kpi3.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0.0)
                .offsetY(5.0)
                .format("\${%Value}{groupsSeparator: }")

            cartesian_kpi3.animation(true)
            cartesian_kpi3.title("Top de Hashtags")

            cartesian_kpi3.yScale().minimum(0.0)

            cartesian_kpi3.yAxis(0).labels().format("\${%Value}{groupsSeparator: }")

            cartesian_kpi3.tooltip().positionMode(TooltipPositionMode.POINT)
            cartesian_kpi3.interactivity().hoverMode(HoverMode.BY_X)

            cartesian_kpi3.xAxis(0).title("Localizacion")
            cartesian_kpi3.yAxis(0).title("Repeticiones")
            any_chart_view_kpi3.setProgressBar(view.findViewById(R.id.progress_bar))
            any_chart_view_kpi3.setChart(cartesian_kpi3)
        }
    }
}
