package xyz.adscope.common.network;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CancelerManager {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Request, Canceller> f64770a = new ConcurrentHashMap();

    public void addCancel(Request request, Canceller canceller) {
        this.f64770a.put(request, canceller);
    }

    public void cancel(Object obj) {
        for (Map.Entry<Request, Canceller> entry : this.f64770a.entrySet()) {
            Object tag = entry.getKey().tag();
            if (obj == tag || (obj != null && obj.equals(tag))) {
                entry.getValue().cancel();
            }
        }
    }

    public void removeCancel(Request request) {
        this.f64770a.remove(request);
    }
}
