package io.netty.handler.ssl;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SniCompletionEvent(String str) {
        this.hostname = str;
    }

    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable cause = cause();
        if (cause == null) {
            return SniCompletionEvent.class.getSimpleName() + "(SUCCESS='" + this.hostname + "'\")";
        }
        return SniCompletionEvent.class.getSimpleName() + '(' + cause + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SniCompletionEvent(String str, Throwable th) {
        super(th);
        this.hostname = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SniCompletionEvent(Throwable th) {
        this(null, th);
    }
}
