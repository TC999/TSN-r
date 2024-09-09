package l0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f60802a;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface a {
        void c(Message message);
    }

    public d(Looper looper, a aVar) {
        super(looper);
        this.f60802a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f60802a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.c(message);
    }
}
