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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class OADIDSDKHelper {
    private static final String SUB_TAG = "OADIDSDKHelper:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j4, a aVar) {
            this.mStartTime = j4;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    Log.d("KSAdSDK", "OADIDSDKHelper:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.em(oaid);
                } else {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void em(String str);
    }

    public static void getOAId(Context context, a aVar) {
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
                int InitSdk = MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListenerImpl(currentTimeMillis, aVar));
                Log.d("KSAdSDK", "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable unused) {
                Log.d("KSAdSDK", "OADIDSDKHelper:oaid sdk not find ");
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
                int a4 = e.a();
                Log.d("KSAdSDK", "OADIDSDKHelper:oaidVersion" + a4);
                try {
                    Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
                    return true;
                } catch (Throwable unused) {
                    Log.d("KSAdSDK", "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                    return false;
                }
            } catch (Throwable unused2) {
                Log.d("KSAdSDK", "OADIDSDKHelper:oaidVersion fail");
                return false;
            }
        } catch (Throwable unused3) {
            Log.d("KSAdSDK", "OADIDSDKHelper:isSupport oaid sdk not find ");
            return false;
        }
    }
}
