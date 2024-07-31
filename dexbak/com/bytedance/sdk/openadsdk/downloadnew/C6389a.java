package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6389a {

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6390ok {

        /* renamed from: a */
        public Map<String, String> f22532a;

        /* renamed from: bl */
        public int f22533bl;

        /* renamed from: ok */
        public InputStream f22534ok;

        /* renamed from: s */
        public HttpURLConnection f22535s;

        public C6390ok(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.f22534ok = inputStream;
            this.f22532a = map;
            this.f22533bl = i;
            this.f22535s = httpURLConnection;
        }
    }

    /* renamed from: ok */
    public static HttpURLConnection m36496ok(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setInstanceFollowRedirects(false);
                httpURLConnection3.setRequestProperty("accept", "*/*");
                httpURLConnection3.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection3.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection3.connect();
                int responseCode = httpURLConnection3.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? m36496ok(httpURLConnection3.getHeaderField(HttpHeaders.Names.LOCATION), map) : httpURLConnection3;
            } catch (Exception unused) {
                httpURLConnection2 = httpURLConnection;
                return httpURLConnection2;
            }
        } catch (Exception unused2) {
        }
    }

    /* renamed from: ok */
    public static Map<String, String> m36495ok(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }

    /* renamed from: ok */
    public static C6390ok m36497ok(String str, List<C12601bl> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (C12601bl c12601bl : list) {
                hashMap.put(c12601bl.m16999ok(), c12601bl.m17000a());
            }
        }
        HttpURLConnection m36496ok = m36496ok(str, hashMap);
        if (m36496ok != null && (responseCode = m36496ok.getResponseCode()) >= 200 && responseCode < 300) {
            Map<String, String> m36495ok = m36495ok(m36496ok);
            InputStream inputStream = m36496ok.getInputStream();
            String contentEncoding = m36496ok.getContentEncoding();
            if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
                inputStream = new GZIPInputStream(inputStream);
            }
            return new C6390ok(inputStream, m36495ok, responseCode, m36496ok);
        }
        return null;
    }
}
