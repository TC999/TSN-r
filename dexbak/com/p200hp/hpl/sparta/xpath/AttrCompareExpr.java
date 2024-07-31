package com.p200hp.hpl.sparta.xpath;

import com.p200hp.hpl.sparta.Sparta;

/* renamed from: com.hp.hpl.sparta.xpath.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AttrCompareExpr extends AttrExpr {

    /* renamed from: b */
    private final String f23961b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrCompareExpr(String str, String str2) {
        super(str);
        this.f23961b = Sparta.m35124a(str2);
    }

    /* renamed from: c */
    public String m35097c() {
        return this.f23961b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public String m35096d(String str) {
        return "[" + super.toString() + str + "'" + this.f23961b + "']";
    }
}
