package com.bytedance.sdk.component.xv.c;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface fz extends Closeable {
    long c(xv xvVar, long j4) throws IOException;

    u c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
