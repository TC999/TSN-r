package com.ss.android.socialbase.downloader.network.ok;

import com.ss.android.socialbase.downloader.network.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements h {

    /* renamed from: n  reason: collision with root package name */
    private static final ArrayList<String> f50039n;

    /* renamed from: a  reason: collision with root package name */
    protected final long f50040a;
    protected List<com.ss.android.socialbase.downloader.model.bl> bl;

    /* renamed from: h  reason: collision with root package name */
    private int f50041h;

    /* renamed from: k  reason: collision with root package name */
    private boolean f50042k;
    protected final String ok;

    /* renamed from: p  reason: collision with root package name */
    private long f50043p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f50044q;

    /* renamed from: r  reason: collision with root package name */
    private h f50045r;
    private Map<String, String> kf = null;

    /* renamed from: s  reason: collision with root package name */
    protected final Object f50046s = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f50039n = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add(Headers.KEY_CONTENT_DISPOSITION);
    }

    public bl(String str, List<com.ss.android.socialbase.downloader.model.bl> list, long j4) {
        this.ok = str;
        this.bl = list;
        this.f50040a = j4;
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public int a() throws IOException {
        return this.f50041h;
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public void bl() {
        h hVar = this.f50045r;
        if (hVar != null) {
            hVar.bl();
        }
    }

    public boolean h() {
        return this.f50042k;
    }

    public boolean kf() {
        return System.currentTimeMillis() - this.f50043p < a.f50036a;
    }

    public boolean n() {
        return this.f50044q;
    }

    public void ok() throws Exception {
        if (this.kf != null) {
            return;
        }
        try {
            this.f50042k = true;
            this.f50045r = com.ss.android.socialbase.downloader.downloader.bl.ok(this.ok, this.bl);
            synchronized (this.f50046s) {
                if (this.f50045r != null) {
                    HashMap hashMap = new HashMap();
                    this.kf = hashMap;
                    ok(this.f50045r, hashMap);
                    this.f50041h = this.f50045r.a();
                    this.f50043p = System.currentTimeMillis();
                    this.f50044q = ok(this.f50041h);
                }
                this.f50042k = false;
                this.f50046s.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f50046s) {
                if (this.f50045r != null) {
                    HashMap hashMap2 = new HashMap();
                    this.kf = hashMap2;
                    ok(this.f50045r, hashMap2);
                    this.f50041h = this.f50045r.a();
                    this.f50043p = System.currentTimeMillis();
                    this.f50044q = ok(this.f50041h);
                }
                this.f50042k = false;
                this.f50046s.notifyAll();
                throw th;
            }
        }
    }

    public boolean ok(int i4) {
        return i4 >= 200 && i4 < 300;
    }

    public List<com.ss.android.socialbase.downloader.model.bl> p() {
        return this.bl;
    }

    public Map<String, String> q() {
        return this.kf;
    }

    public void s() throws InterruptedException {
        synchronized (this.f50046s) {
            if (this.f50042k && this.kf == null) {
                this.f50046s.wait();
            }
        }
    }

    private void ok(h hVar, Map<String, String> map) {
        if (hVar == null || map == null) {
            return;
        }
        Iterator<String> it = f50039n.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, hVar.ok(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public String ok(String str) {
        Map<String, String> map = this.kf;
        if (map != null) {
            return map.get(str);
        }
        h hVar = this.f50045r;
        if (hVar != null) {
            return hVar.ok(str);
        }
        return null;
    }
}
