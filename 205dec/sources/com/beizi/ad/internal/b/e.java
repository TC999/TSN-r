package com.beizi.ad.internal.b;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpProxyCache.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e extends l {

    /* renamed from: a  reason: collision with root package name */
    private final h f13694a;

    /* renamed from: b  reason: collision with root package name */
    private final com.beizi.ad.internal.b.a.b f13695b;

    /* renamed from: c  reason: collision with root package name */
    private b f13696c;

    public e(h hVar, com.beizi.ad.internal.b.a.b bVar) {
        super(hVar, bVar);
        this.f13695b = bVar;
        this.f13694a = hVar;
    }

    private String b(d dVar) throws IOException, m {
        String c4 = this.f13694a.c();
        boolean z3 = !TextUtils.isEmpty(c4);
        int a4 = this.f13695b.d() ? this.f13695b.a() : this.f13694a.a();
        boolean z4 = a4 >= 0;
        boolean z5 = dVar.f13693c;
        long j4 = a4;
        if (z5) {
            j4 -= dVar.f13692b;
        }
        boolean z6 = z4 && z5;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f13693c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z4 ? String.format("Content-Length: %d\n", Long.valueOf(j4)) : "");
        sb.append(z6 ? String.format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f13692b), Integer.valueOf(a4 - 1), Integer.valueOf(a4)) : "");
        sb.append(z3 ? String.format("Content-Type: %s\n", c4) : "");
        sb.append("\n");
        return sb.toString();
    }

    public void a(b bVar) {
        this.f13696c = bVar;
    }

    public void a(d dVar, Socket socket) throws IOException, m {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j4 = dVar.f13692b;
        if (a(dVar)) {
            a(bufferedOutputStream, j4);
        } else {
            b(bufferedOutputStream, j4);
        }
    }

    private boolean a(d dVar) throws m {
        int a4 = this.f13694a.a();
        return ((a4 > 0) && dVar.f13693c && ((float) dVar.f13692b) > ((float) this.f13695b.a()) + (((float) a4) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j4) throws m, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int a4 = a(bArr, j4, 8192);
            if (a4 != -1) {
                outputStream.write(bArr, 0, a4);
                j4 += a4;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void b(OutputStream outputStream, long j4) throws m, IOException {
        h hVar = new h(this.f13694a);
        try {
            hVar.a((int) j4);
            byte[] bArr = new byte[8192];
            while (true) {
                int a4 = hVar.a(bArr);
                if (a4 != -1) {
                    outputStream.write(bArr, 0, a4);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            hVar.b();
        }
    }

    @Override // com.beizi.ad.internal.b.l
    protected void a(int i4) {
        b bVar = this.f13696c;
        if (bVar != null) {
            bVar.a(this.f13695b.f13677a, this.f13694a.d(), i4);
        }
    }
}
