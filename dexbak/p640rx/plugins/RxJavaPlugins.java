package p640rx.plugins;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.plugins.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class RxJavaPlugins {

    /* renamed from: f */
    private static final RxJavaPlugins f46958f = new RxJavaPlugins();

    /* renamed from: g */
    static final RxJavaErrorHandler f46959g = new C16156a();

    /* renamed from: a */
    private final AtomicReference<RxJavaErrorHandler> f46960a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<RxJavaObservableExecutionHook> f46961b = new AtomicReference<>();

    /* renamed from: c */
    private final AtomicReference<RxJavaSingleExecutionHook> f46962c = new AtomicReference<>();

    /* renamed from: d */
    private final AtomicReference<RxJavaCompletableExecutionHook> f46963d = new AtomicReference<>();

    /* renamed from: e */
    private final AtomicReference<RxJavaSchedulersHook> f46964e = new AtomicReference<>();

    /* compiled from: RxJavaPlugins.java */
    /* renamed from: rx.plugins.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16156a extends RxJavaErrorHandler {
        C16156a() {
        }
    }

    /* compiled from: RxJavaPlugins.java */
    /* renamed from: rx.plugins.f$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16157b extends RxJavaCompletableExecutionHook {
        C16157b() {
        }
    }

    RxJavaPlugins() {
    }

    @Deprecated
    /* renamed from: c */
    public static RxJavaPlugins m507c() {
        return f46958f;
    }

    /* renamed from: e */
    static Object m505e(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 == null) {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                    property = property2;
                }
            }
        }
        if (property != null) {
            try {
                return Class.forName(property).asSubclass(cls).newInstance();
            } catch (ClassCastException e) {
                throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException(simpleName + " implementation class not found: " + property, e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e3);
            } catch (InstantiationException e4) {
                throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e4);
            }
        }
        return null;
    }

    /* renamed from: a */
    public RxJavaCompletableExecutionHook m509a() {
        if (this.f46963d.get() == null) {
            Object m505e = m505e(RxJavaCompletableExecutionHook.class, System.getProperties());
            if (m505e == null) {
                this.f46963d.compareAndSet(null, new C16157b());
            } else {
                this.f46963d.compareAndSet(null, (RxJavaCompletableExecutionHook) m505e);
            }
        }
        return this.f46963d.get();
    }

    /* renamed from: b */
    public RxJavaErrorHandler m508b() {
        if (this.f46960a.get() == null) {
            Object m505e = m505e(RxJavaErrorHandler.class, System.getProperties());
            if (m505e == null) {
                this.f46960a.compareAndSet(null, f46959g);
            } else {
                this.f46960a.compareAndSet(null, (RxJavaErrorHandler) m505e);
            }
        }
        return this.f46960a.get();
    }

    /* renamed from: d */
    public RxJavaObservableExecutionHook m506d() {
        if (this.f46961b.get() == null) {
            Object m505e = m505e(RxJavaObservableExecutionHook.class, System.getProperties());
            if (m505e == null) {
                this.f46961b.compareAndSet(null, RxJavaObservableExecutionHookDefault.m510f());
            } else {
                this.f46961b.compareAndSet(null, (RxJavaObservableExecutionHook) m505e);
            }
        }
        return this.f46961b.get();
    }

    /* renamed from: f */
    public RxJavaSchedulersHook m504f() {
        if (this.f46964e.get() == null) {
            Object m505e = m505e(RxJavaSchedulersHook.class, System.getProperties());
            if (m505e == null) {
                this.f46964e.compareAndSet(null, RxJavaSchedulersHook.m489h());
            } else {
                this.f46964e.compareAndSet(null, (RxJavaSchedulersHook) m505e);
            }
        }
        return this.f46964e.get();
    }

    /* renamed from: g */
    public RxJavaSingleExecutionHook m503g() {
        if (this.f46962c.get() == null) {
            Object m505e = m505e(RxJavaSingleExecutionHook.class, System.getProperties());
            if (m505e == null) {
                this.f46962c.compareAndSet(null, RxJavaSingleExecutionHookDefault.m480f());
            } else {
                this.f46962c.compareAndSet(null, (RxJavaSingleExecutionHook) m505e);
            }
        }
        return this.f46962c.get();
    }

    /* renamed from: h */
    public void m502h(RxJavaCompletableExecutionHook rxJavaCompletableExecutionHook) {
        if (this.f46963d.compareAndSet(null, rxJavaCompletableExecutionHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f46962c.get());
    }

    /* renamed from: i */
    public void m501i(RxJavaErrorHandler rxJavaErrorHandler) {
        if (this.f46960a.compareAndSet(null, rxJavaErrorHandler)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f46960a.get());
    }

    /* renamed from: j */
    public void m500j(RxJavaObservableExecutionHook rxJavaObservableExecutionHook) {
        if (this.f46961b.compareAndSet(null, rxJavaObservableExecutionHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f46961b.get());
    }

    /* renamed from: k */
    public void m499k(RxJavaSchedulersHook rxJavaSchedulersHook) {
        if (this.f46964e.compareAndSet(null, rxJavaSchedulersHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f46964e.get());
    }

    /* renamed from: l */
    public void m498l(RxJavaSingleExecutionHook rxJavaSingleExecutionHook) {
        if (this.f46962c.compareAndSet(null, rxJavaSingleExecutionHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f46962c.get());
    }

    /* renamed from: m */
    public void m497m() {
        RxJavaPlugins rxJavaPlugins = f46958f;
        rxJavaPlugins.f46960a.set(null);
        rxJavaPlugins.f46961b.set(null);
        rxJavaPlugins.f46962c.set(null);
        rxJavaPlugins.f46963d.set(null);
        rxJavaPlugins.f46964e.set(null);
    }
}
