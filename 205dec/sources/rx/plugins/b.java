package rx.plugins;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: RxJavaErrorHandler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f64204a = ".errorRendering";

    @Deprecated
    public void a(Throwable th) {
    }

    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String c(Object obj) throws InterruptedException {
        return null;
    }
}
