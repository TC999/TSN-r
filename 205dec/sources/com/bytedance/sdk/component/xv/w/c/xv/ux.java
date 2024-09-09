package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.bk;
import com.bytedance.sdk.component.xv.w.fz;
import com.bytedance.sdk.component.xv.w.s;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ux {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f30966c = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long c(ba baVar) {
        return c(baVar.r());
    }

    public static Set<String> w(s sVar) {
        Set<String> emptySet = Collections.emptySet();
        int c4 = sVar.c();
        for (int i4 = 0; i4 < c4; i4++) {
            if ("Vary".equalsIgnoreCase(sVar.c(i4))) {
                String w3 = sVar.w(i4);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : w3.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static boolean xv(ba baVar) {
        if (baVar.c().w().equals("HEAD")) {
            return false;
        }
        int xv = baVar.xv();
        return (((xv >= 100 && xv < 200) || xv == 204 || xv == 304) && c(baVar) == -1 && !"chunked".equalsIgnoreCase(baVar.c("Transfer-Encoding"))) ? false : true;
    }

    public static long c(s sVar) {
        return c(sVar.c("Content-Length"));
    }

    private static long c(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static s c(s sVar, s sVar2) {
        Set<String> w3 = w(sVar2);
        if (w3.isEmpty()) {
            return new s.c().c();
        }
        s.c cVar = new s.c();
        int c4 = sVar.c();
        for (int i4 = 0; i4 < c4; i4++) {
            String c5 = sVar.c(i4);
            if (w3.contains(c5)) {
                cVar.c(c5, sVar.w(i4));
            }
        }
        return cVar.c();
    }

    public static s w(ba baVar) {
        return c(baVar.p().c().xv(), baVar.r());
    }

    public static void c(bk bkVar, fz fzVar, s sVar) {
        if (bkVar == bk.f30728c) {
            return;
        }
        List<com.bytedance.sdk.component.xv.w.a> c4 = com.bytedance.sdk.component.xv.w.a.c(fzVar, sVar);
        if (c4.isEmpty()) {
            return;
        }
        bkVar.c(fzVar, c4);
    }

    public static int w(String str, int i4) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i4;
        }
    }

    public static int c(String str, int i4, String str2) {
        while (i4 < str.length() && str2.indexOf(str.charAt(i4)) == -1) {
            i4++;
        }
        return i4;
    }

    public static int c(String str, int i4) {
        char charAt;
        while (i4 < str.length() && ((charAt = str.charAt(i4)) == ' ' || charAt == '\t')) {
            i4++;
        }
        return i4;
    }
}
