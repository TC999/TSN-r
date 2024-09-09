package com.bytedance.sdk.openadsdk.core.fz;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventDebugUtils;
import com.bytedance.sdk.component.r.c.c;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.eq.i;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    private static final Set<String> ux;

    /* renamed from: c  reason: collision with root package name */
    public static final String f33686c = UUID.randomUUID().toString();

    /* renamed from: w  reason: collision with root package name */
    public static AtomicInteger f33687w = new AtomicInteger(0);
    private static String sr = "_create";
    public static final AtomicBoolean xv = new AtomicBoolean(false);

    static {
        HashSet hashSet = new HashSet();
        ux = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add("show");
    }

    public static void c(Context context, boolean z3) {
        com.bytedance.sdk.component.utils.a.w(sr, EventDebugUtils.DEBUG_LOG_TAG);
        if (!xv.compareAndSet(false, true) && !com.bytedance.sdk.component.r.w.c.c("csj")) {
            com.bytedance.sdk.component.utils.a.w(EventDebugUtils.DEBUG_LOG_TAG, "duplicate log");
            return;
        }
        w(context, z3);
        com.bytedance.sdk.component.utils.a.w(EventDebugUtils.DEBUG_LOG_TAG, "----init log end----- ");
    }

    public static void sr() {
        try {
            com.bytedance.sdk.component.r.w.c.w("csj");
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f(sr, e4.getMessage());
        }
    }

    public static void ux() {
        try {
            com.bytedance.sdk.component.r.w.c.sr("csj");
            com.bytedance.sdk.component.r.w.c.ux("csj");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void w(Context context, boolean z3) {
        if (context == null) {
            return;
        }
        int gb = ls.w().gb();
        gb = (gb <= 0 || gb == Integer.MAX_VALUE) ? 100 : 100;
        int ia = ls.w().ia();
        if (ia > gb) {
            ia = 5;
            gb = 10;
        }
        com.bytedance.sdk.component.r.w.c.c(new c.C0450c().xv(com.bytedance.sdk.component.r.w.sr.w.c.c(ia, gb)).c(com.bytedance.sdk.component.r.w.sr.w.c.c(1, gb)).w(com.bytedance.sdk.component.r.w.sr.w.c.c(1, gb)).w(z3).c("csj").c(context).c(new r()).c(f.f33675c).c(ls.w().fz()).c());
    }

    public static com.bytedance.sdk.openadsdk.core.fz.xv.c xv() {
        return k.f33678c;
    }

    public static void c() {
        com.bytedance.sdk.component.r.w.c.c(false, "csj");
    }

    public static void c(com.bytedance.sdk.component.r.w.sr.c.c cVar, String str, int i4) {
        if (com.bytedance.sdk.component.r.w.c.c("csj")) {
            c(ls.getContext(), com.bytedance.sdk.openadsdk.core.multipro.w.xv());
        }
        if (ls.w().xg()) {
            return;
        }
        com.bytedance.sdk.component.r.w.c.c(cVar, "csj");
    }

    private static void c(String str, com.bytedance.sdk.component.r.w.sr.c.c cVar) {
        if (ls.w().bk()) {
            try {
                cVar.xv(com.bytedance.sdk.component.r.w.xv.c.w(str));
            } catch (Exception e4) {
                com.bytedance.sdk.component.utils.a.xv(e4.getMessage());
            }
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.core.a.c cVar, String str) {
        if (!ls.w().xg() || ux.contains(str)) {
            com.bytedance.sdk.component.r.w.sr.c.c cVar2 = new com.bytedance.sdk.component.r.w.sr.c.c(cVar.sr(), cVar);
            cVar2.w(cVar.f() ? (byte) 1 : (byte) 2);
            cVar2.c((byte) 0);
            c(cVar.xv(), cVar2);
            if (com.bytedance.sdk.component.r.w.c.c("csj")) {
                c(ls.getContext(), com.bytedance.sdk.openadsdk.core.multipro.w.xv());
            }
            com.bytedance.sdk.component.r.w.c.c(cVar2, "csj");
            com.bytedance.sdk.openadsdk.core.ls.xv xvVar = (com.bytedance.sdk.openadsdk.core.ls.xv) AutoService.c(com.bytedance.sdk.openadsdk.core.ls.xv.class);
            if (xvVar != null) {
                xvVar.c(str, cVar2);
            }
        }
    }

    public static void w() {
        com.bytedance.sdk.component.r.w.c.c(f.f33675c, "csj");
    }

    public static void c(String str, List<String> list, boolean z3, Map<String, String> map) {
        if (list == null) {
            return;
        }
        com.bytedance.sdk.component.utils.a.c(" size:" + list.size());
        if (com.bytedance.sdk.component.r.w.c.c("csj")) {
            c(ls.getContext(), com.bytedance.sdk.openadsdk.core.multipro.w.xv());
        }
        com.bytedance.sdk.component.r.w.c.c("csj", str, c(list, i.c()), z3, map);
    }

    public static List<String> c(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                String str2 = (String) arrayList.get(i4);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("{OAID}") || str2.contains("__OAID__")) {
                        str2 = str2.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(str2);
                }
            }
        }
        return list;
    }

    public static void c(String str) {
        if (com.bytedance.sdk.component.r.w.c.c("csj")) {
            c(ls.getContext(), com.bytedance.sdk.openadsdk.core.multipro.w.xv());
        }
        com.bytedance.sdk.component.r.w.c.c("csj", str);
    }
}
