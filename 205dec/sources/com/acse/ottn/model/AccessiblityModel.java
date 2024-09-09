package com.acse.ottn.model;

import com.acse.ottn.j0;
import com.bytedance.msdk.api.AdError;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class AccessiblityModel implements Serializable {
    private int agl;
    private String ck;
    private String ck_v;
    private int cost_time;

    /* renamed from: r  reason: collision with root package name */
    private int f5979r;
    private int red_package;
    private DataBean data = new DataBean();
    private String genuine_packagename = "";
    private String toast_status = "";
    private String scrolled_screen = j0.f5774p;
    private String reset_heartbeat = "0";
    private String product_info = "";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class DataBean implements Serializable {
        private int coupon_load_time;
        private int play_audio;
        private int show_coupon_time;
        private String spop_deeplink = "";
        private String spop_coupon_price = "";
        private String spop_coupon_title = "";
        private String spop_describe = "";
        private String spop_link = "";
        private String spop_pic = "";
        private String spop_title = "";
        private String package_name = "";
        private String coupon_activity_name = "";
        private String pic_type = "";
        private String discount = "";
        private String original_price = "";
        private String present_price = "";
        private String to_loading = "";
        private String tkl_url = "";
        private String tkl_turn_url = "";
        private int coupon_detail_url = AdError.ERROR_CODE_CONTENT_TYPE;
        private String new_time_remaining = "";
        private String first_price = "";
        private int second_price = 2000;
        private int third_price = 4000;
        private String short_link = "";
        private String auto_open_coupon = "";
        private String origin_url = "";
        private String coupon_type = "";
        private int time_four = 4000;

        public String getAuto_open_coupon() {
            return this.auto_open_coupon;
        }

        public String getCoupon_activity_name() {
            return this.coupon_activity_name;
        }

        public int getCoupon_detail_url() {
            return this.coupon_detail_url;
        }

        public int getCoupon_load_time() {
            return this.coupon_load_time;
        }

        public String getCoupon_type() {
            return this.coupon_type;
        }

        public String getDiscount() {
            return this.discount;
        }

        public String getFirst_price() {
            return this.first_price;
        }

        public String getNew_time_remaining() {
            return this.new_time_remaining;
        }

        public String getOrigin_url() {
            return this.origin_url;
        }

        public String getOriginal_price() {
            return this.original_price;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public String getPic_type() {
            return this.pic_type;
        }

        public int getPlay_audio() {
            return this.play_audio;
        }

        public String getPresent_price() {
            return this.present_price;
        }

        public int getSecond_price() {
            return this.second_price;
        }

        public String getShort_link() {
            return this.short_link;
        }

        public int getShow_coupon_time() {
            return this.show_coupon_time;
        }

        public String getSpop_coupon_price() {
            return this.spop_coupon_price;
        }

        public String getSpop_coupon_title() {
            return this.spop_coupon_title;
        }

        public String getSpop_deeplink() {
            return this.spop_deeplink;
        }

        public String getSpop_describe() {
            return this.spop_describe;
        }

        public String getSpop_link() {
            return this.spop_link;
        }

        public String getSpop_pic() {
            return this.spop_pic;
        }

        public String getSpop_title() {
            return this.spop_title;
        }

        public int getThird_price() {
            return this.third_price;
        }

        public int getTime_four() {
            return this.time_four;
        }

        public String getTkl_turn_url() {
            return this.tkl_turn_url;
        }

        public String getTkl_url() {
            return this.tkl_url;
        }

        public String getTo_loading() {
            return this.to_loading;
        }

        public void setAuto_open_coupon(String str) {
            this.auto_open_coupon = str;
        }

        public void setCoupon_activity_name(String str) {
            this.coupon_activity_name = str;
        }

        public void setCoupon_detail_url(int i4) {
            this.coupon_detail_url = i4;
        }

        public void setCoupon_load_time(int i4) {
            this.coupon_load_time = i4;
        }

        public void setCoupon_type(String str) {
            this.coupon_type = str;
        }

        public void setDiscount(String str) {
            this.discount = str;
        }

        public void setFirst_price(String str) {
            this.first_price = str;
        }

        public void setNew_time_remaining(String str) {
            this.new_time_remaining = str;
        }

        public void setOrigin_url(String str) {
            this.origin_url = str;
        }

        public void setOriginal_price(String str) {
            this.original_price = str;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }

        public void setPic_type(String str) {
            this.pic_type = str;
        }

        public void setPlay_audio(int i4) {
            this.play_audio = i4;
        }

        public void setPresent_price(String str) {
            this.present_price = str;
        }

        public void setSecond_price(int i4) {
            this.second_price = i4;
        }

        public void setShort_link(String str) {
            this.short_link = str;
        }

        public void setShow_coupon_time(int i4) {
            this.show_coupon_time = i4;
        }

        public void setSpop_coupon_price(String str) {
            this.spop_coupon_price = str;
        }

        public void setSpop_coupon_title(String str) {
            this.spop_coupon_title = str;
        }

        public void setSpop_deeplink(String str) {
            this.spop_deeplink = str;
        }

        public void setSpop_describe(String str) {
            this.spop_describe = str;
        }

        public void setSpop_link(String str) {
            this.spop_link = str;
        }

        public void setSpop_pic(String str) {
            this.spop_pic = str;
        }

        public void setSpop_title(String str) {
            this.spop_title = str;
        }

        public void setThird_price(int i4) {
            this.third_price = i4;
        }

        public void setTime_four(int i4) {
            this.time_four = i4;
        }

        public void setTkl_turn_url(String str) {
            this.tkl_turn_url = str;
        }

        public void setTkl_url(String str) {
            this.tkl_url = str;
        }

        public void setTo_loading(String str) {
            this.to_loading = str;
        }

        public String toString() {
            return "DataBean{spop_deeplink='" + this.spop_deeplink + "', spop_coupon_price='" + this.spop_coupon_price + "', play_audio=" + this.play_audio + ", spop_coupon_title='" + this.spop_coupon_title + "', spop_describe='" + this.spop_describe + "', spop_link='" + this.spop_link + "', spop_pic='" + this.spop_pic + "', spop_title='" + this.spop_title + "', package_name='" + this.package_name + "', pic_type='" + this.pic_type + "', discount='" + this.discount + "', original_price='" + this.original_price + "', present_price='" + this.present_price + "', new_time_remaining='" + this.new_time_remaining + "', first_price='" + this.first_price + "', second_price='" + this.second_price + "', third_price='" + this.third_price + "', show_coupon_time='" + this.show_coupon_time + "', coupon_type='" + this.coupon_type + "', coupon_load_time='" + this.coupon_load_time + "', coupon_detail_url='" + this.coupon_detail_url + "', to_loading='" + this.to_loading + "', tkl_url='" + this.tkl_url + "', short_link='" + this.short_link + "', tkl_turn_url='" + this.tkl_turn_url + "', coupon_activity_name='" + this.coupon_activity_name + "', auto_open_coupon='" + this.auto_open_coupon + "'}";
        }
    }

    public int getAgl() {
        return this.agl;
    }

    public String getCk() {
        return this.ck;
    }

    public String getCk_v() {
        return this.ck_v;
    }

    public int getCost_time() {
        return this.cost_time;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getGenuine_packagename() {
        return this.genuine_packagename;
    }

    public String getProduct_info() {
        return this.product_info;
    }

    public int getR() {
        return this.f5979r;
    }

    public int getRed_package() {
        return this.red_package;
    }

    public String getReset_heartbeat() {
        return this.reset_heartbeat;
    }

    public String getScrolled_screen() {
        return this.scrolled_screen;
    }

    public String getToast_status() {
        return this.toast_status;
    }

    public void setAgl(int i4) {
        this.agl = i4;
    }

    public void setCk(String str) {
        this.ck = str;
    }

    public void setCk_v(String str) {
        this.ck_v = str;
    }

    public void setCost_time(int i4) {
        this.cost_time = i4;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setGenuine_packagename(String str) {
        this.genuine_packagename = str;
    }

    public void setProduct_info(String str) {
        this.product_info = str;
    }

    public void setR(int i4) {
        this.f5979r = i4;
    }

    public void setRed_package(int i4) {
        this.red_package = i4;
    }

    public void setReset_heartbeat(String str) {
        this.reset_heartbeat = str;
    }

    public void setScrolled_screen(String str) {
        this.scrolled_screen = str;
    }

    public void setToast_status(String str) {
        this.toast_status = str;
    }

    public String toString() {
        return "AccessiblityModel{ck_v='" + this.ck_v + "', r=" + this.f5979r + ", data=" + this.data + ", cost_time=" + this.cost_time + ", agl=" + this.agl + ", ck='" + this.ck + "', red_package='" + this.red_package + "', genuine_packagename='" + this.genuine_packagename + "'}";
    }
}
