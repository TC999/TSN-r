package com.qq.e.lib.a.e;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface d {
    InputStream a() throws IOException;

    int available() throws IOException;

    void close() throws IOException;

    byte peek() throws IOException;

    int position();

    int read(byte[] bArr, int i4, int i5) throws IOException;

    void reset() throws IOException;

    long skip(long j4) throws IOException;
}
