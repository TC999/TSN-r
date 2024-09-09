package com.bumptech.glide.load.engine;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CallbackException.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class b extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
