package com.bykv.vk.openvk.component.video.api.xv;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f24945a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    public String f24946c;

    /* renamed from: f  reason: collision with root package name */
    private String f24947f;
    private long fp;
    private int fz;
    private boolean ia;

    /* renamed from: k  reason: collision with root package name */
    private String f24950k;

    /* renamed from: r  reason: collision with root package name */
    private int f24953r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f24954s;
    private xv sr;

    /* renamed from: t  reason: collision with root package name */
    private List<String> f24955t;

    /* renamed from: u  reason: collision with root package name */
    private int f24956u;
    private xv ux;

    /* renamed from: w  reason: collision with root package name */
    public int f24957w;
    private String ys;
    private int ev = 204800;
    private int gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f24951p = 0;
    public final HashMap<String, Object> xv = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private int f24948i = 10000;

    /* renamed from: q  reason: collision with root package name */
    private int f24952q = 10000;

    /* renamed from: j  reason: collision with root package name */
    private int f24949j = 10000;
    private int ls = 0;
    private JSONObject gb = new JSONObject();

    public sr(String str, xv xvVar, xv xvVar2, int i4, int i5) {
        this.fz = 0;
        this.f24956u = 0;
        this.f24947f = str;
        this.sr = xvVar;
        this.ux = xvVar2;
        this.fz = i4;
        this.f24956u = i5;
    }

    public long a() {
        if (t()) {
            return this.ux.ux();
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar.ux();
        }
        return 0L;
    }

    public boolean bk() {
        if (t()) {
            return this.ux.j();
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar.j();
        }
        return true;
    }

    public JSONObject c() {
        return this.gb;
    }

    public int ev() {
        return this.f24945a;
    }

    public int f() {
        if (t()) {
            return this.ux.fp();
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar.fp();
        }
        return 0;
    }

    public String fp() {
        if (t()) {
            return this.ux.a();
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar.a();
        }
        return null;
    }

    public int fz() {
        return this.f24948i;
    }

    public xv gb() {
        if (t()) {
            return this.ux;
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar;
        }
        return null;
    }

    public int gd() {
        return this.bk;
    }

    public int i() {
        return this.f24949j;
    }

    public String ia() {
        if (t()) {
            return this.ux.ys();
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar.ys();
        }
        return null;
    }

    public xv j() {
        return this.sr;
    }

    public boolean k() {
        return this.ia;
    }

    public xv ls() {
        return this.ux;
    }

    public long p() {
        return this.fp;
    }

    public int q() {
        return this.ls;
    }

    public boolean r() {
        return this.f24954s;
    }

    public int s() {
        return this.fz;
    }

    public String sr() {
        return this.gb.optString("pitaya_msg");
    }

    public boolean t() {
        xv xvVar;
        if (this.f24956u == 1 && (xvVar = this.ux) != null && !TextUtils.isEmpty(xvVar.a())) {
            if (com.bykv.vk.openvk.component.video.api.xv.ux() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.fz == 1) {
                return true;
            }
        }
        return false;
    }

    public int u() {
        return this.f24952q;
    }

    public String ux() {
        return this.f24947f;
    }

    public int w() {
        return this.gb.optInt("pitaya_cache_size", 0);
    }

    public int xv() {
        return this.gb.optInt("pitaya_code", 0);
    }

    public float ys() {
        if (t()) {
            return this.ux.ev();
        }
        xv xvVar = this.sr;
        if (xvVar != null) {
            return xvVar.ev();
        }
        return -1.0f;
    }

    public void c(String str) {
        this.f24947f = str;
    }

    public void ev(int i4) {
        this.f24949j = i4;
    }

    public void gd(int i4) {
        this.ls = i4;
    }

    public void r(int i4) {
        this.f24952q = i4;
    }

    public void sr(String str) {
        this.f24946c = str;
    }

    public void ux(int i4) {
        this.fz = i4;
    }

    public void w(String str) {
        this.f24950k = str;
    }

    public void xv(int i4) {
        this.bk = i4;
    }

    public void c(int i4) {
        this.f24953r = i4;
    }

    public void sr(int i4) {
        this.f24957w = i4;
    }

    public synchronized Object ux(String str) {
        return this.xv.get(str);
    }

    public void w(int i4) {
        this.f24945a = i4;
    }

    public void xv(String str) {
        this.ys = str;
    }

    public void c(boolean z3) {
        this.f24954s = z3;
    }

    public void w(boolean z3) {
        this.ia = z3;
    }

    public void c(List<String> list) {
        this.f24955t = list;
    }

    public void f(int i4) {
        this.f24948i = i4;
    }

    public void c(long j4) {
        this.fp = j4;
    }

    public synchronized void c(String str, Object obj) {
        this.xv.put(str, obj);
    }
}
