package com.kwad.sdk.api.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
class ResUtil {
    ResUtil() {
    }

    static int getAttrId(Context context, String str) {
        return getIdentifier(context, str, "attr");
    }

    static int getColor(Context context, String str) {
        return getResources(context).getColor(getIdentifier(context, str, "color"));
    }

    static int getDimenId(Context context, String str) {
        return getIdentifier(context, str, "dimen");
    }

    static Drawable getDrawable(Context context, String str) {
        return getResources(context).getDrawable(getIdentifier(context, str, "drawable"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDrawableId(Context context, String str) {
        return getIdentifier(context, str, "drawable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return getResources(context).getIdentifier(str, str2, getPackageName(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLayoutId(Context context, String str) {
        return getIdentifier(context, str, "layout");
    }

    private static String getPackageName(Context context) {
        return context.getPackageName();
    }

    static int getRawId(Context context, String str) {
        return getIdentifier(context, str, "raw");
    }

    private static Resources getResources(Context context) {
        return context.getResources();
    }

    static String getString(Context context, String str) {
        return getResources(context).getString(getIdentifier(context, str, "string"));
    }

    static int getStyleId(Context context, String str) {
        return getIdentifier(context, str, "style");
    }
}
