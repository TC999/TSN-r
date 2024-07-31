package com.beizi.p051ad.internal.p058b;

import android.text.TextUtils;
import com.beizi.p051ad.internal.p058b.p059a.FileCache;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.b.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpProxyCache extends ProxyCache {

    /* renamed from: a */
    private final HttpUrlSource f10017a;

    /* renamed from: b */
    private final FileCache f10018b;

    /* renamed from: c */
    private CacheListener f10019c;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.f10018b = fileCache;
        this.f10017a = httpUrlSource;
    }

    /* renamed from: b */
    private String m49613b(GetRequest getRequest) throws IOException, ProxyCacheException {
        String m49582c = this.f10017a.m49582c();
        boolean z = !TextUtils.isEmpty(m49582c);
        int mo49650a = this.f10018b.mo49644d() ? this.f10018b.mo49650a() : this.f10017a.mo49545a();
        boolean z2 = mo49650a >= 0;
        boolean z3 = getRequest.f10016c;
        long j = mo49650a;
        if (z3) {
            j -= getRequest.f10015b;
        }
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(getRequest.f10016c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? String.format("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? String.format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(getRequest.f10015b), Integer.valueOf(mo49650a - 1), Integer.valueOf(mo49650a)) : "");
        sb.append(z ? String.format("Content-Type: %s\n", m49582c) : "");
        sb.append(ShellAdbUtils.f33810d);
        return sb.toString();
    }

    /* renamed from: a */
    public void m49617a(CacheListener cacheListener) {
        this.f10019c = cacheListener;
    }

    /* renamed from: a */
    public void m49615a(GetRequest getRequest, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m49613b(getRequest).getBytes("UTF-8"));
        long j = getRequest.f10015b;
        if (m49616a(getRequest)) {
            m49614a(bufferedOutputStream, j);
        } else {
            m49612b(bufferedOutputStream, j);
        }
    }

    /* renamed from: a */
    private boolean m49616a(GetRequest getRequest) throws ProxyCacheException {
        int mo49545a = this.f10017a.mo49545a();
        return ((mo49545a > 0) && getRequest.f10016c && ((float) getRequest.f10015b) > ((float) this.f10018b.mo49650a()) + (((float) mo49545a) * 0.2f)) ? false : true;
    }

    /* renamed from: a */
    private void m49614a(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int m49562a = m49562a(bArr, j, 8192);
            if (m49562a != -1) {
                outputStream.write(bArr, 0, m49562a);
                j += m49562a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* renamed from: b */
    private void m49612b(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.f10017a);
        try {
            httpUrlSource.mo49544a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int mo49543a = httpUrlSource.mo49543a(bArr);
                if (mo49543a != -1) {
                    outputStream.write(bArr, 0, mo49543a);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            httpUrlSource.mo49542b();
        }
    }

    @Override // com.beizi.p051ad.internal.p058b.ProxyCache
    /* renamed from: a */
    protected void mo49566a(int i) {
        CacheListener cacheListener = this.f10019c;
        if (cacheListener != null) {
            cacheListener.mo49585a(this.f10018b.f10000a, this.f10017a.m49581d(), i);
        }
    }
}
