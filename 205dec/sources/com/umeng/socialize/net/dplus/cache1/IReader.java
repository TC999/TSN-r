package com.umeng.socialize.net.dplus.cache1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class IReader<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f54152a;
    public T result;

    public IReader(String str) {
        this.f54152a = str;
    }

    public static double formatSize(long j4) {
        double d4 = j4;
        Double.isNaN(d4);
        return (d4 / 1024.0d) / 1024.0d;
    }

    public abstract void create(String str);

    public String getLogFileName() {
        return this.f54152a;
    }
}
