package com.qq.e.comm.plugin.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e1 {

    /* renamed from: a  reason: collision with root package name */
    private static int f46411a;

    public static final int a() {
        return pro.getIresult(273, 1, new Object[0]);
    }

    public static final String b() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 1, new Object[0]);
    }

    public static final String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 1, new Object[0]);
    }

    public static int d() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, 1, new Object[0]);
    }

    public static String e() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 1, new Object[0]);
    }

    public static String f() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 1, new Object[0]);
    }

    public static int g() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 1, new Object[0]);
    }

    public static final int h() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 1, new Object[0]);
    }

    public static final String i() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 1, new Object[0]);
    }

    public static boolean j() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 1, new Object[0]);
    }
}
