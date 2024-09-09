package com.qq.e.comm.plugin.o0;

import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static int a(int i4) {
        if (i4 == 0) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("serverRequestMaxVideoDuration", 61);
        }
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("video_duration_setting_min", 5);
        int a5 = com.qq.e.comm.plugin.d0.a.d().f().a("video_duration_setting_max", 61);
        if (i4 < a4) {
            GDTLogger.e("setMaxVideoDuration \u53c2\u6570\u975e\u6cd5\uff0cmaxDuration \u5fc5\u987b\u5728 " + a4 + " \u548c " + a5 + "\u4e4b\u95f4");
            return a4;
        } else if (i4 > a5) {
            GDTLogger.e("setMaxVideoDuration \u53c2\u6570\u975e\u6cd5\uff0cmaxDuration \u5fc5\u987b\u5728 " + a4 + " \u548c " + a5 + "\u4e4b\u95f4");
            return a5;
        } else {
            return i4;
        }
    }
}
