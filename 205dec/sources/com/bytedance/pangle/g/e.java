package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class e {
    public static boolean a(String str, String str2) {
        o a4;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (com.bytedance.pangle.util.i.a()) {
                a4 = d.a(str);
            } else {
                a4 = a.a(str);
            }
            Signature[] signatureArr = a4 != null ? a4.f28804b : null;
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode != null && decode.length != 0) {
                int i4 = 0;
                for (Signature signature : signatureArr) {
                    i4 += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i4];
                int i5 = 0;
                for (Signature signature2 : signatureArr) {
                    System.arraycopy(signature2.toByteArray(), 0, bArr, i5, signature2.toByteArray().length);
                    i5 += signature2.toByteArray().length;
                }
                boolean a5 = o.a(bArr, decode);
                if (!a5) {
                    ZeusLogger.w("Zeus/install_pangle", "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
                }
                return a5;
            }
            ZeusLogger.w("Zeus/install_pangle", "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
            return false;
        } catch (q e4) {
            ZeusLogger.w("Zeus/install_pangle", "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e4);
            return false;
        }
    }
}
