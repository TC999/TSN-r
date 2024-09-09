package cn.jiguang.cd;

import android.os.Handler;
import android.os.Looper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f3286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        this(Looper.getMainLooper());
    }

    f(Looper looper) {
        this.f3286a = new Handler(looper);
    }

    @Override // cn.jiguang.cd.e
    public Thread a() {
        return this.f3286a.getLooper().getThread();
    }

    @Override // cn.jiguang.cd.e
    public void a(Runnable runnable) {
        this.f3286a.post(runnable);
    }
}
