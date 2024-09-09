package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46402a = String.format("AES/%s/PKCS7Padding", "ECB");

    /* renamed from: b  reason: collision with root package name */
    private static final String f46403b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f46404c;

    static {
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("cgiAesKeyVer");
        f46403b = c4;
        f46404c = TextUtils.isEmpty(c4) ? "1" : f46403b;
    }

    private static String a() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 1, new Object[0]);
    }

    public static String a(String str) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1, str);
    }

    private static byte[] a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return (byte[]) pro.getobjresult(270, 1, bArr);
    }

    public static String b(String str) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 1, str);
    }

    private static byte[] b(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 1, bArr);
    }
}
