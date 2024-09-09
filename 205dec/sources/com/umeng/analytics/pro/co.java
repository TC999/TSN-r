package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TMessage.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class co {

    /* renamed from: a  reason: collision with root package name */
    public final String f52822a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f52823b;

    /* renamed from: c  reason: collision with root package name */
    public final int f52824c;

    public co() {
        this("", (byte) 0, 0);
    }

    public boolean a(co coVar) {
        return this.f52822a.equals(coVar.f52822a) && this.f52823b == coVar.f52823b && this.f52824c == coVar.f52824c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof co) {
            return a((co) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f52822a + "' type: " + ((int) this.f52823b) + " seqid:" + this.f52824c + ">";
    }

    public co(String str, byte b4, int i4) {
        this.f52822a = str;
        this.f52823b = b4;
        this.f52824c = i4;
    }
}
