package com.bytedance.adsdk.lottie.sr;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f25742a;

    public a(HttpURLConnection httpURLConnection) {
        this.f25742a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Override // com.bytedance.adsdk.lottie.sr.e
    public boolean c() {
        try {
            return this.f25742a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25742a.disconnect();
    }

    @Override // com.bytedance.adsdk.lottie.sr.e
    public String sr() {
        try {
            if (c()) {
                return null;
            }
            return "Unable to fetch " + this.f25742a.getURL() + ". Failed with " + this.f25742a.getResponseCode() + "\n" + a(this.f25742a);
        } catch (IOException e4) {
            com.bytedance.adsdk.lottie.f.e.b("get error failed ", e4);
            return e4.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.lottie.sr.e
    public InputStream w() throws IOException {
        return this.f25742a.getInputStream();
    }

    @Override // com.bytedance.adsdk.lottie.sr.e
    public String xv() {
        return this.f25742a.getContentType();
    }
}
