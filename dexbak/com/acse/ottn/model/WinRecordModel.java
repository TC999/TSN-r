package com.acse.ottn.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class WinRecordModel {

    /* renamed from: r */
    private int f2906r;
    private List<RecordBean> record = new ArrayList();

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class RecordBean {
        private String appName;
        private String deeplink;
        private String des;
        private String end_time;
        private String img;
        private String link;
        private String start_time;
        private String title;
        private String used;

        public String getAppName() {
            return this.appName;
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public String getDes() {
            return this.des;
        }

        public String getEnd_time() {
            return this.end_time;
        }

        public String getImg() {
            return this.img;
        }

        public String getLink() {
            return this.link;
        }

        public String getStart_time() {
            return this.start_time;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUsed() {
            return this.used;
        }

        public void setAppName(String str) {
            this.appName = str;
        }

        public void setDeeplink(String str) {
            this.deeplink = str;
        }

        public void setDes(String str) {
            this.des = str;
        }

        public void setEnd_time(String str) {
            this.end_time = str;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setStart_time(String str) {
            this.start_time = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUsed(String str) {
            this.used = str;
        }
    }

    public int getR() {
        return this.f2906r;
    }

    public List<RecordBean> getRecord() {
        return this.record;
    }

    public void setR(int i) {
        this.f2906r = i;
    }

    public void setRecord(List<RecordBean> list) {
        this.record = list;
    }
}
