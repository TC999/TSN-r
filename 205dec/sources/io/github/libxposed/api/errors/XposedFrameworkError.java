package io.github.libxposed.api.errors;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class XposedFrameworkError extends Error {
    public XposedFrameworkError(String str) {
        super(str);
    }

    public XposedFrameworkError(String str, Throwable th) {
        super(str, th);
    }

    public XposedFrameworkError(Throwable th) {
        super(th);
    }
}
