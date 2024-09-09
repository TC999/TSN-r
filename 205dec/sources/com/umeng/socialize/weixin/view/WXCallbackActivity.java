package com.umeng.socialize.weixin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class WXCallbackActivity extends Activity implements IWXAPIEventHandler {
    private final String TAG = "WXCallbackActivity";
    protected UMWXHandler mWxHandler = null;

    protected void handleIntent(Intent intent) {
        this.mWxHandler.getWXApi().handleIntent(intent, this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SLog.I("WXCallbackActivity onCreate");
        UMShareAPI uMShareAPI = UMShareAPI.get(StubApp.getOrigApplicationContext(getApplicationContext()));
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        this.mWxHandler = (UMWXHandler) uMShareAPI.getHandler(share_media);
        SLog.I("WXCallbackActivity mWxHandler\uff1a" + this.mWxHandler);
        this.mWxHandler.onCreate(StubApp.getOrigApplicationContext(getApplicationContext()), PlatformConfig.getPlatform(share_media));
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SLog.I("WXCallbackActivity onNewIntent");
        setIntent(intent);
        UMShareAPI uMShareAPI = UMShareAPI.get(StubApp.getOrigApplicationContext(getApplicationContext()));
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        UMWXHandler uMWXHandler = (UMWXHandler) uMShareAPI.getHandler(share_media);
        this.mWxHandler = uMWXHandler;
        uMWXHandler.onCreate(StubApp.getOrigApplicationContext(getApplicationContext()), PlatformConfig.getPlatform(share_media));
        handleIntent(intent);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        UMWXHandler uMWXHandler = this.mWxHandler;
        if (uMWXHandler != null) {
            uMWXHandler.getWXEventHandler().onReq(baseReq);
        }
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        SLog.I("WXCallbackActivity \u5206\u53d1\u56de\u8c03");
        UMWXHandler uMWXHandler = this.mWxHandler;
        if (uMWXHandler != null && baseResp != null) {
            try {
                uMWXHandler.getWXEventHandler().onResp(baseResp);
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
        finish();
    }
}
