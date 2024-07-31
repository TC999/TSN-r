package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AttrRelationalExpr extends AttrExpr {

    /* renamed from: b */
    private final int f23968b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrRelationalExpr(String str, int i) {
        super(str);
        this.f23968b = i;
    }

    /* renamed from: c */
    public double m35085c() {
        return this.f23968b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public String m35084d(String str) {
        return "[" + super.toString() + str + "'" + this.f23968b + "']";
    }
}
