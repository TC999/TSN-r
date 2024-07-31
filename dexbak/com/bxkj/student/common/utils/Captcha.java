package com.bxkj.student.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Captcha {

    /* renamed from: n */
    private static final char[] f16174n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: o */
    private static final char[] f16175o = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: p */
    private static final char[] f16176p = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: q */
    private static Captcha f16177q;

    /* renamed from: m */
    private String f16190m;

    /* renamed from: k */
    private TYPE f16188k = TYPE.CHARS;

    /* renamed from: a */
    private int f16178a = 200;

    /* renamed from: b */
    private int f16179b = 80;

    /* renamed from: c */
    private int f16180c = -1;

    /* renamed from: d */
    private int f16181d = 4;

    /* renamed from: e */
    private int f16182e = 2;

    /* renamed from: f */
    private int f16183f = 50;

    /* renamed from: g */
    private int f16184g = 20;

    /* renamed from: h */
    private int f16185h = 20;

    /* renamed from: i */
    private int f16186i = 45;

    /* renamed from: j */
    private int f16187j = 15;

    /* renamed from: l */
    private Random f16189l = new Random();

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public enum TYPE {
        NUMBER,
        LETTER,
        CHARS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.common.utils.Captcha$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static /* synthetic */ class C4243a {

        /* renamed from: a */
        static final /* synthetic */ int[] f16191a;

        static {
            int[] iArr = new int[TYPE.values().length];
            f16191a = iArr;
            try {
                iArr[TYPE.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16191a[TYPE.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16191a[TYPE.CHARS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Captcha() {
    }

    /* renamed from: b */
    private String m42905b() {
        StringBuilder sb = new StringBuilder();
        int i = C4243a.f16191a[this.f16188k.ordinal()];
        int i2 = 0;
        if (i == 1) {
            while (i2 < this.f16181d) {
                char[] cArr = f16174n;
                sb.append(cArr[this.f16189l.nextInt(cArr.length)]);
                i2++;
            }
        } else if (i == 2) {
            while (i2 < this.f16181d) {
                char[] cArr2 = f16175o;
                sb.append(cArr2[this.f16189l.nextInt(cArr2.length)]);
                i2++;
            }
        } else if (i != 3) {
            while (i2 < this.f16181d) {
                char[] cArr3 = f16176p;
                sb.append(cArr3[this.f16189l.nextInt(cArr3.length)]);
                i2++;
            }
        } else {
            while (i2 < this.f16181d) {
                char[] cArr4 = f16176p;
                sb.append(cArr4[this.f16189l.nextInt(cArr4.length)]);
                i2++;
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    private void m42904c(Canvas canvas, Paint paint) {
        int m42901f = m42901f();
        int nextInt = this.f16189l.nextInt(this.f16178a);
        int nextInt2 = this.f16189l.nextInt(this.f16179b);
        int nextInt3 = this.f16189l.nextInt(this.f16178a);
        int nextInt4 = this.f16189l.nextInt(this.f16179b);
        paint.setStrokeWidth(1.0f);
        paint.setColor(m42901f);
        canvas.drawLine(nextInt, nextInt2, nextInt3, nextInt4, paint);
    }

    /* renamed from: e */
    public static Captcha m42902e() {
        if (f16177q == null) {
            synchronized (Captcha.class) {
                f16177q = new Captcha();
            }
        }
        return f16177q;
    }

    /* renamed from: f */
    private int m42901f() {
        return Color.rgb(this.f16189l.nextInt(256), this.f16189l.nextInt(256), this.f16189l.nextInt(256));
    }

    /* renamed from: g */
    private int m42900g() {
        return this.f16184g + this.f16189l.nextInt(this.f16185h);
    }

    /* renamed from: h */
    private int m42899h() {
        return this.f16186i + this.f16189l.nextInt(this.f16187j);
    }

    /* renamed from: i */
    private void m42898i(Paint paint) {
        paint.setColor(m42901f());
        paint.setFakeBoldText(this.f16189l.nextBoolean());
        int nextInt = this.f16189l.nextInt(11) / 10;
        if (!this.f16189l.nextBoolean()) {
            nextInt = -nextInt;
        }
        paint.setTextSkewX(nextInt);
    }

    /* renamed from: a */
    public Bitmap m42906a() {
        this.f16190m = m42905b();
        Bitmap createBitmap = Bitmap.createBitmap(this.f16178a, this.f16179b, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(this.f16180c);
        Paint paint = new Paint();
        paint.setTextSize(this.f16183f);
        int i = 0;
        for (int i2 = 0; i2 < this.f16190m.length(); i2++) {
            m42898i(paint);
            i += m42900g();
            canvas.drawText(String.valueOf(this.f16190m.charAt(i2)), i, m42899h(), paint);
        }
        for (int i3 = 0; i3 < this.f16182e; i3++) {
            m42904c(canvas, paint);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    /* renamed from: d */
    public String m42903d() {
        return this.f16190m;
    }

    /* renamed from: j */
    public Captcha m42897j(int color) {
        this.f16180c = color;
        return f16177q;
    }

    /* renamed from: k */
    public Captcha m42896k(int paddingLeft, int paddingTop) {
        this.f16184g = paddingLeft;
        this.f16186i = paddingTop;
        return f16177q;
    }

    /* renamed from: l */
    public Captcha m42895l(int paddingLeft, int paddingLeftRang, int paddingTop, int paddingTopRang) {
        this.f16184g = paddingLeft;
        this.f16185h = paddingLeftRang;
        this.f16186i = paddingTop;
        this.f16187j = paddingTopRang;
        return f16177q;
    }

    /* renamed from: m */
    public Captcha m42894m(int size) {
        this.f16183f = size;
        return f16177q;
    }

    /* renamed from: n */
    public Captcha m42893n(int length) {
        this.f16181d = length;
        return f16177q;
    }

    /* renamed from: o */
    public Captcha m42892o(int number) {
        this.f16182e = number;
        return f16177q;
    }

    /* renamed from: p */
    public Captcha m42891p(int width, int height) {
        this.f16178a = width;
        this.f16179b = height;
        return f16177q;
    }

    /* renamed from: q */
    public Captcha m42890q(TYPE type) {
        this.f16188k = type;
        return f16177q;
    }
}
