package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.annotation.SuppressLint;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetClient;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTNetClient {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    private static volatile TTNetClient f624b;

    /* renamed from: a */
    private final NetClient f625a;

    private TTNetClient(Context context) {
        if (context == null) {
            InternalContainer.m59945d();
        } else {
            context.getApplicationContext();
        }
        NetClient.C0995b c0995b = new NetClient.C0995b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f625a = c0995b.m59079a(10000L, timeUnit).m59076b(10000L, timeUnit).m59075c(10000L, timeUnit).m59077a(true).m59080a();
    }

    /* renamed from: b */
    public static TTNetClient m59292b() {
        if (f624b == null) {
            synchronized (TTNetClient.class) {
                if (f624b == null) {
                    f624b = new TTNetClient(InternalContainer.m59945d());
                }
            }
        }
        return f624b;
    }

    /* renamed from: a */
    public NetClient m59293a() {
        return this.f625a;
    }
}
