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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableDecoderCompat.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f17499a = true;

    private a() {
    }

    public static Drawable a(Context context, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        return c(context, context, i4, theme);
    }

    public static Drawable b(Context context, Context context2, @DrawableRes int i4) {
        return c(context, context2, i4, null);
    }

    private static Drawable c(Context context, Context context2, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        try {
            if (f17499a) {
                return e(context2, i4, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e4) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i4);
            }
            throw e4;
        } catch (NoClassDefFoundError unused2) {
            f17499a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i4, theme);
    }

    private static Drawable d(Context context, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i4, theme);
    }

    private static Drawable e(Context context, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i4);
    }
}
