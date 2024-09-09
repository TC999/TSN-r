package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, (int) MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED), Color.rgb(42, 109, 130)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, (int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 120), Color.rgb(106, 167, 134), Color.rgb(53, (int) MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 209)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 134, 134), Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 199, 0), Color.rgb(106, 150, 31), Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, 140), Color.rgb(255, (int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, (int) MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i4, int i5) {
        return (i4 & 16777215) | ((i5 & 255) << 24);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i4 : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i4)));
        }
        return arrayList;
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, 229);
    }

    public static int rgb(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, (parseLong >> 0) & 255);
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i4 : iArr) {
            arrayList.add(Integer.valueOf(i4));
        }
        return arrayList;
    }
}
