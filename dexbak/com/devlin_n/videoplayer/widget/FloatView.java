package com.devlin_n.videoplayer.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.devlin_n.videoplayer.C6596R;
import com.devlin_n.videoplayer.player.IjkVideoView;
import p601i0.C13584f;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FloatView extends FrameLayout {

    /* renamed from: a */
    private WindowManager f23388a;

    /* renamed from: b */
    private WindowManager.LayoutParams f23389b;

    /* renamed from: c */
    public IjkVideoView f23390c;

    /* renamed from: d */
    private int f23391d;

    /* renamed from: e */
    private int f23392e;

    /* renamed from: f */
    private boolean f23393f;

    public FloatView(@NonNull Context context, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        super(context);
        this.f23393f = true;
        this.f23388a = windowManager;
        this.f23389b = layoutParams;
        m35669a();
    }

    /* renamed from: a */
    private void m35669a() {
        setBackgroundResource(C6596R.C6598drawable.shape_float_window_background);
        int m12710a = C13584f.m12710a(getContext(), 1.0f);
        setPadding(m12710a, m12710a, m12710a, m12710a);
        IjkVideoView ijkVideoView = new IjkVideoView(getContext());
        this.f23390c = ijkVideoView;
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
            this.f23393f = true;
        } else if (action == 2) {
            if (this.f23393f) {
                this.f23391d = (int) motionEvent.getX();
                double y = motionEvent.getY();
                double m12705f = C13584f.m12705f(getContext());
                Double.isNaN(y);
                this.f23392e = (int) (y + m12705f);
                this.f23393f = false;
            }
            WindowManager.LayoutParams layoutParams = this.f23389b;
            layoutParams.x = rawX - this.f23391d;
            layoutParams.y = rawY - this.f23392e;
            this.f23388a.updateViewLayout(this, layoutParams);
        }
        return super.onTouchEvent(motionEvent);
    }
}
