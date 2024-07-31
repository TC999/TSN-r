package p640rx.internal.operators;

import p640rx.Notification;
import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.x1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDematerialize<T> implements Observable.InterfaceC15568b<T, Notification<T>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDematerialize.java */
    /* renamed from: rx.internal.operators.x1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15958a extends Subscriber<Notification<T>> {

        /* renamed from: a */
        boolean f46139a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f46140b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15958a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46140b = subscriber2;
        }

        @Override // p640rx.Observer
        /* renamed from: F */
        public void onNext(Notification<T> notification) {
            int i = C15959b.f46142a[notification.m2001f().ordinal()];
            if (i == 1) {
                if (this.f46139a) {
                    return;
                }
                this.f46140b.onNext(notification.m1999h());
            } else if (i == 2) {
                onError(notification.m2000g());
            } else if (i != 3) {
                onError(new IllegalArgumentException("Unsupported notification type: " + notification));
            } else {
                onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f46139a) {
                return;
            }
            this.f46139a = true;
            this.f46140b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f46139a) {
                return;
            }
            this.f46139a = true;
            this.f46140b.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDematerialize.java */
    /* renamed from: rx.internal.operators.x1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static /* synthetic */ class C15959b {

        /* renamed from: a */
        static final /* synthetic */ int[] f46142a;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            f46142a = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46142a[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46142a[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDematerialize.java */
    /* renamed from: rx.internal.operators.x1$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15960c {

        /* renamed from: a */
        static final OperatorDematerialize<Object> f46143a = new OperatorDematerialize<>();

        C15960c() {
        }
    }

    OperatorDematerialize() {
    }

    /* renamed from: a */
    public static OperatorDematerialize m1006a() {
        return C15960c.f46143a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super Notification<T>> call(Subscriber<? super T> subscriber) {
        return new C15958a(subscriber, subscriber);
    }
}
