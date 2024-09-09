package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.shake.b;
import com.mbridge.msdk.splash.view.nativeview.MBNoRecycledCrashImageView;
import com.mbridge.msdk.splash.view.nativeview.MBSplashClickView;
import com.mbridge.msdk.widget.FeedBackButton;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBSplashNativeView extends RelativeLayout {
    private int A;
    private float B;
    private float C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private String I;
    private String J;
    private MBSplashView K;

    /* renamed from: L  reason: collision with root package name */
    private CampaignEx f40735L;
    private MBShakeView M;
    private String N;
    private String O;
    private String P;
    private b Q;

    /* renamed from: a  reason: collision with root package name */
    private MBNoRecycledCrashImageView f40736a;

    /* renamed from: b  reason: collision with root package name */
    private MBNoRecycledCrashImageView f40737b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f40738c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f40739d;

    /* renamed from: e  reason: collision with root package name */
    private FeedBackButton f40740e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f40741f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f40742g;

    /* renamed from: h  reason: collision with root package name */
    private MBNoRecycledCrashImageView f40743h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f40744i;

    /* renamed from: j  reason: collision with root package name */
    private MBNoRecycledCrashImageView f40745j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f40746k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f40747l;

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f40748m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f40749n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f40750o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f40751p;

    /* renamed from: q  reason: collision with root package name */
    private MBSplashClickView f40752q;

    /* renamed from: r  reason: collision with root package name */
    private int f40753r;

    /* renamed from: s  reason: collision with root package name */
    private int f40754s;

    /* renamed from: t  reason: collision with root package name */
    private int f40755t;

    /* renamed from: u  reason: collision with root package name */
    private int f40756u;

    /* renamed from: v  reason: collision with root package name */
    private int f40757v;

    /* renamed from: w  reason: collision with root package name */
    private int f40758w;

    /* renamed from: x  reason: collision with root package name */
    private int f40759x;

    /* renamed from: y  reason: collision with root package name */
    private int f40760y;

    /* renamed from: z  reason: collision with root package name */
    private int f40761z;

    public MBSplashNativeView(Context context) {
        super(context);
        this.G = false;
        this.H = false;
    }

    static /* synthetic */ void g(MBSplashNativeView mBSplashNativeView) {
        if (!TextUtils.isEmpty(mBSplashNativeView.f40735L.getIconUrl())) {
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(mBSplashNativeView.f40735L.getIconUrl(), new c() { // from class: com.mbridge.msdk.splash.view.MBSplashNativeView.4
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    MBSplashNativeView.this.f40743h.setVisibility(4);
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    Bitmap a4;
                    if (bitmap != null) {
                        try {
                            if (bitmap.isRecycled() || MBSplashNativeView.this.f40743h == null || (a4 = w.a(bitmap, 1, ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 40.0f))) == null || a4.isRecycled()) {
                                return;
                            }
                            MBSplashNativeView.this.f40743h.setImageBitmap(a4);
                        } catch (Throwable th) {
                            x.d("MBSplashNativeView", th.getMessage());
                        }
                    }
                }
            });
        } else {
            mBSplashNativeView.f40743h.setVisibility(4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.f40758w != 1 || this.M == null || this.Q == null) {
                return;
            }
            com.mbridge.msdk.shake.a.a().a(this.Q);
        } catch (Throwable th) {
            x.d("MBSplashNativeView", th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.B = motionEvent.getRawX();
        this.C = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.Q != null) {
                com.mbridge.msdk.shake.a.a().b(this.Q);
                this.Q = null;
            }
            com.mbridge.msdk.foundation.b.b.a().c(this.I);
            detachAllViewsFromParent();
        } catch (Exception e4) {
            x.d("MBSplashNativeView", e4.getMessage());
        }
    }

    public void setIsPause(boolean z3) {
        this.G = z3;
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7) {
        this.f40738c.setPadding(i4, i6, i5, i7);
    }

    public void updateCountDown(int i4) {
        String str;
        if (this.f40741f != null) {
            this.f40754s = i4;
            if (this.F) {
                str = this.O + " " + i4 + this.N;
            } else {
                str = i4 + this.N + " " + this.P;
            }
            this.f40741f.setText(str);
        }
    }

    static /* synthetic */ void c(MBSplashNativeView mBSplashNativeView, boolean z3) {
        if (mBSplashNativeView.K.getSplashJSBridgeImpl() == null || mBSplashNativeView.K.getSplashJSBridgeImpl().a() == null) {
            return;
        }
        mBSplashNativeView.K.getSplashJSBridgeImpl().a().a(z3 ? 2 : 1, mBSplashNativeView.f40754s);
    }

    static /* synthetic */ void a(MBSplashNativeView mBSplashNativeView, int i4) {
        if (mBSplashNativeView.K.getSplashJSBridgeImpl() == null || mBSplashNativeView.K.getSplashJSBridgeImpl().a() == null) {
            return;
        }
        try {
            mBSplashNativeView.K.getSplashJSBridgeImpl().a().a(com.mbridge.msdk.splash.a.a.a.a(com.mbridge.msdk.splash.a.a.a.a(i4, mBSplashNativeView.B, mBSplashNativeView.C), mBSplashNativeView.f40735L));
        } catch (Throwable th) {
            x.d("MBSplashNativeView", th.getMessage());
            mBSplashNativeView.K.getSplashJSBridgeImpl().a().a(mBSplashNativeView.f40735L);
        }
    }

    public MBSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashNativeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.G = false;
        this.H = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MBSplashNativeView(android.content.Context r8, com.mbridge.msdk.splash.view.MBSplashView r9, com.mbridge.msdk.splash.a.c r10) {
        /*
            Method dump skipped, instructions count: 1292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.view.MBSplashNativeView.<init>(android.content.Context, com.mbridge.msdk.splash.view.MBSplashView, com.mbridge.msdk.splash.a.c):void");
    }
}
