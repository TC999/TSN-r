package com.mbridge.msdk.foundation.same.e;

import android.content.Context;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CommonTaskLoader.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    ThreadPoolExecutor f39466a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<Long, a> f39467b;

    /* renamed from: c  reason: collision with root package name */
    WeakReference<Context> f39468c;

    public b(Context context, int i4) {
        if (i4 == 0) {
            this.f39466a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.f39466a = new ThreadPoolExecutor(i4, (i4 * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f39466a.allowCoreThreadTimeOut(true);
        this.f39467b = new HashMap<>();
        this.f39468c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.b bVar) {
        this.f39467b.put(Long.valueOf(aVar.getId()), aVar);
        aVar.setonStateChangeListener(new a.b() { // from class: com.mbridge.msdk.foundation.same.e.b.1
            @Override // com.mbridge.msdk.foundation.same.e.a.b
            public final void a(a.EnumC0740a enumC0740a) {
                if (enumC0740a == a.EnumC0740a.CANCEL) {
                    b.this.f39467b.remove(Long.valueOf(aVar.getId()));
                } else if (enumC0740a == a.EnumC0740a.FINISH) {
                    b.this.f39467b.remove(Long.valueOf(aVar.getId()));
                } else if (enumC0740a == a.EnumC0740a.RUNNING && b.this.f39468c.get() == null) {
                    b.this.a();
                }
                a.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(enumC0740a);
                }
            }
        });
    }

    public final synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.f39467b.containsKey(Long.valueOf(aVar.getId()))) {
                a aVar2 = this.f39467b.get(Long.valueOf(aVar.getId()));
                if (aVar2 != null) {
                    aVar2.cancel();
                }
                this.f39467b.remove(Long.valueOf(aVar.getId()));
            }
        }
    }

    public final void b(a aVar) {
        b(aVar, null);
        this.f39466a.execute(aVar);
    }

    public final synchronized void a() {
        try {
            for (Map.Entry<Long, a> entry : this.f39467b.entrySet()) {
                entry.getValue().cancel();
            }
            this.f39467b.clear();
        } catch (Exception unused) {
        }
    }

    public b(Context context) {
        if (z.a().a("c_t_p_t_l", true)) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            this.f39466a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.f39466a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f39466a.allowCoreThreadTimeOut(true);
        this.f39467b = new HashMap<>();
        this.f39468c = new WeakReference<>(context);
    }

    public final void a(a aVar, a.b bVar) {
        b(aVar, bVar);
        this.f39466a.execute(aVar);
    }
}
