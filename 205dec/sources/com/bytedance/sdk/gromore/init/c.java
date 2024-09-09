package com.bytedance.sdk.gromore.init;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static int c() {
        return eq.f33190w;
    }

    public static String sr() {
        return "6.1.0.6";
    }

    public static boolean ux() {
        return DispatchAdSdkInitializerHolder.isInitSuccess();
    }

    public static me w() {
        Manager csjManger = DispatchAdSdkInitializerHolder.getCsjManger();
        if (csjManger instanceof me) {
            return (me) csjManger;
        }
        return null;
    }

    public static String xv() {
        return eq.xv;
    }

    public static void c(int i4) {
        me w3 = w();
        if (w3 != null) {
            w3.c(i4);
        }
    }

    public static void c(boolean z3) {
        me w3 = w();
        if (w3 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z3);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        w3.c(ValueSet.class, bundle);
    }
}
