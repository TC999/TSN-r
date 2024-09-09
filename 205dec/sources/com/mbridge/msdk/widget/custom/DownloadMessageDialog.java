package com.mbridge.msdk.widget.custom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.custom.a;
import com.mbridge.msdk.widget.custom.baseview.MBButton;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadMessageDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private float f41094a;

    /* renamed from: b  reason: collision with root package name */
    private int f41095b;

    /* renamed from: c  reason: collision with root package name */
    private int f41096c;

    /* renamed from: d  reason: collision with root package name */
    private CustomViewMessageWrap f41097d;

    /* renamed from: e  reason: collision with root package name */
    private com.mbridge.msdk.widget.custom.a f41098e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f41099f;

    /* renamed from: g  reason: collision with root package name */
    private OrientationEventListener f41100g;

    /* renamed from: h  reason: collision with root package name */
    private b f41101h;

    /* renamed from: i  reason: collision with root package name */
    private AnimatorSet f41102i;

    /* renamed from: j  reason: collision with root package name */
    private a f41103j;

    /* renamed from: k  reason: collision with root package name */
    private com.mbridge.msdk.widget.custom.a f41104k;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a(int i4);
    }

    public DownloadMessageDialog(Context context, boolean z3, CustomViewMessageWrap customViewMessageWrap, com.mbridge.msdk.widget.custom.a aVar) {
        this(context, z3, null, customViewMessageWrap, aVar);
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        try {
            AnimatorSet animatorSet = this.f41102i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            OrientationEventListener orientationEventListener = this.f41100g;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f41100g.disable();
            }
        } catch (Exception e4) {
            x.d("DownloadMessageDialog", e4.getMessage());
        }
        super.cancel();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View decorView;
        try {
            AnimatorSet animatorSet = this.f41102i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            OrientationEventListener orientationEventListener = this.f41100g;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f41100g.disable();
            }
        } catch (Exception e4) {
            x.d("DownloadMessageDialog", e4.getMessage());
        }
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || decorView.getParent() == null) {
            return;
        }
        super.dismiss();
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 19) {
                window.addFlags(TTAdConstant.KEY_CLICK_AREA);
                window.getDecorView().setSystemUiVisibility(4098);
            } else {
                window.getDecorView().setSystemUiVisibility(2);
            }
            if (i4 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        try {
            AnimatorSet animatorSet = this.f41102i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            OrientationEventListener orientationEventListener = this.f41100g;
            if (orientationEventListener == null || !orientationEventListener.canDetectOrientation()) {
                return;
            }
            this.f41100g.disable();
        } catch (Exception e4) {
            x.d("DownloadMessageDialog", e4.getMessage());
        }
    }

    public void registerOrientationListener(a aVar) {
        this.f41103j = aVar;
    }

    public void setRenderListener(com.mbridge.msdk.widget.custom.a aVar) {
        this.f41098e = aVar;
    }

    @Override // android.app.Dialog
    public void show() {
        MBButton a4;
        try {
            if (this.f41099f) {
                Window window = getWindow();
                if (window == null) {
                    this.f41104k.a(this, this.f41097d, new Exception("window is null"));
                    return;
                }
                window.setFlags(1024, 1024);
                window.setFlags(8, 8);
                window.getDecorView().setSystemUiVisibility(256);
                window.getDecorView().setSystemUiVisibility(512);
                window.getDecorView().setSystemUiVisibility(4096);
                window.getDecorView().setSystemUiVisibility(1024);
                window.getDecorView().setSystemUiVisibility(4);
                window.clearFlags(8);
                try {
                    getWindow().setFlags(8, 8);
                    if (getContext() != null) {
                        ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) getContext();
                        if (contextThemeWrapper.getBaseContext() instanceof Activity) {
                            Activity activity = (Activity) contextThemeWrapper.getBaseContext();
                            if (!activity.isFinishing() && !activity.isDestroyed()) {
                                super.show();
                            }
                            return;
                        }
                    }
                    hideNavigationBar(getWindow());
                    getWindow().clearFlags(8);
                    this.f41104k.c(this, this.f41097d);
                    if (Build.VERSION.SDK_INT <= 20) {
                        try {
                            MBButton mBButton = (MBButton) this.f41097d.getView("download");
                            if (mBButton != null) {
                                mBButton.setPadding(0, 0, 0, 0);
                            }
                        } catch (Exception e4) {
                            x.d("dialog", e4.getMessage());
                        }
                    }
                    if (this.f41100g == null) {
                        OrientationEventListener orientationEventListener = new OrientationEventListener(getContext(), 1) { // from class: com.mbridge.msdk.widget.custom.DownloadMessageDialog.2
                            @Override // android.view.OrientationEventListener
                            public final void onOrientationChanged(int i4) {
                                try {
                                    WindowManager.LayoutParams attributes = DownloadMessageDialog.this.getWindow().getAttributes();
                                    DisplayMetrics displayMetrics = DownloadMessageDialog.this.getContext().getResources().getDisplayMetrics();
                                    if (DownloadMessageDialog.this.getContext().getResources().getConfiguration().orientation == 1) {
                                        if (DownloadMessageDialog.this.f41103j != null) {
                                            DownloadMessageDialog.this.f41103j.a(1);
                                        }
                                        attributes.width = -1;
                                        attributes.height = (int) (displayMetrics.heightPixels * DownloadMessageDialog.this.f41094a);
                                        attributes.gravity = 80;
                                    } else {
                                        if (DownloadMessageDialog.this.f41103j != null) {
                                            DownloadMessageDialog.this.f41103j.a(2);
                                        }
                                        double d4 = displayMetrics.widthPixels;
                                        Double.isNaN(d4);
                                        attributes.width = (int) (d4 * 0.5d);
                                        attributes.height = -1;
                                        attributes.gravity = 17;
                                    }
                                    DownloadMessageDialog.this.getWindow().setAttributes(attributes);
                                } catch (Throwable th) {
                                    x.d("DownloadMessageDialog", th.getMessage());
                                }
                            }
                        };
                        this.f41100g = orientationEventListener;
                        if (orientationEventListener.canDetectOrientation()) {
                            this.f41100g.enable();
                        } else {
                            this.f41100g.disable();
                            this.f41100g = null;
                        }
                    }
                    OrientationEventListener orientationEventListener2 = this.f41100g;
                    if (orientationEventListener2 != null && orientationEventListener2.canDetectOrientation()) {
                        CampaignEx campaignEx = this.f41097d.getCampaignEx();
                        if (campaignEx == null || !(campaignEx.getAdType() == 94 || campaignEx.getAdType() == 287)) {
                            if (campaignEx != null) {
                                this.f41100g.enable();
                            }
                        } else if (campaignEx.getRewardTemplateMode() != null && campaignEx.getRewardTemplateMode().c() == 0) {
                            this.f41100g.enable();
                        }
                    }
                    b bVar = this.f41101h;
                    if (bVar == null || bVar.a() == null || (a4 = this.f41101h.a()) == null || !String.valueOf(a4.getContentDescription()).contains("anim")) {
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a4, "scaleX", 1.2f, 0.8f);
                    ofFloat.setRepeatCount(-1);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(a4, "scaleY", 1.2f, 0.8f);
                    ofFloat2.setRepeatCount(-1);
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f41102i = animatorSet;
                    animatorSet.play(ofFloat).with(ofFloat2);
                    this.f41102i.setDuration(2000L);
                    this.f41102i.start();
                } catch (Exception e5) {
                    this.f41104k.a(this, this.f41097d, e5);
                }
            }
        } catch (Exception e6) {
            x.d("DownloadMessageDialog", e6.getMessage());
        }
    }

    public DownloadMessageDialog(Context context, boolean z3, DialogInterface.OnCancelListener onCancelListener, CustomViewMessageWrap customViewMessageWrap, com.mbridge.msdk.widget.custom.a aVar) {
        super(context, r.a(context, "mbridge_dialog_fullscreen_bottom", "style"));
        this.f41094a = 0.8f;
        this.f41099f = false;
        this.f41100g = null;
        this.f41104k = new com.mbridge.msdk.widget.custom.a() { // from class: com.mbridge.msdk.widget.custom.DownloadMessageDialog.1
            @Override // com.mbridge.msdk.widget.custom.a
            public final void a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2) {
                if (DownloadMessageDialog.this.f41098e != null) {
                    DownloadMessageDialog.this.f41098e.a(downloadMessageDialog, customViewMessageWrap2);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.a
            public final void b(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2) {
                if (DownloadMessageDialog.this.f41098e != null) {
                    DownloadMessageDialog.this.f41098e.b(downloadMessageDialog, customViewMessageWrap2);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.a
            public final void c(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2) {
                if (DownloadMessageDialog.this.f41098e != null) {
                    DownloadMessageDialog.this.f41098e.c(downloadMessageDialog, customViewMessageWrap2);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.a
            public final void a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2, Exception exc) {
                if (DownloadMessageDialog.this.f41098e != null) {
                    DownloadMessageDialog.this.f41098e.a(downloadMessageDialog, customViewMessageWrap2, exc);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.a
            public final void a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2, a.EnumC0769a enumC0769a) {
                if (DownloadMessageDialog.this.f41098e != null) {
                    if (enumC0769a == a.EnumC0769a.CLICK_EVENT_DOWNLOAD && DownloadMessageDialog.this.f41102i != null) {
                        DownloadMessageDialog.this.f41102i.cancel();
                    }
                    DownloadMessageDialog.this.f41098e.a(downloadMessageDialog, customViewMessageWrap2, enumC0769a);
                }
            }
        };
        setCancelable(z3);
        setOnCancelListener(onCancelListener);
        if (customViewMessageWrap == null) {
            this.f41097d = new CustomViewMessageWrap();
        } else {
            this.f41097d = customViewMessageWrap;
        }
        this.f41098e = aVar;
        if (customViewMessageWrap != null && TextUtils.isEmpty(customViewMessageWrap.getApplicationImage())) {
            this.f41094a = 0.6f;
        }
        try {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.f41104k.a(this, customViewMessageWrap);
            this.f41101h = new b(this, context, this.f41097d, this.f41104k);
            if (isScreenOrientationPortrait(getContext())) {
                this.f41096c = displayMetrics.widthPixels;
                this.f41095b = displayMetrics.heightPixels;
            } else {
                this.f41095b = displayMetrics.widthPixels;
                this.f41096c = displayMetrics.heightPixels;
            }
            View a4 = this.f41101h.a(this.f41096c, this.f41095b);
            if (a4 != null) {
                requestWindowFeature(1);
                setContentView(a4);
                this.f41104k.b(this, customViewMessageWrap);
                this.f41099f = true;
                if (isScreenOrientationPortrait(getContext())) {
                    this.f41096c = displayMetrics.widthPixels;
                    this.f41095b = displayMetrics.heightPixels;
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.width = -1;
                    attributes.height = (int) (this.f41095b * this.f41094a);
                    attributes.gravity = 80;
                    getWindow().setAttributes(attributes);
                    return;
                }
                this.f41096c = displayMetrics.widthPixels;
                this.f41095b = displayMetrics.heightPixels;
                WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
                double d4 = this.f41096c;
                Double.isNaN(d4);
                attributes2.width = (int) (d4 * 0.5d);
                attributes2.height = -1;
                attributes2.gravity = 17;
                getWindow().setAttributes(attributes2);
                return;
            }
            this.f41104k.a(this, customViewMessageWrap, new Exception("view is null"));
        } catch (Exception e4) {
            x.d("DownloadMessageDialog", e4.getMessage());
            this.f41104k.a(this, customViewMessageWrap, e4);
        }
    }
}
