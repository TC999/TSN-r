package com.acse.ottn.model;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class IntegralModel {
    private List<PointsListBean> points_list;

    /* renamed from: r  reason: collision with root package name */
    private int f5982r;
    private String total_points;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class PointsListBean {
        private String ctime;
        private String des;
        private String points;
        private String status;

        public String getCtime() {
            return this.ctime;
        }

        public String getDes() {
            return this.des;
        }

        public String getPoints() {
            return this.points;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCtime(String str) {
            this.ctime = str;
        }

        public void setDes(String str) {
            this.des = str;
        }

        public void setPoints(String str) {
            this.points = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String toString() {
            return "PointsListBean{des='" + this.des + "', ctime='" + this.ctime + "', points='" + this.points + "', status='" + this.status + "'}";
        }
    }

    public List<PointsListBean> getPoints_list() {
        return this.points_list;
    }

    public int getR() {
        return this.f5982r;
    }

    public String getTotal_points() {
        return this.total_points;
    }

    public void setPoints_list(List<PointsListBean> list) {
        this.points_list = list;
    }

    public void setR(int i4) {
        this.f5982r = i4;
    }

    public void setTotal_points(String str) {
        this.total_points = str;
    }

    public String toString() {
        return "IntegralModel{r=" + this.f5982r + ", total_points='" + this.total_points + "', points_list=" + this.points_list + '}';
    }
}
