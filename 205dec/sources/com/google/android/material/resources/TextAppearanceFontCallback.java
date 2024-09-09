package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class TextAppearanceFontCallback {
    public abstract void onFontRetrievalFailed(int i4);

    public abstract void onFontRetrieved(Typeface typeface, boolean z3);
}
