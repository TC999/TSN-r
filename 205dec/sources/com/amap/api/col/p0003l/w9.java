package com.amap.api.col.p0003l;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Table.java */
/* renamed from: com.amap.api.col.3l.w9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class w9 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f9371a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Charset> f9372b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<CharBuffer> f9373c = new ThreadLocal<>();

    /* compiled from: Table.java */
    /* renamed from: com.amap.api.col.3l.w9$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a extends ThreadLocal<CharsetDecoder> {
        a() {
        }

        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    /* compiled from: Table.java */
    /* renamed from: com.amap.api.col.3l.w9$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class b extends ThreadLocal<Charset> {
        b() {
        }

        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return a();
        }
    }
}
