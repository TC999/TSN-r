package cn.jpush.android.cache;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Key<T> {

    /* renamed from: a  reason: collision with root package name */
    String f4104a;

    /* renamed from: b  reason: collision with root package name */
    String f4105b;

    /* renamed from: c  reason: collision with root package name */
    T f4106c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4107d;

    /* renamed from: e  reason: collision with root package name */
    boolean f4108e;

    private Key(String str, String str2, T t3) {
        this.f4104a = str;
        this.f4105b = str2;
        if (t3 == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f4106c = t3;
    }

    public static Key<Boolean> AllowRunningProcess() {
        return new Key("cn.jpush.config", "AllowRunningProcess", Boolean.FALSE).a();
    }

    public static Key<Integer> BadgeCurNum() {
        return new Key("cn.jpush.config", "badgeCurNum", 0).a();
    }

    public static Key<Long> BlackPagesInternalTime() {
        return new Key("cn.jpush.config", "BInternalTime", 21600L).a();
    }

    public static Key<Long> BlackPagesLastReqTime() {
        return new Key("cn.jpush.config", "BLastReqTime", 0L).a();
    }

    public static Key<String> FCM_ClearFlag() {
        return new Key("cn.jpush.config", "fcm_clear_flag", "").a();
    }

    public static Key<Boolean> IgnoreLocalAllowRPConfig() {
        return new Key("cn.jpush.config", "IgnoreLocalAllowRPConfig", Boolean.FALSE).a();
    }

    public static Key<Integer> IsNotificationEnabledLastTime() {
        return new Key("cn.jpush.config", "isNotificationEnabledLastTime", -1).a();
    }

    public static Key<String> JAppKey(String str) {
        return new Key("cn.jpush.config", str + "j_key", "").b();
    }

    public static Key<String> LastAniConfigPath() {
        return new Key("cn.jpush.config", "LastAniConfigPath", "").a();
    }

    public static Key<Long> LastAniConfigReqTime() {
        return new Key("cn.jpush.config", "LastAniConfigReqTime", 0L).a();
    }

    public static Key<Long> LastReportApiStatisticTime() {
        return new Key("cn.jpush.config", "LastReportApiStatisticTime", 0L).a();
    }

    public static Key<String> LocalAniConfigSign() {
        return new Key("cn.jpush.config", "LocalAniConfigSign", "").a();
    }

    public static Key<Integer> LocalAniConfigVersion() {
        return new Key("cn.jpush.config", "LocalAniConfigVersion", 0).a();
    }

    public static Key<String> MAppId(String str) {
        return new Key("cn.jpush.config", str + "m_id", "").b();
    }

    public static Key<String> MAppKey(String str) {
        return new Key("cn.jpush.config", str + "m_key", "").b();
    }

    public static Key<String> MAppSecret(String str) {
        return new Key("cn.jpush.config", str + "m_scrt", "").b();
    }

    public static Key<String> NotiCancel() {
        return new Key("cn.jpush.config", "NotiCancel", "").a();
    }

    public static Key<String> NotiSchedule() {
        return new Key("cn.jpush.config", "NotiSchedule", "").a();
    }

    public static Key<String> NotiShow() {
        return new Key("cn.jpush.config", "NotiShow", "").a();
    }

    public static Key<Long> PushStatusSyncTime() {
        return new Key("cn.jpush.config", "PushStatusSyncTime", 0L).a();
    }

    public static Key<Integer> PushVerCode() {
        return new Key("cn.jpush.config", "versionCode", 0).a();
    }

    public static Key<String> SvrAniConfigSign() {
        return new Key("cn.jpush.config", "SvrAniConfigSign", "").a();
    }

    public static Key<String> ThirdPush_ClearFlag() {
        return new Key("cn.jpush.config", "third_push_clear_flag", "").a();
    }

    public static Key<String> ThirdPush_RegID(byte b4) {
        return new Key("cn.jpush.config", "pluginPlatformRegid_v2" + ((int) b4), "").a();
    }

    public static Key<Boolean> ThirdPush_RegUpload(byte b4) {
        return new Key("cn.jpush.config", "pluginPlatformRegidupload" + ((int) b4), Boolean.FALSE).a();
    }

    public static Key<Boolean> UPSRegister() {
        return new Key<>("cn.jpush.config", "upsRegister", Boolean.TRUE);
    }

    private Key<T> a() {
        this.f4107d = true;
        return this;
    }

    private Key<T> b() {
        this.f4108e = true;
        return this;
    }

    public static Key<Boolean> isEnableUA() {
        return new Key("cn.jpush.config", "IsEnableUA", Boolean.TRUE).a();
    }

    public static Key<Integer> registerType() {
        return new Key("cn.jpush.config", "r_type", 0).a();
    }

    public Key<T> file(String str) {
        this.f4104a = str;
        return this;
    }

    public Key<T> name(String str) {
        this.f4105b = str;
        return this;
    }

    public Key<T> set(T t3) {
        this.f4106c = t3;
        return this;
    }
}
