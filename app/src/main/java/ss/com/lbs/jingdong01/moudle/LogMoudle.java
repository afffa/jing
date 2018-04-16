package ss.com.lbs.jingdong01.moudle;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ss.com.lbs.jingdong01.api.Api;
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
import ss.com.lbs.jingdong01.utils.Util;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class LogMoudle implements Imode {

    @Override
    public void getDengLu(final GetDengLu getDengLu, String tel, String pas) {
        Observable<DengLuBean> dengLu = Util.getminstance().getnetjson(Api.net).getDengLu("android", tel, pas);
        dengLu.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DengLuBean>() {
                    @Override
                    public void accept(DengLuBean dengLuBean) throws Exception {
                        getDengLu.getDengLu(dengLuBean);
                    }
                });
    }

    @Override
    public void getZhuCe(final GetZhuCeBean getZhuCe, String tel, String pas) {
        Observable<ZhuCeBean> dengLu = Util.getminstance().getnetjson(Api.net).getZhuCe("android", tel, pas);
        dengLu.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhuCeBean>() {
                    @Override
                    public void accept(ZhuCeBean zhuCeBean) throws Exception {
                        getZhuCe.getZhuCe(zhuCeBean);
                    }
                });
    }

    @Override
    public void getShouYem(final GetShouYe getShouYe1) {
        Observable<ShouYeBean> shouYe = Util.getminstance().getnetjson(Api.net).getShouYe();
        shouYe.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouYeBean>() {
                    @Override
                    public void accept(ShouYeBean shouYeBean) throws Exception {
                        getShouYe1.getShouYe(shouYeBean);
                    }
                });
    }

    @Override
    public void getXiangQing(final GetXiangQing getXiangQing, String pid) {
        Observable<XiangQingBean> android = Util.getminstance().getnetjson(Api.net).getXiangQing("android", pid);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingBean>() {
                    @Override
                    public void accept(XiangQingBean xiangQingBean) throws Exception {
                        getXiangQing.getXiangQing(xiangQingBean);
                    }
                });
    }

    @Override
    public void getJuiGongGe(final GetJuiGongGe getJuiGongGe) {
        Observable<JuiGongGeBean> juiGongGe = Util.getminstance().getnetjson(Api.net).getJuiGongGe("android");
        juiGongGe.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JuiGongGeBean>() {
                    @Override
                    public void accept(JuiGongGeBean juiGongGeBean) throws Exception {
                        getJuiGongGe.getJuiGongGe(juiGongGeBean);
                    }
                });
    }

    @Override
    public void getFenZiLei(final GeterZiFenLei geterZiFenLei, String cid) {
        Observable<FenZiListBean> fenZiListBean = Util.getminstance().getnetjson(Api.net).getFenZiLeiBean("android",cid);
        fenZiListBean.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FenZiListBean>() {
                    @Override
                    public void accept(FenZiListBean fenZiListBean) throws Exception {
                        geterZiFenLei.getErZiFenLei(fenZiListBean);
                    }
                });
    }

    @Override
    public void getGouWuChecha(final GetChAGouWuChe getChAGouWuChe, String uid, String token) {
        Observable<GouWuChechaBean> android = Util.getminstance().getnetjson(Api.net).getChaGouWuChe("android", uid, token);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GouWuChechaBean>() {
                    @Override
                    public void accept(GouWuChechaBean gouWuChechaBean) throws Exception {
                        getChAGouWuChe.getChaGouWuChe(gouWuChechaBean);
                    }
                });
    }

    @Override
    public void getFenLei_LieBiao(final GetFenLei_LieBiao getFenLei_lieBiao, String pscid) {
        Observable<FenLei_LieBiao_Bean> fenLei_lieBiao = Util.getminstance().getnetjson(Api.net).getFenLei_LieBiao(pscid);
        fenLei_lieBiao.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FenLei_LieBiao_Bean>() {
                    @Override
                    public void accept(FenLei_LieBiao_Bean fenLei_lieBiao) throws Exception {
                        getFenLei_lieBiao.getFEnLei_LieBiao(fenLei_lieBiao);
                    }
                });

    }

    @Override
    public void getAddGoiuWuChe(final GetAddGoiuWuChe getAddGoiuWuChe, String uid, String pid, String token) {
        Observable<AddGouWuCheBean> android = Util.getminstance().getnetjson(Api.net).getAddGouWuChe("android", uid, pid, token);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddGouWuCheBean>() {
                    @Override
                    public void accept(AddGouWuCheBean addGouWuCheBean) throws Exception {
                        getAddGoiuWuChe.getAddGoiuWuChe(addGouWuCheBean);
                    }
                });
    }

    @Override
    public void getRemoveGouWuChe(final GetRemoveGouWuChe getRemoveGouWuChe, String uid, String pid, String token) {
        Observable<RemoveGouWuCheBean> android = Util.getminstance().getnetjson(Api.net).getRemoveGouWuChe("android", uid, pid, token);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RemoveGouWuCheBean>() {
                    @Override
                    public void accept(RemoveGouWuCheBean removeGouWuCheBean) throws Exception {
                        getRemoveGouWuChe.getRemoveGouWuChe(removeGouWuCheBean);
                    }
                });
    }

    @Override
    public void getSouSuoShangPin(final GetSouSuoShangPin getSouSuoShangPin, String keywords, String page) {
        Observable<SouSuoShangPinBean> android = Util.getminstance().getnetjson(Api.net).getSouSuoShangPin("android", keywords, page);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SouSuoShangPinBean>() {
                    @Override
                    public void accept(SouSuoShangPinBean souSuoShangPinBean) throws Exception {
                        getSouSuoShangPin.getSouSuoShangPin(souSuoShangPinBean);
                    }
                });

    }

    @Override
    public void getChuangJianDingdan(final GetChuangJianDingdan getChuangJianDingdan, String uid, String price) {
        Observable<ChuangJianDingDan> android = Util.getminstance().getnetjson(Api.net).getChuangJianDingdan("android", uid, price);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChuangJianDingDan>() {
                    @Override
                    public void accept(ChuangJianDingDan chuangJianDingDan) throws Exception {
                        getChuangJianDingdan.getChuangJianDingdan(chuangJianDingDan);
                    }
                });
    }

    @Override
    public void getDingDanLieBiao(final GetDingDanLieBiao getDingDanLieBiao, String uid) {
        Observable<DingDanLieBiaoBean> android = Util.getminstance().getnetjson(Api.net).getDingDanLieBiao("android", uid);
        android.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DingDanLieBiaoBean>() {
                    @Override
                    public void accept(DingDanLieBiaoBean dingDanLieBiaoBean) throws Exception {
                        getDingDanLieBiao.getDingDanLieBiao(dingDanLieBiaoBean);
                    }
                });


    }
}
