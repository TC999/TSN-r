package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f41640a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f41641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, boolean z3) {
        this.f41641b = aVar;
        this.f41640a = z3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f41641b.f41634d.getPOFactory(this.f41640a, true);
            this.f41641b.f41632b = true;
        } catch (e e4) {
            GDTLogger.e(e4.getMessage(), e4);
        }
    }
}
