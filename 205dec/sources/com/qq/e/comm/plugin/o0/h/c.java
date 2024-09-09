package com.qq.e.comm.plugin.o0.h;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private long f45121c;

    /* renamed from: d  reason: collision with root package name */
    private a f45122d;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a();
    }

    public c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f45122d = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f45122d != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f45121c > 1000) {
                this.f45121c = elapsedRealtime;
                this.f45122d.a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
