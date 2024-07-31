package com.mbridge.msdk.mbjscommon.webEnvCheck;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WebGLCheckjs extends AbsMbridgeDownload {
    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
    }

    public void webglState(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            MBSDKContext.m22865f().m22871c(jSONObject.optInt("webgl"));
            MBSDKContext.m22865f().m22879a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
