package xyz.adscope.common.network.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MainExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public Handler f65035a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f65035a.post(runnable);
    }
}
