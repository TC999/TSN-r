package com.bytedance.sdk.component.widget.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: w  reason: collision with root package name */
    private static volatile c f30471w;

    /* renamed from: c  reason: collision with root package name */
    private volatile w f30472c;

    private c() {
    }

    public static c c() {
        if (f30471w == null) {
            synchronized (c.class) {
                if (f30471w == null) {
                    f30471w = new c();
                }
            }
        }
        return f30471w;
    }

    public w w() {
        return this.f30472c;
    }
}
