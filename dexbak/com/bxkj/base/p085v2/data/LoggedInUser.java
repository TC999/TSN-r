package com.bxkj.base.p085v2.data;

import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.SharedPreferencesUtils;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.BaseApp;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.C14239y0;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010%\n\u0002\b\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\bd\u0010eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010!\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR$\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR$\u0010'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR$\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR$\u0010-\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR$\u00103\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00106\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR$\u00109\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR$\u0010<\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR$\u0010?\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR$\u0010B\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR$\u0010E\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR$\u0010H\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00100\"\u0004\bG\u00102R$\u0010K\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010\u001aR$\u0010N\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0018\"\u0004\bM\u0010\u001aR$\u0010Q\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010\u001aR$\u0010T\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010\u001aR$\u0010W\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u00100\"\u0004\bV\u00102R@\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010X2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010X8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010`\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u00100\"\u0004\b_\u00102R$\u0010c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\t\"\u0004\bb\u0010\u000b¨\u0006f"}, m12616d2 = {"Lcom/bxkj/base/v2/data/a;", "", "Lcn/bluemobi/dylan/base/utils/r;", "a", "Lcn/bluemobi/dylan/base/utils/r;", "sp", "", DomainCampaignEx.LOOPBACK_VALUE, "r", "()Ljava/lang/String;", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;)V", "schoolUrl", "h", "I", "h5Url", CampaignEx.JSON_KEY_AD_Q, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "schoolName", "p", "U", "schoolCode", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "Q", "(I)V", "isOpenLive", "B", "R", "isOpenSQZS", UMCommonContent.f37777aG, "P", "isOpenGGLBT", "d", ExifInterface.LONGITUDE_EAST, "appId", "u", "Z", "userNumber", "b", "C", "accessToken", "g", "H", "frequency", "", "y", "()Z", "M", "(Z)V", "isLogin", UMCommonContent.f37782aL, "Y", "userId", "v", "a0", "username", "o", ExifInterface.GPS_DIRECTION_TRUE, "refreshToken", "f", "G", "dept_id", "j", "K", "lastUpdateTime", "k", "L", "lastUploadTime", IAdInterListener.AdReqParam.WIDTH, "b0", "voiceOpen", "x", "c0", "voiceType", "e", "F", "bindType", C7304t.f25048d, "N", "nfcCardType", "n", ExifInterface.LATITUDE_SOUTH, "queryStudentType", "c", "D", "adOpen", "", "s", "()Ljava/util/Map;", "X", "(Ljava/util/Map;)V", "sportsSetMap", "m", "O", "noPrompt", "i", "J", "lastExerciseExplanationDate", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.data.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class LoggedInUser {
    @NotNull

    /* renamed from: b */
    public static final C3984b f15182b = new C3984b(null);
    @NotNull

    /* renamed from: c */
    private static final InterfaceC14378o<LoggedInUser> f15183c;
    @NotNull

    /* renamed from: a */
    private final SharedPreferencesUtils f15184a;

    /* compiled from: LoggedInUser.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/base/v2/data/a;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.data.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C3983a extends Lambda implements InterfaceC15269a<LoggedInUser> {

        /* renamed from: a */
        public static final C3983a f15185a = new C3983a();

        C3983a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final LoggedInUser invoke() {
            return new LoggedInUser(null);
        }
    }

    /* compiled from: LoggedInUser.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/base/v2/data/a$b;", "", "Lcom/bxkj/base/v2/data/a;", "instance$delegate", "Lkotlin/o;", "a", "()Lcom/bxkj/base/v2/data/a;", "instance", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.data.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3984b {
        private C3984b() {
        }

        public /* synthetic */ C3984b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final LoggedInUser m43634a() {
            return (LoggedInUser) LoggedInUser.f15183c.getValue();
        }
    }

    static {
        InterfaceC14378o<LoggedInUser> m7720b;
        m7720b = C14389r.m7720b(LazyThreadSafetyMode.SYNCHRONIZED, C3983a.f15185a);
        f15183c = m7720b;
    }

    private LoggedInUser() {
        this.f15184a = new SharedPreferencesUtils(BaseApp.m44341b());
    }

    public /* synthetic */ LoggedInUser(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: A */
    public final int m43690A() {
        Object m57697b = this.f15184a.m57697b("isOpenLive", 0);
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: B */
    public final int m43689B() {
        Object m57697b = this.f15184a.m57697b("isOpenSQZS", 1);
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: C */
    public final void m43688C(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("accessToken", value);
    }

    /* renamed from: D */
    public final void m43687D(boolean z) {
        this.f15184a.m57695d("adOpen", Boolean.valueOf(z));
    }

    /* renamed from: E */
    public final void m43686E(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("appId", value);
    }

    /* renamed from: F */
    public final void m43685F(int i) {
        this.f15184a.m57695d("bindType", Integer.valueOf(i));
    }

    /* renamed from: G */
    public final void m43684G(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("dept_id", value);
    }

    /* renamed from: H */
    public final void m43683H(int i) {
        this.f15184a.m57695d("frequency", Integer.valueOf(i));
    }

    /* renamed from: I */
    public final void m43682I(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("h5Url", value);
    }

    /* renamed from: J */
    public final void m43681J(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("lastExerciseExplanationDate", value);
    }

    /* renamed from: K */
    public final void m43680K(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("lastUpdateTime", value);
    }

    /* renamed from: L */
    public final void m43679L(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("lastUploadTime", value);
    }

    /* renamed from: M */
    public final void m43678M(boolean z) {
        this.f15184a.m57695d("isLogin", Boolean.valueOf(z));
    }

    /* renamed from: N */
    public final void m43677N(int i) {
        this.f15184a.m57695d("nfcCardType", Integer.valueOf(i));
    }

    /* renamed from: O */
    public final void m43676O(boolean z) {
        this.f15184a.m57695d("noPrompt", Boolean.valueOf(z));
    }

    /* renamed from: P */
    public final void m43675P(int i) {
        this.f15184a.m57695d("isOpenGGLBT", Integer.valueOf(i));
    }

    /* renamed from: Q */
    public final void m43674Q(int i) {
        this.f15184a.m57695d("isOpenLive", Integer.valueOf(i));
    }

    /* renamed from: R */
    public final void m43673R(int i) {
        this.f15184a.m57695d("isOpenSQZS", Integer.valueOf(i));
    }

    /* renamed from: S */
    public final void m43672S(int i) {
        this.f15184a.m57695d("queryStudentType", Integer.valueOf(i));
    }

    /* renamed from: T */
    public final void m43671T(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("refreshToken", value);
    }

    /* renamed from: U */
    public final void m43670U(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("schoolCode", value);
    }

    /* renamed from: V */
    public final void m43669V(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("schoolName", value);
    }

    /* renamed from: W */
    public final void m43668W(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("schoolUrl", value);
    }

    /* renamed from: X */
    public final void m43667X(@NotNull Map<String, Object> value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("sportsSetMap", JSON.toJSONString(value));
    }

    /* renamed from: Y */
    public final void m43666Y(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("userId", value);
    }

    /* renamed from: Z */
    public final void m43665Z(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("userNumber", value);
    }

    /* renamed from: a0 */
    public final void m43663a0(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f15184a.m57695d("username", value);
    }

    @NotNull
    /* renamed from: b */
    public final String m43662b() {
        Object m57697b = this.f15184a.m57697b("accessToken", OldLoggedInUser.f15196a.m43592a().m43618b());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: b0 */
    public final void m43661b0(boolean z) {
        this.f15184a.m57695d("voiceOpen", Boolean.valueOf(z));
    }

    /* renamed from: c */
    public final boolean m43660c() {
        Object m57697b = this.f15184a.m57697b("adOpen", Boolean.TRUE);
        if (m57697b != null) {
            return ((Boolean) m57697b).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    /* renamed from: c0 */
    public final void m43659c0(int i) {
        this.f15184a.m57695d("voiceType", Integer.valueOf(i));
    }

    @NotNull
    /* renamed from: d */
    public final String m43658d() {
        Object m57697b = this.f15184a.m57697b("appId", OldLoggedInUser.f15196a.m43592a().m43617c());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: e */
    public final int m43657e() {
        Object m57697b = this.f15184a.m57697b("bindType", Integer.valueOf(OldLoggedInUser.f15196a.m43592a().m43616d()));
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @NotNull
    /* renamed from: f */
    public final String m43656f() {
        Object m57697b = this.f15184a.m57697b("dept_id", OldLoggedInUser.f15196a.m43592a().m43615e());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: g */
    public final int m43655g() {
        Object m57697b = this.f15184a.m57697b("frequency", Integer.valueOf(OldLoggedInUser.f15196a.m43592a().m43614f()));
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @NotNull
    /* renamed from: h */
    public final String m43654h() {
        boolean m6548u2;
        boolean m6548u22;
        Object m57697b = this.f15184a.m57697b("h5Url", C14342f0.m8216C("https://h.tsnkj.com/?school=", m43646p()));
        if (m57697b != null) {
            String str = (String) m57697b;
            m6548u2 = StringsJVM.m6548u2(str, "http://", false, 2, null);
            if (m6548u2) {
                return str;
            }
            m6548u22 = StringsJVM.m6548u2(str, "https://", false, 2, null);
            return !m6548u22 ? C14342f0.m8216C("https://h.tsnkj.com/?school=", m43646p()) : str;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: i */
    public final String m43653i() {
        Object m57697b = this.f15184a.m57697b("lastExerciseExplanationDate", "");
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: j */
    public final String m43652j() {
        Object m57697b = this.f15184a.m57697b("lastUpdateTime", OldLoggedInUser.f15196a.m43592a().m43613g());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: k */
    public final String m43651k() {
        Object m57697b = this.f15184a.m57697b("lastUploadTime", OldLoggedInUser.f15196a.m43592a().m43612h());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: l */
    public final int m43650l() {
        Object m57697b = this.f15184a.m57697b("nfcCardType", Integer.valueOf(OldLoggedInUser.f15196a.m43592a().m43611i()));
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: m */
    public final boolean m43649m() {
        Object m57697b = this.f15184a.m57697b("noPrompt", Boolean.FALSE);
        if (m57697b != null) {
            return ((Boolean) m57697b).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    /* renamed from: n */
    public final int m43648n() {
        Object m57697b = this.f15184a.m57697b("queryStudentType", Integer.valueOf(OldLoggedInUser.f15196a.m43592a().m43610j()));
        if (m57697b != null) {
            int intValue = ((Integer) m57697b).intValue();
            if (intValue > 3) {
                return 0;
            }
            return intValue;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @NotNull
    /* renamed from: o */
    public final String m43647o() {
        Object m57697b = this.f15184a.m57697b("refreshToken", OldLoggedInUser.f15196a.m43592a().m43609k());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: p */
    public final String m43646p() {
        Object m57697b = this.f15184a.m57697b("schoolCode", OldLoggedInUser.f15196a.m43592a().m43608l());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: q */
    public final String m43645q() {
        Object m57697b = this.f15184a.m57697b("schoolName", OldLoggedInUser.f15196a.m43592a().m43607m());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r1 == false) goto L7;
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m43644r() {
        /*
            r6 = this;
            cn.bluemobi.dylan.base.utils.r r0 = r6.f15184a
            java.lang.String r1 = "schoolUrl"
            java.lang.String r2 = "http://a.sxstczx.com/"
            java.lang.Object r0 = r0.m57697b(r1, r2)
            if (r0 == 0) goto L30
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "http://"
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r1 = kotlin.text.C14573n.m6739u2(r0, r1, r3, r4, r5)
            if (r1 != 0) goto L22
            java.lang.String r1 = "https://"
            boolean r1 = kotlin.text.C14573n.m6739u2(r0, r1, r3, r4, r5)
            if (r1 != 0) goto L22
            goto L23
        L22:
            r2 = r0
        L23:
            java.lang.String r0 = "/"
            boolean r1 = kotlin.text.C14573n.m6776J1(r2, r0, r3, r4, r5)
            if (r1 != 0) goto L2f
            java.lang.String r2 = kotlin.jvm.internal.C14342f0.m8216C(r2, r0)
        L2f:
            return r2
        L30:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.p085v2.data.LoggedInUser.m43644r():java.lang.String");
    }

    @NotNull
    /* renamed from: s */
    public final Map<String, Object> m43643s() {
        Map<String, Object> m8915J0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object m57697b = this.f15184a.m57697b("sportsSetMap", "");
        if (m57697b != null) {
            String str = (String) m57697b;
            if (str.length() > 0) {
                ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(str);
                C14342f0.m8185o(jsonToMap, "jsonToMap(s)");
                m8915J0 = C14239y0.m8915J0(jsonToMap);
                return m8915J0;
            }
            return linkedHashMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: t */
    public final String m43642t() {
        Object m57697b = this.f15184a.m57697b("userId", OldLoggedInUser.f15196a.m43592a().m43606n());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: u */
    public final String m43641u() {
        Object m57697b = this.f15184a.m57697b("userNumber", OldLoggedInUser.f15196a.m43592a().m43605o());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    /* renamed from: v */
    public final String m43640v() {
        Object m57697b = this.f15184a.m57697b("username", OldLoggedInUser.f15196a.m43592a().m43604p());
        if (m57697b != null) {
            return (String) m57697b;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: w */
    public final boolean m43639w() {
        Object m57697b = this.f15184a.m57697b("voiceOpen", Boolean.valueOf(OldLoggedInUser.f15196a.m43592a().m43603q()));
        if (m57697b != null) {
            return ((Boolean) m57697b).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    /* renamed from: x */
    public final int m43638x() {
        Object m57697b = this.f15184a.m57697b("voiceType", Integer.valueOf(OldLoggedInUser.f15196a.m43592a().m43602r()));
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: y */
    public final boolean m43637y() {
        Object m57697b = this.f15184a.m57697b("isLogin", Boolean.valueOf(OldLoggedInUser.f15196a.m43592a().m43601s()));
        if (m57697b != null) {
            return ((Boolean) m57697b).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    /* renamed from: z */
    public final int m43636z() {
        Object m57697b = this.f15184a.m57697b("isOpenGGLBT", 1);
        if (m57697b != null) {
            return ((Integer) m57697b).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
