package com.mbridge.msdk.widget;

import android.view.View;
import java.util.Calendar;

/* compiled from: MBridgeNoDoubleClick.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private long f41093a = 0;

    protected abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f41093a > 2000) {
            this.f41093a = timeInMillis;
            a(view);
        }
    }
}
