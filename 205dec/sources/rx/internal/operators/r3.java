package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.h;
import rx.internal.operators.s3;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTimeout.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r3<T> extends s3<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeout.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements s3.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f63228a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TimeUnit f63229b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorTimeout.java */
        /* renamed from: rx.internal.operators.r3$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1295a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s3.c f63230a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Long f63231b;

            C1295a(s3.c cVar, Long l4) {
                this.f63230a = cVar;
                this.f63231b = l4;
            }

            @Override // rx.functions.a
            public void call() {
                this.f63230a.g(this.f63231b.longValue());
            }
        }

        a(long j4, TimeUnit timeUnit) {
            this.f63228a = j4;
            this.f63229b = timeUnit;
        }

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ rx.m call(Object obj, Long l4, h.a aVar) {
            return call((s3.c) ((s3.c) obj), l4, aVar);
        }

        public rx.m call(s3.c<T> cVar, Long l4, h.a aVar) {
            return aVar.e(new C1295a(cVar, l4), this.f63228a, this.f63229b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeout.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements s3.b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f63233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TimeUnit f63234b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorTimeout.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s3.c f63235a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Long f63236b;

            a(s3.c cVar, Long l4) {
                this.f63235a = cVar;
                this.f63236b = l4;
            }

            @Override // rx.functions.a
            public void call() {
                this.f63235a.g(this.f63236b.longValue());
            }
        }

        b(long j4, TimeUnit timeUnit) {
            this.f63233a = j4;
            this.f63234b = timeUnit;
        }

        @Override // rx.functions.s
        public /* bridge */ /* synthetic */ rx.m call(Object obj, Long l4, Object obj2, h.a aVar) {
            return call((s3.c<Long>) obj, l4, (Long) obj2, aVar);
        }

        public rx.m call(s3.c<T> cVar, Long l4, T t3, h.a aVar) {
            return aVar.e(new a(cVar, l4), this.f63233a, this.f63234b);
        }
    }

    public r3(long j4, TimeUnit timeUnit, rx.e<? extends T> eVar, rx.h hVar) {
        super(new a(j4, timeUnit), new b(j4, timeUnit), eVar, hVar);
    }

    @Override // rx.internal.operators.s3
    public /* bridge */ /* synthetic */ rx.l call(rx.l lVar) {
        return super.call(lVar);
    }
}
