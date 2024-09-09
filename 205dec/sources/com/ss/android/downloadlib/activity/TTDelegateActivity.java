package com.ss.android.downloadlib.activity;

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
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.model.a;
import com.ss.android.downloadad.api.ok.a;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.ok.n;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.addownload.z;
import com.ss.android.downloadlib.guide.install.ok;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.p;
import com.ss.android.socialbase.appdownloader.bl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: s  reason: collision with root package name */
    private static ok f48349s;

    /* renamed from: a  reason: collision with root package name */
    private boolean f48350a;
    private a bl;
    protected Intent ok = null;

    static {
        StubApp.interface11(22606);
    }

    public static void a(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        Intent bl = bl(okVar);
        bl.addFlags(268435456);
        bl.putExtra("type", 11);
        bl.putExtra("package_name", str);
        if (r.getContext() != null) {
            r.getContext().startActivity(bl);
        }
    }

    private static Intent bl(@NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        return new Intent(r.getContext(), TTDelegateActivity.class);
    }

    public static void ok(String str, String[] strArr) {
        Intent intent = new Intent(r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY, str);
        intent.putExtra("permission_content_key", strArr);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.ok = intent;
        r.a(this);
        ok();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public native void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr);

    @Override // android.app.Activity
    protected void onStop() {
        a aVar;
        DownloadInfo a4;
        super.onStop();
        if (!this.f48350a || (aVar = this.bl) == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            a4 = p.ok(r.getContext()).ok(this.bl.ld(), null, true);
        } else {
            a4 = p.ok(r.getContext()).a(this.bl.ok());
        }
        if (a4 == null || a4.getCurBytes() < a4.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void bl() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.bl():void");
    }

    public static void a(String str, long j4, String str2) {
        Intent intent = new Intent(r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j4);
        intent.putExtra("market_app_id", str2);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    public static void ok(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        Intent bl = bl(okVar);
        bl.addFlags(268435456);
        bl.putExtra("type", 2);
        bl.putExtra("open_url", str);
        if (r.getContext() != null) {
            r.getContext().startActivity(bl);
        }
    }

    public static void ok(com.ss.android.downloadad.api.ok.ok okVar) {
        Intent bl = bl(okVar);
        bl.addFlags(268435456);
        bl.putExtra("type", 4);
        bl.putExtra("model_id", okVar.a());
        if (r.getContext() != null) {
            r.getContext().startActivity(bl);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        ok(okVar, 5, "", "", "", "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3) {
        ok(okVar, 7, str, str2, str3, "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3, String str4) {
        ok(okVar, 20, str, str2, str3, str4);
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void ok(com.ss.android.downloadad.api.ok.ok okVar, ok okVar2) {
        Intent bl = bl(okVar);
        bl.addFlags(268435456);
        bl.putExtra("type", 9);
        f48349s = okVar2;
        if (r.getContext() != null) {
            r.getContext().startActivity(bl);
        }
    }

    private void a(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            u uVar = new u() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> bl;

                {
                    this.bl = new WeakReference<>(TTDelegateActivity.this);
                }

                public void ok() {
                    k.ok(str);
                    bl.ok(this.bl.get());
                }

                public void ok(String str2) {
                    k.ok(str, str2);
                    bl.ok(this.bl.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    r.n().ok(this, strArr, uVar);
                    return;
                } catch (Exception e4) {
                    r.u().ok(e4, "requestPermission");
                    uVar.ok();
                    return;
                }
            }
            uVar.ok();
            return;
        }
        bl.ok((Activity) this);
    }

    public static void ok(long j4) {
        Intent intent = new Intent(r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j4);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    private void a(String str) {
        Intent h4 = j.h(this, str);
        if (h4 == null) {
            return;
        }
        try {
            try {
                h4.addFlags(268435456);
                h4.putExtra("start_only_for_android", true);
                startActivity(h4);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            bl.ok((Activity) this);
        }
    }

    public static void ok(String str, long j4, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j4);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    private void a(long j4) {
        final a s3 = kf.ok().s(j4);
        if (s3 == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("showOpenAppDialogInner nativeModel null");
            bl.ok((Activity) this);
            return;
        }
        com.ss.android.download.api.config.j bl = r.bl();
        a.ok ok = new a.ok(this).ok("\u5df2\u5b89\u88c5\u5b8c\u6210");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(s3.ah()) ? "\u521a\u521a\u4e0b\u8f7d\u7684\u5e94\u7528" : s3.ah();
        bl.a(ok.a(String.format("%1$s\u5df2\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u6253\u5f00\uff1f", objArr)).bl("\u6253\u5f00").s("\u53d6\u6d88").ok(false).ok(j.s(this, s3.n())).ok(new a.InterfaceC0935a() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.a.InterfaceC0935a
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().a("market_openapp_cancel", s3);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                bl.ok((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0935a
            public void bl(DialogInterface dialogInterface) {
                bl.ok((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0935a
            public void ok(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.ok.a(s3);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                bl.ok((Activity) TTDelegateActivity.this);
            }
        }).ok(2).ok());
        com.ss.android.downloadlib.s.ok.ok().a("market_openapp_window_show", s3);
    }

    public static void ok(String str, long j4, String str2) {
        Intent intent = new Intent(r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j4);
        intent.putExtra("need_comment", str2);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    public static void ok(String str, long j4) {
        Intent intent = new Intent(r.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j4);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    private void bl(long j4) {
        new com.ss.android.downloadlib.addownload.compliance.ok(this, j4).show();
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str) {
        ok(okVar, 19, "", "", "", str);
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3) {
        ok(okVar, 8, str, str2, str3, "");
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3, String str4) {
        ok(okVar, 21, str, str2, str3, str4);
    }

    private static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, int i4, String str, String str2, String str3, String str4) {
        Intent bl = bl(okVar);
        bl.addFlags(268435456);
        bl.putExtra("type", i4);
        if (!TextUtils.isEmpty(str2)) {
            bl.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            bl.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            bl.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            bl.putExtra("message_text", str);
        }
        bl.putExtra("model_id", okVar.a());
        if (r.getContext() != null) {
            r.getContext().startActivity(bl);
        }
    }

    protected void ok() {
        Intent intent = this.ok;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                a(this.ok.getStringExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY), this.ok.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                ok(this.ok.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            case 16:
            case 17:
            case 18:
            default:
                bl.ok((Activity) this);
                break;
            case 4:
                a(this.ok.getLongExtra("model_id", 0L));
                break;
            case 5:
                ok(this.ok.getLongExtra("model_id", 0L), "");
                break;
            case 7:
            case 8:
            case 20:
            case 21:
                bl();
                break;
            case 9:
                ok okVar = f48349s;
                if (okVar != null) {
                    okVar.ok();
                }
                bl.ok((Activity) this);
                break;
            case 10:
                bl(this.ok.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                a(this.ok.getStringExtra("package_name"));
                break;
            case 12:
                com.ss.android.downloadlib.h.p.ok(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("param"), this.ok.getStringExtra("ext_json"));
                bl.ok((Activity) this);
                break;
            case 13:
                com.ss.android.downloadlib.h.p.ok(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("need_comment"));
                bl.ok((Activity) this);
                break;
            case 14:
                com.ss.android.downloadlib.h.p.a(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("market_app_id"));
                bl.ok((Activity) this);
                break;
            case 15:
                com.ss.android.downloadlib.h.p.ok(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L));
                bl.ok((Activity) this);
                break;
            case 19:
                ok(this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("delete_button_text"));
                break;
        }
        this.ok = null;
    }

    private void ok(long j4, String str) {
        if (z.ok() == null) {
            return;
        }
        com.ss.android.downloadad.api.ok.a s3 = kf.ok().s(j4);
        if (s3 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(s3.zz());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - s3.qx()));
                jSONObject.putOpt("click_download_size", Long.valueOf(s3.tr()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_dialog_show", jSONObject, s3);
            } else {
                com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_dialog_show", jSONObject, s3);
            }
        }
        n.ok ok = new n.ok(this).ok(false).ok(z.ok());
        if (!TextUtils.isEmpty(str)) {
            ok.s(str).ok(z.a());
        }
        ok.ok().show();
        this.f48350a = true;
        this.bl = s3;
    }

    private void ok(String str) {
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
                if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_app_link_flag")) {
                    intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            bl.ok((Activity) this);
        }
    }
}
