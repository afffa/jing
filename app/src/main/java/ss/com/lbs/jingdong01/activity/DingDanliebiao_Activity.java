package ss.com.lbs.jingdong01.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import ss.com.lbs.jingdong01.presenters.adapter.Mydingdan_liebiaoAbapter;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/16.
 */

public class DingDanliebiao_Activity extends BaseActivity implements OnView {

    private LogPresenters logPresenters;
    private RecyclerView dingdan_liebiao_recy;

    @Override
    protected void getData() {
    }

    @Override
    protected void getinitView() {
        logPresenters = new LogPresenters();
        logPresenters.getDingDanLieBiao(this,new LogMoudle(),"12588");
        dingdan_liebiao_recy = findViewById(R.id.dingdan_liebiao_recy);
        dingdan_liebiao_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int getLayout() {
        return R.layout.dingdanliebiao_view;
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

    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {

    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {
        List<DingDanLieBiaoBean.DataBean> data = dingDanLieBiaoBean.getData();
        Mydingdan_liebiaoAbapter mydingdan_liebiaoAbapter = new Mydingdan_liebiaoAbapter(this, data);
        dingdan_liebiao_recy.setAdapter(mydingdan_liebiaoAbapter);
    }
}
