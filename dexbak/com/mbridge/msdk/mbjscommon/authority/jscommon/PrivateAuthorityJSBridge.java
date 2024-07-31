package com.mbridge.msdk.mbjscommon.authority.jscommon;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class PrivateAuthorityJSBridge extends AbsMbridgeDownload {
    private static final String TAG = "PrivateAuthorityJSBridge";

    private void finishActivity(Object obj) {
        SameLogTool.m21738a(TAG, "close activity" + this.mContext);
    }

    public void getPrivateAuthorityStatus(Object obj, String str) {
        String m22834c = SDKAuthorityController.m22842a().m22834c();
        SameLogTool.m21738a(TAG, "GET authorityStatusString:" + m22834c);
        WindVaneCallJs.m21387a().m21384a(obj, TextUtils.isEmpty(m22834c) ? "" : Base64.encodeToString(m22834c.getBytes(), 2));
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
    }

    public void setPrivateAuthorityStatus(Object obj, String str) {
        SameLogTool.m21738a(TAG, "SET authorityStatusString:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SDKAuthorityController.m22842a().m22835b(str);
        } finally {
            try {
            } finally {
            }
        }
    }
}
