package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import com.bumptech.glide.util.C3771k;
import com.stub.StubApp;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager.java */
/* renamed from: com.bumptech.glide.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3558j implements LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {

    /* renamed from: l */
    private static final RequestOptions f13449l = RequestOptions.m44579W0(Bitmap.class).m44622k0();

    /* renamed from: m */
    private static final RequestOptions f13450m = RequestOptions.m44579W0(GifDrawable.class).m44622k0();

    /* renamed from: n */
    private static final RequestOptions f13451n = RequestOptions.m44578X0(DiskCacheStrategy.f13788c).m44597y0(Priority.LOW).m44668G0(true);

    /* renamed from: a */
    protected final Glide f13452a;

    /* renamed from: b */
    protected final Context f13453b;

    /* renamed from: c */
    final Lifecycle f13454c;
    @GuardedBy("this")

    /* renamed from: d */
    private final RequestTracker f13455d;
    @GuardedBy("this")

    /* renamed from: e */
    private final RequestManagerTreeNode f13456e;
    @GuardedBy("this")

    /* renamed from: f */
    private final TargetTracker f13457f;

    /* renamed from: g */
    private final Runnable f13458g;

    /* renamed from: h */
    private final Handler f13459h;

    /* renamed from: i */
    private final ConnectivityMonitor f13460i;

    /* renamed from: j */
    private final CopyOnWriteArrayList<RequestListener<Object>> f13461j;
    @GuardedBy("this")

    /* renamed from: k */
    private RequestOptions f13462k;

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class RunnableC3559a implements Runnable {
        RunnableC3559a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3558j c3558j = C3558j.this;
            c3558j.f13454c.mo44761b(c3558j);
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.j$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3560b extends ViewTarget<View, Object> {
        C3560b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: k */
        public void mo44364k(@NonNull Object obj, @Nullable InterfaceC3759f<? super Object> interfaceC3759f) {
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.j$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3561c implements ConnectivityMonitor.InterfaceC3736a {
        @GuardedBy("RequestManager.this")

        /* renamed from: a */
        private final RequestTracker f13464a;

        C3561c(@NonNull RequestTracker requestTracker) {
            this.f13464a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.InterfaceC3736a
        /* renamed from: a */
        public void mo44767a(boolean z) {
            if (z) {
                synchronized (C3558j.this) {
                    this.f13464a.m44718h();
                }
            }
        }
    }

    public C3558j(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.m45740h(), context);
    }

    /* renamed from: Y */
    private void m45509Y(@NonNull Target<?> target) {
        if (m45510X(target) || this.f13452a.m45727u(target) || target.mo44472i() == null) {
            return;
        }
        InterfaceC3744d mo44472i = target.mo44472i();
        target.mo44469m(null);
        mo44472i.clear();
    }

    /* renamed from: Z */
    private synchronized void m45508Z(@NonNull RequestOptions requestOptions) {
        this.f13462k = this.f13462k.mo44636b(requestOptions);
    }

    @NonNull
    @CheckResult
    /* renamed from: A */
    public RequestBuilder<File> m45533A(@Nullable Object obj) {
        return m45532B().mo45500o(obj);
    }

    @NonNull
    @CheckResult
    /* renamed from: B */
    public RequestBuilder<File> m45532B() {
        return m45496t(File.class).mo44636b(f13451n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public List<RequestListener<Object>> m45531C() {
        return this.f13461j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public synchronized RequestOptions m45530D() {
        return this.f13462k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: E */
    public <T> TransitionOptions<?, T> m45529E(Class<T> cls) {
        return this.f13452a.m45739i().m45633e(cls);
    }

    /* renamed from: F */
    public synchronized boolean m45528F() {
        return this.f13455d.m44721e();
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: G */
    public RequestBuilder<Drawable> mo45501l(@Nullable Bitmap bitmap) {
        return m45494v().mo45501l(bitmap);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: H */
    public RequestBuilder<Drawable> mo45502g(@Nullable Drawable drawable) {
        return m45494v().mo45502g(drawable);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: I */
    public RequestBuilder<Drawable> mo45505d(@Nullable Uri uri) {
        return m45494v().mo45505d(uri);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: J */
    public RequestBuilder<Drawable> mo45503f(@Nullable File file) {
        return m45494v().mo45503f(file);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: K */
    public RequestBuilder<Drawable> mo45499p(@Nullable @DrawableRes @RawRes Integer num) {
        return m45494v().mo45499p(num);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: L */
    public RequestBuilder<Drawable> mo45500o(@Nullable Object obj) {
        return m45494v().mo45500o(obj);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: M */
    public RequestBuilder<Drawable> mo45507a(@Nullable String str) {
        return m45494v().mo45507a(str);
    }

    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* renamed from: N */
    public RequestBuilder<Drawable> mo45506c(@Nullable URL url) {
        return m45494v().mo45506c(url);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: O */
    public RequestBuilder<Drawable> mo45504e(@Nullable byte[] bArr) {
        return m45494v().mo45504e(bArr);
    }

    /* renamed from: P */
    public synchronized void m45518P() {
        this.f13455d.m44720f();
    }

    /* renamed from: Q */
    public synchronized void m45517Q() {
        this.f13455d.m44719g();
    }

    /* renamed from: R */
    public synchronized void m45516R() {
        m45517Q();
        for (C3558j c3558j : this.f13456e.mo44726a()) {
            c3558j.m45517Q();
        }
    }

    /* renamed from: S */
    public synchronized void m45515S() {
        this.f13455d.m44717i();
    }

    /* renamed from: T */
    public synchronized void m45514T() {
        C3771k.m44389b();
        m45515S();
        for (C3558j c3558j : this.f13456e.mo44726a()) {
            c3558j.m45515S();
        }
    }

    @NonNull
    /* renamed from: U */
    public synchronized C3558j m45513U(@NonNull RequestOptions requestOptions) {
        m45512V(requestOptions);
        return this;
    }

    /* renamed from: V */
    protected synchronized void m45512V(@NonNull RequestOptions requestOptions) {
        this.f13462k = requestOptions.clone().m44629h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: W */
    public synchronized void m45511W(@NonNull Target<?> target, @NonNull InterfaceC3744d interfaceC3744d) {
        this.f13457f.m44713d(target);
        this.f13455d.m44716j(interfaceC3744d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: X */
    public synchronized boolean m45510X(@NonNull Target<?> target) {
        InterfaceC3744d mo44472i = target.mo44472i();
        if (mo44472i == null) {
            return true;
        }
        if (this.f13455d.m44723c(mo44472i)) {
            this.f13457f.m44712e(target);
            target.mo44469m(null);
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.f13457f.onDestroy();
        for (Target<?> target : this.f13457f.m44714c()) {
            m45490z(target);
        }
        this.f13457f.m44715a();
        this.f13455d.m44722d();
        this.f13454c.mo44762a(this);
        this.f13454c.mo44762a(this.f13460i);
        this.f13459h.removeCallbacks(this.f13458g);
        this.f13452a.m45722z(this);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        m45515S();
        this.f13457f.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        m45517Q();
        this.f13457f.onStop();
    }

    /* renamed from: r */
    public C3558j m45498r(RequestListener<Object> requestListener) {
        this.f13461j.add(requestListener);
        return this;
    }

    @NonNull
    /* renamed from: s */
    public synchronized C3558j m45497s(@NonNull RequestOptions requestOptions) {
        m45508Z(requestOptions);
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: t */
    public <ResourceType> RequestBuilder<ResourceType> m45496t(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f13452a, this, cls, this.f13453b);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f13455d + ", treeNode=" + this.f13456e + "}";
    }

    @NonNull
    @CheckResult
    /* renamed from: u */
    public RequestBuilder<Bitmap> m45495u() {
        return m45496t(Bitmap.class).mo44636b(f13449l);
    }

    @NonNull
    @CheckResult
    /* renamed from: v */
    public RequestBuilder<Drawable> m45494v() {
        return m45496t(Drawable.class);
    }

    @NonNull
    @CheckResult
    /* renamed from: w */
    public RequestBuilder<File> m45493w() {
        return m45496t(File.class).mo44636b(RequestOptions.m44559q1(true));
    }

    @NonNull
    @CheckResult
    /* renamed from: x */
    public RequestBuilder<GifDrawable> m45492x() {
        return m45496t(GifDrawable.class).mo44636b(f13450m);
    }

    /* renamed from: y */
    public void m45491y(@NonNull View view) {
        m45490z(new C3560b(view));
    }

    /* renamed from: z */
    public synchronized void m45490z(@Nullable Target<?> target) {
        if (target == null) {
            return;
        }
        m45509Y(target);
    }

    C3558j(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f13457f = new TargetTracker();
        RunnableC3559a runnableC3559a = new RunnableC3559a();
        this.f13458g = runnableC3559a;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f13459h = handler;
        this.f13452a = glide;
        this.f13454c = lifecycle;
        this.f13456e = requestManagerTreeNode;
        this.f13455d = requestTracker;
        this.f13453b = context;
        ConnectivityMonitor mo44763a = connectivityMonitorFactory.mo44763a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new C3561c(requestTracker));
        this.f13460i = mo44763a;
        if (C3771k.m44372s()) {
            handler.post(runnableC3559a);
        } else {
            lifecycle.mo44761b(this);
        }
        lifecycle.mo44761b(mo44763a);
        this.f13461j = new CopyOnWriteArrayList<>(glide.m45739i().m45635c());
        m45512V(glide.m45739i().m45634d());
        glide.m45728t(this);
    }
}
