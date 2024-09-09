package com.bytedance.embedapplog;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia extends bk {

    /* renamed from: w  reason: collision with root package name */
    private static final long[] f26748w = {60000};
    private boolean sr;
    private long xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(ys ysVar) {
        super(ysVar);
        this.sr = true;
    }

    public void c(boolean z3) {
        Log.d("xgc_apm", "set:" + z3);
        this.sr = z3;
    }

    @Override // com.bytedance.embedapplog.bk
    String sr() {
        return "s";
    }

    @Override // com.bytedance.embedapplog.bk
    long[] w() {
        return f26748w;
    }

    @Override // com.bytedance.embedapplog.bk
    public boolean xv() {
        Bundle c4;
        long currentTimeMillis = System.currentTimeMillis();
        s r3 = this.f26705c.r();
        if (r3 != null && (c4 = r3.c(currentTimeMillis, 50000L)) != null) {
            c.c("play_session", c4, 1);
            c.c();
        }
        mt xv = this.f26705c.xv();
        ck ux = this.f26705c.ux();
        if (ux.gd() != 0) {
            JSONObject c5 = g.c(ux.c());
            if (c5 != null) {
                c(xv.c(c5));
                this.xv = System.currentTimeMillis();
                return true;
            }
            be.w((Throwable) null);
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.bk
    long c() {
        long ls = this.f26705c.sr().ls();
        if (ls > 60000 || ls <= 0) {
            ls = 60000;
        }
        f26748w[0] = ls;
        return this.xv + ls;
    }

    private void c(ArrayList<b> arrayList) {
        int i4;
        mt xv = this.f26705c.xv();
        ArrayList<b> arrayList2 = new ArrayList<>();
        ArrayList<b> arrayList3 = new ArrayList<>();
        n sr = this.f26705c.sr();
        this.f26705c.ux();
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<b> c4 = xv.c();
        if (!c4.isEmpty()) {
            arrayList4.addAll(c4);
        }
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                byte[] bArr = bVar.f26693a;
                if (bArr != null && bArr.length > 0) {
                    if (this.sr) {
                        ys ysVar = this.f26705c;
                        i4 = gw.c(vc.c(ysVar, ysVar.w(), this.f26705c.ux().c()), bVar.f26693a, sr);
                    } else {
                        Log.d("xgc_apm", "ignore");
                        i4 = 200;
                    }
                    Log.d("xgc_apm", "Api.send:" + i4);
                    if (gw.c(i4)) {
                        if (arrayList.contains(bVar)) {
                            bVar.f26698t = i4;
                            arrayList3.add(bVar);
                        }
                    } else if (i4 == 200) {
                        arrayList2.add(bVar);
                    } else {
                        bVar.f26698t = i4;
                        arrayList3.add(bVar);
                    }
                } else {
                    arrayList2.add(bVar);
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                xv.c(arrayList2, arrayList3, arrayList);
            }
            be.sr(sr() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
