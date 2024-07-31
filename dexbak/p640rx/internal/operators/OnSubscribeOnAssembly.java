package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.AssemblyStackTraceException;

/* renamed from: rx.internal.operators.s0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeOnAssembly<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: c */
    public static volatile boolean f45827c;

    /* renamed from: a */
    final Observable.InterfaceC15567a<T> f45828a;

    /* renamed from: b */
    final String f45829b = m1103a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeOnAssembly.java */
    /* renamed from: rx.internal.operators.s0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15867a<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super T> f45830a;

        /* renamed from: b */
        final String f45831b;

        public C15867a(Subscriber<? super T> subscriber, String str) {
            super(subscriber);
            this.f45830a = subscriber;
            this.f45831b = str;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45830a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f45831b).attachTo(th);
            this.f45830a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45830a.onNext(t);
        }
    }

    public OnSubscribeOnAssembly(Observable.InterfaceC15567a<T> interfaceC15567a) {
        this.f45828a = interfaceC15567a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m1103a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            if (f45827c || (stackTraceElement.getLineNumber() > 1 && !stackTraceElement2.contains("RxJavaHooks.") && !stackTraceElement2.contains("OnSubscribeOnAssembly") && !stackTraceElement2.contains(".junit.runner") && !stackTraceElement2.contains(".junit4.runner") && !stackTraceElement2.contains(".junit.internal") && !stackTraceElement2.contains("sun.reflect") && !stackTraceElement2.contains("java.lang.Thread.") && !stackTraceElement2.contains("ThreadPoolExecutor") && !stackTraceElement2.contains("org.apache.catalina.") && !stackTraceElement2.contains("org.apache.tomcat."))) {
                sb.append("\n at ");
                sb.append(stackTraceElement2);
            }
        }
        sb.append("\nOriginal exception:");
        return sb.toString();
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        this.f45828a.call(new C15867a(subscriber, this.f45829b));
    }
}
