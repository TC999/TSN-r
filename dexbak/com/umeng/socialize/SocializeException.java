package com.umeng.socialize;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocializeException extends RuntimeException {

    /* renamed from: b */
    private static final long f39264b = 1;

    /* renamed from: a */
    protected int f39265a;

    /* renamed from: c */
    private String f39266c;

    public SocializeException(int i, String str) {
        super(str);
        this.f39265a = i;
        this.f39266c = str;
    }

    public int getErrorCode() {
        return this.f39265a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f39266c;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.f39265a = 5000;
        this.f39266c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.f39265a = 5000;
        this.f39266c = str;
    }
}
