package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Scheduler.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class h {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Scheduler.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a implements m {
        public long b() {
            return System.currentTimeMillis();
        }

        public abstract m c(rx.functions.a aVar);

        public abstract m e(rx.functions.a aVar, long j4, TimeUnit timeUnit);

        public m g(rx.functions.a aVar, long j4, long j5, TimeUnit timeUnit) {
            return rx.internal.schedulers.i.a(this, aVar, j4, j5, timeUnit, null);
        }
    }

    public abstract a a();

    public long b() {
        return System.currentTimeMillis();
    }

    public <S extends h & m> S c(p<e<e<b>>, b> pVar) {
        return new rx.internal.schedulers.k(pVar, this);
    }
}
