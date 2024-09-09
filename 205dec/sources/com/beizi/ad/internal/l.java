package com.beizi.ad.internal;

import android.util.Log;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.network.a;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.StringUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PrefetchAdRequestManagerImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l extends m {

    /* renamed from: a  reason: collision with root package name */
    private com.beizi.ad.internal.network.a f13836a;

    /* renamed from: b  reason: collision with root package name */
    private e f13837b = new e(h.a().e(), StringUtil.createRequestId());

    @Override // com.beizi.ad.internal.f
    public void a() {
        this.f13836a = new com.beizi.ad.internal.network.a(new a.C0126a());
        g();
        try {
            this.f13836a.a(this);
            this.f13836a.executeOnExecutor(com.beizi.ad.lance.a.c.b().c(), new Void[0]);
        } catch (IllegalStateException e4) {
            Log.d("lance", "ignored:" + e4.getMessage());
        } catch (RejectedExecutionException e5) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.e(str, "Concurrent Thread Exception while firing new ad request: " + e5.getMessage());
        }
    }

    @Override // com.beizi.ad.internal.f
    public e c() {
        return this.f13837b;
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.b.a d() {
        return null;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        com.beizi.ad.internal.network.a aVar = this.f13836a;
        if (aVar != null) {
            aVar.cancel(true);
            this.f13836a = null;
        }
        a((LinkedList<com.beizi.ad.internal.a.a>) null);
    }

    @Override // com.beizi.ad.internal.f
    public void a(int i4) {
        String str = HaoboLog.pbLogTag;
        HaoboLog.d(str, "Failed to load prefetch request: " + i4);
    }

    @Override // com.beizi.ad.internal.f
    public void a(ServerResponse serverResponse) {
        Iterator<String> it = serverResponse.getPrefetchResources().iterator();
        while (it.hasNext()) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.d(str, "Prefetch resource: " + it.next());
        }
    }
}
