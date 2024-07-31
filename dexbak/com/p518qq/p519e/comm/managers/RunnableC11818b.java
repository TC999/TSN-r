package com.p518qq.p519e.comm.managers;

import com.p518qq.p519e.comm.managers.plugin.C11828e;
import com.p518qq.p519e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.qq.e.comm.managers.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC11818b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f32906a;

    /* renamed from: b */
    final /* synthetic */ C11815a f32907b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC11818b(C11815a c11815a, boolean z) {
        this.f32907b = c11815a;
        this.f32906a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f32907b.f32900d.getPOFactory(this.f32906a, true);
            this.f32907b.f32898b = true;
        } catch (C11828e e) {
            GDTLogger.m20306e(e.getMessage(), e);
        }
    }
}
