package com.qq.e.comm.plugin.i;

import java.lang.ref.SoftReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SoftReference<a> f44054a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a();
    }

    public static void a(a aVar) {
        f44054a = new SoftReference<>(aVar);
    }

    public static void a() {
        SoftReference<a> softReference = f44054a;
        if (softReference == null) {
            return;
        }
        a aVar = softReference.get();
        if (aVar != null) {
            aVar.a();
        }
        f44054a = null;
    }
}
