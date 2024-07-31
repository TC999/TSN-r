package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AttrExistsExpr extends AttrExpr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrExistsExpr(String str) {
        super(str);
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35074o(this);
    }

    @Override // com.p200hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return "[" + super.toString() + "]";
    }
}
