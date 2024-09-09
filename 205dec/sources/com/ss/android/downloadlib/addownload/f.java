package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f48533c;

    /* renamed from: w  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f48534w;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static f f48535c = new f();
    }

    public static f c() {
        return c.f48535c;
    }

    private String xv(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (TextUtils.equals("https", scheme) && lastPathSegment.endsWith(".apk")) {
                this.f48533c.put(str, lastPathSegment);
                return lastPathSegment;
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void w(String str) {
        Iterator<Map.Entry<String, String>> it = this.f48534w.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.f48533c.remove(next.getKey());
            }
        }
    }

    private f() {
        this.f48533c = new ConcurrentHashMap<>();
        this.f48534w = new ConcurrentHashMap<>();
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.f48534w.containsKey(str2)) {
            return;
        }
        this.f48534w.put(str2, str);
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str) || this.f48534w.isEmpty() || !this.f48534w.containsKey(str)) {
            return null;
        }
        String xv = xv(str);
        if (this.f48533c.containsValue(xv)) {
            for (Map.Entry<String, String> entry : this.f48533c.entrySet()) {
                if (TextUtils.equals(entry.getValue(), xv)) {
                    String str2 = this.f48534w.get(entry.getKey());
                    this.f48534w.put(str, str2);
                    if (!this.f48533c.containsKey(str)) {
                        this.f48533c.put(str, xv);
                    }
                    return str2;
                }
            }
        }
        return this.f48534w.get(str);
    }

    public String c(DownloadModel downloadModel) {
        String xv = xv(downloadModel.getDownloadUrl());
        if (xv == null || TextUtils.isEmpty(xv)) {
            return null;
        }
        String ux = com.ss.android.socialbase.downloader.gd.f.ux(xv + downloadModel.getPackageName());
        this.f48534w.put(downloadModel.getDownloadUrl(), ux);
        return ux;
    }
}
