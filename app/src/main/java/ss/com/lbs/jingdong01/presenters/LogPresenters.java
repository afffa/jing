package ss.com.lbs.jingdong01.presenters;

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
import ss.com.lbs.jingdong01.moudle.GetAddGoiuWuChe;
import ss.com.lbs.jingdong01.moudle.GetChAGouWuChe;
import ss.com.lbs.jingdong01.moudle.GetChuangJianDingdan;
import ss.com.lbs.jingdong01.moudle.GetDengLu;
import ss.com.lbs.jingdong01.moudle.GetDingDanLieBiao;
import ss.com.lbs.jingdong01.moudle.GetFenLei_LieBiao;
import ss.com.lbs.jingdong01.moudle.GetJuiGongGe;
import ss.com.lbs.jingdong01.moudle.GetRemoveGouWuChe;
import ss.com.lbs.jingdong01.moudle.GetShouYe;
import ss.com.lbs.jingdong01.moudle.GetSouSuoShangPin;
import ss.com.lbs.jingdong01.moudle.GetXiangQing;
import ss.com.lbs.jingdong01.moudle.GetZhuCeBean;
import ss.com.lbs.jingdong01.moudle.GeterZiFenLei;
import ss.com.lbs.jingdong01.moudle.Imode;
import ss.com.lbs.jingdong01.view.OnView;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class LogPresenters implements Ipressenter  {

    @Override
    public void getDengLu(final OnView iview, Imode imode, String tel, String pas) {
        imode.getDengLu(new GetDengLu() {
            @Override
            public void getDengLu(DengLuBean dengLuBean) {
                iview.onSuccessM(dengLuBean);
            }
        },tel,pas);
    }

    @Override
    public void getZhuCe(final OnView iview, Imode imode, String tel, String pas) {
        imode.getZhuCe(new GetZhuCeBean() {
            @Override
            public void getZhuCe(ZhuCeBean zhuCeBean) {
                iview.onzhuce(zhuCeBean);
            }
        },tel,pas);
    }

    @Override
    public void getShouYe(final OnView iview, Imode imode) {
        imode.getShouYem(new GetShouYe() {
            @Override
            public void getShouYe(ShouYeBean shouYeBean) {
                iview.onshouye(shouYeBean);
            }
        });
    }

    @Override
    public void getXiangQing(final OnView iview, Imode imode, String pid) {
        imode.getXiangQing(new GetXiangQing() {
            @Override
            public void getXiangQing(XiangQingBean xiangQingBean) {
                iview.onXiangqing(xiangQingBean);
            }
        },pid);
    }

    @Override
    public void getJuiGongGe(final OnView iview, Imode imode) {
        imode.getJuiGongGe(new GetJuiGongGe() {
            @Override
            public void getJuiGongGe(JuiGongGeBean juiGongGeBean) {
                iview.onJuiGongGe(juiGongGeBean);
            }
        });
    }

    @Override
    public void getFenerZiLei(final OnView iview, Imode imode, String cid) {
        imode.getFenZiLei(new GeterZiFenLei() {
            @Override
            public void getErZiFenLei(FenZiListBean fenZiListBean) {
                iview.onFenZiLei(fenZiListBean);
            }
        },cid);
    }

    @Override
    public void getGouWuChe(final OnView iview, Imode imode, String uid, String token) {
        imode.getGouWuChecha(new GetChAGouWuChe() {
            @Override
            public void getChaGouWuChe(GouWuChechaBean gouWuCheBean) {
                iview.onGouWuChe(gouWuCheBean);
            }
        },uid,token);
    }

    @Override
    public void getFenLei_LieBiao(final OnView iview, final Imode imode, String pscid) {
        imode.getFenLei_LieBiao(new GetFenLei_LieBiao() {
            @Override
            public void getFEnLei_LieBiao(FenLei_LieBiao_Bean fenLei_lieBiao) {
                iview.onFenLei_LieBiao(fenLei_lieBiao);
            }
        },pscid);
    }

    @Override
    public void getAddGouWuChe(final OnView iview, final Imode imode, String uid, String pid, String token) {
        imode.getAddGoiuWuChe(new GetAddGoiuWuChe() {
            @Override
            public void getAddGoiuWuChe(AddGouWuCheBean getaddGouWuCheBean) {
                iview.onAddGouWuChe(getaddGouWuCheBean);
            }
        },uid,pid,token);
    }

    @Override
    public void getRemoveGouWuChe(final OnView iview, Imode imode, String uid, String pid, String token) {
        imode.getRemoveGouWuChe(new GetRemoveGouWuChe() {
            @Override
            public void getRemoveGouWuChe(RemoveGouWuCheBean removeGouWuCheBean) {
                iview.onRemoveGouWiuChe(removeGouWuCheBean);
            }
        },uid,pid,token);
    }

    @Override
    public void getSouSuoShangPin(final OnView iview, Imode imode, String keywords, String page) {
        imode.getSouSuoShangPin(new GetSouSuoShangPin() {
            @Override
            public void getSouSuoShangPin(SouSuoShangPinBean souSuoShangPinBean) {
                iview.onSouSuoShangPin(souSuoShangPinBean);
            }
        },keywords,page);
    }

    @Override
    public void getChuangJianDingDan(final OnView iview, Imode imode, String uid, String price) {
        imode.getChuangJianDingdan(new GetChuangJianDingdan() {
            @Override
            public void getChuangJianDingdan(ChuangJianDingDan chuangJianDingDan) {
                iview.onChuangJianDingDan(chuangJianDingDan);
            }
        },uid,price);
    }

    @Override
    public void getDingDanLieBiao(final OnView iview, Imode imode, String uid) {
        imode.getDingDanLieBiao(new GetDingDanLieBiao() {
            @Override
            public void getDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {
                iview.onDingDanLieBiao(dingDanLieBiaoBean);
            }
        },uid);
    }

}
