package com.hp.hpl.sparta.xpath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AttrTest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class j extends o {

    /* renamed from: a  reason: collision with root package name */
    private final String f37452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str) {
        this.f37452a = str;
    }

    @Override // com.hp.hpl.sparta.xpath.o
    public void a(b0 b0Var) {
        b0Var.b(this);
    }

    @Override // com.hp.hpl.sparta.xpath.o
    public boolean b() {
        return true;
    }

    public String c() {
        return this.f37452a;
    }

    public String toString() {
        return "@" + this.f37452a;
    }
}
