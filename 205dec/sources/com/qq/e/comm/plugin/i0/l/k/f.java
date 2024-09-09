package com.qq.e.comm.plugin.i0.l.k;

import com.qq.e.comm.plugin.i0.l.k.c;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f extends c {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DataOutputStream f44359c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ HttpsURLConnection f44360d;

        a(f fVar, DataOutputStream dataOutputStream, HttpsURLConnection httpsURLConnection) {
            this.f44359c = dataOutputStream;
            this.f44360d = httpsURLConnection;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f44359c.close();
            } catch (Exception unused) {
            }
            try {
                this.f44360d.disconnect();
            } catch (Exception unused2) {
            }
        }
    }

    public f(String[] strArr, int i4, int i5, ExecutorService executorService) {
        super(strArr, i4, i5, executorService);
    }

    @Override // com.qq.e.comm.plugin.i0.l.k.c
    d a(c.b bVar, String str, String str2, int i4) throws Exception {
        int contentLength;
        b bVar2 = new b((short) (Math.random() * 65535.0d), i4, str2);
        byte[] b4 = bVar2.b();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setConnectTimeout(3000);
        httpsURLConnection.setReadTimeout(this.f44330d * 1000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept-Encoding", "");
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        bVar.a(new a(this, dataOutputStream, httpsURLConnection));
        dataOutputStream.write(b4);
        dataOutputStream.close();
        if (httpsURLConnection.getResponseCode() == 200 && (contentLength = httpsURLConnection.getContentLength()) > 0 && contentLength <= 1048576) {
            InputStream inputStream = httpsURLConnection.getInputStream();
            byte[] bArr = new byte[contentLength];
            int read = inputStream.read(bArr);
            inputStream.close();
            if (read <= 0) {
                return null;
            }
            return new d(str, 3, bVar2, bArr);
        }
        return null;
    }
}
