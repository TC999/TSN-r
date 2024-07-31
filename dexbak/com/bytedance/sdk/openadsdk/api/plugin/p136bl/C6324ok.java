package com.bytedance.sdk.openadsdk.api.plugin.p136bl;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.bl.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6324ok {
    /* renamed from: ok */
    public static String m36593ok(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
