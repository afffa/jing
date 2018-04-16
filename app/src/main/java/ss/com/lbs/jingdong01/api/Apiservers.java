package ss.com.lbs.jingdong01.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
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

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public interface Apiservers {
    //https://www.zhaoapi.cn/user/login?source=android&mobile=17600558635&password=123456
    @GET("user/login")
    Observable<DengLuBean> getDengLu(@Query("source") String android, @Query("mobile") String tel, @Query("password") String pas );
    //https://www.zhaoapi.cn/user/reg?source=android&mobile=17600558635&password=123456
    @GET("user/reg")
    Observable<ZhuCeBean> getZhuCe(@Query("source") String android, @Query("mobile") String tel, @Query("password") String pas );
    //https://www.zhaoapi.cn/ad/getAd?source=android
    @GET("ad/getAd?source=android")
    Observable<ShouYeBean> getShouYe();
    //https://www.zhaoapi.cn/product/getProductDetail?source=android&pid=2
    //https://www.zhaoapi.cn/product/getProductDetail?source=android&pid=2
    @GET("product/getProductDetail")
    Observable<XiangQingBean> getXiangQing(@Query("source") String android, @Query("pid") String pid);
    //https://www.zhaoapi.cn/product/getCatagory?source=android
    @GET("product/getCatagory")
    Observable<JuiGongGeBean> getJuiGongGe(@Query("source")String android);
    ///https://www.zhaoapi.cn/product/getProductCatagory?source=android&cid=1
    @GET("product/getProductCatagory")
    Observable<FenZiListBean> getFenZiLeiBean(@Query("source") String android,@Query("cid") String cid );
    //https://www.zhaoapi.cn/product/getCarts?source=android&uid=12588&token=D0D2F23D823D4043A072FA416CCEB9E3
    @GET("product/getCarts")
    Observable<GouWuChechaBean> getChaGouWuChe(@Query("source")String android,@Query("uid") String uid,@Query("token") String token);
    //https://www.zhaoapi.cn/product/getProducts?pscid=1
    @GET("product/getProducts")
    Observable<FenLei_LieBiao_Bean> getFenLei_LieBiao(@Query("pscid") String pscid);
    //https://www.zhaoapi.cn/product/addCart?source=android&uid=72&pid=18&token=D0D2F23D823D4043A072FA416CCEB9E3
    @GET("product/addCart")
    Observable<AddGouWuCheBean> getAddGouWuChe(@Query("source") String android,@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);
    //https://www.zhaoapi.cn/product/deleteCart?source=android&uid=72&pid=1&token=D0D2F23D823D4043A072FA416CCEB9E3
    @GET("product/deleteCart")
    Observable<RemoveGouWuCheBean> getRemoveGouWuChe(@Query("source") String android ,@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);
    //https://www.zhaoapi.cn/product/searchProducts?source=android&keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=2
    @GET("product/searchProducts")
    Observable<SouSuoShangPinBean> getSouSuoShangPin(@Query("source") String android,@Query("keywords") String keywords,@Query("page") String page);
    //https://www.zhaoapi.cn/product/createOrder?source=android&uid=12588&price=5199
    @GET("product/createOrder")
    Observable<ChuangJianDingDan> getChuangJianDingdan(@Query("source") String android ,@Query("uid") String uid,@Query("price") String price);
    //https://www.zhaoapi.cn/product/getOrders?source=android&uid=12588
    @GET("product/getOrders")
    Observable<DingDanLieBiaoBean> getDingDanLieBiao(@Query("source") String android ,@Query("uid") String uid);
}
