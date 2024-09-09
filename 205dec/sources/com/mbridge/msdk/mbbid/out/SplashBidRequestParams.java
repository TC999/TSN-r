package com.mbridge.msdk.mbbid.out;

import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.t;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SplashBidRequestParams extends BannerBidRequestParams {

    /* renamed from: b  reason: collision with root package name */
    private static int f40018b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static int f40019c;

    /* renamed from: d  reason: collision with root package name */
    private static int f40020d;

    /* renamed from: a  reason: collision with root package name */
    private boolean f40021a;

    public SplashBidRequestParams(String str, String str2) {
        this(str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        return this.f40021a;
    }

    public int getOrientation() {
        return f40018b;
    }

    public SplashBidRequestParams(String str, String str2, String str3) {
        this(str, str2, str3, false, f40018b, f40020d, f40019c);
    }

    public SplashBidRequestParams(String str, String str2, boolean z3, int i4, int i5, int i6) {
        this(str, str2, "", z3, i4, i6, i5);
    }

    public SplashBidRequestParams(String str, String str2, String str3, boolean z3, int i4, int i5, int i6) {
        super(str, str2, str3, 0, 0);
        this.f40021a = false;
        f40018b = i4;
        int x3 = t.x(a.f().j());
        int y3 = t.y(a.f().j());
        int i7 = f40018b;
        if (i7 == 1) {
            if (y3 > i6 * 4) {
                setHeight(y3 - i6);
                setWidth(x3);
            } else {
                setHeight(0);
                setWidth(0);
            }
        } else if (i7 == 2) {
            if (x3 > i5 * 4) {
                setWidth(x3 - i5);
                setHeight(y3);
            } else {
                setHeight(0);
                setWidth(0);
            }
        }
        this.f40021a = z3;
    }
}
