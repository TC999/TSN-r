package com.qq.e.comm.plugin.l0;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f44607a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f44608b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f44609c;

    private static native JSONObject a(int i4, Object... objArr);

    public static void a() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT, 1, new Object[0]);
    }

    public static String b() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_DUMMY_VOICE_SLEEP, 1, new Object[0]);
    }

    public static String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, 1, new Object[0]);
    }

    public static long d() {
        return pro.getJresult(MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1, new Object[0]);
    }

    public static Pair<Integer, Integer> e() {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 1, new Object[0]);
    }

    public static int f() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD, 1, new Object[0]);
    }

    public static int g() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1, new Object[0]);
    }

    public static JSONObject h() {
        return (JSONObject) pro.getobjresult(545, 1, new Object[0]);
    }

    public static int i() {
        return pro.getIresult(546, 1, new Object[0]);
    }

    public static JSONObject j() {
        return (JSONObject) pro.getobjresult(547, 1, new Object[0]);
    }

    public static int k() {
        return pro.getIresult(548, 1, new Object[0]);
    }

    public static int l() {
        return pro.getIresult(549, 1, new Object[0]);
    }

    private static boolean m() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 1, new Object[0]);
    }

    private static boolean n() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 1, new Object[0]);
    }

    private static int o() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE, 1, new Object[0]);
    }

    public static boolean p() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, 1, new Object[0]);
    }

    private static boolean q() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 1, new Object[0]);
    }
}
