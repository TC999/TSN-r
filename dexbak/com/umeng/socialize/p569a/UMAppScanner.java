package com.umeng.socialize.p569a;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* renamed from: com.umeng.socialize.a.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMAppScanner {

    /* renamed from: a */
    private static WeakReference<Future<?>> f39323a;

    /* renamed from: a */
    public static void m13389a() {
        Future<?> future;
        WeakReference<Future<?>> weakReference = f39323a;
        if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
            f39323a = new WeakReference<>(C13312j.m13385a(new UMAppScanTask()));
        }
    }
}
