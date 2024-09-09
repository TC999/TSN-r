package com.bytedance.pangle.sdk.component.log.impl;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.net.IGetExecutor;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IAdLogDepend {
    public static final int OTHER_SDK = 3;
    public static final int SDK_GROMORE = 2;
    public static final int SDK_OPEN_AD_SDK = 0;
    public static final int SDK_OVERSEAS = 1;

    boolean canUseSDK();

    AdLogEventFace compositeMonitorStates(JSONObject jSONObject);

    String decryptWithCBC(String str);

    boolean enableTrack();

    String encryptWithCBC(String str);

    String getDebugLogTag();

    String getEnableSendStagingAdlog();

    ILogNetDepend getLogNetDepend();

    IListenerEventManager getOverSeaListener();

    String getWebViewUA();

    boolean isAvailableNet(Context context);

    boolean isDebug();

    boolean isOpenMonitor();

    boolean isUploadDebugMessage();

    IGetExecutor providerGetExecutor();

    Executor providerIOExecutor();

    Executor providerLogExecutor();

    int sdkType();

    void upDateDBAdEvent(boolean z3);

    void upDateDBAdEventTime();

    void upDateNetAdEvent(boolean z3, int i4, long j4);
}
