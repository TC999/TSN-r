package com.ss.android.socialbase.appdownloader.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.q;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bl f49151a = null;
    private static int ok = 8;
    private ok<Integer, Bitmap> bl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok<K, T> extends LinkedHashMap<K, T> {
        final int ok;

        public ok(int i4, int i5) {
            super(i5, 0.75f, true);
            this.ok = i4;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.ok;
        }
    }

    private bl() {
        this.bl = null;
        int i4 = ok;
        this.bl = new ok<>(i4, i4 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream a(InputStream inputStream) throws IOException {
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

    public static bl ok() {
        if (f49151a == null) {
            synchronized (bl.class) {
                if (f49151a == null) {
                    f49151a = new bl();
                }
            }
        }
        return f49151a;
    }

    public Bitmap ok(int i4) {
        return this.bl.get(Integer.valueOf(i4));
    }

    public void ok(final int i4, final String str) {
        if (TextUtils.isEmpty(str) || ok(i4) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.z().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.n.bl.1
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
                        q ok2 = com.ss.android.socialbase.downloader.downloader.bl.ok(true, 0, str, null);
                        if (ok2 == null) {
                            kf.ok(null, null, null, null);
                            return;
                        }
                        inputStream = ok2.ok();
                        try {
                            byteArrayOutputStream = bl.a(inputStream);
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
                                    kf.ok(closeableArr);
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
                            int ok3 = com.ss.android.socialbase.appdownloader.bl.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), 44.0f);
                            options.inSampleSize = bl.ok(ok3, ok3, options);
                            options.inJustDecodeBounds = false;
                            bl.this.bl.put(Integer.valueOf(i4), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                            kf.ok(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                        } catch (Exception e8) {
                            e4 = e8;
                            e4.printStackTrace();
                            i5 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                            kf.ok((Closeable[]) i5);
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

    public static int ok(int i4, int i5, BitmapFactory.Options options) {
        int i6 = options.outWidth;
        if (i6 > i4 || options.outHeight > i5) {
            return Math.min(Math.round(i6 / i4), Math.round(options.outHeight / i5));
        }
        return 1;
    }
}
