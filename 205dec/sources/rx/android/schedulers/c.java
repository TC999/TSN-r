package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.h;
import rx.m;
import rx.subscriptions.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LooperScheduler.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f62074a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LooperScheduler.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a extends h.a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f62075a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.android.plugins.b f62076b = rx.android.plugins.a.a().b();

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f62077c;

        a(Handler handler) {
            this.f62075a = handler;
        }

        @Override // rx.h.a
        public m c(rx.functions.a aVar) {
            return e(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.h.a
        public m e(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            if (this.f62077c) {
                return f.e();
            }
            b bVar = new b(this.f62076b.c(aVar), this.f62075a);
            Message obtain = Message.obtain(this.f62075a, bVar);
            obtain.obj = this;
            this.f62075a.sendMessageDelayed(obtain, timeUnit.toMillis(j4));
            if (this.f62077c) {
                this.f62075a.removeCallbacks(bVar);
                return f.e();
            }
            return bVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f62077c;
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f62077c = true;
            this.f62075a.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LooperScheduler.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements Runnable, m {

        /* renamed from: a  reason: collision with root package name */
        private final rx.functions.a f62078a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f62079b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f62080c;

        b(rx.functions.a aVar, Handler handler) {
            this.f62078a = aVar;
            this.f62079b = handler;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f62080c;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f62078a.call();
            } catch (Throwable th) {
                if (th instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                rx.plugins.f.c().b().a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f62080c = true;
            this.f62079b.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Looper looper) {
        this.f62074a = new Handler(looper);
    }

    @Override // rx.h
    public h.a a() {
        return new a(this.f62074a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Handler handler) {
        this.f62074a = handler;
    }
}
