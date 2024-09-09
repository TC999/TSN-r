package com.amap.api.col.p0003l;

import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TimeoutDownloadManager.java */
@Deprecated
/* renamed from: com.amap.api.col.3l.z6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z6 extends t6 {
    public z6(Cif cif) {
        super(cif);
    }

    public z6(Cif cif, long j4, long j5, boolean z3) {
        super(cif, j4, j5, z3);
    }

    /* compiled from: URIRestrictManager.java */
    /* renamed from: com.amap.api.col.3l.z6$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9585a;

        /* renamed from: b  reason: collision with root package name */
        public String f9586b;

        /* renamed from: c  reason: collision with root package name */
        public String f9587c;

        public a(URL url) {
            this.f9585a = url.getProtocol();
            this.f9586b = url.getHost();
            this.f9587c = url.getPath();
        }

        public a(String str, String str2) {
            this.f9585a = null;
            this.f9586b = str;
            this.f9587c = str2;
        }
    }
}
