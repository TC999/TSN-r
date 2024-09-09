package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m1 {
    public static Drawable a(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            try {
                return resources.getDrawable(resources.getIdentifier(str, "drawable", context.getPackageName()));
            } catch (Exception unused) {
                e2.b("Drawable \u8d44\u6e90 \u8f93\u5165\u6709\u8bef");
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null || decode.length <= 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable unused) {
            return null;
        }
    }
}
