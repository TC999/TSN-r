package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class TextCompareExpr extends BooleanExpr {

    /* renamed from: a */
    private final String f23991a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextCompareExpr(String str) {
        this.f23991a = str;
    }

    /* renamed from: b */
    public String m35055b() {
        return this.f23991a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public String m35054c(String str) {
        return "[text()" + str + "'" + this.f23991a + "']";
    }
}
