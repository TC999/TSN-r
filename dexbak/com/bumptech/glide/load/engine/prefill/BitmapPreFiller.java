package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.C3771k;
import java.util.HashMap;

/* renamed from: com.bumptech.glide.load.engine.prefill.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BitmapPreFiller {

    /* renamed from: a */
    private final MemoryCache f13879a;

    /* renamed from: b */
    private final BitmapPool f13880b;

    /* renamed from: c */
    private final DecodeFormat f13881c;

    /* renamed from: d */
    private final Handler f13882d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private BitmapPreFillRunner f13883e;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f13879a = memoryCache;
        this.f13880b = bitmapPool;
        this.f13881c = decodeFormat;
    }

    /* renamed from: b */
    private static int m45159b(PreFillType preFillType) {
        return C3771k.m44384g(preFillType.m45151d(), preFillType.m45153b(), preFillType.m45154a());
    }

    @VisibleForTesting
    /* renamed from: a */
    PreFillQueue m45160a(PreFillType... preFillTypeArr) {
        long maxSize = (this.f13879a.getMaxSize() - this.f13879a.getCurrentSize()) + this.f13880b.getMaxSize();
        int i = 0;
        for (PreFillType preFillType : preFillTypeArr) {
            i += preFillType.m45152c();
        }
        float f = ((float) maxSize) / i;
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType2 : preFillTypeArr) {
            hashMap.put(preFillType2, Integer.valueOf(Math.round(preFillType2.m45152c() * f) / m45159b(preFillType2)));
        }
        return new PreFillQueue(hashMap);
    }

    /* renamed from: c */
    public void m45158c(PreFillType.C3645a... c3645aArr) {
        BitmapPreFillRunner bitmapPreFillRunner = this.f13883e;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.m45165b();
        }
        PreFillType[] preFillTypeArr = new PreFillType[c3645aArr.length];
        for (int i = 0; i < c3645aArr.length; i++) {
            PreFillType.C3645a c3645a = c3645aArr[i];
            if (c3645a.m45149b() == null) {
                c3645a.m45148c(this.f13881c == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            preFillTypeArr[i] = c3645a.m45150a();
        }
        BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.f13880b, this.f13879a, m45160a(preFillTypeArr));
        this.f13883e = bitmapPreFillRunner2;
        this.f13882d.post(bitmapPreFillRunner2);
    }
}
