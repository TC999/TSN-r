package com.acse.ottn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ContinueSlideScrollView extends ScrollView {

    /* renamed from: a */
    private boolean f3405a;

    /* renamed from: b */
    private boolean f3406b;

    /* renamed from: c */
    private Context f3407c;

    /* renamed from: d */
    private InterfaceC1713a f3408d;

    /* renamed from: e */
    private float f3409e;

    /* renamed from: f */
    private float f3410f;

    /* renamed from: g */
    private boolean f3411g;

    /* renamed from: h */
    private int f3412h;

    /* renamed from: i */
    public InterfaceC1714b f3413i;

    /* renamed from: com.acse.ottn.widget.ContinueSlideScrollView$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1713a {
        /* renamed from: a */
        void mo55855a();

        /* renamed from: b */
        void mo55854b();
    }

    /* renamed from: com.acse.ottn.widget.ContinueSlideScrollView$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1714b {
        /* renamed from: a */
        void m55853a();

        /* renamed from: b */
        void m55852b();
    }

    public ContinueSlideScrollView(Context context) {
        super(context);
        this.f3405a = true;
        this.f3406b = false;
        this.f3411g = false;
        this.f3412h = 160;
        this.f3407c = context;
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3405a = true;
        this.f3406b = false;
        this.f3411g = false;
        this.f3412h = 160;
        this.f3407c = context;
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3405a = true;
        this.f3406b = false;
        this.f3411g = false;
        this.f3412h = 160;
        this.f3407c = context;
    }

    /* renamed from: a */
    public static int m55858a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    private void m55856c() {
        InterfaceC1713a interfaceC1713a;
        if (this.f3405a) {
            InterfaceC1713a interfaceC1713a2 = this.f3408d;
            if (interfaceC1713a2 != null) {
                interfaceC1713a2.mo55854b();
            }
        } else if (!this.f3406b || (interfaceC1713a = this.f3408d) == null) {
        } else {
            interfaceC1713a.mo55855a();
        }
    }

    /* renamed from: a */
    public boolean m55859a() {
        return this.f3406b;
    }

    /* renamed from: b */
    public boolean m55857b() {
        return this.f3405a;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.f3405a = z2;
            this.f3406b = false;
        } else {
            this.f3405a = false;
            this.f3406b = z2;
        }
        m55856c();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3409e = motionEvent.getY();
            this.f3411g = true;
        } else if (action == 1) {
            this.f3411g = true;
            this.f3410f = 0.0f;
            this.f3409e = 0.0f;
        } else if (action == 2) {
            this.f3410f = motionEvent.getY();
            if (this.f3411g && m55857b() && this.f3410f - this.f3409e > m55858a(this.f3407c, this.f3412h)) {
                this.f3411g = false;
                Log.i("ccb", "onTouchEvent: 回到顶部，继续滑动" + (this.f3410f - this.f3409e));
                InterfaceC1714b interfaceC1714b = this.f3413i;
                if (interfaceC1714b != null) {
                    interfaceC1714b.m55853a();
                }
            }
            if (this.f3411g && m55859a() && this.f3410f - this.f3409e < (-m55858a(this.f3407c, this.f3412h))) {
                this.f3411g = false;
                Log.i("ccb", "onTouchEvent: 已经到底，继续滑动" + (this.f3410f - this.f3409e));
                InterfaceC1714b interfaceC1714b2 = this.f3413i;
                if (interfaceC1714b2 != null) {
                    interfaceC1714b2.m55852b();
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScanScrollChangedListener(InterfaceC1713a interfaceC1713a) {
        this.f3408d = interfaceC1713a;
    }

    public void setonContinueSlideListener(InterfaceC1714b interfaceC1714b) {
        this.f3413i = interfaceC1714b;
    }
}
