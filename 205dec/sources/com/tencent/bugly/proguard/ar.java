package com.tencent.bugly.proguard;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ar implements Comparable<ar> {

    /* renamed from: a  reason: collision with root package name */
    public long f50961a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f50962b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f50963c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50964d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50965e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f50966f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        ar arVar2 = arVar;
        if (arVar2 != null) {
            long j4 = this.f50962b - arVar2.f50962b;
            if (j4 <= 0) {
                return j4 < 0 ? -1 : 0;
            }
            return 1;
        }
        return 1;
    }
}
