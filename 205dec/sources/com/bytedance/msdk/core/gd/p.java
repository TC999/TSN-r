package com.bytedance.msdk.core.gd;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {

    /* renamed from: c  reason: collision with root package name */
    private static final String f28002c = "TTMediationSDK_" + p.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private Map<String, gd> f28003w;
    private com.bytedance.msdk.xv.c.sr<gd> xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static p f28004c = new p();
    }

    public static p c() {
        return c.f28004c;
    }

    public gd w(String str) {
        if (this.xv != null) {
            Map<String, gd> map = this.f28003w;
            gd gdVar = map != null ? map.get(str) : null;
            if (gdVar != null) {
                return gdVar;
            }
            gd query = this.xv.query(str);
            if (query != null) {
                this.f28003w.put(query.w(), query);
            }
            return query;
        }
        return null;
    }

    private p() {
        this.xv = new com.bytedance.msdk.xv.c.ux(com.bytedance.msdk.core.c.getContext());
        this.f28003w = new ConcurrentHashMap();
    }

    public void c(String str, long j4) {
        if (this.xv != null) {
            Map<String, gd> map = this.f28003w;
            gd gdVar = map != null ? map.get(str) : null;
            if (gdVar != null) {
                gdVar.c(j4);
            }
            this.xv.c(str, j4);
        }
    }

    public gd w(String str, String str2) {
        gd gdVar = null;
        if (this.xv != null) {
            Map<String, gd> map = this.f28003w;
            if (map != null) {
                gdVar = map.get(str + "_" + str2);
            }
            if (gdVar != null) {
                return gdVar;
            }
            gd query = this.xv.query(str, str2);
            if (query != null) {
                this.f28003w.put(query.sr(), query);
            }
            return query;
        }
        return null;
    }

    public void c(String str, String str2, long j4) {
        if (this.xv != null) {
            gd gdVar = null;
            Map<String, gd> map = this.f28003w;
            if (map != null) {
                gdVar = map.get(str + "_" + str2);
            }
            if (gdVar != null) {
                gdVar.c(j4);
            }
            this.xv.c(str, str2, j4);
        }
    }

    public void c(String str) {
        if (this.xv != null) {
            Map<String, gd> map = this.f28003w;
            if (map != null) {
                map.remove(str);
            }
            this.xv.delete(str);
        }
    }

    public void c(String str, String str2) {
        if (this.xv != null) {
            Map<String, gd> map = this.f28003w;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.xv.delete(str, str2);
        }
    }

    public void c(gd gdVar) {
        if (this.xv == null || TextUtils.isEmpty(gdVar.p())) {
            return;
        }
        Map<String, gd> map = this.f28003w;
        if (map != null) {
            map.put(gdVar.sr(), gdVar);
        }
        this.xv.w(gdVar);
    }
}
