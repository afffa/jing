package ss.com.lbs.jingdong01.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;

import ss.com.lbs.jingdong01.R;

/**
 * author:Created by WangZhiQiang on 2018/4/14.
 */

public class ShouYinTai extends BaseActivity {

    String wxzf_tubiao = "https://i04picsos.sogoucdn.com/54d808ed7e022216";
    String zfbzf_tubiao = "https://i01picsos.sogoucdn.com/f34ab606972bbc64";
    private SimpleDraweeView zhifubao_zhifu_tubiao;
    private SimpleDraweeView weixin_zhifu_tubiao;
    private CheckBox weixin_checkbox;
    private CheckBox zhifubao_checkbox;
    private boolean wchecked;
    private boolean zchecked;

    @Override
    protected void getData() {
        zhifubao_zhifu_tubiao.setImageURI(zfbzf_tubiao);
        weixin_zhifu_tubiao.setImageURI(wxzf_tubiao);

    }

    @Override
    protected void getinitView() {
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        Log.i("LLLLLdata1", "" + data1);
        zhifubao_zhifu_tubiao = findViewById(R.id.zhifubao_zhifu_tubiao);
        weixin_zhifu_tubiao = findViewById(R.id.weixin_zhifu_tubiao);
        weixin_checkbox = findViewById(R.id.weixin_checkbox);
        zhifubao_checkbox = findViewById(R.id.zhifubao_checkbox);
//        weixin_checkbox.setChecked(false);
//        zhifubao_checkbox.setChecked(false);
        zhifubao_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zchecked = zhifubao_checkbox.isChecked();
//                zhifubao_checkbox.setChecked(zchecked);
                weixin_checkbox.setChecked(false);
            }

        });

        weixin_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wchecked = weixin_checkbox.isChecked();
//                weixin_checkbox.setChecked(wchecked);
                zhifubao_checkbox.setChecked(false);
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.shouyintai_view;
    }
}
