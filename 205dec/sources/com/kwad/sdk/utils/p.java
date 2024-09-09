package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class p {
    private static String aOL = "";
    private static String aOM = "";
    private static String aON = "";

    private static String a(String str, InputStream inputStream) {
        String gn;
        synchronized (p.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.Kh();
            gn = oVar.Kg().gn(str);
            oVar.end();
        }
        return gn;
    }

    public static String dY(int i4) {
        Context KO = ServiceProvider.KO();
        String str = aOL;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty("aes_key")) {
                Log.e("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = KO.getResources().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = KO.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a4 = a("aes_key", open);
                if (TextUtils.isEmpty(a4)) {
                    Log.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                aOL = a4;
                return a4;
            }
        }
        return str;
    }
}
