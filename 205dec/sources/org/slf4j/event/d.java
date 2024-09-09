package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SubstituteLoggingEvent.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    Level f61732a;

    /* renamed from: b  reason: collision with root package name */
    Marker f61733b;

    /* renamed from: c  reason: collision with root package name */
    String f61734c;

    /* renamed from: d  reason: collision with root package name */
    h f61735d;

    /* renamed from: e  reason: collision with root package name */
    String f61736e;

    /* renamed from: f  reason: collision with root package name */
    String f61737f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f61738g;

    /* renamed from: h  reason: collision with root package name */
    long f61739h;

    /* renamed from: i  reason: collision with root package name */
    Throwable f61740i;

    @Override // org.slf4j.event.c
    public Object[] a() {
        return this.f61738g;
    }

    @Override // org.slf4j.event.c
    public Marker b() {
        return this.f61733b;
    }

    @Override // org.slf4j.event.c
    public String c() {
        return this.f61736e;
    }

    @Override // org.slf4j.event.c
    public long d() {
        return this.f61739h;
    }

    @Override // org.slf4j.event.c
    public String e() {
        return this.f61734c;
    }

    @Override // org.slf4j.event.c
    public Level f() {
        return this.f61732a;
    }

    @Override // org.slf4j.event.c
    public Throwable g() {
        return this.f61740i;
    }

    @Override // org.slf4j.event.c
    public String getMessage() {
        return this.f61737f;
    }

    public h h() {
        return this.f61735d;
    }

    public void i(Object[] objArr) {
        this.f61738g = objArr;
    }

    public void j(Level level) {
        this.f61732a = level;
    }

    public void k(h hVar) {
        this.f61735d = hVar;
    }

    public void l(String str) {
        this.f61734c = str;
    }

    public void m(Marker marker) {
        this.f61733b = marker;
    }

    public void n(String str) {
        this.f61737f = str;
    }

    public void o(String str) {
        this.f61736e = str;
    }

    public void p(Throwable th) {
        this.f61740i = th;
    }

    public void q(long j4) {
        this.f61739h = j4;
    }
}
