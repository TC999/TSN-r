package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p470b.FeedbackManager;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.tools.SameImageTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.shake.NativeShakeManager;
import com.mbridge.msdk.shake.ShakeSensorEventListener;
import com.mbridge.msdk.splash.p501a.p502a.SplashUtils;
import com.mbridge.msdk.splash.view.nativeview.MBNoRecycledCrashImageView;
import com.mbridge.msdk.splash.view.nativeview.MBSplashClickView;
import com.mbridge.msdk.widget.FeedBackButton;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBSplashNativeView extends RelativeLayout {

    /* renamed from: A */
    private int f31968A;

    /* renamed from: B */
    private float f31969B;

    /* renamed from: C */
    private float f31970C;

    /* renamed from: D */
    private boolean f31971D;

    /* renamed from: E */
    private boolean f31972E;

    /* renamed from: F */
    private boolean f31973F;

    /* renamed from: G */
    private boolean f31974G;

    /* renamed from: H */
    private boolean f31975H;

    /* renamed from: I */
    private String f31976I;

    /* renamed from: J */
    private String f31977J;

    /* renamed from: K */
    private MBSplashView f31978K;

    /* renamed from: L */
    private CampaignEx f31979L;

    /* renamed from: M */
    private MBShakeView f31980M;

    /* renamed from: N */
    private String f31981N;

    /* renamed from: O */
    private String f31982O;

    /* renamed from: P */
    private String f31983P;

    /* renamed from: Q */
    private ShakeSensorEventListener f31984Q;

    /* renamed from: a */
    private MBNoRecycledCrashImageView f31985a;

    /* renamed from: b */
    private MBNoRecycledCrashImageView f31986b;

    /* renamed from: c */
    private RelativeLayout f31987c;

    /* renamed from: d */
    private ImageView f31988d;

    /* renamed from: e */
    private FeedBackButton f31989e;

    /* renamed from: f */
    private TextView f31990f;

    /* renamed from: g */
    private RelativeLayout f31991g;

    /* renamed from: h */
    private MBNoRecycledCrashImageView f31992h;

    /* renamed from: i */
    private TextView f31993i;

    /* renamed from: j */
    private MBNoRecycledCrashImageView f31994j;

    /* renamed from: k */
    private TextView f31995k;

    /* renamed from: l */
    private TextView f31996l;

    /* renamed from: m */
    private RelativeLayout f31997m;

    /* renamed from: n */
    private TextView f31998n;

    /* renamed from: o */
    private TextView f31999o;

    /* renamed from: p */
    private TextView f32000p;

    /* renamed from: q */
    private MBSplashClickView f32001q;

    /* renamed from: r */
    private int f32002r;

    /* renamed from: s */
    private int f32003s;

    /* renamed from: t */
    private int f32004t;

    /* renamed from: u */
    private int f32005u;

    /* renamed from: v */
    private int f32006v;

    /* renamed from: w */
    private int f32007w;

    /* renamed from: x */
    private int f32008x;

    /* renamed from: y */
    private int f32009y;

    /* renamed from: z */
    private int f32010z;

    public MBSplashNativeView(Context context) {
        super(context);
        this.f31974G = false;
        this.f31975H = false;
    }

    /* renamed from: g */
    static /* synthetic */ void m20996g(MBSplashNativeView mBSplashNativeView) {
        if (!TextUtils.isEmpty(mBSplashNativeView.f31979L.getIconUrl())) {
            CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(mBSplashNativeView.f31979L.getIconUrl(), new CommonImageLoaderListener() { // from class: com.mbridge.msdk.splash.view.MBSplashNativeView.4
                @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                public final void onFailedLoad(String str, String str2) {
                    MBSplashNativeView.this.f31992h.setVisibility(4);
                }

                @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    Bitmap m21740a;
                    if (bitmap != null) {
                        try {
                            if (bitmap.isRecycled() || MBSplashNativeView.this.f31992h == null || (m21740a = SameImageTool.m21740a(bitmap, 1, SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 40.0f))) == null || m21740a.isRecycled()) {
                                return;
                            }
                            MBSplashNativeView.this.f31992h.setImageBitmap(m21740a);
                        } catch (Throwable th) {
                            SameLogTool.m21733d("MBSplashNativeView", th.getMessage());
                        }
                    }
                }
            });
        } else {
            mBSplashNativeView.f31992h.setVisibility(4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.f32007w != 1 || this.f31980M == null || this.f31984Q == null) {
                return;
            }
            NativeShakeManager.m21302a().m21301a(this.f31984Q);
        } catch (Throwable th) {
            SameLogTool.m21733d("MBSplashNativeView", th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f31969B = motionEvent.getRawX();
        this.f31970C = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.f31984Q != null) {
                NativeShakeManager.m21302a().m21300b(this.f31984Q);
                this.f31984Q = null;
            }
            FeedbackManager.m22907a().m22891c(this.f31976I);
            detachAllViewsFromParent();
        } catch (Exception e) {
            SameLogTool.m21733d("MBSplashNativeView", e.getMessage());
        }
    }

    public void setIsPause(boolean z) {
        this.f31974G = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.f31987c.setPadding(i, i3, i2, i4);
    }

    public void updateCountDown(int i) {
        String str;
        if (this.f31990f != null) {
            this.f32003s = i;
            if (this.f31973F) {
                str = this.f31982O + " " + i + this.f31981N;
            } else {
                str = i + this.f31981N + " " + this.f31983P;
            }
            this.f31990f.setText(str);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m21000c(MBSplashNativeView mBSplashNativeView, boolean z) {
        if (mBSplashNativeView.f31978K.getSplashJSBridgeImpl() == null || mBSplashNativeView.f31978K.getSplashJSBridgeImpl().m21036a() == null) {
            return;
        }
        mBSplashNativeView.f31978K.getSplashJSBridgeImpl().m21036a().mo21118a(z ? 2 : 1, mBSplashNativeView.f32003s);
    }

    /* renamed from: a */
    static /* synthetic */ void m21005a(MBSplashNativeView mBSplashNativeView, int i) {
        if (mBSplashNativeView.f31978K.getSplashJSBridgeImpl() == null || mBSplashNativeView.f31978K.getSplashJSBridgeImpl().m21036a() == null) {
            return;
        }
        try {
            mBSplashNativeView.f31978K.getSplashJSBridgeImpl().m21036a().mo21117a(SplashUtils.m21294a(SplashUtils.m21296a(i, mBSplashNativeView.f31969B, mBSplashNativeView.f31970C), mBSplashNativeView.f31979L));
        } catch (Throwable th) {
            SameLogTool.m21733d("MBSplashNativeView", th.getMessage());
            mBSplashNativeView.f31978K.getSplashJSBridgeImpl().m21036a().mo21117a(mBSplashNativeView.f31979L);
        }
    }

    public MBSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31974G = false;
        this.f31975H = false;
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
    public MBSplashNativeView(android.content.Context r8, com.mbridge.msdk.splash.view.MBSplashView r9, com.mbridge.msdk.splash.p501a.ViewRenderParam r10) {
        /*
            Method dump skipped, instructions count: 1292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.view.MBSplashNativeView.<init>(android.content.Context, com.mbridge.msdk.splash.view.MBSplashView, com.mbridge.msdk.splash.a.c):void");
    }
}
