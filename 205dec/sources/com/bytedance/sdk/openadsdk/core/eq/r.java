package com.bytedance.sdk.openadsdk.core.eq;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ia;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, c> f33299c = Collections.synchronizedMap(new HashMap());

    /* renamed from: w  reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.ia f33300w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(String str);
    }

    static /* synthetic */ com.bytedance.sdk.openadsdk.core.ia c() {
        return w();
    }

    private static c w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f33299c.remove(str);
    }

    public static void c(String str, String[] strArr, c cVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(str, strArr);
    }

    private static com.bytedance.sdk.openadsdk.core.ia w() {
        if (f33300w == null) {
            f33300w = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(com.bytedance.sdk.openadsdk.core.ls.getContext()).c(4));
        }
        return f33300w;
    }

    public static void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.xv().execute(new com.bytedance.sdk.component.gd.p("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.eq.r.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.a.w("MultiProcess", "handleYes-1\uff0ckey=" + str);
                        r.c().w(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        c w3 = w(str);
        if (w3 == null) {
            return;
        }
        w3.c();
    }

    public static void c(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.xv().execute(new com.bytedance.sdk.component.gd.p("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.eq.r.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.a.w("MultiProcess", "handleNo-1\uff0ckey=" + str + "\uff0cpermission=" + str2);
                        r.c().w(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        c w3 = w(str);
        if (w3 == null) {
            return;
        }
        w3.c(str2);
    }

    private static void c(final String str, final c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("addListener") { // from class: com.bytedance.sdk.openadsdk.core.eq.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.a.f("MultiProcess", "getListenerManager().registerPermissionListener...");
                        r.c().c(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.w(cVar));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        com.bytedance.sdk.component.utils.a.f("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            f33299c.put(str, cVar);
        }
    }
}
