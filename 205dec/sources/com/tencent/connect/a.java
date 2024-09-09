package com.tencent.connect;

import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static boolean a(String str, IUiListener iUiListener) {
        return a(str, iUiListener, -6, "\u7528\u6237\u672a\u6388\u6743\uff0c\u6682\u65f6\u65e0\u6cd5\u4f7f\u7528QQ\u767b\u5f55\u53ca\u5206\u4eab\u7b49\u529f\u80fd", "\u7528\u6237\u672a\u6388\u6743\uff0c\u6682\u65f6\u65e0\u6cd5\u4f7f\u7528QQ\u767b\u5f55\u53ca\u5206\u4eab\u7b49\u529f\u80fd");
    }

    public static boolean a(String str, IUiListener iUiListener, int i4, String str2, String str3) {
        if (Tencent.isPermissionNotGranted()) {
            SLog.i(str, "permission not granted");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(i4, str2, str3));
                return true;
            }
            return true;
        }
        return false;
    }
}
