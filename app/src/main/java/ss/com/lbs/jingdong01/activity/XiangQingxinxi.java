package ss.com.lbs.jingdong01.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class XiangQingxinxi extends BaseActivity implements OnView {

    private SimpleDraweeView xiangqing_iv;
    private TextView xiangqing_title_tv1;
    private TextView xiangqing_title_tv2;
    private LogPresenters logPresenters;
    private String pid;
    private TextView xiangqing_jiarugouwuche;
    private String pid1;
    private TextView xiangqing_tijiaodingdan;
    private XiangQingBean.DataBean data;

    @Override
    protected void getData() {
        //调用 P 详情接口方法
        logPresenters = new LogPresenters();
        logPresenters.getXiangQing(this,new LogMoudle(),pid);
    }

    @Override
    protected void getinitView() {
        //获取pid
        final Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        Log.i("PPPl",""+ pid);
        //获取初始ID
        xiangqing_iv = findViewById(R.id.xiangqing_iv);
        xiangqing_title_tv1 = findViewById(R.id.xiangqing_title_tv1);
        xiangqing_title_tv2 = findViewById(R.id.xiangqing_price_tv2);
        xiangqing_jiarugouwuche = findViewById(R.id.xiangqing_jiarugouwuche);
        xiangqing_tijiaodingdan = findViewById(R.id.xiangqing_tijiaodingdan);
        xiangqing_tijiaodingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pscid = data.getPscid();
                logPresenters.getChuangJianDingDan(XiangQingxinxi.this,new LogMoudle(),"12588",pscid);
                Intent intent1 = new Intent(XiangQingxinxi.this,QueRenDingDan_Activity.class);
                String querenpid = data.getPid();
                intent1.putExtra("querenpid",""+querenpid);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.xiangqing_view;
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
        Log.i("LLLX",""+xiangQingBean.getData().getTitle());
        data = xiangQingBean.getData();
        pid1 = data.getPid();
        //拆分图片
        String images = data.getImages();
        if (images.contains("|")) {
            String[] split = images.split("\\|");
            xiangqing_iv.setImageURI(split[0]);
        }else {
            xiangqing_iv.setImageURI(images);
        }
        xiangqing_title_tv1.setText(data.getTitle());
        xiangqing_title_tv2.setText(data.getPrice()+"");
        //加入购物车的事件
        xiangqing_jiarugouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断是否登录状态
                SharedPreferences data2 = XiangQingxinxi.this.getSharedPreferences("data2", MODE_PRIVATE);
                boolean boo = data2.getBoolean("boo", false);
                if (boo == true) {
                    logPresenters.getAddGouWuChe(XiangQingxinxi.this,new LogMoudle(),"12588",pid1,"D0D2F23D823D4043A072FA416CCEB9E3");
                    Toast.makeText(XiangQingxinxi.this, "已登录，可以加入购物车", Toast.LENGTH_SHORT).show();
                }else if (boo == false){
                    Intent intent = new Intent(XiangQingxinxi.this,DengLu_ZhuCe.class);
                    startActivity(intent);
                }
            }
        });
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
        //加入购物车成功的接口回调方法
        Toast.makeText(this, ""+addGouWuCheBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemoveGouWiuChe(RemoveGouWuCheBean removeGouWuCheBean) {

    }

    @Override
    public void onSouSuoShangPin(SouSuoShangPinBean souSuoShangPinBean) {

    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {
        Toast.makeText(XiangQingxinxi.this, "创建订单成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {

    }
}
