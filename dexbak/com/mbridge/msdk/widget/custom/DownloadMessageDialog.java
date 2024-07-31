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
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.widget.custom.CustomViewRenderListener;
import com.mbridge.msdk.widget.custom.baseview.MBButton;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadMessageDialog extends Dialog {

    /* renamed from: a */
    private float f32383a;

    /* renamed from: b */
    private int f32384b;

    /* renamed from: c */
    private int f32385c;

    /* renamed from: d */
    private CustomViewMessageWrap f32386d;

    /* renamed from: e */
    private CustomViewRenderListener f32387e;

    /* renamed from: f */
    private boolean f32388f;

    /* renamed from: g */
    private OrientationEventListener f32389g;

    /* renamed from: h */
    private MBridgeCustomRender f32390h;

    /* renamed from: i */
    private AnimatorSet f32391i;

    /* renamed from: j */
    private InterfaceC11738a f32392j;

    /* renamed from: k */
    private CustomViewRenderListener f32393k;

    /* renamed from: com.mbridge.msdk.widget.custom.DownloadMessageDialog$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC11738a {
        /* renamed from: a */
        void mo20569a(int i);
    }

    public DownloadMessageDialog(Context context, boolean z, CustomViewMessageWrap customViewMessageWrap, CustomViewRenderListener customViewRenderListener) {
        this(context, z, null, customViewMessageWrap, customViewRenderListener);
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        try {
            AnimatorSet animatorSet = this.f32391i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            OrientationEventListener orientationEventListener = this.f32389g;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f32389g.disable();
            }
        } catch (Exception e) {
            SameLogTool.m21733d("DownloadMessageDialog", e.getMessage());
        }
        super.cancel();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View decorView;
        try {
            AnimatorSet animatorSet = this.f32391i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            OrientationEventListener orientationEventListener = this.f32389g;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f32389g.disable();
            }
        } catch (Exception e) {
            SameLogTool.m21733d("DownloadMessageDialog", e.getMessage());
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
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                window.addFlags(67108864);
                window.getDecorView().setSystemUiVisibility(4098);
            } else {
                window.getDecorView().setSystemUiVisibility(2);
            }
            if (i >= 28) {
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
            AnimatorSet animatorSet = this.f32391i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            OrientationEventListener orientationEventListener = this.f32389g;
            if (orientationEventListener == null || !orientationEventListener.canDetectOrientation()) {
                return;
            }
            this.f32389g.disable();
        } catch (Exception e) {
            SameLogTool.m21733d("DownloadMessageDialog", e.getMessage());
        }
    }

    public void registerOrientationListener(InterfaceC11738a interfaceC11738a) {
        this.f32392j = interfaceC11738a;
    }

    public void setRenderListener(CustomViewRenderListener customViewRenderListener) {
        this.f32387e = customViewRenderListener;
    }

    @Override // android.app.Dialog
    public void show() {
        MBButton m20582a;
        try {
            if (this.f32388f) {
                Window window = getWindow();
                if (window == null) {
                    this.f32393k.mo20612a(this, this.f32386d, new Exception("window is null"));
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
                    this.f32393k.mo20610c(this, this.f32386d);
                    if (Build.VERSION.SDK_INT <= 20) {
                        try {
                            MBButton mBButton = (MBButton) this.f32386d.getView("download");
                            if (mBButton != null) {
                                mBButton.setPadding(0, 0, 0, 0);
                            }
                        } catch (Exception e) {
                            SameLogTool.m21733d("dialog", e.getMessage());
                        }
                    }
                    if (this.f32389g == null) {
                        OrientationEventListener orientationEventListener = new OrientationEventListener(getContext(), 1) { // from class: com.mbridge.msdk.widget.custom.DownloadMessageDialog.2
                            @Override // android.view.OrientationEventListener
                            public final void onOrientationChanged(int i) {
                                try {
                                    WindowManager.LayoutParams attributes = DownloadMessageDialog.this.getWindow().getAttributes();
                                    DisplayMetrics displayMetrics = DownloadMessageDialog.this.getContext().getResources().getDisplayMetrics();
                                    if (DownloadMessageDialog.this.getContext().getResources().getConfiguration().orientation == 1) {
                                        if (DownloadMessageDialog.this.f32392j != null) {
                                            DownloadMessageDialog.this.f32392j.mo20569a(1);
                                        }
                                        attributes.width = -1;
                                        attributes.height = (int) (displayMetrics.heightPixels * DownloadMessageDialog.this.f32383a);
                                        attributes.gravity = 80;
                                    } else {
                                        if (DownloadMessageDialog.this.f32392j != null) {
                                            DownloadMessageDialog.this.f32392j.mo20569a(2);
                                        }
                                        double d = displayMetrics.widthPixels;
                                        Double.isNaN(d);
                                        attributes.width = (int) (d * 0.5d);
                                        attributes.height = -1;
                                        attributes.gravity = 17;
                                    }
                                    DownloadMessageDialog.this.getWindow().setAttributes(attributes);
                                } catch (Throwable th) {
                                    SameLogTool.m21733d("DownloadMessageDialog", th.getMessage());
                                }
                            }
                        };
                        this.f32389g = orientationEventListener;
                        if (orientationEventListener.canDetectOrientation()) {
                            this.f32389g.enable();
                        } else {
                            this.f32389g.disable();
                            this.f32389g = null;
                        }
                    }
                    OrientationEventListener orientationEventListener2 = this.f32389g;
                    if (orientationEventListener2 != null && orientationEventListener2.canDetectOrientation()) {
                        CampaignEx campaignEx = this.f32386d.getCampaignEx();
                        if (campaignEx == null || !(campaignEx.getAdType() == 94 || campaignEx.getAdType() == 287)) {
                            if (campaignEx != null) {
                                this.f32389g.enable();
                            }
                        } else if (campaignEx.getRewardTemplateMode() != null && campaignEx.getRewardTemplateMode().m22636c() == 0) {
                            this.f32389g.enable();
                        }
                    }
                    MBridgeCustomRender mBridgeCustomRender = this.f32390h;
                    if (mBridgeCustomRender == null || mBridgeCustomRender.m20582a() == null || (m20582a = this.f32390h.m20582a()) == null || !String.valueOf(m20582a.getContentDescription()).contains("anim")) {
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m20582a, "scaleX", 1.2f, 0.8f);
                    ofFloat.setRepeatCount(-1);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(m20582a, "scaleY", 1.2f, 0.8f);
                    ofFloat2.setRepeatCount(-1);
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f32391i = animatorSet;
                    animatorSet.play(ofFloat).with(ofFloat2);
                    this.f32391i.setDuration(2000L);
                    this.f32391i.start();
                } catch (Exception e2) {
                    this.f32393k.mo20612a(this, this.f32386d, e2);
                }
            }
        } catch (Exception e3) {
            SameLogTool.m21733d("DownloadMessageDialog", e3.getMessage());
        }
    }

    public DownloadMessageDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener, CustomViewMessageWrap customViewMessageWrap, CustomViewRenderListener customViewRenderListener) {
        super(context, ResourceUtil.m21814a(context, "mbridge_dialog_fullscreen_bottom", "style"));
        this.f32383a = 0.8f;
        this.f32388f = false;
        this.f32389g = null;
        this.f32393k = new CustomViewRenderListener() { // from class: com.mbridge.msdk.widget.custom.DownloadMessageDialog.1
            @Override // com.mbridge.msdk.widget.custom.CustomViewRenderListener
            /* renamed from: a */
            public final void mo20614a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2) {
                if (DownloadMessageDialog.this.f32387e != null) {
                    DownloadMessageDialog.this.f32387e.mo20614a(downloadMessageDialog, customViewMessageWrap2);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.CustomViewRenderListener
            /* renamed from: b */
            public final void mo20611b(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2) {
                if (DownloadMessageDialog.this.f32387e != null) {
                    DownloadMessageDialog.this.f32387e.mo20611b(downloadMessageDialog, customViewMessageWrap2);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.CustomViewRenderListener
            /* renamed from: c */
            public final void mo20610c(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2) {
                if (DownloadMessageDialog.this.f32387e != null) {
                    DownloadMessageDialog.this.f32387e.mo20610c(downloadMessageDialog, customViewMessageWrap2);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.CustomViewRenderListener
            /* renamed from: a */
            public final void mo20612a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2, Exception exc) {
                if (DownloadMessageDialog.this.f32387e != null) {
                    DownloadMessageDialog.this.f32387e.mo20612a(downloadMessageDialog, customViewMessageWrap2, exc);
                }
            }

            @Override // com.mbridge.msdk.widget.custom.CustomViewRenderListener
            /* renamed from: a */
            public final void mo20613a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap2, CustomViewRenderListener.EnumC11739a enumC11739a) {
                if (DownloadMessageDialog.this.f32387e != null) {
                    if (enumC11739a == CustomViewRenderListener.EnumC11739a.CLICK_EVENT_DOWNLOAD && DownloadMessageDialog.this.f32391i != null) {
                        DownloadMessageDialog.this.f32391i.cancel();
                    }
                    DownloadMessageDialog.this.f32387e.mo20613a(downloadMessageDialog, customViewMessageWrap2, enumC11739a);
                }
            }
        };
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        if (customViewMessageWrap == null) {
            this.f32386d = new CustomViewMessageWrap();
        } else {
            this.f32386d = customViewMessageWrap;
        }
        this.f32387e = customViewRenderListener;
        if (customViewMessageWrap != null && TextUtils.isEmpty(customViewMessageWrap.getApplicationImage())) {
            this.f32383a = 0.6f;
        }
        try {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.f32393k.mo20614a(this, customViewMessageWrap);
            this.f32390h = new MBridgeCustomRender(this, context, this.f32386d, this.f32393k);
            if (isScreenOrientationPortrait(getContext())) {
                this.f32385c = displayMetrics.widthPixels;
                this.f32384b = displayMetrics.heightPixels;
            } else {
                this.f32384b = displayMetrics.widthPixels;
                this.f32385c = displayMetrics.heightPixels;
            }
            View m20581a = this.f32390h.m20581a(this.f32385c, this.f32384b);
            if (m20581a != null) {
                requestWindowFeature(1);
                setContentView(m20581a);
                this.f32393k.mo20611b(this, customViewMessageWrap);
                this.f32388f = true;
                if (isScreenOrientationPortrait(getContext())) {
                    this.f32385c = displayMetrics.widthPixels;
                    this.f32384b = displayMetrics.heightPixels;
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.width = -1;
                    attributes.height = (int) (this.f32384b * this.f32383a);
                    attributes.gravity = 80;
                    getWindow().setAttributes(attributes);
                    return;
                }
                this.f32385c = displayMetrics.widthPixels;
                this.f32384b = displayMetrics.heightPixels;
                WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
                double d = this.f32385c;
                Double.isNaN(d);
                attributes2.width = (int) (d * 0.5d);
                attributes2.height = -1;
                attributes2.gravity = 17;
                getWindow().setAttributes(attributes2);
                return;
            }
            this.f32393k.mo20612a(this, customViewMessageWrap, new Exception("view is null"));
        } catch (Exception e) {
            SameLogTool.m21733d("DownloadMessageDialog", e.getMessage());
            this.f32393k.mo20612a(this, customViewMessageWrap, e);
        }
    }
}
