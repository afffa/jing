package ss.com.lbs.jingdong01.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        getinitView();
        getData();
    }

    protected abstract void getData();

    protected abstract void getinitView();

    protected abstract int getLayout();

}
