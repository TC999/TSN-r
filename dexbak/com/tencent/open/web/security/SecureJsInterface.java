package com.tencent.open.web.security;

import com.tencent.open.C13006b;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SecureJsInterface extends C13006b.C13008b {
    public static boolean isPWDEdit;

    /* renamed from: a */
    private String f37458a;

    public void clearAllEdit() {
        SLog.m15127i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            SLog.m15129e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void curPosFromJS(String str) {
        int i;
        SLog.m15131d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            SLog.m15128e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
            i = -1;
        }
        if (i >= 0) {
            boolean z = C13075a.f37461c;
            boolean z2 = C13075a.f37460b;
            if (z2) {
                if (Boolean.valueOf(JniInterface.BackSpaceChar(z2, i)).booleanValue()) {
                    C13075a.f37460b = false;
                    return;
                }
                return;
            }
            String str2 = C13075a.f37459a;
            this.f37458a = str2;
            JniInterface.insetTextToArray(i, str2, str2.length());
            SLog.m15123v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f37458a);
            return;
        }
        throw new RuntimeException("position is illegal.");
    }

    @Override // com.tencent.open.C13006b.C13008b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        SLog.m15127i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.m15123v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e) {
            SLog.m15129e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void isPasswordEdit(String str) {
        int i;
        SLog.m15127i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            SLog.m15129e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
            i = -1;
        }
        if (i != 0 && i != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i == 0) {
            isPWDEdit = false;
        } else if (i == 1) {
            isPWDEdit = true;
        }
    }
}
