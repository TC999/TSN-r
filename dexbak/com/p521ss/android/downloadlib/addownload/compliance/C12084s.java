package com.p521ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.RunnableC12194bl;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12718p;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12084s extends C12718p<Long, Bitmap> {

    /* renamed from: ok */
    private final Map<Long, SoftReference<InterfaceC12088ok>> f34209ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.addownload.compliance.s$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12087a {

        /* renamed from: ok */
        private static C12084s f34216ok = new C12084s();
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.s$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12088ok {
        /* renamed from: ok */
        void mo19123ok(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static int m19130a(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    private C12084s() {
        super(8, 8);
        this.f34209ok = new HashMap();
    }

    /* renamed from: ok */
    public static C12084s m19129ok() {
        return C12087a.f34216ok;
    }

    /* renamed from: ok */
    public void m19126ok(long j, @NonNull InterfaceC12088ok interfaceC12088ok) {
        if (get(Long.valueOf(j)) != null) {
            interfaceC12088ok.mo19123ok(get(Long.valueOf(j)));
        } else {
            this.f34209ok.put(Long.valueOf(j), new SoftReference<>(interfaceC12088ok));
        }
    }

    /* renamed from: ok */
    public void m19127ok(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<InterfaceC12088ok> remove = this.f34209ok.remove(Long.valueOf(j));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().mo19123ok(get(Long.valueOf(j)));
        } else if (TextUtils.isEmpty(str)) {
            C12066h.m19212ok(12, j2);
        } else {
            RunnableC12194bl.m18813ok((RunnableC12194bl.InterfaceC12195ok<Object, R>) new RunnableC12194bl.InterfaceC12195ok<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.s.2
                @Override // com.p521ss.android.downloadlib.p534h.RunnableC12194bl.InterfaceC12195ok
                /* renamed from: ok */
                public Object mo18812ok(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    InterfaceC12635q m17769ok;
                    try {
                        m17769ok = C12490bl.m17769ok(true, 0, str, null);
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        C12713kf.m16531ok(bufferedInputStream);
                        throw th;
                    }
                    if (m17769ok == null) {
                        C12713kf.m16531ok(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(m17769ok.mo16909ok());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i = options.outWidth;
                            int i2 = options.outHeight;
                            int m18792ok = C12197j.m18792ok(C12128r.getContext(), 60.0f);
                            options.inSampleSize = C12084s.m19130a(m18792ok, m18792ok, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            C12270ok.m18539ok().m18522ok("ttd_pref_monitor", jSONObject, j2);
                            C12084s.this.put(Long.valueOf(j), decodeStream);
                            C12713kf.m16531ok(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            C12713kf.m16531ok(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        C12235bl.m18640ok().mo18637ok(e, "BitmapCache loadBitmap");
                        C12713kf.m16531ok(bufferedInputStream);
                        return null;
                    }
                    return null;
                }
            }, (Object) null).m18814ok(new RunnableC12194bl.InterfaceC12195ok<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.s.1
                @Override // com.p521ss.android.downloadlib.p534h.RunnableC12194bl.InterfaceC12195ok
                /* renamed from: ok */
                public Object mo18812ok(Object obj) {
                    SoftReference softReference = (SoftReference) C12084s.this.f34209ok.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((InterfaceC12088ok) softReference.get()).mo19123ok(C12084s.this.get(Long.valueOf(j)));
                    return null;
                }
            }).m18816ok();
        }
    }
}
