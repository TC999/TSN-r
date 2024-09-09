package com.qq.e.comm.plugin.util;

import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o1 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f46535a;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f46536b;

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f46537c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f46538d;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f46539e;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a extends ThreadLocal<Cipher> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                Cipher cipher = Cipher.getInstance(o1.f46538d);
                cipher.init(1, new SecretKeySpec(o1.a(), "AES"));
                return cipher;
            } catch (Exception e4) {
                o1.a(true, 1, e4);
                return null;
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c extends ThreadLocal<Cipher> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                Cipher cipher = Cipher.getInstance(o1.f46538d);
                cipher.init(2, new SecretKeySpec(o1.a(), "AES"));
                return cipher;
            } catch (Exception e4) {
                o1.a(false, 1, e4);
                return null;
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d extends Exception {
        public d(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        com.qq.e.comm.plugin.d0.a.d().f().a("spa", 0);
        f46535a = new byte[]{91, -62};
        f46536b = new a();
        f46537c = new c(null);
        f46538d = String.format("AES/%s/PKCS7Padding", "ECB");
        f46539e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);
    }

    public static String a(String str) throws d {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, 1, str);
    }

    static /* synthetic */ void a(boolean z3, int i4, Exception exc) {
        pro.getVresult(333, 1, Boolean.valueOf(z3), Integer.valueOf(i4), exc);
    }

    static /* synthetic */ byte[] a() {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 1, new Object[0]);
    }

    private static byte[] a(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS, 1, bArr);
    }

    public static String b(String str) throws d {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 1, str);
    }

    private static void b(boolean z3, int i4, Exception exc) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 1, Boolean.valueOf(z3), Integer.valueOf(i4), exc);
    }

    private static byte[] b() {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, 1, new Object[0]);
    }

    private static byte[] b(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 1, bArr);
    }

    public static byte[] c(byte[] bArr) throws d {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO, 1, bArr);
    }

    public static byte[] d(byte[] bArr) throws d {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 1, bArr);
    }

    private static byte[] e(byte[] bArr) {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS, 1, bArr);
    }

    private static byte[] f(byte[] bArr) {
        return (byte[]) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 1, bArr);
    }
}
