package com.amap.api.col.p0463l;

@EntityClass(m54740a = "update_item_download_info")
/* renamed from: com.amap.api.col.3l.n0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class DTDownloadInfo {
    @EntityField(m54738a = "mAdcode", m54737b = 6)

    /* renamed from: a */
    private String f4728a;
    @EntityField(m54738a = "fileLength", m54737b = 5)

    /* renamed from: b */
    private long f4729b;
    @EntityField(m54738a = "splitter", m54737b = 2)

    /* renamed from: c */
    private int f4730c;
    @EntityField(m54738a = "startPos", m54737b = 5)

    /* renamed from: d */
    private long f4731d;
    @EntityField(m54738a = "endPos", m54737b = 5)

    /* renamed from: e */
    private long f4732e;

    public DTDownloadInfo() {
        this.f4728a = "";
        this.f4729b = 0L;
        this.f4730c = 0;
        this.f4731d = 0L;
        this.f4732e = 0L;
    }

    /* renamed from: a */
    public static String m54452a(String str) {
        return "mAdcode='" + str + "'";
    }

    public DTDownloadInfo(String str, long j, int i, long j2, long j3) {
        this.f4728a = str;
        this.f4729b = j;
        this.f4730c = i;
        this.f4731d = j2;
        this.f4732e = j3;
    }
}
