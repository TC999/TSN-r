package com.bytedance.adsdk.lottie;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f25641a;

    /* renamed from: b  reason: collision with root package name */
    private final LottieAnimationView f25642b;

    /* renamed from: c  reason: collision with root package name */
    private final d f25643c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25644d;

    m() {
        this.f25641a = new HashMap();
        this.f25644d = true;
        this.f25642b = null;
        this.f25643c = null;
    }

    private void c() {
        LottieAnimationView lottieAnimationView = this.f25642b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        d dVar = this.f25643c;
        if (dVar != null) {
            dVar.invalidateSelf();
        }
    }

    public String a(String str) {
        return str;
    }

    public String b(String str, String str2) {
        return a(str2);
    }

    public void d(String str, String str2) {
        this.f25641a.put(str, str2);
        c();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String e(String str, String str2) {
        if (this.f25644d && this.f25641a.containsKey(str2)) {
            return this.f25641a.get(str2);
        }
        String b4 = b(str, str2);
        if (this.f25644d) {
            this.f25641a.put(str2, b4);
        }
        return b4;
    }

    public m(LottieAnimationView lottieAnimationView) {
        this.f25641a = new HashMap();
        this.f25644d = true;
        this.f25642b = lottieAnimationView;
        this.f25643c = null;
    }
}
