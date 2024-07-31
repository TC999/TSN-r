package com.umeng.socialize.net.dplus.cache1;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class IReader<T> {

    /* renamed from: a */
    private String f39577a;
    public T result;

    public IReader(String str) {
        this.f39577a = str;
    }

    public static double formatSize(long j) {
        double d = j;
        Double.isNaN(d);
        return (d / 1024.0d) / 1024.0d;
    }

    public abstract void create(String str);

    public String getLogFileName() {
        return this.f39577a;
    }
}
