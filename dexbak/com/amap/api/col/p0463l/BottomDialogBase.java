package com.amap.api.col.p0463l;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/* renamed from: com.amap.api.col.3l.q3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
abstract class BottomDialogBase extends Dialog {
    public BottomDialogBase(Context context) {
        super(context);
        m54143b();
    }

    /* renamed from: b */
    private void m54143b() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            mo54144a();
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

    /* renamed from: a */
    protected abstract void mo54144a();
}
