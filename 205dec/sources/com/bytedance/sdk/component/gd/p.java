package com.bytedance.sdk.component.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class p implements Comparable<p>, Runnable {

    /* renamed from: c  reason: collision with root package name */
    private int f29845c;

    /* renamed from: w  reason: collision with root package name */
    private String f29846w;

    public p(String str, int i4) {
        this.f29845c = 0;
        this.f29845c = i4 == 0 ? 5 : i4;
        this.f29846w = str;
    }

    public void c(int i4) {
        this.f29845c = i4;
    }

    public int c() {
        return this.f29845c;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(p pVar) {
        if (c() < pVar.c()) {
            return 1;
        }
        return c() >= pVar.c() ? -1 : 0;
    }

    public p(String str) {
        this.f29845c = 5;
        this.f29846w = str;
    }
}
