package com.example.humiture.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.base.rx.RxPresenter;
import com.example.humiture.R;
import com.example.humiture.mvp.contract.IndexContract;
import com.example.humiture.ui.view.dialog.WarehouseDialog;
import com.example.humiture.utils.DensityUtils;
import com.example.humiture.utils.LineChartUtils;

import java.util.ArrayList;
import java.util.List;

import cn.addapp.pickers.common.LineConfig;
import cn.addapp.pickers.picker.SinglePicker;

import static com.example.humiture.utils.ToastUtils.showToast;

/**
 * Created by 许格.
 * Date on 2019/5/16.
 * dec:
 */
public class IndexPresent extends RxPresenter<IndexContract.mView> implements IndexContract.present {

    private Context mContext;
    private ImageView[] mImageViews;
    private SinglePicker<String> picker;

    public IndexPresent(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void drawPoint(LinearLayout layout, int pagerNumber,int position) {
        layout.removeAllViews();
        mImageViews = new ImageView[pagerNumber];
        for (int i = 0; i < pagerNumber; i++) {
            ImageView imageView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 10, 0);
            imageView.setLayoutParams(params);
            if(i==position){
                imageView.setImageResource(R.mipmap.index_yuan_sel);
            }
            else {
                imageView.setImageResource(R.mipmap.index_yuan);
            }
            mImageViews[i]=imageView;
            layout.addView(imageView);
        }
    }

    @Override
    public void designation(List<String> name, int number) {
        picker = new SinglePicker<>((Activity) mContext,name);
        picker.setCanLoop(false);//不禁用循环
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopHeight(40);
        picker.setTitleTextColor(0xFF000000);
        picker.setTitleTextSize(16);
        picker.setCancelTextColor(0xFF999999);
        picker.setCancelTextSize(14);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setSubmitTextSize(14);
        picker.setSelectedTextColor(0xFF33B5E5);
        picker.setUnSelectedTextColor(0xFF999999);
        picker.setWheelModeEnable(false);
        LineConfig config = new LineConfig();
        config.setColor(Color.GRAY);//线颜色
        config.setAlpha(120);//线透明度
        picker.setLineConfig(config);
        picker.setItemWidth(DensityUtils.getScreenWidth(mContext)*5/10);
        picker.setBackgroundColor(0xFFFFFFFF);
        picker.setSelectedIndex(number);
        if (number == 8){
            picker.setTitleText("请选择数据类型");
        }else {
            picker.setTitleText("请选择库房");
        }
        picker.setOnItemPickListener((index, item) -> {
            if (number == 8){
                mView.showDataType(index, item);
            }else {
                mView.showWareHouse(item);
            }
        });
        picker.show();
    }

    @Override
    public void showLineChart(LineChartUtils manager, ArrayList<Float> xValues, List<Float> toadyValues, List<Float> yesterdayValues, int typeColor) {
        manager.showLineChart(xValues, toadyValues, yesterdayValues, typeColor);
        manager.setYAxis(60, 10, 6);
    }
}
