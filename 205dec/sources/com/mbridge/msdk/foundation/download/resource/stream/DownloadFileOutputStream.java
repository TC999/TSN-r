package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface DownloadFileOutputStream {
    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j4) throws IOException, IllegalAccessException;

    void setLength(long j4) throws IOException, IllegalAccessException;

    void write(byte[] bArr, int i4, int i5) throws IOException;
}
