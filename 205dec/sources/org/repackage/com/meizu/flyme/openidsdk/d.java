package org.repackage.com.meizu.flyme.openidsdk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    public String f61603a;

    /* renamed from: b  reason: collision with root package name */
    public int f61604b;

    /* renamed from: c  reason: collision with root package name */
    public long f61605c = System.currentTimeMillis() + 86400000;

    public d(String str, int i4) {
        this.f61603a = str;
        this.f61604b = i4;
    }

    public String toString() {
        return "ValueData{value='" + this.f61603a + "', code=" + this.f61604b + ", expired=" + this.f61605c + '}';
    }
}
