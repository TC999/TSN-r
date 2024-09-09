package com.bytedance.msdk.api.sr.c.w.ev;

import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.t;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.msdk.api.sr.c.w.w.c {

    /* renamed from: a  reason: collision with root package name */
    private double f27537a;
    private List<String> bk;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f27538f;
    private int fp;
    private t fz;
    private int gd;
    private com.bytedance.msdk.api.sr.c.r.w ia;

    /* renamed from: k  reason: collision with root package name */
    private String f27539k;

    /* renamed from: p  reason: collision with root package name */
    private int f27540p;

    /* renamed from: r  reason: collision with root package name */
    private int f27541r;

    /* renamed from: s  reason: collision with root package name */
    private double f27542s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private String f27543t;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f27544w;
    private String xv;
    private int ys;

    public c() {
        t tVar = new t() { // from class: com.bytedance.msdk.api.sr.c.w.ev.c.1
            @Override // com.bytedance.msdk.api.sr.t
            public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
                c.this.c(z3, d4, i4, map);
            }
        };
        this.fz = tVar;
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar != null) {
            xvVar.c(tVar);
        }
    }

    @Nullable
    public String ba() {
        return this.sr;
    }

    @Nullable
    public List<String> bw() {
        return this.bk;
    }

    public void c(String str) {
        this.f27544w = str;
    }

    public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
    }

    @Nullable
    public String ck() {
        return this.f27544w;
    }

    public int eq() {
        return this.f27538f;
    }

    public void f(String str) {
        this.f27539k = str;
    }

    @Nullable
    public String gd() {
        return null;
    }

    public int gw() {
        return this.fp;
    }

    public int m() {
        return this.ys;
    }

    public int me() {
        return this.f27541r;
    }

    public final boolean mt() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar != null) {
            return xvVar.isUseCustomVideo();
        }
        return false;
    }

    public double n() {
        return this.f27542s;
    }

    @Nullable
    public final String oo() {
        try {
            return gd();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public double pr() {
        return this.f27537a;
    }

    public void r(String str) {
        this.f27543t = str;
    }

    public void sr(String str) {
        this.ux = str;
    }

    public boolean up() {
        return this.f27602c.getAdNetworkSlotType() == 2;
    }

    public void ux(int i4) {
        this.f27540p = i4;
    }

    @Nullable
    public com.bytedance.msdk.api.sr.c.r.w vc() {
        return this.ia;
    }

    @Nullable
    public View w() {
        return null;
    }

    public void w(double d4) {
        this.f27542s = d4;
    }

    public int wv() {
        return this.gd;
    }

    @Nullable
    public String wx() {
        return this.f27539k;
    }

    @Nullable
    public String x() {
        return this.f27543t;
    }

    public int xk() {
        return this.f27540p;
    }

    public void xv(String str) {
        this.sr = str;
    }

    @Nullable
    public String y() {
        return this.ux;
    }

    @Nullable
    public String yu() {
        return this.ev;
    }

    @Nullable
    public String z() {
        return this.xv;
    }

    public void c(List<String> list) {
        this.bk = list;
    }

    public void f(int i4) {
        this.ys = i4;
    }

    public void r(int i4) {
        this.fp = i4;
    }

    public void sr(int i4) {
        this.gd = i4;
    }

    public void ux(String str) {
        this.ev = str;
    }

    public void w(String str) {
        this.xv = str;
    }

    public void xv(int i4) {
        this.f27541r = i4;
    }

    public void c(com.bytedance.msdk.api.sr.c.r.w wVar) {
        this.ia = wVar;
    }

    public void w(int i4) {
        this.f27538f = i4;
    }

    public void xv(double d4) {
        this.f27537a = d4;
    }

    public void c(boolean z3) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar != null) {
            xvVar.setExpressAd(z3);
        }
    }

    public final void c(r rVar) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || rVar == null) {
            return;
        }
        xvVar.c(rVar);
    }
}
