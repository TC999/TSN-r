package com.bytedance.sdk.openadsdk.bk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static c f31617c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(String str, String str2);

        void c(String str, String str2, Throwable th);
    }

    public static void c(c cVar) {
        f31617c = cVar;
    }

    public static boolean c() {
        return f31617c != null;
    }

    public static void c(String str, String str2) {
        c cVar = f31617c;
        if (cVar == null) {
            return;
        }
        cVar.c(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        if (f31617c == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f31617c.c(str, str2, th);
    }
}
