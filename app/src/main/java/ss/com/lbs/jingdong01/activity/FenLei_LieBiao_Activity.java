package ss.com.lbs.jingdong01.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
import ss.com.lbs.jingdong01.presenters.adapter.MyFenLei_liebiaoAdapter;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/12.
 */

public class FenLei_LieBiao_Activity extends BaseActivity implements OnView {

    private ListView fenlei_lisbiao_listview;
    private List<FenLei_LieBiao_Bean.DataBean> data;

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
        //分类页面的列表会掉接口方法
        data = fenLei_lieBiao.getData();
        //添加适配器
        MyFenLei_liebiaoAdapter myFenLei_liebiaoAdapter = new MyFenLei_liebiaoAdapter(this, data);
        fenlei_lisbiao_listview.setAdapter(myFenLei_liebiaoAdapter);
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

    @Override
    protected void getData() {

    }

    @Override
    protected void getinitView() {
        // Intent 取值
        final Intent intent = getIntent();
        String pscid = intent.getStringExtra("pid");
        //调用p层分类列表的方法
        LogPresenters logPresenters = new LogPresenters();
        logPresenters.getFenLei_LieBiao(this,new LogMoudle(),pscid);
        //获取初始分类列表的ID
        fenlei_lisbiao_listview = findViewById(R.id.fenlei_lisbiao_listview);
        //item的点击事件
        fenlei_lisbiao_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pscid1 = data.get(i).getPscid();
                //点击跳转到详情页面
                Intent intent1 = new Intent(FenLei_LieBiao_Activity.this,XiangQingxinxi.class);
                intent1.putExtra("pid",""+pscid1);
                startActivity(intent1);
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.fenleiliebiao_view;
    }
}
