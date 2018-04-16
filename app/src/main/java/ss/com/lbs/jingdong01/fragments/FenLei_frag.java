package ss.com.lbs.jingdong01.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import ss.com.lbs.jingdong01.R;
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
import ss.com.lbs.jingdong01.presenters.adapter.My_Fen_ListAdapters;
import ss.com.lbs.jingdong01.presenters.adapter.My_Zi_Fen_ListAdapters;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class FenLei_frag extends Fragment implements OnView {

    private ListView fenlei_lv;
    private LogPresenters logPresenters;
    private XBanner fen_tupain_xbanner;
    private ExpandableListView fen_expand_listview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取布局
        View view = inflater.inflate(R.layout.fenlei_frag_view, container, false);
        //获取初始ID
        fenlei_lv = view.findViewById(R.id.fenlei_lv);
        fen_tupain_xbanner = view.findViewById(R.id.fen_tupain_Xbanner);
        fen_expand_listview = view.findViewById(R.id.fen_expand_listview);
        //初始图片网络地址
        final List<String> list = new ArrayList<>();
        list.add("http://img04.sogoucdn.com/app/a/100520024/4965d36dcda9197fea8c81faae809e10");
        list.add("http://img02.sogoucdn.com/app/a/100520024/1a0a470a1e0d38ede0445b56a97ec9ac");
        list.add("http://img01.sogoucdn.com/app/a/100520024/d666bcd8f879bbab660609235b9552ab");
        list.add("http://img03.sogoucdn.com/app/a/100520024/7262f1953f13623213a132ead33c6a36");
        //XBanner显示图片数据自动轮播
        fen_tupain_xbanner.setData(list,null);
        fen_tupain_xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                //Picasso 显示加载图片
                Picasso.with(getActivity()).load(list.get(position)).placeholder(R.drawable.ic_launcher_background).into((ImageView) view);
            }
        });
        //调用p层九宫格的方法
        logPresenters = new LogPresenters();
        logPresenters.getJuiGongGe(this,new LogMoudle());
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
    }

    @Override
    public void onXiangqing(XiangQingBean xiangQingBean) {
    }

    @Override
    public void onJuiGongGe(final JuiGongGeBean juiGongGeBean) {
        //九宫格接口回调方法
        //添加适配器
        My_Fen_ListAdapters myadapters = new My_Fen_ListAdapters(getActivity(),juiGongGeBean);
        fenlei_lv.setAdapter(myadapters);
        //适配器item事件
        fenlei_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int cid = juiGongGeBean.getData().get(i).getCid();
                //在点击事件后调用p层分类里面的二级列表方法
                logPresenters.getFenerZiLei(FenLei_frag.this,new LogMoudle(),cid+"");
            }
        });
    }

    @Override
    public void onFenZiLei(FenZiListBean fenZiListBean) {
        //分类二级列表接口回调方法
        //添加适配器
        My_Zi_Fen_ListAdapters my_zi_fen_listAdapters = new My_Zi_Fen_ListAdapters(getActivity(), fenZiListBean);
        fen_expand_listview.setAdapter(my_zi_fen_listAdapters);
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

    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {

    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {

    }
}
