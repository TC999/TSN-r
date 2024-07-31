package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.df */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TTransportException extends TException {

    /* renamed from: a */
    public static final int f38167a = 0;

    /* renamed from: b */
    public static final int f38168b = 1;

    /* renamed from: c */
    public static final int f38169c = 2;

    /* renamed from: d */
    public static final int f38170d = 3;

    /* renamed from: e */
    public static final int f38171e = 4;

    /* renamed from: g */
    private static final long f38172g = 1;

    /* renamed from: f */
    protected int f38173f;

    public TTransportException() {
        this.f38173f = 0;
    }

    /* renamed from: a */
    public int m14372a() {
        return this.f38173f;
    }

    public TTransportException(int i) {
        this.f38173f = i;
    }

    public TTransportException(int i, String str) {
        super(str);
        this.f38173f = i;
    }

    public TTransportException(String str) {
        super(str);
        this.f38173f = 0;
    }

    public TTransportException(int i, Throwable th) {
        super(th);
        this.f38173f = i;
    }

    public TTransportException(Throwable th) {
        super(th);
        this.f38173f = 0;
    }

    public TTransportException(String str, Throwable th) {
        super(str, th);
        this.f38173f = 0;
    }

    public TTransportException(int i, String str, Throwable th) {
        super(str, th);
        this.f38173f = i;
    }
}
