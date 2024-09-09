package com.hp.hpl.sparta.xpath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: PositionEqualsExpr.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class r extends k {

    /* renamed from: a  reason: collision with root package name */
    private final int f37455a;

    public r(int i4) {
        this.f37455a = i4;
    }

    @Override // com.hp.hpl.sparta.xpath.k
    public void a(l lVar) throws XPathException {
        lVar.e(this);
    }

    public int b() {
        return this.f37455a;
    }

    public String toString() {
        return "[" + this.f37455a + "]";
    }
}
