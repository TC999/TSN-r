package io.netty.handler.ssl;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SslHandshakeCompletionEvent {
    public static final SslHandshakeCompletionEvent SUCCESS = new SslHandshakeCompletionEvent();
    private final Throwable cause;

    private SslHandshakeCompletionEvent() {
        this.cause = null;
    }

    public Throwable cause() {
        return this.cause;
    }

    public boolean isSuccess() {
        return this.cause == null;
    }

    public String toString() {
        Throwable cause = cause();
        if (cause == null) {
            return "SslHandshakeCompletionEvent(SUCCESS)";
        }
        return "SslHandshakeCompletionEvent(" + cause + ')';
    }

    public SslHandshakeCompletionEvent(Throwable th) {
        if (th != null) {
            this.cause = th;
            return;
        }
        throw new NullPointerException("cause");
    }
}
