package com.bigkoo.pickerview.lib;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: com.bigkoo.pickerview.lib.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final WheelView f13105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoopViewGestureListener(WheelView wheelView) {
        this.f13105a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f13105a.m45879n(f2);
        return true;
    }
}
