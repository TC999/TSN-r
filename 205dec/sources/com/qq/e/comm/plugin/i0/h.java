package com.qq.e.comm.plugin.i0;

import com.qq.e.comm.plugin.i0.f;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class h extends com.qq.e.comm.plugin.i0.n.b {
    public h(HttpURLConnection httpURLConnection) throws IOException {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.i0.n.b
    public byte[] c() throws IllegalStateException, IOException {
        try {
            return f.c(super.c());
        } catch (f.b e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
