package com.umeng.socialize;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocializeException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private static final long f53853b = 1;

    /* renamed from: a  reason: collision with root package name */
    protected int f53854a;

    /* renamed from: c  reason: collision with root package name */
    private String f53855c;

    public SocializeException(int i4, String str) {
        super(str);
        this.f53854a = i4;
        this.f53855c = str;
    }

    public int getErrorCode() {
        return this.f53854a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f53855c;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.f53854a = 5000;
        this.f53855c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.f53854a = 5000;
        this.f53855c = str;
    }
}
