package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.Lynx;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Leo extends Thread {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lynx.Cdo f52111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f52112d;

    public Leo(Lynx.Cdo cdo, Context context) {
        this.f52111c = cdo;
        this.f52112d = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f52111c.f52145a.b(this.f52112d);
    }
}
