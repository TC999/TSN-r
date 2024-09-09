package com.qq.e.comm.plugin.i0.n;

import com.qq.e.comm.plugin.i0.n.f;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends a {
    public c(String str, f.a aVar, byte[] bArr) {
        super(str, aVar, bArr);
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public g a(HttpURLConnection httpURLConnection) throws IOException {
        return new d(httpURLConnection);
    }

    public c(String str, Map<String, String> map, f.a aVar) {
        super(str, map, aVar);
    }
}
