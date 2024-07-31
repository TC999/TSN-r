package com.p521ss.android.downloadlib.addownload.p531ok;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.config.InterfaceC11958j;
import com.p521ss.android.download.api.model.C11980a;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12036ok;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12117ok {

    /* renamed from: a */
    private static C12117ok f34292a = null;

    /* renamed from: ok */
    private static final String f34293ok = "ok";
    @NonNull

    /* renamed from: bl */
    private CopyOnWriteArrayList<C12036ok> f34294bl;

    /* renamed from: kf */
    private C12110a f34295kf;

    /* renamed from: n */
    private String f34296n;

    /* renamed from: s */
    private boolean f34297s = false;

    /* renamed from: com.ss.android.downloadlib.addownload.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12119ok {
        /* renamed from: ok */
        void mo19013ok();
    }

    private C12117ok() {
        C12110a c12110a = new C12110a();
        this.f34295kf = c12110a;
        this.f34294bl = c12110a.m19042ok("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    /* renamed from: ok */
    public static C12117ok m19022ok() {
        if (f34292a == null) {
            f34292a = new C12117ok();
        }
        return f34292a;
    }

    /* renamed from: a */
    public void m19023a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f34296n = "";
        } else if (TextUtils.equals(this.f34296n, str)) {
            this.f34296n = "";
        }
    }

    /* renamed from: ok */
    private boolean m19020ok(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC12119ok interfaceC12119ok) {
        if (downloadInfo == null) {
            try {
                if (this.f34294bl.isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f34294bl.isEmpty()) {
                m19016ok(activity, new C12036ok(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC12119ok);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<C12036ok> copyOnWriteArrayList = this.f34294bl;
            ListIterator<C12036ok> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                C12036ok previous = listIterator.previous();
                if (previous != null && !C12197j.m18796n(C12128r.getContext(), previous.f34088s) && C12197j.m18784ok(previous.f34083h)) {
                    if (new File(previous.f34083h).lastModified() >= lastModified) {
                        m19016ok(activity, previous, z, interfaceC12119ok);
                    } else {
                        m19016ok(activity, new C12036ok(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC12119ok);
                    }
                }
            }
            String str = f34293ok;
            C12216r.m18673ok(str, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    @MainThread
    /* renamed from: ok */
    public boolean m19019ok(Activity activity, boolean z, InterfaceC12119ok interfaceC12119ok) {
        if (C12128r.m18946q().optInt("disable_install_app_dialog") == 1 || this.f34297s) {
            return false;
        }
        return m19020ok(activity, m19018ok(activity), z, interfaceC12119ok);
    }

    /* renamed from: ok */
    public void m19016ok(Context context, C12036ok c12036ok, boolean z, InterfaceC12119ok interfaceC12119ok) {
        this.f34294bl.clear();
        m19017ok(context, c12036ok, interfaceC12119ok, z);
        this.f34297s = true;
        C12257p.m18572ok(context).m18577bl();
        this.f34295kf.m19043a("sp_ad_install_back_dialog", "key_uninstalled_list");
        C12216r.m18673ok(f34293ok, "tryShowInstallDialog isShow:true", null);
    }

    /* renamed from: ok */
    public DownloadInfo m19018ok(Context context) {
        long m18581a;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            m18581a = C12257p.m18572ok(context).m18581a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (C12128r.m18946q().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !C12197j.m18796n(context, downloadInfo2.getPackageName()) && C12197j.m18784ok(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= m18581a && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                downloadInfo = downloadInfo2;
                                j = lastModified;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    /* renamed from: ok */
    public void m19021ok(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.f34294bl.size(); i++) {
            C12036ok c12036ok = this.f34294bl.get(i);
            if (c12036ok != null && c12036ok.f34081a == j2) {
                this.f34294bl.set(i, new C12036ok(j, j2, j3, str, str2, str3, str4));
                this.f34295kf.m19041ok("sp_ad_install_back_dialog", "key_uninstalled_list", this.f34294bl);
                return;
            }
        }
        this.f34294bl.add(new C12036ok(j, j2, j3, str, str2, str3, str4));
        this.f34295kf.m19041ok("sp_ad_install_back_dialog", "key_uninstalled_list", this.f34294bl);
    }

    /* renamed from: ok */
    private void m19017ok(final Context context, final C12036ok c12036ok, final InterfaceC12119ok interfaceC12119ok, boolean z) {
        final C11998a m19311s = C12032kf.m19324ok().m19311s(c12036ok.f34081a);
        if (m19311s == null) {
            C12235bl.m18640ok().m18639ok("showBackInstallDialog nativeModel null");
            return;
        }
        InterfaceC11958j m18968bl = C12128r.m18968bl();
        C11980a.C11983ok m19598ok = new C11980a.C11983ok(context).m19598ok(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(c12036ok.f34085n) ? "刚刚下载的应用" : c12036ok.f34085n;
        m18968bl.mo19529a(m19598ok.m19609a(String.format("%1$s下载完成，是否立即安装？", objArr)).m19607bl("立即安装").m19594s(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().labelRes))).m19597ok(false).m19601ok(C12197j.m18790ok(context, c12036ok.f34083h)).m19600ok(new C11980a.InterfaceC11982a() { // from class: com.ss.android.downloadlib.addownload.ok.ok.1
            @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
            /* renamed from: a */
            public void mo18862a(DialogInterface dialogInterface) {
                C12270ok.m18539ok().m18541a("backdialog_exit", m19311s);
                InterfaceC12119ok interfaceC12119ok2 = interfaceC12119ok;
                if (interfaceC12119ok2 != null) {
                    interfaceC12119ok2.mo19013ok();
                }
                C12117ok.this.m19023a("");
                dialogInterface.dismiss();
            }

            @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
            /* renamed from: bl */
            public void mo18861bl(DialogInterface dialogInterface) {
                C12117ok.this.m19023a("");
            }

            @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
            /* renamed from: ok */
            public void mo18860ok(DialogInterface dialogInterface) {
                C12270ok.m18539ok().m18541a("backdialog_install", m19311s);
                C12361s.m18063ok(context, (int) c12036ok.f34086ok);
                dialogInterface.dismiss();
            }
        }).m19602ok(1).m19603ok());
        C12270ok.m18539ok().m18541a("backdialog_show", m19311s);
        this.f34296n = c12036ok.f34088s;
    }

    /* renamed from: ok */
    public boolean m19014ok(String str) {
        return TextUtils.equals(this.f34296n, str);
    }

    /* renamed from: ok */
    public void m19015ok(C11998a c11998a) {
        if (C12128r.m18946q().optInt("enable_open_app_dialog", 0) == 1 && !c11998a.m19515cf() && c11998a.mo19288x() && Build.VERSION.SDK_INT < 34) {
            c11998a.m19457r(true);
            TTDelegateActivity.m19356ok(c11998a);
        }
    }
}
