package rx.internal.operators;

import rx.e;
import rx.exceptions.AssemblyStackTraceException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeOnAssembly.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s0<T> implements e.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f63258c;

    /* renamed from: a  reason: collision with root package name */
    final e.a<T> f63259a;

    /* renamed from: b  reason: collision with root package name */
    final String f63260b = a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeOnAssembly.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63261a;

        /* renamed from: b  reason: collision with root package name */
        final String f63262b;

        public a(rx.l<? super T> lVar, String str) {
            super(lVar);
            this.f63261a = lVar;
            this.f63262b = str;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63261a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f63262b).attachTo(th);
            this.f63261a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63261a.onNext(t3);
        }
    }

    public s0(e.a<T> aVar) {
        this.f63259a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            if (f63258c || (stackTraceElement.getLineNumber() > 1 && !stackTraceElement2.contains("RxJavaHooks.") && !stackTraceElement2.contains("OnSubscribeOnAssembly") && !stackTraceElement2.contains(".junit.runner") && !stackTraceElement2.contains(".junit4.runner") && !stackTraceElement2.contains(".junit.internal") && !stackTraceElement2.contains("sun.reflect") && !stackTraceElement2.contains("java.lang.Thread.") && !stackTraceElement2.contains("ThreadPoolExecutor") && !stackTraceElement2.contains("org.apache.catalina.") && !stackTraceElement2.contains("org.apache.tomcat."))) {
                sb.append("\n at ");
                sb.append(stackTraceElement2);
            }
        }
        sb.append("\nOriginal exception:");
        return sb.toString();
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        this.f63259a.call(new a(lVar, this.f63260b));
    }
}
