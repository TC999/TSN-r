package com.p521ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.p521ss.android.download.api.config.InterfaceC11953a;
import com.p521ss.android.download.api.config.InterfaceC11954bl;
import com.p521ss.android.download.api.config.InterfaceC11955h;
import com.p521ss.android.download.api.config.InterfaceC11956i;
import com.p521ss.android.download.api.config.InterfaceC11957io;
import com.p521ss.android.download.api.config.InterfaceC11958j;
import com.p521ss.android.download.api.config.InterfaceC11959k;
import com.p521ss.android.download.api.config.InterfaceC11961n;
import com.p521ss.android.download.api.config.InterfaceC11963p;
import com.p521ss.android.download.api.config.InterfaceC11964q;
import com.p521ss.android.download.api.config.InterfaceC11965r;
import com.p521ss.android.download.api.config.InterfaceC11966rh;
import com.p521ss.android.download.api.config.InterfaceC11967s;
import com.p521ss.android.download.api.config.InterfaceC11968t;
import com.p521ss.android.download.api.config.InterfaceC11971x;
import com.p521ss.android.download.api.config.InterfaceC11972z;
import com.p521ss.android.download.api.config.InterfaceC11973zz;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.model.C11986ok;
import com.p521ss.android.download.api.p522a.InterfaceC11950ok;
import com.p521ss.android.download.api.p525ok.C11991a;
import com.p521ss.android.download.api.p525ok.C11992ok;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12304p;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12128r {

    /* renamed from: a */
    private static Context f34314a;

    /* renamed from: bl */
    private static InterfaceC11955h f34315bl;

    /* renamed from: h */
    private static InterfaceC11964q f34316h;

    /* renamed from: i */
    private static InterfaceC11957io f34317i;

    /* renamed from: io */
    private static InterfaceC11971x f34318io;

    /* renamed from: j */
    private static InterfaceC11967s f34319j;

    /* renamed from: k */
    private static InterfaceC11953a f34320k;

    /* renamed from: kf */
    private static InterfaceC11963p f34321kf;

    /* renamed from: n */
    private static InterfaceC11958j f34322n;

    /* renamed from: ok */
    public static final JSONObject f34323ok = new JSONObject();

    /* renamed from: p */
    private static InterfaceC11959k f34324p;

    /* renamed from: q */
    private static C11986ok f34325q;

    /* renamed from: r */
    private static InterfaceC12304p f34326r;

    /* renamed from: rh */
    private static InterfaceC11968t f34327rh;

    /* renamed from: s */
    private static InterfaceC11954bl f34328s;

    /* renamed from: t */
    private static InterfaceC11965r f34329t;

    /* renamed from: td */
    private static InterfaceC11972z f34330td;

    /* renamed from: u */
    private static InterfaceC11950ok f34331u;

    /* renamed from: ul */
    private static InterfaceC11973zz f34332ul;

    /* renamed from: x */
    private static InterfaceC11966rh f34333x;

    /* renamed from: z */
    private static InterfaceC11961n f34334z;

    /* renamed from: zz */
    private static InterfaceC11956i f34335zz;

    /* renamed from: a */
    public static void m18969a(Context context) {
        if (f34314a != null || context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return;
        }
        f34314a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @NonNull
    /* renamed from: bl */
    public static InterfaceC11958j m18968bl() {
        if (f34322n == null) {
            f34322n = new C11992ok();
        }
        return f34322n;
    }

    public static Context getContext() {
        Context context = f34314a;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    /* renamed from: h */
    public static InterfaceC11968t m18967h() {
        return f34327rh;
    }

    /* renamed from: i */
    public static InterfaceC11961n m18966i() {
        return f34334z;
    }

    @NonNull
    /* renamed from: io */
    public static InterfaceC11973zz m18965io() {
        if (f34332ul == null) {
            f34332ul = new InterfaceC11973zz() { // from class: com.ss.android.downloadlib.addownload.r.5
                @Override // com.p521ss.android.download.api.config.InterfaceC11973zz
                /* renamed from: ok */
                public void mo18932ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i) {
                }
            };
        }
        return f34332ul;
    }

    @Nullable
    /* renamed from: j */
    public static InterfaceC11953a m18964j() {
        return f34320k;
    }

    @NonNull
    /* renamed from: k */
    public static C11986ok m18963k() {
        if (f34325q == null) {
            f34325q = new C11986ok.C11987ok().m19543ok();
        }
        return f34325q;
    }

    /* renamed from: kf */
    public static InterfaceC12304p m18962kf() {
        if (f34326r == null) {
            f34326r = new InterfaceC12304p() { // from class: com.ss.android.downloadlib.addownload.r.2
                @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12304p
                /* renamed from: ok */
                public void mo18389ok(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return f34326r;
    }

    @NonNull
    /* renamed from: n */
    public static InterfaceC11964q m18961n() {
        if (f34316h == null) {
            f34316h = new C11991a();
        }
        return f34316h;
    }

    /* renamed from: o */
    public static boolean m18960o() {
        return (f34315bl == null || f34321kf == null || f34324p == null || f34320k == null || f34318io == null) ? false : true;
    }

    /* renamed from: ok */
    public static void m18958ok(Context context) {
        if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            f34314a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    /* renamed from: p */
    public static InterfaceC11956i m18947p() {
        if (f34335zz == null) {
            f34335zz = new InterfaceC11956i() { // from class: com.ss.android.downloadlib.addownload.r.3
                @Override // com.p521ss.android.download.api.config.InterfaceC11956i
                /* renamed from: ok */
                public void mo18933ok(String str, int i, JSONObject jSONObject) {
                }
            };
        }
        return f34335zz;
    }

    @NonNull
    /* renamed from: q */
    public static JSONObject m18946q() {
        InterfaceC11959k interfaceC11959k = f34324p;
        if (interfaceC11959k != null && interfaceC11959k.mo19652ok() != null) {
            return f34324p.mo19652ok();
        }
        return f34323ok;
    }

    /* renamed from: r */
    public static InterfaceC11972z m18945r() {
        return f34330td;
    }

    /* renamed from: rh */
    public static String m18944rh() {
        return "1.7.0";
    }

    /* renamed from: s */
    public static InterfaceC11963p m18943s() {
        return f34321kf;
    }

    /* renamed from: t */
    public static InterfaceC11967s m18942t() {
        return f34319j;
    }

    @NonNull
    /* renamed from: td */
    public static InterfaceC11971x m18941td() {
        return f34318io;
    }

    @NonNull
    /* renamed from: u */
    public static InterfaceC11950ok m18940u() {
        if (f34331u == null) {
            f34331u = new InterfaceC11950ok() { // from class: com.ss.android.downloadlib.addownload.r.4
                @Override // com.p521ss.android.download.api.p522a.InterfaceC11950ok
                /* renamed from: ok */
                public void mo18637ok(Throwable th, String str) {
                }
            };
        }
        return f34331u;
    }

    /* renamed from: ul */
    public static String m18939ul() {
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + m18946q().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: x */
    public static InterfaceC11965r m18938x() {
        return f34329t;
    }

    @Nullable
    /* renamed from: z */
    public static InterfaceC11966rh m18937z() {
        return f34333x;
    }

    /* renamed from: zz */
    public static InterfaceC11957io m18936zz() {
        return f34317i;
    }

    @NonNull
    /* renamed from: a */
    public static InterfaceC11954bl m18970a() {
        if (f34328s == null) {
            f34328s = new InterfaceC11954bl() { // from class: com.ss.android.downloadlib.addownload.r.1
                @Override // com.p521ss.android.download.api.config.InterfaceC11954bl
                /* renamed from: ok */
                public void mo18935ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.p521ss.android.download.api.config.InterfaceC11954bl
                /* renamed from: ok */
                public void mo18934ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f34328s;
    }

    /* renamed from: ok */
    public static void m18955ok(@NonNull InterfaceC11955h interfaceC11955h) {
        f34315bl = interfaceC11955h;
    }

    /* renamed from: ok */
    public static void m18954ok(@NonNull InterfaceC11958j interfaceC11958j) {
        f34322n = interfaceC11958j;
    }

    /* renamed from: ok */
    public static void m18952ok(@NonNull InterfaceC11963p interfaceC11963p) {
        f34321kf = interfaceC11963p;
    }

    /* renamed from: ok */
    public static void m18951ok(@NonNull InterfaceC11964q interfaceC11964q) {
        f34316h = interfaceC11964q;
    }

    /* renamed from: ok */
    public static void m18953ok(@NonNull InterfaceC11959k interfaceC11959k) {
        f34324p = interfaceC11959k;
    }

    /* renamed from: ok */
    public static void m18949ok(@NonNull C11986ok c11986ok) {
        f34325q = c11986ok;
    }

    /* renamed from: ok */
    public static void m18956ok(@NonNull InterfaceC11953a interfaceC11953a) {
        f34320k = interfaceC11953a;
    }

    /* renamed from: ok */
    public static InterfaceC11955h m18959ok() {
        return f34315bl;
    }

    /* renamed from: ok */
    public static void m18948ok(String str) {
        C12361s.m18068k().m18048ok(str);
    }

    /* renamed from: ok */
    public static void m18950ok(InterfaceC11971x interfaceC11971x) {
        f34318io = interfaceC11971x;
    }

    /* renamed from: ok */
    public static void m18957ok(InterfaceC11950ok interfaceC11950ok) {
        f34331u = interfaceC11950ok;
    }
}
