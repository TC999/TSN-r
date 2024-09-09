package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.dynamic.sr.gd;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.dynamic.xv.p;
import com.bytedance.sdk.component.adexpress.dynamic.xv.r;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {

    /* renamed from: u  reason: collision with root package name */
    private static String f29145u = "";

    /* renamed from: c  reason: collision with root package name */
    private Runnable f29146c;
    protected InteractViewContainer fz;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f29147i;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f29148q;

    /* renamed from: w  reason: collision with root package name */
    private Runnable f29149w;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29147i = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = evVar.p().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.ev - ((int) f.c(context, this.f29132a.w() + this.f29132a.c())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.ev - ((int) f.c(context, this.f29132a.w() + this.f29132a.c())));
        }
    }

    private void gd() {
        if (this.f29147i) {
            int oo = this.f29132a.oo();
            int au = this.f29132a.au();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.10
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.f29140t;
                    if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                        bk renderRequest = DynamicBaseWidgetImp.this.f29140t.getRenderRequest();
                        p pVar = new p();
                        pVar.c(renderRequest.ys());
                        pVar.w(renderRequest.fp());
                        pVar.xv(renderRequest.ia());
                        pVar.c(renderRequest.s());
                        pVar.sr(renderRequest.fz());
                        pVar.ux(renderRequest.u());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.fz = new InteractViewContainer(dynamicBaseWidgetImp2.f29136k, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.f29132a, pVar, renderRequest);
                    } else {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.fz = new InteractViewContainer(dynamicBaseWidgetImp4.f29136k, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.f29132a);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.w(dynamicBaseWidgetImp5.fz);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.fz.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.c((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.fz, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.fz.xv();
                }
            };
            this.f29146c = runnable;
            postDelayed(runnable, oo * 1000);
            if (this.f29132a.bj() || au >= Integer.MAX_VALUE || oo >= au) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    if (dynamicBaseWidgetImp.fz != null) {
                        dynamicBaseWidgetImp.f29147i = false;
                        DynamicBaseWidgetImp.this.fz.sr();
                        DynamicBaseWidgetImp.this.fz.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp2.removeView(dynamicBaseWidgetImp2.fz);
                    }
                }
            };
            this.f29149w = runnable2;
            postDelayed(runnable2, au * 1000);
        }
    }

    private static String getBuildModel() {
        try {
            f29145u = j.c();
        } catch (Throwable unused) {
            f29145u = Build.MODEL;
        }
        if (TextUtils.isEmpty(f29145u)) {
            f29145u = Build.MODEL;
        }
        return f29145u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable w(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                if (jSONArray.getString(i4).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i4));
                } else if (jSONArray.getString(i4).endsWith("deg")) {
                    str2 = jSONArray.getString(i4);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                iArr[i5] = r.c(((String) arrayList.get(i5)).substring(0, 7));
            }
            GradientDrawable c4 = c(c(str2), iArr);
            c4.setShape(0);
            c4.setCornerRadius(f.c(this.f29136k, this.f29132a.ys()));
            return c4;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject optJSONObject;
        final View view = this.ys;
        if (view == null) {
            view = this;
        }
        setContentDescription(this.bk.c(this.f29132a.ck()));
        String xg = this.f29132a.xg();
        String str = null;
        String c4 = (TextUtils.isEmpty(xg) || (dynamicRootView = this.f29140t) == null || dynamicRootView.getRenderRequest() == null || this.f29140t.getRenderRequest().xv() == null || (optJSONObject = this.f29140t.getRenderRequest().xv().optJSONObject("creative")) == null) ? null : c(optJSONObject.opt(xg));
        if (TextUtils.isEmpty(c4)) {
            c4 = this.f29132a.i();
        }
        if (this.f29132a.u()) {
            final int fz = this.f29132a.fz();
            com.bytedance.sdk.component.adexpress.c.c.c.c().ux().c(this.f29132a.f29376w).xv(2).c(new com.bytedance.sdk.component.ux.ev() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
                @Override // com.bytedance.sdk.component.ux.ev
                @ATSMethod(1)
                public Bitmap c(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.sr.c.c(DynamicBaseWidgetImp.this.f29136k, bitmap, fz);
                }
            }).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str2, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k<Bitmap> kVar) {
                    Bitmap xv = kVar.xv();
                    if (xv == null || kVar.sr() == null) {
                        return;
                    }
                    view.setBackground(DynamicBaseWidgetImp.this.c(xv));
                }
            });
        } else if (!TextUtils.isEmpty(c4)) {
            if (!c4.startsWith("http:") && !c4.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.f29140t;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    str = this.f29140t.getRenderRequest().q();
                }
                c4 = gd.w(c4, str);
            }
            com.bytedance.sdk.component.ux.p xv = com.bytedance.sdk.component.adexpress.c.c.c.c().ux().c(c4).xv(2);
            c(xv);
            if (!com.bytedance.sdk.component.adexpress.sr.c()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.bk.p().getType(), "vessel")) {
                    if (com.bytedance.sdk.component.adexpress.sr.r.w(c4)) {
                        this.f29148q = new GifView(this.f29136k);
                    } else {
                        this.f29148q = new ImageView(this.f29136k);
                    }
                    ((FrameLayout) view).addView(this.f29148q, new FrameLayout.LayoutParams(-1, -1));
                    xv.xv(3).c(new fp() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                        @Override // com.bytedance.sdk.component.ux.fp
                        @ATSMethod(2)
                        public void c(int i4, String str2, Throwable th) {
                        }

                        @Override // com.bytedance.sdk.component.ux.fp
                        @ATSMethod(1)
                        public void c(k kVar) {
                            Object xv2 = kVar.xv();
                            if (xv2 instanceof byte[]) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                                com.bytedance.sdk.component.adexpress.sr.sr.c(DynamicBaseWidgetImp.this.f29148q, (byte[]) xv2, dynamicBaseWidgetImp.f29138r, dynamicBaseWidgetImp.ev);
                            }
                        }
                    });
                } else {
                    c(xv, view);
                }
            } else {
                xv.c(new fp<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(2)
                    public void c(int i4, String str2, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ux.fp
                    @ATSMethod(1)
                    public void c(k<Bitmap> kVar) {
                        if (com.bytedance.sdk.component.adexpress.sr.c()) {
                            view.setBackground(new BitmapDrawable(kVar.xv()));
                            ev evVar = DynamicBaseWidgetImp.this.bk;
                            if (evVar == null || evVar.p() == null || 6 != DynamicBaseWidgetImp.this.bk.p().c() || Build.VERSION.SDK_INT < 19 || view.getBackground() == null) {
                                return;
                            }
                            view.getBackground().setAutoMirrored(true);
                            return;
                        }
                        DynamicRootView dynamicRootView3 = DynamicBaseWidgetImp.this.f29140t;
                        if (dynamicRootView3 == null) {
                            return;
                        }
                        if (!"open_ad".equals(dynamicRootView3.getRenderRequest().sr()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.f29140t.getRenderRequest().sr())) {
                            view.setBackground(new BitmapDrawable(kVar.xv()));
                        } else {
                            view.setBackground(new BitmapDrawable(kVar.xv()));
                        }
                    }
                });
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.f29132a.ba() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.f29132a.xk() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable w3 = dynamicBaseWidgetImp.w(dynamicBaseWidgetImp.f29140t.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.f29132a.xk())));
                            if (w3 == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                w3 = dynamicBaseWidgetImp2.c(true, dynamicBaseWidgetImp2.f29140t.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.f29132a.xk())));
                            }
                            if (w3 != null) {
                                view.setBackground(w3);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.c(true, dynamicBaseWidgetImp3.f29140t.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.f29132a.ba() * 1000.0d));
        }
        View view2 = this.ys;
        if (view2 != null) {
            view2.setPadding((int) f.c(this.f29136k, this.f29132a.xv()), (int) f.c(this.f29136k, this.f29132a.w()), (int) f.c(this.f29136k, this.f29132a.sr()), (int) f.c(this.f29136k, this.f29132a.c()));
        }
        if (this.fp || this.f29132a.t() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.f29138r, this.ev);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.ys;
        if (view == null) {
            view = this;
        }
        double u3 = this.bk.p().sr().u();
        if (u3 < 90.0d && u3 > 0.0d) {
            com.bytedance.sdk.component.utils.ev.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.8
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (u3 * 1000.0d));
        }
        c(this.bk.p().sr().fz(), view);
        if (!TextUtils.isEmpty(this.f29132a.m())) {
            gd();
        }
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.f29146c);
            removeCallbacks(this.f29149w);
        } catch (Exception unused) {
        }
    }

    private String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return c(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return c((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void c(com.bytedance.sdk.component.ux.p pVar, final View view) {
        pVar.c(new fp<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i4, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k<Bitmap> kVar) {
                DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.f29140t;
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().sr()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.f29140t.getRenderRequest().sr())) {
                    view.setBackground(new BitmapDrawable(kVar.xv()));
                } else if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    view.setBackground(new c(kVar.xv(), ((DynamicRoot) DynamicBaseWidgetImp.this.f29140t.getChildAt(0)).f29178c));
                } else {
                    view.setBackground(new BitmapDrawable(kVar.xv()));
                }
            }
        });
    }

    private static void c(com.bytedance.sdk.component.ux.p pVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            pVar.c(Bitmap.Config.ARGB_8888);
        }
    }

    private void c(double d4, final View view) {
        if (d4 > 0.0d) {
            com.bytedance.sdk.component.utils.ev.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.9
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.bk.p().sr().rd() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d4 * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            if (viewGroup.getChildAt(i4) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i4);
            }
        }
    }
}
