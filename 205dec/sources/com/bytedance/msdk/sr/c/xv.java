package com.bytedance.msdk.sr.c;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.msdk.f.ls;
import com.bytedance.msdk.f.wv;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.adapter.c.w f28391c;

    /* renamed from: w  reason: collision with root package name */
    private final Set<String> f28392w = new CopyOnWriteArraySet();
    private final AtomicBoolean xv = new AtomicBoolean(false);

    private synchronized void xv(com.bytedance.msdk.api.sr.p pVar) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            com.bytedance.msdk.sr.w.c.c(w(), new Pair(Boolean.FALSE, th.toString()));
        }
        if (ux()) {
            return;
        }
        String xv = xv();
        if (TextUtils.isEmpty(xv)) {
            Map<String, Object> c4 = c();
            if (c4 != null) {
                c4.put("adn_name", w());
                com.bytedance.msdk.adapter.c.xv c5 = com.bytedance.msdk.sr.w.w.c().c(w(), pVar);
                if (c5 != null) {
                    c(c5, c4);
                    sr();
                    return;
                }
                throw new Exception("configuration is null");
            }
            throw new Exception("adn init getConfig() is null");
        }
        throw new Exception("adn init " + xv);
    }

    protected abstract Map<String, Object> c();

    public synchronized void ev() {
        if (!ux()) {
            f();
        }
    }

    public void f() {
        w((com.bytedance.msdk.api.sr.p) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.msdk.core.k.c r() {
        return com.bytedance.msdk.core.c.w().c(w());
    }

    public final synchronized void sr() {
        this.xv.set(true);
    }

    public final synchronized boolean ux() {
        return this.xv.get();
    }

    protected abstract String w();

    protected abstract String xv();

    private void w(com.bytedance.msdk.api.sr.p pVar) {
        com.bytedance.msdk.core.k.c c4 = com.bytedance.msdk.core.c.w().c(w());
        if (pVar != null || c4 != null || "pangle_custom".equals(w()) || "pangle".equals(w())) {
            xv(pVar);
        }
    }

    public void c(com.bytedance.msdk.api.sr.p pVar) {
        w(pVar);
    }

    public void c(com.bytedance.msdk.api.sr.p pVar, com.bytedance.msdk.adapter.c.w wVar) {
        this.f28391c = wVar;
        w(pVar);
    }

    private synchronized void c(com.bytedance.msdk.adapter.c.xv xvVar, Map<String, Object> map) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==--time: start " + w());
        xvVar.c(com.bytedance.msdk.core.c.getContext(), map, new com.bytedance.msdk.adapter.c.w() { // from class: com.bytedance.msdk.sr.c.xv.1
            @Override // com.bytedance.msdk.adapter.c.w
            public void c() {
                if (xv.this.f28391c != null) {
                    xv.this.f28391c.c();
                }
                if (TextUtils.equals(xv.this.w(), "pangle")) {
                    ls.c(com.bytedance.msdk.core.c.getContext());
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==--time: " + xv.this.w() + ", ----==----- " + elapsedRealtime2);
                if (!xv.this.f28392w.contains(xv.this.w())) {
                    xv.this.f28392w.add(xv.this.w());
                    wv.xv(xv.this.w(), elapsedRealtime2);
                }
                com.bytedance.msdk.sr.w.c.c(xv.this.w(), new Pair(Boolean.TRUE, ""));
            }

            @Override // com.bytedance.msdk.adapter.c.w
            public void c(@NonNull com.bytedance.msdk.api.c cVar) {
                if (xv.this.f28391c != null) {
                    xv.this.f28391c.c(cVar);
                }
                if (cVar != null) {
                    String w3 = xv.this.w();
                    Boolean bool = Boolean.FALSE;
                    com.bytedance.msdk.sr.w.c.c(w3, new Pair(bool, "errorCode = " + cVar.f27444c + " errorMessage = " + cVar.f27445w));
                }
            }
        });
    }
}
