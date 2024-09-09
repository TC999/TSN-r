package com.qq.e.comm.plugin.i0;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c {
        static byte a() {
            return pro.getBresult(225, 1, new Object[0]);
        }

        static Pair<Long, byte[]> a(byte[] bArr) throws a {
            return (Pair) pro.getobjresult(226, 1, bArr);
        }

        static byte[] a(String str, long j4, byte[] bArr) throws a {
            return (byte[]) pro.getobjresult(227, 1, str, Long.valueOf(j4), bArr);
        }

        static byte b() {
            return pro.getBresult(228, 1, new Object[0]);
        }

        static Pair<Long, byte[]> b(byte[] bArr) throws a {
            return (Pair) pro.getobjresult(229, 1, bArr);
        }

        static byte c() {
            return pro.getBresult(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 1, new Object[0]);
        }

        static int d() {
            return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 1, new Object[0]);
        }

        static int e() {
            return pro.getIresult(232, 1, new Object[0]);
        }

        static byte f() {
            return pro.getBresult(233, 1, new Object[0]);
        }

        static int g() {
            return pro.getIresult(234, 1, new Object[0]);
        }

        static int h() {
            return pro.getIresult(235, 1, new Object[0]);
        }
    }

    private static String a() {
        return (String) pro.getobjresult(236, 1, new Object[0]);
    }

    public static JSONObject a(int i4) {
        return (JSONObject) pro.getobjresult(237, 1, Integer.valueOf(i4));
    }

    public static native byte[] a(byte[] bArr);

    public static native byte[] a(byte[] bArr, long j4);

    private static long b() {
        return pro.getJresult(238, 1, new Object[0]);
    }

    public static byte[] b(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(239, 1, bArr);
    }

    public static byte[] c(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(240, 1, bArr);
    }

    public static byte[] d(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 1, bArr);
    }
}
