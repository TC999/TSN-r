package com.bykv.vk.openvk.component.video.c.w;

import com.bykv.vk.openvk.component.video.c.w.a;
import com.bykv.vk.openvk.component.video.c.w.gd;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements k {
    private static final AtomicLong bk = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    protected volatile com.bykv.vk.openvk.component.video.c.w.c.c f25047c;
    protected volatile String ev;

    /* renamed from: f  reason: collision with root package name */
    protected volatile List<gd.w> f25048f;
    protected volatile gd gd;

    /* renamed from: p  reason: collision with root package name */
    protected volatile a f25050p;

    /* renamed from: r  reason: collision with root package name */
    protected volatile String f25051r;
    protected com.bykv.vk.openvk.component.video.c.w.sr.c ux;

    /* renamed from: w  reason: collision with root package name */
    protected final com.bykv.vk.openvk.component.video.c.w.w.xv f25053w;
    protected final AtomicInteger xv = new AtomicInteger();
    protected final AtomicLong sr = new AtomicLong();

    /* renamed from: k  reason: collision with root package name */
    protected volatile boolean f25049k = false;

    /* renamed from: a  reason: collision with root package name */
    public final long f25046a = bk.incrementAndGet();

    /* renamed from: t  reason: collision with root package name */
    private final AtomicInteger f25052t = new AtomicInteger(0);
    private int ys = -1;

    public c(com.bykv.vk.openvk.component.video.c.w.c.c cVar, com.bykv.vk.openvk.component.video.c.w.w.xv xvVar) {
        this.f25047c = cVar;
        this.f25053w = xvVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Boolean bool, String str, Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        if (this.gd != null) {
            return this.gd.xv.f25097c;
        }
        return this.f25047c instanceof com.bykv.vk.openvk.component.video.c.w.c.w ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r() {
        return f() == 1;
    }

    public boolean sr() {
        return this.f25052t.get() == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ux() throws com.bykv.vk.openvk.component.video.c.w.xv.c {
        if (w()) {
            throw new com.bykv.vk.openvk.component.video.c.w.xv.c();
        }
    }

    public boolean w() {
        return this.f25052t.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv() {
        this.f25052t.compareAndSet(0, 2);
    }

    public void c() {
        this.f25052t.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bykv.vk.openvk.component.video.c.w.ux.c c(a.c cVar, int i4, int i5, String str) throws IOException {
        com.bykv.vk.openvk.component.video.c.w.ux.w w3 = com.bykv.vk.openvk.component.video.c.w.ux.xv.c().w();
        com.bykv.vk.openvk.component.video.c.w.ux.ux uxVar = new com.bykv.vk.openvk.component.video.c.w.ux.ux();
        HashMap hashMap = new HashMap();
        uxVar.f25143w = cVar.f25044c;
        uxVar.f25142c = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            uxVar.f25142c = 4;
        }
        List<gd.w> list = this.f25048f;
        if (list != null && !list.isEmpty()) {
            for (gd.w wVar : list) {
                if (!"Range".equalsIgnoreCase(wVar.f25101c) && !"Connection".equalsIgnoreCase(wVar.f25101c) && !"Proxy-Connection".equalsIgnoreCase(wVar.f25101c) && !"Host".equalsIgnoreCase(wVar.f25101c)) {
                    hashMap.put(wVar.f25101c, wVar.f25102w);
                }
            }
        }
        String c4 = com.bykv.vk.openvk.component.video.c.xv.c.c(i4, i5);
        if (c4 != null) {
            hashMap.put("Range", c4);
        }
        if (ux.f25134f) {
            hashMap.put("Cache-Control", "no-cache");
        }
        sr xv = sr.xv();
        f c5 = f.c();
        boolean z3 = this.gd == null;
        xv c6 = z3 ? xv.c() : c5.w();
        xv w4 = z3 ? xv.w() : c5.xv();
        if (c6 != null || w4 != null) {
            if (c6 != null) {
                uxVar.xv = c6.c(cVar.f25045w);
            }
            if (w4 != null) {
                uxVar.sr = w4.c(cVar.f25045w);
            }
        }
        uxVar.ux = hashMap;
        if (this.f25049k) {
            this.f25049k = false;
            return null;
        }
        return w3.c(uxVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, int i5) {
        if (i4 <= 0 || i5 < 0) {
            return;
        }
        int i6 = ux.f25137r;
        int f4 = f();
        if (i6 == 1 || (i6 == 2 && f4 == 1)) {
            int i7 = (int) ((i5 / i4) * 100.0f);
            if (i7 > 100) {
                i7 = 100;
            }
            synchronized (this) {
                if (i7 <= this.ys) {
                    return;
                }
                this.ys = i7;
                com.bykv.vk.openvk.component.video.c.xv.c.c(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.w.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        com.bykv.vk.openvk.component.video.c.w.sr.c cVar2 = cVar.ux;
                        if (cVar2 != null) {
                            cVar2.c(cVar.f25050p, c.this.ys);
                        }
                    }
                });
            }
        }
    }
}
