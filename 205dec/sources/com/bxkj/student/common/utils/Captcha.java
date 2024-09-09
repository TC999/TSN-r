package com.bxkj.student.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class Captcha {

    /* renamed from: n  reason: collision with root package name */
    private static final char[] f19573n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: o  reason: collision with root package name */
    private static final char[] f19574o = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: p  reason: collision with root package name */
    private static final char[] f19575p = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: q  reason: collision with root package name */
    private static Captcha f19576q;

    /* renamed from: m  reason: collision with root package name */
    private String f19589m;

    /* renamed from: k  reason: collision with root package name */
    private TYPE f19587k = TYPE.CHARS;

    /* renamed from: a  reason: collision with root package name */
    private int f19577a = 200;

    /* renamed from: b  reason: collision with root package name */
    private int f19578b = 80;

    /* renamed from: c  reason: collision with root package name */
    private int f19579c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f19580d = 4;

    /* renamed from: e  reason: collision with root package name */
    private int f19581e = 2;

    /* renamed from: f  reason: collision with root package name */
    private int f19582f = 50;

    /* renamed from: g  reason: collision with root package name */
    private int f19583g = 20;

    /* renamed from: h  reason: collision with root package name */
    private int f19584h = 20;

    /* renamed from: i  reason: collision with root package name */
    private int f19585i = 45;

    /* renamed from: j  reason: collision with root package name */
    private int f19586j = 15;

    /* renamed from: l  reason: collision with root package name */
    private Random f19588l = new Random();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public enum TYPE {
        NUMBER,
        LETTER,
        CHARS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19590a;

        static {
            int[] iArr = new int[TYPE.values().length];
            f19590a = iArr;
            try {
                iArr[TYPE.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19590a[TYPE.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19590a[TYPE.CHARS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Captcha() {
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        int i4 = a.f19590a[this.f19587k.ordinal()];
        int i5 = 0;
        if (i4 == 1) {
            while (i5 < this.f19580d) {
                char[] cArr = f19573n;
                sb.append(cArr[this.f19588l.nextInt(cArr.length)]);
                i5++;
            }
        } else if (i4 == 2) {
            while (i5 < this.f19580d) {
                char[] cArr2 = f19574o;
                sb.append(cArr2[this.f19588l.nextInt(cArr2.length)]);
                i5++;
            }
        } else if (i4 != 3) {
            while (i5 < this.f19580d) {
                char[] cArr3 = f19575p;
                sb.append(cArr3[this.f19588l.nextInt(cArr3.length)]);
                i5++;
            }
        } else {
            while (i5 < this.f19580d) {
                char[] cArr4 = f19575p;
                sb.append(cArr4[this.f19588l.nextInt(cArr4.length)]);
                i5++;
            }
        }
        return sb.toString();
    }

    private void c(Canvas canvas, Paint paint) {
        int f4 = f();
        int nextInt = this.f19588l.nextInt(this.f19577a);
        int nextInt2 = this.f19588l.nextInt(this.f19578b);
        int nextInt3 = this.f19588l.nextInt(this.f19577a);
        int nextInt4 = this.f19588l.nextInt(this.f19578b);
        paint.setStrokeWidth(1.0f);
        paint.setColor(f4);
        canvas.drawLine(nextInt, nextInt2, nextInt3, nextInt4, paint);
    }

    public static Captcha e() {
        if (f19576q == null) {
            synchronized (Captcha.class) {
                f19576q = new Captcha();
            }
        }
        return f19576q;
    }

    private int f() {
        return Color.rgb(this.f19588l.nextInt(256), this.f19588l.nextInt(256), this.f19588l.nextInt(256));
    }

    private int g() {
        return this.f19583g + this.f19588l.nextInt(this.f19584h);
    }

    private int h() {
        return this.f19585i + this.f19588l.nextInt(this.f19586j);
    }

    private void i(Paint paint) {
        paint.setColor(f());
        paint.setFakeBoldText(this.f19588l.nextBoolean());
        int nextInt = this.f19588l.nextInt(11) / 10;
        if (!this.f19588l.nextBoolean()) {
            nextInt = -nextInt;
        }
        paint.setTextSkewX(nextInt);
    }

    public Bitmap a() {
        this.f19589m = b();
        Bitmap createBitmap = Bitmap.createBitmap(this.f19577a, this.f19578b, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(this.f19579c);
        Paint paint = new Paint();
        paint.setTextSize(this.f19582f);
        int i4 = 0;
        for (int i5 = 0; i5 < this.f19589m.length(); i5++) {
            i(paint);
            i4 += g();
            canvas.drawText(String.valueOf(this.f19589m.charAt(i5)), i4, h(), paint);
        }
        for (int i6 = 0; i6 < this.f19581e; i6++) {
            c(canvas, paint);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public String d() {
        return this.f19589m;
    }

    public Captcha j(int color) {
        this.f19579c = color;
        return f19576q;
    }

    public Captcha k(int paddingLeft, int paddingTop) {
        this.f19583g = paddingLeft;
        this.f19585i = paddingTop;
        return f19576q;
    }

    public Captcha l(int paddingLeft, int paddingLeftRang, int paddingTop, int paddingTopRang) {
        this.f19583g = paddingLeft;
        this.f19584h = paddingLeftRang;
        this.f19585i = paddingTop;
        this.f19586j = paddingTopRang;
        return f19576q;
    }

    public Captcha m(int size) {
        this.f19582f = size;
        return f19576q;
    }

    public Captcha n(int length) {
        this.f19580d = length;
        return f19576q;
    }

    public Captcha o(int number) {
        this.f19581e = number;
        return f19576q;
    }

    public Captcha p(int width, int height) {
        this.f19577a = width;
        this.f19578b = height;
        return f19576q;
    }

    public Captcha q(TYPE type) {
        this.f19587k = type;
        return f19576q;
    }
}
