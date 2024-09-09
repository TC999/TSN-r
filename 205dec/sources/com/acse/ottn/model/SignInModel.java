package com.acse.ottn.model;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SignInModel {
    private String points;

    /* renamed from: r  reason: collision with root package name */
    private int f5984r;
    private List<SignBean> sign = new ArrayList();
    private int sign_in;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class SignBean {
        private String day;
        private String points;
        private int sign;

        public String getDay() {
            return this.day;
        }

        public String getPoints() {
            return this.points;
        }

        public int getSign() {
            return this.sign;
        }

        public void setDay(String str) {
            this.day = str;
        }

        public void setPoints(String str) {
            this.points = str;
        }

        public void setSign(int i4) {
            this.sign = i4;
        }
    }

    public String getPoints() {
        return this.points;
    }

    public int getR() {
        return this.f5984r;
    }

    public List<SignBean> getSign() {
        return this.sign;
    }

    public int getSign_in() {
        return this.sign_in;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setR(int i4) {
        this.f5984r = i4;
    }

    public void setSign(List<SignBean> list) {
        this.sign = list;
    }

    public void setSign_in(int i4) {
        this.sign_in = i4;
    }
}
