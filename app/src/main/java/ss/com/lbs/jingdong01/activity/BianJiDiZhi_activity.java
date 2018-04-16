package ss.com.lbs.jingdong01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ss.com.lbs.jingdong01.R;

/**
 * author:Created by WangZhiQiang on 2018/4/16.
 */

public class BianJiDiZhi_activity extends AppCompatActivity {

    private TextView bianjidizhi_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bianjidizhi_view);
        EditText bianjidizhi_et = findViewById(R.id.bianjidizhi_et);
        bianjidizhi_tv = findViewById(R.id.bianjidizhi_tv);
        Intent intent = getIntent();
        String dizhi = intent.getStringExtra("dizhi");
        bianjidizhi_et.setText(dizhi);
        bianjidizhi_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dizhi = bianjidizhi_tv.getText().toString();
                Intent intent1 = new Intent(BianJiDiZhi_activity.this,QueRenDingDan_Activity.class);
                intent1.putExtra("diz", "" + dizhi);
                startActivity(intent1);
            }
        });
    }
}
