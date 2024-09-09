package com.qq.e.comm.plugin.i0;

import com.qq.e.comm.plugin.i0.n.f;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g extends com.qq.e.comm.plugin.i0.n.a {
    public g(String str, byte[] bArr) {
        super(str, f.a.POST, bArr);
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public com.qq.e.comm.plugin.i0.n.g a(HttpURLConnection httpURLConnection) throws IOException {
        return new h(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.i0.n.a, com.qq.e.comm.plugin.i0.n.f
    public byte[] k() throws Exception {
        return f.b(super.k());
    }
}
