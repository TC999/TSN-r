package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ar */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12831ar implements Comparable<C12831ar> {

    /* renamed from: a */
    public long f36587a = -1;

    /* renamed from: b */
    public long f36588b = -1;

    /* renamed from: c */
    public String f36589c = null;

    /* renamed from: d */
    public boolean f36590d = false;

    /* renamed from: e */
    public boolean f36591e = false;

    /* renamed from: f */
    public int f36592f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C12831ar c12831ar) {
        C12831ar c12831ar2 = c12831ar;
        if (c12831ar2 != null) {
            long j = this.f36588b - c12831ar2.f36588b;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
            return 1;
        }
        return 1;
    }
}
