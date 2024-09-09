package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.io;
import com.ss.android.download.api.config.rh;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.config.zz;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ok;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.io.File;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static Context f48590a;
    private static com.ss.android.download.api.config.h bl;

    /* renamed from: h  reason: collision with root package name */
    private static com.ss.android.download.api.config.q f48591h;

    /* renamed from: i  reason: collision with root package name */
    private static io f48592i;

    /* renamed from: io  reason: collision with root package name */
    private static x f48593io;

    /* renamed from: j  reason: collision with root package name */
    private static com.ss.android.download.api.config.s f48594j;

    /* renamed from: k  reason: collision with root package name */
    private static com.ss.android.download.api.config.a f48595k;
    private static com.ss.android.download.api.config.p kf;

    /* renamed from: n  reason: collision with root package name */
    private static com.ss.android.download.api.config.j f48596n;
    public static final JSONObject ok = new JSONObject();

    /* renamed from: p  reason: collision with root package name */
    private static com.ss.android.download.api.config.k f48597p;

    /* renamed from: q  reason: collision with root package name */
    private static com.ss.android.download.api.model.ok f48598q;

    /* renamed from: r  reason: collision with root package name */
    private static com.ss.android.socialbase.appdownloader.bl.p f48599r;
    private static t rh;

    /* renamed from: s  reason: collision with root package name */
    private static com.ss.android.download.api.config.bl f48600s;

    /* renamed from: t  reason: collision with root package name */
    private static com.ss.android.download.api.config.r f48601t;
    private static com.ss.android.download.api.config.z td;

    /* renamed from: u  reason: collision with root package name */
    private static com.ss.android.download.api.a.ok f48602u;
    private static zz ul;

    /* renamed from: x  reason: collision with root package name */
    private static rh f48603x;

    /* renamed from: z  reason: collision with root package name */
    private static com.ss.android.download.api.config.n f48604z;
    private static i zz;

    public static void a(Context context) {
        if (f48590a != null || context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return;
        }
        f48590a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @NonNull
    public static com.ss.android.download.api.config.j bl() {
        if (f48596n == null) {
            f48596n = new com.ss.android.download.api.ok.ok();
        }
        return f48596n;
    }

    public static Context getContext() {
        Context context = f48590a;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static t h() {
        return rh;
    }

    public static com.ss.android.download.api.config.n i() {
        return f48604z;
    }

    @NonNull
    public static zz io() {
        if (ul == null) {
            ul = new zz() { // from class: com.ss.android.downloadlib.addownload.r.5
                @Override // com.ss.android.download.api.config.zz
                public void ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i4) {
                }
            };
        }
        return ul;
    }

    @Nullable
    public static com.ss.android.download.api.config.a j() {
        return f48595k;
    }

    @NonNull
    public static com.ss.android.download.api.model.ok k() {
        if (f48598q == null) {
            f48598q = new ok.C0937ok().ok();
        }
        return f48598q;
    }

    public static com.ss.android.socialbase.appdownloader.bl.p kf() {
        if (f48599r == null) {
            f48599r = new com.ss.android.socialbase.appdownloader.bl.p() { // from class: com.ss.android.downloadlib.addownload.r.2
                @Override // com.ss.android.socialbase.appdownloader.bl.p
                public void ok(DownloadInfo downloadInfo, BaseException baseException, int i4) {
                }
            };
        }
        return f48599r;
    }

    @NonNull
    public static com.ss.android.download.api.config.q n() {
        if (f48591h == null) {
            f48591h = new com.ss.android.download.api.ok.a();
        }
        return f48591h;
    }

    public static boolean o() {
        return (bl == null || kf == null || f48597p == null || f48595k == null || f48593io == null) ? false : true;
    }

    public static void ok(Context context) {
        if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            f48590a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    public static i p() {
        if (zz == null) {
            zz = new i() { // from class: com.ss.android.downloadlib.addownload.r.3
                public void ok(String str, int i4, JSONObject jSONObject) {
                }
            };
        }
        return zz;
    }

    @NonNull
    public static JSONObject q() {
        com.ss.android.download.api.config.k kVar = f48597p;
        if (kVar != null && kVar.ok() != null) {
            return f48597p.ok();
        }
        return ok;
    }

    public static com.ss.android.download.api.config.z r() {
        return td;
    }

    public static String rh() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.p s() {
        return kf;
    }

    public static com.ss.android.download.api.config.s t() {
        return f48594j;
    }

    @NonNull
    public static x td() {
        return f48593io;
    }

    @NonNull
    public static com.ss.android.download.api.a.ok u() {
        if (f48602u == null) {
            f48602u = new com.ss.android.download.api.a.ok() { // from class: com.ss.android.downloadlib.addownload.r.4
                @Override // com.ss.android.download.api.a.ok
                public void ok(Throwable th, String str) {
                }
            };
        }
        return f48602u;
    }

    public static String ul() {
        try {
            int i4 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i4 == 29 && !Environment.isExternalStorageLegacy()) || i4 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + q().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static com.ss.android.download.api.config.r x() {
        return f48601t;
    }

    @Nullable
    public static rh z() {
        return f48603x;
    }

    public static io zz() {
        return f48592i;
    }

    @NonNull
    public static com.ss.android.download.api.config.bl a() {
        if (f48600s == null) {
            f48600s = new com.ss.android.download.api.config.bl() { // from class: com.ss.android.downloadlib.addownload.r.1
                @Override // com.ss.android.download.api.config.bl
                public void ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.bl
                public void ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f48600s;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.h hVar) {
        bl = hVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.j jVar) {
        f48596n = jVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.p pVar) {
        kf = pVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.q qVar) {
        f48591h = qVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.k kVar) {
        f48597p = kVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.model.ok okVar) {
        f48598q = okVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.a aVar) {
        f48595k = aVar;
    }

    public static com.ss.android.download.api.config.h ok() {
        return bl;
    }

    public static void ok(String str) {
        com.ss.android.socialbase.appdownloader.s.k().ok(str);
    }

    public static void ok(x xVar) {
        f48593io = xVar;
    }

    public static void ok(com.ss.android.download.api.a.ok okVar) {
        f48602u = okVar;
    }
}
