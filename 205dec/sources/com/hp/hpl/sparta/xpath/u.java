package com.hp.hpl.sparta.xpath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: TextCompareExpr.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class u extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String f37474a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str) {
        this.f37474a = str;
    }

    public String b() {
        return this.f37474a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        return "[text()" + str + "'" + this.f37474a + "']";
    }
}
