package com.tencent.open.web.security;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class JniInterface {
    public static boolean isJniOk;

    public static native boolean BackSpaceChar(boolean z3, int i4);

    public static native boolean clearAllPWD();

    public static native String d1(String str);

    public static native String d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i4, String str, int i5);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            Context a4 = g.a();
            if (a4 != null) {
                if (new File(a4.getFilesDir().toString() + TTPathConst.sSeparator + AuthAgent.SECURE_LIB_NAME).exists()) {
                    System.load(a4.getFilesDir().toString() + TTPathConst.sSeparator + AuthAgent.SECURE_LIB_NAME);
                    isJniOk = true;
                    SLog.i("openSDK_LOG.JniInterface", "-->load lib success:" + AuthAgent.SECURE_LIB_NAME);
                } else {
                    SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
            }
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th);
        }
    }
}
