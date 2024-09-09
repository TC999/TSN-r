package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.xv;
import com.ss.android.socialbase.downloader.network.gd;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr extends com.ss.android.socialbase.downloader.gd.ev<Long, Bitmap> {

    /* renamed from: c  reason: collision with root package name */
    private final Map<Long, SoftReference<c>> f48491c;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c {
        void c(Bitmap bitmap);
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class w {

        /* renamed from: c  reason: collision with root package name */
        private static sr f48496c = new sr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int w(int i4, int i5, BitmapFactory.Options options) {
        int i6 = options.outWidth;
        if (i6 > i4 || options.outHeight > i5) {
            return Math.min(Math.round(i6 / i4), Math.round(options.outHeight / i5));
        }
        return 1;
    }

    private sr() {
        super(8, 8);
        this.f48491c = new HashMap();
    }

    public static sr c() {
        return w.f48496c;
    }

    public void c(long j4, @NonNull c cVar) {
        if (get(Long.valueOf(j4)) != null) {
            cVar.c(get(Long.valueOf(j4)));
        } else {
            this.f48491c.put(Long.valueOf(j4), new SoftReference<>(cVar));
        }
    }

    public void c(final long j4, final long j5, final String str) {
        if (get(Long.valueOf(j4)) != null) {
            SoftReference<c> remove = this.f48491c.remove(Long.valueOf(j4));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().c(get(Long.valueOf(j4)));
        } else if (TextUtils.isEmpty(str)) {
            r.c(12, j5);
        } else {
            com.ss.android.downloadlib.r.xv.c((xv.c<Object, R>) new xv.c<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.sr.2
                @Override // com.ss.android.downloadlib.r.xv.c
                public Object c(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    gd c4;
                    try {
                        c4 = com.ss.android.socialbase.downloader.downloader.xv.c(true, 0, str, null);
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.gd.f.c(bufferedInputStream);
                        throw th;
                    }
                    if (c4 == null) {
                        com.ss.android.socialbase.downloader.gd.f.c(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(c4.c());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i4 = options.outWidth;
                            int i5 = options.outHeight;
                            int c5 = com.ss.android.downloadlib.r.a.c(k.getContext(), 60.0f);
                            options.inSampleSize = sr.w(c5, c5, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i4));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i5));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            com.ss.android.downloadlib.sr.c.c().c("ttd_pref_monitor", jSONObject, j5);
                            sr.this.put(Long.valueOf(j4), decodeStream);
                            com.ss.android.socialbase.downloader.gd.f.c(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            com.ss.android.socialbase.downloader.gd.f.c(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        com.ss.android.downloadlib.ux.xv.c().c(e, "BitmapCache loadBitmap");
                        com.ss.android.socialbase.downloader.gd.f.c(bufferedInputStream);
                        return null;
                    }
                    return null;
                }
            }, (Object) null).c(new xv.c<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.sr.1
                @Override // com.ss.android.downloadlib.r.xv.c
                public Object c(Object obj) {
                    SoftReference softReference = (SoftReference) sr.this.f48491c.remove(Long.valueOf(j4));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((c) softReference.get()).c(sr.this.get(Long.valueOf(j4)));
                    return null;
                }
            }).c();
        }
    }
}
