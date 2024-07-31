package com.umeng.socialize.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.URLBuilder;
import com.umeng.socialize.utils.UmengText;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OauthDialog extends BaseDialog {
    private static final String BASE_URL = "https://log.umsns.com/";
    private static final String TAG = "OauthDialog";
    private static String mRedirectUri = "error";
    private C13473a mListener;

    /* renamed from: com.umeng.socialize.view.OauthDialog$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13473a {

        /* renamed from: a */
        private UMAuthListener f39652a;

        /* renamed from: b */
        private SHARE_MEDIA f39653b;

        /* renamed from: c */
        private int f39654c;

        public C13473a(UMAuthListener uMAuthListener, SHARE_MEDIA share_media) {
            this.f39652a = uMAuthListener;
            this.f39653b = share_media;
        }

        /* renamed from: a */
        public void m13203a(Exception exc) {
            UMAuthListener uMAuthListener = this.f39652a;
            if (uMAuthListener != null) {
                uMAuthListener.onError(this.f39653b, this.f39654c, exc);
            }
        }

        /* renamed from: a */
        public void m13204a(Bundle bundle) {
            UMAuthListener uMAuthListener = this.f39652a;
            if (uMAuthListener != null) {
                uMAuthListener.onComplete(this.f39653b, this.f39654c, SocializeUtils.bundleTomap(bundle));
            }
        }

        /* renamed from: a */
        public void m13205a() {
            UMAuthListener uMAuthListener = this.f39652a;
            if (uMAuthListener != null) {
                uMAuthListener.onCancel(this.f39653b, this.f39654c);
            }
        }
    }

    /* renamed from: com.umeng.socialize.view.OauthDialog$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13474b extends WebChromeClient {

        /* renamed from: a */
        private WeakReference<OauthDialog> f39655a;

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            WeakReference<OauthDialog> weakReference = this.f39655a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                if (i < 90) {
                    oauthDialog.mProgressbar.setVisibility(0);
                } else {
                    oauthDialog.mHandler.sendEmptyMessage(1);
                }
            }
        }

        private C13474b(OauthDialog oauthDialog) {
            this.f39655a = new WeakReference<>(oauthDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.umeng.socialize.view.OauthDialog$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13475c extends WebViewClient {

        /* renamed from: a */
        private WeakReference<OauthDialog> f39656a;

        /* renamed from: a */
        private void m13202a(String str) {
            WeakReference<OauthDialog> weakReference = this.f39656a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                oauthDialog.mFlag = 1;
                oauthDialog.mValues = SocializeUtils.parseUrl(str);
                if (oauthDialog.isShowing()) {
                    SocializeUtils.safeCloseDialog(oauthDialog);
                }
            }
        }

        /* renamed from: b */
        private void m13201b(String str) {
            WeakReference<OauthDialog> weakReference = this.f39656a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                oauthDialog.mFlag = 1;
                oauthDialog.mValues = SocializeNetUtils.parseUrl(str);
                if (oauthDialog.isShowing()) {
                    SocializeUtils.safeCloseDialog(oauthDialog);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WeakReference<OauthDialog> weakReference = this.f39656a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                oauthDialog.mHandler.sendEmptyMessage(1);
                super.onPageFinished(webView, str);
                if (oauthDialog.mFlag == 0 && str.contains(oauthDialog.mWaitUrl)) {
                    m13202a(str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WeakReference<OauthDialog> weakReference = this.f39656a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                String decrypt = str.contains("?ud_get=") ? oauthDialog.decrypt(str) : "";
                if (decrypt.contains("access_key") && decrypt.contains("access_secret")) {
                    if (str.contains(oauthDialog.mWaitUrl)) {
                        m13202a(str);
                        return;
                    }
                    return;
                } else if (str.startsWith(OauthDialog.mRedirectUri)) {
                    m13201b(str);
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WeakReference<OauthDialog> weakReference = this.f39656a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                View view = oauthDialog.mProgressbar;
                if (view.getVisibility() == 0) {
                    view.setVisibility(8);
                }
            }
            super.onReceivedError(webView, i, str, str2);
            if (oauthDialog != null) {
                SocializeUtils.safeCloseDialog(oauthDialog);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WeakReference<OauthDialog> weakReference = this.f39656a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                Context applicationContext = oauthDialog.mContext.getApplicationContext();
                if (!DeviceConfig.isNetworkAvailable(applicationContext)) {
                    Toast.makeText(applicationContext, UmengText.NET.NET_INAVALIBLE, 0).show();
                    return true;
                }
                if (str.contains("?ud_get=")) {
                    str = oauthDialog.decrypt(str);
                }
                if (str.contains(oauthDialog.mWaitUrl)) {
                    m13202a(str);
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        private C13475c(OauthDialog oauthDialog) {
            this.f39656a = new WeakReference<>(oauthDialog);
        }
    }

    public OauthDialog(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        super(activity, share_media);
        this.mListener = new C13473a(uMAuthListener, share_media);
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String decrypt(String str) {
        try {
            String[] split = str.split("ud_get=");
            return split[0] + split[1];
        } catch (Exception e) {
            SLog.error(e);
            return str;
        }
    }

    private WebViewClient getAdapterWebViewClient() {
        return new C13475c();
    }

    private String getUrl(SHARE_MEDIA share_media) {
        URLBuilder uRLBuilder = new URLBuilder(this.mContext);
        uRLBuilder.setHost("https://log.umsns.com/").setPath("share/auth/").setAppkey(SocializeUtils.getAppkey(this.mContext)).setEntityKey(Config.EntityKey).withMedia(share_media).withOpId(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).withSessionId(Config.SessionId).withUID(UMUtils.getUMId(this.mContext));
        return uRLBuilder.toEncript();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Bundle bundle = this.mValues;
        if (bundle != null) {
            String string = bundle.getString("uid");
            String string2 = this.mValues.getString("error_code");
            String string3 = this.mValues.getString("error_description");
            if (this.mPlatform == SHARE_MEDIA.SINA && !TextUtils.isEmpty(string3)) {
                C13473a c13473a = this.mListener;
                c13473a.m13203a(new SocializeException(UmengErrorCode.AuthorizeFailed.getMessage() + "errorcode:" + string2 + " message:" + string3));
            } else if (TextUtils.isEmpty(string)) {
                C13473a c13473a2 = this.mListener;
                c13473a2.m13203a(new SocializeException(UmengErrorCode.AuthorizeFailed.getMessage() + "unfetch usid..."));
            } else {
                Bundle bundle2 = this.mValues;
                bundle2.putString("accessToken", bundle2.getString("access_key"));
                Bundle bundle3 = this.mValues;
                bundle3.putString("expiration", bundle3.getString("expires_in"));
                this.mListener.m13204a(this.mValues);
            }
        } else {
            this.mListener.m13205a();
        }
        super.dismiss();
        releaseWebView();
    }

    @Override // com.umeng.socialize.view.BaseDialog
    public void setClient(WebView webView) {
        webView.setWebViewClient(getAdapterWebViewClient());
        this.mWebView.setWebChromeClient(new C13474b());
    }

    public void setmRedirectUri(String str) {
        mRedirectUri = str;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mValues = null;
        SHARE_MEDIA share_media = this.mPlatform;
        if (share_media == SHARE_MEDIA.SINA) {
            this.mWebView.loadUrl(this.mWaitUrl);
            return;
        }
        this.mWebView.loadUrl(getUrl(share_media));
    }
}
