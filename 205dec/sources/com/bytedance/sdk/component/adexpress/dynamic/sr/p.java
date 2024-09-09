package com.bytedance.sdk.component.adexpress.dynamic.sr;

import com.bytedance.sdk.component.adexpress.dynamic.sr.w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {
    public static float c(float f4) {
        return (float) Math.ceil((f4 * 16.0f) / 16.0f);
    }

    public static List<w.c> c(float f4, List<w.c> list) {
        ArrayList<w.c> arrayList = new ArrayList();
        for (w.c cVar : list) {
            arrayList.add((w.c) cVar.clone());
        }
        boolean z3 = true;
        int i4 = 0;
        int i5 = 0;
        for (w.c cVar2 : arrayList) {
            if (cVar2.f29319w) {
                i4 = (int) (i4 + cVar2.f29318c);
            } else {
                i5 = (int) (i5 + cVar2.f29318c);
                z3 = false;
            }
        }
        if (!z3 || f4 <= i4) {
            float f5 = i4;
            float f6 = f4 < f5 ? f4 / f5 : 1.0f;
            float f7 = f4 > f5 ? (f4 - f5) / i5 : 0.0f;
            if (f7 > 1.0f) {
                ArrayList arrayList2 = new ArrayList();
                boolean z4 = false;
                for (w.c cVar3 : arrayList) {
                    if (!cVar3.f29319w) {
                        float f8 = cVar3.xv;
                        if (f8 != 0.0f && cVar3.f29318c * f7 > f8) {
                            cVar3.f29318c = f8;
                            cVar3.f29319w = true;
                            z4 = true;
                        }
                    }
                    arrayList2.add(cVar3);
                }
                if (z4) {
                    return c(f4, arrayList2);
                }
            }
            int i6 = 0;
            for (w.c cVar4 : arrayList) {
                if (cVar4.f29319w) {
                    cVar4.f29318c = c(cVar4.f29318c * f6);
                } else {
                    cVar4.f29318c = c(cVar4.f29318c * f7);
                }
                i6 = (int) (i6 + cVar4.f29318c);
            }
            float f9 = i6;
            if (f9 < f4) {
                float f10 = f4 - f9;
                for (int i7 = 0; i7 < arrayList.size() && f10 > 0.0f; i7 = (i7 + 1) % arrayList.size()) {
                    w.c cVar5 = (w.c) arrayList.get(i7);
                    if ((f4 < f5 && cVar5.f29319w) || (f4 > f5 && !cVar5.f29319w)) {
                        cVar5.f29318c += 0.0625f;
                        f10 -= 0.0625f;
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }
}
