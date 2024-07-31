package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.config.TTAppDialogClickListener;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.error.InitSdkError;
import com.p518qq.p519e.ads.dfa.GDTAppDialogClickListener;
import com.p518qq.p519e.comm.managers.GDTAdSdk;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.GDTADManager;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtAdapterConfiguration extends TTBaseAdapterConfiguration {
    /* renamed from: a */
    private boolean m37854a(Context context, String str, TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener) {
        try {
            if (context == null || str == null) {
                Logger.m37557e("TTMediationSDK_SDK_Init", "init GDT SDK fail ! context or appId can't be null !!");
                return false;
            }
            Logger.m37554i("TTMediationSDK_SDK_Init", "init GDT SDK start......");
            boolean initWith = GDTADManager.getInstance().initWith(context, str);
            Logger.m37554i("TTMediationSDK_SDK_Init", "init GDT SDK  finish......");
            return initWith;
        } catch (Throwable th) {
            Logger.m37557e("TTMediationSDK_SDK_Init", "init GDT SDK fail error msg:" + th.toString());
            return false;
        }
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdNetworkName() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdapterVersion() {
        return "4.391.1261.1";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkVersion() {
        return SDKStatus.getIntegrationSDKVersion();
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void initializeNetwork(@NonNull Context context, @Nullable Map<String, String> map, @NonNull TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener) {
        InitSdkError initSdkError;
        synchronized (GdtAdapterConfiguration.class) {
            if (!isInitedSuccess() && map != null && !map.isEmpty()) {
                boolean m37854a = m37854a(context, map.get("app_id"), tTOnNetworkInitializationFinishedListener);
                if (tTOnNetworkInitializationFinishedListener != null) {
                    if (m37854a) {
                        setInitedSuccess(true);
                        initSdkError = new InitSdkError(AdError.ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS, "gdt");
                    } else {
                        initSdkError = new InitSdkError(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "gdt");
                    }
                    tTOnNetworkInitializationFinishedListener.onNetworkInitializationFinished(GdtAdapterConfiguration.class, initSdkError);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public int showOpenOrInstallAppDialog(final TTAppDialogClickListener tTAppDialogClickListener) {
        try {
            return GDTAdSdk.getGDTAdManger().showOpenOrInstallAppDialog(new GDTAppDialogClickListener(this) { // from class: com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration.1
                @Override // com.p518qq.p519e.ads.dfa.GDTAppDialogClickListener
                public void onButtonClick(int i) {
                    TTAppDialogClickListener tTAppDialogClickListener2 = tTAppDialogClickListener;
                    if (tTAppDialogClickListener2 != null) {
                        tTAppDialogClickListener2.onButtonClick(i);
                    }
                }
            });
        } catch (Exception unused) {
            return 0;
        }
    }
}
