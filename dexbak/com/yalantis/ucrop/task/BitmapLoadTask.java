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
import com.kuaishou.weapon.p205p0.C7282g;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.C13526e;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import p028c1.BitmapLoadCallback;

/* renamed from: com.yalantis.ucrop.task.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, C13525a> {

    /* renamed from: g */
    private static final String f39864g = "BitmapWorkerTask";

    /* renamed from: a */
    private final Context f39865a;

    /* renamed from: b */
    private Uri f39866b;

    /* renamed from: c */
    private Uri f39867c;

    /* renamed from: d */
    private final int f39868d;

    /* renamed from: e */
    private final int f39869e;

    /* renamed from: f */
    private final BitmapLoadCallback f39870f;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.f39865a = context;
        this.f39866b = uri;
        this.f39867c = uri2;
        this.f39868d = i;
        this.f39869e = i2;
        this.f39870f = bitmapLoadCallback;
    }

    /* renamed from: a */
    private void m13025a(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        Log.d(f39864g, "copyFile");
        if (uri2 != null) {
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = this.f39865a.getContentResolver().openInputStream(uri);
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
                                BitmapLoadUtils.m13017c(fileOutputStream2);
                                BitmapLoadUtils.m13017c(inputStream);
                                this.f39866b = this.f39867c;
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        BitmapLoadUtils.m13017c(fileOutputStream);
                        BitmapLoadUtils.m13017c(inputStream);
                        this.f39866b = this.f39867c;
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

    /* renamed from: c */
    private void m13023c(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        Closeable closeable;
        Response response;
        Response execute;
        BufferedSource source;
        Log.d(f39864g, "downloadFile");
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
                OutputStream openOutputStream = this.f39865a.getContentResolver().openOutputStream(uri2);
                if (openOutputStream != null) {
                    Sink sink = Okio.sink(openOutputStream);
                    source.readAll(sink);
                    BitmapLoadUtils.m13017c(source);
                    BitmapLoadUtils.m13017c(sink);
                    BitmapLoadUtils.m13017c(execute.body());
                    okHttpClient.dispatcher().cancelAll();
                    this.f39866b = this.f39867c;
                    return;
                }
                throw new NullPointerException("OutputStream for given output Uri is null");
            } catch (Throwable th3) {
                th = th3;
                response = execute;
                closeable = null;
                bufferedSource = source;
                BitmapLoadUtils.m13017c(bufferedSource);
                BitmapLoadUtils.m13017c(closeable);
                if (response != null) {
                    BitmapLoadUtils.m13017c(response.body());
                }
                okHttpClient.dispatcher().cancelAll();
                this.f39866b = this.f39867c;
                throw th;
            }
        }
        throw new NullPointerException("Output Uri is null - cannot download image");
    }

    /* renamed from: d */
    private String m13022d() {
        if (ContextCompat.checkSelfPermission(this.f39865a, C7282g.f24951i) == 0) {
            return C13526e.m13001c(this.f39865a, this.f39866b);
        }
        return null;
    }

    /* renamed from: f */
    private void m13020f() throws NullPointerException, IOException {
        String scheme = this.f39866b.getScheme();
        Log.d(f39864g, "Uri scheme: " + scheme);
        if (!IDataSource.f43971a.equals(scheme) && !"https".equals(scheme)) {
            if ("content".equals(scheme)) {
                String m13022d = m13022d();
                if (!TextUtils.isEmpty(m13022d) && new File(m13022d).exists()) {
                    this.f39866b = Uri.fromFile(new File(m13022d));
                    return;
                }
                try {
                    m13025a(this.f39866b, this.f39867c);
                    return;
                } catch (IOException | NullPointerException e) {
                    Log.e(f39864g, "Copying failed", e);
                    throw e;
                }
            } else if (IDataSource.f43973c.equals(scheme)) {
                return;
            } else {
                Log.e(f39864g, "Invalid Uri scheme " + scheme);
                throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
            }
        }
        try {
            m13023c(this.f39866b, this.f39867c);
        } catch (IOException | NullPointerException e2) {
            Log.e(f39864g, "Downloading failed", e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @NonNull
    /* renamed from: b */
    public C13525a doInBackground(Void... voidArr) {
        if (this.f39866b == null) {
            return new C13525a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            m13020f();
            try {
                ParcelFileDescriptor openFileDescriptor = this.f39865a.getContentResolver().openFileDescriptor(this.f39866b, "r");
                if (openFileDescriptor != null) {
                    FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        options.inSampleSize = BitmapLoadUtils.m13019a(options, this.f39868d, this.f39869e);
                        boolean z = false;
                        options.inJustDecodeBounds = false;
                        Bitmap bitmap = null;
                        while (!z) {
                            try {
                                bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                                z = true;
                            } catch (OutOfMemoryError e) {
                                Log.e(f39864g, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e);
                                options.inSampleSize *= 2;
                            }
                        }
                        if (bitmap == null) {
                            return new C13525a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f39866b + "]"));
                        }
                        BitmapLoadUtils.m13017c(openFileDescriptor);
                        int m13013g = BitmapLoadUtils.m13013g(this.f39865a, this.f39866b);
                        int m13015e = BitmapLoadUtils.m13015e(m13013g);
                        int m13014f = BitmapLoadUtils.m13014f(m13013g);
                        ExifInfo exifInfo = new ExifInfo(m13013g, m13015e, m13014f);
                        Matrix matrix = new Matrix();
                        if (m13015e != 0) {
                            matrix.preRotate(m13015e);
                        }
                        if (m13014f != 1) {
                            matrix.postScale(m13014f, 1.0f);
                        }
                        if (!matrix.isIdentity()) {
                            return new C13525a(BitmapLoadUtils.m13012h(bitmap, matrix), exifInfo);
                        }
                        return new C13525a(bitmap, exifInfo);
                    }
                    return new C13525a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f39866b + "]"));
                }
                return new C13525a(new NullPointerException("ParcelFileDescriptor was null for given Uri: [" + this.f39866b + "]"));
            } catch (FileNotFoundException e2) {
                return new C13525a(e2);
            }
        } catch (IOException | NullPointerException e3) {
            return new C13525a(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e */
    public void onPostExecute(@NonNull C13525a c13525a) {
        Exception exc = c13525a.f39873c;
        if (exc == null) {
            BitmapLoadCallback bitmapLoadCallback = this.f39870f;
            Bitmap bitmap = c13525a.f39871a;
            ExifInfo exifInfo = c13525a.f39872b;
            String path = this.f39866b.getPath();
            Uri uri = this.f39867c;
            bitmapLoadCallback.mo12926a(bitmap, exifInfo, path, uri == null ? null : uri.getPath());
            return;
        }
        this.f39870f.mo12925b(exc);
    }

    /* compiled from: BitmapLoadTask.java */
    /* renamed from: com.yalantis.ucrop.task.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13525a {

        /* renamed from: a */
        Bitmap f39871a;

        /* renamed from: b */
        ExifInfo f39872b;

        /* renamed from: c */
        Exception f39873c;

        public C13525a(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.f39871a = bitmap;
            this.f39872b = exifInfo;
        }

        public C13525a(@NonNull Exception exc) {
            this.f39873c = exc;
        }
    }
}
