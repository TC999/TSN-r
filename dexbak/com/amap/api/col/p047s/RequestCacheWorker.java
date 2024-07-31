package com.amap.api.col.p047s;

import com.amap.api.col.p047s.RequestCacheControl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.s.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestCacheWorker {

    /* renamed from: a */
    private boolean f6315a = true;

    /* renamed from: b */
    private long f6316b = 86400;

    /* renamed from: c */
    private int f6317c = 10;

    /* renamed from: d */
    private long f6318d = 0;

    /* renamed from: e */
    private final LinkedHashMap<RequestCacheControl.C2097b, Object> f6319e = new LinkedHashMap<>();

    /* renamed from: f */
    private final Object f6320f = new Object();

    /* renamed from: g */
    private final LinkedHashMap<RequestCacheControl.C2097b, Object> f6321g = new LinkedHashMap<>();

    /* renamed from: h */
    private final Object f6322h = new Object();

    /* renamed from: i */
    private ArrayList<String> f6323i = new ArrayList<>();

    public RequestCacheWorker(String... strArr) {
        m52727e(strArr);
    }

    /* renamed from: b */
    private void m52729b() {
        int size = this.f6319e.size();
        if (size <= 0 || size < this.f6317c) {
            return;
        }
        RequestCacheControl.C2097b c2097b = null;
        Iterator<RequestCacheControl.C2097b> it = this.f6319e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RequestCacheControl.C2097b next = it.next();
            if (next != null) {
                c2097b = next;
                break;
            }
        }
        mo52708k(this.f6319e, c2097b);
    }

    /* renamed from: e */
    private void m52727e(String... strArr) {
        this.f6318d = System.currentTimeMillis();
        this.f6319e.clear();
        this.f6323i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.f6323i.add(str);
            }
        }
    }

    /* renamed from: h */
    private void m52726h() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.f6318d) / 1000 > this.f6316b) {
            this.f6319e.clear();
            this.f6318d = currentTimeMillis;
        }
    }

    /* renamed from: i */
    private void m52725i(RequestCacheControl.C2097b c2097b, Object obj) {
        synchronized (this.f6320f) {
            m52729b();
            m52726h();
            this.f6319e.put(c2097b, obj);
        }
    }

    /* renamed from: a */
    public final RequestCacheControl.C2098c m52730a(RequestCacheControl.C2097b c2097b) {
        if (this.f6315a && c2097b != null && m52724j(c2097b)) {
            m52726h();
            synchronized (this.f6320f) {
                if (mo52710f(this.f6319e, c2097b)) {
                    return new RequestCacheControl.C2098c(mo52709g(this.f6319e, c2097b), true);
                }
                synchronized (this.f6322h) {
                    if (mo52710f(this.f6321g, c2097b)) {
                        while (!mo52710f(this.f6319e, c2097b) && mo52710f(this.f6321g, c2097b)) {
                            try {
                                this.f6322h.wait(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        this.f6321g.put(c2097b, null);
                    }
                }
                return new RequestCacheControl.C2098c(mo52709g(this.f6319e, c2097b), false);
            }
        }
        return null;
    }

    /* renamed from: c */
    public void mo52711c(RequestCacheControl.C2096a c2096a) {
        if (c2096a != null) {
            this.f6315a = c2096a.m52753e();
            this.f6316b = c2096a.m52752f();
            this.f6317c = c2096a.m52751g();
        }
    }

    /* renamed from: d */
    public final void m52728d(RequestCacheControl.C2097b c2097b, Object obj) {
        if (this.f6315a && c2097b != null && m52724j(c2097b)) {
            m52725i(c2097b, obj);
            synchronized (this.f6322h) {
                mo52708k(this.f6321g, c2097b);
                this.f6322h.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo52710f(LinkedHashMap<RequestCacheControl.C2097b, Object> linkedHashMap, RequestCacheControl.C2097b c2097b) {
        if (linkedHashMap == null || c2097b == null) {
            return false;
        }
        return linkedHashMap.containsKey(c2097b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public Object mo52709g(LinkedHashMap<RequestCacheControl.C2097b, Object> linkedHashMap, RequestCacheControl.C2097b c2097b) {
        if (linkedHashMap == null || c2097b == null) {
            return null;
        }
        return linkedHashMap.get(c2097b);
    }

    /* renamed from: j */
    public final boolean m52724j(RequestCacheControl.C2097b c2097b) {
        if (c2097b != null && c2097b.f6300a != null) {
            Iterator<String> it = this.f6323i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && c2097b.f6300a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public Object mo52708k(LinkedHashMap<RequestCacheControl.C2097b, Object> linkedHashMap, RequestCacheControl.C2097b c2097b) {
        if (linkedHashMap == null || c2097b == null) {
            return null;
        }
        return linkedHashMap.remove(c2097b);
    }
}
