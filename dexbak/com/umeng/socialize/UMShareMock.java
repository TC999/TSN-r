package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMSSOHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.umeng.socialize.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMShareMock extends UMShareAPI {
    /* JADX INFO: Access modifiers changed from: protected */
    public UMShareMock(Context context) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return null;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return "";
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return false;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return false;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return false;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void release() {
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void setShareConfig(UMShareConfig uMShareConfig) {
    }
}
