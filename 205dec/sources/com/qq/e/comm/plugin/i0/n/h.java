package com.qq.e.comm.plugin.i0.n;

import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.util.o1;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends a {
    public h(String str, byte[] bArr) {
        super(str, f.a.POST, bArr);
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public g a(HttpURLConnection httpURLConnection) throws IOException {
        return new i(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.i0.n.a, com.qq.e.comm.plugin.i0.n.f
    public byte[] k() throws Exception {
        return o1.c(super.k());
    }
}
