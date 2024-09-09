package com.baidu.mobads.sdk.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f12585a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f12586a = "remote_adserv";

        /* renamed from: b  reason: collision with root package name */
        public static final String f12587b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f12585a == null) {
            synchronized (c.class) {
                if (f12585a == null) {
                    f12585a = new c();
                }
            }
        }
        return f12585a;
    }

    public as a(String str) {
        return new as(str);
    }
}
