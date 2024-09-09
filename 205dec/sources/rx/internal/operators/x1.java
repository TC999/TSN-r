package rx.internal.operators;

import rx.Notification;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDematerialize.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x1<T> implements e.b<T, Notification<T>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDematerialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<Notification<T>> {

        /* renamed from: a  reason: collision with root package name */
        boolean f63570a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f63571b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63571b = lVar2;
        }

        @Override // rx.f
        /* renamed from: g */
        public void onNext(Notification<T> notification) {
            int i4 = b.f63573a[notification.f().ordinal()];
            if (i4 == 1) {
                if (this.f63570a) {
                    return;
                }
                this.f63571b.onNext(notification.h());
            } else if (i4 == 2) {
                onError(notification.g());
            } else if (i4 != 3) {
                onError(new IllegalArgumentException("Unsupported notification type: " + notification));
            } else {
                onCompleted();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63570a) {
                return;
            }
            this.f63570a = true;
            this.f63571b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63570a) {
                return;
            }
            this.f63570a = true;
            this.f63571b.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDematerialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f63573a;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            f63573a = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63573a[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63573a[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDematerialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final x1<Object> f63574a = new x1<>();

        c() {
        }
    }

    x1() {
    }

    public static x1 a() {
        return c.f63574a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super Notification<T>> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
