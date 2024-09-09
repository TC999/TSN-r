package cn.jiguang.bw;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private C0057a[] f3015a = new C0057a[17];

    /* renamed from: cn.jiguang.bw.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class C0057a {

        /* renamed from: a  reason: collision with root package name */
        g f3016a;

        /* renamed from: b  reason: collision with root package name */
        int f3017b;

        /* renamed from: c  reason: collision with root package name */
        C0057a f3018c;

        private C0057a() {
        }
    }

    public int a(g gVar) {
        int i4 = -1;
        for (C0057a c0057a = this.f3015a[(gVar.hashCode() & Integer.MAX_VALUE) % 17]; c0057a != null; c0057a = c0057a.f3018c) {
            if (c0057a.f3016a.equals(gVar)) {
                i4 = c0057a.f3017b;
            }
        }
        return i4;
    }

    public void a(int i4, g gVar) {
        if (i4 > 16383) {
            return;
        }
        int hashCode = (gVar.hashCode() & Integer.MAX_VALUE) % 17;
        C0057a c0057a = new C0057a();
        c0057a.f3016a = gVar;
        c0057a.f3017b = i4;
        C0057a[] c0057aArr = this.f3015a;
        c0057a.f3018c = c0057aArr[hashCode];
        c0057aArr[hashCode] = c0057a;
    }
}
