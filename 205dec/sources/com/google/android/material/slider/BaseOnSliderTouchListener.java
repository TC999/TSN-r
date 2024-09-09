package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface BaseOnSliderTouchListener<S> {
    void onStartTrackingTouch(@NonNull S s3);

    void onStopTrackingTouch(@NonNull S s3);
}
