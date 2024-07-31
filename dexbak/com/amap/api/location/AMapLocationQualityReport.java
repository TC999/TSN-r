package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.tencent.connect.common.Constants;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;

    /* renamed from: b */
    private boolean f6945b = false;

    /* renamed from: c */
    private int f6946c = 2;

    /* renamed from: d */
    private int f6947d = 0;

    /* renamed from: e */
    private String f6948e = Constants.APP_VERSION_UNKNOWN;

    /* renamed from: f */
    private long f6949f = 0;

    /* renamed from: g */
    private boolean f6950g = false;

    /* renamed from: a */
    AMapLocationClientOption.AMapLocationMode f6944a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    public String getAdviseMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.f6944a;
        if (aMapLocationMode != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
            int i = this.f6946c;
            if (i != 0) {
                if (i == 1) {
                    stringBuffer.append("您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n");
                } else if (i == 2) {
                    stringBuffer.append("您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n");
                } else if (i == 3) {
                    stringBuffer.append("您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n");
                } else if (i == 4) {
                    stringBuffer.append("您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n");
                }
            } else if (aMapLocationMode == AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.f6947d < 4) {
                stringBuffer.append("当前GPS信号弱，位置更新可能会延迟\n");
            }
        }
        if (this.f6944a != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            if ("DISCONNECTED".equals(this.f6948e)) {
                stringBuffer.append("您的设备未连接到网络，无法进行网络定位\n");
            } else if ("2G".equals(this.f6948e)) {
                stringBuffer.append("您的设备网络状态不太好，网络定位可能会有延迟\n");
            }
            if (!this.f6945b) {
                stringBuffer.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
            }
        }
        return stringBuffer.toString();
    }

    public int getGPSSatellites() {
        return this.f6947d;
    }

    public int getGPSStatus() {
        return this.f6946c;
    }

    public long getNetUseTime() {
        return this.f6949f;
    }

    public String getNetworkType() {
        return this.f6948e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.f6950g;
    }

    public boolean isWifiAble() {
        return this.f6945b;
    }

    public void setGPSSatellites(int i) {
        this.f6947d = i;
    }

    public void setGpsStatus(int i) {
        this.f6946c = i;
    }

    public void setInstallHighDangerMockApp(boolean z) {
        this.f6950g = z;
    }

    public void setLocationMode(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f6944a = aMapLocationMode;
    }

    public void setNetUseTime(long j) {
        this.f6949f = j;
    }

    public void setNetworkType(String str) {
        this.f6948e = str;
    }

    public void setWifiAble(boolean z) {
        this.f6945b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public AMapLocationQualityReport m60096clone() {
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        try {
            aMapLocationQualityReport.setGpsStatus(this.f6946c);
            aMapLocationQualityReport.setGPSSatellites(this.f6947d);
            aMapLocationQualityReport.setWifiAble(this.f6945b);
            aMapLocationQualityReport.setNetUseTime(this.f6949f);
            aMapLocationQualityReport.setNetworkType(this.f6948e);
            aMapLocationQualityReport.setLocationMode(this.f6944a);
            aMapLocationQualityReport.setInstallHighDangerMockApp(this.f6950g);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapLocationQualityReport", "clone");
        }
        return aMapLocationQualityReport;
    }
}
