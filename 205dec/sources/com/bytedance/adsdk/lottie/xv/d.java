package com.bytedance.adsdk.lottie.xv;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.xv.w.e> f25776a;

    /* renamed from: b  reason: collision with root package name */
    private final char f25777b;

    /* renamed from: c  reason: collision with root package name */
    private final double f25778c;

    /* renamed from: d  reason: collision with root package name */
    private final double f25779d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25780e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25781f;

    public d(List<com.bytedance.adsdk.lottie.xv.w.e> list, char c4, double d4, double d5, String str, String str2) {
        this.f25776a = list;
        this.f25777b = c4;
        this.f25778c = d4;
        this.f25779d = d5;
        this.f25780e = str;
        this.f25781f = str2;
    }

    public static int a(char c4, String str, String str2) {
        return (((c4 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<com.bytedance.adsdk.lottie.xv.w.e> b() {
        return this.f25776a;
    }

    public double c() {
        return this.f25779d;
    }

    public int hashCode() {
        return a(this.f25777b, this.f25781f, this.f25780e);
    }
}
