package ss.com.lbs.jingdong01.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.activity.DengLu_ZhuCe;
import ss.com.lbs.jingdong01.activity.DingDanliebiao_Activity;
import ss.com.lbs.jingdong01.bean.AddGouWuCheBean;
import ss.com.lbs.jingdong01.bean.ChuangJianDingDan;
import ss.com.lbs.jingdong01.bean.DingDanLieBiaoBean;
import ss.com.lbs.jingdong01.bean.FenLei_LieBiao_Bean;
import ss.com.lbs.jingdong01.bean.FenZiListBean;
import ss.com.lbs.jingdong01.bean.GouWuChechaBean;
import ss.com.lbs.jingdong01.bean.JuiGongGeBean;
import ss.com.lbs.jingdong01.bean.RemoveGouWuCheBean;
import ss.com.lbs.jingdong01.bean.ShouYeBean;
import ss.com.lbs.jingdong01.bean.SouSuoShangPinBean;
import ss.com.lbs.jingdong01.bean.XiangQingBean;
import ss.com.lbs.jingdong01.bean.ZhuCeBean;
import ss.com.lbs.jingdong01.moudle.LogMoudle;
import ss.com.lbs.jingdong01.presenters.LogPresenters;
import ss.com.lbs.jingdong01.presenters.adapter.MyGouWuCheErJiAdaPter;
import ss.com.lbs.jingdong01.view.OnView;

import static android.content.Context.MODE_PRIVATE;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class GouWuChe_frag extends Fragment implements OnView {
    @BindView(R.id.gouwuche_bianji_tv)
    TextView gouwucheBianjiTv;
    @BindView(R.id.gouwuche_edlist_list)
    ExpandableListView gouwucheEdlistList;
    @BindView(R.id.gouwuche_quanxuan_cb)
    CheckBox gouwucheQuanxuanCb;
    @BindView(R.id.gouwuche_hj)
    TextView gouwucheHj;
    @BindView(R.id.gouwuche_jiesuan)
    Button gouwucheJiesuan;
    @BindView(R.id.bianji)
    LinearLayout bianji;
    @BindView(R.id.gouwuche_shanchu)
    Button gouwucheShanchu;
    @BindView(R.id.wancheng)
    LinearLayout wancheng;
    Unbinder unbinder;
    boolean flog = true;
    List<GouWuChechaBean.DataBean> data;
    private MyGouWuCheErJiAdaPter myGouWuCheAdaPter;
    private LogPresenters logPresenters;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gouwuche_frag_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        logPresenters = new LogPresenters();
        logPresenters.getGouWuChe(this, new LogMoudle(), "12588", "D0D2F23D823D4043A072FA416CCEB9E3");
        //全选的点击事件
        quuanxuan(gouwucheQuanxuanCb);
        //setVisibility(View.GONE);  ///显示布局
        wancheng.setVisibility(View.GONE);
        //编辑事件
        gouwucheBianjiTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flog) {
                    gouwucheBianjiTv.setText("完成");
                    flog = false;
                    //setVisibility(View.VISIBLE);  ///隐藏布局
                    wancheng.setVisibility(View.VISIBLE);
                    bianji.setVisibility(View.GONE);
                } else {
                    gouwucheBianjiTv.setText("编辑");
                    flog = true;
                    bianji.setVisibility(View.VISIBLE);
                    wancheng.setVisibility(View.GONE);
                }
            }
        });
        //删除的事件
        shanchu();

        gouwucheEdlistList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(getActivity(), "" + data.get(i).getList().get(i1).getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        //去结算的点击事件
        gouwucheJiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转订单列表
                Intent intent = new Intent(getActivity(),DingDanliebiao_Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    //删除方法
    private void shanchu() {
        //删除单击事件
        gouwucheShanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < data.size(); i++) {
                    List<GouWuChechaBean.DataBean.ListBean> list = data.get(i).getList();
                    boolean presenterck = data.get(i).isPresenterck();
                    if (presenterck) {
                        //删除列表 //合计//刷新
                        data.remove(i);
                        heji();
                         myGouWuCheAdaPter.notifyDataSetChanged();
                    }
                    for (int j = 0; j < list.size(); j++) {
                        boolean childck = list.get(j).isChildck();
                        if (childck) {
                            //调用P层删除购物车商品的信息
                            logPresenters.getRemoveGouWuChe(GouWuChe_frag.this,new LogMoudle(),"12588",list.get(j).getPid()+"","D0D2F23D823D4043A072FA416CCEB9E3");
                            //删除列表 //合计//刷新
                            list.remove(j);
                            heji();
                            myGouWuCheAdaPter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }
    //全选的方法
    private void quuanxuan(CheckBox gouwucheQuanxuanCb) {
        gouwucheQuanxuanCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < data.size(); i++) {
                    boolean presenterck = data.get(i).isPresenterck();
                    data.get(i).setPresenterck(!presenterck);
                    List<GouWuChechaBean.DataBean.ListBean> list = data.get(i).getList();
                    for (int j = 0; j < list.size(); j++) {
                        boolean childck = list.get(j).isChildck();
                        list.get(j).setChildck(!childck);
                    }
                }
                heji();
                myGouWuCheAdaPter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSuccessM(Object object) {

    }

    @Override
    public void onzhuce(ZhuCeBean object) {

    }

    @Override
    public void onshouye(ShouYeBean shouYeBean) {

    }

    @Override
    public void onXiangqing(XiangQingBean xiangQingBean) {

    }

    @Override
    public void onJuiGongGe(JuiGongGeBean juiGongGeBean) {

    }

    @Override
    public void onFenZiLei(FenZiListBean fenZiListBean) {

    }

    @Override
    public void onGouWuChe(GouWuChechaBean gouWuChechaBean) {
        //Log.i("LLL", "" + gouWuChechaBean.getData().get(1).getSellerName());
        this.data = gouWuChechaBean.getData();
        //添加购物车的二级列表适配器
        myGouWuCheAdaPter = new MyGouWuCheErJiAdaPter(getActivity(), this.data, this);
        gouwucheEdlistList.setAdapter(myGouWuCheAdaPter);
    }

    @Override
    public void heji() {

        double add = 0;
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            List<GouWuChechaBean.DataBean.ListBean> list = data.get(i).getList();
            for (int j = 0; j < list.size(); j++) {
                boolean childck = list.get(j).isChildck();
                if (childck) {
                    count++;
                    int mycount = list.get(j).getCount() + 1;
                    double mul = mul(list.get(j).getPrice(), mycount);
                    add = add(add, mul);
                }
            }
        }
        gouwucheHj.setText(add + "");
        gouwucheJiesuan.setText("去结算" + "（" + count + "）");
    }

    @Override
    public void onFenLei_LieBiao(FenLei_LieBiao_Bean fenLei_lieBiao) {

    }

    @Override
    public void onAddGouWuChe(AddGouWuCheBean addGouWuCheBean) {

    }

    @Override
    public void onRemoveGouWiuChe(RemoveGouWuCheBean removeGouWuCheBean) {
        myGouWuCheAdaPter.notifyDataSetChanged();
        Toast.makeText(getActivity(), ""+removeGouWuCheBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSouSuoShangPin(SouSuoShangPinBean souSuoShangPinBean) {

    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {

    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {

    }

    public static double mul(double price, double mycount) {
        //高级乘法
        BigDecimal b1 = new BigDecimal(Double.toString(price));
        BigDecimal b2 = new BigDecimal(Double.toString(mycount));
        return b1.multiply(b2).doubleValue();
    }

    public static double add(double add, double mul) {
        //高级加法
        BigDecimal b1 = new BigDecimal(Double.toString(add));
        BigDecimal b2 = new BigDecimal(Double.toString(mul));
        return b1.add(b2).doubleValue();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        //fragment  的生命周期方法    在显示这个页面的第一时间就会走这个方法
        SharedPreferences data2 = getActivity().getSharedPreferences("data2", MODE_PRIVATE);
        boolean boo = data2.getBoolean("boo", false);
        if (boo == true) {
            LogPresenters logPresenters = new LogPresenters();
            logPresenters.getGouWuChe(GouWuChe_frag.this, new LogMoudle(), "12588", "D0D2F23D823D4043A072FA416CCEB9E3");
        }else if (boo == false){
            Toast.makeText(getActivity(), "系统检测到您未登录，请登录再查看购物车", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(),DengLu_ZhuCe.class);
            startActivity(intent);
        }
    }
}
