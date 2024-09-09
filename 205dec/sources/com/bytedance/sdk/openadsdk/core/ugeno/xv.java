package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import j0.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements a {
    public void c(Context context, String str, ImageView imageView) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.bytedance.sdk.openadsdk.r.w.c(str).xv(3).c(Bitmap.Config.RGB_565).c(new fp() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.1
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str2, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k kVar) {
                    try {
                        Object xv = kVar.xv();
                        if (xv instanceof byte[]) {
                            if (kVar.ev()) {
                                gifView.c((byte[]) xv, false);
                                gifView.setRepeatConfig(true);
                                gifView.w();
                            } else {
                                gifView.setImageDrawable(com.bytedance.sdk.openadsdk.core.eq.fp.c((byte[]) xv, 0));
                            }
                        }
                    } catch (Throwable th) {
                        c(1002, "", th);
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.r.w.c(str).c(imageView);
    }

    public void c(String str, final a.InterfaceC1087a interfaceC1087a) {
        com.bytedance.sdk.openadsdk.r.w.c(str).xv(2).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.2
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k<Bitmap> kVar) {
                if (kVar == null) {
                    interfaceC1087a.c(null);
                    return;
                }
                a.InterfaceC1087a interfaceC1087a2 = interfaceC1087a;
                if (interfaceC1087a2 != null) {
                    interfaceC1087a2.c(kVar.xv());
                } else {
                    interfaceC1087a2.c(null);
                }
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i4, String str2, Throwable th) {
                a.InterfaceC1087a interfaceC1087a2 = interfaceC1087a;
                if (interfaceC1087a2 != null) {
                    interfaceC1087a2.c(null);
                }
            }
        });
    }
}
