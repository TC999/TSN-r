package rx.android.schedulers;

import android.os.Looper;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AndroidSchedulers.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f62072b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final h f62073a;

    private a() {
        h b4 = rx.android.plugins.a.a().b().b();
        if (b4 != null) {
            this.f62073a = b4;
        } else {
            this.f62073a = new c(Looper.getMainLooper());
        }
    }

    public static h a(Looper looper) {
        if (looper != null) {
            return new c(looper);
        }
        throw new NullPointerException("looper == null");
    }

    public static h b() {
        return f62072b.f62073a;
    }
}
