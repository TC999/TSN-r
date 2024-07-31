package com.bumptech.glide.load.engine;

/* renamed from: com.bumptech.glide.load.engine.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
