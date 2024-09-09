package com.qq.e.comm.plugin.e0.d;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f42803c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.e0.d.e$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0808a implements Runnable {
            RunnableC0808a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Map<String, String> preloadAdapterMaps = GlobalSetting.getPreloadAdapterMaps();
                e.b(a.this.f42803c, preloadAdapterMaps.get("BD"), com.qq.e.comm.plugin.e0.e.d.f42909w);
                e.b(a.this.f42803c, preloadAdapterMaps.get("TT"), com.qq.e.comm.plugin.e0.e.d.f42911y);
                e.b(a.this.f42803c, preloadAdapterMaps.get("KS"), com.qq.e.comm.plugin.e0.e.d.f42910x);
            }
        }

        a(Context context) {
            this.f42803c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f42803c);
            p0.a((Runnable) new RunnableC0808a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            Class.forName(str).getMethod("init", Context.class, String.class).invoke(null, context, str2);
        } catch (Exception e4) {
            GDTLogger.e("MSDK MediationPreloadManager " + e4.toString());
        }
    }

    public static void a(Context context) {
        d0.f46407c.execute(new a(context));
    }
}
