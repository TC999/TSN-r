package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.stub.StubApp;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class OADIDSDKHelper {
    private static final String SUB_TAG = "OADIDSDKHelper:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class IIdentifierListenerImpl implements IIdentifierListener {
        private final InterfaceC10889a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j, InterfaceC10889a interfaceC10889a) {
            this.mStartTime = j;
            this.mOaidListener = interfaceC10889a;
        }

        public void onSupport(IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    Log.d(OADIDSDKHelper.TAG, "OADIDSDKHelper:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.mo24548em(oaid);
                } else {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    /* renamed from: com.kwad.sdk.oaid.OADIDSDKHelper$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10889a {
        /* renamed from: em */
        void mo24548em(String str);
    }

    public static void getOAId(Context context, InterfaceC10889a interfaceC10889a) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
        } else if (mIsRequestIng) {
        } else {
            mIsRequestIng = true;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int InitSdk = MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListenerImpl(currentTimeMillis, interfaceC10889a));
                Log.d(TAG, "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable unused) {
                Log.d(TAG, "OADIDSDKHelper:oaid sdk not find ");
                mIsRequestIng = false;
                sGetOaidFail = true;
            }
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper.1
                public final void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport(null);
            try {
                int a = e.a();
                Log.d(TAG, "OADIDSDKHelper:oaidVersion" + a);
                try {
                    Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
                    return true;
                } catch (Throwable unused) {
                    Log.d(TAG, "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                    return false;
                }
            } catch (Throwable unused2) {
                Log.d(TAG, "OADIDSDKHelper:oaidVersion fail");
                return false;
            }
        } catch (Throwable unused3) {
            Log.d(TAG, "OADIDSDKHelper:isSupport oaid sdk not find ");
            return false;
        }
    }
}
