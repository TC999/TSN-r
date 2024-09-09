package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: HttpHeaders.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class e {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(a0 a0Var) {
        return a(a0Var.e());
    }

    public static boolean b(a0 a0Var) {
        if (a0Var.k().e().equals("HEAD")) {
            return false;
        }
        int c4 = a0Var.c();
        return (((c4 >= 100 && c4 < 200) || c4 == 204 || c4 == 304) && a(a0Var) == -1 && !"chunked".equalsIgnoreCase(a0Var.a("Transfer-Encoding"))) ? false : true;
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.f1335a) {
            return;
        }
        List<l> a4 = l.a(sVar, rVar);
        if (a4.isEmpty()) {
            return;
        }
        mVar.a(sVar, a4);
    }

    public static int b(String str, int i4) {
        char charAt;
        while (i4 < str.length() && ((charAt = str.charAt(i4)) == ' ' || charAt == '\t')) {
            i4++;
        }
        return i4;
    }

    public static int a(String str, int i4, String str2) {
        while (i4 < str.length() && str2.indexOf(str.charAt(i4)) == -1) {
            i4++;
        }
        return i4;
    }

    public static int a(String str, int i4) {
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
}
