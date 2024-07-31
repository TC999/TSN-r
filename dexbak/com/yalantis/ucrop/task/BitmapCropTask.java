package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.C13526e;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import p028c1.BitmapCropCallback;

/* renamed from: com.yalantis.ucrop.task.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: s */
    private static final String f39845s = "BitmapCropTask";

    /* renamed from: a */
    private final WeakReference<Context> f39846a;

    /* renamed from: b */
    private Bitmap f39847b;

    /* renamed from: c */
    private final RectF f39848c;

    /* renamed from: d */
    private final RectF f39849d;

    /* renamed from: e */
    private float f39850e;

    /* renamed from: f */
    private float f39851f;

    /* renamed from: g */
    private final int f39852g;

    /* renamed from: h */
    private final int f39853h;

    /* renamed from: i */
    private final Bitmap.CompressFormat f39854i;

    /* renamed from: j */
    private final int f39855j;

    /* renamed from: k */
    private final String f39856k;

    /* renamed from: l */
    private final String f39857l;

    /* renamed from: m */
    private final ExifInfo f39858m;

    /* renamed from: n */
    private final BitmapCropCallback f39859n;

    /* renamed from: o */
    private int f39860o;

    /* renamed from: p */
    private int f39861p;

    /* renamed from: q */
    private int f39862q;

    /* renamed from: r */
    private int f39863r;

    public BitmapCropTask(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull ImageState imageState, @NonNull CropParameters cropParameters, @Nullable BitmapCropCallback bitmapCropCallback) {
        this.f39846a = new WeakReference<>(context);
        this.f39847b = bitmap;
        this.f39848c = imageState.m13034a();
        this.f39849d = imageState.m13032c();
        this.f39850e = imageState.m13031d();
        this.f39851f = imageState.m13033b();
        this.f39852g = cropParameters.m13042f();
        this.f39853h = cropParameters.m13041g();
        this.f39854i = cropParameters.m13047a();
        this.f39855j = cropParameters.m13046b();
        this.f39856k = cropParameters.m13044d();
        this.f39857l = cropParameters.m13043e();
        this.f39858m = cropParameters.m13045c();
        this.f39859n = bitmapCropCallback;
    }

    /* renamed from: a */
    private boolean m13030a() throws IOException {
        Bitmap bitmap;
        if (this.f39852g > 0 && this.f39853h > 0) {
            float width = this.f39848c.width() / this.f39850e;
            float height = this.f39848c.height() / this.f39850e;
            int i = this.f39852g;
            if (width > i || height > this.f39853h) {
                float min = Math.min(i / width, this.f39853h / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f39847b, Math.round(bitmap.getWidth() * min), Math.round(this.f39847b.getHeight() * min), false);
                Bitmap bitmap2 = this.f39847b;
                if (bitmap2 != createScaledBitmap) {
                    bitmap2.recycle();
                }
                this.f39847b = createScaledBitmap;
                this.f39850e /= min;
            }
        }
        if (this.f39851f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f39851f, this.f39847b.getWidth() / 2, this.f39847b.getHeight() / 2);
            Bitmap bitmap3 = this.f39847b;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f39847b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.f39847b;
            if (bitmap4 != createBitmap) {
                bitmap4.recycle();
            }
            this.f39847b = createBitmap;
        }
        this.f39862q = Math.round((this.f39848c.left - this.f39849d.left) / this.f39850e);
        this.f39863r = Math.round((this.f39848c.top - this.f39849d.top) / this.f39850e);
        this.f39860o = Math.round(this.f39848c.width() / this.f39850e);
        int round = Math.round(this.f39848c.height() / this.f39850e);
        this.f39861p = round;
        boolean m13026e = m13026e(this.f39860o, round);
        Log.i(f39845s, "Should crop: " + m13026e);
        if (m13026e) {
            ExifInterface exifInterface = new ExifInterface(this.f39856k);
            m13027d(Bitmap.createBitmap(this.f39847b, this.f39862q, this.f39863r, this.f39860o, this.f39861p));
            if (this.f39854i.equals(Bitmap.CompressFormat.JPEG)) {
                ImageHeaderParser.m12995b(exifInterface, this.f39860o, this.f39861p, this.f39857l);
                return true;
            }
            return true;
        }
        C13526e.m13003a(this.f39856k, this.f39857l);
        return false;
    }

    /* renamed from: d */
    private void m13027d(@NonNull Bitmap bitmap) throws FileNotFoundException {
        Context context = this.f39846a.get();
        if (context == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(Uri.fromFile(new File(this.f39857l)));
            bitmap.compress(this.f39854i, this.f39855j, outputStream);
            bitmap.recycle();
        } finally {
            BitmapLoadUtils.m13017c(outputStream);
        }
    }

    /* renamed from: e */
    private boolean m13026e(int i, int i2) {
        int round = Math.round(Math.max(i, i2) / 1000.0f) + 1;
        if (this.f39852g <= 0 || this.f39853h <= 0) {
            float f = round;
            return Math.abs(this.f39848c.left - this.f39849d.left) > f || Math.abs(this.f39848c.top - this.f39849d.top) > f || Math.abs(this.f39848c.bottom - this.f39849d.bottom) > f || Math.abs(this.f39848c.right - this.f39849d.right) > f || this.f39851f != 0.0f;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Nullable
    /* renamed from: b */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.f39847b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f39849d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            m13030a();
            this.f39847b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(@Nullable Throwable th) {
        BitmapCropCallback bitmapCropCallback = this.f39859n;
        if (bitmapCropCallback != null) {
            if (th == null) {
                this.f39859n.mo13108a(Uri.fromFile(new File(this.f39857l)), this.f39862q, this.f39863r, this.f39860o, this.f39861p);
                return;
            }
            bitmapCropCallback.mo13107b(th);
        }
    }
}
