package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25701a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f25702b = new c();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, com.bytedance.adsdk.lottie.f.c> f25703c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f25704d = new a();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a implements Comparator<Pair<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface b {
        void c(float f4);
    }

    public void a(String str, float f4) {
        if (this.f25701a) {
            com.bytedance.adsdk.lottie.f.c cVar = this.f25703c.get(str);
            if (cVar == null) {
                cVar = new com.bytedance.adsdk.lottie.f.c();
                this.f25703c.put(str, cVar);
            }
            cVar.a(f4);
            if (str.equals("__container")) {
                for (b bVar : this.f25702b) {
                    bVar.c(f4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z3) {
        this.f25701a = z3;
    }
}
