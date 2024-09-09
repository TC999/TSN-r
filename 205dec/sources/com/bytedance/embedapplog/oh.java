package com.bytedance.embedapplog;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
abstract class oh<T> {

    /* renamed from: c  reason: collision with root package name */
    private volatile T f26777c;

    protected abstract T c(Object... objArr);

    public final T w(Object... objArr) {
        if (this.f26777c == null) {
            synchronized (this) {
                if (this.f26777c == null) {
                    this.f26777c = c(objArr);
                }
            }
        }
        return this.f26777c;
    }
}
