package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventThread;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.EventFace;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventDispatcher<T extends EventFace> {

    /* renamed from: a */
    private AdEventThread<T> f562a;

    /* renamed from: b */
    private Handler f563b;

    /* renamed from: c */
    private AtomicBoolean f564c = new AtomicBoolean(false);

    public AdEventDispatcher(String str, AdEventRepertory<T> adEventRepertory, ReportNetApi<T> reportNetApi, AdEventThread.C0977b c0977b, AdEventThread.InterfaceC0976a interfaceC0976a) {
        this.f562a = new AdEventThread<>(str, adEventRepertory, reportNetApi, c0977b, interfaceC0976a);
    }

    /* renamed from: a */
    public synchronized void m59439a() {
        AtomicBoolean atomicBoolean = this.f564c;
        if ((atomicBoolean == null || !atomicBoolean.get()) && this.f562a.getLooper() == null) {
            AtomicBoolean atomicBoolean2 = this.f564c;
            if (atomicBoolean2 != null && !atomicBoolean2.get()) {
                this.f562a.start();
                Handler handler = new Handler(this.f562a.getLooper(), this.f562a);
                this.f563b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f563b.sendMessage(obtainMessage);
                this.f564c.set(true);
            }
        }
    }

    /* renamed from: a */
    public void m59438a(@NonNull T t) {
        if (this.f564c.get()) {
            Message obtainMessage = this.f563b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.f563b.sendMessage(obtainMessage);
        }
    }
}
