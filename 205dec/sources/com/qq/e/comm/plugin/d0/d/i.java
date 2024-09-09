package com.qq.e.comm.plugin.d0.d;

import android.content.Context;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.UnsupportedEncodingException;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f42257a;

        /* renamed from: b  reason: collision with root package name */
        private final T f42258b;

        public T a() {
            return this.f42258b;
        }

        public String b() {
            return this.f42257a;
        }

        private b(String str, T t3) {
            this.f42257a = str;
            this.f42258b = t3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) throws UnsupportedEncodingException {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 1, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 1, context);
    }

    private static void a(Context context, String str) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 1, context, str);
    }

    private static void a(boolean z3, String str, String str2, String str3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 1, Boolean.valueOf(z3), str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str, String str2) {
        return pro.getZresult(198, 1, context, str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        return pro.getZresult(199, 1, context, str, str2, str3);
    }

    private static Pair<String, String> b(Context context, String str) {
        return (Pair) pro.getobjresult(200, 1, context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b<com.qq.e.comm.plugin.d0.d.a> b(Context context) {
        return (b) pro.getobjresult(201, 1, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, String str, String str2) {
        return pro.getZresult(202, 1, context, str, str2);
    }

    private static boolean b(Context context, String str, String str2, String str3) {
        return pro.getZresult(203, 1, context, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b<f> c(Context context) {
        return (b) pro.getobjresult(204, 1, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str, String str2) {
        return pro.getZresult(205, 1, context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b<g> d(Context context) {
        return (b) pro.getobjresult(206, 1, context);
    }
}
