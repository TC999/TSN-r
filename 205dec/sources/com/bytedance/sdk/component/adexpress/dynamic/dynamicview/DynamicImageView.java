package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.sr.gd;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.component.ux.p;
import com.bytedance.sdk.component.ux.ys;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {

    /* renamed from: c  reason: collision with root package name */
    private String f29166c;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        if (!TextUtils.isEmpty(this.f29132a.ta()) && evVar.fz()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.f29132a.eu());
            dynamicLottieView.setImageLottieTosPath(this.f29132a.ta());
            dynamicLottieView.setLottieAppNameMaxLength(this.f29132a.bs());
            dynamicLottieView.setLottieAdTitleMaxLength(this.f29132a.g());
            dynamicLottieView.setLottieAdDescMaxLength(this.f29132a.be());
            dynamicLottieView.setData(evVar.u());
            this.ys = dynamicLottieView;
        } else if (this.f29132a.ys() > 0.0f) {
            TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
            this.ys = tTRoundRectImageView;
            tTRoundRectImageView.setXRound((int) f.c(context, this.f29132a.ys()));
            ((TTRoundRectImageView) this.ys).setYRound((int) f.c(context, this.f29132a.ys()));
        } else if (!r() && "arrowButton".equals(evVar.p().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.f29132a);
            this.ys = animationImageView;
        } else if (r.w(this.f29132a.k())) {
            this.ys = new GifView(context);
        } else {
            this.ys = new ImageView(context);
        }
        this.f29166c = getImageKey();
        this.ys.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(evVar.p().getType())) {
            if (this.f29132a.w() <= 0 && this.f29132a.c() <= 0) {
                int max = Math.max(this.f29138r, this.ev);
                this.f29138r = max;
                this.ev = Math.max(max, this.ev);
            } else {
                int min = Math.min(this.f29138r, this.ev);
                this.f29138r = min;
                this.ev = Math.min(min, this.ev);
                this.gd = (int) (this.gd + f.c(context, this.f29132a.w() + (this.f29132a.c() / 2) + 0.5f));
            }
            this.f29132a.c(this.f29138r / 2);
        }
        addView(this.ys, new FrameLayout.LayoutParams(this.f29138r, this.ev));
    }

    private void c(p pVar) {
        pVar.xv(3).c(new fp() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.3
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i4, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k kVar) {
                Object xv = kVar.xv();
                if (xv instanceof byte[]) {
                    DynamicImageView dynamicImageView = DynamicImageView.this;
                    View view = dynamicImageView.ys;
                    if (view instanceof ImageView) {
                        com.bytedance.sdk.component.adexpress.sr.sr.c((ImageView) view, (byte[]) xv, dynamicImageView.f29138r, dynamicImageView.ev);
                    }
                }
            }
        });
    }

    private boolean gd() {
        String a4 = this.f29132a.a();
        if (this.f29132a.u()) {
            return true;
        }
        if (TextUtils.isEmpty(a4)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(a4);
            return Math.abs((((float) this.f29138r) / (((float) this.ev) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private String getImageKey() {
        Map<String, String> k4 = this.f29140t.getRenderRequest().k();
        if (k4 == null || k4.size() <= 0) {
            return null;
        }
        return k4.get(this.f29132a.k());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (!TextUtils.isEmpty(this.f29132a.ta())) {
            ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        } else if ("arrowButton".equals(this.bk.p().getType())) {
            ((ImageView) this.ys).setImageResource(i.sr(this.f29136k, "tt_white_righterbackicon_titlebar"));
            if (Build.VERSION.SDK_INT >= 19 && ((ImageView) this.ys).getDrawable() != null) {
                ((ImageView) this.ys).getDrawable().setAutoMirrored(true);
            }
            this.ys.setPadding(0, 0, 0, 0);
            ((ImageView) this.ys).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        } else {
            this.ys.setBackgroundColor(this.f29132a.z());
            String w3 = this.bk.p().w();
            if ("user".equals(w3)) {
                ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ((ImageView) this.ys).setColorFilter(this.f29132a.r());
                ((ImageView) this.ys).setImageDrawable(i.xv(getContext(), "tt_user"));
                int i4 = this.f29138r;
                ((ImageView) this.ys).setPadding(i4 / 10, this.ev / 5, i4 / 10, 0);
            } else if (w3 != null && w3.startsWith("@")) {
                try {
                    ((ImageView) this.ys).setImageResource(Integer.parseInt(w3.substring(1)));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            ys ux = com.bytedance.sdk.component.adexpress.c.c.c.c().ux();
            String k4 = this.f29132a.k();
            if (!TextUtils.isEmpty(k4) && !k4.startsWith("http:") && !k4.startsWith("https:")) {
                String str = null;
                DynamicRootView dynamicRootView = this.f29140t;
                if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                    str = this.f29140t.getRenderRequest().q();
                }
                k4 = gd.w(k4, str);
            }
            p w4 = ux.c(k4).w(this.f29166c);
            String t3 = this.f29140t.getRenderRequest().t();
            if (!TextUtils.isEmpty(t3)) {
                w4.xv(t3);
            }
            if (gd()) {
                ((ImageView) this.ys).setScaleType(ImageView.ScaleType.FIT_CENTER);
                w4.c(Bitmap.Config.ARGB_4444).xv(2).c(new com.bytedance.sdk.component.ux.ev() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.2
                    @Override // com.bytedance.sdk.component.ux.ev
                    @ATSMethod(1)
                    public Bitmap c(Bitmap bitmap) {
                        return com.bytedance.sdk.component.adexpress.sr.c.c(DynamicImageView.this.f29136k, bitmap, 25);
                    }
                }).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(2)
                    public void c(int i5, String str2, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(1)
                    public void c(k<Bitmap> kVar) {
                        Bitmap xv = kVar.xv();
                        if (xv == null || kVar.sr() == null) {
                            return;
                        }
                        DynamicImageView.this.ys.setBackground(new BitmapDrawable(DynamicImageView.this.getResources(), xv));
                    }
                });
            } else {
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    w4.c((ImageView) this.ys);
                }
                ((ImageView) this.ys).setScaleType(ImageView.ScaleType.FIT_XY);
            }
            if ((this.ys instanceof ImageView) && "cover".equals(getImageObjectFit())) {
                ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            if (!com.bytedance.sdk.component.adexpress.sr.c()) {
                c(w4);
            }
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((ImageView) this.ys).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).start();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = ((ImageView) this.ys).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }
}
