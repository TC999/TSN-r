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

/* renamed from: com.bumptech.glide.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
interface ModelTypes<T> {
    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo45507a(@Nullable String str);

    @CheckResult
    @Deprecated
    /* renamed from: c */
    T mo45506c(@Nullable URL url);

    @NonNull
    @CheckResult
    /* renamed from: d */
    T mo45505d(@Nullable Uri uri);

    @NonNull
    @CheckResult
    /* renamed from: e */
    T mo45504e(@Nullable byte[] bArr);

    @NonNull
    @CheckResult
    /* renamed from: f */
    T mo45503f(@Nullable File file);

    @NonNull
    @CheckResult
    /* renamed from: g */
    T mo45502g(@Nullable Drawable drawable);

    @NonNull
    @CheckResult
    /* renamed from: l */
    T mo45501l(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    /* renamed from: o */
    T mo45500o(@Nullable Object obj);

    @NonNull
    @CheckResult
    /* renamed from: p */
    T mo45499p(@Nullable @DrawableRes @RawRes Integer num);
}
