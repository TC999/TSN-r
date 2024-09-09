package com.acse.ottn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ContinueSlideScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6950a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6951b;

    /* renamed from: c  reason: collision with root package name */
    public Context f6952c;

    /* renamed from: d  reason: collision with root package name */
    public a f6953d;

    /* renamed from: e  reason: collision with root package name */
    public float f6954e;

    /* renamed from: f  reason: collision with root package name */
    public float f6955f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6956g;

    /* renamed from: h  reason: collision with root package name */
    public int f6957h;

    /* renamed from: i  reason: collision with root package name */
    public b f6958i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface b {
        void a();

        void b();
    }

    public ContinueSlideScrollView(Context context) {
        super(context);
        this.f6950a = true;
        this.f6951b = false;
        this.f6956g = false;
        this.f6957h = 160;
        this.f6952c = context;
    }

    public boolean a() {
        return this.f6951b;
    }

    public boolean b() {
        return this.f6950a;
    }

    public final void c() {
        a aVar;
        if (this.f6950a) {
            a aVar2 = this.f6953d;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (!this.f6951b || (aVar = this.f6953d) == null) {
        } else {
            aVar.a();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i4, int i5, boolean z3, boolean z4) {
        super.onOverScrolled(i4, i5, z3, z4);
        if (i5 == 0) {
            this.f6950a = z4;
            this.f6951b = false;
        } else {
            this.f6950a = false;
            this.f6951b = z4;
        }
        c();
    }

    @Override // android.view.View
    public void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6954e = motionEvent.getY();
            this.f6956g = true;
        } else if (action == 1) {
            this.f6956g = true;
            this.f6955f = 0.0f;
            this.f6954e = 0.0f;
        } else if (action == 2) {
            this.f6955f = motionEvent.getY();
            if (this.f6956g && b() && this.f6955f - this.f6954e > a(this.f6952c, this.f6957h)) {
                this.f6956g = false;
                Log.i("ccb", "onTouchEvent: \u56de\u5230\u9876\u90e8\uff0c\u7ee7\u7eed\u6ed1\u52a8" + (this.f6955f - this.f6954e));
                b bVar = this.f6958i;
                if (bVar != null) {
                    bVar.a();
                }
            }
            if (this.f6956g && a() && this.f6955f - this.f6954e < (-a(this.f6952c, this.f6957h))) {
                this.f6956g = false;
                Log.i("ccb", "onTouchEvent: \u5df2\u7ecf\u5230\u5e95\uff0c\u7ee7\u7eed\u6ed1\u52a8" + (this.f6955f - this.f6954e));
                b bVar2 = this.f6958i;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScanScrollChangedListener(a aVar) {
        this.f6953d = aVar;
    }

    public void setonContinueSlideListener(b bVar) {
        this.f6958i = bVar;
    }

    public static int a(Context context, int i4) {
        return (int) ((i4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6950a = true;
        this.f6951b = false;
        this.f6956g = false;
        this.f6957h = 160;
        this.f6952c = context;
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6950a = true;
        this.f6951b = false;
        this.f6956g = false;
        this.f6957h = 160;
        this.f6952c = context;
    }
}
