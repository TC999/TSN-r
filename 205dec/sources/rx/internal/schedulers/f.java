package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ImmediateScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class f extends rx.h {

    /* renamed from: a  reason: collision with root package name */
    public static final f f63803a = new f();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ImmediateScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    final class a extends h.a implements rx.m {

        /* renamed from: a  reason: collision with root package name */
        final rx.subscriptions.a f63804a = new rx.subscriptions.a();

        a() {
        }

        public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            return d(new l(aVar, this, f.this.b() + timeUnit.toMillis(j4)));
        }

        public rx.m d(rx.functions.a aVar) {
            aVar.call();
            return rx.subscriptions.f.e();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63804a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f63804a.unsubscribe();
        }
    }

    private f() {
    }

    @Override // rx.h
    public h.a a() {
        return new a();
    }
}
