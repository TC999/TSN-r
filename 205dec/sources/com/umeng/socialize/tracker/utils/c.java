package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TaskPool.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f54205a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static ExecutorService f54206b = Executors.newFixedThreadPool(1);

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f54206b.execute(runnable);
        }
    }
}
