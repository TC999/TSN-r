package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends TouchDelegate {

    /* renamed from: c  reason: collision with root package name */
    private View f30222c;
    private boolean sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private Rect f30223w;
    private Rect xv;

    public r(Rect rect, View view) {
        super(rect, view);
        this.f30223w = rect;
        this.ux = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.xv = rect2;
        int i4 = this.ux;
        rect2.inset(-i4, -i4);
        this.f30222c = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z5 = this.sr;
                if (z5) {
                    z3 = this.xv.contains(x3, y3);
                    z4 = z5;
                } else {
                    z4 = z5;
                }
            } else {
                if (action == 3) {
                    boolean z6 = this.sr;
                    this.sr = false;
                    z4 = z6;
                }
                z3 = true;
                z4 = false;
            }
            z3 = true;
        } else if (this.f30223w.contains(x3, y3)) {
            this.sr = true;
            z3 = true;
        } else {
            this.sr = false;
            z3 = true;
            z4 = false;
        }
        if (z4) {
            View view = this.f30222c;
            if (z3) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f4 = -(this.ux * 2);
                motionEvent.setLocation(f4, f4);
            }
            if (view.getVisibility() == 0) {
                return view.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
