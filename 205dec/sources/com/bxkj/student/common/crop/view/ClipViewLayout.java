package com.bxkj.student.common.crop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bxkj.student.R;
import com.bxkj.student.common.crop.view.ClipView;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ClipViewLayout extends RelativeLayout {

    /* renamed from: n  reason: collision with root package name */
    private static final int f19541n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static final int f19542o = 1;

    /* renamed from: p  reason: collision with root package name */
    private static final int f19543p = 2;

    /* renamed from: a  reason: collision with root package name */
    private ImageView f19544a;

    /* renamed from: b  reason: collision with root package name */
    private ClipView f19545b;

    /* renamed from: c  reason: collision with root package name */
    private float f19546c;

    /* renamed from: d  reason: collision with root package name */
    private float f19547d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f19548e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f19549f;

    /* renamed from: g  reason: collision with root package name */
    private int f19550g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f19551h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f19552i;

    /* renamed from: j  reason: collision with root package name */
    private float f19553j;

    /* renamed from: k  reason: collision with root package name */
    private final float[] f19554k;

    /* renamed from: l  reason: collision with root package name */
    private float f19555l;

    /* renamed from: m  reason: collision with root package name */
    private float f19556m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Uri f19557a;

        a(final Uri val$uri) {
            this.f19557a = val$uri;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ClipViewLayout.this.i(this.f19557a);
            ClipViewLayout.this.f19544a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public ClipViewLayout(Context context) {
        this(context, null);
    }

    public static int b(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > reqHeight || i5 > reqWidth) {
            int round = Math.round(i4 / reqHeight);
            int round2 = Math.round(i5 / reqWidth);
            if (round >= round2) {
                round = round2;
            }
            if (round >= 3) {
                if (round < 6.5d) {
                    return 4;
                }
                if (round < 8) {
                    return 8;
                }
            }
            return round;
        }
        return 1;
    }

    private void c() {
        float f4;
        RectF g4 = g(this.f19548e);
        int width = this.f19544a.getWidth();
        int height = this.f19544a.getHeight();
        float width2 = g4.width();
        float f5 = width;
        float f6 = this.f19546c;
        if (width2 >= f5 - (f6 * 2.0f)) {
            float f7 = g4.left;
            f4 = f7 > f6 ? (-f7) + f6 : 0.0f;
            float f8 = g4.right;
            if (f8 < f5 - f6) {
                f4 = (f5 - f6) - f8;
            }
        } else {
            f4 = 0.0f;
        }
        float height2 = g4.height();
        float f9 = height;
        float f10 = this.f19547d;
        if (height2 >= f9 - (2.0f * f10)) {
            float f11 = g4.top;
            r7 = f11 > f10 ? (-f11) + f10 : 0.0f;
            float f12 = g4.bottom;
            if (f12 < f9 - f10) {
                r7 = (f9 - f10) - f12;
            }
        }
        this.f19548e.postTranslate(f4, r7);
    }

    public static Bitmap e(String filePath, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = b(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static int f(String filepath) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(filepath);
        } catch (IOException e4) {
            e4.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) != -1) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return 270;
            }
        }
        return 0;
    }

    private RectF g(Matrix matrix) {
        RectF rectF = new RectF();
        Drawable drawable = this.f19544a.getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    private void j(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }

    private float k(MotionEvent event) {
        float x3 = event.getX(0) - event.getX(1);
        float y3 = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((x3 * x3) + (y3 * y3));
    }

    public static Bitmap l(Bitmap bitmap, int w3, int h4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(w3 / width, h4 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap d() {
        /*
            r6 = this;
            android.widget.ImageView r0 = r6.f19544a
            r1 = 1
            r0.setDrawingCacheEnabled(r1)
            android.widget.ImageView r0 = r6.f19544a
            r0.buildDrawingCache()
            com.bxkj.student.common.crop.view.ClipView r0 = r6.f19545b
            android.graphics.Rect r0 = r0.getClipRect()
            r1 = 0
            android.widget.ImageView r2 = r6.f19544a     // Catch: java.lang.Exception -> L33
            android.graphics.Bitmap r2 = r2.getDrawingCache()     // Catch: java.lang.Exception -> L33
            int r3 = r0.left     // Catch: java.lang.Exception -> L33
            int r4 = r0.top     // Catch: java.lang.Exception -> L33
            int r5 = r0.width()     // Catch: java.lang.Exception -> L33
            int r0 = r0.height()     // Catch: java.lang.Exception -> L33
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r0)     // Catch: java.lang.Exception -> L33
            r2 = 295(0x127, float:4.13E-43)
            r3 = 413(0x19d, float:5.79E-43)
            android.graphics.Bitmap r1 = l(r0, r2, r3)     // Catch: java.lang.Exception -> L31
            goto L38
        L31:
            r2 = move-exception
            goto L35
        L33:
            r2 = move-exception
            r0 = r1
        L35:
            r2.printStackTrace()
        L38:
            if (r0 == 0) goto L3d
            r0.recycle()
        L3d:
            android.widget.ImageView r0 = r6.f19544a
            r0.destroyDrawingCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.crop.view.ClipViewLayout.d():android.graphics.Bitmap");
    }

    public final float getScale() {
        this.f19548e.getValues(this.f19554k);
        return this.f19554k[0];
    }

    public void h(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ClipViewLayout);
        this.f19546c = obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        int i4 = obtainStyledAttributes.getInt(1, 1);
        obtainStyledAttributes.recycle();
        ClipView clipView = new ClipView(context);
        this.f19545b = clipView;
        clipView.setClipType(i4 == 1 ? ClipView.ClipType.CIRCLE : ClipView.ClipType.RECTANGLE);
        this.f19545b.setClipBorderWidth(dimensionPixelSize);
        this.f19545b.setmHorizontalPadding(this.f19546c);
        this.f19544a = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.f19544a, layoutParams);
        addView(this.f19545b, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x008f, code lost:
        if (r0 < r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b4, code lost:
        if (r0 < r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b6, code lost:
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(android.net.Uri r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.crop.view.ClipViewLayout.i(android.net.Uri):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            this.f19549f.set(this.f19548e);
            this.f19551h.set(event.getX(), event.getY());
            this.f19550g = 1;
        } else if (action == 2) {
            int i4 = this.f19550g;
            if (i4 == 1) {
                this.f19548e.set(this.f19549f);
                float x3 = event.getX() - this.f19551h.x;
                float y3 = event.getY() - this.f19551h.y;
                this.f19547d = this.f19545b.getClipRect().top;
                this.f19548e.postTranslate(x3, y3);
                c();
            } else if (i4 == 2) {
                float k4 = k(event);
                if (k4 > 10.0f) {
                    float f4 = k4 / this.f19553j;
                    if (f4 < 1.0f) {
                        if (getScale() > this.f19555l) {
                            this.f19548e.set(this.f19549f);
                            this.f19547d = this.f19545b.getClipRect().top;
                            Matrix matrix = this.f19548e;
                            PointF pointF = this.f19552i;
                            matrix.postScale(f4, f4, pointF.x, pointF.y);
                            while (getScale() < this.f19555l) {
                                Matrix matrix2 = this.f19548e;
                                PointF pointF2 = this.f19552i;
                                matrix2.postScale(1.01f, 1.01f, pointF2.x, pointF2.y);
                            }
                        }
                        c();
                    } else if (getScale() <= this.f19556m) {
                        this.f19548e.set(this.f19549f);
                        this.f19547d = this.f19545b.getClipRect().top;
                        Matrix matrix3 = this.f19548e;
                        PointF pointF3 = this.f19552i;
                        matrix3.postScale(f4, f4, pointF3.x, pointF3.y);
                    }
                }
            }
            this.f19544a.setImageMatrix(this.f19548e);
        } else if (action == 5) {
            float k5 = k(event);
            this.f19553j = k5;
            if (k5 > 10.0f) {
                this.f19549f.set(this.f19548e);
                j(this.f19552i, event);
                this.f19550g = 2;
            }
        } else if (action == 6) {
            this.f19550g = 0;
        }
        return true;
    }

    public void setImageSrc(final Uri uri) {
        this.f19544a.getViewTreeObserver().addOnGlobalLayoutListener(new a(uri));
    }

    public ClipViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f19548e = new Matrix();
        this.f19549f = new Matrix();
        this.f19550g = 0;
        this.f19551h = new PointF();
        this.f19552i = new PointF();
        this.f19553j = 1.0f;
        this.f19554k = new float[9];
        this.f19556m = 4.0f;
        h(context, attrs);
    }
}
