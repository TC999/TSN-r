package com.kwad.components.core.p327r.p328a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.p286b.C8542b;
import com.kwad.components.core.p286b.View$OnClickListenerC8540a;
import com.kwad.components.core.p287c.C8552f;
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.p327r.p329b.C8905a;
import com.kwad.components.core.p327r.p329b.C8908b;
import com.kwad.components.core.webview.tachikoma.AbstractC9340k;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.InterfaceC9871l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* renamed from: com.kwad.components.core.r.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8902a extends AbstractC8691b<C8904b> {

    /* renamed from: SH */
    private static final ConcurrentMap<Integer, Map<String, Object>> f28770SH = new ConcurrentHashMap();

    /* renamed from: SI */
    private static final AtomicInteger f28771SI = new AtomicInteger(1);

    /* renamed from: SA */
    private StyleTemplate f28772SA;

    /* renamed from: SB */
    private String f28773SB;

    /* renamed from: SC */
    private boolean f28774SC;

    /* renamed from: SD */
    private InterfaceC9871l f28775SD;

    /* renamed from: SE */
    private AbstractC9340k f28776SE;

    /* renamed from: SF */
    private C8908b f28777SF;

    /* renamed from: SG */
    private int f28778SG;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private View$OnClickListenerC8540a mTitleBarHelper;

    /* renamed from: a */
    public static void m29640a(int i, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = f28770SH;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i), map);
        }
        map.put(str, obj);
    }

    /* renamed from: aK */
    private static void m29639aK(int i) {
        Map<String, Object> map = f28770SH.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }

    /* renamed from: ay */
    private Object m29638ay(String str) {
        return m29637m(this.f28778SG, str);
    }

    /* renamed from: m */
    private static Object m29637m(int i, String str) {
        Map<String, Object> map = f28770SH.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.p301l.AbstractC8691b
    /* renamed from: qQ */
    public C8904b onCreateCallerContext() {
        C8904b c8904b = new C8904b(this);
        c8904b.m29632d(this.mAdResultData);
        c8904b.f28780SA = this.f28772SA;
        c8904b.mRootContainer = this.mRootContainer;
        c8904b.f28781SD = this.f28775SD;
        c8904b.f28782SE = this.f28776SE;
        return c8904b;
    }

    /* renamed from: qR */
    public static int m29635qR() {
        return f28771SI.incrementAndGet();
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(FeedDownloadActivity.class, C8902a.class);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean checkIntentData(@Nullable Intent intent) {
        this.f28778SG = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        AbstractC9340k abstractC9340k = (AbstractC9340k) m29638ay("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && abstractC9340k == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.f28772SA = styleTemplate;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (abstractC9340k != null) {
            this.f28776SE = abstractC9340k;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData m30380d = C8552f.m30378mE().m30380d(intExtra, true);
        this.mAdResultData = m30380d;
        return intExtra <= 0 || m30380d != null;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public int getLayoutId() {
        return C9659R.C9663layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initData() {
        this.f28774SC = getIntent().getBooleanExtra("show_navigationBar", true);
        this.f28773SB = getIntent().getStringExtra("title");
        this.f28775SD = (InterfaceC9871l) m29638ay("native_intent");
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(C9659R.C9662id.ksad_js_container);
        if (!this.f28774SC && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        View$OnClickListenerC8540a view$OnClickListenerC8540a = new View$OnClickListenerC8540a((ViewGroup) findViewById(C9659R.C9662id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = view$OnClickListenerC8540a;
        view$OnClickListenerC8540a.m30412a(new View$OnClickListenerC8540a.InterfaceC8541a() { // from class: com.kwad.components.core.r.a.a.1
            @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
            /* renamed from: u */
            public final void mo29634u(View view) {
                C8902a.this.finish();
            }

            @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
            /* renamed from: v */
            public final void mo29633v(View view) {
            }
        });
        this.mTitleBarHelper.m30411a(new C8542b(this.f28773SB));
        this.mTitleBarHelper.m30410ah(false);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        C8908b c8908b = this.f28777SF;
        if (c8908b == null || !c8908b.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public Presenter onCreatePresenter() {
        if (this.f28772SA != null) {
            return new C8905a();
        }
        if (this.f28777SF == null) {
            this.f28777SF = new C8908b();
        }
        return this.f28777SF;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            m29639aK(this.f28778SG);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
