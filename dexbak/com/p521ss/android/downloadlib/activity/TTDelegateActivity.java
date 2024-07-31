package com.p521ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.p521ss.android.download.api.config.InterfaceC11958j;
import com.p521ss.android.download.api.config.InterfaceC11970u;
import com.p521ss.android.download.api.model.C11980a;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.C12159z;
import com.p521ss.android.downloadlib.addownload.compliance.DialogC12076ok;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p531ok.DialogC12112n;
import com.p521ss.android.downloadlib.guide.install.InterfaceC12183ok;
import com.p521ss.android.downloadlib.p527a.C12018ok;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12198k;
import com.p521ss.android.downloadlib.p534h.C12205p;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: s */
    private static InterfaceC12183ok f34035s;

    /* renamed from: a */
    private boolean f34036a;

    /* renamed from: bl */
    private C11998a f34037bl;

    /* renamed from: ok */
    protected Intent f34038ok = null;

    static {
        StubApp.interface11(22606);
    }

    /* renamed from: a */
    public static void m19364a(String str, InterfaceC11999ok interfaceC11999ok) {
        Intent m19360bl = m19360bl(interfaceC11999ok);
        m19360bl.addFlags(268435456);
        m19360bl.putExtra("type", 11);
        m19360bl.putExtra("package_name", str);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(m19360bl);
        }
    }

    /* renamed from: bl */
    private static Intent m19360bl(@NonNull InterfaceC11999ok interfaceC11999ok) {
        return new Intent(C12128r.getContext(), TTDelegateActivity.class);
    }

    /* renamed from: ok */
    public static void m19345ok(String str, String[] strArr) {
        Intent intent = new Intent(C12128r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY, str);
        intent.putExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_CONTENT_KEY, strArr);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f34038ok = intent;
        C12128r.m18969a(this);
        mo19359ok();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public native void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    @Override // android.app.Activity
    protected void onStop() {
        C11998a c11998a;
        DownloadInfo m18578a;
        super.onStop();
        if (!this.f34036a || (c11998a = this.f34037bl) == null) {
            return;
        }
        if (!TextUtils.isEmpty(c11998a.m19480ld())) {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18563ok(this.f34037bl.m19480ld(), null, true);
        } else {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18578a(this.f34037bl.mo19298ok());
        }
        if (m18578a == null || m18578a.getCurBytes() < m18578a.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: bl */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m19362bl() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.downloadlib.activity.TTDelegateActivity.m19362bl():void");
    }

    /* renamed from: a */
    public static void m19365a(String str, long j, String str2) {
        Intent intent = new Intent(C12128r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(intent);
        }
    }

    /* renamed from: ok */
    public static void m19346ok(String str, InterfaceC11999ok interfaceC11999ok) {
        Intent m19360bl = m19360bl(interfaceC11999ok);
        m19360bl.addFlags(268435456);
        m19360bl.putExtra("type", 2);
        m19360bl.putExtra("open_url", str);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(m19360bl);
        }
    }

    /* renamed from: ok */
    public static void m19356ok(InterfaceC11999ok interfaceC11999ok) {
        Intent m19360bl = m19360bl(interfaceC11999ok);
        m19360bl.addFlags(268435456);
        m19360bl.putExtra("type", 4);
        m19360bl.putExtra("model_id", interfaceC11999ok.mo19309a());
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(m19360bl);
        }
    }

    /* renamed from: a */
    public static void m19369a(@NonNull InterfaceC11999ok interfaceC11999ok) {
        m19355ok(interfaceC11999ok, 5, "", "", "", "");
    }

    /* renamed from: a */
    public static void m19368a(@NonNull InterfaceC11999ok interfaceC11999ok, String str, String str2, String str3) {
        m19355ok(interfaceC11999ok, 7, str, str2, str3, "");
    }

    /* renamed from: a */
    public static void m19367a(@NonNull InterfaceC11999ok interfaceC11999ok, String str, String str2, String str3, String str4) {
        m19355ok(interfaceC11999ok, 20, str, str2, str3, str4);
    }

    /* renamed from: a */
    private void m19371a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* renamed from: ok */
    public static void m19354ok(InterfaceC11999ok interfaceC11999ok, InterfaceC12183ok interfaceC12183ok) {
        Intent m19360bl = m19360bl(interfaceC11999ok);
        m19360bl.addFlags(268435456);
        m19360bl.putExtra("type", 9);
        f34035s = interfaceC12183ok;
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(m19360bl);
        }
    }

    /* renamed from: a */
    private void m19363a(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            InterfaceC11970u interfaceC11970u = new InterfaceC11970u() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1

                /* renamed from: bl */
                private WeakReference<Activity> f34040bl;

                {
                    this.f34040bl = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.p521ss.android.download.api.config.InterfaceC11970u
                /* renamed from: ok */
                public void mo18984ok() {
                    C12198k.m18767ok(str);
                    C12293bl.m18426ok(this.f34040bl.get());
                }

                @Override // com.p521ss.android.download.api.config.InterfaceC11970u
                /* renamed from: ok */
                public void mo18983ok(String str2) {
                    C12198k.m18765ok(str, str2);
                    C12293bl.m18426ok(this.f34040bl.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    C12128r.m18961n().mo19531ok(this, strArr, interfaceC11970u);
                    return;
                } catch (Exception e) {
                    C12128r.m18940u().mo18637ok(e, "requestPermission");
                    interfaceC11970u.mo18984ok();
                    return;
                }
            }
            interfaceC11970u.mo18984ok();
            return;
        }
        C12293bl.m18426ok((Activity) this);
    }

    /* renamed from: ok */
    public static void m19358ok(long j) {
        Intent intent = new Intent(C12128r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m19366a(String str) {
        Intent m18799h = C12197j.m18799h(this, str);
        if (m18799h == null) {
            return;
        }
        try {
            try {
                m18799h.addFlags(268435456);
                m18799h.putExtra("start_only_for_android", true);
                startActivity(m18799h);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            C12293bl.m18426ok((Activity) this);
        }
    }

    /* renamed from: ok */
    public static void m19347ok(String str, long j, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(C12128r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m19370a(long j) {
        final C11998a m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19311s == null) {
            C12235bl.m18640ok().m18639ok("showOpenAppDialogInner nativeModel null");
            C12293bl.m18426ok((Activity) this);
            return;
        }
        InterfaceC11958j m18968bl = C12128r.m18968bl();
        C11980a.C11983ok m19598ok = new C11980a.C11983ok(this).m19598ok("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(m19311s.m19521ah()) ? "刚刚下载的应用" : m19311s.m19521ah();
        m18968bl.mo19529a(m19598ok.m19609a(String.format("%1$s已安装完成，是否立即打开？", objArr)).m19607bl("打开").m19594s("取消").m19597ok(false).m19601ok(C12197j.m18770s(this, m19311s.mo19300n())).m19600ok(new C11980a.InterfaceC11982a() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
            /* renamed from: a */
            public void mo18862a(DialogInterface dialogInterface) {
                C12270ok.m18539ok().m18541a("market_openapp_cancel", m19311s);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                C12293bl.m18426ok((Activity) TTDelegateActivity.this);
            }

            @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
            /* renamed from: bl */
            public void mo18861bl(DialogInterface dialogInterface) {
                C12293bl.m18426ok((Activity) TTDelegateActivity.this);
            }

            @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
            /* renamed from: ok */
            public void mo18860ok(DialogInterface dialogInterface) {
                C12018ok.m19385a(m19311s);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                C12293bl.m18426ok((Activity) TTDelegateActivity.this);
            }
        }).m19602ok(2).m19603ok());
        C12270ok.m18539ok().m18541a("market_openapp_window_show", m19311s);
    }

    /* renamed from: ok */
    public static void m19348ok(String str, long j, String str2) {
        Intent intent = new Intent(C12128r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(intent);
        }
    }

    /* renamed from: ok */
    public static void m19349ok(String str, long j) {
        Intent intent = new Intent(C12128r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(intent);
        }
    }

    /* renamed from: bl */
    private void m19361bl(long j) {
        new DialogC12076ok(this, j).show();
    }

    /* renamed from: ok */
    public static void m19353ok(@NonNull InterfaceC11999ok interfaceC11999ok, String str) {
        m19355ok(interfaceC11999ok, 19, "", "", "", str);
    }

    /* renamed from: ok */
    public static void m19352ok(@NonNull InterfaceC11999ok interfaceC11999ok, String str, String str2, String str3) {
        m19355ok(interfaceC11999ok, 8, str, str2, str3, "");
    }

    /* renamed from: ok */
    public static void m19351ok(@NonNull InterfaceC11999ok interfaceC11999ok, String str, String str2, String str3, String str4) {
        m19355ok(interfaceC11999ok, 21, str, str2, str3, str4);
    }

    /* renamed from: ok */
    private static void m19355ok(@NonNull InterfaceC11999ok interfaceC11999ok, int i, String str, String str2, String str3, String str4) {
        Intent m19360bl = m19360bl(interfaceC11999ok);
        m19360bl.addFlags(268435456);
        m19360bl.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            m19360bl.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            m19360bl.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            m19360bl.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            m19360bl.putExtra("message_text", str);
        }
        m19360bl.putExtra("model_id", interfaceC11999ok.mo19309a());
        if (C12128r.getContext() != null) {
            C12128r.getContext().startActivity(m19360bl);
        }
    }

    /* renamed from: ok */
    protected void mo19359ok() {
        Intent intent = this.f34038ok;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                m19363a(this.f34038ok.getStringExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY), this.f34038ok.getStringArrayExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_CONTENT_KEY));
                break;
            case 2:
                m19350ok(this.f34038ok.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            case 16:
            case 17:
            case 18:
            default:
                C12293bl.m18426ok((Activity) this);
                break;
            case 4:
                m19370a(this.f34038ok.getLongExtra("model_id", 0L));
                break;
            case 5:
                m19357ok(this.f34038ok.getLongExtra("model_id", 0L), "");
                break;
            case 7:
            case 8:
            case 20:
            case 21:
                m19362bl();
                break;
            case 9:
                InterfaceC12183ok interfaceC12183ok = f34035s;
                if (interfaceC12183ok != null) {
                    interfaceC12183ok.mo18662ok();
                }
                C12293bl.m18426ok((Activity) this);
                break;
            case 10:
                m19361bl(this.f34038ok.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                m19366a(this.f34038ok.getStringExtra("package_name"));
                break;
            case 12:
                C12205p.m18707ok(this, this.f34038ok.getStringExtra("package_name"), this.f34038ok.getLongExtra("model_id", 0L), this.f34038ok.getStringExtra("param"), this.f34038ok.getStringExtra("ext_json"));
                C12293bl.m18426ok((Activity) this);
                break;
            case 13:
                C12205p.m18708ok(this, this.f34038ok.getStringExtra("package_name"), this.f34038ok.getLongExtra("model_id", 0L), this.f34038ok.getStringExtra("need_comment"));
                C12293bl.m18426ok((Activity) this);
                break;
            case 14:
                C12205p.m18725a(this, this.f34038ok.getStringExtra("package_name"), this.f34038ok.getLongExtra("model_id", 0L), this.f34038ok.getStringExtra("market_app_id"));
                C12293bl.m18426ok((Activity) this);
                break;
            case 15:
                C12205p.m18709ok(this, this.f34038ok.getStringExtra("package_name"), this.f34038ok.getLongExtra("model_id", 0L));
                C12293bl.m18426ok((Activity) this);
                break;
            case 19:
                m19357ok(this.f34038ok.getLongExtra("model_id", 0L), this.f34038ok.getStringExtra("delete_button_text"));
                break;
        }
        this.f34038ok = null;
    }

    /* renamed from: ok */
    private void m19357ok(long j, String str) {
        if (C12159z.m18876ok() == null) {
            return;
        }
        C11998a m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19311s != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(m19311s.mo19285zz());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - m19311s.m19460qx()));
                jSONObject.putOpt("click_download_size", Long.valueOf(m19311s.m19443tr()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                C12270ok.m18539ok().m18521ok("cancel_pause_reserve_wifi_dialog_show", jSONObject, m19311s);
            } else {
                C12270ok.m18539ok().m18540a("pause_reserve_wifi_dialog_show", jSONObject, m19311s);
            }
        }
        DialogC12112n.C12116ok m19027ok = new DialogC12112n.C12116ok(this).m19025ok(false).m19027ok(C12159z.m18876ok());
        if (!TextUtils.isEmpty(str)) {
            m19027ok.m19024s(str).m19028ok(C12159z.m18877a());
        }
        m19027ok.m19029ok().show();
        this.f34036a = true;
        this.f34037bl = m19311s;
    }

    /* renamed from: ok */
    private void m19350ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra("open_url", str);
                intent.addFlags(268435456);
                if (C12534ok.m17605bl().m17595ok("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            C12293bl.m18426ok((Activity) this);
        }
    }
}
