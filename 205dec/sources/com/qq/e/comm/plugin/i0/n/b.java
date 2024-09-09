package com.qq.e.comm.plugin.i0.n;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b implements g {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f44400a;

    /* renamed from: b  reason: collision with root package name */
    private int f44401b;

    public b(HttpURLConnection httpURLConnection) throws IOException {
        this.f44401b = 0;
        if (httpURLConnection != null) {
            this.f44400a = httpURLConnection;
            this.f44401b = httpURLConnection.getResponseCode();
            return;
        }
        throw new IOException("AbstractResponse parameter is null");
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public InputStream a() throws IllegalStateException, IOException {
        return this.f44400a.getInputStream();
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public String b() throws IOException {
        byte[] c4 = c();
        String str = null;
        if (c4 == null) {
            return null;
        }
        if (c4.length == 0) {
            return "";
        }
        try {
            str = this.f44400a.getContentEncoding();
        } catch (Throwable unused) {
        }
        if (str == null) {
            str = "UTF-8";
        }
        return new String(c4, str);
    }

    public byte[] c() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream a4 = a();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = a4.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    a4.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th) {
            a4.close();
            throw th;
        }
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public void close() throws IllegalStateException, IOException {
        a().close();
        this.f44400a.disconnect();
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public int getStatusCode() {
        return this.f44401b;
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public String a(String str) {
        return this.f44400a.getHeaderField(str);
    }
}
