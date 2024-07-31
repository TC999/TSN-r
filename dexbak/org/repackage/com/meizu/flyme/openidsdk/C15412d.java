package org.repackage.com.meizu.flyme.openidsdk;

/* renamed from: org.repackage.com.meizu.flyme.openidsdk.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C15412d {

    /* renamed from: a */
    public String f44177a;

    /* renamed from: b */
    public int f44178b;

    /* renamed from: c */
    public long f44179c = System.currentTimeMillis() + 86400000;

    public C15412d(String str, int i) {
        this.f44177a = str;
        this.f44178b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f44177a + "', code=" + this.f44178b + ", expired=" + this.f44179c + '}';
    }
}
