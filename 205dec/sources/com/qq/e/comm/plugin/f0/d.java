package com.qq.e.comm.plugin.f0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements ACTD, View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final Activity f43088c;

    /* renamed from: d  reason: collision with root package name */
    private String f43089d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f43090e;

    /* renamed from: f  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.a f43091f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f43092g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f43093h;

    /* renamed from: i  reason: collision with root package name */
    private e f43094i;

    /* renamed from: j  reason: collision with root package name */
    private e f43095j;

    /* renamed from: k  reason: collision with root package name */
    private e f43096k;

    /* renamed from: l  reason: collision with root package name */
    private View f43097l;

    /* renamed from: m  reason: collision with root package name */
    private View f43098m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f43099n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43101c;

        b(String str) {
            this.f43101c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f43099n.setText(this.f43101c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SpannableStringBuilder f43103c;

        c(SpannableStringBuilder spannableStringBuilder) {
            this.f43103c = spannableStringBuilder;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f43099n.setText(this.f43103c);
        }
    }

    public d(Activity activity) {
        this.f43088c = activity;
    }

    private FrameLayout b() {
        FrameLayout frameLayout = new FrameLayout(this.f43088c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(this.f43088c, this.f43090e).a();
        a4.loadUrl(this.f43091f.c());
        View a5 = a4.a();
        this.f43098m = a5;
        frameLayout.addView(a5, layoutParams);
        com.qq.e.comm.plugin.q0.h a6 = new com.qq.e.comm.plugin.q0.d(this.f43088c, this.f43090e).a();
        a6.loadUrl(this.f43091f.g());
        View a7 = a6.a();
        this.f43097l = a7;
        frameLayout.addView(a7, layoutParams);
        TextView textView = new TextView(this.f43088c);
        this.f43099n = textView;
        textView.setBackgroundColor(-1);
        this.f43099n.setText("\u6743\u9650\u4fe1\u606f\u83b7\u53d6\u4e2d...");
        this.f43099n.setTextColor(-13421773);
        this.f43099n.setMovementMethod(new ScrollingMovementMethod());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        int a8 = f1.a((Context) this.f43088c, 4);
        this.f43099n.setPadding(a8, 0, a8, 0);
        frameLayout.addView(this.f43099n, layoutParams2);
        com.qq.e.comm.plugin.i0.d.a().a(new com.qq.e.comm.plugin.i0.n.c(this.f43091f.f(), f.a.GET, (byte[]) null), c.a.f44222e, new a());
        return frameLayout;
    }

    private ViewGroup c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f43088c);
        TextView textView = new TextView(this.f43088c);
        this.f43093h = textView;
        textView.setId(4660);
        this.f43093h.setTextColor(-13421773);
        this.f43093h.setTextSize(2, 16.0f);
        this.f43093h.setTypeface(Typeface.defaultFromStyle(1));
        this.f43093h.setEllipsize(TextUtils.TruncateAt.END);
        this.f43093h.setText(this.f43091f.a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = f1.a((Context) this.f43088c, 20);
        relativeLayout.addView(this.f43093h, layoutParams);
        ImageView imageView = new ImageView(this.f43088c);
        this.f43092g = imageView;
        imageView.setId(4661);
        this.f43092g.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAABIAAAAfCAYAAADqUJ2JAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAEqADAAQAAAABAAAAHwAAAABiOXbkAAABU0lEQVRIDaXVO07DQBAGYO/aQrKUzgXKCUJjGruDIhGi4AAWB6Cl5Qacgysg0SCakCI0ll1QUtgtVK7oItn8Q7JWovgxu7tFxrZ2vo2lGY/rGK4kSU58378Kw/CnKIqNNHGiKJqWZfmJ3LeqqlZkaEOECCHekXtGANZp0zRCC1IIEmdbw9kg3gNu2FAX4rrubZZlL4SKnTwY+pA0TZ9V4ijEQQgbhLjIIKSD9EK6SCdkghxBpsgBZIO0kC1CkKQuRlzulz1V7H6x0caxJdHFc2xSDehIKR91ETpEBkHwgfhNN7Tqun7Aq15u7/i//5Udx/EMr0afhuku9RfxJs/zNZdqW8QWayE62QY7gGywI8gU64RMsF5IFxuEdLBRiIuxIA7GHkcYO1+YXwugqp0muH5F7V3QQWyINvdgT9qTtgsDUmtNWkLUon+G63MAd57nXdPzP9A5AGXXq8l4AAAAAElFTkSuQmCC"));
        this.f43092g.setOnClickListener(this);
        int a4 = f1.a((Context) this.f43088c, 16);
        int a5 = f1.a((Context) this.f43088c, 10);
        int i4 = a4 + (a5 * 2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, i4);
        this.f43092g.setPadding(a5, a5, a5, a5);
        layoutParams2.topMargin = f1.a((Context) this.f43088c, 12);
        layoutParams2.leftMargin = f1.a((Context) this.f43088c, 6);
        relativeLayout.addView(this.f43092g, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f43088c);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = f1.a((Context) this.f43088c, 20);
        layoutParams3.addRule(3, 4660);
        layoutParams3.addRule(14);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 1.0f;
        e eVar = new e(this.f43088c, "\u6743\u9650\u8be6\u60c5");
        this.f43094i = eVar;
        eVar.setId(4662);
        this.f43094i.setOnClickListener(this);
        this.f43094i.a(true);
        linearLayout.addView(this.f43094i, layoutParams4);
        e eVar2 = new e(this.f43088c, "\u9690\u79c1\u534f\u8bae");
        this.f43095j = eVar2;
        eVar2.setId(4663);
        this.f43095j.setOnClickListener(this);
        linearLayout.addView(this.f43095j, layoutParams4);
        e eVar3 = new e(this.f43088c, "\u529f\u80fd\u4ecb\u7ecd");
        this.f43096k = eVar3;
        eVar3.setId(4664);
        this.f43096k.setOnClickListener(this);
        linearLayout.addView(this.f43096k, layoutParams4);
        relativeLayout.addView(linearLayout, layoutParams3);
        return relativeLayout;
    }

    private void d() {
        LinearLayout linearLayout = new LinearLayout(this.f43088c);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        ViewGroup c4 = c();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = f1.a((Context) this.f43088c, 1);
        linearLayout.addView(c4, layoutParams);
        View view = new View(this.f43088c);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        linearLayout.addView(b(), new LinearLayout.LayoutParams(-1, -1));
        this.f43088c.setContentView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.f43088c.getIntent().getStringExtra("objectId");
        this.f43089d = stringExtra;
        com.qq.e.comm.plugin.g0.e a4 = ((com.qq.e.comm.plugin.d0.b.a) com.qq.e.comm.plugin.d0.b.e.a(stringExtra, com.qq.e.comm.plugin.d0.b.a.class)).a();
        this.f43090e = a4;
        if (a4 == null) {
            d1.a("MiitInfo Activity \u521b\u5efa\u5931\u8d25\uff0c\u5e7f\u544a\u6570\u636e\u4e3a\u7a7a");
            com.qq.e.comm.plugin.d0.b.e.a(com.qq.e.comm.plugin.d0.b.a.class);
            this.f43088c.finish();
            return;
        }
        if (a4.q() != null) {
            com.qq.e.comm.plugin.g0.a b4 = this.f43090e.q().b();
            this.f43091f = b4;
            if (b4 != null) {
                d();
                return;
            }
        }
        d1.a("MiitInfo Activity \u521b\u5efa\u5931\u8d25\uff0c\u5e7f\u544aApp\u4fe1\u606f\u6570\u636e\u4e3a\u7a7a");
        v.a(9130070, com.qq.e.comm.plugin.n0.c.a(this.f43090e), 2);
        this.f43088c.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        a();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f43088c.requestWindowFeature(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 4661:
                a();
                return;
            case 4662:
                this.f43094i.a(true);
                this.f43095j.a(false);
                this.f43096k.a(false);
                this.f43099n.setVisibility(0);
                this.f43097l.setVisibility(8);
                this.f43098m.setVisibility(8);
                return;
            case 4663:
                this.f43094i.a(false);
                this.f43095j.a(true);
                this.f43096k.a(false);
                this.f43099n.setVisibility(8);
                this.f43097l.setVisibility(0);
                this.f43098m.setVisibility(8);
                return;
            case 4664:
                this.f43094i.a(false);
                this.f43095j.a(false);
                this.f43096k.a(true);
                this.f43099n.setVisibility(8);
                this.f43097l.setVisibility(8);
                this.f43098m.setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        com.qq.e.comm.plugin.d0.b.e.b(this.f43089d, com.qq.e.comm.plugin.d0.b.a.class);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f43088c.runOnUiThread(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int a4 = f1.a((Context) this.f43088c, 3);
        int a5 = f1.a((Context) this.f43088c, 20);
        int i4 = 0;
        while (keys.hasNext()) {
            JSONObject optJSONObject = jSONObject.optJSONObject(keys.next());
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("level");
                String optString = optJSONObject.optString("desc");
                String optString2 = optJSONObject.optString("title");
                if (optInt > 0 && !TextUtils.isEmpty(optString2)) {
                    spannableStringBuilder.append((CharSequence) (optString2 + '\n'));
                    int length = optString2.length() + i4 + 1;
                    spannableStringBuilder.setSpan(new BulletSpan(a4), i4, length, 33);
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, length, 33);
                    if (TextUtils.isEmpty(optString)) {
                        i4 = length;
                    } else {
                        spannableStringBuilder.append((CharSequence) (optString + '\n'));
                        i4 = optString.length() + length + 1;
                        spannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(a5), length, i4, 33);
                    }
                }
            }
        }
        this.f43088c.runOnUiThread(new c(spannableStringBuilder));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.i0.b {
        a() {
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            int statusCode = gVar.getStatusCode();
            if (statusCode == 200) {
                try {
                    d.this.a(new JSONObject(gVar.b()));
                    return;
                } catch (IOException | JSONException e4) {
                    d dVar = d.this;
                    dVar.a("\u83b7\u53d6\u6743\u9650\u4fe1\u606f\u56de\u5305\u89e3\u6790\u5931\u8d25:" + e4.getMessage());
                    return;
                }
            }
            d dVar2 = d.this;
            dVar2.a("\u83b7\u53d6\u6743\u9650\u4fe1\u606f\u7f51\u7edc\u5931\u8d25\u9519\u8bef\u7801:" + statusCode);
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
            d dVar = d.this;
            dVar.a("\u83b7\u53d6\u6743\u9650\u4fe1\u606f\u5931\u8d25:" + exc.getMessage());
        }
    }

    private void a() {
        WeakReference<g.b> weakReference;
        this.f43088c.finish();
        com.qq.e.comm.plugin.g0.e eVar = this.f43090e;
        if (eVar == null || (weakReference = g.b.f43113a.get(eVar.e0())) == null) {
            return;
        }
        g.b bVar = weakReference.get();
        if (bVar != null) {
            bVar.c();
        }
        g.b.f43113a.remove(this.f43090e.e0());
    }
}
