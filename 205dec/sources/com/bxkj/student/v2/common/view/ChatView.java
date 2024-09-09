package com.bxkj.student.v2.common.view;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.u;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ChatView extends RelativeLayout {

    /* renamed from: k  reason: collision with root package name */
    private static final int f23415k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f23416l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f23417m = 3;

    /* renamed from: n  reason: collision with root package name */
    private static final int f23418n = 4;

    /* renamed from: a  reason: collision with root package name */
    private int f23419a;

    /* renamed from: b  reason: collision with root package name */
    private int f23420b;

    /* renamed from: c  reason: collision with root package name */
    private int f23421c;

    /* renamed from: d  reason: collision with root package name */
    private WindowManager.LayoutParams f23422d;

    /* renamed from: e  reason: collision with root package name */
    private WindowManager f23423e;

    /* renamed from: f  reason: collision with root package name */
    private float f23424f;

    /* renamed from: g  reason: collision with root package name */
    private float f23425g;

    /* renamed from: h  reason: collision with root package name */
    private float f23426h;

    /* renamed from: i  reason: collision with root package name */
    private float f23427i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23428j;

    public ChatView(Activity activity) {
        super(activity);
        LayoutInflater.from(activity).inflate(2131427638, this);
        this.f23423e = (WindowManager) activity.getSystemService("window");
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f23419a = u.a(50.0f, activity);
        this.f23421c = this.f23423e.getDefaultDisplay().getWidth();
        this.f23420b = this.f23423e.getDefaultDisplay().getHeight();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f23422d = layoutParams;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.gravity = 53;
        layoutParams.flags = 8;
        int i4 = this.f23419a;
        layoutParams.width = i4;
        layoutParams.height = i4;
        layoutParams.y = (this.f23420b - i4) >> 1;
        this.f23423e.addView(this, layoutParams);
        d();
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.v2.common.view.ChatView.1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy() {
                    ChatView.this.b();
                }
            });
        }
    }

    private void a() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (iArr[0] < (this.f23421c / 2) - (getWidth() / 2)) {
            g(0);
        } else {
            g(1);
        }
    }

    private int c(int densityDpi) {
        if (densityDpi <= 120) {
            return 36;
        }
        if (densityDpi <= 160) {
            return 48;
        }
        if (densityDpi <= 240) {
            return 72;
        }
        return densityDpi <= 320 ? 96 : 108;
    }

    private void f() {
        WindowManager.LayoutParams layoutParams = this.f23422d;
        layoutParams.x = (int) (this.f23424f - this.f23426h);
        layoutParams.y = (int) ((this.f23425g - this.f23427i) - (this.f23420b / 25));
        this.f23423e.updateViewLayout(this, layoutParams);
    }

    private void g(int l4) {
        if (l4 == 0) {
            this.f23422d.x = 0;
        } else if (l4 == 1) {
            this.f23422d.x = this.f23421c - this.f23419a;
        } else if (l4 == 3) {
            this.f23422d.y = 0;
        } else if (l4 == 4) {
            this.f23422d.y = this.f23420b - this.f23419a;
        }
        this.f23423e.updateViewLayout(this, this.f23422d);
    }

    public void b() {
        d();
        this.f23423e.removeViewImmediate(this);
    }

    public void d() {
        setVisibility(8);
    }

    public void e() {
        if (isShown()) {
            return;
        }
        setVisibility(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.f23424f = event.getRawX();
        this.f23425g = event.getRawY();
        int action = event.getAction();
        if (action == 0) {
            this.f23426h = event.getX();
            this.f23427i = event.getY();
        } else if (action == 1) {
            if (this.f23428j) {
                a();
            }
            this.f23428j = false;
            this.f23427i = 0.0f;
            this.f23426h = 0.0f;
        } else if (action == 2) {
            if (this.f23428j) {
                f();
            } else if (Math.abs(this.f23426h - event.getX()) > this.f23419a / 3 || Math.abs(this.f23427i - event.getY()) > this.f23419a / 3) {
                f();
            }
            this.f23428j = true;
        }
        return super.onTouchEvent(event);
    }
}
