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
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.click.p460a.RetryReportControl;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDKTool;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainMBCommonActivity extends Activity {

    /* renamed from: b */
    private CampaignEx f29699b;

    /* renamed from: c */
    private BrowserView f29700c;

    /* renamed from: a */
    String f29698a = "";

    /* renamed from: d */
    private BrowserView.InterfaceC11444a f29701d = new BrowserView.InterfaceC11444a() { // from class: com.mbridge.msdk.activity.DomainMBCommonActivity.1
        @Override // com.mbridge.msdk.foundation.webview.BrowserView.InterfaceC11444a
        /* renamed from: a */
        public final void mo21707a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.InterfaceC11444a
        /* renamed from: a */
        public final void mo21705a(WebView webView, String str, Bitmap bitmap) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.InterfaceC11444a
        /* renamed from: a */
        public final boolean mo21706a(WebView webView, String str) {
            SameLogTool.m21733d("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (SameSDKTool.C11399a.m22026a(str) && SameSDKTool.C11399a.m22027a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.m23464a(webView, str);
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            SameLogTool.m21733d("MBCommonActivity", th.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("intent_flag");
        String stringExtra2 = getIntent().getStringExtra("intent_jsonobject");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("shortcuts") && !TextUtils.isEmpty(stringExtra2)) {
            try {
                this.f29699b = CampaignEx.parseCampaignWithBackData(new JSONObject(stringExtra2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                if (m23252b == null) {
                    m23252b = SettingManager.m23261a().m23253b();
                }
                CampaignEx m22734d = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(this)).m22734d(this.f29699b.getId(), m23252b.m23446D());
                MBSDKContext.m22865f().m22886a(this);
                if (m22734d != null && !TextUtils.isEmpty(this.f29699b.getImpressionURL()) && !TextUtils.isEmpty(m23252b.m23446D()) && m22734d.getIsClick() == 0) {
                    CommonClickControl.m23127a((Context) this, this.f29699b, m23252b.m23446D(), this.f29699b.getImpressionURL(), false, true, RetryReportControl.f29980g);
                }
                this.f29699b.setIsClick(1);
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_click", (Integer) 1);
                CampaignDao.m22767a(CommonSDKDBHelper.m22721a(this)).m22754a(this.f29699b.getId(), contentValues);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                setContentView(linearLayout);
                return;
            } catch (Exception e2) {
                finish();
                e2.printStackTrace();
                return;
            }
        }
        String stringExtra3 = getIntent().getStringExtra("url");
        this.f29698a = stringExtra3;
        if (!TextUtils.isEmpty(stringExtra3)) {
            this.f29699b = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
            BrowserView browserView = new BrowserView(this, this.f29699b);
            this.f29700c = browserView;
            browserView.setListener(this.f29701d);
            this.f29700c.loadUrl(this.f29698a);
            View view = this.f29700c;
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
        BrowserView browserView = this.f29700c;
        if (browserView != null) {
            browserView.destroy();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m23464a(android.webkit.WebView r9, java.lang.String r10) {
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
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r4)     // Catch: java.lang.Throwable -> Lae
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
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r9)     // Catch: java.lang.Throwable -> Lae
        L9e:
            boolean r9 = com.mbridge.msdk.click.CommonClickUtil.m23064e(r8, r10)     // Catch: java.lang.Throwable -> Lae
            if (r9 == 0) goto Lad
            java.lang.String r9 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r9)     // Catch: java.lang.Throwable -> Lae
            r8.finish()     // Catch: java.lang.Throwable -> Lae
            return r6
        Lad:
            return r2
        Lae:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.DomainMBCommonActivity.m23464a(android.webkit.WebView, java.lang.String):boolean");
    }
}
