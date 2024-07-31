package com.kwad.sdk.api.p367a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.api.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9700b {
    private static final ExecutorService ann = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: Ym */
    private static final Handler f29506Ym = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static Future<?> m28021a(AbstractRunnableC9699a abstractRunnableC9699a) {
        return ann.submit(abstractRunnableC9699a);
    }
}
