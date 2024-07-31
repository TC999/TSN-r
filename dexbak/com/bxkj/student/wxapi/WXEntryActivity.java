package com.bxkj.student.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stub.StubApp;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;
import com.tencent.p562mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.p562mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.SLog;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a */
    private UMWXHandler f21278a = null;

    static {
        StubApp.interface11(12875);
    }

    /* renamed from: a */
    private void m37927a(Intent intent) {
        this.f21278a.getWXApi().handleIntent(intent, this);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    @Override // android.app.Activity
    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        setIntent(paramIntent);
        UMShareAPI uMShareAPI = UMShareAPI.get(StubApp.getOrigApplicationContext(getApplicationContext()));
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        UMWXHandler uMWXHandler = (UMWXHandler) uMShareAPI.getHandler(share_media);
        this.f21278a = uMWXHandler;
        uMWXHandler.onCreate(StubApp.getOrigApplicationContext(getApplicationContext()), PlatformConfig.getPlatform(share_media));
        m37927a(paramIntent);
    }

    @Override // com.tencent.p562mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq req) {
        UMWXHandler uMWXHandler = this.f21278a;
        if (uMWXHandler != null) {
            uMWXHandler.getWXEventHandler().onReq(req);
        }
        finish();
    }

    @Override // com.tencent.p562mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp resp) {
        SLog.m13210I("WXCallbackActivity 分发回调");
        if (resp.getType() == 19) {
            WXLaunchMiniProgram.Resp resp2 = (WXLaunchMiniProgram.Resp) resp;
        }
        UMWXHandler uMWXHandler = this.f21278a;
        if (uMWXHandler != null) {
            try {
                uMWXHandler.getWXEventHandler().onResp(resp);
            } catch (Exception e) {
                SLog.error(e);
            }
        }
        finish();
    }
}
