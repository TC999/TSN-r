package org.slf4j.helpers;

/* renamed from: org.slf4j.helpers.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class FormattingTuple {

    /* renamed from: d */
    public static FormattingTuple f44345d = new FormattingTuple(null);

    /* renamed from: a */
    private String f44346a;

    /* renamed from: b */
    private Throwable f44347b;

    /* renamed from: c */
    private Object[] f44348c;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    /* renamed from: a */
    public Object[] m2605a() {
        return this.f44348c;
    }

    /* renamed from: b */
    public String m2604b() {
        return this.f44346a;
    }

    /* renamed from: c */
    public Throwable m2603c() {
        return this.f44347b;
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.f44346a = str;
        this.f44347b = th;
        this.f44348c = objArr;
    }
}
