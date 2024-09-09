package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTakeLast.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f62830a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeLast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62831a;

        a(b bVar) {
            this.f62831a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f62831a.g(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeLast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> implements rx.functions.p<Object, T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62833a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicLong f62834b = new AtomicLong();

        /* renamed from: c  reason: collision with root package name */
        final ArrayDeque<Object> f62835c = new ArrayDeque<>();

        /* renamed from: d  reason: collision with root package name */
        final int f62836d;

        public b(rx.l<? super T> lVar, int i4) {
            this.f62833a = lVar;
            this.f62836d = i4;
        }

        @Override // rx.functions.p
        public T call(Object obj) {
            return (T) v.e(obj);
        }

        void g(long j4) {
            if (j4 > 0) {
                rx.internal.operators.a.h(this.f62834b, j4, this.f62835c, this.f62833a, this);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            rx.internal.operators.a.e(this.f62834b, this.f62835c, this.f62833a, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62835c.clear();
            this.f62833a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62835c.size() == this.f62836d) {
                this.f62835c.poll();
            }
            this.f62835c.offer(v.j(t3));
        }
    }

    public j3(int i4) {
        if (i4 >= 0) {
            this.f62830a = i4;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f62830a);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }
}
