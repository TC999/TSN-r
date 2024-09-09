package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class F implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static F f6719a;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6721c = new Handler(Looper.myLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Scheduler f6720b = Schedulers.from(this);

    private F() {
    }

    public static synchronized Scheduler a() {
        Scheduler scheduler;
        synchronized (F.class) {
            if (f6719a == null) {
                f6719a = new F();
            }
            scheduler = f6719a.f6720b;
        }
        return scheduler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f6721c.post(runnable);
    }
}
