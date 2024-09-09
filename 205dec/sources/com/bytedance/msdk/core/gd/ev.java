package com.bytedance.msdk.core.gd;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27992c = "TTMediationSDK_" + ev.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private Map<String, r> f27993w;
    private com.bytedance.msdk.xv.c.w<r> xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static ev f27994c = new ev();
    }

    public static ev c() {
        return c.f27994c;
    }

    public r w(String str) {
        if (this.xv != null) {
            Map<String, r> map = this.f27993w;
            r rVar = map != null ? map.get(str) : null;
            if (rVar != null) {
                return rVar;
            }
            r query = this.xv.query(str);
            if (query != null) {
                Map<String, r> map2 = this.f27993w;
                if (map2 != null) {
                    map2.put(query.sr(), query);
                }
                return query;
            }
        }
        return null;
    }

    private ev() {
        this.xv = new com.bytedance.msdk.xv.c.xv(com.bytedance.msdk.core.c.getContext());
        this.f27993w = new ConcurrentHashMap();
    }

    public void c(String str) {
        if (this.xv != null) {
            Map<String, r> map = this.f27993w;
            if (map != null) {
                map.remove(str);
            }
            this.xv.delete(str);
        }
    }

    public void c(String str, String str2) {
        if (this.xv != null) {
            Map<String, r> map = this.f27993w;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.xv.delete(str, str2);
        }
    }

    public r w(String str, String str2) {
        r rVar;
        if (this.xv != null) {
            Map<String, r> map = this.f27993w;
            if (map != null) {
                rVar = map.get(str + "_" + str2);
            } else {
                rVar = null;
            }
            if (rVar != null) {
                return rVar;
            }
            r query = this.xv.query(str, str2);
            if (query != null) {
                Map<String, r> map2 = this.f27993w;
                if (map2 != null) {
                    map2.put(query.sr(), query);
                }
                return query;
            }
        }
        return null;
    }

    public void c(r rVar) {
        r w3;
        ux uxVar;
        if (rVar.c()) {
            w3 = w(rVar.w(), rVar.xv());
        } else {
            w3 = w(rVar.w());
        }
        if (w3 == null) {
            if (this.xv != null) {
                Map<String, r> map = this.f27993w;
                if (map != null) {
                    map.put(rVar.sr(), rVar);
                }
                this.xv.w(rVar);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (ux uxVar2 : w3.k()) {
            hashMap.put(uxVar2.xv(), uxVar2);
        }
        for (ux uxVar3 : rVar.k()) {
            if (hashMap.containsKey(uxVar3.xv()) && (uxVar = (ux) hashMap.get(uxVar3.xv())) != null) {
                uxVar3.c(uxVar);
            }
        }
        Map<String, r> map2 = this.f27993w;
        if (map2 != null) {
            map2.put(rVar.sr(), rVar);
        }
        w(rVar);
    }

    public void w(r rVar) {
        if (this.xv != null) {
            Map<String, r> map = this.f27993w;
            if (map != null) {
                map.put(rVar.sr(), rVar);
            }
            this.xv.c(rVar);
        }
    }

    public void c(r rVar, String str, int i4) {
        if (this.xv != null) {
            rVar.c(str, i4);
            Map<String, r> map = this.f27993w;
            if (map != null) {
                map.put(rVar.sr(), rVar);
            }
            this.xv.c(rVar);
        }
    }

    public void c(r rVar, String str, long j4) {
        if (this.xv != null) {
            rVar.c(str, j4);
            Map<String, r> map = this.f27993w;
            if (map != null) {
                map.put(rVar.sr(), rVar);
            }
            this.xv.c(rVar);
        }
    }
}
