package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.e;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.i;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AdEventDispatcher.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    private e<T> f555a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f556b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f557c = new AtomicBoolean(false);

    public b(String str, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a<T> aVar, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a<T> aVar2, e.b bVar, e.a aVar3) {
        this.f555a = new e<>(str, aVar, aVar2, bVar, aVar3);
    }

    public synchronized void a() {
        AtomicBoolean atomicBoolean = this.f557c;
        if ((atomicBoolean == null || !atomicBoolean.get()) && this.f555a.getLooper() == null) {
            AtomicBoolean atomicBoolean2 = this.f557c;
            if (atomicBoolean2 != null && !atomicBoolean2.get()) {
                this.f555a.start();
                Handler handler = new Handler(this.f555a.getLooper(), this.f555a);
                this.f556b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f556b.sendMessage(obtainMessage);
                this.f557c.set(true);
            }
        }
    }

    public void a(@NonNull T t3) {
        if (this.f557c.get()) {
            Message obtainMessage = this.f556b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t3;
            this.f556b.sendMessage(obtainMessage);
        }
    }
}
