package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.cl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TField {

    /* renamed from: a */
    public final String f38028a;

    /* renamed from: b */
    public final byte f38029b;

    /* renamed from: c */
    public final short f38030c;

    public TField() {
        this("", (byte) 0, (short) 0);
    }

    /* renamed from: a */
    public boolean m14444a(TField tField) {
        return this.f38029b == tField.f38029b && this.f38030c == tField.f38030c;
    }

    public String toString() {
        return "<TField name:'" + this.f38028a + "' type:" + ((int) this.f38029b) + " field-id:" + ((int) this.f38030c) + ">";
    }

    public TField(String str, byte b, short s) {
        this.f38028a = str;
        this.f38029b = b;
        this.f38030c = s;
    }
}
