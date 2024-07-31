package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bytedance.msdk.adapter.ThirdSdkInit;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.Preconditions;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.InitSdkError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleAdapterConfiguration extends TTBaseAdapterConfiguration {
    public static final String AD_PLACEMENT_ID_EXTRA_KEY = "ad_placement_id";
    public static final String APP_ID_EXTRA_KEY = "app_id";
    public static final int TT_THEME_STATUS_DAY = 0;
    public static final int TT_THEME_STATUS_NIGHT = 1;

    /* renamed from: b */
    private static final String f21419b = "PangleAdapterConfiguration";

    /* renamed from: a */
    private static void m37731a(Context context, String str, ThirdSdkInit.InitCallback initCallback) {
        if (!TextUtils.isEmpty(str) && context != null) {
            TTPangleSDKInitManager.initTTPangleSDK(context, str, initCallback);
            return;
        }
        Logger.m37557e("TTMediationSDK_ADAPTER", f21419b + ",Invalid Pangle app ID. Ensure the app id is valid on the csj dashboard.");
        if (initCallback != null) {
            initCallback.fail(1, "Invalid Pangle app ID");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: b */
    private int[] m37730b(int i, AdSlot adSlot) {
        switch (i) {
            case 1:
                return new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 50};
            case 2:
                return new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 100};
            case 3:
                return new int[]{300, 250};
            case 4:
                return new int[]{468, 60};
            case 5:
                return new int[]{728, 90};
            case 6:
                if (adSlot.getImgAcceptedWidth() > 0 && adSlot.getImgAcceptedHeight() > 0) {
                    return new int[]{adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()};
                }
                if (adSlot.getImgAcceptedWidth() > 0 && adSlot.getImgAcceptedHeight() < 0) {
                    return new int[]{adSlot.getImgAcceptedWidth(), 0};
                }
                break;
        }
        return new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 50};
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdNetworkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdapterVersion() {
        return "4.0.0.0.0";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getBiddingToken(Context context, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.AdSlot adSlot = null;
        r12 = null;
        WaterFallConfig waterFallConfig = null;
        adSlot = null;
        if (map != null) {
            Object obj = map.get(TTBaseAdapterConfiguration.TT_MSDK_ADSLOT_INFO);
            Object obj2 = map.get(TTBaseAdapterConfiguration.TT_MSDK_WATER_FALL_AB_TEST);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = map.get(TTBaseAdapterConfiguration.TT_MSDK_CLIENT_REQ_ID);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            if (obj instanceof AdSlot) {
                AdSlot adSlot2 = (AdSlot) obj;
                AdSlot.Builder mediaExtra = new AdSlot.Builder().setAdType(adSlot2.getAdType()).setAdCount(adSlot2.getAdCount()).setCodeId(adSlot2.getAdUnitId()).setOrientation(adSlot2.getOrientation()).setRewardAmount(adSlot2.getRewardAmount()).setRewardName(adSlot2.getRewardName()).setSupportDeepLink(adSlot2.isSupportDeepLink()).setUserID(adSlot2.getUserID()).setMediaExtra(adSlot2.getMediaExtra());
                List list = (List) map.get(TTBaseAdapterConfiguration.TT_MSDK_WATER_FALL_LIST);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WaterFallConfig waterFallConfig2 = (WaterFallConfig) it.next();
                        if (waterFallConfig2 != null && waterFallConfig2.m59450u() && TextUtils.equals(waterFallConfig2.m59477d(), "pangle")) {
                            waterFallConfig = waterFallConfig2;
                            break;
                        }
                    }
                }
                int m59457n = waterFallConfig != null ? waterFallConfig.m59457n() : 0;
                if (adSlot2.getAdType() == 3) {
                    if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                        mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                        mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                    } else {
                        mediaExtra.setExpressViewAcceptedSize(1080.0f, 1920.0f);
                        mediaExtra.setImageAcceptedSize(PredefinedCaptureConfigurations.f24409s, PredefinedCaptureConfigurations.f24410t);
                    }
                } else if (adSlot2.getAdType() != 1 && adSlot2.getAdType() != 2) {
                    if (adSlot2.getAdType() == 5) {
                        if (m59457n == 1 || m59457n == 2) {
                            if (m59457n == 1) {
                                if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() <= 0) {
                                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), 0.0f);
                                } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                                }
                            } else if (adSlot2.getImgAcceptedHeight() > 0 && adSlot2.getImgAcceptedWidth() > 0) {
                                mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                            } else {
                                mediaExtra.setImageAcceptedSize(640, 340);
                            }
                        } else if (adSlot2.getAdStyleType() == 1) {
                            if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() <= 0) {
                                mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), 0.0f);
                            } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                                mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                            }
                        } else if (adSlot2.getImgAcceptedHeight() > 0 && adSlot2.getImgAcceptedWidth() > 0) {
                            mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                        } else {
                            mediaExtra.setImageAcceptedSize(640, 340);
                        }
                    }
                } else if (adSlot2.getAdStyleType() != 1 && adSlot2.getAdType() != 1 && adSlot2.getAdType() != 2) {
                    if (adSlot2.getImgAcceptedHeight() > 0 && adSlot2.getImgAcceptedWidth() > 0) {
                        mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                    } else {
                        mediaExtra.setImageAcceptedSize(640, 340);
                    }
                } else if (adSlot2.getAdType() == 1) {
                    int[] m37730b = m37730b(adSlot2.getBannerSize(), adSlot2);
                    mediaExtra.setExpressViewAcceptedSize(m37730b[0], m37730b[1]);
                } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() <= 0) {
                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), 0.0f);
                } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                }
                if (m59457n != 0) {
                    if (m59457n == 1 && adSlot2.getAdType() == 5) {
                        mediaExtra.setNativeAdType(adSlot2.getAdType());
                    }
                } else if (adSlot2.getAdStyleType() == 1 && adSlot2.getAdType() == 5) {
                    mediaExtra.setNativeAdType(adSlot2.getAdType());
                }
                if (adSlot2.getAdType() == 1 || adSlot2.getAdType() == 2) {
                    mediaExtra.setNativeAdType(adSlot2.getAdType());
                }
                PangleAdapterUtils.updateData(mediaExtra, str, str2, true);
                adSlot = mediaExtra.build();
            }
        }
        return TTAdSdk.getAdManager().getBiddingToken(adSlot);
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkVersion() {
        return TTAdSdk.getAdManager().getSDKVersion();
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void initializeNetwork(@NonNull Context context, Map<String, String> map, final TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(tTOnNetworkInitializationFinishedListener);
        if (isInitedSuccess() || map == null || map.isEmpty()) {
            return;
        }
        try {
            m37731a(context, map.get("app_id"), new ThirdSdkInit.InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.1
                @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
                public void fail(int i, String str) {
                    PangleAdapterConfiguration.this.setInitedSuccess(false);
                    TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener2 = tTOnNetworkInitializationFinishedListener;
                    if (tTOnNetworkInitializationFinishedListener2 != null) {
                        tTOnNetworkInitializationFinishedListener2.onNetworkInitializationFinished(PangleAdapterConfiguration.class, new InitSdkError(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle"));
                    }
                    Logger.m37557e("TTMediationSDK_ADAPTER", "Initializing Pangle has encountered an exception.code=" + i + ",msg=" + str);
                }

                @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
                public void success() {
                    PangleAdapterConfiguration.this.setInitedSuccess(true);
                    TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener2 = tTOnNetworkInitializationFinishedListener;
                    if (tTOnNetworkInitializationFinishedListener2 != null) {
                        tTOnNetworkInitializationFinishedListener2.onNetworkInitializationFinished(PangleAdapterConfiguration.class, new InitSdkError(AdError.ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS, "pangle"));
                    }
                    Logger.m37554i("TTMediationSDK_P", "Initializing Pangle has success !!!");
                }
            });
        } catch (Exception e) {
            Logger.m37556e("TTMediationSDK_ADAPTER", "Initializing Pangle has encountered an exception.", e);
            if (tTOnNetworkInitializationFinishedListener != null) {
                tTOnNetworkInitializationFinishedListener.onNetworkInitializationFinished(PangleAdapterConfiguration.class, new InitSdkError(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle"));
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setThemeStatus(Map<String, Object> map) {
        super.setThemeStatus(map);
        if (map == null) {
            return;
        }
        Object obj = map.get(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (intValue == 0 || intValue == 1) {
            TTAdSdk.getAdManager().setThemeStatus(intValue);
        }
    }
}
