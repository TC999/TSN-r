package cn.jpush.android.data;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends JPushConfig {

    /* renamed from: a  reason: collision with root package name */
    private String f4174a;

    /* renamed from: b  reason: collision with root package name */
    private String f4175b;

    /* renamed from: c  reason: collision with root package name */
    private String f4176c;

    /* renamed from: d  reason: collision with root package name */
    private String f4177d;

    public a() {
    }

    public a(JPushConfig jPushConfig) {
        setjAppKey(jPushConfig.getjAppKey());
        setMzAppId(jPushConfig.getMzAppId());
        setMzAppKey(jPushConfig.getMzAppKey());
        setOppoAppId(jPushConfig.getOppoAppId());
        setOppoAppKey(jPushConfig.getOppoAppKey());
        setOppoAppSecret(jPushConfig.getOppoAppSecret());
        setXmAppId(jPushConfig.getXmAppId());
        setXmAppKey(jPushConfig.getXmAppKey());
    }

    public String a() {
        return this.f4174a;
    }

    public void a(String str) {
        this.f4174a = str;
    }

    public String b() {
        return this.f4175b;
    }

    public void b(String str) {
        this.f4175b = str;
    }

    public String c() {
        return this.f4176c;
    }

    public void c(String str) {
        this.f4176c = str;
    }

    public String d() {
        return this.f4177d;
    }

    public void d(String str) {
        this.f4177d = str;
    }
}
