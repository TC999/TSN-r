package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ac {
    @WorkerThread
    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace(AdScopeTrackerTool.width, ea(aVar.getWidth())).replace(AdScopeTrackerTool.height, ea(aVar.getHeight())).replace("__DOWN_X__", ea(aVar.LV())).replace("__DOWN_Y__", ea(aVar.LW())).replace("__UP_X__", ea(aVar.LX())).replace("__UP_Y__", ea(aVar.LY()));
    }

    public static String am(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(k.bT(context))).replace("__DEVICE_HEIGHT__", String.valueOf(k.bU(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z3) {
        return str.replace(AdScopeTrackerTool.ts, String.valueOf(bk.v(context, z3)));
    }

    private static String ea(int i4) {
        return i4 >= 0 ? String.valueOf(i4) : "-999";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private int aPl;
        private int aPm;
        private int aPn;
        private int aPo;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aPl = -1;
            this.aPm = -1;
            this.aPn = -1;
            this.aPo = -1;
        }

        public final int LV() {
            return this.aPl;
        }

        public final int LW() {
            return this.aPm;
        }

        public final int LX() {
            return this.aPn;
        }

        public final int LY() {
            return this.aPo;
        }

        public final void f(float f4, float f5) {
            this.aPl = (int) f4;
            this.aPm = (int) f5;
        }

        public final void g(float f4, float f5) {
            this.aPn = (int) f4;
            this.aPo = (int) f5;
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

        public final void z(int i4, int i5) {
            this.mWidth = i4;
            this.mHeight = i5;
        }

        public a(int i4, int i5) {
            this.aPl = -1;
            this.aPm = -1;
            this.aPn = -1;
            this.aPo = -1;
            this.mWidth = i4;
            this.mHeight = i5;
        }
    }
}
