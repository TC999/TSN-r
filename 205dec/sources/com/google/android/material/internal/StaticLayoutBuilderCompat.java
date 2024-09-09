package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class StaticLayoutBuilderCompat {
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    @Nullable
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;
    @Nullable
    private static Object textDirection;
    private int end;
    private boolean isRtl;
    private final TextPaint paint;
    private CharSequence source;
    private final int width;
    private int start = 0;
    private Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
    private int maxLines = Integer.MAX_VALUE;
    private boolean includePad = true;
    @Nullable
    private TextUtils.TruncateAt ellipsize = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i4) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i4;
        this.end = charSequence.length();
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        Class<?> cls;
        if (initialized) {
            return;
        }
        try {
            boolean z3 = this.isRtl && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                textDirection = z3 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                String str = this.isRtl ? "RTL" : "LTR";
                Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                textDirection = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            constructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
            initialized = true;
        } catch (Exception e4) {
            throw new StaticLayoutBuilderCompatException(e4);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i4) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i4);
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.paint, max, this.ellipsize);
        }
        int min = Math.min(charSequence.length(), this.end);
        this.end = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.isRtl) {
                this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.start, min, this.paint, max);
            obtain.setAlignment(this.alignment);
            obtain.setIncludePad(this.includePad);
            obtain.setTextDirection(this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.ellipsize;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.maxLines);
            return obtain.build();
        }
        createConstructorWithReflection();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(constructor)).newInstance(charSequence, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(max), this.alignment, Preconditions.checkNotNull(textDirection), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(max), Integer.valueOf(this.maxLines));
        } catch (Exception e4) {
            throw new StaticLayoutBuilderCompatException(e4);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int i4) {
        this.end = i4;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean z3) {
        this.includePad = z3;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z3) {
        this.isRtl = z3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int i4) {
        this.maxLines = i4;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int i4) {
        this.start = i4;
        return this;
    }
}
