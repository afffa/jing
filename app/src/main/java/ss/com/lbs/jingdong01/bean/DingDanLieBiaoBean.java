package ss.com.lbs.jingdong01.bean;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/13.
 */

public class DingDanLieBiaoBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2018-04-13T20:09:15","orderid":9767,"price":5199,"status":0,"title":"订单测试标题12588","uid":12588}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2018-04-13T20:09:15
         * orderid : 9767
         * price : 5199
         * status : 0
         * title : 订单测试标题12588
         * uid : 12588
         */

        private String createtime;
        private String orderid;
        private String price;
        private String status;
        private String title;
        private String uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
