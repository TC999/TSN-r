package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* renamed from: com.bumptech.glide.load.resource.drawable.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DrawableDecoderCompat {

    /* renamed from: a */
    private static volatile boolean f14182a = true;

    private DrawableDecoderCompat() {
    }

    /* renamed from: a */
    public static Drawable m44883a(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return m44881c(context, context, i, theme);
    }

    /* renamed from: b */
    public static Drawable m44882b(Context context, Context context2, @DrawableRes int i) {
        return m44881c(context, context2, i, null);
    }

    /* renamed from: c */
    private static Drawable m44881c(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (f14182a) {
                return m44879e(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i);
            }
            throw e;
        } catch (NoClassDefFoundError unused2) {
            f14182a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return m44880d(context2, i, theme);
    }

    /* renamed from: d */
    private static Drawable m44880d(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }

    /* renamed from: e */
    private static Drawable m44879e(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i);
    }
}
