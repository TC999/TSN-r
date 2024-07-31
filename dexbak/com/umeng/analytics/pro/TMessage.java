package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.co */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class TMessage {

    /* renamed from: a */
    public final String f38036a;

    /* renamed from: b */
    public final byte f38037b;

    /* renamed from: c */
    public final int f38038c;

    public TMessage() {
        this("", (byte) 0, 0);
    }

    /* renamed from: a */
    public boolean m14443a(TMessage tMessage) {
        return this.f38036a.equals(tMessage.f38036a) && this.f38037b == tMessage.f38037b && this.f38038c == tMessage.f38038c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TMessage) {
            return m14443a((TMessage) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f38036a + "' type: " + ((int) this.f38037b) + " seqid:" + this.f38038c + ">";
    }

    public TMessage(String str, byte b, int i) {
        this.f38036a = str;
        this.f38037b = b;
        this.f38038c = i;
    }
}
