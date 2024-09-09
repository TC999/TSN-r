package com.bytedance.sdk.component.ux.xv;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.ux.a;
import com.bytedance.sdk.component.ux.bk;
import com.bytedance.sdk.component.ux.fz;
import com.bytedance.sdk.component.ux.ia;
import com.bytedance.sdk.component.ux.s;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    private ExecutorService ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.sr f30295f;
    private ia gd;

    /* renamed from: r  reason: collision with root package name */
    private a f30296r;

    /* renamed from: w  reason: collision with root package name */
    private final bk f30297w;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<xv>> f30294c = new ConcurrentHashMap();
    private Map<String, s> xv = new HashMap();
    private Map<String, fz> sr = new HashMap();
    private Map<String, com.bytedance.sdk.component.ux.xv> ux = new HashMap();

    public f(Context context, bk bkVar) {
        this.f30297w = (bk) ev.c(bkVar);
        com.bytedance.sdk.component.ux.xv.c.c.c(context, bkVar.ev());
    }

    private ia a() {
        ia r3 = this.f30297w.r();
        return r3 == null ? new r() : r3;
    }

    private com.bytedance.sdk.component.ux.xv f(com.bytedance.sdk.component.ux.w wVar) {
        com.bytedance.sdk.component.ux.xv f4 = this.f30297w.f();
        return f4 != null ? f4 : new com.bytedance.sdk.component.ux.xv.c.c.w(wVar.ux(), wVar.c(), f());
    }

    private com.bytedance.sdk.component.ux.sr gd() {
        com.bytedance.sdk.component.ux.sr xv = this.f30297w.xv();
        return xv == null ? com.bytedance.sdk.component.ux.w.w.c() : xv;
    }

    private ExecutorService k() {
        ExecutorService w3 = this.f30297w.w();
        return w3 != null ? w3 : com.bytedance.sdk.component.ux.c.xv.c();
    }

    private a p() {
        a c4 = this.f30297w.c();
        return c4 != null ? c4 : com.bytedance.sdk.component.ux.c.w.c();
    }

    private s sr(com.bytedance.sdk.component.ux.w wVar) {
        s sr = this.f30297w.sr();
        if (sr != null) {
            return com.bytedance.sdk.component.ux.xv.c.w.c.c(sr);
        }
        return com.bytedance.sdk.component.ux.xv.c.w.c.c(wVar.w());
    }

    private fz ux(com.bytedance.sdk.component.ux.w wVar) {
        fz ux = this.f30297w.ux();
        return ux != null ? ux : com.bytedance.sdk.component.ux.xv.c.w.ux.c(wVar.w());
    }

    public Collection<s> c() {
        return this.xv.values();
    }

    public ia ev() {
        if (this.gd == null) {
            this.gd = a();
        }
        return this.gd;
    }

    public Map<String, List<xv>> r() {
        return this.f30294c;
    }

    public Collection<fz> w() {
        return this.sr.values();
    }

    public Collection<com.bytedance.sdk.component.ux.xv> xv() {
        return this.ux.values();
    }

    public s c(com.bytedance.sdk.component.ux.w wVar) {
        if (wVar == null) {
            wVar = com.bytedance.sdk.component.ux.xv.c.c.r();
        }
        String file = wVar.ux().toString();
        s sVar = this.xv.get(file);
        if (sVar == null) {
            s sr = sr(wVar);
            this.xv.put(file, sr);
            return sr;
        }
        return sVar;
    }

    public fz w(com.bytedance.sdk.component.ux.w wVar) {
        if (wVar == null) {
            wVar = com.bytedance.sdk.component.ux.xv.c.c.r();
        }
        String file = wVar.ux().toString();
        fz fzVar = this.sr.get(file);
        if (fzVar == null) {
            fz ux = ux(wVar);
            this.sr.put(file, ux);
            return ux;
        }
        return fzVar;
    }

    public com.bytedance.sdk.component.ux.xv xv(com.bytedance.sdk.component.ux.w wVar) {
        if (wVar == null) {
            wVar = com.bytedance.sdk.component.ux.xv.c.c.r();
        }
        String file = wVar.ux().toString();
        com.bytedance.sdk.component.ux.xv xvVar = this.ux.get(file);
        if (xvVar == null) {
            com.bytedance.sdk.component.ux.xv f4 = f(wVar);
            this.ux.put(file, f4);
            return f4;
        }
        return xvVar;
    }

    public ExecutorService f() {
        if (this.ev == null) {
            this.ev = k();
        }
        return this.ev;
    }

    public a ux() {
        if (this.f30296r == null) {
            this.f30296r = p();
        }
        return this.f30296r;
    }

    public com.bytedance.sdk.component.ux.sr sr() {
        if (this.f30295f == null) {
            this.f30295f = gd();
        }
        return this.f30295f;
    }

    public com.bytedance.sdk.component.ux.xv c(String str) {
        return xv(com.bytedance.sdk.component.ux.xv.c.c.c(new File(str)));
    }

    public com.bytedance.sdk.component.ux.xv.w.c c(xv xvVar) {
        ImageView.ScaleType ux = xvVar.ux();
        if (ux == null) {
            ux = com.bytedance.sdk.component.ux.xv.w.c.f30314c;
        }
        ImageView.ScaleType scaleType = ux;
        Bitmap.Config a4 = xvVar.a();
        if (a4 == null) {
            a4 = com.bytedance.sdk.component.ux.xv.w.c.f30315w;
        }
        return new com.bytedance.sdk.component.ux.xv.w.c(xvVar.xv(), xvVar.sr(), scaleType, a4, xvVar.gd(), xvVar.p());
    }
}
