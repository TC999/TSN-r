package xyz.adscope.common.network.connect;

import android.content.Context;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RealTimeNetwork implements Network {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64869a;

    /* renamed from: b  reason: collision with root package name */
    public final NetworkChecker f64870b;

    public RealTimeNetwork(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f64869a = origApplicationContext;
        this.f64870b = new NetworkChecker(origApplicationContext);
    }

    @Override // xyz.adscope.common.network.connect.Network
    public boolean isAvailable() {
        return this.f64870b.isAvailable();
    }
}
