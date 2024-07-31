package com.baidu.mobads.sdk.internal;

/* renamed from: com.baidu.mobads.sdk.internal.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2645c {

    /* renamed from: a */
    private static volatile C2645c f8794a;

    /* renamed from: com.baidu.mobads.sdk.internal.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2646a {

        /* renamed from: a */
        public static final String f8795a = "remote_adserv";

        /* renamed from: b */
        public static final String f8796b = "remote_novel";
    }

    private C2645c() {
    }

    /* renamed from: a */
    public static C2645c m50655a() {
        if (f8794a == null) {
            synchronized (C2645c.class) {
                if (f8794a == null) {
                    f8794a = new C2645c();
                }
            }
        }
        return f8794a;
    }

    /* renamed from: a */
    public C2600ap m50654a(String str) {
        return new C2600ap(str);
    }
}
