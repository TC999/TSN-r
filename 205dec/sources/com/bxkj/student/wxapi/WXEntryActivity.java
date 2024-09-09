package com.bxkj.student.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a  reason: collision with root package name */
    private UMWXHandler f24731a = null;

    static {
        StubApp.interface11(12875);
    }

    private void a(Intent intent) {
        this.f24731a.getWXApi().handleIntent(intent, this);
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
        this.f24731a = uMWXHandler;
        uMWXHandler.onCreate(StubApp.getOrigApplicationContext(getApplicationContext()), PlatformConfig.getPlatform(share_media));
        a(paramIntent);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq req) {
        UMWXHandler uMWXHandler = this.f24731a;
        if (uMWXHandler != null) {
            uMWXHandler.getWXEventHandler().onReq(req);
        }
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp resp) {
        SLog.I("WXCallbackActivity \u5206\u53d1\u56de\u8c03");
        if (resp.getType() == 19) {
            WXLaunchMiniProgram.Resp resp2 = (WXLaunchMiniProgram.Resp) resp;
        }
        UMWXHandler uMWXHandler = this.f24731a;
        if (uMWXHandler != null) {
            try {
                uMWXHandler.getWXEventHandler().onResp(resp);
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
        finish();
    }
}
