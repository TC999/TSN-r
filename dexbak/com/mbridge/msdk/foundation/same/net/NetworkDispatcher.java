package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Process;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.BasicNetwork;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.stack.HttpStack;
import com.mbridge.msdk.foundation.same.net.stack.OkHttpStack;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.mbridge.msdk.foundation.same.net.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NetworkDispatcher {

    /* renamed from: a */
    private static final String f30833a = "h";

    /* renamed from: b */
    private HttpStack f30834b = new OkHttpStack();

    /* renamed from: c */
    private Network f30835c;

    /* renamed from: d */
    private Delivery f30836d;

    public NetworkDispatcher(Context context, SSLSocketFactory sSLSocketFactory, Delivery delivery) {
        this.f30835c = new BasicNetwork(this.f30834b, delivery);
        this.f30836d = delivery;
    }

    /* renamed from: a */
    public final void m22212a(AbstractC11354i abstractC11354i) {
        Process.setThreadPriority(10);
        try {
            String str = f30833a;
            SameLogTool.m21736b(str, "network-queue-take request=" + abstractC11354i.m22198b());
            this.f30836d.mo22284c(abstractC11354i);
            if (abstractC11354i.m22196c()) {
                abstractC11354i.m22200a("network-discard-cancelled");
                this.f30836d.mo22285b(abstractC11354i);
                this.f30836d.mo22289a(abstractC11354i);
            } else {
                this.f30836d.mo22283d(abstractC11354i);
                NetworkResponse mo22237a = this.f30835c.mo22237a(abstractC11354i);
                SameLogTool.m21736b(str, "network-http-complete networkResponse=" + mo22237a.f30751a);
                C11356k<?> mo22205a = abstractC11354i.mo22205a(mo22237a);
                SameLogTool.m21736b(str, "network-parse-complete response=" + mo22205a.f30855a);
                this.f30836d.mo22286a(abstractC11354i, mo22205a);
            }
        } catch (CommonError e) {
            this.f30836d.mo22287a(abstractC11354i, e);
        } catch (Exception e2) {
            String str2 = f30833a;
            SameLogTool.m21733d(str2, "Unhandled exception " + e2.getMessage());
            this.f30836d.mo22287a(abstractC11354i, new CommonError(4, null));
        }
    }
}
