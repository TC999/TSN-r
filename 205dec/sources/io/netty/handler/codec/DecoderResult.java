package io.netty.handler.codec;

import io.netty.util.Signal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DecoderResult {
    protected static final Signal SIGNAL_SUCCESS;
    protected static final Signal SIGNAL_UNFINISHED;
    public static final DecoderResult SUCCESS;
    public static final DecoderResult UNFINISHED;
    private final Throwable cause;

    static {
        Signal valueOf = Signal.valueOf(DecoderResult.class, "UNFINISHED");
        SIGNAL_UNFINISHED = valueOf;
        Signal valueOf2 = Signal.valueOf(DecoderResult.class, "SUCCESS");
        SIGNAL_SUCCESS = valueOf2;
        UNFINISHED = new DecoderResult(valueOf);
        SUCCESS = new DecoderResult(valueOf2);
    }

    protected DecoderResult(Throwable th) {
        if (th != null) {
            this.cause = th;
            return;
        }
        throw new NullPointerException("cause");
    }

    public static DecoderResult failure(Throwable th) {
        if (th != null) {
            return new DecoderResult(th);
        }
        throw new NullPointerException("cause");
    }

    public Throwable cause() {
        if (isFailure()) {
            return this.cause;
        }
        return null;
    }

    public boolean isFailure() {
        Throwable th = this.cause;
        return (th == SIGNAL_SUCCESS || th == SIGNAL_UNFINISHED) ? false : true;
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public String toString() {
        if (isFinished()) {
            if (isSuccess()) {
                return "success";
            }
            String th = cause().toString();
            StringBuilder sb = new StringBuilder(th.length() + 17);
            sb.append("failure(");
            sb.append(th);
            sb.append(')');
            return sb.toString();
        }
        return "unfinished";
    }
}
