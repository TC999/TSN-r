package xyz.adscope.amps.common;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSEnum {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum AMPSSDKInitStatus {
        AMPSAdSDKInitStatusNormal(0, "sdk Init status normal"),
        AMPSAdSDKInitStatusLoading(1, "sdk Init status loading"),
        AMPSAdSDKInitStatusSuccess(2, "sdk Init status success"),
        AMPSAdSDKInitStatusFail(3, "sdk Init status fail"),
        AMPSAdSDKInitStatusFailRepeat(4, "sdk Init status fail repeat");
        
        private int code;
        private String msg;

        AMPSSDKInitStatus(int i4, String str) {
            this.code = i4;
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum AdapterNameEnum {
        ASNP_ADAPTER_NAME("AMPSASNPSDKManagerAdapter"),
        GDT_ADAPTER_NAME("AMPSGDTSDKManagerAdapter"),
        CSJ_ADAPTER_NAME("AMPSCSJSDKManagerAdapter"),
        GroMore_ADAPTER_NAME("AMPSGROMORESDKManagerAdapter"),
        KS_ADAPTER_NAME("AMPSKSSDKManagerAdapter"),
        ALL_ADAPTER_NAME("AMPSALLSDKManagerAdapter");
        
        private String value;

        AdapterNameEnum(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum AutoPlayEnum {
        HAS_NET_AUTO_PLAY(1),
        NO_AUTO_PLAY(0),
        WIFI_AUTO_PLAY(2);
        
        private int autoPlayStatus;

        AutoPlayEnum(int i4) {
            this.autoPlayStatus = i4;
        }

        public int getAutoPlayValue() {
            return this.autoPlayStatus;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ChannelInitStatus {
        INIT_STATUS_SUCCESS(true),
        INIT_STATUS_FAIL(false);
        
        private boolean value;

        ChannelInitStatus(boolean z3) {
            this.value = z3;
        }

        public boolean getValue() {
            return this.value;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ChannelSdkName {
        CHANNEL_SDK_KS("KS"),
        CHANNEL_SDK_CSJ(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ),
        CHANNEL_SDK_GM(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GM),
        CHANNEL_SDK_GDT(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT),
        CHANNEL_SDK_YJ4(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_ASNP),
        CHANNEL_SDK_YJ5(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_BZ);
        
        private String sdkType;

        ChannelSdkName(String str) {
            this.sdkType = str;
        }

        public String getSdkType() {
            return this.sdkType;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum OrientationEnum {
        ORIENTATION_PORTRAIT("2"),
        ORIENTATION_LANDSCAPE("1"),
        ORIENTATION_COMMON("3");
        
        private String orientation;

        OrientationEnum(String str) {
            this.orientation = str;
        }

        public String getOrientation() {
            return this.orientation;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum SupportPersonalizedEnum {
        SUPPORT_PERSONAL_RECOMMEND("1"),
        NO_SUPPORT_PERSONAL_RECOMMEND("0");
        
        private String value;

        SupportPersonalizedEnum(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum VideoSoundEnum {
        SUPPORT_VIDEO_SOUND(1),
        NO_SUPPORT_VIDEO_SOUND(0);
        
        private int hasSound;

        VideoSoundEnum(int i4) {
            this.hasSound = i4;
        }

        public int getHasSound() {
            return this.hasSound;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ZoomOutEnum {
        SUPPORT_ZOOM_OUT("1"),
        NO_SUPPORT_ZOOM_OUT("0");
        
        private String zoomOutValue;

        ZoomOutEnum(String str) {
            this.zoomOutValue = str;
        }

        public String getZoomOutValue() {
            return this.zoomOutValue;
        }
    }
}
