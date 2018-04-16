package ss.com.lbs.jingdong01.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ss.com.lbs.jingdong01.api.Apiservers;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class Util {
    private volatile static Util util = null;

    public Util() {
    }
    public static Util getminstance(){
        if (util == null) {
            synchronized (Util.class){
                if (util == null) {
                    util = new Util();
                }
            }
        }
        return util;
    }

    public Apiservers getnetjson(String uri){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Apiservers testservive = retrofit.create(Apiservers.class);
        return testservive;

    }

}
