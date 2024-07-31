package com.bxkj.base.p085v2.data;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.data.spp.PreferencesProviderUtils;
import com.bxkj.base.user.LoginUser;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.C14387q;
import kotlin.InterfaceC14378o;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b*\u0018\u0000 G2\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\bE\u0010FR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R$\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R$\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R$\u0010,\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R$\u0010/\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R$\u00102\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R$\u00105\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007R$\u00108\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R$\u0010;\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR$\u0010>\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR$\u0010A\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR$\u0010D\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001c¨\u0006H"}, m12616d2 = {"Lcom/bxkj/base/v2/data/c;", "", "", DomainCampaignEx.LOOPBACK_VALUE, "m", "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "schoolName", C7304t.f25048d, "G", "schoolCode", UMCommonContent.f37782aL, "D", "isOpenLive", "c", "v", "appId", "o", "J", "userNumber", "b", "u", "accessToken", "", "f", "()I", "y", "(I)V", "frequency", "", "s", "()Z", "B", "(Z)V", "isLogin", "n", "I", "userId", "p", "K", "username", "k", "F", "refreshToken", "e", "x", "dept_id", "g", UMCommonContent.f37777aG, "lastUpdateTime", "h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "lastUploadTime", CampaignEx.JSON_KEY_AD_Q, "L", "voiceOpen", "r", "M", "voiceType", "d", IAdInterListener.AdReqParam.WIDTH, "bindType", "i", "C", "nfcCardType", "j", ExifInterface.LONGITUDE_EAST, "queryStudentType", "<init>", "()V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.data.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class OldLoggedInUser {
    @NotNull

    /* renamed from: b */
    private static final String f15197b = "user";
    @NotNull

    /* renamed from: a */
    public static final C3987b f15196a = new C3987b(null);
    @NotNull

    /* renamed from: c */
    private static final InterfaceC14378o<OldLoggedInUser> f15198c = C14387q.m7727b(LazyThreadSafetyMode.SYNCHRONIZED, C3986a.f15199a);

    /* compiled from: OldLoggedInUser.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/base/v2/data/c;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.data.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C3986a extends Lambda implements InterfaceC15269a<OldLoggedInUser> {

        /* renamed from: a */
        public static final C3986a f15199a = new C3986a();

        C3986a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final OldLoggedInUser invoke() {
            return new OldLoggedInUser(null);
        }
    }

    /* compiled from: OldLoggedInUser.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/base/v2/data/c$b;", "", "Lcom/bxkj/base/v2/data/c;", "instance$delegate", "Lkotlin/o;", "a", "()Lcom/bxkj/base/v2/data/c;", "instance", "", "spName", "Ljava/lang/String;", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.data.c$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3987b {
        private C3987b() {
        }

        public /* synthetic */ C3987b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final OldLoggedInUser m43592a() {
            return (OldLoggedInUser) OldLoggedInUser.f15198c.getValue();
        }
    }

    private OldLoggedInUser() {
    }

    public /* synthetic */ OldLoggedInUser(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: A */
    public final void m43632A(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "lastUploadTime", value);
    }

    /* renamed from: B */
    public final void m43631B(boolean z) {
        PreferencesProviderUtils.m43571m(BaseApp.m44341b(), "user", "isLogin", z);
    }

    /* renamed from: C */
    public final void m43630C(int i) {
        PreferencesProviderUtils.m43569o(BaseApp.m44341b(), "user", "nfcCardType", i);
    }

    /* renamed from: D */
    public final void m43629D(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "isOpenLive", value);
    }

    /* renamed from: E */
    public final void m43628E(int i) {
        PreferencesProviderUtils.m43569o(BaseApp.m44341b(), "user", "queryStudentType", i);
    }

    /* renamed from: F */
    public final void m43627F(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "refreshToken", value);
    }

    /* renamed from: G */
    public final void m43626G(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "schoolCode", value);
    }

    /* renamed from: H */
    public final void m43625H(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "schoolName", value);
    }

    /* renamed from: I */
    public final void m43624I(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "userId", value);
    }

    /* renamed from: J */
    public final void m43623J(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "userNumber", value);
    }

    /* renamed from: K */
    public final void m43622K(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "username", value);
    }

    /* renamed from: L */
    public final void m43621L(boolean z) {
        PreferencesProviderUtils.m43571m(BaseApp.m44341b(), "user", "voiceOpen", z);
    }

    /* renamed from: M */
    public final void m43620M(int i) {
        PreferencesProviderUtils.m43569o(BaseApp.m44341b(), "user", "voiceType", i);
    }

    @NotNull
    /* renamed from: b */
    public final String m43618b() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "accessToken", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…pName, \"accessToken\", \"\")");
        return m43573k;
    }

    @NotNull
    /* renamed from: c */
    public final String m43617c() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "appId", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp(), spName, \"appId\", \"\")");
        return m43573k;
    }

    /* renamed from: d */
    public final int m43616d() {
        return PreferencesProviderUtils.m43577g(BaseApp.m44341b(), "user", "bindType", 0);
    }

    @NotNull
    /* renamed from: e */
    public final String m43615e() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "dept_id", String.valueOf(LoginUser.getLoginUser().getUserType()));
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…er().userType.toString())");
        return m43573k;
    }

    /* renamed from: f */
    public final int m43614f() {
        return PreferencesProviderUtils.m43577g(BaseApp.m44341b(), "user", "frequency", 1);
    }

    @NotNull
    /* renamed from: g */
    public final String m43613g() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "lastUpdateTime", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…me, \"lastUpdateTime\", \"\")");
        return m43573k;
    }

    @NotNull
    /* renamed from: h */
    public final String m43612h() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "lastUploadTime", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…me, \"lastUploadTime\", \"\")");
        return m43573k;
    }

    /* renamed from: i */
    public final int m43611i() {
        return PreferencesProviderUtils.m43577g(BaseApp.m44341b(), "user", "nfcCardType", 0);
    }

    /* renamed from: j */
    public final int m43610j() {
        return PreferencesProviderUtils.m43577g(BaseApp.m44341b(), "user", "queryStudentType", 0);
    }

    @NotNull
    /* renamed from: k */
    public final String m43609k() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "refreshToken", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…Name, \"refreshToken\", \"\")");
        return m43573k;
    }

    @NotNull
    /* renamed from: l */
    public final String m43608l() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "schoolCode", "a");
        C14342f0.m8185o(m43573k, "getString(\n            B…choolCode\", \"a\"\n        )");
        return m43573k;
    }

    @NotNull
    /* renamed from: m */
    public final String m43607m() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "schoolName", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…spName, \"schoolName\", \"\")");
        return m43573k;
    }

    @NotNull
    /* renamed from: n */
    public final String m43606n() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "userId", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp(), spName, \"userId\", \"\")");
        return m43573k;
    }

    @NotNull
    /* renamed from: o */
    public final String m43605o() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "userNumber", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…spName, \"userNumber\", \"\")");
        return m43573k;
    }

    @NotNull
    /* renamed from: p */
    public final String m43604p() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "username", "");
        C14342f0.m8185o(m43573k, "getString(BaseApp.getApp…, spName, \"username\", \"\")");
        return m43573k;
    }

    /* renamed from: q */
    public final boolean m43603q() {
        return PreferencesProviderUtils.m43581c(BaseApp.m44341b(), "user", "voiceOpen", false);
    }

    /* renamed from: r */
    public final int m43602r() {
        return PreferencesProviderUtils.m43577g(BaseApp.m44341b(), "user", "voiceType", 0);
    }

    /* renamed from: s */
    public final boolean m43601s() {
        return PreferencesProviderUtils.m43581c(BaseApp.m44341b(), "user", "isLogin", false);
    }

    @NotNull
    /* renamed from: t */
    public final String m43600t() {
        String m43573k = PreferencesProviderUtils.m43573k(BaseApp.m44341b(), "user", "isOpenLive", "0");
        C14342f0.m8185o(m43573k, "getString(\n            B…sOpenLive\", \"0\"\n        )");
        return m43573k;
    }

    /* renamed from: u */
    public final void m43599u(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "accessToken", value);
    }

    /* renamed from: v */
    public final void m43598v(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "appId", value);
    }

    /* renamed from: w */
    public final void m43597w(int i) {
        PreferencesProviderUtils.m43569o(BaseApp.m44341b(), "user", "bindType", i);
    }

    /* renamed from: x */
    public final void m43596x(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "dept_id", value);
    }

    /* renamed from: y */
    public final void m43595y(int i) {
        PreferencesProviderUtils.m43569o(BaseApp.m44341b(), "user", "frequency", i);
    }

    /* renamed from: z */
    public final void m43594z(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        PreferencesProviderUtils.m43567q(BaseApp.m44341b(), "user", "lastUpdateTime", value);
    }
}
