package com.p521ss.android.socialbase.appdownloader;

import android.content.Context;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;

/* renamed from: com.ss.android.socialbase.appdownloader.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12360q {
    /* renamed from: a */
    public static int m18088a(String str) {
        return m18083ok(C12490bl.m17807l(), str);
    }

    /* renamed from: bl */
    public static int m18086bl(String str) {
        try {
            return m18081ok(str, C12490bl.m17807l().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: kf */
    public static int m18085kf(String str) {
        try {
            return C12490bl.m17807l().getResources().getIdentifier(str, "color", C12490bl.m17807l().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: n */
    public static int m18084n(String str) {
        try {
            return C12490bl.m17807l().getResources().getIdentifier(str, "id", C12490bl.m17807l().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: ok */
    public static int m18082ok(String str) {
        try {
            return C12490bl.m17807l().getResources().getIdentifier(str, "layout", C12490bl.m17807l().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: s */
    public static int m18080s(String str) {
        try {
            return C12490bl.m17807l().getResources().getIdentifier(str, "style", C12490bl.m17807l().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static int m18087a(String str, String str2) {
        try {
            return C12490bl.m17807l().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: ok */
    public static int m18083ok(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: ok */
    public static int m18081ok(String str, String str2) {
        try {
            return C12490bl.m17807l().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
