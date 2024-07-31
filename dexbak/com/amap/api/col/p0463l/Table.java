package com.amap.api.col.p0463l;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* renamed from: com.amap.api.col.3l.v9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Table {

    /* renamed from: a */
    private static final ThreadLocal<CharsetDecoder> f5569a = new C1973a();

    /* renamed from: b */
    public static final ThreadLocal<Charset> f5570b = new C1974b();

    /* renamed from: c */
    private static final ThreadLocal<CharBuffer> f5571c = new ThreadLocal<>();

    /* compiled from: Table.java */
    /* renamed from: com.amap.api.col.3l.v9$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C1973a extends ThreadLocal<CharsetDecoder> {
        C1973a() {
        }

        /* renamed from: a */
        private static CharsetDecoder m53632a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return m53632a();
        }
    }

    /* compiled from: Table.java */
    /* renamed from: com.amap.api.col.3l.v9$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C1974b extends ThreadLocal<Charset> {
        C1974b() {
        }

        /* renamed from: a */
        private static Charset m53631a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return m53631a();
        }
    }
}
