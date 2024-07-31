package com.umeng.socialize.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QZoneSsoHandler extends UMTencentSSOHandler {
    private static final String TAG = "QZoneSsoHandler";
    private QZoneShareContent mShareContent;
    private QQPreferences qqPreferences;

    private void defaultQZoneShare(final Bundle bundle) {
        if (bundle != null) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.7
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneSsoHandler.this.mWeakAct.get() == null || QZoneSsoHandler.this.mWeakAct.get().isFinishing()) {
                        return;
                    }
                    QZoneSsoHandler qZoneSsoHandler = QZoneSsoHandler.this;
                    Bundle bundle2 = bundle;
                    QZoneSsoHandler qZoneSsoHandler2 = QZoneSsoHandler.this;
                    qZoneSsoHandler.mTencent.shareToQzone(qZoneSsoHandler.mWeakAct.get(), bundle2, qZoneSsoHandler2.getmShareListener(qZoneSsoHandler2.mShareListener));
                }
            });
        }
    }

    private void doPublishToQzone(final Bundle bundle) {
        if (bundle != null) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.6
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneSsoHandler.this.mWeakAct.get() == null || QZoneSsoHandler.this.mWeakAct.get().isFinishing()) {
                        return;
                    }
                    QZoneSsoHandler qZoneSsoHandler = QZoneSsoHandler.this;
                    Bundle bundle2 = bundle;
                    QZoneSsoHandler qZoneSsoHandler2 = QZoneSsoHandler.this;
                    qZoneSsoHandler.mTencent.publishToQzone(qZoneSsoHandler.mWeakAct.get(), bundle2, qZoneSsoHandler2.getmShareListener(qZoneSsoHandler2.mShareListener));
                }
            });
        }
    }

    private IUiListener getAuthlistener(UMAuthListener uMAuthListener) {
        return new IUiListener() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.4
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                QZoneSsoHandler qZoneSsoHandler = QZoneSsoHandler.this;
                qZoneSsoHandler.getAuthListener(qZoneSsoHandler.mAuthListener).onCancel(SHARE_MEDIA.QQ, 0);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                SocializeUtils.safeCloseDialog(QZoneSsoHandler.this.mProgressDialog);
                Bundle parseOauthData = QZoneSsoHandler.this.parseOauthData(obj);
                QZoneSsoHandler.this.qqPreferences.setAuthData(parseOauthData).commit();
                QZoneSsoHandler.this.initOpenidAndToken((JSONObject) obj);
                UMAuthListener uMAuthListener2 = QZoneSsoHandler.this.mAuthListener;
                if (uMAuthListener2 != null) {
                    uMAuthListener2.onComplete(SHARE_MEDIA.QQ, 0, SocializeUtils.bundleTomap(parseOauthData));
                }
                if (parseOauthData != null) {
                    TextUtils.isEmpty(parseOauthData.getString("ret"));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                QZoneSsoHandler qZoneSsoHandler = QZoneSsoHandler.this;
                UMAuthListener authListener = qZoneSsoHandler.getAuthListener(qZoneSsoHandler.mAuthListener);
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                authListener.onError(share_media, 0, new Throwable(UmengErrorCode.AuthorizeFailed.getMessage() + " ==> errorCode = " + uiError.errorCode + ", errorMsg = " + uiError.errorMessage + ", detail = " + uiError.errorDetail));
            }

            @Override // com.tencent.tauth.IUiListener
            public void onWarning(int i) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IUiListener getmShareListener(final UMShareListener uMShareListener) {
        return new IUiListener() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.5
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                QZoneSsoHandler.this.getShareListener(uMShareListener).onCancel(SHARE_MEDIA.QZONE);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                QZoneSsoHandler.this.getShareListener(uMShareListener).onResult(SHARE_MEDIA.QZONE);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                UMShareListener shareListener = QZoneSsoHandler.this.getShareListener(uMShareListener);
                SHARE_MEDIA share_media = SHARE_MEDIA.QZONE;
                shareListener.onError(share_media, new Throwable(UmengErrorCode.ShareFailed.getMessage() + uiError.errorMessage));
            }

            @Override // com.tencent.tauth.IUiListener
            public void onWarning(int i) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOpenidAndToken(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return;
            }
            this.mTencent.setAccessToken(string, string2);
            this.mTencent.setOpenId(string3);
        } catch (Exception e) {
            SLog.error(UmengText.C13465QQ.OPENIDANDTOKEN, e);
        }
    }

    private boolean isInstall(PlatformConfig.Platform platform) {
        return this.mWeakAct.get() == null || this.mWeakAct.get().isFinishing() || this.mTencent.isSupportSSOLogin(this.mWeakAct.get());
    }

    private void loginDeal() {
        if (this.mWeakAct.get() == null || this.mWeakAct.get().isFinishing()) {
            return;
        }
        this.mTencent.login(this.mWeakAct.get(), "all", getAuthlistener(this.mAuthListener));
    }

    private void shareToQZone() {
        Bundle buildParamsQzone = this.mShareContent.buildParamsQzone();
        buildParamsQzone.putString("appName", getShareConfig().getAppName());
        if (this.mShareContent.getisPublish()) {
            doPublishToQzone(buildParamsQzone);
        } else {
            defaultQZoneShare(buildParamsQzone);
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void authorize(UMAuthListener uMAuthListener) {
        if (isInstall(getConfig())) {
            this.mAuthListener = uMAuthListener;
            loginDeal();
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void deleteAuth(final UMAuthListener uMAuthListener) {
        this.mTencent.logout(getContext());
        QQPreferences qQPreferences = this.qqPreferences;
        if (qQPreferences != null) {
            qQPreferences.delete();
        }
        QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneSsoHandler.this.getAuthListener(uMAuthListener).onComplete(SHARE_MEDIA.QZONE, 1, null);
            }
        });
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public int getRequestCode() {
        return 10104;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isSupportAuth() {
        return true;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, getmShareListener(this.mShareListener));
        }
        if (i == 11101) {
            Tencent.onActivityResultData(i, i2, intent, getAuthlistener(this.mAuthListener));
        }
    }

    @Override // com.umeng.socialize.handler.UMTencentSSOHandler, com.umeng.socialize.handler.UMSSOHandler
    public void onCreate(Context context, PlatformConfig.Platform platform) {
        super.onCreate(context, platform);
        this.qqPreferences = new QQPreferences(context, SHARE_MEDIA.QQ.toString());
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean share(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (uMShareListener != null) {
            this.mShareListener = uMShareListener;
        }
        if (this.mTencent == null) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    UMShareListener shareListener = QZoneSsoHandler.this.getShareListener(uMShareListener);
                    SHARE_MEDIA share_media = SHARE_MEDIA.QZONE;
                    shareListener.onError(share_media, new Throwable(UmengErrorCode.ShareFailed.getMessage() + UmengText.tencentEmpty(Config.isUmengQQ.booleanValue())));
                }
            });
            return false;
        } else if (!isInstall(getConfig())) {
            if (Config.isJumptoAppStore) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://log.umsns.com/link/qq/download/"));
                this.mWeakAct.get().startActivity(intent);
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.QZoneSsoHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneSsoHandler.this.getShareListener(uMShareListener).onError(SHARE_MEDIA.QQ, new Throwable(UmengErrorCode.NotInstall.getMessage()));
                }
            });
            return false;
        } else {
            QZoneShareContent qZoneShareContent = new QZoneShareContent(shareContent);
            this.mShareContent = qZoneShareContent;
            UMShareConfig uMShareConfig = this.mShareConfig;
            if (uMShareConfig != null) {
                qZoneShareContent.setCompressListener(uMShareConfig.getCompressListener());
            }
            shareToQZone();
            return false;
        }
    }
}
