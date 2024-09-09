package com.bytedance.sdk.component.r.w.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f30081c;

    public static w c(com.bytedance.sdk.component.r.c.ux uxVar) {
        if (f30081c == null) {
            synchronized (w.class) {
                if (f30081c == null) {
                    f30081c = new xv(new f(uxVar), uxVar);
                }
            }
        }
        return f30081c;
    }
}
