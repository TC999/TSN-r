package cn.jiguang.bw;

import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private static Integer[] f3034a = new Integer[64];

    /* renamed from: d  reason: collision with root package name */
    private String f3037d;

    /* renamed from: e  reason: collision with root package name */
    private int f3038e;

    /* renamed from: f  reason: collision with root package name */
    private String f3039f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3041h;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f3035b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private HashMap f3036c = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private int f3040g = Integer.MAX_VALUE;

    static {
        int i4 = 0;
        while (true) {
            Integer[] numArr = f3034a;
            if (i4 >= numArr.length) {
                return;
            }
            numArr[i4] = Integer.valueOf(i4);
            i4++;
        }
    }

    public f(String str, int i4) {
        this.f3037d = str;
        this.f3038e = i4;
    }

    private String a(String str) {
        int i4 = this.f3038e;
        return i4 == 2 ? str.toUpperCase() : i4 == 3 ? str.toLowerCase() : str;
    }

    public static Integer b(int i4) {
        if (i4 >= 0) {
            Integer[] numArr = f3034a;
            if (i4 < numArr.length) {
                return numArr[i4];
            }
        }
        return Integer.valueOf(i4);
    }

    public void a(int i4) {
        this.f3040g = i4;
    }

    public void a(int i4, String str) {
        c(i4);
        Integer b4 = b(i4);
        String a4 = a(str);
        this.f3035b.put(a4, b4);
        this.f3036c.put(b4, a4);
    }

    public void a(boolean z3) {
        this.f3041h = z3;
    }

    public void c(int i4) {
        if (i4 < 0 || i4 > this.f3040g) {
            throw new IllegalArgumentException(this.f3037d + " " + i4 + "is out of range");
        }
    }

    public String d(int i4) {
        c(i4);
        String str = (String) this.f3036c.get(b(i4));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i4);
        if (this.f3039f != null) {
            return this.f3039f + num;
        }
        return num;
    }
}
