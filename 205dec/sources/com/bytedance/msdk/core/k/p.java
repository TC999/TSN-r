package com.bytedance.msdk.core.k;

import android.text.TextUtils;
import com.bytedance.msdk.f.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p implements Comparable<p> {

    /* renamed from: a  reason: collision with root package name */
    private String f28036a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private String f28037c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f28038f;
    private int fp;
    private Map<String, String> fz;
    private int gd;

    /* renamed from: i  reason: collision with root package name */
    private String f28039i;
    private int ia;

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.msdk.core.gd.gd f28040j;

    /* renamed from: k  reason: collision with root package name */
    private String f28041k;
    private com.bytedance.msdk.core.gd.r ls;

    /* renamed from: p  reason: collision with root package name */
    private String f28042p;

    /* renamed from: q  reason: collision with root package name */
    private int f28043q;

    /* renamed from: r  reason: collision with root package name */
    private int f28044r;

    /* renamed from: s  reason: collision with root package name */
    private ev f28045s;

    /* renamed from: t  reason: collision with root package name */
    private int f28046t;

    /* renamed from: u  reason: collision with root package name */
    private int f28047u;

    /* renamed from: w  reason: collision with root package name */
    private String f28048w;
    private String xv;
    private int ys;
    private String sr = "1";
    private String ux = "0";

    public int a() {
        return this.gd;
    }

    public boolean ba() {
        return this.f28038f == 2;
    }

    public String bk() {
        return this.sr;
    }

    public com.bytedance.msdk.core.gd.r c() {
        return this.ls;
    }

    public ev ck() {
        return this.f28045s;
    }

    public boolean eq() {
        return this.f28038f == 100;
    }

    public int ev() {
        return this.f28046t;
    }

    public String f() {
        return this.f28042p;
    }

    public String fp() {
        return TextUtils.isEmpty(this.f28037c) ? this.f28048w : this.f28037c;
    }

    public boolean fz() {
        int i4 = this.f28038f;
        return i4 == 0 || i4 == 100;
    }

    public String gb() {
        return this.f28041k;
    }

    public int gd() {
        return this.ys;
    }

    public double i() {
        ev evVar = this.f28045s;
        if (evVar != null && !TextUtils.isEmpty(evVar.f())) {
            try {
                return Double.valueOf(this.f28045s.f()).doubleValue();
            } catch (Exception e4) {
                com.bytedance.msdk.adapter.sr.xv.sr("WaterFallConfig", "getServerBiddingLoadEcpm error " + e4.toString());
            }
        }
        return -1.0d;
    }

    public String ia() {
        return this.xv;
    }

    public int j() {
        return this.f28044r;
    }

    public int k() {
        return this.ia;
    }

    public int ls() {
        return this.ev;
    }

    public boolean me() {
        return this.f28038f == 3;
    }

    public String n() {
        return this.f28036a;
    }

    public int p() {
        return this.fp;
    }

    public double q() {
        try {
            return Double.valueOf(this.ux).doubleValue() * Double.valueOf(this.sr).doubleValue();
        } catch (Exception e4) {
            com.bytedance.msdk.adapter.sr.xv.sr("WaterFallConfig", "getEcpm error " + e4.toString());
            return 0.0d;
        }
    }

    public int r() {
        return this.bk;
    }

    public int s() {
        return this.f28038f;
    }

    public p sr() {
        ConcurrentHashMap concurrentHashMap;
        List<String> w3 = a.w();
        p pVar = new p();
        pVar.f28037c = this.f28037c;
        a.c(w3, "mAdnetworkName");
        pVar.xv = this.xv;
        a.c(w3, "mAdnetwokrSlotId");
        pVar.sr = this.sr;
        a.c(w3, "mExchangeRate");
        pVar.ux = this.ux;
        a.c(w3, "mEcpm");
        pVar.f28038f = this.f28038f;
        a.c(w3, "mAdnetworkSlotType");
        pVar.f28044r = this.f28044r;
        a.c(w3, "mLoadSort");
        pVar.ev = this.ev;
        a.c(w3, "mShowSort");
        pVar.gd = this.gd;
        a.c(w3, "mRitType");
        pVar.ys = this.ys;
        a.c(w3, "originType");
        pVar.f28047u = this.f28047u;
        a.c(w3, "mSubAdType");
        pVar.f28042p = this.f28042p;
        a.c(w3, "mLoaderAdapterName");
        pVar.f28041k = this.f28041k;
        a.c(w3, "mWaterfallAbTestParam");
        pVar.f28036a = this.f28036a;
        a.c(w3, "mServerBiddingExtra");
        pVar.bk = this.bk;
        a.c(w3, "adExpiredTime");
        pVar.f28046t = this.f28046t;
        a.c(w3, "ifReuseAds");
        pVar.fp = this.fp;
        a.c(w3, "ifPreRequest");
        pVar.ia = this.ia;
        a.c(w3, "ifIsReady");
        pVar.f28048w = this.f28048w;
        a.c(w3, "mCustomAdnetworkName");
        Map<String, String> map = this.fz;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.fz);
        }
        pVar.fz = concurrentHashMap;
        a.c(w3, "mMultilevelSlotCpm");
        pVar.f28039i = this.f28039i;
        a.c(w3, "mCustomAdapterJson");
        pVar.f28043q = this.f28043q;
        a.c(w3, "mAdnRitTimingMode");
        pVar.ls = this.ls;
        a.c(w3, "mIntervalFreqctlBean");
        pVar.f28040j = this.f28040j;
        a.c(w3, "mIntervalPacingBean");
        a.w(w3, "WaterFallConfig");
        return pVar;
    }

    public String t() {
        return this.f28037c;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.f28037c + "', mCustomAdnetworkName='" + this.f28048w + "', mAdnetwokrSlotId='" + this.xv + "', mExchangeRate=" + this.sr + ", mSlotEcpm=" + this.ux + ", mAdnetworkSlotType=" + this.f28038f + ", mLoadSort=" + this.f28044r + ", mShowSort=" + this.ev + '}';
    }

    public double u() {
        ev evVar = this.f28045s;
        if (evVar != null && !TextUtils.isEmpty(evVar.ux())) {
            try {
                return Double.valueOf(this.f28045s.ux()).doubleValue();
            } catch (Exception e4) {
                com.bytedance.msdk.adapter.sr.xv.sr("WaterFallConfig", "getServerBiddingShowEcpm error " + e4.toString());
            }
        }
        return -1.0d;
    }

    public int ux() {
        return this.f28047u;
    }

    public com.bytedance.msdk.core.gd.gd w() {
        return this.f28040j;
    }

    public boolean wv() {
        return this.f28038f == 0;
    }

    public String xk() {
        return this.f28039i;
    }

    public boolean xv() {
        return this.f28043q == 1;
    }

    public boolean y() {
        return this.f28038f == 1;
    }

    public String ys() {
        return this.f28048w;
    }

    public boolean yu() {
        return com.bytedance.msdk.core.c.w().xv(this.f28037c);
    }

    public Map<String, String> z() {
        return this.fz;
    }

    public void c(com.bytedance.msdk.core.gd.r rVar) {
        this.ls = rVar;
    }

    public void ev(int i4) {
        this.gd = i4;
    }

    public void f(int i4) {
        this.fp = i4;
    }

    public void gd(int i4) {
        this.f28038f = i4;
    }

    public void k(int i4) {
        this.ev = i4;
    }

    public void p(int i4) {
        this.f28044r = i4;
    }

    public void r(int i4) {
        this.ia = i4;
    }

    public void ux(int i4) {
        this.ys = i4;
    }

    public void w(int i4) {
        this.f28047u = i4;
    }

    public void xv(int i4) {
        this.bk = i4;
    }

    public void c(com.bytedance.msdk.core.gd.gd gdVar) {
        this.f28040j = gdVar;
    }

    public void ev(String str) {
        this.f28036a = str;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.ux = str;
    }

    public void gd(String str) {
        this.f28039i = str;
    }

    public void r(String str) {
        this.f28041k = str;
    }

    public void ux(String str) {
        this.xv = str;
    }

    public void w(String str) {
        this.sr = str;
    }

    public void xv(String str) {
        this.f28037c = str;
    }

    public void c(int i4) {
        this.f28043q = i4;
    }

    public void c(String str) {
        this.f28042p = str;
    }

    public void c(ev evVar) {
        this.f28045s = evVar;
    }

    public void c(Map<String, String> map) {
        this.fz = map;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(p pVar) {
        if (pVar != null && this.f28044r <= pVar.j()) {
            return this.f28044r < pVar.j() ? -1 : 0;
        }
        return 1;
    }

    public void sr(int i4) {
        this.f28046t = i4;
    }

    public void sr(String str) {
        this.f28048w = str;
    }
}
