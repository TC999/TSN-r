package com.tencent.mm.opensdk.diffdev.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    

    /* renamed from: a  reason: collision with root package name */
    private int f51613a;

    d(int i4) {
        this.f51613a = i4;
    }

    public int a() {
        return this.f51613a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f51613a;
    }
}
