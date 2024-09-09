package com.amap.api.col.p0003l;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BottomDialogBase.java */
/* renamed from: com.amap.api.col.3l.q3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
abstract class q3 extends Dialog {
    public q3(Context context) {
        super(context);
        b();
    }

    private void b() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            a();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }

    protected abstract void a();
}
