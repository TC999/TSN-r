package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.util.concurrent.Executor;

/* renamed from: com.mbridge.msdk.foundation.same.net.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ExecutorDelivery implements Delivery {

    /* renamed from: a */
    private final String f30704a = ExecutorDelivery.class.getSimpleName();

    /* renamed from: b */
    private final Executor f30705b;

    /* compiled from: ExecutorDelivery.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private class RunnableC11344a implements Runnable {

        /* renamed from: b */
        private final AbstractC11354i f30723b;

        /* renamed from: c */
        private final C11356k f30724c;

        public RunnableC11344a(AbstractC11354i abstractC11354i, C11356k c11356k) {
            this.f30723b = abstractC11354i;
            this.f30724c = c11356k;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f30723b.m22196c()) {
                this.f30723b.m22200a("canceled-at-delivery");
                this.f30723b.m22185n();
                return;
            }
            C11356k c11356k = this.f30724c;
            CommonError commonError = c11356k.f30856b;
            if (commonError == null) {
                this.f30723b.m22202a(c11356k);
            } else {
                this.f30723b.m22208a(commonError);
            }
            this.f30723b.m22200a("done");
            this.f30723b.m22183p();
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.f30705b = new Executor() { // from class: com.mbridge.msdk.foundation.same.net.d.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: a */
    public final void mo22286a(AbstractC11354i<?> abstractC11354i, C11356k<?> c11356k) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postResponse response=" + c11356k.f30855a);
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new RunnableC11344a(abstractC11354i, c11356k));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: b */
    public final void mo22285b(final AbstractC11354i<?> abstractC11354i) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postCancel request=" + abstractC11354i.m22198b());
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    abstractC11354i.m22185n();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: c */
    public final void mo22284c(final AbstractC11354i<?> abstractC11354i) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postPreExecute request=" + abstractC11354i.m22198b());
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    abstractC11354i.m22184o();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: d */
    public final void mo22283d(final AbstractC11354i<?> abstractC11354i) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postNetworking request=" + abstractC11354i.m22198b());
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    abstractC11354i.m22181r();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: e */
    public final void mo22282e(final AbstractC11354i<?> abstractC11354i) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postRetry request=" + abstractC11354i.m22198b());
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.6
                @Override // java.lang.Runnable
                public final void run() {
                    abstractC11354i.m22182q();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: a */
    public final void mo22287a(AbstractC11354i<?> abstractC11354i, CommonError commonError) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postError error=" + commonError.f30690a);
        if (this.f30705b != null) {
            this.f30705b.execute(new RunnableC11344a(abstractC11354i, C11356k.m22176a(commonError)));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: a */
    public final void mo22289a(final AbstractC11354i<?> abstractC11354i) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postFinish request=" + abstractC11354i.m22198b());
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    abstractC11354i.m22183p();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Delivery
    /* renamed from: a */
    public final void mo22288a(final AbstractC11354i<?> abstractC11354i, final long j, final long j2) {
        String str = this.f30704a;
        SameLogTool.m21736b(str, "postDownloadProgress downloadedSize=" + j2 + "/ fileSize=" + j);
        Executor executor = this.f30705b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.7
                @Override // java.lang.Runnable
                public final void run() {
                    abstractC11354i.m22209a(j, j2);
                }
            });
        }
    }
}
