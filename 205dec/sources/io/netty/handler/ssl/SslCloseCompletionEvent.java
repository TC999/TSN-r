package io.netty.handler.ssl;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SslCloseCompletionEvent extends SslCompletionEvent {
    public static final SslCloseCompletionEvent SUCCESS = new SslCloseCompletionEvent();

    private SslCloseCompletionEvent() {
    }

    public SslCloseCompletionEvent(Throwable th) {
        super(th);
    }
}
