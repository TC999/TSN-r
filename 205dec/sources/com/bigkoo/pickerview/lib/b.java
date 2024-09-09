package com.bigkoo.pickerview.lib;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LoopViewGestureListener.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final WheelView f16303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WheelView wheelView) {
        this.f16303a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        this.f16303a.n(f5);
        return true;
    }
}
