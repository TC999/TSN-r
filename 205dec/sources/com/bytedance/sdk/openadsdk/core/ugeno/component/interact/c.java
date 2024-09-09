package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.component.b;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends b<InteractWebView> {

    /* renamed from: c  reason: collision with root package name */
    private String f34940c;
    private Map<String, Object> mt;

    public c(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: c */
    public InteractWebView xv() {
        InteractWebView interactWebView = new InteractWebView(this.f26040w);
        this.ux = interactWebView;
        return interactWebView;
    }

    public void ev() {
        if (TextUtils.isEmpty(this.f34940c)) {
            this.f34940c = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.ux).c(this.f34940c);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        Map<String, Object> e4 = this.gd.e();
        this.mt = e4;
        ((InteractWebView) this.ux).setUGenExtraMap(e4);
        ((InteractWebView) this.ux).setUGenContext(this.gd);
        ((InteractWebView) this.ux).bk();
        ((InteractWebView) this.ux).t();
        ev();
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            if (!TextUtils.isEmpty(this.f34940c) && this.f34940c.startsWith("http")) {
                this.f34940c = str2;
            } else {
                this.f34940c = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            }
        }
    }
}
