package com.hp.hpl.sparta.xpath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AttrExpr.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String f37450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f37450a = str;
    }

    public String b() {
        return this.f37450a;
    }

    public String toString() {
        return "@" + this.f37450a;
    }
}
