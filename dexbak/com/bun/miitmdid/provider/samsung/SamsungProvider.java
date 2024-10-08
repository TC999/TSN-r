package com.bun.miitmdid.provider.samsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;
import com.samsung.android.deviceidservice.IDeviceIdService;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SamsungProvider extends BaseProvider {
    private static final String TAG = "SDK call Samsung: ";
    private Context context;
    private ServiceConnection mConnection;
    private IDeviceIdService mDeviceidInterface;
    private String packagename;

    /* renamed from: com.bun.miitmdid.provider.samsung.SamsungProvider$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class ServiceConnectionC37951 implements ServiceConnection {
        public ServiceConnectionC37951() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SamsungProvider.access$002(SamsungProvider.this, IDeviceIdService.Stub.asInterface(iBinder));
            SamsungProvider.access$100(SamsungProvider.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SamsungProvider.access$002(SamsungProvider.this, null);
        }
    }

    public SamsungProvider(Context context) {
        this.context = context;
        this.packagename = context.getPackageName();
    }

    private void ReadData() {
        Utils.m20485rL(new Object[]{this, 86, 1606976968558L});
    }

    public static /* synthetic */ IDeviceIdService access$002(SamsungProvider samsungProvider, IDeviceIdService iDeviceIdService) {
        Object[] objArr = new Object[5];
        objArr[1] = samsungProvider;
        objArr[2] = iDeviceIdService;
        objArr[3] = 87;
        objArr[4] = 1606976968559L;
        return (IDeviceIdService) Utils.m20485rL(objArr);
    }

    public static /* synthetic */ void access$100(SamsungProvider samsungProvider) {
        Object[] objArr = new Object[4];
        objArr[1] = samsungProvider;
        objArr[2] = 88;
        objArr[3] = 1606976968560L;
        Utils.m20485rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.m20485rL(new Object[]{this, 89, 1606976968561L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.m20485rL(new Object[]{this, 90, 1606976968562L})).booleanValue();
    }

    @Override // com.bun.miitmdid.provider.BaseProvider, com.bun.miitmdid.interfaces.InnerIdProvider
    public void shutDown() {
        Utils.m20485rL(new Object[]{this, 91, 1606976968563L});
    }
}
