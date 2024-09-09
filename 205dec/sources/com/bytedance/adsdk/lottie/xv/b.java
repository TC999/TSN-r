package com.bytedance.adsdk.lottie.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f25754a;

    /* renamed from: b  reason: collision with root package name */
    public final float f25755b;

    /* renamed from: c  reason: collision with root package name */
    public final float f25756c;

    public b(String str, float f4, float f5) {
        this.f25754a = str;
        this.f25756c = f5;
        this.f25755b = f4;
    }

    public boolean a(String str) {
        if (this.f25754a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f25754a.endsWith("\r")) {
            String str2 = this.f25754a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
