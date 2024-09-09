package com.bytedance.msdk.core.t;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, InterfaceC0420c> f28188c = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.msdk.core.t.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0420c {
        void c();

        void c(String str);
    }

    public static void c(String str) {
        InterfaceC0420c w3;
        if (TextUtils.isEmpty(str) || (w3 = w(str)) == null) {
            return;
        }
        w3.c();
    }

    private static InterfaceC0420c w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f28188c.remove(str);
    }

    public static void c(String str, String str2) {
        InterfaceC0420c w3;
        if (TextUtils.isEmpty(str) || (w3 = w(str)) == null) {
            return;
        }
        w3.c(str2);
    }
}
