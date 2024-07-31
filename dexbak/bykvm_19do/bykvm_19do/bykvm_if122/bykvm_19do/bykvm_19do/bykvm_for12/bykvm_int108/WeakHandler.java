package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class WeakHandler extends Handler {

    /* renamed from: a */
    private final WeakReference<InterfaceC1009a> f791a;

    /* compiled from: WeakHandler.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1009a {
        void handleMsg(Message message);
    }

    public WeakHandler(Looper looper, InterfaceC1009a interfaceC1009a) {
        super(looper);
        this.f791a = new WeakReference<>(interfaceC1009a);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        InterfaceC1009a interfaceC1009a = this.f791a.get();
        if (interfaceC1009a == null || message == null) {
            return;
        }
        interfaceC1009a.handleMsg(message);
    }
}
