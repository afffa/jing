package ss.com.lbs.jingdong01.activity;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class MApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始fresco
        Fresco.initialize(this);
    }
}
