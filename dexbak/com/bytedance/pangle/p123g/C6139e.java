package com.bytedance.pangle.p123g;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.C6253i;

/* renamed from: com.bytedance.pangle.g.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6139e {
    /* renamed from: a */
    public static boolean m37128a(String str, String str2) {
        C6153o m37140a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (C6253i.m36887a()) {
                m37140a = C6138d.m37130a(str);
            } else {
                m37140a = C6131a.m37140a(str);
            }
            Signature[] signatureArr = m37140a != null ? m37140a.f22043b : null;
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode != null && decode.length != 0) {
                int i = 0;
                for (Signature signature : signatureArr) {
                    i += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i];
                int i2 = 0;
                for (Signature signature2 : signatureArr) {
                    System.arraycopy(signature2.toByteArray(), 0, bArr, i2, signature2.toByteArray().length);
                    i2 += signature2.toByteArray().length;
                }
                boolean m37097a = C6153o.m37097a(bArr, decode);
                if (!m37097a) {
                    ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
                }
                return m37097a;
            }
            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
            return false;
        } catch (C6155q e) {
            ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}
