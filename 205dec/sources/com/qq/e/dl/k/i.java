package com.qq.e.dl.k;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final char f47014a;

    /* renamed from: b  reason: collision with root package name */
    private final float f47015b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f47016c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f47017d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Object obj) {
        if (obj instanceof Number) {
            this.f47015b = ((Number) obj).floatValue();
            this.f47014a = (char) 0;
            return;
        }
        float f4 = 0.0f;
        if (!(obj instanceof String)) {
            this.f47015b = 0.0f;
            this.f47014a = (char) 0;
            return;
        }
        String str = (String) obj;
        int length = str.length();
        if (length < 2) {
            this.f47015b = 0.0f;
            this.f47014a = (char) 0;
            return;
        }
        int i4 = length - 1;
        char charAt = str.charAt(i4);
        if (charAt >= 'a' && charAt <= 'f') {
            this.f47014a = charAt;
            try {
                f4 = Float.parseFloat(str.substring(0, i4));
            } catch (Exception unused) {
            }
            this.f47015b = f4;
            return;
        }
        try {
            f4 = Float.parseFloat(str);
        } catch (Exception unused2) {
        }
        this.f47015b = f4;
        this.f47014a = (char) 0;
    }

    public int a(int i4, int i5) {
        if (this.f47015b == 0.0f) {
            return 0;
        }
        char c4 = this.f47014a;
        if (c4 == 'e') {
            return a(i4);
        }
        if (c4 == 'f') {
            return a(i5);
        }
        return d();
    }

    public float b() {
        return this.f47015b;
    }

    public boolean c() {
        char c4 = this.f47014a;
        return c4 == 'f' || c4 == 'e';
    }

    public int d() {
        float f4 = this.f47015b;
        if (f4 == 0.0f) {
            return 0;
        }
        switch (this.f47014a) {
            case 'b':
                if (com.qq.e.dl.j.f.c()) {
                    Integer num = this.f47016c;
                    if (num == null) {
                        num = Integer.valueOf(a(com.qq.e.dl.j.f.b()));
                        this.f47016c = num;
                    }
                    return num.intValue();
                }
                Integer num2 = this.f47017d;
                if (num2 == null) {
                    num2 = Integer.valueOf(a(com.qq.e.dl.j.f.b()));
                    this.f47017d = num2;
                }
                return num2.intValue();
            case 'c':
                if (com.qq.e.dl.j.f.c()) {
                    Integer num3 = this.f47016c;
                    if (num3 == null) {
                        num3 = Integer.valueOf(a(com.qq.e.dl.j.f.a()));
                        this.f47016c = num3;
                    }
                    return num3.intValue();
                }
                Integer num4 = this.f47017d;
                if (num4 == null) {
                    num4 = Integer.valueOf(a(com.qq.e.dl.j.f.a()));
                    this.f47017d = num4;
                }
                return num4.intValue();
            case 'd':
                return (int) f4;
            case 'e':
            case 'f':
                return 0;
            default:
                Integer num5 = this.f47016c;
                if (num5 == null) {
                    num5 = Integer.valueOf(com.qq.e.dl.j.f.a(f4));
                    this.f47016c = num5;
                }
                return num5.intValue();
        }
    }

    public boolean a() {
        char c4 = this.f47014a;
        return c4 == 'e' || c4 == 'b';
    }

    private int a(int i4) {
        if (i4 == 0) {
            return 0;
        }
        double d4 = (this.f47015b * i4) / 100.0f;
        Double.isNaN(d4);
        return (int) (d4 + 0.5d);
    }
}
