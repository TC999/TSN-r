package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.xv.f;
import com.bytedance.sdk.openadsdk.core.p.xv.gd;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.playable.r;
import com.bytedance.sdk.openadsdk.core.playable.ux;
import com.bytedance.sdk.openadsdk.core.playable.xv;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.w.c;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.stub.StubApp;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTPlayableWebPageActivity extends Activity implements n.c, ux.c.InterfaceC0503c {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f31896a;
    private boolean ba;
    private xv bk;

    /* renamed from: c  reason: collision with root package name */
    ev f31897c;
    private c ck;
    private boolean eq;
    private View ev;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f31898f;
    private ux.c fp;
    private Activity gb;
    private ImageView gd;

    /* renamed from: i  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f31899i;

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f31901k;
    private LinearLayout me;

    /* renamed from: n  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.multipro.w.c f31902n;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f31903p;

    /* renamed from: r  reason: collision with root package name */
    private TextView f31905r;

    /* renamed from: s  reason: collision with root package name */
    private me f31906s;

    /* renamed from: t  reason: collision with root package name */
    private int f31907t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f31908u;
    private View ux;

    /* renamed from: w  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ia.ev f31909w;
    private String ys;

    /* renamed from: z  reason: collision with root package name */
    private r f31911z;
    private final String ia = "embeded_ad";
    private final n fz = new n(Looper.getMainLooper(), this);

    /* renamed from: q  reason: collision with root package name */
    private int f31904q = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31900j = false;
    private boolean ls = true;

    /* renamed from: y  reason: collision with root package name */
    private boolean f31910y = false;
    protected com.bytedance.sdk.openadsdk.core.w.ux xv = new com.bytedance.sdk.openadsdk.core.w.ux() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.1
        @Override // com.bytedance.sdk.openadsdk.core.w.ux
        public void c(me meVar, boolean z3) {
            TTPlayableWebPageActivity.this.f31908u = true;
            if (TTPlayableWebPageActivity.this.f31899i != null) {
                TTPlayableWebPageActivity.this.f31899i.sr(z3);
                TTPlayableWebPageActivity.this.f31899i.w(me.ux(meVar));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.w.ux
        public void w() {
            if (xk.sr(TTPlayableWebPageActivity.this.me)) {
                return;
            }
            TTPlayableWebPageActivity.this.ls = false;
            if (TTPlayableWebPageActivity.this.bk.sr()) {
                return;
            }
            TTPlayableWebPageActivity.this.ux();
        }

        @Override // com.bytedance.sdk.openadsdk.core.w.ux
        public void c() {
            TTPlayableWebPageActivity.this.f31908u = true;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.ia.r sr = new com.bytedance.sdk.openadsdk.core.ia.r() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.3
        @Override // com.bytedance.sdk.openadsdk.core.ia.r
        public void c(int i4) {
            TTPlayableWebPageActivity.this.c(i4 <= 0);
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f31914c;

        static {
            int[] iArr = new int[ux.w.values().length];
            f31914c = iArr;
            try {
                iArr[ux.w.STATUS_NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31914c[ux.w.STATUS_LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31914c[ux.w.STATUS_FINISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31914c[ux.w.STATUS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        StubApp.interface11(17854);
    }

    private void a() {
        this.f31910y = true;
        this.fz.removeMessages(2);
        this.bk.w();
        this.bk.w(this.f31906s, "embeded_ad");
        ux();
    }

    private void bk() {
        if (!wx.ls(this.f31906s)) {
            this.ls = true;
        }
        if (!wx.gb(this.f31906s)) {
            this.ls = true;
        }
        r rVar = this.f31911z;
        if (rVar != null) {
            rVar.c();
        }
        xk.c((View) this.me, 0);
        ux();
    }

    private void ev() {
        com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.gb, this.f31906s, "embeded_ad");
        this.f31899i = c4;
        c4.c(k.c(this.f31906s));
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31899i;
        if (xvVar instanceof f) {
            ((f) xvVar).w(true);
        }
        c cVar = this.ck;
        if (cVar != null) {
            ((w) cVar.c(w.class)).c(this.f31899i);
        }
        if (wx.sr(this.f31906s)) {
            com.bytedance.sdk.openadsdk.core.p.w.xv xvVar2 = this.f31899i;
            if (xvVar2 instanceof f) {
                ((f) xvVar2).c().c(true);
            } else if (xvVar2 instanceof gd) {
                ((gd) xvVar2).c().c(true);
            }
            this.f31899i.w(me.ux(this.f31906s));
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar3 = this.f31899i;
        if (xvVar3 instanceof f) {
            ((f) xvVar3).xv(true);
        }
        this.f31899i.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c() {
                TTPlayableWebPageActivity.this.c(1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void w(long j4, long j5, String str, String str2) {
                TTPlayableWebPageActivity.this.c(j4, j5, 2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void xv(long j4, long j5, String str, String str2) {
                TTPlayableWebPageActivity.this.c(j4, j5, 4);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, long j5, String str, String str2) {
                TTPlayableWebPageActivity.this.c(j4, j5, 3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, String str, String str2) {
                TTPlayableWebPageActivity.this.c(5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(String str, String str2) {
                TTPlayableWebPageActivity.this.c(6, 100);
            }
        });
    }

    private void gd() {
        this.f31904q = ls.w().k(String.valueOf(wv.gd(this.f31906s)));
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = this.f31904q;
        this.fz.sendMessage(obtain);
    }

    private void k() {
        c cVar;
        if (this.f31908u || !wx.k(this.f31906s) || (cVar = this.ck) == null) {
            return;
        }
        cVar.c(null, new com.bytedance.sdk.openadsdk.core.u.gd());
    }

    private void p() {
        this.ux = findViewById(2114387688);
        this.bk = new xv((PlayableLoadingView) findViewById(2114387914), this.f31906s);
        this.f31903p = (FrameLayout) findViewById(2114387610);
        this.f31905r = (TextView) findViewById(2114387797);
        this.f31901k = (LinearLayout) findViewById(2114387967);
        this.f31898f = (RelativeLayout) findViewById(2114387748);
        this.f31896a = (FrameLayout) findViewById(2114387800);
        xk.c(this.f31898f, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.a.xv.sr(TTPlayableWebPageActivity.this.f31906s, "embeded_ad", "playable_close", (JSONObject) null);
                if (TTPlayableWebPageActivity.this.fp != null) {
                    TTPlayableWebPageActivity.this.fp.ev();
                }
                TTPlayableWebPageActivity.this.finish();
            }
        }, "mIvCloseLayout");
        View findViewById = findViewById(2114387693);
        this.ev = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTPlayableWebPageActivity.this.w();
            }
        });
        ImageView imageView = (ImageView) findViewById(2114387869);
        this.gd = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTPlayableWebPageActivity tTPlayableWebPageActivity = TTPlayableWebPageActivity.this;
                tTPlayableWebPageActivity.f31900j = !tTPlayableWebPageActivity.f31900j;
                TTPlayableWebPageActivity tTPlayableWebPageActivity2 = TTPlayableWebPageActivity.this;
                tTPlayableWebPageActivity2.c(tTPlayableWebPageActivity2.f31900j);
            }
        });
        this.ck = new c(this.gb, this.f31906s, "embeded_ad", this.f31907t) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                super.c(view, gdVar);
                TTPlayableWebPageActivity.this.f31908u = true;
                HashMap hashMap = new HashMap();
                hashMap.put("playable_url", TTPlayableWebPageActivity.this.ys);
                com.bytedance.sdk.openadsdk.core.a.xv.p(TTPlayableWebPageActivity.this.f31906s, this.xv, "click_playable_download_button_loading", hashMap);
            }
        };
        if (this.f31906s.v() == 4) {
            ((w) this.ck.c(w.class)).w(-1);
        }
    }

    private void t() {
        String str;
        this.me = (LinearLayout) findViewById(2114387747);
        ImageView imageView = (TTRoundRectImageView) findViewById(2114387805);
        TextView textView = (TextView) findViewById(2114387697);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387922);
        TextView textView2 = (TextView) findViewById(2114387897);
        TextView textView3 = (TextView) findViewById(2114387624);
        TextView textView4 = (TextView) findViewById(2114387750);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(xk.ux(this.gb, 16.0f));
            tTRatingBar.setStarImageHeight(xk.ux(this.gb, 16.0f));
            tTRatingBar.setStarImagePadding(xk.ux(this.gb, 4.0f));
            tTRatingBar.c();
        }
        if (imageView != null) {
            gb kr = this.f31906s.kr();
            if (kr != null && !TextUtils.isEmpty(kr.c())) {
                com.bytedance.sdk.openadsdk.r.w.c(kr).c(imageView);
            } else {
                imageView.setImageDrawable(i.xv(this.gb, "tt_ad_logo_small"));
            }
        }
        if (textView != null) {
            if (this.f31906s.ix() != null && !TextUtils.isEmpty(this.f31906s.ix().xv())) {
                textView.setText(this.f31906s.ix().xv());
            } else {
                textView.setText(this.f31906s.ny());
            }
        }
        if (textView2 != null) {
            int f4 = this.f31906s.ix() != null ? this.f31906s.ix().f() : 6870;
            String c4 = i.c(this.gb, "tt_comment_num_backup");
            if (f4 > 10000) {
                str = (f4 / 10000) + "\u4e07";
            } else {
                str = f4 + "";
            }
            textView2.setText(String.format(c4, str));
        }
        if (textView4 != null) {
            xk.c(textView4, this.f31906s);
        }
        if (textView3 != null) {
            textView3.setText(ys());
            c cVar = new c(this.gb, this.f31906s, "embeded_ad", this.f31907t) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
                public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                    super.c(view, gdVar);
                    TTPlayableWebPageActivity.this.f31908u = true;
                }
            };
            ((w) cVar.c(w.class)).w(-1);
            ((w) cVar.c(w.class)).c(this.f31899i);
            textView3.setOnClickListener(cVar);
        }
        if (imageView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, (int) xk.xv(this.gb, 50.0f), 0, 0);
            imageView.setLayoutParams(layoutParams);
        }
    }

    private String ys() {
        me meVar = this.f31906s;
        if (meVar == null) {
            return "\u7acb\u5373\u4e0b\u8f7d";
        }
        if (TextUtils.isEmpty(meVar.dk())) {
            return this.f31906s.v() != 4 ? "\u67e5\u770b\u8be6\u60c5" : "\u7acb\u5373\u4e0b\u8f7d";
        }
        return this.f31906s.dk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.playable.ux.c.InterfaceC0503c
    public Activity getActivity() {
        return this.gb;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        this.fz.removeCallbacksAndMessages(null);
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        ux.c cVar = this.fp;
        if (cVar != null) {
            cVar.xv();
        }
        k();
        r rVar = this.f31911z;
        if (rVar != null) {
            rVar.sr();
        }
        this.f31909w = null;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.ba = false;
        ux.c cVar = this.fp;
        if (cVar != null) {
            cVar.sr();
        }
        com.bytedance.sdk.openadsdk.core.ia.ev evVar = this.f31909w;
        if (evVar != null) {
            evVar.unregisterReceiver();
            this.f31909w.c((com.bytedance.sdk.openadsdk.core.ia.r) null);
        }
        r rVar = this.f31911z;
        if (rVar != null) {
            rVar.w();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.ba = true;
        ux.c cVar = this.fp;
        if (cVar != null) {
            cVar.w(this.f31910y);
        }
        com.bytedance.sdk.openadsdk.core.ia.ev evVar = this.f31909w;
        if (evVar != null) {
            evVar.c(this.sr);
            this.f31909w.registerReceiver();
            if (this.f31909w.w() == 0) {
                this.f31900j = true;
            }
            c(this.f31900j);
        }
        r rVar = this.f31911z;
        if (rVar != null) {
            rVar.xv();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            me meVar = this.f31906s;
            bundle.putString("material_meta", meVar != null ? meVar.mo().toString() : null);
            bundle.putInt("source", this.f31907t);
            bundle.putString("url", this.ys);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        ux.c cVar = this.fp;
        if (cVar != null) {
            cVar.ux();
        }
    }

    private void f() {
        ux.c c4 = ux.c().c(ls.getContext(), this.f31906s);
        this.fp = c4;
        if (c4 == null) {
            return;
        }
        c4.c(this);
        com.bytedance.sdk.openadsdk.core.xk gd = this.fp.gd();
        if (gd != null) {
            gd.sr(this.eq);
        }
    }

    private void r() {
        this.f31911z = new r("embeded_ad", this, this.f31906s, 1, null, this.f31896a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.playable.ux.c.InterfaceC0503c
    public void sr() {
        this.f31903p.removeAllViews();
    }

    public void ux() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31899i;
        if (xvVar != null) {
            if (xvVar instanceof f) {
                ((f) xvVar).c().c(this.ls);
            } else if (xvVar instanceof gd) {
                ((gd) xvVar).c().c(this.ls);
            }
        }
    }

    private Message xv(int i4) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i4;
        return obtain;
    }

    public void c(long j4, long j5, int i4) {
        if (!isFinishing() && j4 > 0) {
            this.fp.c(i4, (int) ((j5 * 100) / j4));
        }
    }

    protected void w() {
        if (this.f31906s == null || isFinishing()) {
            return;
        }
        if (this.f31897c == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(this.gb, this.f31906s.ve(), "embeded_ad", true);
            this.f31897c = cVar;
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.gb, cVar, this.f31906s);
        }
        this.f31897c.c();
    }

    public void c(int i4, int i5) {
        if (isFinishing()) {
            return;
        }
        this.fp.c(i4, i5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.playable.ux.c.InterfaceC0503c
    public com.bytedance.sdk.openadsdk.core.w.ux xv() {
        return this.xv;
    }

    private void c(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.f31907t = intent.getIntExtra("source", -1);
            this.eq = intent.getBooleanExtra("is_outer_click", false);
            this.ys = intent.getStringExtra("url");
            String stringExtra = intent.getStringExtra("multi_process_data");
            if (stringExtra != null) {
                try {
                    this.f31902n = com.bytedance.sdk.openadsdk.core.multipro.w.c.c(new JSONObject(stringExtra));
                    a.w("TTPWPActivity", "video state\uff1a" + this.f31902n.f33977c);
                    a.w("TTPWPActivity", "video progress\uff1a" + this.f31902n.f33979r);
                    com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = this.f31902n;
                    if (cVar.f33977c) {
                        cVar.f33979r = 0L;
                    }
                } catch (Exception unused) {
                }
            }
        }
        if (intent != null) {
            this.f31906s = wv.c(intent);
        }
        if (bundle != null) {
            try {
                this.f31907t = bundle.getInt("source", -1);
                this.ys = bundle.getString("url");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.f31906s = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(string));
                }
            } catch (Throwable unused2) {
            }
        }
        me meVar = this.f31906s;
        if (meVar == null) {
            a.f("TTPWPActivity", "material is null, no data to display");
            finish();
            return;
        }
        if (meVar.dd()) {
            this.ys = u.w(this.f31906s);
        }
        this.ys = wv.w(this.f31906s, this.ys);
        try {
            com.bytedance.sdk.openadsdk.core.z.r w3 = ls.w();
            me meVar2 = this.f31906s;
            this.f31900j = w3.c(meVar2, wv.gd(meVar2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.playable.ux.c.InterfaceC0503c
    public void w(int i4) {
        if (wx.r(this.f31906s)) {
            this.bk.c(i4);
        }
    }

    protected void c() {
        if (this.bk == null) {
            return;
        }
        if (!wx.r(this.f31906s)) {
            ux();
            this.bk.w();
            return;
        }
        this.bk.xv();
        this.bk.c(this.f31906s, "embeded_ad");
        this.bk.c(this.ck);
        if (wx.gd(this.f31906s)) {
            this.fz.sendMessageDelayed(xv(2), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        if (i4 == 1) {
            int i5 = message.arg1;
            if (i5 <= 0) {
                xk.c((View) this.f31905r, 8);
                xk.c((View) this.f31898f, 0);
                return;
            }
            xk.c((View) this.f31905r, 0);
            TextView textView = this.f31905r;
            xk.c(textView, i5 + "s");
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i5 - 1;
            this.fz.sendMessageDelayed(obtain, 1000L);
        } else if (i4 != 2) {
        } else {
            int i6 = message.arg1;
            if (i6 == 0) {
                this.fp.c(i6);
                if (this.ba) {
                    this.fp.xv(true);
                }
                a();
            } else if (i6 == 1) {
                if (this.ba) {
                    this.fp.xv(true);
                }
                a();
            } else if (i6 == 2) {
                bk();
                this.fp.c(message.arg1);
                a();
            } else if (i6 != 3) {
            } else {
                bk();
                a();
            }
        }
    }

    protected void c(boolean z3) {
        Drawable xv;
        try {
            this.f31900j = z3;
            if (z3) {
                xv = i.xv(this.gb, "tt_mute");
            } else {
                xv = i.xv(this.gb, "tt_unmute");
            }
            this.gd.setImageDrawable(xv);
            ux.c cVar = this.fp;
            if (cVar != null) {
                cVar.c(z3);
            }
            r rVar = this.f31911z;
            if (rVar != null) {
                rVar.c(z3);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.playable.ux.c.InterfaceC0503c
    public void c(int i4) {
        if (i4 == 0) {
            this.fz.sendMessageDelayed(xv(0), 1000L);
        } else if (i4 == 1) {
            this.fz.sendMessage(xv(1));
        } else if (i4 != 3) {
        } else {
            this.fz.sendMessage(xv(3));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.playable.ux.c.InterfaceC0503c
    public void c(SSWebView sSWebView) {
        ViewGroup viewGroup;
        try {
            if (sSWebView.getWebView() != null && (viewGroup = (ViewGroup) sSWebView.getParent()) != null) {
                viewGroup.removeView(sSWebView);
            }
        } catch (Exception unused) {
        }
        ViewGroup.LayoutParams layoutParams = sSWebView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            sSWebView.setLayoutParams(layoutParams);
        }
        this.f31903p.addView(sSWebView);
        ux.c cVar = this.fp;
        if (cVar == null) {
            return;
        }
        int i4 = AnonymousClass2.f31914c[cVar.c().ordinal()];
        if (i4 == 1 || i4 == 2) {
            this.bk.c(this.fp.w());
        } else if (i4 == 3) {
            ux();
            this.bk.w();
        } else if (i4 == 4) {
            this.bk.w();
            bk();
        }
        if (this.fp.r()) {
            c();
        }
        r rVar = this.f31911z;
        if (rVar != null) {
            com.bytedance.sdk.openadsdk.core.multipro.w.c cVar2 = this.f31902n;
            rVar.c(cVar2 == null ? 0L : cVar2.f33979r, this.f31900j);
        }
        k.c(this.f31906s, (ViewGroup) this.f31901k, (Context) this.gb, "embeded_ad", true, new com.bytedance.sdk.openadsdk.core.w.f() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.w.f
            public void c() {
                TTPlayableWebPageActivity.this.ls = true;
                TTPlayableWebPageActivity.this.ux();
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.f
            public void w() {
                TTPlayableWebPageActivity.this.ls = false;
                TTPlayableWebPageActivity.this.ux();
            }
        }, true);
    }
}
