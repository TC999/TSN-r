package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.alibaba.fastjson.asm.Opcodes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p518qq.p519e.comm.adevent.AdEventType;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb((int) AdEventType.VIDEO_ERROR, 248, 246), Color.rgb(148, (int) AdEventType.VIDEO_PRELOADED, (int) AdEventType.VIDEO_PRELOADED), Color.rgb((int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK), Color.rgb((int) DnsRecord.CLASS_NONE, 149, 7), Color.rgb((int) DnsRecord.CLASS_NONE, 247, 120), Color.rgb(106, (int) Opcodes.GOTO, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE), Color.rgb(53, 194, (int) AdEventType.VIDEO_INIT)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(149, (int) Opcodes.IF_ACMPEQ, 124), Color.rgb(217, (int) Opcodes.INVOKESTATIC, (int) Opcodes.IF_ICMPGE), Color.rgb(191, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE), Color.rgb(179, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb((int) Opcodes.INSTANCEOF, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, (int) Opcodes.IFNONNULL, 0), Color.rgb(106, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, 31), Color.rgb(179, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb((int) Opcodes.CHECKCAST, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, (int) AdEventType.VIDEO_CLICKED, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i, int i2) {
        return (i & 16777215) | ((i2 & 255) << 24);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
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
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}
