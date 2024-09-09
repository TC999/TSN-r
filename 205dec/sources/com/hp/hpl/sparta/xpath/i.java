package com.hp.hpl.sparta.xpath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AttrRelationalExpr.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class i extends e {

    /* renamed from: b  reason: collision with root package name */
    private final int f37451b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, int i4) {
        super(str);
        this.f37451b = i4;
    }

    public double c() {
        return this.f37451b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(String str) {
        return "[" + super.toString() + str + "'" + this.f37451b + "']";
    }
}
