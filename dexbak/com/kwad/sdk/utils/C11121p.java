package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.pngencrypt.C10938o;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* renamed from: com.kwad.sdk.utils.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11121p {
    private static String aOL = "";
    private static String aOM = "";
    private static String aON = "";

    /* renamed from: a */
    private static String m23752a(String str, InputStream inputStream) {
        String m24456gn;
        synchronized (C11121p.class) {
            C10938o c10938o = new C10938o(inputStream, true);
            c10938o.m24416Kh();
            m24456gn = c10938o.m24417Kg().m24456gn(str);
            c10938o.end();
        }
        return m24456gn;
    }

    /* renamed from: dY */
    public static String m23751dY(int i) {
        Context m24363KO = ServiceProvider.m24363KO();
        String str = aOL;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty("aes_key")) {
                Log.e("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = m24363KO.getResources().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = m24363KO.getAssets().open("ksad_common_encrypt_image.png");
                }
                String m23752a = m23752a("aes_key", open);
                if (TextUtils.isEmpty(m23752a)) {
                    Log.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                aOL = m23752a;
                return m23752a;
            }
        }
        return str;
    }
}
