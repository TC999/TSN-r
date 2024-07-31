package com.bytedance.msdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdNetworkConfValue;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener;
import com.bytedance.msdk.adapter.pangle.TTPangleSDKInitManager;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ThirdSdkInit {

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    public static String getTTPangleAppId() {
        AdNetworkConfValue m59763a = InternalContainer.m59943f().m59763a("pangle");
        String m59573a = m59763a != null ? m59763a.m59573a() : null;
        return TextUtils.isEmpty(m59573a) ? SdkGlobalInfo.m59939B().m59921c() : m59573a;
    }

    public static void initTTBaiduSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> m59273c;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (m59273c = InitHelper.m59273c()) == null || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("baidu"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            hashMap.put(TTBaseAdapterConfiguration.BAIDU_IS_READ_DEVICE_ID, SdkGlobalInfo.m59939B().m59917d() ? "true" : "false");
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.3
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m37557e("TTMediationSDK_SDK_Init", "BAIDU SDK 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initTTGDTSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> m59273c;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (m59273c = InitHelper.m59273c()) == null || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("gdt"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.1
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m37557e("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initTTKSSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> m59273c;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (m59273c = InitHelper.m59273c()) == null || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("ks"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            hashMap.put("app_name", SdkGlobalInfo.m59939B().m59907g());
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.2
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m37557e("TTMediationSDK_SDK_Init", "KS SDK 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initTTKlevinSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> m59273c;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (m59273c = InitHelper.m59273c()) == null || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("klevin"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.6
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m37557e("TTMediationSDK_SDK_Init", "klevin SDK 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initTTMintergralSDK(Context context, String str, String str2) {
        Map<String, ITTAdapterConfiguration> m59273c;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m59273c = InitHelper.m59273c()) == null || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("mintegral"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            hashMap.put("app_key", str2);
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.4
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m37557e("TTMediationSDK_SDK_Init", "Mintegral SDK 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initTTPangleSDK(Context context) {
        TTPangleSDKInitManager.initTTPangleSDK(context, getTTPangleAppId(), null);
    }

    public static void initTTSigmobSDK(Context context, String str, String str2) {
        Map<String, ITTAdapterConfiguration> m59273c;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m59273c = InitHelper.m59273c()) == null || (iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName("sigmob"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            hashMap.put("app_key", str2);
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.5
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m37557e("TTMediationSDK_SDK_Init", "Sigmob SDK 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initUnitySDK(Activity activity) {
        try {
            Method method = Class.forName("com.bytedance.msdk.adapter.init.UnitySdkInit").getMethod("initUnitySDK", Activity.class, String.class);
            AdNetworkConfValue m59763a = InternalContainer.m59943f().m59763a("unity");
            if (m59763a != null) {
                method.invoke(null, activity, m59763a.m59573a());
            } else {
                Logger.m37557e("TTMediationSDK_SDK_Init", "unitySdkInit 初始化失败。。 配置信息为null");
            }
        } catch (Throwable th) {
            Logger.m37557e("TTMediationSDK_SDK_Init", "unitySdkInit 初始化失败。。 e=" + th.toString());
        }
    }

    public static void initTTPangleSDK(Context context, String str, InitCallback initCallback) {
        TTPangleSDKInitManager.initTTPangleSDK(context, str, initCallback);
    }
}
