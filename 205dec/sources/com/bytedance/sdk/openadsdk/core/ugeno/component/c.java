package com.bytedance.sdk.openadsdk.core.ugeno.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.adsdk.ugeno.component.image.RoundImageView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.r.w;
import l0.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends b<RoundImageView> {

    /* renamed from: c  reason: collision with root package name */
    protected String f34924c;
    protected int mt;

    public c(Context context) {
        super(context);
        this.mt = 25;
    }

    private void ev() {
        if (TextUtils.isEmpty(this.f34924c)) {
            return;
        }
        ((RoundImageView) this.ux).setImageDrawable(null);
        if (this.f34924c.startsWith("local://")) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.f26040w.getResources(), f.e(this.f26040w, this.f34924c.replace("local://", "")));
            if (decodeResource != null) {
                c(decodeResource);
                return;
            }
            return;
        }
        w.c(this.f34924c).xv(2).c(new fp() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.c.1
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k kVar) {
                Object xv = kVar.xv();
                if (xv != null && (xv instanceof Bitmap)) {
                    c.this.c((Bitmap) xv);
                } else {
                    a.w("UGBlurWidget", "failed get img");
                }
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i4, String str, Throwable th) {
                a.w("UGBlurWidget", str, th);
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ev();
        ((RoundImageView) this.ux).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.ux).setBorderColor(this.wx);
        ((RoundImageView) this.ux).setCornerRadius(this.f26042y);
        ((RoundImageView) this.ux).setBorderWidth(this.yu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bitmap bitmap) {
        Bitmap c4 = com.bytedance.sdk.component.adexpress.sr.c.c(this.f26040w, bitmap, 25);
        if (c4 != null) {
            ((RoundImageView) this.ux).setImageBitmap(c4);
        } else {
            a.w("UGBlurWidget", "blur failed!");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: c */
    public RoundImageView xv() {
        RoundImageView roundImageView = new RoundImageView(this.f26040w);
        roundImageView.d(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.c(str, str2);
        str.hashCode();
        if (!str.equals("blurRate")) {
            if (str.equals("src")) {
                this.f34924c = str2;
                return;
            }
            return;
        }
        try {
            this.mt = Integer.parseInt(str2);
        } catch (Exception e4) {
            a.xv("UGBlurWidget", e4);
        }
    }
}
