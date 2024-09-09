package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.Cinstanceof;
import com.tencent.turingfd.sdk.ams.au.Vulpecula;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.implements  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cimplements implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f52320c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Cinstanceof.Cdo f52321d;

    public Cimplements(Cinstanceof.Cdo cdo, int i4) {
        this.f52321d = cdo;
        this.f52320c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        if (!Octans.b(context)) {
            return;
        }
        int i4 = 0;
        while (true) {
            String[] strArr = this.f52321d.f52322a;
            if (i4 >= strArr.length) {
                return;
            }
            try {
                Vulpecula.Cdo cdo = new Vulpecula.Cdo(strArr[i4]);
                int i5 = this.f52320c;
                if (i5 > 0) {
                    cdo.f52219d = i5;
                }
                if (i5 > 0) {
                    cdo.f52220e = i5;
                }
                Vulpecula vulpecula = new Vulpecula(cdo);
                Csynchronized.a(vulpecula, vulpecula.f52210a, vulpecula.f52212c);
                this.f52321d.f52323b = i4;
                return;
            } catch (Throwable unused) {
                i4++;
            }
        }
    }
}
