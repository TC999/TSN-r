package com.bytedance.sdk.component.ev.xv;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public boolean f29779c = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f29785w = true;
    public Map<String, Integer> xv = null;
    public Map<String, String> sr = null;
    public int ux = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f29780f = 1;

    /* renamed from: r  reason: collision with root package name */
    public int f29783r = 1;
    public int ev = 10;
    public int gd = 1;

    /* renamed from: p  reason: collision with root package name */
    public int f29782p = 1;

    /* renamed from: k  reason: collision with root package name */
    public int f29781k = 900;

    /* renamed from: a  reason: collision with root package name */
    public int f29778a = 120;
    public String bk = null;

    /* renamed from: t  reason: collision with root package name */
    public int f29784t = 0;
    public long ys = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f29779c);
        sb.append(" probeEnable: ");
        sb.append(this.f29785w);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.xv;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.sr;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.ux);
        sb.append("#");
        sb.append(this.f29780f);
        sb.append("#");
        sb.append(this.f29783r);
        sb.append(" reqErr: ");
        sb.append(this.ev);
        sb.append("#");
        sb.append(this.gd);
        sb.append("#");
        sb.append(this.f29782p);
        sb.append(" updateInterval: ");
        sb.append(this.f29781k);
        sb.append(" updateRandom: ");
        sb.append(this.f29778a);
        sb.append(" httpBlack: ");
        sb.append(this.bk);
        return sb.toString();
    }
}
