package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HttpProxyCache.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class h extends o {

    /* renamed from: n  reason: collision with root package name */
    private static final float f36753n = 0.2f;

    /* renamed from: k  reason: collision with root package name */
    private final k f36754k;

    /* renamed from: l  reason: collision with root package name */
    private final com.danikula.videocache.file.b f36755l;

    /* renamed from: m  reason: collision with root package name */
    private e f36756m;

    public h(k kVar, com.danikula.videocache.file.b bVar) {
        super(kVar, bVar);
        this.f36755l = bVar;
        this.f36754k = kVar;
    }

    private String p(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean q(g gVar) throws ProxyCacheException {
        long length = this.f36754k.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && gVar.f36752c && ((float) gVar.f36751b) > ((float) this.f36755l.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String r(g gVar) throws IOException, ProxyCacheException {
        String d4 = this.f36754k.d();
        boolean z3 = !TextUtils.isEmpty(d4);
        long available = this.f36755l.isCompleted() ? this.f36755l.available() : this.f36754k.length();
        boolean z4 = available >= 0;
        boolean z5 = gVar.f36752c;
        long j4 = z5 ? available - gVar.f36751b : available;
        boolean z6 = z4 && z5;
        StringBuilder sb = new StringBuilder();
        sb.append(gVar.f36752c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z4 ? p("Content-Length: %d\n", Long.valueOf(j4)) : "");
        sb.append(z6 ? p("Content-Range: bytes %d-%d/%d\n", Long.valueOf(gVar.f36751b), Long.valueOf(available - 1), Long.valueOf(available)) : "");
        sb.append(z3 ? p("Content-Type: %s\n", d4) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void u(OutputStream outputStream, long j4) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int j5 = j(bArr, j4, 8192);
            if (j5 != -1) {
                outputStream.write(bArr, 0, j5);
                j4 += j5;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void v(OutputStream outputStream, long j4) throws ProxyCacheException, IOException {
        k kVar = new k(this.f36754k);
        try {
            kVar.a((int) j4);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = kVar.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            kVar.close();
        }
    }

    @Override // com.danikula.videocache.o
    protected void g(int i4) {
        e eVar = this.f36756m;
        if (eVar != null) {
            eVar.a(this.f36755l.f36738b, this.f36754k.e(), i4);
        }
    }

    public void s(g gVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(r(gVar).getBytes("UTF-8"));
        long j4 = gVar.f36751b;
        if (q(gVar)) {
            u(bufferedOutputStream, j4);
        } else {
            v(bufferedOutputStream, j4);
        }
    }

    public void t(e eVar) {
        this.f36756m = eVar;
    }
}
