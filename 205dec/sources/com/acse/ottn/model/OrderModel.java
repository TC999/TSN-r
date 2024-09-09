package com.acse.ottn.model;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class OrderModel {
    private List<OrderListBean> order_list = new ArrayList();
    private String points;

    /* renamed from: r  reason: collision with root package name */
    private int f5983r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class OrderListBean {
        private String app;
        private String deeplink;
        private String img;
        private String link;
        private String order_price;
        private String order_sn;
        private String order_time;
        private String points;
        private String product;
        private String status;

        public String getApp() {
            return this.app;
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public String getImg() {
            return this.img;
        }

        public String getLink() {
            return this.link;
        }

        public String getOrder_price() {
            return this.order_price;
        }

        public String getOrder_sn() {
            return this.order_sn;
        }

        public String getOrder_time() {
            return this.order_time;
        }

        public String getPoints() {
            return this.points;
        }

        public String getProduct() {
            return this.product;
        }

        public String getStatus() {
            return this.status;
        }

        public void setApp(String str) {
            this.app = str;
        }

        public void setDeeplink(String str) {
            this.deeplink = str;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setOrder_price(String str) {
            this.order_price = str;
        }

        public void setOrder_sn(String str) {
            this.order_sn = str;
        }

        public void setOrder_time(String str) {
            this.order_time = str;
        }

        public void setPoints(String str) {
            this.points = str;
        }

        public void setProduct(String str) {
            this.product = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    public List<OrderListBean> getOrder_list() {
        return this.order_list;
    }

    public String getPoints() {
        return this.points;
    }

    public int getR() {
        return this.f5983r;
    }

    public void setOrder_list(List<OrderListBean> list) {
        this.order_list = list;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setR(int i4) {
        this.f5983r = i4;
    }
}
