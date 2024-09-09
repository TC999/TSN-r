package com.bytedance.msdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a;
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

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ThirdSdkInit {

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface InitCallback {
        void fail(int i4, String str);

        void success();
    }

    public static String getTTPangleAppId() {
        a a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("pangle");
        String a5 = a4 != null ? a4.a() : null;
        return TextUtils.isEmpty(a5) ? b.B().c() : a5;
    }

    public static void initTTBaiduSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> c4;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c()) == null || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("baidu"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            hashMap.put(TTBaseAdapterConfiguration.BAIDU_IS_READ_DEVICE_ID, b.B().d() ? "true" : "false");
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.3
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("TTMediationSDK_SDK_Init", "BAIDU SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initTTGDTSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> c4;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c()) == null || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("gdt"))) == null) {
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
            Logger.e("TTMediationSDK_SDK_Init", "GDT SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initTTKSSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> c4;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c()) == null || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("ks"))) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", str);
            hashMap.put("app_name", b.B().g());
            iTTAdapterConfiguration.initializeNetwork(context, hashMap, new TTOnNetworkInitializationFinishedListener() { // from class: com.bytedance.msdk.adapter.ThirdSdkInit.2
                @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
                public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("TTMediationSDK_SDK_Init", "KS SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initTTKlevinSDK(Context context, String str) {
        Map<String, ITTAdapterConfiguration> c4;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c()) == null || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("klevin"))) == null) {
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
            Logger.e("TTMediationSDK_SDK_Init", "klevin SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initTTMintergralSDK(Context context, String str, String str2) {
        Map<String, ITTAdapterConfiguration> c4;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c()) == null || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("mintegral"))) == null) {
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
            Logger.e("TTMediationSDK_SDK_Init", "Mintegral SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initTTPangleSDK(Context context) {
        TTPangleSDKInitManager.initTTPangleSDK(context, getTTPangleAppId(), null);
    }

    public static void initTTSigmobSDK(Context context, String str, String str2) {
        Map<String, ITTAdapterConfiguration> c4;
        ITTAdapterConfiguration iTTAdapterConfiguration;
        if (context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c()) == null || (iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName("sigmob"))) == null) {
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
            Logger.e("TTMediationSDK_SDK_Init", "Sigmob SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initUnitySDK(Activity activity) {
        try {
            Method method = Class.forName("com.bytedance.msdk.adapter.init.UnitySdkInit").getMethod("initUnitySDK", Activity.class, String.class);
            a a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("unity");
            if (a4 != null) {
                method.invoke(null, activity, a4.a());
            } else {
                Logger.e("TTMediationSDK_SDK_Init", "unitySdkInit \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 \u914d\u7f6e\u4fe1\u606f\u4e3anull");
            }
        } catch (Throwable th) {
            Logger.e("TTMediationSDK_SDK_Init", "unitySdkInit \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
        }
    }

    public static void initTTPangleSDK(Context context, String str, InitCallback initCallback) {
        TTPangleSDKInitManager.initTTPangleSDK(context, str, initCallback);
    }
}
