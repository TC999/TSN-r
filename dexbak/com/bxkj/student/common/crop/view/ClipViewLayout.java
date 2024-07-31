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
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.crop.view.ClipView;
import java.io.IOException;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ClipViewLayout extends RelativeLayout {

    /* renamed from: n */
    private static final int f16146n = 0;

    /* renamed from: o */
    private static final int f16147o = 1;

    /* renamed from: p */
    private static final int f16148p = 2;

    /* renamed from: a */
    private ImageView f16149a;

    /* renamed from: b */
    private ClipView f16150b;

    /* renamed from: c */
    private float f16151c;

    /* renamed from: d */
    private float f16152d;

    /* renamed from: e */
    private Matrix f16153e;

    /* renamed from: f */
    private Matrix f16154f;

    /* renamed from: g */
    private int f16155g;

    /* renamed from: h */
    private PointF f16156h;

    /* renamed from: i */
    private PointF f16157i;

    /* renamed from: j */
    private float f16158j;

    /* renamed from: k */
    private final float[] f16159k;

    /* renamed from: l */
    private float f16160l;

    /* renamed from: m */
    private float f16161m;

    /* renamed from: com.bxkj.student.common.crop.view.ClipViewLayout$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class ViewTreeObserver$OnGlobalLayoutListenerC4237a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ Uri f16162a;

        ViewTreeObserver$OnGlobalLayoutListenerC4237a(final Uri val$uri) {
            this.f16162a = val$uri;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ClipViewLayout.this.m42918i(this.f16162a);
            ClipViewLayout.this.f16149a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public ClipViewLayout(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public static int m42925b(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i > reqHeight || i2 > reqWidth) {
            int round = Math.round(i / reqHeight);
            int round2 = Math.round(i2 / reqWidth);
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

    /* renamed from: c */
    private void m42924c() {
        float f;
        RectF m42920g = m42920g(this.f16153e);
        int width = this.f16149a.getWidth();
        int height = this.f16149a.getHeight();
        float width2 = m42920g.width();
        float f2 = width;
        float f3 = this.f16151c;
        if (width2 >= f2 - (f3 * 2.0f)) {
            float f4 = m42920g.left;
            f = f4 > f3 ? (-f4) + f3 : 0.0f;
            float f5 = m42920g.right;
            if (f5 < f2 - f3) {
                f = (f2 - f3) - f5;
            }
        } else {
            f = 0.0f;
        }
        float height2 = m42920g.height();
        float f6 = height;
        float f7 = this.f16152d;
        if (height2 >= f6 - (2.0f * f7)) {
            float f8 = m42920g.top;
            r7 = f8 > f7 ? (-f8) + f7 : 0.0f;
            float f9 = m42920g.bottom;
            if (f9 < f6 - f7) {
                r7 = (f6 - f7) - f9;
            }
        }
        this.f16153e.postTranslate(f, r7);
    }

    /* renamed from: e */
    public static Bitmap m42922e(String filePath, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = m42925b(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    /* renamed from: f */
    public static int m42921f(String filepath) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(filepath);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) != -1) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return BitmapUtils.ROTATE270;
            }
        }
        return 0;
    }

    /* renamed from: g */
    private RectF m42920g(Matrix matrix) {
        RectF rectF = new RectF();
        Drawable drawable = this.f16149a.getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    /* renamed from: j */
    private void m42917j(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }

    /* renamed from: k */
    private float m42916k(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* renamed from: l */
    public static Bitmap m42915l(Bitmap bitmap, int w, int h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(w / width, h / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap m42923d() {
        /*
            r6 = this;
            android.widget.ImageView r0 = r6.f16149a
            r1 = 1
            r0.setDrawingCacheEnabled(r1)
            android.widget.ImageView r0 = r6.f16149a
            r0.buildDrawingCache()
            com.bxkj.student.common.crop.view.ClipView r0 = r6.f16150b
            android.graphics.Rect r0 = r0.getClipRect()
            r1 = 0
            android.widget.ImageView r2 = r6.f16149a     // Catch: java.lang.Exception -> L33
            android.graphics.Bitmap r2 = r2.getDrawingCache()     // Catch: java.lang.Exception -> L33
            int r3 = r0.left     // Catch: java.lang.Exception -> L33
            int r4 = r0.top     // Catch: java.lang.Exception -> L33
            int r5 = r0.width()     // Catch: java.lang.Exception -> L33
            int r0 = r0.height()     // Catch: java.lang.Exception -> L33
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r0)     // Catch: java.lang.Exception -> L33
            r2 = 295(0x127, float:4.13E-43)
            r3 = 413(0x19d, float:5.79E-43)
            android.graphics.Bitmap r1 = m42915l(r0, r2, r3)     // Catch: java.lang.Exception -> L31
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
            android.widget.ImageView r0 = r6.f16149a
            r0.destroyDrawingCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.crop.view.ClipViewLayout.m42923d():android.graphics.Bitmap");
    }

    public final float getScale() {
        this.f16153e.getValues(this.f16159k);
        return this.f16159k[0];
    }

    /* renamed from: h */
    public void m42919h(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, C4215R.styleable.ClipViewLayout);
        this.f16151c = obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        int i = obtainStyledAttributes.getInt(1, 1);
        obtainStyledAttributes.recycle();
        ClipView clipView = new ClipView(context);
        this.f16150b = clipView;
        clipView.setClipType(i == 1 ? ClipView.ClipType.CIRCLE : ClipView.ClipType.RECTANGLE);
        this.f16150b.setClipBorderWidth(dimensionPixelSize);
        this.f16150b.setmHorizontalPadding(this.f16151c);
        this.f16149a = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.f16149a, layoutParams);
        addView(this.f16150b, layoutParams);
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
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m42918i(android.net.Uri r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.crop.view.ClipViewLayout.m42918i(android.net.Uri):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            this.f16154f.set(this.f16153e);
            this.f16156h.set(event.getX(), event.getY());
            this.f16155g = 1;
        } else if (action == 2) {
            int i = this.f16155g;
            if (i == 1) {
                this.f16153e.set(this.f16154f);
                float x = event.getX() - this.f16156h.x;
                float y = event.getY() - this.f16156h.y;
                this.f16152d = this.f16150b.getClipRect().top;
                this.f16153e.postTranslate(x, y);
                m42924c();
            } else if (i == 2) {
                float m42916k = m42916k(event);
                if (m42916k > 10.0f) {
                    float f = m42916k / this.f16158j;
                    if (f < 1.0f) {
                        if (getScale() > this.f16160l) {
                            this.f16153e.set(this.f16154f);
                            this.f16152d = this.f16150b.getClipRect().top;
                            Matrix matrix = this.f16153e;
                            PointF pointF = this.f16157i;
                            matrix.postScale(f, f, pointF.x, pointF.y);
                            while (getScale() < this.f16160l) {
                                Matrix matrix2 = this.f16153e;
                                PointF pointF2 = this.f16157i;
                                matrix2.postScale(1.01f, 1.01f, pointF2.x, pointF2.y);
                            }
                        }
                        m42924c();
                    } else if (getScale() <= this.f16161m) {
                        this.f16153e.set(this.f16154f);
                        this.f16152d = this.f16150b.getClipRect().top;
                        Matrix matrix3 = this.f16153e;
                        PointF pointF3 = this.f16157i;
                        matrix3.postScale(f, f, pointF3.x, pointF3.y);
                    }
                }
            }
            this.f16149a.setImageMatrix(this.f16153e);
        } else if (action == 5) {
            float m42916k2 = m42916k(event);
            this.f16158j = m42916k2;
            if (m42916k2 > 10.0f) {
                this.f16154f.set(this.f16153e);
                m42917j(this.f16157i, event);
                this.f16155g = 2;
            }
        } else if (action == 6) {
            this.f16155g = 0;
        }
        return true;
    }

    public void setImageSrc(final Uri uri) {
        this.f16149a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC4237a(uri));
    }

    public ClipViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f16153e = new Matrix();
        this.f16154f = new Matrix();
        this.f16155g = 0;
        this.f16156h = new PointF();
        this.f16157i = new PointF();
        this.f16158j = 1.0f;
        this.f16159k = new float[9];
        this.f16161m = 4.0f;
        m42919h(context, attrs);
    }
}
