package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.interstitial.c.a;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBInterstitialHandler {
    private a mController;

    public MBInterstitialHandler(Context context, Map<String, Object> map) {
        if (this.mController == null) {
            this.mController = new a();
        }
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (!TextUtils.isEmpty(str)) {
                String m21981f = SameTool.m21981f(str);
                if (!TextUtils.isEmpty(m21981f)) {
                    SameTool.m22008a(str, m21981f);
                }
            }
        }
        this.mController.a(context, map);
        if (MBSDKContext.m22865f().m22861j() != null || context == null) {
            return;
        }
        MBSDKContext.m22865f().m22875b(context);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        try {
            a aVar = this.mController;
            if (aVar != null) {
                aVar.a(interstitialListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        try {
            this.mController.c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
