package com.devlin_n.videoplayer.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c1.f;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.player.IjkVideoView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class FloatView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f36984a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager.LayoutParams f36985b;

    /* renamed from: c  reason: collision with root package name */
    public IjkVideoView f36986c;

    /* renamed from: d  reason: collision with root package name */
    private int f36987d;

    /* renamed from: e  reason: collision with root package name */
    private int f36988e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f36989f;

    public FloatView(@NonNull Context context, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        super(context);
        this.f36989f = true;
        this.f36984a = windowManager;
        this.f36985b = layoutParams;
        a();
    }

    private void a() {
        setBackgroundResource(R.drawable.shape_float_window_background);
        int a4 = f.a(getContext(), 1.0f);
        setPadding(a4, a4, a4, a4);
        IjkVideoView ijkVideoView = new IjkVideoView(getContext());
        this.f36986c = ijkVideoView;
        addView(ijkVideoView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return motionEvent.getAction() != 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f36989f = true;
        } else if (action == 2) {
            if (this.f36989f) {
                this.f36987d = (int) motionEvent.getX();
                double y3 = motionEvent.getY();
                double f4 = f.f(getContext());
                Double.isNaN(y3);
                this.f36988e = (int) (y3 + f4);
                this.f36989f = false;
            }
            WindowManager.LayoutParams layoutParams = this.f36985b;
            layoutParams.x = rawX - this.f36987d;
            layoutParams.y = rawY - this.f36988e;
            this.f36984a.updateViewLayout(this, layoutParams);
        }
        return super.onTouchEvent(motionEvent);
    }
}
