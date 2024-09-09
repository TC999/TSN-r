package com.ss.android.socialbase.downloader.network.c;

import com.ss.android.socialbase.downloader.network.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements r {
    private static final ArrayList<String> ux;

    /* renamed from: c  reason: collision with root package name */
    protected final String f50025c;
    private long ev;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private r f50027k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f50028p;

    /* renamed from: r  reason: collision with root package name */
    private int f50029r;

    /* renamed from: w  reason: collision with root package name */
    protected final long f50030w;
    protected List<com.ss.android.socialbase.downloader.model.xv> xv;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f50026f = null;
    protected final Object sr = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        ux = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add(Headers.KEY_CONTENT_DISPOSITION);
    }

    public xv(String str, List<com.ss.android.socialbase.downloader.model.xv> list, long j4) {
        this.f50025c = str;
        this.xv = list;
        this.f50030w = j4;
    }

    public void c() throws Exception {
        if (this.f50026f != null) {
            return;
        }
        try {
            this.f50028p = true;
            this.f50027k = com.ss.android.socialbase.downloader.downloader.xv.c(this.f50025c, this.xv);
            synchronized (this.sr) {
                if (this.f50027k != null) {
                    HashMap hashMap = new HashMap();
                    this.f50026f = hashMap;
                    c(this.f50027k, hashMap);
                    this.f50029r = this.f50027k.w();
                    this.ev = System.currentTimeMillis();
                    this.gd = c(this.f50029r);
                }
                this.f50028p = false;
                this.sr.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.sr) {
                if (this.f50027k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f50026f = hashMap2;
                    c(this.f50027k, hashMap2);
                    this.f50029r = this.f50027k.w();
                    this.ev = System.currentTimeMillis();
                    this.gd = c(this.f50029r);
                }
                this.f50028p = false;
                this.sr.notifyAll();
                throw th;
            }
        }
    }

    public boolean c(int i4) {
        return i4 >= 200 && i4 < 300;
    }

    public List<com.ss.android.socialbase.downloader.model.xv> ev() {
        return this.xv;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.ev < w.f50022w;
    }

    public Map<String, String> gd() {
        return this.f50026f;
    }

    public boolean r() {
        return this.f50028p;
    }

    public void sr() throws InterruptedException {
        synchronized (this.sr) {
            if (this.f50028p && this.f50026f == null) {
                this.sr.wait();
            }
        }
    }

    public boolean ux() {
        return this.gd;
    }

    public int w() throws IOException {
        return this.f50029r;
    }

    public void xv() {
        r rVar = this.f50027k;
        if (rVar != null) {
            rVar.xv();
        }
    }

    private void c(r rVar, Map<String, String> map) {
        if (rVar == null || map == null) {
            return;
        }
        Iterator<String> it = ux.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, rVar.c(next));
        }
    }

    public String c(String str) {
        Map<String, String> map = this.f50026f;
        if (map != null) {
            return map.get(str);
        }
        r rVar = this.f50027k;
        if (rVar != null) {
            return rVar.c(str);
        }
        return null;
    }
}
