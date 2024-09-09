package xyz.adscope.common.network.connect.http;

import java.util.List;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.Interceptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppChain implements Chain {

    /* renamed from: a  reason: collision with root package name */
    public final List<Interceptor> f64873a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64874b;

    /* renamed from: c  reason: collision with root package name */
    public final Request f64875c;

    /* renamed from: d  reason: collision with root package name */
    public Call f64876d;

    public AppChain(List<Interceptor> list, int i4, Request request, Call call) {
        this.f64873a = list;
        this.f64874b = i4;
        this.f64875c = request;
        this.f64876d = call;
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Call call() {
        return this.f64876d;
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Call newCall() {
        return this.f64876d;
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Response proceed(Request request) {
        return this.f64873a.get(this.f64874b).intercept(new AppChain(this.f64873a, this.f64874b + 1, request, this.f64876d));
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Request request() {
        return this.f64875c;
    }
}
