package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AttrLessExpr extends AttrRelationalExpr {
    public AttrLessExpr(String str, int i) {
        super(str, i);
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35075m(this);
    }

    @Override // com.p200hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return m35084d("<");
    }
}
