package com.qq.e.comm.plugin.i0.n;

import com.qq.e.comm.plugin.util.o1;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends b {
    public i(HttpURLConnection httpURLConnection) throws IOException {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.i0.n.b
    public byte[] c() throws IllegalStateException, IOException {
        try {
            return o1.d(super.c());
        } catch (o1.d e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
