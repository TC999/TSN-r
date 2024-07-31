package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.Logger;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TncHostInterceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TncInstanceManager;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.GetExecutor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PostExecutor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.ProcessUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import com.clj.fastble.BleManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class NetClient {

    /* renamed from: a */
    private OkHttpClient f696a;

    /* renamed from: b */
    private TncHostInterceptor f697b;

    /* renamed from: c */
    private int f698c;

    /* compiled from: NetClient.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C0995b {

        /* renamed from: a */
        int f699a;

        /* renamed from: b */
        int f700b;

        /* renamed from: c */
        int f701c;

        /* renamed from: d */
        boolean f702d = true;

        public C0995b() {
            new ArrayList();
            this.f699a = BleManager.f22896l;
            this.f700b = BleManager.f22896l;
            this.f701c = BleManager.f22896l;
        }

        /* renamed from: a */
        public C0995b m59079a(long j, TimeUnit timeUnit) {
            this.f699a = m59078a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C0995b m59076b(long j, TimeUnit timeUnit) {
            this.f700b = m59078a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: c */
        public C0995b m59075c(long j, TimeUnit timeUnit) {
            this.f701c = m59078a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public C0995b m59077a(boolean z) {
            this.f702d = z;
            return this;
        }

        /* renamed from: a */
        private static int m59078a(String str, long j, TimeUnit timeUnit) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        /* renamed from: a */
        public NetClient m59080a() {
            return new NetClient(this);
        }
    }

    /* renamed from: c */
    public static void m59081c() {
        Logger.m59086a(Logger.EnumC0991b.DEBUG);
    }

    /* renamed from: a */
    public void m59083a(Context context, boolean z, boolean z2, ITTAdNetDepend iTTAdNetDepend) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (iTTAdNetDepend != null) {
            int mo59042c = iTTAdNetDepend.mo59042c();
            this.f698c = mo59042c;
            TncHostInterceptor tncHostInterceptor = this.f697b;
            if (tncHostInterceptor != null) {
                tncHostInterceptor.m59007a(mo59042c);
            }
            TncInstanceManager.m59006a().m59005a(this.f698c).m59023a(z2);
            TncInstanceManager.m59006a().m59005a(this.f698c).m59030a(iTTAdNetDepend);
            TncInstanceManager.m59006a().m59005a(this.f698c).m59031a(context, ProcessUtils.m58980b(context));
            if (ProcessUtils.m58979c(context) || (!ProcessUtils.m58980b(context) && z)) {
                TncInstanceManager.m59006a().m59004a(this.f698c, context).m59055d();
                TncInstanceManager.m59006a().m59004a(this.f698c, context).m59052f();
            }
            if (ProcessUtils.m58980b(context)) {
                TncInstanceManager.m59006a().m59004a(this.f698c, context).m59055d();
                TncInstanceManager.m59006a().m59004a(this.f698c, context).m59052f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
    }

    /* renamed from: b */
    public PostExecutor m59082b() {
        return new PostExecutor(this.f696a);
    }

    private NetClient(C0995b c0995b) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.C1081b m58226b = new OkHttpClient.C1081b().m58228a(c0995b.f699a, timeUnit).m58225c(c0995b.f701c, timeUnit).m58226b(c0995b.f700b, timeUnit);
        if (c0995b.f702d) {
            TncHostInterceptor tncHostInterceptor = new TncHostInterceptor();
            this.f697b = tncHostInterceptor;
            m58226b.m58227a(tncHostInterceptor);
        }
        this.f696a = m58226b.m58229a();
    }

    /* renamed from: a */
    public GetExecutor m59084a() {
        return new GetExecutor(this.f696a);
    }
}
