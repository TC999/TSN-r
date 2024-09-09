package com.hp.hpl.sparta.xpath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AttrCompareExpr.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private final String f37444b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        super(str);
        this.f37444b = com.hp.hpl.sparta.q.a(str2);
    }

    public String c() {
        return this.f37444b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(String str) {
        return "[" + super.toString() + str + "'" + this.f37444b + "']";
    }
}
