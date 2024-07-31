package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class PositionEqualsExpr extends BooleanExpr {

    /* renamed from: a */
    private final int f23972a;

    public PositionEqualsExpr(int i) {
        this.f23972a = i;
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35080e(this);
    }

    /* renamed from: b */
    public int m35064b() {
        return this.f23972a;
    }

    public String toString() {
        return "[" + this.f23972a + "]";
    }
}
