package com.bykv.vk.component.ttvideo.player;

import java.io.Closeable;
import java.io.IOException;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IMediaDataSource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @Keep
    void close() throws IOException;

    @Keep
    long getSize() throws IOException;

    @Keep
    int readAt(long j4, byte[] bArr, int i4, int i5) throws IOException;
}
