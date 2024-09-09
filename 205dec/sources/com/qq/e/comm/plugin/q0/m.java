package com.qq.e.comm.plugin.q0;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.n2;
import com.qq.e.comm.plugin.util.p0;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final int f45501a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Queue<com.qq.e.comm.plugin.q0.b>> f45502b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f45503c;

        a(WebView webView) {
            this.f45503c = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView;
            if (m.this.f45502b.isEmpty()) {
                return;
            }
            for (Map.Entry entry : m.this.f45502b.entrySet()) {
                Queue<com.qq.e.comm.plugin.q0.b> queue = (Queue) entry.getValue();
                if (queue != null && !queue.isEmpty()) {
                    for (com.qq.e.comm.plugin.q0.b bVar : queue) {
                        if ((this.f45503c == null && bVar != null) || ((webView = this.f45503c) != null && bVar == webView)) {
                            bVar.destroy();
                        }
                    }
                }
            }
            if (this.f45503c == null) {
                m.this.f45502b.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final m f45505a = new m(null);
    }

    /* synthetic */ m(a aVar) {
        this();
    }

    private m() {
        this.f45502b = new ConcurrentHashMap();
        this.f45501a = com.qq.e.comm.plugin.d0.a.d().f().a("wvmcc", 2);
    }

    public static m a() {
        return b.f45505a;
    }

    public com.qq.e.comm.plugin.q0.b a(Context context, String str) {
        Queue<com.qq.e.comm.plugin.q0.b> queue = this.f45502b.get(str);
        com.qq.e.comm.plugin.q0.b poll = (queue == null || queue.isEmpty()) ? null : queue.poll();
        if (poll == null) {
            return a(context);
        }
        ((MutableContextWrapper) poll.getContext()).setBaseContext(context);
        return poll;
    }

    private com.qq.e.comm.plugin.q0.b a(Context context) {
        try {
            return new com.qq.e.comm.plugin.q0.b(new MutableContextWrapper(context));
        } catch (Resources.NotFoundException unused) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21 && i4 < 23) {
                return new com.qq.e.comm.plugin.q0.b(new MutableContextWrapper(context.createConfigurationContext(new Configuration())));
            }
            return new com.qq.e.comm.plugin.q0.b(new MutableContextWrapper(context.getApplicationContext()));
        }
    }

    public void a(com.qq.e.comm.plugin.q0.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && (bVar.getContext() instanceof MutableContextWrapper) && bVar.h()) {
            Queue<com.qq.e.comm.plugin.q0.b> queue = this.f45502b.get(str);
            if (queue == null) {
                queue = new LinkedList<>();
                this.f45502b.put(str, queue);
            }
            if (queue.contains(bVar)) {
                return;
            }
            if (queue.size() < this.f45501a) {
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) bVar.getContext();
                mutableContextWrapper.setBaseContext(mutableContextWrapper.getApplicationContext());
                bVar.g(true);
                bVar.l();
                queue.offer(bVar);
                d1.a("Webview\u590d\u7528\uff1a\u52a0\u5165\u56de\u6536\u6c60", new Object[0]);
            } else {
                bVar.destroy();
            }
            n2.a(bVar);
            return;
        }
        bVar.destroy();
        n2.a(bVar);
    }

    public void a(WebView webView) {
        p0.a((Runnable) new a(webView));
    }
}
