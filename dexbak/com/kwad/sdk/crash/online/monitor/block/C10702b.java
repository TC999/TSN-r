package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10702b {
    private static List<String> aGC = null;
    private static List<String> aGD = null;
    private static int aGE = 5;

    /* renamed from: a */
    public static void m25088a(C10696a c10696a) {
        aGC = new ArrayList();
        List<String> list = c10696a.aGP;
        if (list != null && !list.isEmpty()) {
            aGC.addAll(c10696a.aGP);
        } else {
            aGC.add("com.kwad");
            aGC.add("com.kwai");
            aGC.add("com.ksad");
            aGC.add("tkruntime");
            aGC.add("tachikoma");
            aGC.add("kuaishou");
        }
        aGE = c10696a.aGU;
        aGD = new ArrayList();
        List<String> list2 = c10696a.aGO;
        if (list2 != null && !list2.isEmpty()) {
            aGD.addAll(c10696a.aGO);
            return;
        }
        aGD.add("android.");
        aGD.add("androidx.");
        aGD.add("org.");
        aGD.add("java.");
    }

    /* renamed from: fs */
    private static boolean m25087fs(String str) {
        List<String> list = aGD;
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ft */
    private static boolean m25086ft(String str) {
        List<String> list = aGC;
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: fu */
    public static String m25085fu(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(ShellAdbUtils.f33810d);
        C10331c.m26254d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z = false;
        int i = 0;
        for (String str2 : split) {
            if (z || !m25087fs(str2)) {
                if (i >= aGE) {
                    return "";
                }
                if (m25086ft(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
