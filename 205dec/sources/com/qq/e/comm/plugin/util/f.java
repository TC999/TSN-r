package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f46416a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f46417b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f46416a)) {
            return f46416a;
        }
        try {
            f46416a = a(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures);
            return f46416a;
        } catch (Exception e4) {
            d1.a("get Signature Digest encounter exception: " + e4.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String a(Signature[] signatureArr) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF, 1, signatureArr);
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b4 = bArr[i4];
            int i5 = i4 * 2;
            char[] cArr2 = f46417b;
            cArr[i5] = cArr2[(b4 >>> 4) & 15];
            cArr[i5 + 1] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }
}
