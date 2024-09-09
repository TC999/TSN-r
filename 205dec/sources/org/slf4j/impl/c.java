package org.slf4j.impl;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StaticLoggerBinder.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c implements l3.b {

    /* renamed from: b  reason: collision with root package name */
    private static final c f61768b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static String f61769c = "1.6.99";

    /* renamed from: d  reason: collision with root package name */
    private static final String f61770d = b.class.getName();

    /* renamed from: a  reason: collision with root package name */
    private final org.slf4j.a f61771a = new b();

    private c() {
    }

    public static c c() {
        return f61768b;
    }

    @Override // l3.b
    public org.slf4j.a a() {
        return this.f61771a;
    }

    @Override // l3.b
    public String b() {
        return f61770d;
    }
}
