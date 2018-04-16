package ss.com.lbs.jingdong01.moudle;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public interface Imode {
    void getDengLu(GetDengLu getDengLu,String tel,String pas);
    void getZhuCe(GetZhuCeBean getDengLu, String tel, String pas);
    void getShouYem(GetShouYe gEtShouYe);
    void getXiangQing(GetXiangQing getXiangQing,String pid);
    void getJuiGongGe(GetJuiGongGe getJuiGongGe);
    void getFenZiLei(GeterZiFenLei geterZiFenLei,String cid);
    void getGouWuChecha(GetChAGouWuChe getChAGouWuChe,String uid,String token);
    void getFenLei_LieBiao(GetFenLei_LieBiao getFenLei_lieBiao,String pscid);
    void getAddGoiuWuChe(GetAddGoiuWuChe getAddGoiuWuChe,String uid ,String pid,String token );
    void getRemoveGouWuChe(GetRemoveGouWuChe getRemoveGouWuChe,String uid,String pid,String token);
    void getSouSuoShangPin(GetSouSuoShangPin getSouSuoShangPin,String keywords,String page);
    void getChuangJianDingdan(GetChuangJianDingdan getChuangJianDingdan,String uid,String price);
    void getDingDanLieBiao(GetDingDanLieBiao getDingDanLieBiao,String uid);
}
