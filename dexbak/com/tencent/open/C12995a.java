package com.tencent.open;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12995a {
    /* renamed from: a */
    public static void m15229a(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(1024, 1024);
        int i = Build.VERSION.SDK_INT;
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
        if (i >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        window.addFlags(67108864);
    }

    /* renamed from: a */
    public static void m15230a(final Dialog dialog, Handler handler) {
        if (dialog == null || dialog.getContext() == null || handler == null) {
            return;
        }
        Toast.makeText(dialog.getContext(), "网页加载异常，请自行下载并安装QQ后，再重新登录。", 0).show();
        handler.postDelayed(new Runnable() { // from class: com.tencent.open.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                    SLog.m15128e("openSDK_LOG.DialogUtils", "dismiss dialog exception", e);
                }
            }
        }, 100L);
    }
}
