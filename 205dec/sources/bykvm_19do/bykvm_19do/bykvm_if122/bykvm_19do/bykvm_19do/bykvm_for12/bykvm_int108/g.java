package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f784a;

    /* compiled from: WeakHandler.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void handleMsg(Message message);
    }

    public g(Looper looper, a aVar) {
        super(looper);
        this.f784a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f784a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.handleMsg(message);
    }
}
