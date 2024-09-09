package com.qq.e.comm.plugin.p0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends j {

    /* renamed from: f  reason: collision with root package name */
    protected final a f45319f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45320g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        super(aVar);
        this.f45319f = aVar;
    }

    private String b(b bVar) throws IOException, k {
        String d4 = this.f45319f.d();
        boolean z3 = !TextUtils.isEmpty(d4);
        long h4 = this.f45319f.h();
        boolean z4 = h4 >= 0;
        long j4 = bVar.f45316c ? h4 - bVar.f45315b : h4;
        boolean z5 = z4 && bVar.f45316c;
        d1.a("VideoCache", "response header mime:" + d4 + ", length:" + h4 + ", partial:" + bVar.f45316c);
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.f45316c ? "HTTP/1.1 206 PARTIAL CONTENT\r\n" : "HTTP/1.1 200 OK\r\n");
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append(z4 ? a("Content-Length: %d\r\n", Long.valueOf(j4)) : "");
        sb.append(z5 ? a("Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(bVar.f45315b), Long.valueOf(h4 - 1), Long.valueOf(h4)) : "");
        sb.append(z3 ? a("Content-Type: %s\r\n", d4) : "");
        sb.append("\r\n");
        return sb.toString();
    }

    private String d() {
        return "HTTP/1.1 400 Bad Request\r\nContent-Type: application/json\r\nContent-Length: 41\r\nAccept-Ranges: bytes\r\n\r\n{\"code\":400,\"msg\":\"Filename is illegal.\"}\r\n";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar, Socket socket) throws IOException, k {
        d1.a("VideoCache", "HttpProxyCache processRequest:" + bVar + ", socket:" + socket);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        if (this.f45320g) {
            d1.b("VideoCache", "processRequest download video error");
            bufferedOutputStream.write(d().getBytes(com.qq.e.comm.plugin.k.a.f44515a));
            bufferedOutputStream.flush();
            return;
        }
        bufferedOutputStream.write(b(bVar).getBytes(com.qq.e.comm.plugin.k.a.f44515a));
        a(bufferedOutputStream, bVar.f45315b, bVar);
    }

    @Override // com.qq.e.comm.plugin.p0.j
    protected void a(OutputStream outputStream) throws IOException {
    }

    private void a(OutputStream outputStream, long j4, b bVar) throws k, IOException {
        d1.a("VideoCache", "response with cache");
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int a4 = a(bArr, j4, 8192, outputStream, bVar);
                if (a4 == -1) {
                    return;
                }
                outputStream.write(bArr, 0, a4);
                j4 += a4;
            } finally {
                d1.a("VideoCache", "OutputStream flush");
                outputStream.flush();
            }
        }
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        this.f45320g = z3;
    }
}
