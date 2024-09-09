package com.qq.e.comm.plugin.p0;

import com.qq.e.comm.plugin.util.d1;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j4, int i4) throws k {
        i.a(bArr, "Buffer must be not null!");
        boolean z3 = true;
        i.a(j4 >= 0, "Data offset must be positive!");
        i.a((i4 < 0 || i4 > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Error encoding url", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Error decoding url", e4);
        }
    }

    static HttpURLConnection a(String str, int i4) throws IOException, k {
        HttpURLConnection httpURLConnection;
        boolean z3;
        int i5 = 0;
        do {
            d1.a("Open connection  to " + str, new Object[0]);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i4 > 0) {
                httpURLConnection.setConnectTimeout(i4);
                httpURLConnection.setReadTimeout(i4);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z3 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z3) {
                str = httpURLConnection.getHeaderField("Location");
                i5++;
                httpURLConnection.disconnect();
            }
            if (i5 > 5) {
                throw new k("Too many redirects: " + i5);
            }
        } while (z3);
        return httpURLConnection;
    }
}
