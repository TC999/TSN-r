package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationHandler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class m extends Handler {

    /* renamed from: b  reason: collision with root package name */
    static final int f61875b = -1;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<e> f61876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        super(Looper.getMainLooper());
        this.f61876a = new WeakReference<>(eVar);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        e eVar = this.f61876a.get();
        if (eVar == null) {
            return;
        }
        if (message.what == -1) {
            eVar.invalidateSelf();
            return;
        }
        Iterator<a> it = eVar.f61831h.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }
}
