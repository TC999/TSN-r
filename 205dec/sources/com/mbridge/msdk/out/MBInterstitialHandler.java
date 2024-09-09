package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.interstitial.c.a;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBInterstitialHandler {
    private a mController;

    public MBInterstitialHandler(Context context, Map<String, Object> map) {
        if (this.mController == null) {
            this.mController = new a();
        }
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (!TextUtils.isEmpty(str)) {
                String f4 = ac.f(str);
                if (!TextUtils.isEmpty(f4)) {
                    ac.a(str, f4);
                }
            }
        }
        this.mController.a(context, map);
        if (com.mbridge.msdk.foundation.controller.a.f().j() != null || context == null) {
            return;
        }
        com.mbridge.msdk.foundation.controller.a.f().b(context);
    }

    public String getRequestId() {
        a aVar = this.mController;
        return aVar != null ? aVar.b() : "";
    }

    public void preload() {
        try {
            a aVar = this.mController;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        try {
            a aVar = this.mController;
            if (aVar != null) {
                aVar.a(interstitialListener);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void show() {
        try {
            this.mController.c();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
