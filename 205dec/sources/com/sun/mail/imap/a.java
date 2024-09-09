package com.sun.mail.imap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ACL.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f50307a;

    /* renamed from: b  reason: collision with root package name */
    private n f50308b;

    public a(String str) {
        this.f50307a = str;
        this.f50308b = new n();
    }

    public String a() {
        return this.f50307a;
    }

    public n b() {
        return this.f50308b;
    }

    public void c(n nVar) {
        this.f50308b = nVar;
    }

    public Object clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        aVar.f50308b = (n) this.f50308b.clone();
        return aVar;
    }

    public a(String str, n nVar) {
        this.f50307a = str;
        this.f50308b = nVar;
    }
}
