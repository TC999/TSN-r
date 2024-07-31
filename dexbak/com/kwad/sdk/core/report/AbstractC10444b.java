package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.AbstractC10453e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.C10506a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.report.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10444b<T extends AbstractC10453e, R extends InterfaceC10420f> {
    private static ExecutorService axn;

    /* renamed from: fS */
    private static volatile Handler f29560fS;
    private T axq;
    private Context mContext;

    /* renamed from: Tc */
    private volatile long f29561Tc = 120000;
    protected InterfaceC10462l axm = new C10463m();
    private AtomicInteger axo = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int axp = 5;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC10444b() {
        if (axn == null) {
            axn = GlobalThreadPools.m25603FF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: EC */
    public void m26060EC() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.axp) {
            if (andIncrement > 0) {
                this.f29561Tc *= 2;
            }
            m26050aq(this.f29561Tc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aq */
    public synchronized void m26050aq(long j) {
        if (f29560fS == null) {
            return;
        }
        f29560fS.removeMessages(16843025);
        Message obtain = Message.obtain(f29560fS, mo26034a(this.mContext, this.axm, this.axo));
        obtain.what = 16843025;
        f29560fS.sendMessageDelayed(obtain, j);
    }

    /* renamed from: EA */
    protected final boolean m26062EA() {
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        InterfaceC10471s interfaceC10471s = (InterfaceC10471s) ServiceProvider.get(InterfaceC10471s.class);
        return this.axm.size() >= (interfaceC10471s != null ? (long) (interfaceC10471s.mo24872ym() << i) : 20L);
    }

    /* renamed from: EB */
    public final void m26061EB() {
        m26050aq(0L);
    }

    /* renamed from: ap */
    protected final void m26051ap(long j) {
        if (j < 60) {
            this.f29561Tc = 60000L;
        } else {
            this.f29561Tc = j * 1000;
        }
    }

    /* renamed from: i */
    public synchronized void m26044i(Context context, int i) {
        this.mContext = context;
        if (f29560fS == null) {
            f29560fS = C10506a.m25586Fz();
        }
    }

    /* renamed from: w */
    protected abstract R mo26028w(List<T> list);

    /* renamed from: c */
    private void m26046c(@NonNull final InterfaceC10461k<T> interfaceC10461k) {
        new AbstractC10436l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @NonNull
            /* renamed from: en */
            private static BatchReportResult m26041en(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            public final R createRequest() {
                AbstractC10453e mo26021EF = interfaceC10461k.mo26021EF();
                AbstractC10444b.this.axq = mo26021EF;
                return (R) AbstractC10444b.this.mo26033a((AbstractC10444b) mo26021EF);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10402a
            public final ExecutorService getExecutor() {
                return AbstractC10444b.axn;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return m26041en(str);
            }
        }.request(new AbstractC10439o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            /* renamed from: a */
            private void m26040a(@NonNull BatchReportResult batchReportResult) {
                C10331c.m26254d("BaseBatchReporter", "立即上报 onSuccess action= " + AbstractC10444b.this.axq + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final void onError(@NonNull R r, int i, String str) {
                C10331c.m26250e("BaseBatchReporter", "立即上报 onError errorCode:" + i + " errorMsg:" + str + "\naction=" + AbstractC10444b.this.axq);
                AbstractC10444b.this.m26054a((InterfaceC10461k) new InterfaceC10461k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.InterfaceC10461k
                    @NonNull
                    /* renamed from: EF */
                    public final T mo26021EF() {
                        return (T) AbstractC10444b.this.axq;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m26040a((BatchReportResult) baseResultData);
            }
        });
    }

    /* renamed from: b */
    public final void m26048b(@NonNull InterfaceC10461k<T> interfaceC10461k) {
        try {
            m26046c(interfaceC10461k);
        } catch (Throwable th) {
            ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m26053a(InterfaceC10462l interfaceC10462l) {
        this.axm = interfaceC10462l;
    }

    /* renamed from: a */
    public final void m26054a(@NonNull final InterfaceC10461k<T> interfaceC10461k) {
        axn.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractC10444b.f29560fS != null && !AbstractC10444b.f29560fS.hasMessages(16843025)) {
                    AbstractC10444b abstractC10444b = AbstractC10444b.this;
                    abstractC10444b.m26050aq(abstractC10444b.f29561Tc);
                }
                AbstractC10453e mo26021EF = interfaceC10461k.mo26021EF();
                if (mo26021EF != null) {
                    AbstractC10444b.this.axm.mo26018j(mo26021EF);
                }
                if (AbstractC10444b.this.m26062EA()) {
                    AbstractC10444b.this.m26061EB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Runnable mo26034a(Context context, InterfaceC10462l<T> interfaceC10462l, AtomicInteger atomicInteger) {
        return new RunnableC10473u(context, interfaceC10462l, this, atomicInteger);
    }

    /* renamed from: a */
    public final void m26052a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.axo.getAndIncrement();
        new AbstractC10436l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @NonNull
            /* renamed from: en */
            private static BatchReportResult m26043en(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            public final R createRequest() {
                return (R) AbstractC10444b.this.mo26028w(list);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10402a
            public final ExecutorService getExecutor() {
                return AbstractC10444b.axn;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return m26043en(str);
            }
        }.request(new AbstractC10439o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            /* renamed from: a */
            private void m26042a(@NonNull BatchReportResult batchReportResult) {
                AbstractC10444b.this.axm.mo26017x(list);
                if (AbstractC10444b.this.axo.decrementAndGet() == 0 && atomicBoolean.get()) {
                    AbstractC10444b.this.m26060EC();
                }
                AbstractC10444b.this.m26051ap(batchReportResult.getInterval());
                AbstractC10444b abstractC10444b = AbstractC10444b.this;
                abstractC10444b.m26050aq(abstractC10444b.f29561Tc);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final void onError(@NonNull R r, int i, String str) {
                atomicBoolean.set(true);
                if (AbstractC10444b.this.axo.decrementAndGet() == 0) {
                    AbstractC10444b.this.m26060EC();
                }
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m26042a((BatchReportResult) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public R mo26033a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return mo26028w(arrayList);
    }
}
