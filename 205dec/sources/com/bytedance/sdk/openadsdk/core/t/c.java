package com.bytedance.sdk.openadsdk.core.t;

import android.os.Build;
import android.webkit.WebResourceResponse;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.z.r;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile AtomicBoolean f34579c = new AtomicBoolean(true);

    /* renamed from: w  reason: collision with root package name */
    private static String f34580w = "gecko.zijieapi.com";
    private File xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.t.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0511c {

        /* renamed from: c  reason: collision with root package name */
        private static c f34583c = new c();
    }

    public static c c() {
        return C0511c.f34583c;
    }

    public WebResourceResponse c(Object obj, me meVar, String str) {
        return null;
    }

    public Object c(me meVar) {
        return null;
    }

    public void c(Object obj) {
    }

    public void w() {
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            r w3 = ls.w();
            if (w3 == null) {
                return;
            }
            List<String> ux = w3.ux();
            if (ux.isEmpty()) {
                return;
            }
            for (String str : ux) {
                linkedList.add(new CheckRequestBodyModel.TargetChannel(str));
            }
        } catch (Throwable unused) {
        }
    }

    private c() {
        this.xv = new File(w.w(ls.getContext()) + File.separator + "gecko");
        k.sr().z();
    }

    public void c(Map<String, me> map) {
        c("4ab312f7094810afa84659d3dc6cf0fe", map);
    }

    private void c(String str, Map<String, me> map) {
        a.w("GeckoHub", "doPreload: false");
    }
}
