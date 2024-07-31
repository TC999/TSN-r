package com.mbridge.msdk.foundation.same.p478e;

import android.content.Context;
import com.mbridge.msdk.foundation.same.p478e.CommonTask;
import com.mbridge.msdk.foundation.tools.SameOptimizedController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.mbridge.msdk.foundation.same.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonTaskLoader {

    /* renamed from: a */
    ThreadPoolExecutor f30672a;

    /* renamed from: b */
    HashMap<Long, CommonTask> f30673b;

    /* renamed from: c */
    WeakReference<Context> f30674c;

    public CommonTaskLoader(Context context, int i) {
        if (i == 0) {
            this.f30672a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.f30672a = new ThreadPoolExecutor(i, (i * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f30672a.allowCoreThreadTimeOut(true);
        this.f30673b = new HashMap<>();
        this.f30674c = new WeakReference<>(context);
    }

    /* renamed from: b */
    private synchronized void m22312b(final CommonTask commonTask, final CommonTask.InterfaceC11325b interfaceC11325b) {
        this.f30673b.put(Long.valueOf(commonTask.getId()), commonTask);
        commonTask.setonStateChangeListener(new CommonTask.InterfaceC11325b() { // from class: com.mbridge.msdk.foundation.same.e.b.1
            @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask.InterfaceC11325b
            /* renamed from: a */
            public final void mo22311a(CommonTask.EnumC11324a enumC11324a) {
                if (enumC11324a == CommonTask.EnumC11324a.CANCEL) {
                    CommonTaskLoader.this.f30673b.remove(Long.valueOf(commonTask.getId()));
                } else if (enumC11324a == CommonTask.EnumC11324a.FINISH) {
                    CommonTaskLoader.this.f30673b.remove(Long.valueOf(commonTask.getId()));
                } else if (enumC11324a == CommonTask.EnumC11324a.RUNNING && CommonTaskLoader.this.f30674c.get() == null) {
                    CommonTaskLoader.this.m22316a();
                }
                CommonTask.InterfaceC11325b interfaceC11325b2 = interfaceC11325b;
                if (interfaceC11325b2 != null) {
                    interfaceC11325b2.mo22311a(enumC11324a);
                }
            }
        });
    }

    /* renamed from: a */
    public final synchronized void m22315a(CommonTask commonTask) {
        if (commonTask != null) {
            if (this.f30673b.containsKey(Long.valueOf(commonTask.getId()))) {
                CommonTask commonTask2 = this.f30673b.get(Long.valueOf(commonTask.getId()));
                if (commonTask2 != null) {
                    commonTask2.cancel();
                }
                this.f30673b.remove(Long.valueOf(commonTask.getId()));
            }
        }
    }

    /* renamed from: b */
    public final void m22313b(CommonTask commonTask) {
        m22312b(commonTask, null);
        this.f30672a.execute(commonTask);
    }

    /* renamed from: a */
    public final synchronized void m22316a() {
        try {
            for (Map.Entry<Long, CommonTask> entry : this.f30673b.entrySet()) {
                entry.getValue().cancel();
            }
            this.f30673b.clear();
        } catch (Exception unused) {
        }
    }

    public CommonTaskLoader(Context context) {
        if (SameOptimizedController.m21727a().m21724a("c_t_p_t_l", true)) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            this.f30672a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.f30672a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f30672a.allowCoreThreadTimeOut(true);
        this.f30673b = new HashMap<>();
        this.f30674c = new WeakReference<>(context);
    }

    /* renamed from: a */
    public final void m22314a(CommonTask commonTask, CommonTask.InterfaceC11325b interfaceC11325b) {
        m22312b(commonTask, interfaceC11325b);
        this.f30672a.execute(commonTask);
    }
}
