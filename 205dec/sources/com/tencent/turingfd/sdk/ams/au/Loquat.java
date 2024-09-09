package com.tencent.turingfd.sdk.ams.au;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.turingfd.sdk.ams.au.Csuper;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Loquat extends Cif {

    /* renamed from: d  reason: collision with root package name */
    public final String f52140d;

    /* renamed from: e  reason: collision with root package name */
    public final Coconut f52141e;

    public Loquat(Window.Callback callback, String str, Coconut coconut) {
        super(callback);
        this.f52140d = str;
        this.f52141e = coconut;
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Cif, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        LeoMinor leoMinor;
        Coconut coconut = this.f52141e;
        String str = this.f52140d;
        Csuper.Cdo cdo = (Csuper.Cdo) coconut;
        if (!cdo.f52359a.get()) {
            synchronized (LeoMinor.f52113i) {
                leoMinor = LeoMinor.f52115k;
                if (leoMinor == null) {
                    leoMinor = new LeoMinor();
                } else {
                    LeoMinor.f52115k = leoMinor.f52116a;
                    LeoMinor.f52114j--;
                    leoMinor.f52116a = null;
                }
            }
            leoMinor.f52117b = str;
            leoMinor.f52118c = motionEvent.getAction();
            leoMinor.f52119d = motionEvent.getDeviceId();
            leoMinor.f52120e = motionEvent.getToolType(0);
            leoMinor.f52121f = motionEvent.getPressure();
            leoMinor.f52122g = motionEvent.getSize();
            leoMinor.f52123h = System.currentTimeMillis();
            cdo.f52360b.obtainMessage(2, leoMinor).sendToTarget();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
