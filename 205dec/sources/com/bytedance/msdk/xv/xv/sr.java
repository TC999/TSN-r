package com.bytedance.msdk.xv.xv;

import android.content.Context;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.f.ck;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager;
import com.bytedance.pangle.sdk.component.log.impl.ILogNetDepend;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.net.IGetExecutor;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements IAdLogDepend {
    public static String c(String str) {
        return com.bytedance.msdk.f.c.w(str, com.bytedance.msdk.f.w.c());
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public boolean canUseSDK() {
        return true;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public AdLogEventFace compositeMonitorStates(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public String decryptWithCBC(String str) {
        return c(str);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public boolean enableTrack() {
        return false;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public String encryptWithCBC(String str) {
        return com.bytedance.msdk.f.c.c(str, com.bytedance.msdk.f.w.c());
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public String getDebugLogTag() {
        return "mediation_log";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public String getEnableSendStagingAdlog() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public ILogNetDepend getLogNetDepend() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public IListenerEventManager getOverSeaListener() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public String getWebViewUA() {
        return "gromore-no-webview";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public boolean isAvailableNet(Context context) {
        return ck.c(context);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public boolean isDebug() {
        return false;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public boolean isOpenMonitor() {
        return false;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public boolean isUploadDebugMessage() {
        return false;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public IGetExecutor providerGetExecutor() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public Executor providerIOExecutor() {
        return f.f();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public Executor providerLogExecutor() {
        return f.f();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public int sdkType() {
        return 2;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public void upDateDBAdEvent(boolean z3) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public void upDateDBAdEventTime() {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend
    public void upDateNetAdEvent(boolean z3, int i4, long j4) {
    }
}
