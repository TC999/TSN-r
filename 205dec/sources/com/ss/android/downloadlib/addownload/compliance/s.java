package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.bl;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.network.q;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s extends com.ss.android.socialbase.downloader.q.p<Long, Bitmap> {
    private final Map<Long, SoftReference<ok>> ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {
        private static s ok = new s();
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok {
        void ok(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i4, int i5, BitmapFactory.Options options) {
        int i6 = options.outWidth;
        if (i6 > i4 || options.outHeight > i5) {
            return Math.min(Math.round(i6 / i4), Math.round(options.outHeight / i5));
        }
        return 1;
    }

    private s() {
        super(8, 8);
        this.ok = new HashMap();
    }

    public static s ok() {
        return a.ok;
    }

    public void ok(long j4, @NonNull ok okVar) {
        if (get(Long.valueOf(j4)) != null) {
            okVar.ok(get(Long.valueOf(j4)));
        } else {
            this.ok.put(Long.valueOf(j4), new SoftReference<>(okVar));
        }
    }

    public void ok(final long j4, final long j5, final String str) {
        if (get(Long.valueOf(j4)) != null) {
            SoftReference<ok> remove = this.ok.remove(Long.valueOf(j4));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().ok(get(Long.valueOf(j4)));
        } else if (TextUtils.isEmpty(str)) {
            h.ok(12, j5);
        } else {
            com.ss.android.downloadlib.h.bl.ok((bl.ok<Object, R>) new bl.ok<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.s.2
                @Override // com.ss.android.downloadlib.h.bl.ok
                public Object ok(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    q ok2;
                    try {
                        ok2 = com.ss.android.socialbase.downloader.downloader.bl.ok(true, 0, str, null);
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                        throw th;
                    }
                    if (ok2 == null) {
                        com.ss.android.socialbase.downloader.q.kf.ok(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(ok2.ok());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i4 = options.outWidth;
                            int i5 = options.outHeight;
                            int ok3 = j.ok(com.ss.android.downloadlib.addownload.r.getContext(), 60.0f);
                            options.inSampleSize = s.a(ok3, ok3, options);
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
                            com.ss.android.downloadlib.s.ok.ok().ok("ttd_pref_monitor", jSONObject, j5);
                            s.this.put(Long.valueOf(j4), decodeStream);
                            com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        com.ss.android.downloadlib.n.bl.ok().ok(e, "BitmapCache loadBitmap");
                        com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                        return null;
                    }
                    return null;
                }
            }, (Object) null).ok(new bl.ok<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.s.1
                @Override // com.ss.android.downloadlib.h.bl.ok
                public Object ok(Object obj) {
                    SoftReference softReference = (SoftReference) s.this.ok.remove(Long.valueOf(j4));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((ok) softReference.get()).ok(s.this.get(Long.valueOf(j4)));
                    return null;
                }
            }).ok();
        }
    }
}
