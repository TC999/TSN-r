package com.bytedance.msdk.api.format;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTMediaView extends FrameLayout {
    public TTMediaView(@NonNull Context context) {
        super(context);
    }

    public TTMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TTMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public TTMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
