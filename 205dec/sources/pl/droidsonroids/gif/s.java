package pl.droidsonroids.gif;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeRunnable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final e f61882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(e eVar) {
        this.f61882a = eVar;
    }

    abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f61882a.v()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
