package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ModelTypes.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
interface h<T> {
    @NonNull
    @CheckResult
    T a(@Nullable String str);

    @CheckResult
    @Deprecated
    T c(@Nullable URL url);

    @NonNull
    @CheckResult
    T d(@Nullable Uri uri);

    @NonNull
    @CheckResult
    T e(@Nullable byte[] bArr);

    @NonNull
    @CheckResult
    T f(@Nullable File file);

    @NonNull
    @CheckResult
    T g(@Nullable Drawable drawable);

    @NonNull
    @CheckResult
    T l(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    T o(@Nullable Object obj);

    @NonNull
    @CheckResult
    T p(@Nullable @DrawableRes @RawRes Integer num);
}
