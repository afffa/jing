package ss.com.lbs.jingdong01.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.activity.XiaoXiJieMian;
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
import ss.com.lbs.jingdong01.presenters.adapter.Mysousuo_liebiao_recyAdapter;
import ss.com.lbs.jingdong01.presenters.adapter.MyxrecyAdapter;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class Home_frag extends Fragment implements OnView {

    private XRecyclerView xrecy_xview;
    private LogPresenters logPresenters;
    private JuiGongGeBean juiGongGeBean;
    private XBanner xbanner;
    List<String> list_tu = new ArrayList<>();
    private View inflate;
    private View view;
    private MyxrecyAdapter myxrecyAdapter;
    private EditText sou_et;
    private LinearLayout shouye_liebiao;
    private LinearLayout sousuo_liebiao;
    boolean flog = true;
    int page = 1;
    private ImageView suosou_tu;
    private RecyclerView sousuo_liebiao_recy_item_view1;
    private ImageView sao_tu;
    private ImageView xiaoxi_tu;
    private ImageView qietu;
    int qie = 2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //主布局
        view = inflater.inflate(R.layout.home_frag_view, container, false);
        //XBanner 头布局
        inflate = View.inflate(getActivity(), R.layout.sxrecy_item_view1, null);
        //实例p
        logPresenters = new LogPresenters();
        //p首页方法
        logPresenters.getShouYe(this,new LogMoudle());
        //p九宫格方法
        logPresenters.getJuiGongGe(this,new LogMoudle());
        //获取初始数据
        sou_et = view.findViewById(R.id.sou_et);
        sousuo_liebiao_recy_item_view1 = view.findViewById(R.id.sousuo_liebiao_recy_item_view1);
        suosou_tu = view.findViewById(R.id.suosou_tu);
        shouye_liebiao = view.findViewById(R.id.shouye_liebiao);
        sousuo_liebiao = view.findViewById(R.id.sousuo_liebiao);
        xrecy_xview = view.findViewById(R.id.xrecy_xview);
        sao_tu = view.findViewById(R.id.sao_tu);
        xiaoxi_tu = view.findViewById(R.id.xiaoxi_tu);
        qietu = view.findViewById(R.id.qietu);
        qietu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qie == 1 ) {
                    qietu.setImageResource(R.drawable.qietu_1);
                    sousuo_liebiao_recy_item_view1.setLayoutManager(new LinearLayoutManager(getActivity()));
                    qie = 2;
                }else {
                    qietu.setImageResource(R.drawable.qietu_2);
                    sousuo_liebiao_recy_item_view1.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    qie = 1;
                }
            }
        });
        //setVisibility(View.VISIBLE);  ///隐藏布局控件
        //setVisibility(View.GONE);    ////显示布局控件
//        shouye_liebiao.setVisibility(View.GONE);
        //二维码
        sao_tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        //消息界面
        xiaoxi_tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), XiaoXiJieMian.class);
                startActivity(intent);
            }
        });
        sousuo_liebiao.setVisibility(View.VISIBLE);
        //单击搜索图标的事件
        suosou_tu.setOnClickListener(new View.OnClickListener() {
            private String sou_et1;
            @Override
            public void onClick(View view) {
                if (flog) {
                    Toast.makeText(getActivity(), "首页隐藏，搜索显示", Toast.LENGTH_SHORT).show();
                    shouye_liebiao.setVisibility(View.GONE);
                    sousuo_liebiao.setVisibility(View.VISIBLE);
                    flog = false;
                    sou_et1 = sou_et.getText().toString();
                    Log.i("LLLED",""+sou_et1);
                    if (sou_et1.equals("")){
                        Toast.makeText(getActivity(), "请您输入想搜索的宝贝!!免费让你看一下笔记本吧吧。", Toast.LENGTH_SHORT).show();
                        logPresenters.getSouSuoShangPin(Home_frag.this, new LogMoudle(), "笔记本", "" + page);
                    }else {
                        logPresenters.getSouSuoShangPin(Home_frag.this, new LogMoudle(), "" + sou_et1, "" + page);
                    }
                }else {
                    Toast.makeText(getActivity(), "搜索隐藏，首页显示", Toast.LENGTH_SHORT).show();
                    shouye_liebiao.setVisibility(View.VISIBLE);
                    sousuo_liebiao.setVisibility(View.GONE);
                    flog = true;
                }
            }
        });
        //添加xbanner头
        xrecy_xview.addHeaderView(inflate);
        xbanner = inflate.findViewById(R.id.shou_xbanner);
        //xrecy_xview 布局管理器
        xrecy_xview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //刷新加载方法
        xrecy_xview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新适配器
                myxrecyAdapter.notifyDataSetChanged();
                //刷新完成
                xrecy_xview.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                //刷新适配器
                myxrecyAdapter.notifyDataSetChanged();
                //刷新完成
                xrecy_xview.refreshComplete();
            }
        });
        return view;
    }

    @Override
    public void onSuccessM(Object object) {

    }

    @Override
    public void onzhuce(ZhuCeBean object) {

    }

    @Override
    public void onshouye(ShouYeBean shouYeBean) {
        //首页接口回调方法
        //添加适配器
        myxrecyAdapter = new MyxrecyAdapter(getActivity(),shouYeBean,juiGongGeBean);
        xrecy_xview.setAdapter(myxrecyAdapter);
        for (int i = 0; i < shouYeBean.getData().size(); i++) {
            //  为xbanner显示图片获取图片地址
            list_tu.add(shouYeBean.getData().get(i).getIcon()+"");
        }
        ///  xbanner显示图片
        xbanner.setData(list_tu,null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Picasso.with(getActivity()).load(list_tu.get(position)).placeholder(R.drawable.ic_launcher_background).into((ImageView) view);
            }
        });
    }

    @Override
    public void onXiangqing(XiangQingBean xiangQingBean) {

    }

    @Override
    public void onJuiGongGe(JuiGongGeBean juiGongGeBean) {
        this.juiGongGeBean = juiGongGeBean;
    }

    @Override
    public void onFenZiLei(FenZiListBean fenZiListBean) {

    }

    @Override
    public void onGouWuChe(GouWuChechaBean gouWuChechaBean) {

    }

    @Override
    public void heji() {

    }

    @Override
    public void onFenLei_LieBiao(FenLei_LieBiao_Bean fenLei_lieBiao) {

    }

    @Override
    public void onAddGouWuChe(AddGouWuCheBean addGouWuCheBean) {

    }

    @Override
    public void onRemoveGouWiuChe(RemoveGouWuCheBean removeGouWuCheBean) {
    }

    @Override
    public void onSouSuoShangPin(SouSuoShangPinBean souSuoShangPinBean) {
        //搜索商品的接口回调方法
        Log.i("LLLSouSuo",""+souSuoShangPinBean.getData().get(0).getTitle());
        // Recycleview 布局管理器
        sousuo_liebiao_recy_item_view1.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<SouSuoShangPinBean.DataBean> data = souSuoShangPinBean.getData();
        //添加适配器
        Mysousuo_liebiao_recyAdapter mysousuo_liebiao_recyAdapter = new Mysousuo_liebiao_recyAdapter(getActivity(),data);
        sousuo_liebiao_recy_item_view1.setAdapter(mysousuo_liebiao_recyAdapter);
    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {

    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {

    }
}
