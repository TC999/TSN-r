package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.dislike.ui.c;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.r.r;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.ev;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.core.widget.gd;
import com.bytedance.sdk.openadsdk.core.widget.ia;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.core.widget.p;
import com.bytedance.sdk.openadsdk.core.widget.sr;
import com.bytedance.sdk.openadsdk.core.widget.t;
import com.bytedance.sdk.openadsdk.core.widget.ux;
import com.bytedance.sdk.openadsdk.core.widget.w;
import com.bytedance.sdk.openadsdk.core.widget.xv;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    public static me f31813c;
    private static r ia;

    /* renamed from: a  reason: collision with root package name */
    private sr f31814a;
    private xv bk;
    private Dialog ev;

    /* renamed from: f  reason: collision with root package name */
    private f f31815f;
    private ia fp;
    private gd gd;

    /* renamed from: k  reason: collision with root package name */
    private ux f31816k;

    /* renamed from: p  reason: collision with root package name */
    private Activity f31817p;

    /* renamed from: r  reason: collision with root package name */
    private w f31818r;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.c sr;

    /* renamed from: t  reason: collision with root package name */
    private a f31819t;
    private k ux;

    /* renamed from: w  reason: collision with root package name */
    private Intent f31820w;
    private AlertDialog xv;
    private p ys;

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity$19  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass19 extends com.bytedance.sdk.component.gd.p {
        AnonymousClass19(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.fz.a.c().c(TTDelegateActivity.this.f31817p);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends com.bytedance.sdk.component.gd.p {
        public c(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            ITTDownloadVisitor c4 = com.bytedance.sdk.openadsdk.core.p.c.c.c();
            if (c4 != null) {
                Bridge u3 = com.bytedance.sdk.openadsdk.core.k.sr().u();
                if (u3 != null) {
                    c4.initPath(u3.values().booleanValue(1));
                }
                i.a();
            }
        }
    }

    static {
        StubApp.interface11(17831);
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                com.bytedance.sdk.openadsdk.ys.w.xv.sr f4 = com.bytedance.sdk.openadsdk.core.k.sr().f();
                boolean xv = f4.xv();
                boolean ux = f4.ux();
                ArrayList arrayList = new ArrayList();
                com.bytedance.sdk.openadsdk.t.c.c(f4, arrayList);
                if (xv) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (ux) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.j.ux.c().c(this.f31817p, strArr, new com.bytedance.sdk.openadsdk.core.j.f() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                    @Override // com.bytedance.sdk.openadsdk.core.j.f
                    public void c() {
                        ev.c(new c("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.j.f
                    public void c(String str) {
                        "android.permission.READ_PHONE_STATE".equals(str);
                        ev.c(new c("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        com.bytedance.sdk.component.utils.a.w("TTDelegate", "\u5df2\u7ecf\u6709Read phone state\u6743\u9650");
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ux uxVar = this.f31816k;
        if (uxVar == null || uxVar.isShowing()) {
            return;
        }
        this.f31816k.c();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            f31813c = null;
            AlertDialog alertDialog = this.xv;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.xv.dismiss();
            }
            gd gdVar = this.gd;
            if (gdVar != null && gdVar.isShowing()) {
                com.bytedance.sdk.openadsdk.core.eq.f.c(this.gd.c());
                if (this.gd.isShowing()) {
                    this.gd.dismiss();
                }
            }
            f fVar = this.f31815f;
            if (fVar != null && fVar.isShowing()) {
                this.f31815f.dismiss();
            }
            ux uxVar = this.f31816k;
            if (uxVar != null) {
                if (uxVar.isShowing()) {
                    this.f31816k.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.eq.f.c(this.f31816k.sr());
            }
            xv xvVar = this.bk;
            if (xvVar != null && xvVar.isShowing()) {
                this.bk.dismiss();
            }
            sr srVar = this.f31814a;
            if (srVar != null && srVar.isShowing()) {
                this.f31814a.dismiss();
            }
            a aVar = this.f31819t;
            if (aVar != null && aVar.isShowing()) {
                this.f31819t.dismiss();
            }
            Dialog dialog = this.ev;
            if (dialog != null && dialog.isShowing()) {
                this.ev.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (ls.getContext() == null) {
            ls.c(this.f31817p);
        }
        try {
            setIntent(intent);
            this.f31820w = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr);

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            ux();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        xv();
    }

    public static void sr(Context context, String str, String str2) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 12);
        c4.putExtra("web_url", str);
        c4.putExtra("web_title", str2);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    private void ux() {
        try {
            Intent intent = this.f31820w;
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.f31820w.getStringExtra("app_download_url");
            this.f31820w.getStringExtra("app_name");
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    f();
                    break;
                case 3:
                    c(stringExtra, this.f31820w.getStringExtra("dialog_title"), this.f31820w.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    w(this.f31820w.getStringExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY), this.f31820w.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    c(stringExtra, this.f31820w.getStringExtra("dialog_title"), this.f31820w.getStringExtra("dialog_content_key"), this.f31820w.getStringExtra("dialog_btn_yes_key"), this.f31820w.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    ux(this.f31820w.getStringExtra("materialmeta"));
                    break;
                case 7:
                    xv(stringExtra);
                    break;
                case 8:
                    w(this.f31820w.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    sr(this.f31820w.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 10:
                    w(this.f31820w.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    sr(this.f31820w.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    xv(this.f31820w.getStringExtra("web_url"), this.f31820w.getStringExtra("web_title"));
                    break;
                case 13:
                    w();
                    break;
                case 14:
                    w(stringExtra, this.f31820w.getStringExtra("dialog_app_desc_url"), true);
                    break;
                case 15:
                    c(this.f31820w.getStringExtra("web_url"));
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    public static void w(Context context, String str, String str2, String str3) {
        if (context == null) {
            try {
                context = ls.getContext();
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        Intent c4 = c(context);
        JSONObject jSONObject = new JSONObject(str3);
        c4.putExtra("type", 7);
        c4.putExtra("app_download_url", str);
        c4.putExtra("dialog_app_manage_model", str2);
        c4.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        c4.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        c4.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        c4.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    public static void xv(Context context, String str, String str2) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 14);
        c4.putExtra("dialog_app_desc_url", str2);
        c4.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    public static void c(String str, String[] strArr) {
        Intent intent = new Intent(ls.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY, str);
        intent.putExtra("permission_content_key", strArr);
        if (ls.getContext() != null) {
            com.bytedance.sdk.component.utils.w.c(ls.getContext(), intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.component.utils.w.c
                public void c() {
                }

                @Override // com.bytedance.sdk.component.utils.w.c
                public void c(Throwable th) {
                    com.bytedance.sdk.component.utils.a.xv("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    private void sr() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void xv() {
        if (com.bytedance.sdk.openadsdk.core.k.sr().xk()) {
            if (this.f31816k == null && this.gd == null && this.f31819t == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.k.sr().p(false);
            finish();
        }
    }

    private void sr(String str, String str2) {
        if (this.f31820w == null) {
            return;
        }
        c(str, str2, true);
    }

    public static void c(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 3);
        c4.putExtra("app_download_url", str);
        c4.putExtra("dialog_title", str2);
        c4.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    private void sr(String str) {
        try {
            if (xk.ev(this.f31817p)) {
                a aVar = this.f31819t;
                if (aVar != null) {
                    aVar.dismiss();
                }
                a aVar2 = new a(this.f31817p, str);
                this.f31819t = aVar2;
                aVar2.c(new a.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.c
                    public void c(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.f31819t.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void xv(final String str) {
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        float f4;
        String str7;
        String str8;
        Intent intent = this.f31820w;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("dialog_app_manage_model");
        String stringExtra2 = this.f31820w.getStringExtra("dialog_title");
        final String stringExtra3 = this.f31820w.getStringExtra("dialog_icon_url");
        final String stringExtra4 = this.f31820w.getStringExtra("dialog_app_description");
        boolean z3 = false;
        boolean booleanExtra = this.f31820w.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        JSONArray jSONArray2 = null;
        float f5 = 0.0f;
        try {
            String str9 = "";
            if (TextUtils.isEmpty(stringExtra)) {
                str2 = stringExtra;
                jSONArray = null;
                str3 = "";
                str4 = str3;
                str5 = str4;
                str6 = str5;
                f4 = 0.0f;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra);
                com.bytedance.sdk.openadsdk.core.u.ux ux = com.bytedance.sdk.openadsdk.core.w.ux(jSONObject);
                if (ux != null) {
                    String ux2 = ux.ux();
                    String r3 = ux.r();
                    String a4 = ux.a();
                    if (!TextUtils.isEmpty(a4)) {
                        stringExtra2 = a4;
                    }
                    JSONArray sr = ux.sr();
                    float xv = ux.xv();
                    str9 = stringExtra2;
                    str7 = ux2;
                    str8 = r3;
                    jSONArray2 = sr;
                    f5 = xv;
                } else {
                    str7 = "";
                    str8 = str7;
                }
                String optString = jSONObject.optString("ugen_url");
                String optString2 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    jSONObject.put("app_name", str9);
                    jSONObject.put(CampaignEx.JSON_KEY_ICON_URL, stringExtra3);
                    jSONObject.put("description", stringExtra4);
                    stringExtra = jSONObject.toString();
                    z3 = true;
                }
                str3 = jSONObject.optString("hand_icon_url");
                str2 = stringExtra;
                str4 = str7;
                str6 = str9;
                str5 = str8;
                jSONArray = jSONArray2;
                f4 = f5;
            }
            if (booleanExtra) {
                c(str, str2, stringExtra3, stringExtra4, str4, str5, str6, jSONArray, f4);
            } else if (z3) {
                final String str10 = str2;
                final float f6 = f4;
                final String str11 = str3;
                final JSONArray jSONArray3 = jSONArray;
                final String str12 = str4;
                final String str13 = str5;
                final String str14 = str6;
                c(str, str2, new r() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
                    public void c(int i4, String str15) {
                        TTDelegateActivity.this.c(str, str10, stringExtra3, f6, stringExtra4, str11, jSONArray3, str12, str13, str14);
                        if (TTDelegateActivity.this.gd != null) {
                            TTDelegateActivity.this.gd.c((r) null);
                        }
                        if (TTDelegateActivity.ia != null) {
                            TTDelegateActivity.ia.c(i4, str15);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
                    public void c(b<View> bVar) {
                        if (TTDelegateActivity.ia != null) {
                            TTDelegateActivity.ia.c(null);
                        }
                    }
                });
            } else {
                c(str, str2, stringExtra3, f4, stringExtra4, str3, jSONArray, str4, str5, str6);
            }
        } catch (Throwable unused) {
        }
    }

    public static void w(Context context, String str, String str2) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 9);
        c4.putExtra("dialog_app_manage_model", str2);
        c4.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(String str, final String str2, final boolean z3, final Dialog dialog) {
        try {
            if (xk.ev(this.f31817p)) {
                xv xvVar = this.bk;
                if (xvVar != null) {
                    xvVar.dismiss();
                }
                xv xvVar2 = new xv(this.f31817p, str);
                this.bk = xvVar2;
                xvVar2.c(new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // com.bytedance.sdk.openadsdk.core.widget.xv.c
                    public void c(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.eq.f.w(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xv.c
                    public void w(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xv.c
                    public void xv(Dialog dialog2) {
                        if (TTDelegateActivity.this.bk != null) {
                            if (z3) {
                                com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                                TTDelegateActivity.this.finish();
                                return;
                            }
                            Dialog dialog3 = dialog;
                            if (dialog3 != null) {
                                dialog3.show();
                            }
                            TTDelegateActivity.this.bk.dismiss();
                        }
                    }
                });
                this.bk.show();
            }
        } catch (Throwable unused) {
        }
    }

    private static Intent c(Context context) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public static void w(Context context, String str) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 11);
        c4.putExtra("dialog_app_ad_info", str);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    public static void c(r rVar) {
        ia = rVar;
    }

    public static void c(Context context, String str, String str2, String str3, r rVar, me meVar) {
        try {
            f31813c = meVar;
            ia = rVar;
            if (context == null) {
                context = ls.getContext();
            }
            Intent c4 = c(context);
            JSONObject jSONObject = new JSONObject(str3);
            c4.putExtra("type", 7);
            c4.putExtra("app_download_url", str);
            c4.putExtra("dialog_app_manage_model", str2);
            c4.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            c4.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            c4.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            c4.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.bytedance.sdk.component.utils.w.c(context, c4, null);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void w() {
        try {
            if (this.ys == null) {
                this.ys = new p(this.f31817p, getIntent());
            }
            if (this.ys.isShowing()) {
                this.ys.dismiss();
            }
            this.ys.c(new p.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
                @Override // com.bytedance.sdk.openadsdk.core.widget.p.c
                public void c(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.ys.show();
        } catch (Throwable unused) {
        }
    }

    private void w(String str) {
        try {
            if (xk.ev(this.f31817p)) {
                Dialog dialog = this.ev;
                if (dialog == null || !dialog.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.c cVar = new com.bytedance.sdk.openadsdk.core.widget.c(this.f31817p, str);
                    this.ev = cVar;
                    cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.ev.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void ux(String str) {
        if (xk.ev(this.f31817p)) {
            if (str != null && this.sr == null) {
                try {
                    me c4 = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(str));
                    if (c4 != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(this.f31817p, c4.ve(), false);
                        this.sr = cVar;
                        cVar.c(new c.InterfaceC0490c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                            public void c() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                            public void c(int i4, String str2, boolean z3) {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                            public void w() {
                                TTDelegateActivity.this.finish();
                            }
                        });
                        com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.f31817p, this.sr, c4);
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar2 = this.sr;
            if (cVar2 != null) {
                cVar2.c();
            }
        }
    }

    private void w(String str, String str2) {
        if (this.f31820w == null) {
            return;
        }
        xv(str, str2, true);
    }

    public static void c(Context context, String str, String str2) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 8);
        c4.putExtra("app_download_url", str);
        c4.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, String str2, boolean z3) {
        xv(str, str2, z3, (Dialog) null);
    }

    private void xv(String str, String str2) {
        try {
            if (xk.ev(this.f31817p)) {
                f fVar = this.f31815f;
                if (fVar != null) {
                    fVar.dismiss();
                }
                f fVar2 = new f(this.f31817p, str, str2);
                this.f31815f = fVar2;
                fVar2.c(new f.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.f.c
                    public void c(Dialog dialog) {
                        if (TTDelegateActivity.this.f31815f != null) {
                            TTDelegateActivity.this.f31815f.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.f31815f.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, String str2, boolean z3, Dialog dialog) {
        xv(str, str2, z3, dialog);
    }

    private void w(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    com.bytedance.sdk.openadsdk.core.j.ux.c().c(this.f31817p, strArr, new com.bytedance.sdk.openadsdk.core.j.f() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                        @Override // com.bytedance.sdk.openadsdk.core.j.f
                        public void c() {
                            com.bytedance.sdk.openadsdk.core.eq.r.c(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.j.f
                        public void c(String str2) {
                            com.bytedance.sdk.openadsdk.core.eq.r.c(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            com.bytedance.sdk.component.utils.a.w("TTDelegate", "\u5df2\u7ecf\u6709\u6743\u9650");
            finish();
            return;
        }
        finish();
    }

    public static void c(Context context, String str) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 10);
        c4.putExtra("dialog_content_key", str);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    private void xv(final String str, String str2, final boolean z3, final Dialog dialog) {
        try {
            if (xk.ev(this.f31817p)) {
                com.bytedance.sdk.openadsdk.core.widget.w wVar = this.f31818r;
                if (wVar != null) {
                    wVar.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.w wVar2 = new com.bytedance.sdk.openadsdk.core.widget.w(this.f31817p, str2);
                this.f31818r = wVar2;
                wVar2.c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.w.c
                    public void c(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.eq.f.w(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.w.c
                    public void w(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.eq.f.sr(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.w.c
                    public void xv(Dialog dialog2) {
                        TTDelegateActivity.this.c(z3, str, dialog);
                    }
                });
                this.f31818r.show();
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 5);
        c4.putExtra("app_download_url", str);
        c4.putExtra("dialog_title", str2);
        c4.putExtra("dialog_content_key", str3);
        c4.putExtra("dialog_btn_yes_key", str4);
        c4.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(String str, final String str2, final boolean z3) {
        try {
            if (xk.ev(this.f31817p)) {
                xv xvVar = this.bk;
                if (xvVar != null) {
                    xvVar.dismiss();
                }
                xv xvVar2 = new xv(this.f31817p, str);
                this.bk = xvVar2;
                xvVar2.c(new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.xv.c
                    public void c(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.eq.f.w(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xv.c
                    public void w(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xv.c
                    public void xv(Dialog dialog) {
                        if (TTDelegateActivity.this.bk != null) {
                            if (!z3) {
                                TTDelegateActivity.this.bk.dismiss();
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.bk.show();
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, me meVar) {
        JSONObject mo;
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 6);
        if (meVar != null && (mo = meVar.mo()) != null) {
            c4.putExtra("materialmeta", mo.toString());
        }
        if (context != null) {
            try {
                context.startActivity(c4);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str) {
        if (this.fp == null) {
            this.fp = new ia(this.f31817p, str);
        }
        if (this.fp.isShowing()) {
            this.fp.dismiss();
        }
        this.fp.c(new ia.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
            @Override // com.bytedance.sdk.openadsdk.core.widget.ia.c
            public void c(String str2) {
                com.bytedance.sdk.openadsdk.core.eq.f.w(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ia.c
            public void w(String str2) {
                com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.fp.show();
    }

    public static void c(Context context, String str, boolean z3) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 15);
        if (!z3) {
            c4.putExtra("web_url", str);
        }
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    public static void c(Context context, String str, me meVar) {
        if (context == null) {
            context = ls.getContext();
        }
        Intent c4 = c(context);
        c4.putExtra("type", 13);
        f31813c = meVar;
        c4.putExtra("event_tag", str);
        com.bytedance.sdk.component.utils.w.c(context, c4, null);
    }

    private void c(String str, String str2, r rVar) {
        if (xk.ev(this.f31817p)) {
            if (TextUtils.isEmpty(str2)) {
                rVar.c(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                ux uxVar = this.f31816k;
                if (uxVar == null || !uxVar.isShowing()) {
                    ux r3 = new t(this.f31817p, jSONObject, rVar).r(str);
                    this.f31816k = r3;
                    ((t) r3).w(c(str, str2));
                    this.f31816k.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void c(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f4) {
        c(str, str2, str7, f4, new r() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.22
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str8) {
                TTDelegateActivity.this.c(str, str2, str3, f4, str4, "", jSONArray, str5, str6, str7);
                if (TTDelegateActivity.this.gd != null) {
                    TTDelegateActivity.this.gd.c((r) null);
                }
                if (TTDelegateActivity.ia != null) {
                    TTDelegateActivity.ia.c(i4, str8);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                if (TTDelegateActivity.ia != null) {
                    TTDelegateActivity.ia.c(null);
                }
            }
        });
    }

    private void c(final String str, final String str2, String str3, float f4, r rVar) {
        if (xk.ev(this.f31817p)) {
            if (TextUtils.isEmpty(str2)) {
                rVar.c(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f4);
                JSONObject w3 = com.bytedance.sdk.openadsdk.core.ugeno.f.w(jSONObject.getString("ugen_dialog_md5"), jSONObject.getString("ugen_dialog_url"));
                if (w3 == null) {
                    rVar.c(8, "uegnTemplate is empty");
                    return;
                }
                gd gdVar = this.gd;
                if (gdVar == null || !gdVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    gd gdVar2 = new gd(str, this.f31817p, w3, jSONObject2, rVar, f31813c);
                    this.gd = gdVar2;
                    gdVar2.c(new ev.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.23
                        @Override // com.bytedance.sdk.openadsdk.core.widget.ev.c
                        public void c(Dialog dialog) {
                            com.bytedance.sdk.openadsdk.core.eq.f.w(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ev.c
                        public void sr(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.c(str2, str, false, (Dialog) tTDelegateActivity.gd);
                            if (TTDelegateActivity.this.gd != null) {
                                TTDelegateActivity.this.gd.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ev.c
                        public void w(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.sr(str2, str, false, tTDelegateActivity.gd);
                            if (TTDelegateActivity.this.gd != null) {
                                TTDelegateActivity.this.gd.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ev.c
                        public void xv(Dialog dialog) {
                            com.bytedance.sdk.openadsdk.core.eq.f.sr(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ev.c
                        public void c() {
                            try {
                                com.bytedance.sdk.openadsdk.core.u.ux ux = com.bytedance.sdk.openadsdk.core.w.ux(new JSONObject(str2));
                                if (ux != null) {
                                    TTDelegateActivity.this.w(str, ux.gd(), false, (Dialog) TTDelegateActivity.this.gd);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.gd != null) {
                                TTDelegateActivity.this.gd.hide();
                            }
                        }
                    });
                    this.gd.show();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, float f4, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8) {
        if (xk.ev(this.f31817p)) {
            ux uxVar = this.f31816k;
            if (uxVar == null || !uxVar.isShowing()) {
                ux c4 = new ux(this.f31817p).c(str8).ux(str6).w(str3).f(str7).r(str).xv(str5).c(f4).c(jSONArray).sr(str4).c(c(str, str2));
                this.f31816k = c4;
                c4.show();
            }
        }
    }

    private ux.c c(final String str, final String str2) {
        return new ux.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.24
            @Override // com.bytedance.sdk.openadsdk.core.widget.ux.c
            public void c(Dialog dialog) {
                com.bytedance.sdk.openadsdk.core.eq.f.w(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ux.c
            public void sr(Dialog dialog) {
                TTDelegateActivity.this.c(str2, str, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ux.c
            public void ux(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.u.ux ux = com.bytedance.sdk.openadsdk.core.w.ux(new JSONObject(str2));
                    if (ux == null) {
                        return;
                    }
                    TTDelegateActivity.this.w(str, ux.gd(), false);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ux.c
            public void w(Dialog dialog) {
                TTDelegateActivity.this.xv(str2, str, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ux.c
            public void xv(Dialog dialog) {
                com.bytedance.sdk.openadsdk.core.eq.f.sr(str);
                TTDelegateActivity.this.finish();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final String str2, final boolean z3, final Dialog dialog) {
        try {
            if (xk.ev(this.f31817p)) {
                sr srVar = this.f31814a;
                if (srVar != null) {
                    srVar.dismiss();
                }
                sr srVar2 = new sr(this.f31817p, str);
                this.f31814a = srVar2;
                srVar2.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.sr.c
                    public void c(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.eq.f.w(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.sr.c
                    public void w(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.sr.c
                    public void xv(Dialog dialog2) {
                        if (TTDelegateActivity.this.f31814a != null) {
                            if (z3) {
                                com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                                TTDelegateActivity.this.finish();
                                return;
                            }
                            Dialog dialog3 = dialog;
                            if (dialog3 != null) {
                                dialog3.show();
                            }
                            TTDelegateActivity.this.f31814a.dismiss();
                        }
                    }
                });
                this.f31814a.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final String str2, final boolean z3) {
        try {
            if (xk.ev(this.f31817p)) {
                sr srVar = this.f31814a;
                if (srVar != null) {
                    srVar.dismiss();
                }
                sr srVar2 = new sr(this.f31817p, str);
                this.f31814a = srVar2;
                srVar2.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.sr.c
                    public void c(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.eq.f.w(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.sr.c
                    public void w(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.sr.c
                    public void xv(Dialog dialog) {
                        if (TTDelegateActivity.this.f31814a != null) {
                            if (!z3) {
                                TTDelegateActivity.this.f31814a.dismiss();
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.eq.f.sr(str2);
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.f31814a.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3, String str, Dialog dialog) {
        if (this.f31818r == null) {
            return;
        }
        if (z3) {
            com.bytedance.sdk.openadsdk.core.eq.f.sr(str);
            finish();
            return;
        }
        if (dialog != null) {
            dialog.show();
        }
        this.f31818r.dismiss();
    }

    private void c(final String str, String str2, String str3, String str4, String str5) {
        if (xk.ev(this.f31817p)) {
            AlertDialog alertDialog = this.xv;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.ux == null) {
                this.ux = new k(this.f31817p).c(str2).w(str3).xv(str4).sr(str5).c(new k.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                    @Override // com.bytedance.sdk.openadsdk.core.widget.k.c
                    public void c(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.eq.f.w(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.k.c
                    public void w(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.eq.f.xv(str);
                        TTDelegateActivity.this.finish();
                    }
                }).c(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        com.bytedance.sdk.openadsdk.core.eq.f.sr(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.ux.isShowing()) {
                this.ux.show();
            }
            this.xv = this.ux;
        }
    }

    private void c(final String str, String str2, String str3) {
        if (xk.ev(this.f31817p)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.i.c(this.f31817p, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            c(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    com.bytedance.sdk.openadsdk.core.eq.f.w(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    com.bytedance.sdk.openadsdk.core.eq.f.xv(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.bytedance.sdk.openadsdk.core.eq.f.sr(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void c(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        Activity activity;
        String str3;
        try {
            if (this.xv == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activity = this.f31817p;
                    str3 = "Theme.Dialog.TTDownload";
                } else {
                    activity = this.f31817p;
                    str3 = "Theme.Dialog.TTDownloadOld";
                }
                this.xv = new AlertDialog.Builder(this.f31817p, com.bytedance.sdk.component.utils.i.ux(activity, str3)).create();
            }
            this.xv.setTitle(String.valueOf(str));
            this.xv.setMessage(String.valueOf(str2));
            this.xv.setButton(-1, com.bytedance.sdk.component.utils.i.c(this.f31817p, "tt_label_ok"), onClickListener);
            this.xv.setButton(-2, com.bytedance.sdk.component.utils.i.c(this.f31817p, "tt_label_cancel"), onClickListener2);
            this.xv.setOnCancelListener(onCancelListener);
            if (this.xv.isShowing()) {
                return;
            }
            this.xv.show();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
