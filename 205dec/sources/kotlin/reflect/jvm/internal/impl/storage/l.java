package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: SingleThreadValue.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class l<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f58249a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread f58250b = Thread.currentThread();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(T t3) {
        this.f58249a = t3;
    }

    public T a() {
        if (b()) {
            return this.f58249a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f58250b == Thread.currentThread();
    }
}
