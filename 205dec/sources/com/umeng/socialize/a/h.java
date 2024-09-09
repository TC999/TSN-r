package com.umeng.socialize.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMAppScanner.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<Future<?>> f53912a;

    public static void a() {
        Future<?> future;
        WeakReference<Future<?>> weakReference = f53912a;
        if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
            f53912a = new WeakReference<>(j.a(new g()));
        }
    }
}
