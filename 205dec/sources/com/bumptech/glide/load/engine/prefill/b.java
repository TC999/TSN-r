package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.engine.prefill.d;
import com.bumptech.glide.util.k;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapPreFiller.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final j f17196a;

    /* renamed from: b  reason: collision with root package name */
    private final e f17197b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeFormat f17198c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f17199d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private a f17200e;

    public b(j jVar, e eVar, DecodeFormat decodeFormat) {
        this.f17196a = jVar;
        this.f17197b = eVar;
        this.f17198c = decodeFormat;
    }

    private static int b(d dVar) {
        return k.g(dVar.d(), dVar.b(), dVar.a());
    }

    @VisibleForTesting
    c a(d... dVarArr) {
        long maxSize = (this.f17196a.getMaxSize() - this.f17196a.getCurrentSize()) + this.f17197b.getMaxSize();
        int i4 = 0;
        for (d dVar : dVarArr) {
            i4 += dVar.c();
        }
        float f4 = ((float) maxSize) / i4;
        HashMap hashMap = new HashMap();
        for (d dVar2 : dVarArr) {
            hashMap.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f4) / b(dVar2)));
        }
        return new c(hashMap);
    }

    public void c(d.a... aVarArr) {
        a aVar = this.f17200e;
        if (aVar != null) {
            aVar.b();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            d.a aVar2 = aVarArr[i4];
            if (aVar2.b() == null) {
                aVar2.c(this.f17198c == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            dVarArr[i4] = aVar2.a();
        }
        a aVar3 = new a(this.f17197b, this.f17196a, a(dVarArr));
        this.f17200e = aVar3;
        this.f17199d.post(aVar3);
    }
}
