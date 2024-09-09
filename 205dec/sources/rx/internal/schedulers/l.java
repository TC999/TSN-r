package rx.internal.schedulers;

import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SleepingAction.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
class l implements rx.functions.a {

    /* renamed from: a  reason: collision with root package name */
    private final rx.functions.a f63848a;

    /* renamed from: b  reason: collision with root package name */
    private final h.a f63849b;

    /* renamed from: c  reason: collision with root package name */
    private final long f63850c;

    public l(rx.functions.a aVar, h.a aVar2, long j4) {
        this.f63848a = aVar;
        this.f63849b = aVar2;
        this.f63850c = j4;
    }

    @Override // rx.functions.a
    public void call() {
        if (this.f63849b.isUnsubscribed()) {
            return;
        }
        long b4 = this.f63850c - this.f63849b.b();
        if (b4 > 0) {
            try {
                Thread.sleep(b4);
            } catch (InterruptedException e4) {
                Thread.currentThread().interrupt();
                rx.exceptions.a.c(e4);
            }
        }
        if (this.f63849b.isUnsubscribed()) {
            return;
        }
        this.f63848a.call();
    }
}
