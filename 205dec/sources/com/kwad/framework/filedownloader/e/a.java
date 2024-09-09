package com.kwad.framework.filedownloader.e;

import java.io.Closeable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface a extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j4);

    void setLength(long j4);

    void wI();

    void write(byte[] bArr, int i4, int i5);
}
