package com.tencent.open.web.security;

import com.tencent.open.b;
import com.tencent.open.log.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SecureJsInterface extends b.C1042b {
    public static boolean isPWDEdit;

    /* renamed from: a  reason: collision with root package name */
    private String f51858a;

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e4.getMessage());
            throw new RuntimeException(e4);
        }
    }

    public void curPosFromJS(String str) {
        int i4;
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i4 = Integer.parseInt(str);
        } catch (NumberFormatException e4) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e4);
            i4 = -1;
        }
        if (i4 >= 0) {
            boolean z3 = a.f51861c;
            boolean z4 = a.f51860b;
            if (z4) {
                if (Boolean.valueOf(JniInterface.BackSpaceChar(z4, i4)).booleanValue()) {
                    a.f51860b = false;
                    return;
                }
                return;
            }
            String str2 = a.f51859a;
            this.f51858a = str2;
            JniInterface.insetTextToArray(i4, str2, str2.length());
            SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f51858a);
            return;
        }
        throw new RuntimeException("position is illegal.");
    }

    @Override // com.tencent.open.b.C1042b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e4.getMessage());
            throw new RuntimeException(e4);
        }
    }

    public void isPasswordEdit(String str) {
        int i4;
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i4 = Integer.parseInt(str);
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e4.getMessage());
            i4 = -1;
        }
        if (i4 != 0 && i4 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i4 == 0) {
            isPWDEdit = false;
        } else if (i4 == 1) {
            isPWDEdit = true;
        }
    }
}
