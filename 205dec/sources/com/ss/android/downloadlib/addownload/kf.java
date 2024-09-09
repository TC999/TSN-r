package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f48536a;
    private final ConcurrentHashMap<String, String> ok;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {
        private static kf ok = new kf();
    }

    private String bl(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (TextUtils.equals("https", scheme) && lastPathSegment.endsWith(".apk")) {
                this.ok.put(str, lastPathSegment);
                return lastPathSegment;
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static kf ok() {
        return ok.ok;
    }

    public void a(String str) {
        Iterator<Map.Entry<String, String>> it = this.f48536a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.ok.remove(next.getKey());
            }
        }
    }

    private kf() {
        this.ok = new ConcurrentHashMap<>();
        this.f48536a = new ConcurrentHashMap<>();
    }

    public void ok(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.f48536a.containsKey(str2)) {
            return;
        }
        this.f48536a.put(str2, str);
    }

    public String ok(String str) {
        if (TextUtils.isEmpty(str) || this.f48536a.isEmpty() || !this.f48536a.containsKey(str)) {
            return null;
        }
        String bl = bl(str);
        if (this.ok.containsValue(bl)) {
            for (Map.Entry<String, String> entry : this.ok.entrySet()) {
                if (TextUtils.equals(entry.getValue(), bl)) {
                    String str2 = this.f48536a.get(entry.getKey());
                    this.f48536a.put(str, str2);
                    if (!this.ok.containsKey(str)) {
                        this.ok.put(str, bl);
                    }
                    return str2;
                }
            }
        }
        return this.f48536a.get(str);
    }

    public String ok(DownloadModel downloadModel) {
        String bl = bl(downloadModel.getDownloadUrl());
        if (bl == null || TextUtils.isEmpty(bl)) {
            return null;
        }
        String n4 = com.ss.android.socialbase.downloader.q.kf.n(bl + downloadModel.getPackageName());
        this.f48536a.put(downloadModel.getDownloadUrl(), n4);
        return n4;
    }
}
