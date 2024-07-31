package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.umeng.socialize.tracker.utils.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TaskPool {

    /* renamed from: a */
    private static final int f39631a = 1;

    /* renamed from: b */
    private static ExecutorService f39632b = Executors.newFixedThreadPool(1);

    /* renamed from: a */
    public static void m13213a(Runnable runnable) {
        if (runnable != null) {
            f39632b.execute(runnable);
        }
    }
}
