package ss.com.lbs.jingdong01.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import ss.com.lbs.jingdong01.R;

public class MainActivity extends AppCompatActivity {

    private ImageView guanggao_tu;
    private Timer timer;
    int i1 = R.drawable.ic_navigation_vp_page_1;
    int i2 = R.drawable.ic_navigation_vp_page_2;
    int i3 = R.drawable.ic_navigation_vp_page_3;
    int i4 = R.drawable.ic_navigation_vp_page_4;
    int i = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(i == 0){
                guanggao_tu.setImageResource(i1);
            }else if(i == 1){
                guanggao_tu.setImageResource(i2);
            }else if(i == 2){
                guanggao_tu.setImageResource(i3);
            }else if ( i == 3){
                guanggao_tu.setImageResource(i4);
            }else {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                timer.cancel();
                finish();
            }
            i++;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guanggao_tu = findViewById(R.id.guanggao_tu);

        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        String name = user.getString("name", "");
        if (name == null | name == "") {
            //sp保存数据用来判断
            SharedPreferences.Editor edit = user.edit();
            edit.putString("name","111");
            edit.commit();
            //应用首次启动
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Message msg = new Message();
                    handler.sendMessage(msg);
                }
            }, 0, 2000);

        } else if (name.equals("111")){
            guanggao_tu.setImageResource(R.drawable.ic_navigation_vp_page_0);
            //缩放
            //属性动画
            ObjectAnimator scaleAnim1 = ObjectAnimator.ofFloat(guanggao_tu, "scaleY", 1f, 2f, 1f);
            scaleAnim1.setDuration(3000);
            scaleAnim1.start();
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }

    }
}
