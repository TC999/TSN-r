package com.beizi.p051ad.internal.utilities;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.beizi.p051ad.lance.p062a.LogUtil;

/* renamed from: com.beizi.ad.internal.utilities.TouchDelegate */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TouchDelegate extends android.view.TouchDelegate {
    public static final int ABOVE = 1;
    public static final int BELOW = 2;
    public static final int TO_LEFT = 4;
    public static final int TO_RIGHT = 8;
    private Rect mBounds;
    private boolean mDelegateTargeted;
    private View mDelegateView;
    private int mSlop;
    private Rect mSlopBounds;

    public TouchDelegate(Rect rect, View view) {
        super(rect, view);
        this.mBounds = rect;
        this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.mSlopBounds = rect2;
        int i = this.mSlop;
        rect2.inset(-i, -i);
        this.mDelegateView = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                if (actionMasked == 3) {
                    z = this.mDelegateTargeted;
                    this.mDelegateTargeted = false;
                } else if (actionMasked != 5 && actionMasked != 6) {
                    z = false;
                }
            }
            boolean z2 = this.mDelegateTargeted;
            r3 = z2 ? this.mSlopBounds.contains(x, y) : true;
            z = z2;
        } else {
            LogUtil.m49044c("BeiZisAd", "TouchDelegate mBounds = " + this.mBounds + ",x = " + x + ",y = " + y);
            this.mDelegateTargeted = this.mBounds.contains(x, y);
            StringBuilder sb = new StringBuilder();
            sb.append("TouchDelegate onTouchEvent mDelegateTargeted = ");
            sb.append(this.mDelegateTargeted);
            LogUtil.m49044c("BeiZisAd", sb.toString());
            z = this.mDelegateTargeted;
        }
        if (z) {
            View view = this.mDelegateView;
            if (r3) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f = -(this.mSlop * 2);
                motionEvent.setLocation(f, f);
            }
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
