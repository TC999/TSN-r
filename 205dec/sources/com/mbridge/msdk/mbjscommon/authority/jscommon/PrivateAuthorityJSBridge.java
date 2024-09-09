package com.mbridge.msdk.mbjscommon.authority.jscommon;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.h;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class PrivateAuthorityJSBridge extends AbsMbridgeDownload {
    private static final String TAG = "PrivateAuthorityJSBridge";

    private void finishActivity(Object obj) {
        x.a(TAG, "close activity" + this.mContext);
    }

    public void getPrivateAuthorityStatus(Object obj, String str) {
        String c4 = a.a().c();
        x.a(TAG, "GET authorityStatusString:" + c4);
        h.a().a(obj, TextUtils.isEmpty(c4) ? "" : Base64.encodeToString(c4.getBytes(), 2));
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
    }

    public void setPrivateAuthorityStatus(Object obj, String str) {
        x.a(TAG, "SET authorityStatusString:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a.a().b(str);
        } finally {
            try {
            } finally {
            }
        }
    }
}
