package com.bxkj.student.v2.common.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;
import com.orhanobut.logger.j;

/* compiled from: FloatActionView2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class g {

    /* compiled from: FloatActionView2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f23546a;

        /* renamed from: b  reason: collision with root package name */
        private int f23547b;

        /* renamed from: c  reason: collision with root package name */
        private float f23548c;

        /* renamed from: d  reason: collision with root package name */
        private float f23549d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f23550e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Activity f23551f;

        a(final int val$screenWidth, final Activity val$activity) {
            this.f23550e = val$screenWidth;
            this.f23551f = val$activity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v3, MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                this.f23546a = ((int) v3.getX()) - ((int) event.getRawX());
                this.f23547b = ((int) v3.getY()) - ((int) event.getRawY());
                this.f23548c = event.getRawX();
                this.f23549d = event.getRawY();
            } else if (action == 1) {
                float abs = Math.abs(event.getRawX() - this.f23548c);
                float abs2 = Math.abs(event.getRawY() - this.f23549d);
                if (abs == 0.0f && abs2 == 0.0f) {
                    j.c("\u63d0\u4ea4\u53cd\u9988");
                }
                Rect rect = new Rect();
                this.f23551f.getWindow().getDecorView().getGlobalVisibleRect(rect);
                if (!rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v3.animate().x(this.f23548c + this.f23546a).y(this.f23549d + this.f23547b).setDuration(300L).start();
                }
            } else if (action != 2) {
                return false;
            } else {
                v3.animate().x(event.getRawX() + this.f23546a).y(event.getRawY() + this.f23547b).setDuration(0L).start();
                float x3 = v3.getX() + v3.getWidth();
                j.c("\u79fb\u52a8 viewRightEdge=" + x3 + " screenWidth=" + this.f23550e);
            }
            return true;
        }
    }

    g() {
    }

    private View b(final Activity activity) {
        LinearLayout linearLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setGravity(53);
        linearLayout.setPadding(0, 0, u.a(10.0f, activity), 0);
        linearLayout.setBackgroundColor(ContextCompat.getColor(activity, 17170445));
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = u.a(200.0f, activity);
        layoutParams2.topMargin = u.a(200.0f, activity);
        View inflate = LayoutInflater.from(activity).inflate(2131427638, (ViewGroup) null);
        inflate.findViewById(2131232322);
        linearLayout.addView(inflate, layoutParams2);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(linearLayout);
        inflate.setOnTouchListener(new a(activity.getResources().getDisplayMetrics().widthPixels, activity));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.common.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.c("\u63d0\u4ea4\u53cd\u9988");
            }
        });
        return linearLayout;
    }
}
