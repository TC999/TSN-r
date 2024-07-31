package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.file.C6545b;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpProxyCache.java */
/* renamed from: com.danikula.videocache.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6555h extends C6568o {

    /* renamed from: n */
    private static final float f23086n = 0.2f;

    /* renamed from: k */
    private final C6563k f23087k;

    /* renamed from: l */
    private final C6545b f23088l;

    /* renamed from: m */
    private InterfaceC6542e f23089m;

    public C6555h(C6563k c6563k, C6545b c6545b) {
        super(c6563k, c6545b);
        this.f23088l = c6545b;
        this.f23087k = c6563k;
    }

    /* renamed from: p */
    private String m35921p(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: q */
    private boolean m35920q(C6554g c6554g) throws ProxyCacheException {
        long length = this.f23087k.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && c6554g.f23085c && ((float) c6554g.f23084b) > ((float) this.f23088l.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    /* renamed from: r */
    private String m35919r(C6554g c6554g) throws IOException, ProxyCacheException {
        String m35873d = this.f23087k.m35873d();
        boolean z = !TextUtils.isEmpty(m35873d);
        long available = this.f23088l.isCompleted() ? this.f23088l.available() : this.f23087k.length();
        boolean z2 = available >= 0;
        boolean z3 = c6554g.f23085c;
        long j = z3 ? available - c6554g.f23084b : available;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(c6554g.f23085c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? m35921p("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? m35921p("Content-Range: bytes %d-%d/%d\n", Long.valueOf(c6554g.f23084b), Long.valueOf(available - 1), Long.valueOf(available)) : "");
        sb.append(z ? m35921p("Content-Type: %s\n", m35873d) : "");
        sb.append(ShellAdbUtils.f33810d);
        return sb.toString();
    }

    /* renamed from: u */
    private void m35916u(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int m35847j = m35847j(bArr, j, 8192);
            if (m35847j != -1) {
                outputStream.write(bArr, 0, m35847j);
                j += m35847j;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* renamed from: v */
    private void m35915v(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        C6563k c6563k = new C6563k(this.f23087k);
        try {
            c6563k.mo35833a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = c6563k.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            c6563k.close();
        }
    }

    @Override // com.danikula.videocache.C6568o
    /* renamed from: g */
    protected void mo35850g(int i) {
        InterfaceC6542e interfaceC6542e = this.f23089m;
        if (interfaceC6542e != null) {
            interfaceC6542e.mo35682a(this.f23088l.f23071b, this.f23087k.m35872e(), i);
        }
    }

    /* renamed from: s */
    public void m35918s(C6554g c6554g, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m35919r(c6554g).getBytes("UTF-8"));
        long j = c6554g.f23084b;
        if (m35920q(c6554g)) {
            m35916u(bufferedOutputStream, j);
        } else {
            m35915v(bufferedOutputStream, j);
        }
    }

    /* renamed from: t */
    public void m35917t(InterfaceC6542e interfaceC6542e) {
        this.f23089m = interfaceC6542e;
    }
}
