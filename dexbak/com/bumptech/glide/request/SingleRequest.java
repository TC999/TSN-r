package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.C3771k;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.bumptech.glide.request.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SingleRequest<R> implements InterfaceC3744d, SizeReadyCallback, ResourceCallback, FactoryPools.InterfaceC3779f {

    /* renamed from: D */
    private static final String f14398D = "Glide";

    /* renamed from: A */
    private int f14401A;
    @Nullable

    /* renamed from: B */
    private RuntimeException f14402B;

    /* renamed from: a */
    private boolean f14403a;
    @Nullable

    /* renamed from: b */
    private final String f14404b;

    /* renamed from: c */
    private final StateVerifier f14405c;
    @Nullable

    /* renamed from: d */
    private RequestListener<R> f14406d;

    /* renamed from: e */
    private RequestCoordinator f14407e;

    /* renamed from: f */
    private Context f14408f;

    /* renamed from: g */
    private GlideContext f14409g;
    @Nullable

    /* renamed from: h */
    private Object f14410h;

    /* renamed from: i */
    private Class<R> f14411i;

    /* renamed from: j */
    private BaseRequestOptions<?> f14412j;

    /* renamed from: k */
    private int f14413k;

    /* renamed from: l */
    private int f14414l;

    /* renamed from: m */
    private Priority f14415m;

    /* renamed from: n */
    private Target<R> f14416n;
    @Nullable

    /* renamed from: o */
    private List<RequestListener<R>> f14417o;

    /* renamed from: p */
    private Engine f14418p;

    /* renamed from: q */
    private TransitionFactory<? super R> f14419q;

    /* renamed from: r */
    private Executor f14420r;

    /* renamed from: s */
    private Resource<R> f14421s;

    /* renamed from: t */
    private Engine.C3636d f14422t;

    /* renamed from: u */
    private long f14423u;
    @GuardedBy("this")

    /* renamed from: v */
    private EnumC3747b f14424v;

    /* renamed from: w */
    private Drawable f14425w;

    /* renamed from: x */
    private Drawable f14426x;

    /* renamed from: y */
    private Drawable f14427y;

    /* renamed from: z */
    private int f14428z;

    /* renamed from: E */
    private static final Pools.Pool<SingleRequest<?>> f14399E = FactoryPools.m44359e(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, new C3746a());

    /* renamed from: C */
    private static final String f14397C = "Request";

    /* renamed from: F */
    private static final boolean f14400F = Log.isLoggable(f14397C, 2);

    /* compiled from: SingleRequest.java */
    /* renamed from: com.bumptech.glide.request.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3746a implements FactoryPools.InterfaceC3777d<SingleRequest<?>> {
        C3746a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3777d
        /* renamed from: b */
        public SingleRequest<?> mo44354a() {
            return new SingleRequest<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleRequest.java */
    /* renamed from: com.bumptech.glide.request.j$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC3747b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    SingleRequest() {
        this.f14404b = f14400F ? String.valueOf(super.hashCode()) : null;
        this.f14405c = StateVerifier.m44345a();
    }

    /* renamed from: A */
    public static <R> SingleRequest<R> m44557A(Context context, GlideContext glideContext, Object obj, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        SingleRequest<?> acquire = f14399E.acquire();
        if (acquire == null) {
            acquire = new SingleRequest();
        }
        acquire.m44542s(context, glideContext, obj, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
        return acquire;
    }

    /* renamed from: B */
    private synchronized void m44556B(GlideException glideException, int i) {
        boolean z;
        this.f14405c.mo44343c();
        glideException.setOrigin(this.f14402B);
        int m45631g = this.f14409g.m45631g();
        if (m45631g <= i) {
            Log.w(f14398D, "Load failed for " + this.f14410h + " with size [" + this.f14428z + "x" + this.f14401A + "]", glideException);
            if (m45631g <= 4) {
                glideException.logRootCauses(f14398D);
            }
        }
        this.f14422t = null;
        this.f14424v = EnumC3747b.FAILED;
        boolean z2 = true;
        this.f14403a = true;
        List<RequestListener<R>> list = this.f14417o;
        if (list != null) {
            z = false;
            for (RequestListener<R> requestListener : list) {
                z |= requestListener.mo44585a(glideException, this.f14410h, this.f14416n, m44541t());
            }
        } else {
            z = false;
        }
        RequestListener<R> requestListener2 = this.f14406d;
        if (requestListener2 == null || !requestListener2.mo44585a(glideException, this.f14410h, this.f14416n, m44541t())) {
            z2 = false;
        }
        if (!(z | z2)) {
            m44553E();
        }
        this.f14403a = false;
        m44536y();
    }

    /* renamed from: C */
    private synchronized void m44555C(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean m44541t = m44541t();
        this.f14424v = EnumC3747b.COMPLETE;
        this.f14421s = resource;
        if (this.f14409g.m45631g() <= 3) {
            Log.d(f14398D, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.f14410h + " with size [" + this.f14428z + "x" + this.f14401A + "] in " + LogTime.m44412a(this.f14423u) + " ms");
        }
        boolean z2 = true;
        this.f14403a = true;
        List<RequestListener<R>> list = this.f14417o;
        if (list != null) {
            z = false;
            for (RequestListener<R> requestListener : list) {
                z |= requestListener.mo44584c(r, this.f14410h, this.f14416n, dataSource, m44541t);
            }
        } else {
            z = false;
        }
        RequestListener<R> requestListener2 = this.f14406d;
        if (requestListener2 == null || !requestListener2.mo44584c(r, this.f14410h, this.f14416n, dataSource, m44541t)) {
            z2 = false;
        }
        if (!(z2 | z)) {
            this.f14416n.mo44364k(r, this.f14419q.mo44442a(dataSource, m44541t));
        }
        this.f14403a = false;
        m44535z();
    }

    /* renamed from: D */
    private void m44554D(Resource<?> resource) {
        this.f14418p.m45210k(resource);
        this.f14421s = null;
    }

    /* renamed from: E */
    private synchronized void m44553E() {
        if (m44548m()) {
            Drawable m44544q = this.f14410h == null ? m44544q() : null;
            if (m44544q == null) {
                m44544q = m44545p();
            }
            if (m44544q == null) {
                m44544q = m44543r();
            }
            this.f14416n.mo44481n(m44544q);
        }
    }

    /* renamed from: k */
    private void m44550k() {
        if (this.f14403a) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* renamed from: l */
    private boolean m44549l() {
        RequestCoordinator requestCoordinator = this.f14407e;
        return requestCoordinator == null || requestCoordinator.mo44522l(this);
    }

    /* renamed from: m */
    private boolean m44548m() {
        RequestCoordinator requestCoordinator = this.f14407e;
        return requestCoordinator == null || requestCoordinator.mo44531c(this);
    }

    /* renamed from: n */
    private boolean m44547n() {
        RequestCoordinator requestCoordinator = this.f14407e;
        return requestCoordinator == null || requestCoordinator.mo44529e(this);
    }

    /* renamed from: o */
    private void m44546o() {
        m44550k();
        this.f14405c.mo44343c();
        this.f14416n.mo44478b(this);
        Engine.C3636d c3636d = this.f14422t;
        if (c3636d != null) {
            c3636d.m45201a();
            this.f14422t = null;
        }
    }

    /* renamed from: p */
    private Drawable m44545p() {
        if (this.f14425w == null) {
            Drawable m44669G = this.f14412j.m44669G();
            this.f14425w = m44669G;
            if (m44669G == null && this.f14412j.m44671F() > 0) {
                this.f14425w = m44539v(this.f14412j.m44671F());
            }
        }
        return this.f14425w;
    }

    /* renamed from: q */
    private Drawable m44544q() {
        if (this.f14427y == null) {
            Drawable m44667H = this.f14412j.m44667H();
            this.f14427y = m44667H;
            if (m44667H == null && this.f14412j.m44665I() > 0) {
                this.f14427y = m44539v(this.f14412j.m44665I());
            }
        }
        return this.f14427y;
    }

    /* renamed from: r */
    private Drawable m44543r() {
        if (this.f14426x == null) {
            Drawable m44655N = this.f14412j.m44655N();
            this.f14426x = m44655N;
            if (m44655N == null && this.f14412j.m44653O() > 0) {
                this.f14426x = m44539v(this.f14412j.m44653O());
            }
        }
        return this.f14426x;
    }

    /* renamed from: s */
    private synchronized void m44542s(Context context, GlideContext glideContext, Object obj, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.f14408f = context;
        this.f14409g = glideContext;
        this.f14410h = obj;
        this.f14411i = cls;
        this.f14412j = baseRequestOptions;
        this.f14413k = i;
        this.f14414l = i2;
        this.f14415m = priority;
        this.f14416n = target;
        this.f14406d = requestListener;
        this.f14417o = list;
        this.f14407e = requestCoordinator;
        this.f14418p = engine;
        this.f14419q = transitionFactory;
        this.f14420r = executor;
        this.f14424v = EnumC3747b.PENDING;
        if (this.f14402B == null && glideContext.m45629i()) {
            this.f14402B = new RuntimeException("Glide request origin trace");
        }
    }

    /* renamed from: t */
    private boolean m44541t() {
        RequestCoordinator requestCoordinator = this.f14407e;
        return requestCoordinator == null || !requestCoordinator.mo44532b();
    }

    /* renamed from: u */
    private synchronized boolean m44540u(SingleRequest<?> singleRequest) {
        boolean z;
        synchronized (singleRequest) {
            List<RequestListener<R>> list = this.f14417o;
            int size = list == null ? 0 : list.size();
            List<RequestListener<?>> list2 = singleRequest.f14417o;
            z = size == (list2 == null ? 0 : list2.size());
        }
        return z;
    }

    /* renamed from: v */
    private Drawable m44539v(@DrawableRes int i) {
        return DrawableDecoderCompat.m44883a(this.f14409g, i, this.f14412j.m44644T() != null ? this.f14412j.m44644T() : this.f14408f.getTheme());
    }

    /* renamed from: w */
    private void m44538w(String str) {
        Log.v(f14397C, str + " this: " + this.f14404b);
    }

    /* renamed from: x */
    private static int m44537x(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    /* renamed from: y */
    private void m44536y() {
        RequestCoordinator requestCoordinator = this.f14407e;
        if (requestCoordinator != null) {
            requestCoordinator.mo44526h(this);
        }
    }

    /* renamed from: z */
    private void m44535z() {
        RequestCoordinator requestCoordinator = this.f14407e;
        if (requestCoordinator != null) {
            requestCoordinator.mo44523k(this);
        }
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: a */
    public synchronized boolean mo44533a() {
        return this.f14424v == EnumC3747b.COMPLETE;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    /* renamed from: b */
    public synchronized void mo44552b(GlideException glideException) {
        m44556B(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /* renamed from: c */
    public synchronized void mo44551c(Resource<?> resource, DataSource dataSource) {
        this.f14405c.mo44343c();
        this.f14422t = null;
        if (resource == null) {
            mo44552b(new GlideException("Expected to receive a Resource<R> with an object of " + this.f14411i + " inside, but instead got null."));
            return;
        }
        Object obj = resource.get();
        if (obj != null && this.f14411i.isAssignableFrom(obj.getClass())) {
            if (!m44547n()) {
                m44554D(resource);
                this.f14424v = EnumC3747b.COMPLETE;
                return;
            }
            m44555C(resource, obj, dataSource);
            return;
        }
        m44554D(resource);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f14411i);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(resource);
        sb.append("}.");
        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        mo44552b(new GlideException(sb.toString()));
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public synchronized void clear() {
        m44550k();
        this.f14405c.mo44343c();
        EnumC3747b enumC3747b = this.f14424v;
        EnumC3747b enumC3747b2 = EnumC3747b.CLEARED;
        if (enumC3747b == enumC3747b2) {
            return;
        }
        m44546o();
        Resource<R> resource = this.f14421s;
        if (resource != null) {
            m44554D(resource);
        }
        if (m44549l()) {
            this.f14416n.mo44471j(m44543r());
        }
        this.f14424v = enumC3747b2;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: d */
    public synchronized boolean mo44530d() {
        return mo44533a();
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    /* renamed from: e */
    public synchronized void mo44365e(int i, int i2) {
        try {
            this.f14405c.mo44343c();
            boolean z = f14400F;
            if (z) {
                m44538w("Got onSizeReady in " + LogTime.m44412a(this.f14423u));
            }
            if (this.f14424v != EnumC3747b.WAITING_FOR_SIZE) {
                return;
            }
            EnumC3747b enumC3747b = EnumC3747b.RUNNING;
            this.f14424v = enumC3747b;
            float m44645S = this.f14412j.m44645S();
            this.f14428z = m44537x(i, m44645S);
            this.f14401A = m44537x(i2, m44645S);
            if (z) {
                m44538w("finished setup for calling load in " + LogTime.m44412a(this.f14423u));
            }
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f14422t = this.f14418p.m45214g(this.f14409g, this.f14410h, this.f14412j.m44647R(), this.f14428z, this.f14401A, this.f14412j.m44649Q(), this.f14411i, this.f14415m, this.f14412j.m44673E(), this.f14412j.m44643U(), this.f14412j.m44628h0(), this.f14412j.m44634c0(), this.f14412j.m44661K(), this.f14412j.m44637a0(), this.f14412j.m44641W(), this.f14412j.m44642V(), this.f14412j.m44663J(), this, this.f14420r);
                if (this.f14424v != enumC3747b) {
                    this.f14422t = null;
                }
                if (z) {
                    m44538w("finished onSizeReady in " + LogTime.m44412a(this.f14423u));
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: f */
    public synchronized boolean mo44528f() {
        return this.f14424v == EnumC3747b.FAILED;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: g */
    public synchronized boolean mo44527g() {
        return this.f14424v == EnumC3747b.CLEARED;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3779f
    @NonNull
    /* renamed from: h */
    public StateVerifier mo44353h() {
        return this.f14405c;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: i */
    public synchronized boolean mo44525i(InterfaceC3744d interfaceC3744d) {
        boolean z = false;
        if (interfaceC3744d instanceof SingleRequest) {
            SingleRequest<?> singleRequest = (SingleRequest) interfaceC3744d;
            synchronized (singleRequest) {
                if (this.f14413k == singleRequest.f14413k && this.f14414l == singleRequest.f14414l && C3771k.m44388c(this.f14410h, singleRequest.f14410h) && this.f14411i.equals(singleRequest.f14411i) && this.f14412j.equals(singleRequest.f14412j) && this.f14415m == singleRequest.f14415m && m44540u(singleRequest)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public synchronized boolean isRunning() {
        boolean z;
        EnumC3747b enumC3747b = this.f14424v;
        if (enumC3747b != EnumC3747b.RUNNING) {
            z = enumC3747b == EnumC3747b.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: j */
    public synchronized void mo44524j() {
        m44550k();
        this.f14405c.mo44343c();
        this.f14423u = LogTime.m44411b();
        if (this.f14410h == null) {
            if (C3771k.m44369v(this.f14413k, this.f14414l)) {
                this.f14428z = this.f14413k;
                this.f14401A = this.f14414l;
            }
            m44556B(new GlideException("Received null model"), m44544q() == null ? 5 : 3);
            return;
        }
        EnumC3747b enumC3747b = this.f14424v;
        EnumC3747b enumC3747b2 = EnumC3747b.RUNNING;
        if (enumC3747b != enumC3747b2) {
            if (enumC3747b == EnumC3747b.COMPLETE) {
                mo44551c(this.f14421s, DataSource.MEMORY_CACHE);
                return;
            }
            EnumC3747b enumC3747b3 = EnumC3747b.WAITING_FOR_SIZE;
            this.f14424v = enumC3747b3;
            if (C3771k.m44369v(this.f14413k, this.f14414l)) {
                mo44365e(this.f14413k, this.f14414l);
            } else {
                this.f14416n.mo44466q(this);
            }
            EnumC3747b enumC3747b4 = this.f14424v;
            if ((enumC3747b4 == enumC3747b2 || enumC3747b4 == enumC3747b3) && m44548m()) {
                this.f14416n.mo44473h(m44543r());
            }
            if (f14400F) {
                m44538w("finished run method in " + LogTime.m44412a(this.f14423u));
            }
            return;
        }
        throw new IllegalArgumentException("Cannot restart a running request");
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public synchronized void recycle() {
        m44550k();
        this.f14408f = null;
        this.f14409g = null;
        this.f14410h = null;
        this.f14411i = null;
        this.f14412j = null;
        this.f14413k = -1;
        this.f14414l = -1;
        this.f14416n = null;
        this.f14417o = null;
        this.f14406d = null;
        this.f14407e = null;
        this.f14419q = null;
        this.f14422t = null;
        this.f14425w = null;
        this.f14426x = null;
        this.f14427y = null;
        this.f14428z = -1;
        this.f14401A = -1;
        this.f14402B = null;
        f14399E.release(this);
    }
}
