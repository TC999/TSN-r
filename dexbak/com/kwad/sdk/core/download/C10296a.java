package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.clj.fastble.BleManager;
import com.kwad.sdk.C9774c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.C10442r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.p432e.C10753a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11031aw;
import com.kwad.sdk.utils.C11128v;
import com.kwad.sdk.utils.C11130w;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: com.kwad.sdk.core.download.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10296a {
    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10297a {
    }

    @Nullable
    /* renamed from: H */
    public static String m26382H(AdInfo adInfo) {
        return m26373du(DownloadParams.transform(adInfo).mFileUrl);
    }

    /* renamed from: I */
    public static void m26381I(@NonNull AdInfo adInfo) {
        m26380a(adInfo, false);
    }

    /* renamed from: a */
    private static void m26380a(@NonNull AdInfo adInfo, boolean z) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!C11013ag.isNetworkConnected(context)) {
                Context context2 = mContext;
                C11128v.m23672O(context2, C11130w.m23666bX(context2));
                return;
            }
            DownloadParams transform = DownloadParams.transform(adInfo);
            transform.requestInstallPermission = false;
            String str = transform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
                downloadRequest.setDestinationFileName(m26372dv(str));
                downloadRequest.setTag(transform);
                downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
                if (ServiceProvider.m24362KP().showNotification && m26375aW(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                C10753a.m24904a(mContext, transform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: aV */
    public static synchronized void m26376aV(Context context) {
        synchronized (C10296a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    C9774c.m27790xL().init(context);
                    C10303b.m26364De().init(context);
                    mHasInit = true;
                }
            }
        }
    }

    /* renamed from: aW */
    private static boolean m26375aW(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m26374d(String str, File file) {
        try {
            return m26379a(str, file, null, false);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: du */
    private static String m26373du(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return C11031aw.m23995cL(mContext) + File.separator + m26372dv(str);
    }

    /* renamed from: dv */
    private static String m26372dv(String str) {
        return C11010ad.m24144bu(str) + ".apk";
    }

    /* renamed from: dw */
    public static void m26371dw(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        C10753a.m24905C(mContext, str);
    }

    /* renamed from: dx */
    public static void m26370dx(String str) {
        if (mContext == null) {
            return;
        }
        String m26373du = m26373du(str);
        C10753a.m24903e(mContext, C11010ad.m24144bu(str), m26373du);
    }

    /* renamed from: dy */
    private static URLConnection m26369dy(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        C10442r.wrapHttpURLConnection(openConnection);
        openConnection.setRequestProperty("Accept-Language", "zh-CN");
        openConnection.setConnectTimeout(BleManager.f22896l);
        openConnection.setReadTimeout(120000);
        openConnection.setUseCaches(false);
        openConnection.setDoInput(true);
        openConnection.setRequestProperty("Connection", "keep-alive");
        openConnection.setRequestProperty("Charset", "UTF-8");
        return openConnection;
    }

    /* renamed from: a */
    public static void m26378a(String str, File file, boolean z) {
        m26379a(str, file, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115 A[Catch: all -> 0x013f, TryCatch #8 {all -> 0x013f, blocks: (B:58:0x0111, B:60:0x0115, B:62:0x013e, B:61:0x0118), top: B:88:0x0111 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118 A[Catch: all -> 0x013f, TryCatch #8 {all -> 0x013f, blocks: (B:58:0x0111, B:60:0x0115, B:62:0x013e, B:61:0x0118), top: B:88:0x0111 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.File] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m26379a(java.lang.String r10, java.io.File r11, com.kwad.sdk.core.download.C10296a.InterfaceC10297a r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.C10296a.m26379a(java.lang.String, java.io.File, com.kwad.sdk.core.download.a$a, boolean):boolean");
    }

    /* renamed from: a */
    private static InputStream m26377a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                boolean z = false;
                Iterator<String> it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }
}
