package com.qq.e.comm.plugin.util;

import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h1 {
    public static String a(String str) {
        return a(str, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw41hNBphwAvvOJ5Ruzq1\rEYxmKXMh2cRtxu9RsZKcELezpJhjYB1IfqhE9rBJFL2gxk7cb9GrzuaeukXAL5uA\r3tYEbZ8q3oRE2faRmlsCByktcfT68ngsTk2arqBewBwcbgcjAPt/onySpsf9wKUg\rEhrWoeR92BPNCaVEWpBDqKcIgGDr/W4lpU8hmY9DYrv0BM8qpFYYDnr+AcrgREb4\rvPq+B06GUwTLVh/NAA4Afb7R1dDpxuXT2CMfX/2vPgWW+GiqAl8b1Q2CjGWL6PU/\rmcjJUwSycdsoRr+hVjIOMImNpDd8mON6zPsEccJMC/+srcRTjZn78zNtDeMtYiOt\rDwIDAQAB");
    }

    public static String a(String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            bArr = a(str.getBytes(), str2);
        } catch (Exception e4) {
            d1.a("Rsa encrypt encounter error: " + e4.getMessage(), new Object[0]);
        }
        return Base64.encodeToString(bArr, 2);
    }

    private static byte[] a(byte[] bArr, String str) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        byte[] doFinal;
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = length - i4;
            if (i6 > 0) {
                if (i6 > 245) {
                    doFinal = cipher.doFinal(bArr, i4, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR);
                } else {
                    doFinal = cipher.doFinal(bArr, i4, i6);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i5++;
                i4 = i5 * MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }
}
