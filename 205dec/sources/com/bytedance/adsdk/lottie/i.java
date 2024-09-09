package com.bytedance.adsdk.lottie;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum i {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25633a;

        static {
            int[] iArr = new int[i.values().length];
            f25633a = iArr;
            try {
                iArr[i.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25633a[i.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25633a[i.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean c(int i4, boolean z3, int i5) {
        int i6 = a.f25633a[ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                return (z3 && i4 < 28) || i5 > 4 || i4 <= 25;
            }
            return true;
        }
        return false;
    }
}
