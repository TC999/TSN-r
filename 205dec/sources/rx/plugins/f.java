package rx.plugins;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: RxJavaPlugins.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    private static final f f64227f = new f();

    /* renamed from: g  reason: collision with root package name */
    static final rx.plugins.b f64228g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<rx.plugins.b> f64229a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<d> f64230b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<h> f64231c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<rx.plugins.a> f64232d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<g> f64233e = new AtomicReference<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaPlugins.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a extends rx.plugins.b {
        a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaPlugins.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class b extends rx.plugins.a {
        b() {
        }
    }

    f() {
    }

    @Deprecated
    public static f c() {
        return f64227f;
    }

    static Object e(Class<?> cls, Properties properties) {
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
            } catch (ClassCastException e4) {
                throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(simpleName + " implementation class not found: " + property, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e7);
            }
        }
        return null;
    }

    public rx.plugins.a a() {
        if (this.f64232d.get() == null) {
            Object e4 = e(rx.plugins.a.class, System.getProperties());
            if (e4 == null) {
                this.f64232d.compareAndSet(null, new b());
            } else {
                this.f64232d.compareAndSet(null, (rx.plugins.a) e4);
            }
        }
        return this.f64232d.get();
    }

    public rx.plugins.b b() {
        if (this.f64229a.get() == null) {
            Object e4 = e(rx.plugins.b.class, System.getProperties());
            if (e4 == null) {
                this.f64229a.compareAndSet(null, f64228g);
            } else {
                this.f64229a.compareAndSet(null, (rx.plugins.b) e4);
            }
        }
        return this.f64229a.get();
    }

    public d d() {
        if (this.f64230b.get() == null) {
            Object e4 = e(d.class, System.getProperties());
            if (e4 == null) {
                this.f64230b.compareAndSet(null, e.f());
            } else {
                this.f64230b.compareAndSet(null, (d) e4);
            }
        }
        return this.f64230b.get();
    }

    public g f() {
        if (this.f64233e.get() == null) {
            Object e4 = e(g.class, System.getProperties());
            if (e4 == null) {
                this.f64233e.compareAndSet(null, g.h());
            } else {
                this.f64233e.compareAndSet(null, (g) e4);
            }
        }
        return this.f64233e.get();
    }

    public h g() {
        if (this.f64231c.get() == null) {
            Object e4 = e(h.class, System.getProperties());
            if (e4 == null) {
                this.f64231c.compareAndSet(null, i.f());
            } else {
                this.f64231c.compareAndSet(null, (h) e4);
            }
        }
        return this.f64231c.get();
    }

    public void h(rx.plugins.a aVar) {
        if (this.f64232d.compareAndSet(null, aVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f64231c.get());
    }

    public void i(rx.plugins.b bVar) {
        if (this.f64229a.compareAndSet(null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f64229a.get());
    }

    public void j(d dVar) {
        if (this.f64230b.compareAndSet(null, dVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f64230b.get());
    }

    public void k(g gVar) {
        if (this.f64233e.compareAndSet(null, gVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f64233e.get());
    }

    public void l(h hVar) {
        if (this.f64231c.compareAndSet(null, hVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f64231c.get());
    }

    public void m() {
        f fVar = f64227f;
        fVar.f64229a.set(null);
        fVar.f64230b.set(null);
        fVar.f64231c.set(null);
        fVar.f64232d.set(null);
        fVar.f64233e.set(null);
    }
}
