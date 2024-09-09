package com.bytedance.sdk.component.xv.c;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface s extends Closeable, Flushable {
    void a_(xv xvVar, long j4) throws IOException;

    u c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
