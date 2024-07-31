package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* renamed from: com.acse.ottn.util.F */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ExecutorC1627F implements Executor {

    /* renamed from: a */
    private static ExecutorC1627F f3146a;

    /* renamed from: c */
    private final Handler f3148c = new Handler(Looper.myLooper());

    /* renamed from: b */
    private final Scheduler f3147b = Schedulers.from(this);

    private ExecutorC1627F() {
    }

    /* renamed from: a */
    public static synchronized Scheduler m56271a() {
        Scheduler scheduler;
        synchronized (ExecutorC1627F.class) {
            if (f3146a == null) {
                f3146a = new ExecutorC1627F();
            }
            scheduler = f3146a.f3147b;
        }
        return scheduler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f3148c.post(runnable);
    }
}
