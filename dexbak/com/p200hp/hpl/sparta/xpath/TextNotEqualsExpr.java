package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TextNotEqualsExpr extends TextCompareExpr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TextNotEqualsExpr(String str) {
        super(str);
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35081d(this);
    }

    public String toString() {
        return m35054c("!=");
    }
}
