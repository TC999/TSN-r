package com.acse.ottn;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h implements Executor {

    /* renamed from: c  reason: collision with root package name */
    public static h f5707c;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f5709b = new Handler(Looper.myLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Scheduler f5708a = Schedulers.from(this);

    public static synchronized Scheduler a() {
        Scheduler scheduler;
        synchronized (h.class) {
            if (f5707c == null) {
                f5707c = new h();
            }
            scheduler = f5707c.f5708a;
        }
        return scheduler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f5709b.post(runnable);
    }
}
