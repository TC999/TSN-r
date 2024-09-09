package io.netty.util.internal.logging;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormattingTuple(String str, Throwable th) {
        this.message = str;
        this.throwable = th;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
