package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.h;
import com.bytedance.adsdk.lottie.m;
import com.bytedance.adsdk.lottie.p;
import com.bytedance.adsdk.lottie.u;
import com.bytedance.sdk.component.ux.ev;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicLottieView extends LottieAnimationView {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Bitmap> f29526c;

    /* renamed from: f  reason: collision with root package name */
    private int f29527f;

    /* renamed from: r  reason: collision with root package name */
    private Map<String, String> f29528r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private String f29529w;
    private boolean xv;

    public DynamicLottieView(Context context) {
        super(context);
        this.f29526c = new HashMap();
    }

    public void f() {
        if (TextUtils.isEmpty(this.f29529w)) {
            return;
        }
        setProgress(0.0f);
        w(this.xv);
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.f29529w + ".json");
        setImageAssetDelegate(new p() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.p
            public Bitmap c(final h hVar) {
                final String c4 = hVar.c();
                c4.hashCode();
                char c5 = '\uffff';
                switch (c4.hashCode()) {
                    case -2126550274:
                        if (c4.equals("{appIcon}")) {
                            c5 = 0;
                            break;
                        }
                        break;
                    case -975050240:
                        if (c4.equals("{adImage}")) {
                            c5 = 1;
                            break;
                        }
                        break;
                    case -664048988:
                        if (c4.equals("{slot}")) {
                            c5 = 2;
                            break;
                        }
                        break;
                }
                switch (c5) {
                    case 0:
                        c4 = (String) DynamicLottieView.this.f29528r.get(RewardPlus.ICON);
                        break;
                    case 1:
                    case 2:
                        c4 = (String) DynamicLottieView.this.f29528r.get("imageUrl");
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.f29526c.get(c4);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.c.c.c.c().ux().c(c4).xv(2).c(new ev() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.ux.ev
                    @ATSMethod(1)
                    public Bitmap c(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, hVar.a(), hVar.e(), false);
                        DynamicLottieView.this.f29526c.put(c4, createScaledBitmap);
                        return createScaledBitmap;
                    }
                }).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(2)
                    public void c(int i4, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(1)
                    public void c(k<Bitmap> kVar) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(kVar.xv(), hVar.a(), hVar.e(), false);
                        DynamicLottieView.this.f29526c.put(c4, createScaledBitmap);
                        DynamicLottieView.this.c(hVar.f(), createScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.f29526c.get(c4);
            }
        });
        m mVar = new m(this);
        String str = this.f29528r.get("app_name");
        String str2 = this.f29528r.get("description");
        String str3 = this.f29528r.get("title");
        if (this.sr > 0 && str.length() > this.sr) {
            str = str.substring(0, this.sr - 1) + "...";
        } else if (this.sr <= 0) {
            str = "";
        }
        if (this.ux > 0 && str3.length() > this.ux) {
            str3 = str3.substring(0, this.ux - 1) + "...";
        } else if (this.sr <= 0) {
            str3 = "";
        }
        if (this.f29527f > 0 && str2.length() > this.f29527f) {
            str2 = str2.substring(0, this.f29527f - 1) + "...";
        } else if (this.sr <= 0) {
            str2 = "";
        }
        mVar.d("{appName}", str);
        mVar.d("{adTitle}", str3);
        mVar.d("{adDesc}", str2);
        setTextDelegate(mVar);
        setFontAssetDelegate(new u() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
            @Override // com.bytedance.adsdk.lottie.u
            public Typeface c(String str4) {
                return Typeface.MONOSPACE;
            }

            @Override // com.bytedance.adsdk.lottie.u
            public String w(String str4) {
                return null;
            }
        });
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xv();
    }

    public void setAnimationsLoop(boolean z3) {
        this.xv = z3;
    }

    public void setData(Map<String, String> map) {
        this.f29528r = map;
    }

    public void setImageLottieTosPath(String str) {
        this.f29529w = str;
    }

    public void setLottieAdDescMaxLength(int i4) {
        this.f29527f = i4;
    }

    public void setLottieAdTitleMaxLength(int i4) {
        this.ux = i4;
    }

    public void setLottieAppNameMaxLength(int i4) {
        this.sr = i4;
    }
}
