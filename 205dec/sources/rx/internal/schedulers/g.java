package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: NewThreadScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class g extends rx.h {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f63806a;

    public g(ThreadFactory threadFactory) {
        this.f63806a = threadFactory;
    }

    @Override // rx.h
    public h.a a() {
        return new h(this.f63806a);
    }
}
