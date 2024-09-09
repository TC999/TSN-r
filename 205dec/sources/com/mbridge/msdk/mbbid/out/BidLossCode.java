package com.mbridge.msdk.mbbid.out;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BidLossCode {

    /* renamed from: a  reason: collision with root package name */
    private static int f40014a;

    private BidLossCode(int i4) {
        f40014a = i4;
    }

    public static BidLossCode bidPriceNotHighest() {
        return new BidLossCode(102);
    }

    public static BidLossCode bidTimeOut() {
        return new BidLossCode(2);
    }

    public static BidLossCode bidWinButNotShow() {
        return new BidLossCode(3001);
    }

    public int getCurrentCode() {
        return f40014a;
    }
}
