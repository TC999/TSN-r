package com.tencent.open;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.open.log.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static void a(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(1024, 1024);
        int i4 = Build.VERSION.SDK_INT;
        window.getDecorView().setSystemUiVisibility(1280);
        if (i4 >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            if (i4 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        window.addFlags(TTAdConstant.KEY_CLICK_AREA);
    }

    public static void a(final Dialog dialog, Handler handler) {
        if (dialog == null || dialog.getContext() == null || handler == null) {
            return;
        }
        Toast.makeText(dialog.getContext(), "\u7f51\u9875\u52a0\u8f7d\u5f02\u5e38\uff0c\u8bf7\u81ea\u884c\u4e0b\u8f7d\u5e76\u5b89\u88c5QQ\u540e\uff0c\u518d\u91cd\u65b0\u767b\u5f55\u3002", 0).show();
        handler.postDelayed(new Runnable() { // from class: com.tencent.open.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dialog.dismiss();
                } catch (Exception e4) {
                    SLog.e("openSDK_LOG.DialogUtils", "dismiss dialog exception", e4);
                }
            }
        }, 100L);
    }
}
