package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import java.util.Map;

/* compiled from: TNCConfig.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f719a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f720b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f721c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f722d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f723e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f724f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f725g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f726h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f727i = 1;

    /* renamed from: j  reason: collision with root package name */
    public int f728j = 1;

    /* renamed from: k  reason: collision with root package name */
    public int f729k = 900;

    /* renamed from: l  reason: collision with root package name */
    public int f730l = 120;

    /* renamed from: m  reason: collision with root package name */
    public String f731m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f719a);
        sb.append(" probeEnable: ");
        sb.append(this.f720b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f721c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f722d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f723e);
        sb.append("#");
        sb.append(this.f724f);
        sb.append("#");
        sb.append(this.f725g);
        sb.append(" reqErr: ");
        sb.append(this.f726h);
        sb.append("#");
        sb.append(this.f727i);
        sb.append("#");
        sb.append(this.f728j);
        sb.append(" updateInterval: ");
        sb.append(this.f729k);
        sb.append(" updateRandom: ");
        sb.append(this.f730l);
        sb.append(" httpBlack: ");
        sb.append(this.f731m);
        return sb.toString();
    }
}
