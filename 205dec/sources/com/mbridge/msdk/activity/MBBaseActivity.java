package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.x;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class MBBaseActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private OrientationEventListener f38670a;

    /* renamed from: b  reason: collision with root package name */
    private Display f38671b;

    /* renamed from: c  reason: collision with root package name */
    private int f38672c = -1;

    static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(mBBaseActivity, 1) { // from class: com.mbridge.msdk.activity.MBBaseActivity.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i4) {
                int rotation = MBBaseActivity.this.f38671b != null ? MBBaseActivity.this.f38671b.getRotation() : 0;
                if (rotation == 1 && MBBaseActivity.this.f38672c != 1) {
                    MBBaseActivity.this.f38672c = 1;
                    MBBaseActivity.this.getNotchParams();
                    x.d("MBBaseActivity", "Orientation Left");
                } else if (rotation == 3 && MBBaseActivity.this.f38672c != 2) {
                    MBBaseActivity.this.f38672c = 2;
                    MBBaseActivity.this.getNotchParams();
                    x.d("MBBaseActivity", "Orientation Right");
                } else if (rotation == 0 && MBBaseActivity.this.f38672c != 3) {
                    MBBaseActivity.this.f38672c = 3;
                    MBBaseActivity.this.getNotchParams();
                    x.d("MBBaseActivity", "Orientation Top");
                } else if (rotation != 2 || MBBaseActivity.this.f38672c == 4) {
                } else {
                    MBBaseActivity.this.f38672c = 4;
                    MBBaseActivity.this.getNotchParams();
                    x.d("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.f38670a = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            mBBaseActivity.f38670a.enable();
            return;
        }
        mBBaseActivity.f38670a.disable();
        mBBaseActivity.f38670a = null;
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.mbridge.msdk.activity.MBBaseActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                int i4;
                int i5;
                int i6;
                DisplayCutout displayCutout;
                int a4;
                try {
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 23) {
                        WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i8 = -1;
                        int i9 = 0;
                        if (rootWindowInsets == null || i7 < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                            i4 = 0;
                            i5 = 0;
                            i6 = 0;
                        } else {
                            int safeInsetLeft = displayCutout.getSafeInsetLeft();
                            i4 = displayCutout.getSafeInsetRight();
                            i5 = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            x.d("MBBaseActivity", "NOTCH Left:" + safeInsetLeft + " Right:" + i4 + " Top:" + i5 + " Bottom:" + safeInsetBottom);
                            if (MBBaseActivity.this.f38671b == null) {
                                a4 = MBBaseActivity.this.a();
                            } else {
                                a4 = MBBaseActivity.this.f38671b.getRotation();
                            }
                            if (MBBaseActivity.this.f38672c == -1) {
                                MBBaseActivity.this.f38672c = a4 == 0 ? 3 : a4 == 1 ? 1 : a4 == 2 ? 4 : a4 == 3 ? 2 : -1;
                                x.d("MBBaseActivity", MBBaseActivity.this.f38672c + "");
                            }
                            if (a4 != 0) {
                                if (a4 == 1) {
                                    i8 = 90;
                                } else if (a4 == 2) {
                                    i8 = 180;
                                } else if (a4 == 3) {
                                    i8 = 270;
                                }
                                i6 = safeInsetBottom;
                                i9 = safeInsetLeft;
                            } else {
                                i6 = safeInsetBottom;
                                i9 = safeInsetLeft;
                                i8 = 0;
                            }
                        }
                        MBBaseActivity.this.setTopControllerPadding(i8, i9, i4, i5, i6);
                        if (MBBaseActivity.this.f38670a == null) {
                            MBBaseActivity.e(MBBaseActivity.this);
                        }
                    }
                } catch (Exception e4) {
                    x.d("MBBaseActivity", e4.getMessage());
                }
            }
        }, 500L);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            b();
            a();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e4) {
            x.d("MBBaseActivity", e4.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f38670a;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f38670a = null;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (b.f39072c) {
            return;
        }
        getNotchParams();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        b();
    }

    public abstract void setTopControllerPadding(int i4, int i5, int i6, int i7, int i8);

    private void b() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
                getWindow().getDecorView().setSystemUiVisibility(4098);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(2);
            }
        } catch (Throwable th) {
            x.d("MBBaseActivity", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        if (this.f38671b == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f38671b = getDisplay();
            } else {
                this.f38671b = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f38671b;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }
}
