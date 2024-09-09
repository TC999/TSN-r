package com.bytedance.sdk.component.xv.c;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface sr extends s, WritableByteChannel {
    sr a(long j4) throws IOException;

    sr ev(int i4) throws IOException;

    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
    void flush() throws IOException;

    sr gd(int i4) throws IOException;

    sr i() throws IOException;

    sr k(long j4) throws IOException;

    sr r(int i4) throws IOException;

    sr w(f fVar) throws IOException;

    sr w(String str) throws IOException;

    sr xv(byte[] bArr) throws IOException;

    sr xv(byte[] bArr, int i4, int i5) throws IOException;

    xv xv();
}
