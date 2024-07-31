package p640rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.android.plugins.RxAndroidPlugins;
import p640rx.android.plugins.RxAndroidSchedulersHook;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.functions.Action0;
import p640rx.plugins.RxJavaPlugins;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.android.schedulers.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class LooperScheduler extends Scheduler {

    /* renamed from: a */
    private final Handler f44643a;

    /* compiled from: LooperScheduler.java */
    /* renamed from: rx.android.schedulers.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15504a extends Scheduler.AbstractC15607a {

        /* renamed from: a */
        private final Handler f44644a;

        /* renamed from: b */
        private final RxAndroidSchedulersHook f44645b = RxAndroidPlugins.m1990a().m1989b();

        /* renamed from: c */
        private volatile boolean f44646c;

        C15504a(Handler handler) {
            this.f44644a = handler;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f44646c) {
                return Subscriptions.m342e();
            }
            RunnableC15505b runnableC15505b = new RunnableC15505b(this.f44645b.m1984c(action0), this.f44644a);
            Message obtain = Message.obtain(this.f44644a, runnableC15505b);
            obtain.obj = this;
            this.f44644a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f44646c) {
                this.f44644a.removeCallbacks(runnableC15505b);
                return Subscriptions.m342e();
            }
            return runnableC15505b;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            return mo460F(action0, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f44646c;
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f44646c = true;
            this.f44644a.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LooperScheduler.java */
    /* renamed from: rx.android.schedulers.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class RunnableC15505b implements Runnable, Subscription {

        /* renamed from: a */
        private final Action0 f44647a;

        /* renamed from: b */
        private final Handler f44648b;

        /* renamed from: c */
        private volatile boolean f44649c;

        RunnableC15505b(Action0 action0, Handler handler) {
            this.f44647a = action0;
            this.f44648b = handler;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f44649c;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f44647a.call();
            } catch (Throwable th) {
                if (th instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                RxJavaPlugins.m507c().m508b().m587a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f44649c = true;
            this.f44648b.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LooperScheduler(Looper looper) {
        this.f44643a = new Handler(looper);
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new C15504a(this.f44643a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LooperScheduler(Handler handler) {
        this.f44643a = handler;
    }
}
