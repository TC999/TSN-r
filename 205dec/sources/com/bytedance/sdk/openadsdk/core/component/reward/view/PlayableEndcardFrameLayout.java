package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private c f32618c;

    /* renamed from: w  reason: collision with root package name */
    private int f32619w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    public void c(c cVar) {
        this.f32618c = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y3 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(this.f32619w - y3) > 100) {
                c();
            }
        } else {
            this.f32619w = y3;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void c() {
        c cVar = this.f32618c;
        if (cVar != null) {
            cVar.c();
        }
    }
}
