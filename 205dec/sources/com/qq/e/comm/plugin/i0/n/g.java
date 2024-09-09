package com.qq.e.comm.plugin.i0.n;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface g {
    InputStream a() throws IllegalStateException, IOException;

    String a(String str);

    String b() throws IllegalStateException, IOException;

    void close() throws IllegalStateException, IOException;

    int getStatusCode();
}
