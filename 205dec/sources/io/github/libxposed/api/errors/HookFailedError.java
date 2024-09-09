package io.github.libxposed.api.errors;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class HookFailedError extends XposedFrameworkError {
    public HookFailedError(String str) {
        super(str);
    }

    public HookFailedError(String str, Throwable th) {
        super(str, th);
    }

    public HookFailedError(Throwable th) {
        super(th);
    }
}
