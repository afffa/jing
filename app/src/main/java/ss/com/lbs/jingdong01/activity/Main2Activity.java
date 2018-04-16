package ss.com.lbs.jingdong01.activity;

import android.graphics.Color;

import com.hjm.bottomtabbar.BottomTabBar;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.fragments.FaXian_frag;
import ss.com.lbs.jingdong01.fragments.FenLei_frag;
import ss.com.lbs.jingdong01.fragments.GouWuChe_frag;
import ss.com.lbs.jingdong01.fragments.Home_frag;
import ss.com.lbs.jingdong01.fragments.MyDe_frag;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class Main2Activity extends BaseActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void getData() {
        //设置bottomTabBar数据
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("",R.drawable.s, Home_frag.class)
                .addTabItem("",R.drawable.f, FenLei_frag.class)
                .addTabItem("",R.drawable.fx, FaXian_frag.class)
                .addTabItem("",R.drawable.g, GouWuChe_frag.class)
                .addTabItem("",R.drawable.w, MyDe_frag.class)
                .isShowDivider(false);
    }

    @Override
    protected void getinitView() {
        //初始  获取 bottomTabBar
        bottomTabBar = findViewById(R.id.bta);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }
}
