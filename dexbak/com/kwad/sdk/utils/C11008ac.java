package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* renamed from: com.kwad.sdk.utils.ac */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11008ac {
    @WorkerThread
    /* renamed from: a */
    public static String m24156a(String str, C11009a c11009a) {
        return (TextUtils.isEmpty(str) || c11009a == null) ? str : str.replace("__WIDTH__", m24153ea(c11009a.getWidth())).replace("__HEIGHT__", m24153ea(c11009a.getHeight())).replace("__DOWN_X__", m24153ea(c11009a.m24152LV())).replace("__DOWN_Y__", m24153ea(c11009a.m24151LW())).replace("__UP_X__", m24153ea(c11009a.m24150LX())).replace("__UP_Y__", m24153ea(c11009a.m24149LY()));
    }

    /* renamed from: am */
    public static String m24155am(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(C11102k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(C11102k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(C11102k.m23777bT(context))).replace("__DEVICE_HEIGHT__", String.valueOf(C11102k.m23776bU(context)));
    }

    /* renamed from: c */
    public static String m24154c(@Nullable Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(C11061bk.m23868v(context, z)));
    }

    /* renamed from: ea */
    private static String m24153ea(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }

    /* renamed from: com.kwad.sdk.utils.ac$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11009a {
        private int aPl;
        private int aPm;
        private int aPn;
        private int aPo;
        private int mHeight;
        private int mWidth;

        public C11009a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aPl = -1;
            this.aPm = -1;
            this.aPn = -1;
            this.aPo = -1;
        }

        /* renamed from: LV */
        public final int m24152LV() {
            return this.aPl;
        }

        /* renamed from: LW */
        public final int m24151LW() {
            return this.aPm;
        }

        /* renamed from: LX */
        public final int m24150LX() {
            return this.aPn;
        }

        /* renamed from: LY */
        public final int m24149LY() {
            return this.aPo;
        }

        /* renamed from: f */
        public final void m24148f(float f, float f2) {
            this.aPl = (int) f;
            this.aPm = (int) f2;
        }

        /* renamed from: g */
        public final void m24147g(float f, float f2) {
            this.aPn = (int) f;
            this.aPo = (int) f2;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aPl + ", mDownY=" + this.aPm + ", mUpX=" + this.aPn + ", mUpY=" + this.aPo + '}';
        }

        /* renamed from: z */
        public final void m24146z(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public C11009a(int i, int i2) {
            this.aPl = -1;
            this.aPm = -1;
            this.aPn = -1;
            this.aPo = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }
    }
}
