package com.bytedance.sdk.openadsdk.core.ugeno.gd;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.a.ux;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.f;
import com.bytedance.sdk.openadsdk.core.ugeno.r.ux;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.core.ugeno.r.c implements n.c {
    private boolean ck;
    private com.bytedance.sdk.openadsdk.core.ia.xv gb;

    /* renamed from: j  reason: collision with root package name */
    private boolean f34973j;
    private final Handler ls;

    /* renamed from: n  reason: collision with root package name */
    private long f34974n;

    /* renamed from: q  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.w f34975q;

    /* renamed from: z  reason: collision with root package name */
    private AtomicBoolean f34976z;

    public w(Context context, ViewGroup viewGroup, ux uxVar, me meVar, String str, int i4) {
        super(context, viewGroup, uxVar, meVar, str, i4);
        this.f34973j = false;
        this.ls = new n(Looper.getMainLooper(), this);
        this.ck = true;
        this.f34976z = new AtomicBoolean();
        this.f34974n = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int S_() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int T_() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void U_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void V_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void W_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void X_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void Y_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a_(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4, float f5, float f6, float f7, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void ev() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void f() {
    }

    public void fp() {
        ScrollView scrollView = new ScrollView(this.f34997w);
        LinearLayout linearLayout = new LinearLayout(this.f34997w);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.f34997w);
        imageView.setImageDrawable(i.xv(this.f34997w, "tt_ecomm_page_backup_img"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = xk.ux(this.f34997w, 10.0f);
        layoutParams.leftMargin = xk.ux(this.f34997w, 10.0f);
        layoutParams.rightMargin = xk.ux(this.f34997w, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.f34997w);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageDrawable(i.xv(this.f34997w, "tt_ecomm_page_backup_img"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = xk.ux(this.f34997w, 10.0f);
        layoutParams2.leftMargin = xk.ux(this.f34997w, 10.0f);
        layoutParams2.rightMargin = xk.ux(this.f34997w, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.xv.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void fz() {
        this.ls.removeMessages(10082);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long getActualPlayDuration() {
        return 0L;
    }

    public void ia() {
        s();
        if (this.ck) {
            this.ck = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_START, this.f34974n);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.ux, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gd.w.3
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    public void s() {
        Handler handler = this.ls;
        if (handler != null) {
            handler.removeMessages(10081);
            this.ls.removeMessages(10082);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void setPauseFromExpressView(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void sr(b<View> bVar) {
    }

    public void u() {
        if (f.w(this.ux)) {
            this.ls.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void w(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long xv() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(@NonNull List<me> list) {
        this.fp = list.size();
        this.ia = list.size();
        this.f34994s = t();
        a.w("BasePageInflater", "\u5728\u3010" + this.f34994s + "\u3011\u4f4d\u7f6e\u5904\u8fdb\u884c\u9884\u8bf7\u6c42");
        me meVar = list.get(0);
        if (meVar != null) {
            this.f34995t = meVar.ya();
        }
        this.gd = c(list);
        com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c(this.f34985c, new ux.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gd.w.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c
            public void c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    ((com.bytedance.sdk.openadsdk.core.ugeno.r.c) w.this).sr.c(-1, "template info load fail");
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.r.c) w.this).f34986f != null) {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.r.c) w.this).f34986f.c(-1);
                        return;
                    }
                    return;
                }
                w wVar = w.this;
                wVar.c(jSONObject, ((com.bytedance.sdk.openadsdk.core.ugeno.r.c) wVar).gd);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #0 {Exception -> 0x0062, blocks: (B:2:0x0000, B:4:0x001b, B:6:0x0021, B:8:0x002d, B:14:0x0045, B:18:0x0056), top: B:28:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.core.u.me r0 = r6.ux     // Catch: java.lang.Exception -> L62
            int r0 = com.bytedance.sdk.openadsdk.core.ugeno.f.c(r0)     // Catch: java.lang.Exception -> L62
            r6.ys = r0     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.u.me r0 = r6.ux     // Catch: java.lang.Exception -> L62
            org.json.JSONObject r0 = r0.ya()     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.ugeno.gd.w$1 r1 = new com.bytedance.sdk.openadsdk.core.ugeno.gd.w$1     // Catch: java.lang.Exception -> L62
            r1.<init>()     // Catch: java.lang.Exception -> L62
            r6.gb = r1     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.u.me r1 = r6.ux     // Catch: java.lang.Exception -> L62
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L42
            com.bytedance.sdk.openadsdk.core.ugeno.gd.c r1 = r1.fp()     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L42
            com.bytedance.sdk.openadsdk.core.u.me r1 = r6.ux     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.ugeno.gd.c r1 = r1.fp()     // Catch: java.lang.Exception -> L62
            org.json.JSONObject r1 = r1.xv()     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L42
            com.bytedance.sdk.openadsdk.core.u.me r1 = r6.ux     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.ugeno.gd.c r1 = r1.fp()     // Catch: java.lang.Exception -> L62
            org.json.JSONObject r1 = r1.xv()     // Catch: java.lang.Exception -> L62
            java.lang.String r4 = "use_gnd_prefetch"
            int r1 = r1.optInt(r4, r2)     // Catch: java.lang.Exception -> L62
            if (r1 != r3) goto L40
            goto L42
        L40:
            r1 = 0
            goto L43
        L42:
            r1 = 1
        L43:
            if (r1 == 0) goto L54
            com.bytedance.sdk.openadsdk.core.playable.sr r1 = com.bytedance.sdk.openadsdk.core.playable.sr.c()     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.u.me r4 = r6.ux     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.ia.xv r5 = r6.gb     // Catch: java.lang.Exception -> L62
            boolean r1 = r1.c(r4, r5)     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L54
            r2 = 1
        L54:
            if (r2 != 0) goto La1
            com.bytedance.sdk.openadsdk.core.u.me r1 = r6.ux     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.ia.xv r2 = r6.gb     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.ys.w.xv.w r3 = r1.oo()     // Catch: java.lang.Exception -> L62
            com.bytedance.sdk.openadsdk.core.q.w.c(r1, r0, r2, r3)     // Catch: java.lang.Exception -> L62
            goto La1
        L62:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicInteger r1 = r6.f34987i
            int r1 = r1.get()
            if (r1 > 0) goto L7d
            com.bytedance.sdk.openadsdk.core.a.ux r1 = r6.sr
            java.lang.String r0 = r0.getMessage()
            r2 = -3
            r1.c(r2, r0)
            com.bytedance.sdk.openadsdk.core.ugeno.sr.c r0 = r6.f34986f
            if (r0 == 0) goto La1
            r0.c(r2)
            goto La1
        L7d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onAdLoaded: retry "
            r0.append(r1)
            java.util.concurrent.atomic.AtomicInteger r1 = r6.f34987i
            int r1 = r1.get()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BasePageInflater"
            android.util.Log.d(r1, r0)
            java.util.concurrent.atomic.AtomicInteger r0 = r6.f34987i
            r0.decrementAndGet()
            r6.a()
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.gd.w.a():void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void f(b<View> bVar) {
        if (bVar == null) {
            return;
        }
        a.w("BasePageInflater", "onDeActive");
        JSONObject p3 = bVar.p();
        if (p3 == null) {
            return;
        }
        int optInt = p3.optInt("image_mode");
        b<View> w3 = bVar.w("video_" + optInt);
        if (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) w3).q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.c
    public List<com.bytedance.adsdk.ugeno.c.c.f> k() {
        this.gd = new ArrayList();
        JSONObject mo = this.ux.mo();
        try {
            mo.put("env_info", f.c());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.gd.add(new com.bytedance.adsdk.ugeno.c.c.f(mo, -2134548432));
        return this.gd;
    }

    public void sr(boolean z3) {
        this.f34976z.set(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void ux(b<View> bVar) {
        if (bVar == null) {
            return;
        }
        a.w("BasePageInflater", "onActive\uff1a " + bVar);
        JSONObject p3 = bVar.p();
        if (p3 == null) {
            return;
        }
        int optInt = p3.optInt("image_mode");
        b<View> w3 = bVar.w("video_" + optInt);
        if (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) w3;
            this.f34975q = wVar;
            wVar.xv(this.f34973j);
            this.f34975q.fz();
        }
    }

    public void xv(boolean z3) {
        this.f34973j = z3;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = this.f34975q;
        if (wVar != null) {
            wVar.xv(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.c
    public void ys() {
        super.ys();
        com.bytedance.sdk.openadsdk.core.playable.sr.c().w(this.ux);
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void c(int i4, int i5) {
        a.w("BasePageInflater", "onScrolled\uff0c dy = " + i5);
        if (i5 > 0) {
            this.f34991p.set(1);
        }
    }

    public void xv(int i4) {
        if (i4 == 0) {
            if (this.f34976z.get()) {
                return;
            }
            this.ls.sendEmptyMessageDelayed(10081, 5000L);
            return;
        }
        if (this.f34976z.get()) {
            com.bytedance.sdk.openadsdk.core.ugeno.r.w wVar = this.fz;
            if (wVar != null) {
                wVar.w();
            }
            this.f34976z.set(false);
        }
        this.ls.removeMessages(10081);
        this.ls.removeMessages(10082);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void c(RecyclerView recyclerView, int i4) {
        if (f.w(this.ux)) {
            xv(i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void c(b bVar, int i4, View view, com.bytedance.adsdk.ugeno.c.c.f fVar) {
        if (fVar == null || fVar.a() == null) {
            return;
        }
        int hashCode = fVar.a().hashCode();
        if (this.f34989k.get(Integer.valueOf(hashCode)) != null && this.f34989k.containsKey(Integer.valueOf(hashCode)) && this.f34989k.get(Integer.valueOf(hashCode)).booleanValue()) {
            return;
        }
        a.w("BasePageInflater", "show key = " + hashCode + "; position = " + i4);
        c(fVar.a());
        if (i4 == this.f34994s) {
            c(bVar);
        }
        this.f34989k.put(Integer.valueOf(hashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (this.f34991p.get() == 1) {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.ux, this.f34984a, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.xv
    public void xv(b bVar) {
        me c4;
        if (bVar == null) {
            return;
        }
        if (bVar.p().has("ugen_sub_meta")) {
            c4 = com.bytedance.sdk.openadsdk.core.w.c(bVar.p().optJSONObject("ugen_sub_meta"));
        } else {
            c4 = com.bytedance.sdk.openadsdk.core.w.c(bVar.p());
        }
        if (c4 != null) {
            c(c4, bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4) {
        a.w("BasePageInflater", "onChangeVideoState: " + i4);
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = this.f34975q;
        if (wVar == null) {
            a.f("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i4 == 2) {
            wVar.i();
        } else if (i4 == 3) {
            wVar.u();
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        if (i4 != 10081) {
            if (i4 != 10082) {
                return;
            }
            if (this.f34976z.get()) {
                c(i.c(this.f34997w, "tt_ecomm_page_reward_slide_tip"));
                this.ls.sendEmptyMessageDelayed(10082, 6000L);
                return;
            }
            this.ls.removeMessages(10082);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.r.w wVar = this.fz;
        if (wVar != null) {
            wVar.c();
            this.f34976z.set(true);
            c(i.c(this.f34997w, "tt_ecomm_page_reward_slide_tip"));
            this.ls.sendEmptyMessageDelayed(10082, 6000L);
        }
    }

    public void c(String str) {
        ViewGroup viewGroup = this.xv;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        Toast makeText = Toast.makeText(this.f34997w, str, 0);
        makeText.setGravity(49, 0, 60);
        makeText.show();
    }
}
