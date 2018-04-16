package ss.com.lbs.jingdong01.view;

import ss.com.lbs.jingdong01.bean.AddGouWuCheBean;
import ss.com.lbs.jingdong01.bean.ChuangJianDingDan;
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

public interface OnView {
    void onSuccessM(Object object);
    void onzhuce(ZhuCeBean object);
    void onshouye(ShouYeBean shouYeBean);
    void onXiangqing(XiangQingBean xiangQingBean);
    void onJuiGongGe(JuiGongGeBean juiGongGeBean);
    void onFenZiLei(FenZiListBean fenZiListBean);
    void onGouWuChe(GouWuChechaBean gouWuChechaBean);
    void heji();
    void onFenLei_LieBiao(FenLei_LieBiao_Bean fenLei_lieBiao);
    void onAddGouWuChe(AddGouWuCheBean addGouWuCheBean);
    void onRemoveGouWiuChe(RemoveGouWuCheBean removeGouWuCheBean);
    void onSouSuoShangPin(SouSuoShangPinBean souSuoShangPinBean);
    void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan);
    void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean);
}
