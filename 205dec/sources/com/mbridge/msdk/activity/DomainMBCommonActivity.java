package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.webview.BrowserView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DomainMBCommonActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f38666b;

    /* renamed from: c  reason: collision with root package name */
    private BrowserView f38667c;

    /* renamed from: a  reason: collision with root package name */
    String f38665a = "";

    /* renamed from: d  reason: collision with root package name */
    private BrowserView.a f38668d = new BrowserView.a() { // from class: com.mbridge.msdk.activity.DomainMBCommonActivity.1
        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str, Bitmap bitmap) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final boolean a(WebView webView, String str) {
            x.d("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (ab.a.a(str) && ab.a.a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            x.d("MBCommonActivity", th.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("intent_flag");
        String stringExtra2 = getIntent().getStringExtra("intent_jsonobject");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("shortcuts") && !TextUtils.isEmpty(stringExtra2)) {
            try {
                this.f38666b = CampaignEx.parseCampaignWithBackData(new JSONObject(stringExtra2));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            try {
                a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                if (b4 == null) {
                    b4 = b.a().b();
                }
                CampaignEx d4 = f.a(i.a(this)).d(this.f38666b.getId(), b4.D());
                com.mbridge.msdk.foundation.controller.a.f().a(this);
                if (d4 != null && !TextUtils.isEmpty(this.f38666b.getImpressionURL()) && !TextUtils.isEmpty(b4.D()) && d4.getIsClick() == 0) {
                    com.mbridge.msdk.click.b.a((Context) this, this.f38666b, b4.D(), this.f38666b.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f38807g);
                }
                this.f38666b.setIsClick(1);
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_click", (Integer) 1);
                f.a(i.a(this)).a(this.f38666b.getId(), contentValues);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                setContentView(linearLayout);
                return;
            } catch (Exception e5) {
                finish();
                e5.printStackTrace();
                return;
            }
        }
        String stringExtra3 = getIntent().getStringExtra("url");
        this.f38665a = stringExtra3;
        if (!TextUtils.isEmpty(stringExtra3)) {
            this.f38666b = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
            BrowserView browserView = new BrowserView(this, this.f38666b);
            this.f38667c = browserView;
            browserView.setListener(this.f38668d);
            this.f38667c.loadUrl(this.f38665a);
            View view = this.f38667c;
            if (view != null) {
                setContentView(view);
                return;
            }
            return;
        }
        Toast.makeText(this, "Error: no data", 0).show();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BrowserView browserView = this.f38667c;
        if (browserView != null) {
            browserView.destroy();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        String stringExtra = getIntent().getStringExtra("intent_flag");
        if (TextUtils.isEmpty(stringExtra) || !stringExtra.equals("shortcuts")) {
            return;
        }
        super.setTheme(16973840);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[Catch: all -> 0x00ae, TryCatch #2 {all -> 0x00ae, blocks: (B:3:0x0005, B:6:0x000c, B:9:0x001d, B:16:0x002e, B:18:0x003a, B:42:0x009e, B:44:0x00a4, B:27:0x0066, B:29:0x0072, B:31:0x0080, B:37:0x0090, B:19:0x003e, B:21:0x0048, B:23:0x0052), top: B:50:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #2 {all -> 0x00ae, blocks: (B:3:0x0005, B:6:0x000c, B:9:0x001d, B:16:0x002e, B:18:0x003a, B:42:0x009e, B:44:0x00a4, B:27:0x0066, B:29:0x0072, B:31:0x0080, B:37:0x0090, B:19:0x003e, B:21:0x0048, B:23:0x0052), top: B:50:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.webkit.WebView r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "http"
            java.lang.String r1 = "MBCommonActivity"
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lae
            if (r3 == 0) goto Lc
            return r2
        Lc:
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = r3.getScheme()     // Catch: java.lang.Throwable -> Lae
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "https"
            r6 = 1
            if (r4 != 0) goto L2a
            java.lang.String r4 = r3.getScheme()     // Catch: java.lang.Throwable -> Lae
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> Lae
            if (r4 == 0) goto L28
            goto L2a
        L28:
            r4 = 0
            goto L2b
        L2a:
            r4 = 1
        L2b:
            if (r4 == 0) goto L2e
            return r2
        L2e:
            java.lang.String r3 = r3.getScheme()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = "intent"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> Lae
            if (r3 == 0) goto L9e
            android.content.Intent r3 = android.content.Intent.parseUri(r10, r6)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = r3.getPackage()     // Catch: java.lang.Throwable -> L5e
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L5e
            if (r7 != 0) goto L66
            android.content.pm.PackageManager r7 = r8.getPackageManager()     // Catch: java.lang.Throwable -> L5e
            android.content.Intent r4 = r7.getLaunchIntentForPackage(r4)     // Catch: java.lang.Throwable -> L5e
            if (r4 == 0) goto L66
            r4 = 268435456(0x10000000, float:2.524355E-29)
            r3.setFlags(r4)     // Catch: java.lang.Throwable -> L5e
            r8.startActivityForResult(r3, r2)     // Catch: java.lang.Throwable -> L5e
            r8.finish()     // Catch: java.lang.Throwable -> L5e
            return r6
        L5e:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> Lae
            com.mbridge.msdk.foundation.tools.x.d(r1, r4)     // Catch: java.lang.Throwable -> Lae
        L66:
            java.lang.String r4 = "browser_fallback_url"
            java.lang.String r3 = r3.getStringExtra(r4)     // Catch: java.lang.Throwable -> L96
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L96
            if (r4 != 0) goto L9e
            android.net.Uri r4 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = r4.getScheme()     // Catch: java.lang.Throwable -> L96
            boolean r0 = r7.equals(r0)     // Catch: java.lang.Throwable -> L96
            if (r0 != 0) goto L8d
            java.lang.String r0 = r4.getScheme()     // Catch: java.lang.Throwable -> L96
            boolean r0 = r0.equals(r5)     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L8b
            goto L8d
        L8b:
            r0 = 0
            goto L8e
        L8d:
            r0 = 1
        L8e:
            if (r0 == 0) goto L94
            r9.loadUrl(r3)     // Catch: java.lang.Throwable -> L96
            return r2
        L94:
            r10 = r3
            goto L9e
        L96:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> Lae
            com.mbridge.msdk.foundation.tools.x.d(r1, r9)     // Catch: java.lang.Throwable -> Lae
        L9e:
            boolean r9 = com.mbridge.msdk.click.c.e(r8, r10)     // Catch: java.lang.Throwable -> Lae
            if (r9 == 0) goto Lad
            java.lang.String r9 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.x.d(r1, r9)     // Catch: java.lang.Throwable -> Lae
            r8.finish()     // Catch: java.lang.Throwable -> Lae
            return r6
        Lad:
            return r2
        Lae:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.x.d(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.DomainMBCommonActivity.a(android.webkit.WebView, java.lang.String):boolean");
    }
}
