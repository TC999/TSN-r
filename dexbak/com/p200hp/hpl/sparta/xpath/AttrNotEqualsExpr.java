package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AttrNotEqualsExpr extends AttrCompareExpr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrNotEqualsExpr(String str, String str2) {
        super(str, str2);
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35079f(this);
    }

    @Override // com.p200hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return m35096d("!=");
    }
}
