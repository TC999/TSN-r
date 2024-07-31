package com.mbridge.msdk.mbjscommon.base;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;

/* renamed from: com.mbridge.msdk.mbjscommon.base.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class IntentFilter implements BaseFilter {
    @Override // com.mbridge.msdk.mbjscommon.base.BaseFilter
    /* renamed from: a */
    public final boolean mo21524a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equals("intent")) {
            return false;
        }
        return CommonClickUtil.m23064e(MBSDKContext.m22865f().m22861j(), str);
    }
}
