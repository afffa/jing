package ss.com.lbs.jingdong01.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.AddGouWuCheBean;
import ss.com.lbs.jingdong01.bean.ChuangJianDingDan;
import ss.com.lbs.jingdong01.bean.DengLuBean;
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

public class DengLu_ZhuCe extends BaseActivity implements OnView  {

    private EditText dtel;
    private EditText dpas;
    private Button denglu;
    private Button zuce;
    private LogPresenters logPresenters;
    private SharedPreferences data2;

    @Override
    protected void getData() {
        //单击登录事件
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取手机号与密码
                String tel = dtel.getText().toString();
                String pas = dpas.getText().toString();
                //效验手机号与密码
                if (tel.length() != 11) {
                    Toast.makeText(DengLu_ZhuCe.this, "手机号不对，请重新输入。", Toast.LENGTH_SHORT).show();
                }else if (pas.length() != 6){
                    Toast.makeText(DengLu_ZhuCe.this, "密码必须为6位，请重新输入。", Toast.LENGTH_SHORT).show();
                }else {
                    logPresenters.getDengLu(DengLu_ZhuCe.this,new LogMoudle(),tel,pas);
                }
            }
        });
        //单击注册事件
        zuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取手机号与密码
                String tel = dtel.getText().toString();
                String pas = dpas.getText().toString();
                //效验手机号与密码
                if (tel.length() != 11) {
                    Toast.makeText(DengLu_ZhuCe.this, "手机号不对，请重新输入。", Toast.LENGTH_SHORT).show();
                }else if (pas.length() != 6){
                    Toast.makeText(DengLu_ZhuCe.this, "密码必须为6位，请重新输入。", Toast.LENGTH_SHORT).show();
                }else {
                    logPresenters.getZhuCe(DengLu_ZhuCe.this,new LogMoudle(),tel,pas);
                }
            }
        });
    }

    @Override
    protected void getinitView() {

        //实例P层
        logPresenters = new LogPresenters();
        //获取并初始数据
        dtel = findViewById(R.id.dtel);
        dpas = findViewById(R.id.dpas);
        denglu = findViewById(R.id.denglu);
        zuce = findViewById(R.id.zuce);
    }

    @Override
    protected int getLayout() {
        return R.layout.dengluzhuce_view;
    }

    @Override
    public void onSuccessM(Object object) {
        //登录成功回调接口方法
        DengLuBean dengLuBean = (DengLuBean) object;
        String msg = dengLuBean.getMsg();
        //效验登录成功
        if (msg.equals("登录成功")) {
            //通过sp保存数据
            data2=getSharedPreferences("data2", MODE_PRIVATE);
            SharedPreferences.Editor edit = data2.edit();
            edit.putString("kname",""+ dengLuBean.getData().getUsername());
            edit.putBoolean("boo",true);
//            Log.i("LLL",""+dengLuBean.getData().getNickname());
            //提交保存的数据
            edit.commit();
            //杀死本页面
            finish();
        }
    }

    @Override
    public void onzhuce(ZhuCeBean zhuCeBean) {
        //注册成功回调方法
        final String msg = zhuCeBean.getMsg();
//        Toast.makeText(this, "msg", Toast.LENGTH_SHORT).show();
        //效验注册结果
        if (msg.equals("天呢！用户已注册") || msg.equals("注册成功") ) {
            //子线程转主线程
            DengLu_ZhuCe.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(DengLu_ZhuCe.this, ""+msg, Toast.LENGTH_SHORT).show();
                }
            });
        }
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

    }
}
