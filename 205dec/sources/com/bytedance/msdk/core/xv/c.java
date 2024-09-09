package com.bytedance.msdk.core.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private double f28287c;

    /* renamed from: f  reason: collision with root package name */
    private int f28288f;

    /* renamed from: k  reason: collision with root package name */
    private String f28289k;

    /* renamed from: p  reason: collision with root package name */
    private String f28290p;
    private double sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private double f28292w;
    private double xv;

    /* renamed from: r  reason: collision with root package name */
    private int f28291r = 0;
    private int ev = 0;
    private int gd = 0;

    public c(double d4, double d5, double d6, double d7, int i4, String str) {
        this.f28287c = d4;
        this.f28292w = d5;
        this.xv = d6;
        this.sr = d7;
        this.ux = str;
        this.f28288f = i4;
    }

    private boolean sr() {
        return c(this.f28287c, this.xv);
    }

    private boolean ux() {
        return c(this.f28292w, this.sr);
    }

    public boolean c() {
        return sr();
    }

    public String toString() {
        return "adnName = " + this.f28290p + " adnRit = " + this.f28289k + ", send = " + this.f28291r + ", fill = " + this.ev + ", show = " + this.gd + " localSsr = " + this.f28287c + ", serviceSsr = " + this.xv + ", localSrr = " + this.f28292w + ", serviceSrr = " + this.sr + ", opt = " + this.ux + ", condition = " + this.f28288f + ", compareBehaviorSsr = " + sr() + ", compareBehaviorSrr = " + ux() + ", checkBehaviorRule = " + c();
    }

    public double w() {
        return this.f28287c;
    }

    public double xv() {
        return this.f28292w;
    }

    private boolean c(double d4, double d5) {
        String str = this.ux;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c4 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c4 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c4 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c4 = 3;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return d4 > d5;
            case 1:
                return d4 < d5;
            case 2:
                return d4 >= d5;
            case 3:
                return d4 <= d5;
            case 4:
                return d4 == d5;
            default:
                return true;
        }
    }

    public void w(int i4) {
        this.ev = i4;
    }

    public void xv(int i4) {
        this.gd = i4;
    }

    public void c(int i4) {
        this.f28291r = i4;
    }

    public void w(String str) {
        this.f28289k = str;
    }

    public void c(String str) {
        this.f28290p = str;
    }
}
