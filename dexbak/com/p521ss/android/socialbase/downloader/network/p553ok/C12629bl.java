package com.p521ss.android.socialbase.downloader.network.p553ok;

import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12620h;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.network.ok.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12629bl implements InterfaceC12620h {

    /* renamed from: n */
    private static final ArrayList<String> f35583n;

    /* renamed from: a */
    protected final long f35584a;

    /* renamed from: bl */
    protected List<C12601bl> f35585bl;

    /* renamed from: h */
    private int f35586h;

    /* renamed from: k */
    private boolean f35587k;

    /* renamed from: ok */
    protected final String f35589ok;

    /* renamed from: p */
    private long f35590p;

    /* renamed from: q */
    private boolean f35591q;

    /* renamed from: r */
    private InterfaceC12620h f35592r;

    /* renamed from: kf */
    private Map<String, String> f35588kf = null;

    /* renamed from: s */
    protected final Object f35593s = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f35583n = arrayList;
        arrayList.add("Content-Length");
        arrayList.add(HttpHeaders.Names.CONTENT_RANGE);
        arrayList.add(HttpHeaders.Names.TRANSFER_ENCODING);
        arrayList.add(HttpHeaders.Names.ACCEPT_RANGES);
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public C12629bl(String str, List<C12601bl> list, long j) {
        this.f35589ok = str;
        this.f35585bl = list;
        this.f35584a = j;
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
    /* renamed from: a */
    public int mo16918a() throws IOException {
        return this.f35586h;
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
    /* renamed from: bl */
    public void mo16917bl() {
        InterfaceC12620h interfaceC12620h = this.f35592r;
        if (interfaceC12620h != null) {
            interfaceC12620h.mo16917bl();
        }
    }

    /* renamed from: h */
    public boolean m16934h() {
        return this.f35587k;
    }

    /* renamed from: kf */
    public boolean m16933kf() {
        return System.currentTimeMillis() - this.f35590p < C12626a.f35577a;
    }

    /* renamed from: n */
    public boolean m16932n() {
        return this.f35591q;
    }

    /* renamed from: ok */
    public void m16931ok() throws Exception {
        if (this.f35588kf != null) {
            return;
        }
        try {
            this.f35587k = true;
            this.f35592r = C12490bl.m17775ok(this.f35589ok, this.f35585bl);
            synchronized (this.f35593s) {
                if (this.f35592r != null) {
                    HashMap hashMap = new HashMap();
                    this.f35588kf = hashMap;
                    m16929ok(this.f35592r, hashMap);
                    this.f35586h = this.f35592r.mo16918a();
                    this.f35590p = System.currentTimeMillis();
                    this.f35591q = m16930ok(this.f35586h);
                }
                this.f35587k = false;
                this.f35593s.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f35593s) {
                if (this.f35592r != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f35588kf = hashMap2;
                    m16929ok(this.f35592r, hashMap2);
                    this.f35586h = this.f35592r.mo16918a();
                    this.f35590p = System.currentTimeMillis();
                    this.f35591q = m16930ok(this.f35586h);
                }
                this.f35587k = false;
                this.f35593s.notifyAll();
                throw th;
            }
        }
    }

    /* renamed from: ok */
    public boolean m16930ok(int i) {
        return i >= 200 && i < 300;
    }

    /* renamed from: p */
    public List<C12601bl> m16928p() {
        return this.f35585bl;
    }

    /* renamed from: q */
    public Map<String, String> m16927q() {
        return this.f35588kf;
    }

    /* renamed from: s */
    public void m16926s() throws InterruptedException {
        synchronized (this.f35593s) {
            if (this.f35587k && this.f35588kf == null) {
                this.f35593s.wait();
            }
        }
    }

    /* renamed from: ok */
    private void m16929ok(InterfaceC12620h interfaceC12620h, Map<String, String> map) {
        if (interfaceC12620h == null || map == null) {
            return;
        }
        Iterator<String> it = f35583n.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, interfaceC12620h.mo16912ok(next));
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
    /* renamed from: ok */
    public String mo16912ok(String str) {
        Map<String, String> map = this.f35588kf;
        if (map != null) {
            return map.get(str);
        }
        InterfaceC12620h interfaceC12620h = this.f35592r;
        if (interfaceC12620h != null) {
            return interfaceC12620h.mo16912ok(str);
        }
        return null;
    }
}
