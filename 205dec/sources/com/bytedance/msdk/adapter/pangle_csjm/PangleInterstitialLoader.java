package com.bytedance.msdk.adapter.pangle_csjm;

import android.content.Context;
import com.bytedance.msdk.adapter.c;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleInterstitialLoader extends c {
    public static final String TAG = "PangleInterstitialAdapter";
    public static final String VERSION_00 = "0.0";

    @Override // com.bytedance.msdk.adapter.c
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getSdkVersion() {
        try {
            return com.bytedance.sdk.gromore.init.c.xv();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void loadAd(Context context, Map<String, Object> map) {
        notifyAdFailed(new com.bytedance.msdk.api.c(81004, com.bytedance.msdk.api.c.c(81004)));
    }
}
