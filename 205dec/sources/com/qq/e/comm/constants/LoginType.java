package com.qq.e.comm.constants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);
    

    /* renamed from: a  reason: collision with root package name */
    private int f41609a;

    LoginType(int i4) {
        this.f41609a = i4;
        ordinal();
    }

    public int getValue() {
        return this.f41609a;
    }
}
