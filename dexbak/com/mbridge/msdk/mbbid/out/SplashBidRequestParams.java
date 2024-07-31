package com.mbridge.msdk.mbbid.out;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameDiTool;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SplashBidRequestParams extends BannerBidRequestParams {

    /* renamed from: b */
    private static int f31246b = 1;

    /* renamed from: c */
    private static int f31247c;

    /* renamed from: d */
    private static int f31248d;

    /* renamed from: a */
    private boolean f31249a;

    public SplashBidRequestParams(String str, String str2) {
        this(str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m21683a() {
        return this.f31249a;
    }

    public int getOrientation() {
        return f31246b;
    }

    public SplashBidRequestParams(String str, String str2, String str3) {
        this(str, str2, str3, false, f31246b, f31248d, f31247c);
    }

    public SplashBidRequestParams(String str, String str2, boolean z, int i, int i2, int i3) {
        this(str, str2, "", z, i, i3, i2);
    }

    public SplashBidRequestParams(String str, String str2, String str3, boolean z, int i, int i2, int i3) {
        super(str, str2, str3, 0, 0);
        this.f31249a = false;
        f31246b = i;
        int m21765x = SameDiTool.m21765x(MBSDKContext.m22865f().m22861j());
        int m21763y = SameDiTool.m21763y(MBSDKContext.m22865f().m22861j());
        int i4 = f31246b;
        if (i4 == 1) {
            if (m21763y > i3 * 4) {
                setHeight(m21763y - i3);
                setWidth(m21765x);
            } else {
                setHeight(0);
                setWidth(0);
            }
        } else if (i4 == 2) {
            if (m21765x > i2 * 4) {
                setWidth(m21765x - i2);
                setHeight(m21763y);
            } else {
                setHeight(0);
                setWidth(0);
            }
        }
        this.f31249a = z;
    }
}
