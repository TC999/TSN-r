package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PangleAdapterConfiguration extends TTBaseAdapterConfiguration {
    public static final String AD_PLACEMENT_ID_EXTRA_KEY = "ad_placement_id";
    public static final String APP_ID_EXTRA_KEY = "app_id";
    public static final int TT_THEME_STATUS_DAY = 0;
    public static final int TT_THEME_STATUS_NIGHT = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final String f27029b = "PangleAdapterConfiguration";

    private static void a(Context context, String str, ThirdSdkInit.InitCallback initCallback) {
        if (!TextUtils.isEmpty(str) && context != null) {
            TTPangleSDKInitManager.initTTPangleSDK(context, str, initCallback);
            return;
        }
        Logger.e("TTMediationSDK_ADAPTER", f27029b + ",Invalid Pangle app ID. Ensure the app id is valid on the csj dashboard.");
        if (initCallback != null) {
            initCallback.fail(1, "Invalid Pangle app ID");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int[] b(int i4, AdSlot adSlot) {
        switch (i4) {
            case 1:
                return new int[]{320, 50};
            case 2:
                return new int[]{320, 100};
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
        return new int[]{320, 50};
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
        h hVar = null;
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
                        h hVar2 = (h) it.next();
                        if (hVar2 != null && hVar2.u() && TextUtils.equals(hVar2.d(), "pangle")) {
                            hVar = hVar2;
                            break;
                        }
                    }
                }
                int n4 = hVar != null ? hVar.n() : 0;
                if (adSlot2.getAdType() == 3) {
                    if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                        mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                        mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                    } else {
                        mediaExtra.setExpressViewAcceptedSize(1080.0f, 1920.0f);
                        mediaExtra.setImageAcceptedSize(1080, 1920);
                    }
                } else if (adSlot2.getAdType() != 1 && adSlot2.getAdType() != 2) {
                    if (adSlot2.getAdType() == 5) {
                        if (n4 == 1 || n4 == 2) {
                            if (n4 == 1) {
                                if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() <= 0) {
                                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), 0.0f);
                                } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                                }
                            } else if (adSlot2.getImgAcceptedHeight() > 0 && adSlot2.getImgAcceptedWidth() > 0) {
                                mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                            } else {
                                mediaExtra.setImageAcceptedSize(640, MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO);
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
                            mediaExtra.setImageAcceptedSize(640, MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO);
                        }
                    }
                } else if (adSlot2.getAdStyleType() != 1 && adSlot2.getAdType() != 1 && adSlot2.getAdType() != 2) {
                    if (adSlot2.getImgAcceptedHeight() > 0 && adSlot2.getImgAcceptedWidth() > 0) {
                        mediaExtra.setImageAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                    } else {
                        mediaExtra.setImageAcceptedSize(640, MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO);
                    }
                } else if (adSlot2.getAdType() == 1) {
                    int[] b4 = b(adSlot2.getBannerSize(), adSlot2);
                    mediaExtra.setExpressViewAcceptedSize(b4[0], b4[1]);
                } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() <= 0) {
                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), 0.0f);
                } else if (adSlot2.getImgAcceptedWidth() > 0 && adSlot2.getImgAcceptedHeight() > 0) {
                    mediaExtra.setExpressViewAcceptedSize(adSlot2.getImgAcceptedWidth(), adSlot2.getImgAcceptedHeight());
                }
                if (n4 != 0) {
                    if (n4 == 1 && adSlot2.getAdType() == 5) {
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
            a(context, map.get("app_id"), new ThirdSdkInit.InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.1
                @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
                public void fail(int i4, String str) {
                    PangleAdapterConfiguration.this.setInitedSuccess(false);
                    TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener2 = tTOnNetworkInitializationFinishedListener;
                    if (tTOnNetworkInitializationFinishedListener2 != null) {
                        tTOnNetworkInitializationFinishedListener2.onNetworkInitializationFinished(PangleAdapterConfiguration.class, new InitSdkError(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle"));
                    }
                    Logger.e("TTMediationSDK_ADAPTER", "Initializing Pangle has encountered an exception.code=" + i4 + ",msg=" + str);
                }

                @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
                public void success() {
                    PangleAdapterConfiguration.this.setInitedSuccess(true);
                    TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener2 = tTOnNetworkInitializationFinishedListener;
                    if (tTOnNetworkInitializationFinishedListener2 != null) {
                        tTOnNetworkInitializationFinishedListener2.onNetworkInitializationFinished(PangleAdapterConfiguration.class, new InitSdkError(AdError.ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS, "pangle"));
                    }
                    Logger.i("TTMediationSDK_P", "Initializing Pangle has success !!!");
                }
            });
        } catch (Exception e4) {
            Logger.e("TTMediationSDK_ADAPTER", "Initializing Pangle has encountered an exception.", e4);
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
