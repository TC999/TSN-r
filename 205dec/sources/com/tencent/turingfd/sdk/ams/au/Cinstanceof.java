package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.instanceof  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cinstanceof {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.instanceof$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo implements Canesatici {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f52322a;

        /* renamed from: b  reason: collision with root package name */
        public volatile int f52323b = 0;

        public Cdo(String[] strArr) {
            this.f52322a = strArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
            if ((r3 != null && r3.contains("ACCESS_NETWORK_STATE")) != false) goto L122;
         */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0218  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.tencent.turingfd.sdk.ams.au.Canesatici.Cdo a(byte[] r11) {
            /*
                Method dump skipped, instructions count: 619
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cinstanceof.Cdo.a(byte[]):com.tencent.turingfd.sdk.ams.au.Canesatici$do");
        }
    }

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            return System.getProperty("http.proxyHost");
        }
        return Proxy.getHost(context);
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                return Integer.parseInt(System.getProperty("http.proxyPort"));
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return Proxy.getPort(context);
    }
}
