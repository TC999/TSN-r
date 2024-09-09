package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.annotation.SuppressLint;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.concurrent.TimeUnit;

/* compiled from: TTNetClient.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f617b;

    /* renamed from: a  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a f618a;

    private b(Context context) {
        if (context == null) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d();
        } else {
            context.getApplicationContext();
        }
        a.b bVar = new a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f618a = bVar.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).b(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).c(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).a(true).a();
    }

    public static b b() {
        if (f617b == null) {
            synchronized (b.class) {
                if (f617b == null) {
                    f617b = new b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
                }
            }
        }
        return f617b;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a a() {
        return this.f618a;
    }
}
