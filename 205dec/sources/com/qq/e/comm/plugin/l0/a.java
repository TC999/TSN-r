package com.qq.e.comm.plugin.l0;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    private static String a(int i4, String str, int i5) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION, 1, Integer.valueOf(i4), str, Integer.valueOf(i5));
    }

    public static void a(String str) {
        b(MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, str, 0);
    }

    private static void b(int i4, String str, int i5) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 1, Integer.valueOf(i4), str, Integer.valueOf(i5));
    }

    public static void b(String str, int i4) {
        b(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, str, i4);
    }

    public static void a(String str, int i4) {
        b(MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, str, i4);
    }

    public static void a(String str, String str2, int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.qq.e.comm.plugin.apkmanager.x.b.b(com.qq.e.comm.plugin.d0.a.d().a(), str)) {
            b(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, str2, i4);
        } else {
            b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, str2, i4);
        }
    }

    public static void a(boolean z3, boolean z4, String str, int i4) {
        b(z3 ? z4 ? MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME : MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME : z4 ? MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS : MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, str, i4);
    }
}
