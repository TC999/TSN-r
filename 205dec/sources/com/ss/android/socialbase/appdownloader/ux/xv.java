package com.ss.android.socialbase.appdownloader.ux;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.gd.f;
import com.ss.android.socialbase.downloader.network.gd;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static int f49234c = 8;

    /* renamed from: w  reason: collision with root package name */
    private static volatile xv f49235w;
    private c<Integer, Bitmap> xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: c  reason: collision with root package name */
        final int f49238c;

        public c(int i4, int i5) {
            super(i5, 0.75f, true);
            this.f49238c = i4;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f49238c;
        }
    }

    private xv() {
        this.xv = null;
        int i4 = f49234c;
        this.xv = new c<>(i4, i4 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream w(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public static xv c() {
        if (f49235w == null) {
            synchronized (xv.class) {
                if (f49235w == null) {
                    f49235w = new xv();
                }
            }
        }
        return f49235w;
    }

    public Bitmap c(int i4) {
        return this.xv.get(Integer.valueOf(i4));
    }

    public void c(final int i4, final String str) {
        if (TextUtils.isEmpty(str) || c(i4) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.bk().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ux.xv.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable[]] */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e4;
                int i5 = 4;
                i5 = 4;
                i5 = 4;
                i5 = 4;
                i5 = 4;
                try {
                    try {
                        gd c4 = com.ss.android.socialbase.downloader.downloader.xv.c(true, 0, str, null);
                        if (c4 == null) {
                            f.c(null, null, null, null);
                            return;
                        }
                        inputStream = c4.c();
                        try {
                            byteArrayOutputStream = xv.w(inputStream);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                } catch (Exception e5) {
                                    byteArrayInputStream2 = null;
                                    e4 = e5;
                                } catch (Throwable th2) {
                                    byteArrayInputStream2 = null;
                                    th = th2;
                                    Closeable[] closeableArr = new Closeable[i5];
                                    closeableArr[0] = inputStream;
                                    closeableArr[1] = byteArrayOutputStream;
                                    closeableArr[2] = byteArrayInputStream;
                                    closeableArr[3] = byteArrayInputStream2;
                                    f.c(closeableArr);
                                    throw th;
                                }
                            } catch (Exception e6) {
                                byteArrayInputStream2 = null;
                                e4 = e6;
                                byteArrayInputStream = null;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception e7) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e4 = e7;
                            byteArrayOutputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            th = th4;
                            byteArrayOutputStream = null;
                        }
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                            int c5 = com.ss.android.socialbase.appdownloader.xv.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), 44.0f);
                            options.inSampleSize = xv.c(c5, c5, options);
                            options.inJustDecodeBounds = false;
                            xv.this.xv.put(Integer.valueOf(i4), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                            f.c(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                        } catch (Exception e8) {
                            e4 = e8;
                            e4.printStackTrace();
                            i5 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                            f.c((Closeable[]) i5);
                        }
                    } catch (Exception e9) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e4 = e9;
                        inputStream = null;
                    } catch (Throwable th5) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th5;
                        inputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int c(int i4, int i5, BitmapFactory.Options options) {
        int i6 = options.outWidth;
        if (i6 > i4 || options.outHeight > i5) {
            return Math.min(Math.round(i6 / i4), Math.round(options.outHeight / i5));
        }
        return 1;
    }
}
