package com.bykv.vk.openvk.component.video.c.ux;

import android.os.Build;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final int f25038c = Build.VERSION.SDK_INT;

    public static int c(long j4, long j5) {
        int i4;
        if (j5 > 0) {
            double d4 = j4;
            Double.isNaN(d4);
            double d5 = j5;
            Double.isNaN(d5);
            i4 = (int) (((d4 * 1.0d) / d5) * 100.0d);
        } else {
            i4 = 0;
        }
        return Math.min(Math.max(0, i4), 100);
    }

    public static String c(long j4) {
        StringBuilder sb = new StringBuilder();
        long j5 = j4 / 60000;
        long j6 = ((j4 % 3600000) % 60000) / 1000;
        if (j5 >= 10) {
            sb.append(j5);
        } else if (j5 > 0) {
            sb.append(0);
            sb.append(j5);
        } else {
            sb.append(0);
            sb.append(0);
        }
        sb.append(":");
        if (j6 >= 10) {
            sb.append(j6);
        } else if (j6 > 0) {
            sb.append(0);
            sb.append(j6);
        } else {
            sb.append(0);
            sb.append(0);
        }
        return sb.toString();
    }

    public static void c(View view, boolean z3) {
        if (view == null) {
            return;
        }
        if (z3) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i4 = f25038c;
        if (i4 >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i4 >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
