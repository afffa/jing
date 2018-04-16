package ss.com.lbs.jingdong01.presenters;

import ss.com.lbs.jingdong01.moudle.Imode;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public interface Ipressenter {
    void getDengLu(OnView iview, Imode imode, String tel, String pas);
    void getZhuCe(OnView iview, Imode imode, String tel, String pas);
    void getShouYe(OnView iview, Imode imode);
    void getXiangQing(OnView iview, Imode imode, String pid);
    void getJuiGongGe(OnView iview, Imode imode);
    void getFenerZiLei(OnView iview,Imode imode,String cid);
    void getGouWuChe(OnView iview,Imode imode,String uid,String token);
    void getFenLei_LieBiao(OnView iview,Imode imode,String pscid);
    void getAddGouWuChe(OnView iview,Imode imode,String uid,String pid,String token);
    void getRemoveGouWuChe(OnView iview,Imode imode,String uid,String pid,String token);
    void getSouSuoShangPin(OnView iview,Imode imode,String keywords,String page);
    void getChuangJianDingDan(OnView iview,Imode imode,String uid,String price);
    void getDingDanLieBiao(OnView iview,Imode imode,String uid);
}
