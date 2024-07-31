package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.mbridge.msdk.foundation.p470b.FeedbackManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class MBBaseActivity extends Activity {

    /* renamed from: a */
    private OrientationEventListener f29703a;

    /* renamed from: b */
    private Display f29704b;

    /* renamed from: c */
    private int f29705c = -1;

    /* renamed from: e */
    static /* synthetic */ void m23455e(MBBaseActivity mBBaseActivity) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(mBBaseActivity, 1) { // from class: com.mbridge.msdk.activity.MBBaseActivity.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                int rotation = MBBaseActivity.this.f29704b != null ? MBBaseActivity.this.f29704b.getRotation() : 0;
                if (rotation == 1 && MBBaseActivity.this.f29705c != 1) {
                    MBBaseActivity.this.f29705c = 1;
                    MBBaseActivity.this.getNotchParams();
                    SameLogTool.m21733d("MBBaseActivity", "Orientation Left");
                } else if (rotation == 3 && MBBaseActivity.this.f29705c != 2) {
                    MBBaseActivity.this.f29705c = 2;
                    MBBaseActivity.this.getNotchParams();
                    SameLogTool.m21733d("MBBaseActivity", "Orientation Right");
                } else if (rotation == 0 && MBBaseActivity.this.f29705c != 3) {
                    MBBaseActivity.this.f29705c = 3;
                    MBBaseActivity.this.getNotchParams();
                    SameLogTool.m21733d("MBBaseActivity", "Orientation Top");
                } else if (rotation != 2 || MBBaseActivity.this.f29705c == 4) {
                } else {
                    MBBaseActivity.this.f29705c = 4;
                    MBBaseActivity.this.getNotchParams();
                    SameLogTool.m21733d("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.f29703a = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            mBBaseActivity.f29703a.enable();
            return;
        }
        mBBaseActivity.f29703a.disable();
        mBBaseActivity.f29703a = null;
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.mbridge.msdk.activity.MBBaseActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                int i2;
                int i3;
                DisplayCutout displayCutout;
                int m23462a;
                try {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 23) {
                        WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i5 = -1;
                        int i6 = 0;
                        if (rootWindowInsets == null || i4 < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                        } else {
                            int safeInsetLeft = displayCutout.getSafeInsetLeft();
                            i = displayCutout.getSafeInsetRight();
                            i2 = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            SameLogTool.m21733d("MBBaseActivity", "NOTCH Left:" + safeInsetLeft + " Right:" + i + " Top:" + i2 + " Bottom:" + safeInsetBottom);
                            if (MBBaseActivity.this.f29704b == null) {
                                m23462a = MBBaseActivity.this.m23462a();
                            } else {
                                m23462a = MBBaseActivity.this.f29704b.getRotation();
                            }
                            if (MBBaseActivity.this.f29705c == -1) {
                                MBBaseActivity.this.f29705c = m23462a == 0 ? 3 : m23462a == 1 ? 1 : m23462a == 2 ? 4 : m23462a == 3 ? 2 : -1;
                                SameLogTool.m21733d("MBBaseActivity", MBBaseActivity.this.f29705c + "");
                            }
                            if (m23462a != 0) {
                                if (m23462a == 1) {
                                    i5 = 90;
                                } else if (m23462a == 2) {
                                    i5 = 180;
                                } else if (m23462a == 3) {
                                    i5 = BitmapUtils.ROTATE270;
                                }
                                i3 = safeInsetBottom;
                                i6 = safeInsetLeft;
                            } else {
                                i3 = safeInsetBottom;
                                i6 = safeInsetLeft;
                                i5 = 0;
                            }
                        }
                        MBBaseActivity.this.setTopControllerPadding(i5, i6, i, i2, i3);
                        if (MBBaseActivity.this.f29703a == null) {
                            MBBaseActivity.m23455e(MBBaseActivity.this);
                        }
                    }
                } catch (Exception e) {
                    SameLogTool.m21733d("MBBaseActivity", e.getMessage());
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
            m23459b();
            m23462a();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            SameLogTool.m21733d("MBBaseActivity", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f29703a;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f29703a = null;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (FeedbackManager.f30245c) {
            return;
        }
        getNotchParams();
        m23459b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m23459b();
    }

    public abstract void setTopControllerPadding(int i, int i2, int i3, int i4, int i5);

    /* renamed from: b */
    private void m23459b() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(67108864);
                getWindow().getDecorView().setSystemUiVisibility(4098);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(2);
            }
        } catch (Throwable th) {
            SameLogTool.m21733d("MBBaseActivity", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m23462a() {
        if (this.f29704b == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f29704b = getDisplay();
            } else {
                this.f29704b = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f29704b;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }
}
