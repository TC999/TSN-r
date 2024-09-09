package io.netty.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class BlockingOperationException extends IllegalStateException {
    private static final long serialVersionUID = 2462223247762460301L;

    public BlockingOperationException() {
    }

    public BlockingOperationException(String str) {
        super(str);
    }

    public BlockingOperationException(Throwable th) {
        super(th);
    }

    public BlockingOperationException(String str, Throwable th) {
        super(str, th);
    }
}
