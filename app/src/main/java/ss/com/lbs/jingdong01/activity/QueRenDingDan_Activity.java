package ss.com.lbs.jingdong01.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

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
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/13.
 */

public class QueRenDingDan_Activity extends BaseActivity implements OnView {

    private SimpleDraweeView queren_divtu;
    private TextView queren_dtitle;
    private TextView queren_dprces;
    private TextView querendingdan_tijiaodingdan;
    private XiangQingBean.DataBean data;
    private TextView queren_ddizhi_name;
    private String diz = "";
    private String querenpid;

    @Override
    protected void getData() {

    }

    @Override
    protected void getinitView() {
        final Intent intent = getIntent();
        querenpid = intent.getStringExtra("querenpid");
        diz = intent.getStringExtra("diz");
        LogPresenters logPresenters = new LogPresenters();
        logPresenters.getXiangQing(this,new LogMoudle(), querenpid);
        queren_divtu = findViewById(R.id.queren_divtu);
        queren_dtitle = findViewById(R.id.queren_dtitle);
        queren_dprces = findViewById(R.id.queren_dprces);
        queren_ddizhi_name = findViewById(R.id.queren_ddizhi_name);
        TextView dingdan_bianji_dizhi = findViewById(R.id.dingdan_bianji_dizhi);
        dingdan_bianji_dizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = queren_ddizhi_name.getText().toString();
                Intent intent2 = new Intent(QueRenDingDan_Activity.this,BianJiDiZhi_activity.class);
                intent2.putExtra("dizhi",""+string);
                startActivity(intent2);
            }
        });
        querendingdan_tijiaodingdan = findViewById(R.id.querendingdan_tijiaodingdan);
        querendingdan_tijiaodingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(QueRenDingDan_Activity.this,ShouYinTai.class);
                intent1.putExtra("data1",""+data.toString());
                startActivity(intent1);
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.querendingdan_view;
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
        data = xiangQingBean.getData();
        String images = data.getImages();
        if (images.contains("|")) {
            String[] split = images.split("\\|");
            queren_divtu.setImageURI(split[0]);
        }else {
            queren_divtu.setImageURI(images);
        }
        queren_dtitle.setText(data.getTitle());
        queren_dprces.setText("￥："+ data.getPrice());
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
    }
}
