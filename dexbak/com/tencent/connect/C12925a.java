package com.tencent.connect;

import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12925a {
    /* renamed from: a */
    public static boolean m15471a(String str, IUiListener iUiListener) {
        return m15470a(str, iUiListener, -6, Constants.MSG_PERMISSION_NOT_GRANTED, Constants.MSG_PERMISSION_NOT_GRANTED);
    }

    /* renamed from: a */
    public static boolean m15470a(String str, IUiListener iUiListener, int i, String str2, String str3) {
        if (Tencent.isPermissionNotGranted()) {
            SLog.m15127i(str, "permission not granted");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(i, str2, str3));
                return true;
            }
            return true;
        }
        return false;
    }
}
