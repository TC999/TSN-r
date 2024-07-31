package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.cr */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TProtocolException extends TException {

    /* renamed from: a */
    public static final int f38044a = 0;

    /* renamed from: b */
    public static final int f38045b = 1;

    /* renamed from: c */
    public static final int f38046c = 2;

    /* renamed from: d */
    public static final int f38047d = 3;

    /* renamed from: e */
    public static final int f38048e = 4;

    /* renamed from: f */
    public static final int f38049f = 5;

    /* renamed from: h */
    private static final long f38050h = 1;

    /* renamed from: g */
    protected int f38051g;

    public TProtocolException() {
        this.f38051g = 0;
    }

    /* renamed from: a */
    public int m14399a() {
        return this.f38051g;
    }

    public TProtocolException(int i) {
        this.f38051g = i;
    }

    public TProtocolException(int i, String str) {
        super(str);
        this.f38051g = i;
    }

    public TProtocolException(String str) {
        super(str);
        this.f38051g = 0;
    }

    public TProtocolException(int i, Throwable th) {
        super(th);
        this.f38051g = i;
    }

    public TProtocolException(Throwable th) {
        super(th);
        this.f38051g = 0;
    }

    public TProtocolException(String str, Throwable th) {
        super(str, th);
        this.f38051g = 0;
    }

    public TProtocolException(int i, String str, Throwable th) {
        super(str, th);
        this.f38051g = i;
    }
}
