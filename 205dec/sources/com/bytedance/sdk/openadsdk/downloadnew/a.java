package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f35803a;
        public int bl;
        public InputStream ok;

        /* renamed from: s  reason: collision with root package name */
        public HttpURLConnection f35804s;

        public ok(InputStream inputStream, Map<String, String> map, int i4, HttpURLConnection httpURLConnection) {
            this.ok = inputStream;
            this.f35803a = map;
            this.bl = i4;
            this.f35804s = httpURLConnection;
        }
    }

    public static HttpURLConnection ok(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setInstanceFollowRedirects(false);
                httpURLConnection3.setRequestProperty("accept", Headers.VALUE_ACCEPT_ALL);
                httpURLConnection3.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection3.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection3.connect();
                int responseCode = httpURLConnection3.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? ok(httpURLConnection3.getHeaderField("Location"), map) : httpURLConnection3;
            } catch (Exception unused) {
                httpURLConnection2 = httpURLConnection;
                return httpURLConnection2;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> ok(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i4 = 0; i4 < size; i4++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i4), httpURLConnection.getHeaderField(i4));
        }
        return hashMap;
    }

    public static ok ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                hashMap.put(blVar.ok(), blVar.a());
            }
        }
        HttpURLConnection ok2 = ok(str, hashMap);
        if (ok2 != null && (responseCode = ok2.getResponseCode()) >= 200 && responseCode < 300) {
            Map<String, String> ok3 = ok(ok2);
            InputStream inputStream = ok2.getInputStream();
            String contentEncoding = ok2.getContentEncoding();
            if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
                inputStream = new GZIPInputStream(inputStream);
            }
            return new ok(inputStream, ok3, responseCode, ok2);
        }
        return null;
    }
}
