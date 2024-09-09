package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static volatile q f12905a;

    /* renamed from: b  reason: collision with root package name */
    private List<aa.a> f12906b = new CopyOnWriteArrayList();

    private q() {
    }

    public static q a() {
        if (f12905a == null) {
            synchronized (q.class) {
                if (f12905a == null) {
                    f12905a = new q();
                }
            }
        }
        return f12905a;
    }

    private void b(aa.a aVar) {
        if (this.f12906b.contains(aVar)) {
            this.f12906b.remove(aVar);
        }
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.f12906b.contains(aVar)) {
            return;
        }
        this.f12906b.add(aVar);
    }

    public void a(int i4) {
        for (aa.a aVar : this.f12906b) {
            if (i4 == 1) {
                aVar.onSuccess();
            } else if (i4 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
