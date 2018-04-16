package ss.com.lbs.jingdong01.fragments;

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
import android.widget.Toast;

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
import ss.com.lbs.jingdong01.presenters.adapter.Mysousuo_liebiao_recyAdapter;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class FaXian_frag extends Fragment implements OnView {

    private LogPresenters logPresenters;
    private ImageView faxiang_sao_tu;
    private ImageView faxiang_qietu;
    private EditText faxiang_sou_et;
    private ImageView faxiang_suosou_tu;
    private ImageView faxiang_xiaoxi_tu;
    int page = 1;
    private RecyclerView faxian_sousuo_recy;
    int qie = 1;
    private Mysousuo_liebiao_recyAdapter mysousuo_liebiao_recyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxian_frag_view, container, false);
        logPresenters = new LogPresenters();
        faxiang_sao_tu = view.findViewById(R.id.faxiang_sao_tu);
        faxiang_qietu = view.findViewById(R.id.faxiang_qietu);
        faxiang_sou_et = view.findViewById(R.id.faxiang_sou_et);
        faxiang_suosou_tu = view.findViewById(R.id.faxiang_suosou_tu);
        faxiang_xiaoxi_tu = view.findViewById(R.id.faxiang_xiaoxi_tu);
        faxian_sousuo_recy = view.findViewById(R.id.faxian_sousuo_recy);
        faxian_sousuo_recy.setLayoutManager(new GridLayoutManager(getActivity(),2));
        faxiang_qietu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qie == 1 ) {
                    faxiang_qietu.setImageResource(R.drawable.qietu_2);
                    faxian_sousuo_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
                    qie = 2;
                }else {
                    faxiang_qietu.setImageResource(R.drawable.qietu_1);
                    faxian_sousuo_recy.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    qie = 1;
                }
            }
        });


        faxiang_suosou_tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sou_et = faxiang_sou_et.getText().toString();
                Log.i("SSSSS",""+sou_et);
                if (sou_et.equals("")) {
                    Toast.makeText(getActivity(), "请您输入想搜索的宝贝!!免费让你看一下手机吧。", Toast.LENGTH_SHORT).show();
                    logPresenters.getSouSuoShangPin(FaXian_frag.this,new LogMoudle(),"手机",""+page);
                }else {
                    logPresenters.getSouSuoShangPin(FaXian_frag.this,new LogMoudle(),""+sou_et,""+page);
                }
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
        List<SouSuoShangPinBean.DataBean> data = souSuoShangPinBean.getData();
        mysousuo_liebiao_recyAdapter = new Mysousuo_liebiao_recyAdapter(getActivity(), data);
        faxian_sousuo_recy.setAdapter(mysousuo_liebiao_recyAdapter);
    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {

    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {

    }
}
