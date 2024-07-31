package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AttrEqualsExpr extends AttrCompareExpr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrEqualsExpr(String str, String str2) {
        super(str, str2);
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35076j(this);
    }

    @Override // com.p200hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return m35096d("=");
    }
}
