package xyz.adscope.common.info.deviceinfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DeviceInfoSystemMark {
    static {
        try {
            System.loadLibrary("commondevInfo");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public native String getDeviceBootMark();

    public native String getDeviceUpdateMark();
}
