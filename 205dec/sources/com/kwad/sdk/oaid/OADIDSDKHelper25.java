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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class OADIDSDKHelper25 {
    private static final String SUB_TAG = "OADIDSDKHelper25:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class IIdentifierListener25 implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListener25(long j4, a aVar) {
            this.mStartTime = j4;
            this.mOaidListener = aVar;
        }

        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void OnSupport(boolean z3, IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    Log.d("KSAdSDK", "OADIDSDKHelper25:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.em(oaid);
                } else {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        @WorkerThread
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
                int InitSdk = MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListener25(currentTimeMillis, aVar));
                Log.d("KSAdSDK", "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable unused) {
                Log.d("KSAdSDK", "OADIDSDKHelper25:oaid sdk not find ");
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
                public final void OnSupport(boolean z3, IdSupplier idSupplier) {
                }
            }.OnSupport(true, null);
            try {
                Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper25.class.getClassLoader());
                return true;
            } catch (Throwable unused) {
                Log.d("KSAdSDK", "OADIDSDKHelper25:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                return false;
            }
        } catch (Throwable unused2) {
            Log.d("KSAdSDK", "OADIDSDKHelper25:isSupport oaid sdk not find ");
            return false;
        }
    }
}
