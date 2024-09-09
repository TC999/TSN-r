package com.bytedance.sdk.component.c;

import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.c.j;
import com.bytedance.sdk.component.c.q;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.component.c.u;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements j.c {

    /* renamed from: c  reason: collision with root package name */
    private final ev f29697c;
    private final boolean ev;
    private final boolean gd;

    /* renamed from: p  reason: collision with root package name */
    private final com.bytedance.sdk.component.c.c f29699p;

    /* renamed from: r  reason: collision with root package name */
    private final bk f29700r;

    /* renamed from: w  reason: collision with root package name */
    private final i f29701w;
    private final Map<String, w> xv = new HashMap();
    private final Map<String, sr.w> sr = new HashMap();
    private final List<ia> ux = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Set<sr> f29698f = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        boolean f29706c;

        /* renamed from: w  reason: collision with root package name */
        String f29707w;

        private c(boolean z3, String str) {
            this.f29706c = z3;
            this.f29707w = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, com.bytedance.sdk.component.c.c cVar, q qVar) {
        this.f29699p = cVar;
        this.f29697c = pVar.sr;
        i iVar = new i(qVar, pVar.f29681a, pVar.bk);
        this.f29701w = iVar;
        iVar.c(this);
        iVar.c(pVar.fp);
        this.f29700r = pVar.gd;
        this.ev = pVar.ev;
        this.gd = pVar.ys;
    }

    private ls w(String str, w wVar) {
        if (this.gd) {
            return ls.PRIVATE;
        }
        return this.f29701w.c(this.ev, str, wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public c c(ia iaVar, f fVar) throws Exception {
        w wVar = this.xv.get(iaVar.sr);
        if (wVar != null) {
            try {
                ls w3 = w(fVar.f29659w, wVar);
                fVar.sr = w3;
                if (w3 == null) {
                    bk bkVar = this.f29700r;
                    if (bkVar != null) {
                        bkVar.c(fVar.f29659w, iaVar.sr, 1);
                    }
                    gd.c("Permission denied, call: " + iaVar);
                    throw new fz(-1);
                } else if (wVar instanceof ux) {
                    gd.c("Processing stateless call: " + iaVar);
                    return c(iaVar, (ux) wVar, fVar);
                } else if (wVar instanceof xv) {
                    gd.c("Processing raw call: " + iaVar);
                    return c(iaVar, (xv) wVar, w3);
                }
            } catch (q.c e4) {
                gd.c("No remote permission config fetched, call pending: " + iaVar, e4);
                this.ux.add(iaVar);
                return new c(false, gb.c());
            }
        }
        sr.w wVar2 = this.sr.get(iaVar.sr);
        if (wVar2 != null) {
            sr c4 = wVar2.c();
            c4.c(iaVar.sr);
            ls w4 = w(fVar.f29659w, c4);
            fVar.sr = w4;
            if (w4 != null) {
                gd.c("Processing stateful call: " + iaVar);
                return c(iaVar, c4, fVar);
            }
            gd.c("Permission denied, call: " + iaVar);
            c4.ux();
            throw new fz(-1);
        }
        bk bkVar2 = this.f29700r;
        if (bkVar2 != null) {
            bkVar2.c(fVar.f29659w, iaVar.sr, 2);
        }
        gd.w("Received call: " + iaVar + ", but not registered.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, ux<?, ?> uxVar) {
        uxVar.c(str);
        this.xv.put(str, uxVar);
        gd.c("JsBridge stateless method registered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, sr.w wVar) {
        this.sr.put(str, wVar);
        gd.c("JsBridge stateful method registered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        for (sr srVar : this.f29698f) {
            srVar.f();
        }
        this.f29698f.clear();
        this.xv.clear();
        this.sr.clear();
        this.f29701w.w(this);
    }

    @MainThread
    private c c(ia iaVar, ux uxVar, f fVar) throws Exception {
        return new c(true, gb.c(this.f29697c.c((ev) uxVar.c(c(iaVar.ux, (w) uxVar), fVar))));
    }

    @MainThread
    private c c(final ia iaVar, final sr srVar, f fVar) throws Exception {
        this.f29698f.add(srVar);
        srVar.c(c(iaVar.ux, srVar), fVar, new sr.c() { // from class: com.bytedance.sdk.component.c.r.1
            @Override // com.bytedance.sdk.component.c.sr.c
            public void c(Object obj) {
                if (r.this.f29699p == null) {
                    return;
                }
                r.this.f29699p.w(gb.c(r.this.f29697c.c((ev) obj)), iaVar);
                r.this.f29698f.remove(srVar);
            }

            @Override // com.bytedance.sdk.component.c.sr.c
            public void c(Throwable th) {
                if (r.this.f29699p == null) {
                    return;
                }
                r.this.f29699p.w(gb.c(th), iaVar);
                r.this.f29698f.remove(srVar);
            }
        });
        return new c(false, gb.c());
    }

    @MainThread
    private c c(final ia iaVar, xv xvVar, ls lsVar) throws Exception {
        xvVar.c(iaVar, new u(iaVar.sr, lsVar, new u.c() { // from class: com.bytedance.sdk.component.c.r.2
        }));
        return new c(false, gb.c());
    }

    private Object c(String str, w wVar) throws JSONException {
        return this.f29697c.c(str, c(wVar)[0]);
    }

    private static Type[] c(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
