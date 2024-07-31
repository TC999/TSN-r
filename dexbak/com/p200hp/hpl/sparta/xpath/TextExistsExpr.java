package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TextExistsExpr extends BooleanExpr {

    /* renamed from: a */
    static final TextExistsExpr f23992a = new TextExistsExpr();

    private TextExistsExpr() {
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExpr
    /* renamed from: a */
    public void mo35053a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.mo35078g(this);
    }

    public String toString() {
        return "[text()]";
    }
}
