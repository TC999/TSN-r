package pl.droidsonroids.gif;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: pl.droidsonroids.gif.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class SafeRunnable implements Runnable {

    /* renamed from: a */
    final GifDrawable f44469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeRunnable(GifDrawable gifDrawable) {
        this.f44469a = gifDrawable;
    }

    /* renamed from: a */
    abstract void mo2363a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f44469a.m2425v()) {
                return;
            }
            mo2363a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
