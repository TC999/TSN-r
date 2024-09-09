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
import com.yalantis.ucrop.model.c;
import com.yalantis.ucrop.util.e;
import com.yalantis.ucrop.util.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BitmapCropTask.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: s  reason: collision with root package name */
    private static final String f54381s = "BitmapCropTask";

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f54382a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f54383b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f54384c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f54385d;

    /* renamed from: e  reason: collision with root package name */
    private float f54386e;

    /* renamed from: f  reason: collision with root package name */
    private float f54387f;

    /* renamed from: g  reason: collision with root package name */
    private final int f54388g;

    /* renamed from: h  reason: collision with root package name */
    private final int f54389h;

    /* renamed from: i  reason: collision with root package name */
    private final Bitmap.CompressFormat f54390i;

    /* renamed from: j  reason: collision with root package name */
    private final int f54391j;

    /* renamed from: k  reason: collision with root package name */
    private final String f54392k;

    /* renamed from: l  reason: collision with root package name */
    private final String f54393l;

    /* renamed from: m  reason: collision with root package name */
    private final com.yalantis.ucrop.model.b f54394m;

    /* renamed from: n  reason: collision with root package name */
    private final c1.a f54395n;

    /* renamed from: o  reason: collision with root package name */
    private int f54396o;

    /* renamed from: p  reason: collision with root package name */
    private int f54397p;

    /* renamed from: q  reason: collision with root package name */
    private int f54398q;

    /* renamed from: r  reason: collision with root package name */
    private int f54399r;

    public a(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull c cVar, @NonNull com.yalantis.ucrop.model.a aVar, @Nullable c1.a aVar2) {
        this.f54382a = new WeakReference<>(context);
        this.f54383b = bitmap;
        this.f54384c = cVar.a();
        this.f54385d = cVar.c();
        this.f54386e = cVar.d();
        this.f54387f = cVar.b();
        this.f54388g = aVar.f();
        this.f54389h = aVar.g();
        this.f54390i = aVar.a();
        this.f54391j = aVar.b();
        this.f54392k = aVar.d();
        this.f54393l = aVar.e();
        this.f54394m = aVar.c();
        this.f54395n = aVar2;
    }

    private boolean a() throws IOException {
        Bitmap bitmap;
        if (this.f54388g > 0 && this.f54389h > 0) {
            float width = this.f54384c.width() / this.f54386e;
            float height = this.f54384c.height() / this.f54386e;
            int i4 = this.f54388g;
            if (width > i4 || height > this.f54389h) {
                float min = Math.min(i4 / width, this.f54389h / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f54383b, Math.round(bitmap.getWidth() * min), Math.round(this.f54383b.getHeight() * min), false);
                Bitmap bitmap2 = this.f54383b;
                if (bitmap2 != createScaledBitmap) {
                    bitmap2.recycle();
                }
                this.f54383b = createScaledBitmap;
                this.f54386e /= min;
            }
        }
        if (this.f54387f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f54387f, this.f54383b.getWidth() / 2, this.f54383b.getHeight() / 2);
            Bitmap bitmap3 = this.f54383b;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f54383b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.f54383b;
            if (bitmap4 != createBitmap) {
                bitmap4.recycle();
            }
            this.f54383b = createBitmap;
        }
        this.f54398q = Math.round((this.f54384c.left - this.f54385d.left) / this.f54386e);
        this.f54399r = Math.round((this.f54384c.top - this.f54385d.top) / this.f54386e);
        this.f54396o = Math.round(this.f54384c.width() / this.f54386e);
        int round = Math.round(this.f54384c.height() / this.f54386e);
        this.f54397p = round;
        boolean e4 = e(this.f54396o, round);
        Log.i("BitmapCropTask", "Should crop: " + e4);
        if (e4) {
            ExifInterface exifInterface = new ExifInterface(this.f54392k);
            d(Bitmap.createBitmap(this.f54383b, this.f54398q, this.f54399r, this.f54396o, this.f54397p));
            if (this.f54390i.equals(Bitmap.CompressFormat.JPEG)) {
                f.b(exifInterface, this.f54396o, this.f54397p, this.f54393l);
                return true;
            }
            return true;
        }
        e.a(this.f54392k, this.f54393l);
        return false;
    }

    private void d(@NonNull Bitmap bitmap) throws FileNotFoundException {
        Context context = this.f54382a.get();
        if (context == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(Uri.fromFile(new File(this.f54393l)));
            bitmap.compress(this.f54390i, this.f54391j, outputStream);
            bitmap.recycle();
        } finally {
            com.yalantis.ucrop.util.a.c(outputStream);
        }
    }

    private boolean e(int i4, int i5) {
        int round = Math.round(Math.max(i4, i5) / 1000.0f) + 1;
        if (this.f54388g <= 0 || this.f54389h <= 0) {
            float f4 = round;
            return Math.abs(this.f54384c.left - this.f54385d.left) > f4 || Math.abs(this.f54384c.top - this.f54385d.top) > f4 || Math.abs(this.f54384c.bottom - this.f54385d.bottom) > f4 || Math.abs(this.f54384c.right - this.f54385d.right) > f4 || this.f54387f != 0.0f;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Nullable
    /* renamed from: b */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.f54383b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f54385d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a();
            this.f54383b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(@Nullable Throwable th) {
        c1.a aVar = this.f54395n;
        if (aVar != null) {
            if (th == null) {
                this.f54395n.a(Uri.fromFile(new File(this.f54393l)), this.f54398q, this.f54399r, this.f54396o, this.f54397p);
                return;
            }
            aVar.b(th);
        }
    }
}
