package com.p521ss.android.socialbase.appdownloader.p545n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.appdownloader.n.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12332bl {

    /* renamed from: a */
    private static volatile C12332bl f34784a = null;

    /* renamed from: ok */
    private static int f34785ok = 8;

    /* renamed from: bl */
    private C12334ok<Integer, Bitmap> f34786bl;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.n.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12334ok<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: ok */
        final int f34790ok;

        public C12334ok(int i, int i2) {
            super(i2, 0.75f, true);
            this.f34790ok = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f34790ok;
        }
    }

    private C12332bl() {
        this.f34786bl = null;
        int i = f34785ok;
        this.f34786bl = new C12334ok<>(i, i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static ByteArrayOutputStream m18134a(InputStream inputStream) throws IOException {
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

    /* renamed from: ok */
    public static C12332bl m18133ok() {
        if (f34784a == null) {
            synchronized (C12332bl.class) {
                if (f34784a == null) {
                    f34784a = new C12332bl();
                }
            }
        }
        return f34784a;
    }

    /* renamed from: ok */
    public Bitmap m18132ok(int i) {
        return this.f34786bl.get(Integer.valueOf(i));
    }

    /* renamed from: ok */
    public void m18130ok(final int i, final String str) {
        if (TextUtils.isEmpty(str) || m18132ok(i) != null) {
            return;
        }
        C12490bl.m17745z().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.n.bl.1
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
                Exception e;
                int i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                try {
                    try {
                        InterfaceC12635q m17769ok = C12490bl.m17769ok(true, 0, str, null);
                        if (m17769ok == null) {
                            C12713kf.m16531ok(null, null, null, null);
                            return;
                        }
                        inputStream = m17769ok.mo16909ok();
                        try {
                            byteArrayOutputStream = C12332bl.m18134a(inputStream);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                } catch (Exception e2) {
                                    byteArrayInputStream2 = null;
                                    e = e2;
                                } catch (Throwable th2) {
                                    byteArrayInputStream2 = null;
                                    th = th2;
                                    Closeable[] closeableArr = new Closeable[i2];
                                    closeableArr[0] = inputStream;
                                    closeableArr[1] = byteArrayOutputStream;
                                    closeableArr[2] = byteArrayInputStream;
                                    closeableArr[3] = byteArrayInputStream2;
                                    C12713kf.m16531ok(closeableArr);
                                    throw th;
                                }
                            } catch (Exception e3) {
                                byteArrayInputStream2 = null;
                                e = e3;
                                byteArrayInputStream = null;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception e4) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e = e4;
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
                            int m18424ok = C12293bl.m18424ok(C12490bl.m17807l(), 44.0f);
                            options.inSampleSize = C12332bl.m18131ok(m18424ok, m18424ok, options);
                            options.inJustDecodeBounds = false;
                            C12332bl.this.f34786bl.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                            C12713kf.m16531ok(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                        } catch (Exception e5) {
                            e = e5;
                            e.printStackTrace();
                            i2 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                            C12713kf.m16531ok((Closeable[]) i2);
                        }
                    } catch (Exception e6) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e = e6;
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

    /* renamed from: ok */
    public static int m18131ok(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
