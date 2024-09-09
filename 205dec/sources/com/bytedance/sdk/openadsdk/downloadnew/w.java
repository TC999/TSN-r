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

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public InputStream f35827c;
        public HttpURLConnection sr;

        /* renamed from: w  reason: collision with root package name */
        public Map<String, String> f35828w;
        public int xv;

        public c(InputStream inputStream, Map<String, String> map, int i4, HttpURLConnection httpURLConnection) {
            this.f35827c = inputStream;
            this.f35828w = map;
            this.xv = i4;
            this.sr = httpURLConnection;
        }
    }

    public static HttpURLConnection c(String str, Map<String, String> map) {
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
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? c(httpURLConnection3.getHeaderField("Location"), map) : httpURLConnection3;
            } catch (Exception unused) {
                httpURLConnection2 = httpURLConnection;
                return httpURLConnection2;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> c(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i4 = 0; i4 < size; i4++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i4), httpURLConnection.getHeaderField(i4));
        }
        return hashMap;
    }

    public static c c(String str, List<com.ss.android.socialbase.downloader.model.xv> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.xv xvVar : list) {
                hashMap.put(xvVar.c(), xvVar.w());
            }
        }
        HttpURLConnection c4 = c(str, hashMap);
        if (c4 != null && (responseCode = c4.getResponseCode()) >= 200 && responseCode < 300) {
            Map<String, String> c5 = c(c4);
            InputStream inputStream = c4.getInputStream();
            String contentEncoding = c4.getContentEncoding();
            if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
                inputStream = new GZIPInputStream(inputStream);
            }
            return new c(inputStream, c5, responseCode, c4);
        }
        return null;
    }
}
