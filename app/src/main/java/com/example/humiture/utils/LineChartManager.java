package com.example.humiture.utils;

import android.content.Context;

import com.example.humiture.R;
import com.example.humiture.ui.view.LineChartMarker;
import com.example.humiture.utils.helper.DataTypeHelper;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许格.
 * Date on 2019/5/17.
 * dec:
 */
public class LineChartManager {
        private Context mContext;
        private LineChart lineChart;
        private YAxis leftAxis;   //左边Y轴
        private YAxis rightAxis;  //右边Y轴
        private XAxis xAxis;      //X轴

        public LineChartManager(Context context, LineChart mLineChart) {
            this.mContext = context;
            this.lineChart = mLineChart;
            lineChart.setNoDataText("暂无数据");
            leftAxis = lineChart.getAxisLeft();
            rightAxis = lineChart.getAxisRight();
            rightAxis.setDrawLabels(false);//右侧Y轴数据不显示
            xAxis = lineChart.getXAxis();
        }

        /**
         * 初始化LineChart
         */
        private void initLineChart(int type, boolean isWhite) {

            lineChart.setDrawGridBackground(false);
            //显示边界
            lineChart.setDrawBorders(false);

            lineChart.getDescription().setEnabled(false);

            //设置动画效果
            lineChart.animateY(2000, Easing.Linear);
            lineChart.animateX(2000, Easing.Linear);

            //折线图例 标签 设置
            Legend legend = lineChart.getLegend();
            legend.setForm(Legend.LegendForm.CIRCLE);
            legend.setTextSize(10f);
            //显示位置
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            legend.setDrawInside(false);

            //XY轴的设置
            //X轴设置显示位置在底部
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setAvoidFirstLastClipping(false);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
            //xAxis.setAxisMinimum(0f);
            xAxis.setGranularity(1f);
            //保证Y轴从0开始，不然会上移一点
            leftAxis.setAxisMinimum(0f);
            rightAxis.setAxisMinimum(0f);
            xAxis.setDrawGridLines(false);
            leftAxis.setDrawAxisLine(false);
            rightAxis.setDrawAxisLine(false);
            leftAxis.enableGridDashedLine(10f,10f,0f);
            LineChartMarker marker = new LineChartMarker(mContext,xAxis.getValueFormatter(),type);
            lineChart.setMarker(marker);
            lineChart.zoomToCenter(2f,1f);
            if (isWhite) setColor(legend);
        }

        private void setColor(Legend legend){
            xAxis.setTextColor(0xFFFFFFFF);
            leftAxis.setTextColor(0xFFFFFFFF);
            leftAxis.setGridColor(0xFFFFFFFF);
            legend.setTextColor(0xFFFFFFFF);

        }
        /**
         * 初始化曲线 每一个LineDataSet代表一条线
         * @param lineDataSet
         * @param color
         * @param mode        折线图是否填充
         */
        private void initLineDataSet(LineDataSet lineDataSet, int color, boolean mode) {
            lineDataSet.setColor(color);
            lineDataSet.setCircleColor(color);
            lineDataSet.setLineWidth(1.5f);
            lineDataSet.setCircleRadius(4f);
            lineDataSet.setDrawValues(false);
            //设置曲线值的圆点是实心还是空心
            lineDataSet.setDrawCircleHole(true);
            lineDataSet.setValueTextSize(8f);
            //设置折线图填充
            lineDataSet.setDrawFilled(mode);
            lineDataSet.setFormLineWidth(1f);
            lineDataSet.setFormSize(8f);
            //填充颜色.透明度
//        lineDataSet.setFillColor(Color.BLUE);
            lineDataSet.setFillAlpha(35);
            //线模式为圆滑曲线（默认折线）
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        }

        /**
         * 展示折线图(一条)
         *
         * @param xAxisValues
         * @param yAxisValues
         * @param label
         * @param color
         */
        public void showLineChart(List<Float> xAxisValues, List<Float> yAxisValues, String label, int color) {
            initLineChart(1,false);
            ArrayList<Entry> entries = new ArrayList<>();
            for (int i = 0; i < xAxisValues.size(); i++) {
                entries.add(new Entry(xAxisValues.get(i), yAxisValues.get(i)));
            }
            // 每一个LineDataSet代表一条线
            LineDataSet lineDataSet = new LineDataSet(entries, label);
            initLineDataSet(lineDataSet, color, false);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(lineDataSet);
            LineData data = new LineData(dataSets);
            //设置X轴的刻度数
            xAxis.setLabelCount(xAxisValues.size(), true);
            lineChart.setData(data);
        }

        /**
         * 展示线性图(多条)
         * @param xAxisValues
         * @param toadyValues
         * @param yesterdayValues 多条曲线Y轴数据集合的集合
         * @param type 数据类型
         */
        public void showLineChart(List<Integer> xAxisValues, List<Float> toadyValues, List<Float> yesterdayValues,int type,boolean isWhite) {
            initLineChart(type, isWhite);
            //设置Y轴数据
            List<List<Float>> yValues = new ArrayList<>();
            yValues.add(toadyValues);
            yValues.add(yesterdayValues);
            //添加曲线注释
            List<String> names = new ArrayList<>();
            names.add("今日");
            names.add("昨日");
            //添加曲线颜色(昨日颜色不变）
            List<Integer> colors = new ArrayList<>();
            colors.add(mContext.getResources().getColor(DataTypeHelper.getColors().get(type)));
            colors.add(mContext.getResources().getColor(R.color.yesterday_line));

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            for (int i = 0; i < yValues.size(); i++) {
                ArrayList<Entry> entries = new ArrayList<>();
                for (int j = 0; j < yValues.get(i).size(); j++) {
                    if (j >= xAxisValues.size()) {
                        j = xAxisValues.size() - 1;
                    }
                    entries.add(new Entry(xAxisValues.get(j), yValues.get(i).get(j)));
                }
                LineDataSet lineDataSet = new LineDataSet(entries, names.get(i));
                initLineDataSet(lineDataSet, colors.get(i), false);
                dataSets.add(lineDataSet);
            }
            LineData data = new LineData(dataSets);
            xAxis.setLabelCount(8, true);
            lineChart.setData(data);
        }

        /**
         * 设置Y轴值
         *
         * @param max
         * @param min
         * @param labelCount
         */
        public void setYAxis(float max, float min, int labelCount) {
            if (max < min) {
                return;
            }
            leftAxis.setAxisMaximum(max);
            leftAxis.setAxisMinimum(min);
            leftAxis.setLabelCount(labelCount, false);

            rightAxis.setAxisMaximum(max);
            rightAxis.setAxisMinimum(min);
            rightAxis.setLabelCount(labelCount, false);
            lineChart.invalidate();
        }

        /**
         * 设置X轴的值
         *
         * @param max
         * @param min
         * @param labelCount
         */
        public void setXAxis(float max, float min, int labelCount) {
            xAxis.setAxisMaximum(max);
            xAxis.setAxisMinimum(min);
            xAxis.setLabelCount(labelCount, true);
            lineChart.invalidate();
        }

        /**
         * 设置高限制线
         *
         * @param high
         * @param name
         */
        public void setHightLimitLine(float high, String name, int color) {
            if (name == null) {
                name = "高限制线";
            }
            LimitLine hightLimit = new LimitLine(high, name);
            hightLimit.setLineWidth(2f);
            hightLimit.setTextSize(10f);
            hightLimit.setLineColor(color);
            hightLimit.setTextColor(color);
            leftAxis.addLimitLine(hightLimit);
            lineChart.invalidate();
        }

        /**
         * 设置低限制线
         *
         * @param low
         * @param name
         */
        public void setLowLimitLine(int low, String name) {
            if (name == null) {
                name = "低限制线";
            }
            LimitLine hightLimit = new LimitLine(low, name);
            hightLimit.setLineWidth(4f);
            hightLimit.setTextSize(10f);
            leftAxis.addLimitLine(hightLimit);
            lineChart.invalidate();
        }

        /**
         * 设置描述信息
         *
         * @param str
         */
        public void setDescription(String str) {
            Description description = new Description();
            description.setText(str);
            lineChart.setDescription(description);
            lineChart.invalidate();
        }

        /**
         * 无数据
         */
        public void setNoData(){
                lineChart.removeAllViews();
                lineChart.setNoDataText("暂无数据");
            }
    }
