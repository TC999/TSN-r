package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.util.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BitmapLoadTask.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f54400g = "BitmapWorkerTask";

    /* renamed from: a  reason: collision with root package name */
    private final Context f54401a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f54402b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f54403c;

    /* renamed from: d  reason: collision with root package name */
    private final int f54404d;

    /* renamed from: e  reason: collision with root package name */
    private final int f54405e;

    /* renamed from: f  reason: collision with root package name */
    private final c1.b f54406f;

    public b(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i4, int i5, c1.b bVar) {
        this.f54401a = context;
        this.f54402b = uri;
        this.f54403c = uri2;
        this.f54404d = i4;
        this.f54405e = i5;
        this.f54406f = bVar;
    }

    private void a(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        Log.d("BitmapWorkerTask", "copyFile");
        if (uri2 != null) {
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = this.f54401a.getContentResolver().openInputStream(uri);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                    try {
                        if (inputStream == null) {
                            throw new NullPointerException("InputStream for given input Uri is null");
                        }
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                com.yalantis.ucrop.util.a.c(fileOutputStream2);
                                com.yalantis.ucrop.util.a.c(inputStream);
                                this.f54402b = this.f54403c;
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.yalantis.ucrop.util.a.c(fileOutputStream);
                        com.yalantis.ucrop.util.a.c(inputStream);
                        this.f54402b = this.f54403c;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } else {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
    }

    private void c(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        Closeable closeable;
        Response response;
        Response execute;
        BufferedSource source;
        Log.d("BitmapWorkerTask", "downloadFile");
        if (uri2 != null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            BufferedSource bufferedSource = null;
            try {
                execute = okHttpClient.newCall(new Request.Builder().url(uri.toString()).build()).execute();
                try {
                    source = execute.body().source();
                } catch (Throwable th) {
                    th = th;
                    response = execute;
                    closeable = null;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                response = null;
            }
            try {
                OutputStream openOutputStream = this.f54401a.getContentResolver().openOutputStream(uri2);
                if (openOutputStream != null) {
                    Sink sink = Okio.sink(openOutputStream);
                    source.readAll(sink);
                    com.yalantis.ucrop.util.a.c(source);
                    com.yalantis.ucrop.util.a.c(sink);
                    com.yalantis.ucrop.util.a.c(execute.body());
                    okHttpClient.dispatcher().cancelAll();
                    this.f54402b = this.f54403c;
                    return;
                }
                throw new NullPointerException("OutputStream for given output Uri is null");
            } catch (Throwable th3) {
                th = th3;
                response = execute;
                closeable = null;
                bufferedSource = source;
                com.yalantis.ucrop.util.a.c(bufferedSource);
                com.yalantis.ucrop.util.a.c(closeable);
                if (response != null) {
                    com.yalantis.ucrop.util.a.c(response.body());
                }
                okHttpClient.dispatcher().cancelAll();
                this.f54402b = this.f54403c;
                throw th;
            }
        }
        throw new NullPointerException("Output Uri is null - cannot download image");
    }

    private String d() {
        if (ContextCompat.checkSelfPermission(this.f54401a, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return e.c(this.f54401a, this.f54402b);
        }
        return null;
    }

    private void f() throws NullPointerException, IOException {
        String scheme = this.f54402b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            if ("content".equals(scheme)) {
                String d4 = d();
                if (!TextUtils.isEmpty(d4) && new File(d4).exists()) {
                    this.f54402b = Uri.fromFile(new File(d4));
                    return;
                }
                try {
                    a(this.f54402b, this.f54403c);
                    return;
                } catch (IOException | NullPointerException e4) {
                    Log.e("BitmapWorkerTask", "Copying failed", e4);
                    throw e4;
                }
            } else if ("file".equals(scheme)) {
                return;
            } else {
                Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
                throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
            }
        }
        try {
            c(this.f54402b, this.f54403c);
        } catch (IOException | NullPointerException e5) {
            Log.e("BitmapWorkerTask", "Downloading failed", e5);
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @NonNull
    /* renamed from: b */
    public a doInBackground(Void... voidArr) {
        if (this.f54402b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            f();
            try {
                ParcelFileDescriptor openFileDescriptor = this.f54401a.getContentResolver().openFileDescriptor(this.f54402b, "r");
                if (openFileDescriptor != null) {
                    FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        options.inSampleSize = com.yalantis.ucrop.util.a.a(options, this.f54404d, this.f54405e);
                        boolean z3 = false;
                        options.inJustDecodeBounds = false;
                        Bitmap bitmap = null;
                        while (!z3) {
                            try {
                                bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                                z3 = true;
                            } catch (OutOfMemoryError e4) {
                                Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e4);
                                options.inSampleSize *= 2;
                            }
                        }
                        if (bitmap == null) {
                            return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f54402b + "]"));
                        }
                        com.yalantis.ucrop.util.a.c(openFileDescriptor);
                        int g4 = com.yalantis.ucrop.util.a.g(this.f54401a, this.f54402b);
                        int e5 = com.yalantis.ucrop.util.a.e(g4);
                        int f4 = com.yalantis.ucrop.util.a.f(g4);
                        com.yalantis.ucrop.model.b bVar = new com.yalantis.ucrop.model.b(g4, e5, f4);
                        Matrix matrix = new Matrix();
                        if (e5 != 0) {
                            matrix.preRotate(e5);
                        }
                        if (f4 != 1) {
                            matrix.postScale(f4, 1.0f);
                        }
                        if (!matrix.isIdentity()) {
                            return new a(com.yalantis.ucrop.util.a.h(bitmap, matrix), bVar);
                        }
                        return new a(bitmap, bVar);
                    }
                    return new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f54402b + "]"));
                }
                return new a(new NullPointerException("ParcelFileDescriptor was null for given Uri: [" + this.f54402b + "]"));
            } catch (FileNotFoundException e6) {
                return new a(e6);
            }
        } catch (IOException | NullPointerException e7) {
            return new a(e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e */
    public void onPostExecute(@NonNull a aVar) {
        Exception exc = aVar.f54409c;
        if (exc == null) {
            c1.b bVar = this.f54406f;
            Bitmap bitmap = aVar.f54407a;
            com.yalantis.ucrop.model.b bVar2 = aVar.f54408b;
            String path = this.f54402b.getPath();
            Uri uri = this.f54403c;
            bVar.a(bitmap, bVar2, path, uri == null ? null : uri.getPath());
            return;
        }
        this.f54406f.b(exc);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BitmapLoadTask.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Bitmap f54407a;

        /* renamed from: b  reason: collision with root package name */
        com.yalantis.ucrop.model.b f54408b;

        /* renamed from: c  reason: collision with root package name */
        Exception f54409c;

        public a(@NonNull Bitmap bitmap, @NonNull com.yalantis.ucrop.model.b bVar) {
            this.f54407a = bitmap;
            this.f54408b = bVar;
        }

        public a(@NonNull Exception exc) {
            this.f54409c = exc;
        }
    }
}
