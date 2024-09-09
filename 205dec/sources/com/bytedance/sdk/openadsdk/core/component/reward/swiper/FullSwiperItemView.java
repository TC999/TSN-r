package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.component.reward.w.f;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.bytedance.sdk.openadsdk.core.video.w.c;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FullSwiperItemView extends FrameLayout implements n.c, p {

    /* renamed from: a  reason: collision with root package name */
    private Context f32547a;
    private com.bytedance.sdk.openadsdk.core.component.reward.xv bk;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32548c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f32549f;
    private boolean fp;
    private boolean fz;
    private float gd;

    /* renamed from: i  reason: collision with root package name */
    private w f32550i;
    private final n ia;

    /* renamed from: k  reason: collision with root package name */
    private FullRewardExpressView f32551k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.swiper.c f32552p;

    /* renamed from: r  reason: collision with root package name */
    public TTProgressBar f32553r;

    /* renamed from: s  reason: collision with root package name */
    private c f32554s;
    public FrameLayout sr;

    /* renamed from: t  reason: collision with root package name */
    private int f32555t;

    /* renamed from: u  reason: collision with root package name */
    private int f32556u;
    public FrameLayout ux;

    /* renamed from: w  reason: collision with root package name */
    public FrameLayout f32557w;
    public FrameLayout xv;
    private boolean ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(View view, float f4, float f5);
    }

    public FullSwiperItemView(Context context, com.bytedance.sdk.openadsdk.core.component.reward.swiper.c cVar, float f4, float f5) {
        super(context);
        this.ia = new n(Looper.getMainLooper(), this);
        this.f32552p = cVar;
        this.ev = f4;
        this.gd = f5;
        this.f32547a = context;
        setBackgroundColor(0);
        k();
        this.f32556u = wv.gd(cVar.c());
        this.fz = ls.w().c(cVar.c(), this.f32556u);
        a();
        this.f32551k = new FullRewardExpressView(this.f32548c.getContext(), this.f32552p.c(), com.bytedance.sdk.openadsdk.core.eq.n.c(8, String.valueOf(this.f32556u), this.ev, this.gd), this.f32552p.w(), this.fz);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int S_() {
        com.bytedance.sdk.openadsdk.core.component.reward.xv xvVar = this.bk;
        if (xvVar == null || !this.fp) {
            return 2;
        }
        if (xvVar.ng()) {
            return 5;
        }
        if (this.bk.q()) {
            return 1;
        }
        if (this.bk.ok()) {
            return 2;
        }
        this.bk.gb();
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int T_() {
        com.bytedance.sdk.openadsdk.core.component.reward.xv xvVar = this.bk;
        if (xvVar == null) {
            return 0;
        }
        return (int) (xvVar.k() / 1000);
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
        a.c().c(this.f32552p.c(), "stats_reward_full_click_express_close");
        Context context = this.f32547a;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).b().c().c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            me c4 = this.f32552p.c();
            if (c4 != null && c4.dc() != null) {
                jSONObject.put("refresh_num", this.f32552p.c().dc().xv());
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        a.c().c(this.f32552p.c(), "stats_reward_full_click_native_close", jSONObject);
        c cVar = this.f32554s;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void Y_() {
        c cVar = this.f32554s;
        if (cVar != null) {
            cVar.c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            me c4 = this.f32552p.c();
            if (c4 != null && c4.dc() != null) {
                jSONObject.put("refresh_num", this.f32552p.c().dc().xv());
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        a.c().c(this.f32552p.c(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.f32547a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public void a() {
        me c4 = this.f32552p.c();
        if (c4 == null) {
            return;
        }
        float yx = c4.yx();
        int fh = c4.fh();
        float ee = c4.ee();
        float[] c5 = com.bytedance.sdk.openadsdk.core.component.reward.ux.w.c(StubApp.getOrigApplicationContext(this.f32547a.getApplicationContext()), c4.yx(), c4.fh());
        float f4 = c5[0];
        float f5 = c5[1];
        if (yx == 100.0f) {
            this.ev = f4;
            this.gd = f5;
            return;
        }
        int[] c6 = com.bytedance.sdk.openadsdk.core.component.reward.ux.w.c(StubApp.getOrigApplicationContext(this.f32547a.getApplicationContext()), yx, ee, fh);
        int i4 = c6[0];
        int i5 = c6[1];
        int i6 = c6[2];
        int i7 = c6[3];
        this.ev = (int) ((f4 - i4) - i6);
        this.gd = (int) ((f5 - i5) - i7);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a_(boolean z3) {
        if (this.fz != z3) {
            this.fz = z3;
            com.bytedance.sdk.openadsdk.core.component.reward.xv xvVar = this.bk;
            if (xvVar != null) {
                xvVar.w(z3);
            }
            Context context = this.f32547a;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).b().c().w();
            }
            c cVar = this.f32554s;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void bk() {
        if (this.f32552p == null) {
            return;
        }
        this.f32553r.setVisibility(0);
        this.f32551k.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                if (FullSwiperItemView.this.f32550i != null) {
                    FullSwiperItemView.this.f32550i.c(view, f4, f5);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
                super.c(view, i4);
            }
        });
        this.f32551k.setExpressVideoListenerProxy(this);
        this.f32551k.setInteractListener(this.f32554s);
        this.f32551k.setOnVideoSizeChangeListener(new FullRewardExpressView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.c
            public void c(int i4) {
                FullSwiperItemView.this.f32555t = i4;
            }
        });
        if (this.f32551k.getParent() != null) {
            ((ViewGroup) this.f32551k.getParent()).removeView(this.f32551k);
        }
        this.ux.addView(this.f32551k);
        this.bk = new com.bytedance.sdk.openadsdk.core.component.reward.xv(this.f32548c.getContext(), this.xv, this.f32552p.c(), null);
        this.bk.c(new xv(this.f32552p.ux(), pr.xv(this.f32552p.c()), new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.xv.c
            public void c() {
                if (FullSwiperItemView.this.f32547a instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.f32547a).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.xv.c
            public void c(boolean z3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.xv.c
            public void c(long j4, long j5) {
                f bj;
                if (FullSwiperItemView.this.f32551k == null || !(FullSwiperItemView.this.f32547a instanceof TTBaseVideoActivity) || (bj = ((TTBaseVideoActivity) FullSwiperItemView.this.f32547a).bj()) == null) {
                    return;
                }
                bj.w(j4);
                FullSwiperItemView.this.f32551k.c(String.valueOf(bj.eq()), (int) (bj.me() / 1000), 0, j4 == j5 || bj.yu());
            }
        }, this.ia));
        this.bk.w(this.fz);
        this.f32551k.setVideoController(this.bk);
        this.f32552p.c(this.xv, this.sr, this.f32551k);
        this.f32551k.fp();
        this.f32551k.ia();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4, float f5, float f6, float f7, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void ev() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void f() {
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c b4;
        c cVar = this.f32554s;
        if (cVar != null) {
            cVar.c();
        }
        Context context = this.f32547a;
        if (!(context instanceof TTBaseVideoActivity) || (b4 = ((TTBaseVideoActivity) context).b()) == null || b4.c() == null) {
            return;
        }
        b4.c().xv();
    }

    public void fp() {
        com.bytedance.sdk.openadsdk.core.component.reward.xv xvVar = this.bk;
        if (xvVar != null) {
            xvVar.ev();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long getActualPlayDuration() {
        return 0L;
    }

    public void ia() {
        n nVar = this.ia;
        if (nVar != null) {
            nVar.removeMessages(102);
        }
    }

    public void k() {
        View bk = ux.bk(this.f32547a);
        addView(bk);
        this.f32548c = (ViewGroup) bk.findViewById(2114387896);
        this.f32557w = (FrameLayout) bk.findViewById(2114387780);
        this.xv = (FrameLayout) bk.findViewById(2114387815);
        this.sr = (FrameLayout) bk.findViewById(2114387669);
        this.ux = (FrameLayout) bk.findViewById(2114387824);
        this.f32549f = (FrameLayout) bk.findViewById(2114387678);
        this.f32553r = (TTProgressBar) bk.findViewById(2114387769);
    }

    public void s() {
        FullRewardExpressView fullRewardExpressView = this.f32551k;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.a();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.xv xvVar = this.bk;
        if (xvVar != null) {
            xvVar.gd();
        }
    }

    public void setOnSwiperItemInteractListener(c cVar) {
        this.f32554s = cVar;
    }

    public void setOnSwiperItemRenderResultListener(w wVar) {
        this.f32550i = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void setPauseFromExpressView(boolean z3) {
    }

    public void t() {
        if (this.bk != null && this.ys) {
            this.f32552p.p();
            this.f32551k.ys();
            this.fp = true;
            if (me.w(this.f32552p.c())) {
                this.ia.sendEmptyMessageDelayed(102, 5000L);
            }
            this.f32552p.c(this.f32551k);
            if (this.f32551k.fz()) {
                return;
            }
            this.bk.c(this.f32552p.k());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void w(int i4) {
    }

    public void ys() {
        com.bytedance.sdk.openadsdk.core.component.reward.xv xvVar = this.bk;
        if (xvVar == null) {
            return;
        }
        xvVar.f();
    }

    public void w(boolean z3) {
        FullRewardExpressView fullRewardExpressView = this.f32551k;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.fz()) {
            Context context = this.f32547a;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).ls();
            }
        } else {
            this.f32551k.c((ViewGroup) this.f32557w, false);
        }
        this.ys = true;
        this.f32552p.xv(z3);
        t();
        this.f32553r.setVisibility(8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long xv() {
        return this.bk.k();
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 102) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.c cVar = this.f32552p;
        if (cVar != null) {
            cVar.ev();
        }
        Context context = this.f32547a;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).fp();
        }
        c cVar2 = this.f32554s;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class xv implements c.InterfaceC0520c {

        /* renamed from: c  reason: collision with root package name */
        private final c.InterfaceC0520c f32561c;
        private final int sr;
        private final n ux;

        /* renamed from: w  reason: collision with root package name */
        private final c f32562w;
        private boolean xv = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface c {
            void c();

            void c(long j4, long j5);

            void c(boolean z3);
        }

        xv(c.InterfaceC0520c interfaceC0520c, int i4, c cVar, n nVar) {
            this.f32561c = interfaceC0520c;
            this.f32562w = cVar;
            this.sr = i4;
            this.ux = nVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void c() {
            this.xv = false;
            c.InterfaceC0520c interfaceC0520c = this.f32561c;
            if (interfaceC0520c != null) {
                interfaceC0520c.c();
            }
            c cVar = this.f32562w;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void w() {
            c(true);
            c.InterfaceC0520c interfaceC0520c = this.f32561c;
            if (interfaceC0520c != null) {
                interfaceC0520c.w();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void xv() {
            c.InterfaceC0520c interfaceC0520c = this.f32561c;
            if (interfaceC0520c != null) {
                interfaceC0520c.xv();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void c(int i4, String str) {
            c(true);
            this.xv = false;
            c.InterfaceC0520c interfaceC0520c = this.f32561c;
            if (interfaceC0520c != null) {
                interfaceC0520c.c(i4, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void c(long j4, long j5) {
            this.ux.removeMessages(102);
            c.InterfaceC0520c interfaceC0520c = this.f32561c;
            if (interfaceC0520c != null) {
                interfaceC0520c.c(j4, j5);
            }
            c cVar = this.f32562w;
            if (cVar != null) {
                cVar.c(j4, j5);
            }
        }

        private void c(boolean z3) {
            c cVar;
            if (this.xv || (cVar = this.f32562w) == null) {
                return;
            }
            cVar.c(z3);
        }
    }
}
