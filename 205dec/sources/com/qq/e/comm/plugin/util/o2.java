package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o2 {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f46540a;

    public static float a(View view) {
        return pro.getFresult(320, 1, view);
    }

    static int a(Rect rect, Rect rect2) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 1, rect, rect2);
    }

    private static int a(View view, ViewGroup viewGroup) {
        return pro.getIresult(322, 1, view, viewGroup);
    }

    public static Pair<Boolean, Integer> a(View view, int i4) {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 1, view, Integer.valueOf(i4));
    }

    public static Pair<Boolean, Integer> a(View view, int i4, int i5) {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 1, view, Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static void a(int i4, int i5, int i6, Object... objArr) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_PLAY_TYPE, 1, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), objArr);
    }

    public static boolean a(Context context, View view, int i4) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 1, context, view, Integer.valueOf(i4));
    }

    public static boolean a(Context context, View view, int i4, boolean z3) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, 1, context, view, Integer.valueOf(i4), Boolean.valueOf(z3));
    }

    public static boolean b(Context context, View view, int i4, boolean z3) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, 1, context, view, Integer.valueOf(i4), Boolean.valueOf(z3));
    }

    public static boolean b(View view) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, 1, view);
    }

    private static boolean b(View view, int i4) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 1, view, Integer.valueOf(i4));
    }
}
