package com.bun.miitmdid.provider.lenovo;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;
import com.zui.opendeviceidlibrary.OpenDeviceId;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LenovoProvider extends BaseProvider {
    private static final String TAG = "SDK call Lenovo: ";
    private Context context;
    private OpenDeviceId openDeviceId = new OpenDeviceId();

    /* renamed from: com.bun.miitmdid.provider.lenovo.LenovoProvider$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C37941 implements OpenDeviceId.CallBack<String> {
        public C37941() {
        }

        @Override // com.zui.opendeviceidlibrary.OpenDeviceId.CallBack
        public void serviceConnected(String str, OpenDeviceId openDeviceId) {
            LenovoProvider.access$002(LenovoProvider.this, openDeviceId.isSupported());
            String oaid = openDeviceId.getOAID();
            String vaid = openDeviceId.getVAID();
            String aaid = openDeviceId.getAAID();
            LenovoProvider lenovoProvider = LenovoProvider.this;
            if (oaid == null) {
                oaid = "";
            }
            LenovoProvider.access$102(lenovoProvider, oaid);
            LenovoProvider lenovoProvider2 = LenovoProvider.this;
            if (vaid == null) {
                vaid = "";
            }
            LenovoProvider.access$202(lenovoProvider2, vaid);
            LenovoProvider lenovoProvider3 = LenovoProvider.this;
            if (aaid == null) {
                aaid = "";
            }
            LenovoProvider.access$302(lenovoProvider3, aaid);
            LenovoProvider.this.returnCallResult();
        }
    }

    public LenovoProvider(Context context) {
        this.context = context;
    }

    public static /* synthetic */ boolean access$002(LenovoProvider lenovoProvider, boolean z) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = 64;
        objArr[4] = 1606976968536L;
        return ((Boolean) Utils.m20485rL(objArr)).booleanValue();
    }

    public static /* synthetic */ String access$102(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 65;
        objArr[4] = 1606976968537L;
        return (String) Utils.m20485rL(objArr);
    }

    public static /* synthetic */ String access$202(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 66;
        objArr[4] = 1606976968538L;
        return (String) Utils.m20485rL(objArr);
    }

    public static /* synthetic */ String access$302(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 67;
        objArr[4] = 1606976968539L;
        return (String) Utils.m20485rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.m20485rL(new Object[]{this, 68, 1606976968540L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.m20485rL(new Object[]{this, 69, 1606976968541L})).booleanValue();
    }
}
