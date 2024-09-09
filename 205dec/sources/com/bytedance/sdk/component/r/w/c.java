package com.bytedance.sdk.component.r.w;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.r.c.f;
import com.bytedance.sdk.component.r.c.r;
import com.bytedance.sdk.component.r.c.ux;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, w> f30048c = new ConcurrentHashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private static volatile List<com.bytedance.sdk.component.r.c.xv> f30049w = new ArrayList();
    private static ConcurrentHashMap<String, ux> xv = new ConcurrentHashMap<>();

    public static r c(com.bytedance.sdk.component.r.c.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.ux()) && cVar.getContext() != null) {
            ConcurrentHashMap<String, w> concurrentHashMap = f30048c;
            w wVar = concurrentHashMap.get(cVar.ux());
            if (wVar == null) {
                wVar = new w(cVar);
            } else {
                wVar.w(cVar);
            }
            concurrentHashMap.put(cVar.ux(), wVar);
            com.bytedance.sdk.component.r.w.xv.xv.c("init  end", cVar.ux());
            return wVar;
        }
        Log.e("log_error", "config or adLogFrom or context is null");
        return null;
    }

    public static void f(String str) {
        xv(str).xv();
    }

    public static ux r(String str) {
        ux uxVar = xv.get(str);
        if (uxVar == null && (uxVar = xv(str).ux()) != null) {
            xv.put(str, uxVar);
        }
        return uxVar;
    }

    public static void sr(String str) {
        xv(str).w();
    }

    public static void ux(String str) {
        xv(str).sr();
    }

    public static void w(String str) {
        Log.d("log_start", "AdLogManager#start");
        c(false, str);
        xv(str).c();
    }

    public static r xv(String str) {
        ConcurrentHashMap<String, w> concurrentHashMap = f30048c;
        w wVar = concurrentHashMap.get(str);
        if (wVar == null) {
            wVar = new w();
        }
        concurrentHashMap.put(str, wVar);
        return wVar;
    }

    public static void c(f fVar, String str) {
        xv(str).c(fVar);
    }

    public static void c(boolean z3, String str) {
        xv(str).c(z3);
    }

    public static List<com.bytedance.sdk.component.r.c.xv> c() {
        return f30049w;
    }

    public static void c(com.bytedance.sdk.component.r.c.xv xvVar) {
        if (xvVar != null) {
            f30049w.add(xvVar);
        }
    }

    public static boolean c(String str) {
        w wVar = f30048c.get(str);
        return wVar == null || wVar.ux() == null || wVar.f() == null || wVar.r() == null;
    }

    public static void c(String str, String str2) {
        xv(str).c(str2);
    }

    public static void c(String str, String str2, List<String> list, boolean z3, Map<String, String> map) {
        xv(str).c(str2, list, z3, map);
    }

    public static void c(com.bytedance.sdk.component.r.c.w wVar, String str) {
        xv(str).c(wVar);
    }
}
