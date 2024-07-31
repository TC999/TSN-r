package com.mbridge.msdk.widget;

import android.view.View;
import java.util.Calendar;

/* renamed from: com.mbridge.msdk.widget.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class MBridgeNoDoubleClick implements View.OnClickListener {

    /* renamed from: a */
    private long f32382a = 0;

    /* renamed from: a */
    protected abstract void m20619a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f32382a > 2000) {
            this.f32382a = timeInMillis;
            m20619a(view);
        }
    }
}
