package com.mbridge.msdk.mbbid.out;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BidLossCode {

    /* renamed from: a */
    private static int f31240a;

    private BidLossCode(int i) {
        f31240a = i;
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
        return f31240a;
    }
}
