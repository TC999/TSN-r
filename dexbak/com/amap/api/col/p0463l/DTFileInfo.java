package com.amap.api.col.p0463l;

import master.flame.danmaku.danmaku.parser.IDataSource;

@EntityClass(m54740a = "update_item_file")
/* renamed from: com.amap.api.col.3l.o0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class DTFileInfo {
    @EntityField(m54738a = "mAdcode", m54737b = 6)

    /* renamed from: a */
    private String f4767a;
    @EntityField(m54738a = IDataSource.f43973c, m54737b = 6)

    /* renamed from: b */
    private String f4768b;

    public DTFileInfo() {
        this.f4767a = "";
        this.f4768b = "";
    }

    /* renamed from: b */
    public static String m54416b(String str) {
        return "mAdcode='" + str + "'";
    }

    /* renamed from: a */
    public final String m54417a() {
        return this.f4768b;
    }

    public DTFileInfo(String str, String str2) {
        this.f4767a = str;
        this.f4768b = str2;
    }
}
