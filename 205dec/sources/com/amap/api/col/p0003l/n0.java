package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DTDownloadInfo.java */
@hk(a = "update_item_download_info")
/* renamed from: com.amap.api.col.3l.n0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class n0 {
    @hl(a = "mAdcode", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f8363a;
    @hl(a = "fileLength", b = 5)

    /* renamed from: b  reason: collision with root package name */
    private long f8364b;
    @hl(a = "splitter", b = 2)

    /* renamed from: c  reason: collision with root package name */
    private int f8365c;
    @hl(a = "startPos", b = 5)

    /* renamed from: d  reason: collision with root package name */
    private long f8366d;
    @hl(a = "endPos", b = 5)

    /* renamed from: e  reason: collision with root package name */
    private long f8367e;

    public n0() {
        this.f8363a = "";
        this.f8364b = 0L;
        this.f8365c = 0;
        this.f8366d = 0L;
        this.f8367e = 0L;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }

    public n0(String str, long j4, int i4, long j5, long j6) {
        this.f8363a = str;
        this.f8364b = j4;
        this.f8365c = i4;
        this.f8366d = j5;
        this.f8367e = j6;
    }
}
