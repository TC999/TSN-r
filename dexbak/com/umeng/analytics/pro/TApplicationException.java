package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.bq */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TApplicationException extends TException {

    /* renamed from: a */
    public static final int f37939a = 0;

    /* renamed from: b */
    public static final int f37940b = 1;

    /* renamed from: c */
    public static final int f37941c = 2;

    /* renamed from: d */
    public static final int f37942d = 3;

    /* renamed from: e */
    public static final int f37943e = 4;

    /* renamed from: f */
    public static final int f37944f = 5;

    /* renamed from: g */
    public static final int f37945g = 6;

    /* renamed from: h */
    public static final int f37946h = 7;

    /* renamed from: j */
    private static final TStruct f37947j = new TStruct("TApplicationException");

    /* renamed from: k */
    private static final TField f37948k = new TField("message", (byte) 11, 1);

    /* renamed from: l */
    private static final TField f37949l = new TField("type", (byte) 8, 2);

    /* renamed from: m */
    private static final long f37950m = 1;

    /* renamed from: i */
    protected int f37951i;

    public TApplicationException() {
        this.f37951i = 0;
    }

    /* renamed from: a */
    public int m14547a() {
        return this.f37951i;
    }

    /* renamed from: b */
    public void m14545b(TProtocol tProtocol) throws TException {
        tProtocol.mo14429a(f37947j);
        if (getMessage() != null) {
            tProtocol.mo14434a(f37948k);
            tProtocol.mo14428a(getMessage());
            tProtocol.mo14423c();
        }
        tProtocol.mo14434a(f37949l);
        tProtocol.mo14436a(this.f37951i);
        tProtocol.mo14423c();
        tProtocol.mo14422d();
        tProtocol.mo14424b();
    }

    /* renamed from: a */
    public static TApplicationException m14546a(TProtocol tProtocol) throws TException {
        tProtocol.mo14416j();
        String str = null;
        int i = 0;
        while (true) {
            TField mo14414l = tProtocol.mo14414l();
            byte b = mo14414l.f38029b;
            if (b == 0) {
                tProtocol.mo14415k();
                return new TApplicationException(i, str);
            }
            short s = mo14414l.f38030c;
            if (s != 1) {
                if (s != 2) {
                    TProtocolUtil.m14397a(tProtocol, b);
                } else if (b == 8) {
                    i = tProtocol.mo14403w();
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
            } else if (b == 11) {
                str = tProtocol.mo14400z();
            } else {
                TProtocolUtil.m14397a(tProtocol, b);
            }
            tProtocol.mo14413m();
        }
    }

    public TApplicationException(int i) {
        this.f37951i = i;
    }

    public TApplicationException(int i, String str) {
        super(str);
        this.f37951i = i;
    }

    public TApplicationException(String str) {
        super(str);
        this.f37951i = 0;
    }
}
