package com.bytedance.adsdk.lottie.f;

import android.util.Log;
import com.bytedance.adsdk.lottie.k;
import com.bytedance.adsdk.lottie.s;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f25624a = new HashSet();

    public void a(String str, Throwable th) {
        if (s.f25706a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // com.bytedance.adsdk.lottie.k
    public void c(String str) {
        a(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.k
    public void w(String str) {
        c(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.k
    public void c(String str, Throwable th) {
        Set<String> set = f25624a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    @Override // com.bytedance.adsdk.lottie.k
    public void w(String str, Throwable th) {
        if (s.f25706a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
