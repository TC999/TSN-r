package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AttrExpr extends BooleanExpr {

    /* renamed from: a */
    private final String f23967a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrExpr(String str) {
        this.f23967a = str;
    }

    /* renamed from: b */
    public String m35086b() {
        return this.f23967a;
    }

    public String toString() {
        return "@" + this.f23967a;
    }
}
