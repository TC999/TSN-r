package com.p521ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ss.android.downloadlib.addownload.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12092kf {

    /* renamed from: a */
    private final ConcurrentHashMap<String, String> f34217a;

    /* renamed from: ok */
    private final ConcurrentHashMap<String, String> f34218ok;

    /* renamed from: com.ss.android.downloadlib.addownload.kf$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12094ok {

        /* renamed from: ok */
        private static C12092kf f34219ok = new C12092kf();
    }

    /* renamed from: bl */
    private String m19117bl(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (TextUtils.equals("https", scheme) && lastPathSegment.endsWith(".apk")) {
                this.f34218ok.put(str, lastPathSegment);
                return lastPathSegment;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ok */
    public static C12092kf m19116ok() {
        return C12094ok.f34219ok;
    }

    /* renamed from: a */
    public void m19118a(String str) {
        Iterator<Map.Entry<String, String>> it = this.f34217a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.f34218ok.remove(next.getKey());
            }
        }
    }

    private C12092kf() {
        this.f34218ok = new ConcurrentHashMap<>();
        this.f34217a = new ConcurrentHashMap<>();
    }

    /* renamed from: ok */
    public void m19113ok(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.f34217a.containsKey(str2)) {
            return;
        }
        this.f34217a.put(str2, str);
    }

    /* renamed from: ok */
    public String m19114ok(String str) {
        if (TextUtils.isEmpty(str) || this.f34217a.isEmpty() || !this.f34217a.containsKey(str)) {
            return null;
        }
        String m19117bl = m19117bl(str);
        if (this.f34218ok.containsValue(m19117bl)) {
            for (Map.Entry<String, String> entry : this.f34218ok.entrySet()) {
                if (TextUtils.equals(entry.getValue(), m19117bl)) {
                    String str2 = this.f34217a.get(entry.getKey());
                    this.f34217a.put(str, str2);
                    if (!this.f34218ok.containsKey(str)) {
                        this.f34218ok.put(str, m19117bl);
                    }
                    return str2;
                }
            }
        }
        return this.f34217a.get(str);
    }

    /* renamed from: ok */
    public String m19115ok(DownloadModel downloadModel) {
        String m19117bl = m19117bl(downloadModel.getDownloadUrl());
        if (m19117bl == null || TextUtils.isEmpty(m19117bl)) {
            return null;
        }
        String m16578n = C12713kf.m16578n(m19117bl + downloadModel.getPackageName());
        this.f34217a.put(downloadModel.getDownloadUrl(), m16578n);
        return m16578n;
    }
}
