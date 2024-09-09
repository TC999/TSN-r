package xyz.adscope.common.network.connect.http;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Response;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Call {

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f64877e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public final Request f64878a;

    /* renamed from: b  reason: collision with root package name */
    public ConnectInterceptor f64879b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64880c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64881d;

    public Call(Request request) {
        this.f64878a = request;
    }

    public void asyncCancel() {
        f64877e.execute(new Runnable() { // from class: xyz.adscope.common.network.connect.http.Call.1
            @Override // java.lang.Runnable
            public void run() {
                Call.this.cancel();
            }
        });
    }

    public void cancel() {
        if (this.f64881d) {
            return;
        }
        this.f64881d = true;
        ConnectInterceptor connectInterceptor = this.f64879b;
        if (connectInterceptor != null) {
            connectInterceptor.cancel();
        }
    }

    public Response execute() {
        if (this.f64881d) {
            throw new CancellationException("The request has been cancelled.");
        }
        this.f64880c = true;
        ArrayList arrayList = new ArrayList(Kalle.getConfig().getInterceptor());
        ConnectInterceptor connectInterceptor = new ConnectInterceptor();
        this.f64879b = connectInterceptor;
        arrayList.add(connectInterceptor);
        try {
            return new AppChain(arrayList, 0, this.f64878a, this).proceed(this.f64878a);
        } catch (Exception e4) {
            if (this.f64881d) {
                throw new CancellationException("The request has been cancelled.");
            }
            throw e4;
        }
    }

    public boolean isCanceled() {
        return this.f64881d;
    }

    public boolean isExecuted() {
        return this.f64880c;
    }
}
