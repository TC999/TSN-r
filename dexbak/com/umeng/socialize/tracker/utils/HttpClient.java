package com.umeng.socialize.tracker.utils;

import java.util.Map;

/* renamed from: com.umeng.socialize.tracker.utils.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpClient {

    /* renamed from: a */
    private static final String f39623a = "HttpClient";

    /* renamed from: b */
    private String f39624b;

    /* renamed from: c */
    private EnumC13464a f39625c;

    /* renamed from: d */
    private Map<String, String> f39626d;

    /* renamed from: e */
    private HttpRequestListener f39627e;

    /* compiled from: HttpClient.java */
    /* renamed from: com.umeng.socialize.tracker.utils.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13464a {
        POST,
        GET
    }

    public HttpClient(String str, EnumC13464a enumC13464a, Map<String, String> map, HttpRequestListener httpRequestListener) {
        this.f39624b = str;
        this.f39625c = enumC13464a;
        this.f39626d = map;
        this.f39627e = httpRequestListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c9, code lost:
        if (r1 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d4, code lost:
        if (r1 == null) goto L44;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01cd: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:85:0x01d2, block:B:83:0x01cd */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m13214a(int r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.tracker.utils.HttpClient.m13214a(int, java.lang.String):java.lang.String");
    }
}
