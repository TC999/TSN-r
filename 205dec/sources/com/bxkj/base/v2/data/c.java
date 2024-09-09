package com.bxkj.base.v2.data;

import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.o;
import kotlin.q;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OldLoggedInUser.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b*\u0018\u0000 G2\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\bE\u0010FR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R$\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R$\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R$\u0010,\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R$\u0010/\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R$\u00102\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R$\u00105\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007R$\u00108\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R$\u0010;\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR$\u0010>\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR$\u0010A\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR$\u0010D\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001c\u00a8\u0006H"}, d2 = {"Lcom/bxkj/base/v2/data/c;", "", "", "value", "m", "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "schoolName", "l", "G", "schoolCode", "t", "D", "isOpenLive", "c", "v", "appId", "o", "J", "userNumber", "b", "u", "accessToken", "", "f", "()I", "y", "(I)V", "frequency", "", "s", "()Z", "B", "(Z)V", "isLogin", "n", "I", "userId", "p", "K", "username", "k", "F", "refreshToken", "e", "x", "dept_id", "g", "z", "lastUpdateTime", "h", "A", "lastUploadTime", CampaignEx.JSON_KEY_AD_Q, "L", "voiceOpen", "r", "M", "voiceType", "d", "w", "bindType", "i", "C", "nfcCardType", "j", "E", "queryStudentType", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class c {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f18694b = "user";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f18693a = new b(null);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final o<c> f18695c = q.b(LazyThreadSafetyMode.SYNCHRONIZED, a.f18696a);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OldLoggedInUser.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/base/v2/data/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l1.a<c> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18696a = new a();

        a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final c invoke() {
            return new c(null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OldLoggedInUser.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/base/v2/data/c$b;", "", "Lcom/bxkj/base/v2/data/c;", "instance$delegate", "Lkotlin/o;", "a", "()Lcom/bxkj/base/v2/data/c;", "instance", "", "spName", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @NotNull
        public final c a() {
            return (c) c.f18695c.getValue();
        }
    }

    private c() {
    }

    public /* synthetic */ c(u uVar) {
        this();
    }

    public final void A(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "lastUploadTime", value);
    }

    public final void B(boolean z3) {
        com.bxkj.base.v2.data.spp.a.m(BaseApp.b(), "user", "isLogin", z3);
    }

    public final void C(int i4) {
        com.bxkj.base.v2.data.spp.a.o(BaseApp.b(), "user", "nfcCardType", i4);
    }

    public final void D(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "isOpenLive", value);
    }

    public final void E(int i4) {
        com.bxkj.base.v2.data.spp.a.o(BaseApp.b(), "user", "queryStudentType", i4);
    }

    public final void F(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "refreshToken", value);
    }

    public final void G(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "schoolCode", value);
    }

    public final void H(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "schoolName", value);
    }

    public final void I(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "userId", value);
    }

    public final void J(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "userNumber", value);
    }

    public final void K(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "username", value);
    }

    public final void L(boolean z3) {
        com.bxkj.base.v2.data.spp.a.m(BaseApp.b(), "user", "voiceOpen", z3);
    }

    public final void M(int i4) {
        com.bxkj.base.v2.data.spp.a.o(BaseApp.b(), "user", "voiceType", i4);
    }

    @NotNull
    public final String b() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "accessToken", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026pName, \"accessToken\", \"\")");
        return k4;
    }

    @NotNull
    public final String c() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "appId", "");
        f0.o(k4, "getString(BaseApp.getApp(), spName, \"appId\", \"\")");
        return k4;
    }

    public final int d() {
        return com.bxkj.base.v2.data.spp.a.g(BaseApp.b(), "user", "bindType", 0);
    }

    @NotNull
    public final String e() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "dept_id", String.valueOf(LoginUser.getLoginUser().getUserType()));
        f0.o(k4, "getString(BaseApp.getApp\u2026er().userType.toString())");
        return k4;
    }

    public final int f() {
        return com.bxkj.base.v2.data.spp.a.g(BaseApp.b(), "user", "frequency", 1);
    }

    @NotNull
    public final String g() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "lastUpdateTime", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026me, \"lastUpdateTime\", \"\")");
        return k4;
    }

    @NotNull
    public final String h() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "lastUploadTime", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026me, \"lastUploadTime\", \"\")");
        return k4;
    }

    public final int i() {
        return com.bxkj.base.v2.data.spp.a.g(BaseApp.b(), "user", "nfcCardType", 0);
    }

    public final int j() {
        return com.bxkj.base.v2.data.spp.a.g(BaseApp.b(), "user", "queryStudentType", 0);
    }

    @NotNull
    public final String k() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "refreshToken", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026Name, \"refreshToken\", \"\")");
        return k4;
    }

    @NotNull
    public final String l() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "schoolCode", "a");
        f0.o(k4, "getString(\n            B\u2026choolCode\", \"a\"\n        )");
        return k4;
    }

    @NotNull
    public final String m() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "schoolName", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026spName, \"schoolName\", \"\")");
        return k4;
    }

    @NotNull
    public final String n() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "userId", "");
        f0.o(k4, "getString(BaseApp.getApp(), spName, \"userId\", \"\")");
        return k4;
    }

    @NotNull
    public final String o() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "userNumber", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026spName, \"userNumber\", \"\")");
        return k4;
    }

    @NotNull
    public final String p() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "username", "");
        f0.o(k4, "getString(BaseApp.getApp\u2026, spName, \"username\", \"\")");
        return k4;
    }

    public final boolean q() {
        return com.bxkj.base.v2.data.spp.a.c(BaseApp.b(), "user", "voiceOpen", false);
    }

    public final int r() {
        return com.bxkj.base.v2.data.spp.a.g(BaseApp.b(), "user", "voiceType", 0);
    }

    public final boolean s() {
        return com.bxkj.base.v2.data.spp.a.c(BaseApp.b(), "user", "isLogin", false);
    }

    @NotNull
    public final String t() {
        String k4 = com.bxkj.base.v2.data.spp.a.k(BaseApp.b(), "user", "isOpenLive", "0");
        f0.o(k4, "getString(\n            B\u2026sOpenLive\", \"0\"\n        )");
        return k4;
    }

    public final void u(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "accessToken", value);
    }

    public final void v(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "appId", value);
    }

    public final void w(int i4) {
        com.bxkj.base.v2.data.spp.a.o(BaseApp.b(), "user", "bindType", i4);
    }

    public final void x(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "dept_id", value);
    }

    public final void y(int i4) {
        com.bxkj.base.v2.data.spp.a.o(BaseApp.b(), "user", "frequency", i4);
    }

    public final void z(@NotNull String value) {
        f0.p(value, "value");
        com.bxkj.base.v2.data.spp.a.q(BaseApp.b(), "user", "lastUpdateTime", value);
    }
}
