package com.kwad.sdk.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.stub.StubApp;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class OADIDSDKHelper25 {
    private static final String SUB_TAG = "OADIDSDKHelper25:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    @Keep
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class IIdentifierListener25 implements IIdentifierListener {
        private final InterfaceC10891a mOaidListener;
        private final long mStartTime;

        public IIdentifierListener25(long j, InterfaceC10891a interfaceC10891a) {
            this.mStartTime = j;
            this.mOaidListener = interfaceC10891a;
        }

        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    Log.d(OADIDSDKHelper25.TAG, "OADIDSDKHelper25:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.mo24547em(oaid);
                } else {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }
    }

    /* renamed from: com.kwad.sdk.oaid.OADIDSDKHelper25$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10891a {
        @WorkerThread
        /* renamed from: em */
        void mo24547em(String str);
    }

    public static void getOAId(Context context, InterfaceC10891a interfaceC10891a) {
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
                int InitSdk = MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListener25(currentTimeMillis, interfaceC10891a));
                Log.d(TAG, "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable unused) {
                Log.d(TAG, "OADIDSDKHelper25:oaid sdk not find ");
                mIsRequestIng = false;
                sGetOaidFail = true;
            }
        }
    }

    public static boolean isSupport() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper25.1
                @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                public final void OnSupport(boolean z, IdSupplier idSupplier) {
                }
            }.OnSupport(true, null);
            try {
                Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper25.class.getClassLoader());
                return true;
            } catch (Throwable unused) {
                Log.d(TAG, "OADIDSDKHelper25:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                return false;
            }
        } catch (Throwable unused2) {
            Log.d(TAG, "OADIDSDKHelper25:isSupport oaid sdk not find ");
            return false;
        }
    }
}
