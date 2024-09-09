package com.bxkj.base.v2.data;

import android.content.Intent;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.utils.r;
import cn.bluemobi.dylan.http.JsonParse;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.netty4android.service.NettySocketService;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.p;
import kotlin.q;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: LoggedInUser.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\bV\n\u0002\u0010%\n\u0002\b\u000e\u0018\u0000 [2\u00020\u0001:\u0001\u0003B\u000b\b\u0002\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R*\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b\u000b\u0010%R\"\u0010*\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\"\u0010.\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$\"\u0004\b-\u0010%R$\u00101\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010$\"\u0004\b0\u0010%R$\u00104\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u0010$\"\u0004\b3\u0010%R$\u00107\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b5\u0010$\"\u0004\b6\u0010%R$\u0010:\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u0010$\"\u0004\b9\u0010%R$\u0010<\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b;\u0010\u001eR$\u0010>\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u001c\"\u0004\b=\u0010\u001eR$\u0010A\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR$\u0010D\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR$\u0010F\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010$\"\u0004\bE\u0010%R$\u0010I\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bG\u0010$\"\u0004\bH\u0010%R$\u0010K\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010$\"\u0004\bJ\u0010%R$\u0010N\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010\u001c\"\u0004\bM\u0010\u001eR$\u0010Q\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR$\u0010T\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bR\u0010$\"\u0004\bS\u0010%R$\u0010W\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bU\u0010$\"\u0004\bV\u0010%R$\u0010Z\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bX\u0010$\"\u0004\bY\u0010%R$\u0010]\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b[\u0010$\"\u0004\b\\\u0010%R$\u0010`\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b^\u0010$\"\u0004\b_\u0010%R$\u0010c\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\ba\u0010$\"\u0004\bb\u0010%R$\u0010f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR$\u0010i\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bg\u0010\u001c\"\u0004\bh\u0010\u001eR$\u0010k\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u001c\"\u0004\bj\u0010\u001eR$\u0010n\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bl\u0010\u001c\"\u0004\bm\u0010\u001eR$\u0010q\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bo\u0010\u001c\"\u0004\bp\u0010\u001eR$\u0010s\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\r\"\u0004\br\u0010\u000fR$\u0010v\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bt\u0010\r\"\u0004\bu\u0010\u000fR@\u0010|\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u00010w2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u00010w8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R$\u0010\u007f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b}\u0010\r\"\u0004\b~\u0010\u000fR'\u0010\u0082\u0001\u001a\u00020 2\u0006\u0010\n\u001a\u00020 8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010$\"\u0005\b\u0081\u0001\u0010%\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/bxkj/base/v2/data/a;", "", "Lkotlin/f1;", "b", "c", "Lcn/bluemobi/dylan/base/utils/r;", "a", "Lcn/bluemobi/dylan/base/utils/r;", "sp", "", "value", "Z", "K", "()Z", "j0", "(Z)V", "isRefreshTokenFinish", "", "J", "m", "()J", "V", "(J)V", "lastHeartCallBackTime", "", "d", "I", "z", "()I", "n0", "(I)V", "serverOpen", "", "e", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "nettySocketIp", "f", CampaignEx.JSON_KEY_AD_Q, "a0", "nettySocketPort", "g", "r", "b0", "nettySocketSecret", "y", "m0", "schoolUrl", "k", "T", "h5Url", "x", "l0", "schoolName", "w", "k0", "schoolCode", "f0", "isOpenLive", "g0", "isOpenSQZS", "H", "e0", "isOpenGGLBT", "L", "q0", "isUserJPush", "O", "appId", "C", "r0", "userNumber", "M", "accessToken", "j", "S", "frequency", "G", "Y", "isLogin", "B", "p0", "userId", "D", "s0", "username", "v", "i0", "refreshToken", "h", "Q", "dept_id", "n", "W", "lastUpdateTime", "o", "X", "lastUploadTime", "E", "t0", "voiceOpen", "F", "u0", "voiceType", "P", "bindType", "s", "c0", "nfcCardType", "u", "h0", "queryStudentType", "N", "adOpen", "i", "R", "floatActionButtonShow", "", "A", "()Ljava/util/Map;", "o0", "(Ljava/util/Map;)V", "sportsSetMap", "t", "d0", "noPrompt", "l", "U", "lastExerciseExplanationDate", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final b f18673h = new b(null);
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final p<a> f18674i = q.c(LazyThreadSafetyMode.SYNCHRONIZED, C0204a.f18682a);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final r f18675a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18676b;

    /* renamed from: c  reason: collision with root package name */
    private long f18677c;

    /* renamed from: d  reason: collision with root package name */
    private int f18678d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private String f18679e;

    /* renamed from: f  reason: collision with root package name */
    private int f18680f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private String f18681g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LoggedInUser.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/base/v2/data/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.data.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class C0204a extends Lambda implements l1.a<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0204a f18682a = new C0204a();

        C0204a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final a invoke() {
            return new a(null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LoggedInUser.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/base/v2/data/a$b;", "", "Lcom/bxkj/base/v2/data/a;", "instance$delegate", "Lkotlin/p;", "a", "()Lcom/bxkj/base/v2/data/a;", "instance", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @NotNull
        public final a a() {
            return (a) a.f18674i.getValue();
        }
    }

    private a() {
        this.f18675a = new r(BaseApp.b());
        this.f18678d = 1;
        this.f18679e = "";
        this.f18681g = "";
    }

    public /* synthetic */ a(u uVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        try {
            BaseApp.b().startService(new Intent(BaseApp.b(), NettySocketService.class).putExtra("action", 1));
        } catch (Exception e4) {
            j.e(f0.C("startService\uff1a", e4.getMessage()), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        try {
            BaseApp.b().startService(new Intent(BaseApp.b(), NettySocketService.class).putExtra("action", 2));
        } catch (Exception e4) {
            j.e(f0.C("startService\uff1a", e4.getMessage()), new Object[0]);
        }
    }

    @NotNull
    public final Map<String, Object> A() {
        Map<String, Object> J0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object b4 = this.f18675a.b("sportsSetMap", "");
        if (b4 != null) {
            String str = (String) b4;
            if (str.length() > 0) {
                ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(str);
                f0.o(jsonToMap, "jsonToMap(s)");
                J0 = z0.J0(jsonToMap);
                return J0;
            }
            return linkedHashMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    public final String B() {
        Object b4 = this.f18675a.b("userId", c.f18693a.a().n());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    public final String C() {
        Object b4 = this.f18675a.b("userNumber", c.f18693a.a().o());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    public final String D() {
        Object b4 = this.f18675a.b("username", c.f18693a.a().p());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final boolean E() {
        Object b4 = this.f18675a.b("voiceOpen", Boolean.valueOf(c.f18693a.a().q()));
        if (b4 != null) {
            return ((Boolean) b4).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final int F() {
        Object b4 = this.f18675a.b("voiceType", Integer.valueOf(c.f18693a.a().r()));
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final boolean G() {
        Object b4 = this.f18675a.b("isLogin", Boolean.valueOf(c.f18693a.a().s()));
        if (b4 != null) {
            return ((Boolean) b4).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final int H() {
        Object b4 = this.f18675a.b("isOpenGGLBT", 1);
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final int I() {
        Object b4 = this.f18675a.b("isOpenLive", 0);
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final int J() {
        Object b4 = this.f18675a.b("isOpenSQZS", 1);
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final boolean K() {
        return this.f18676b;
    }

    public final int L() {
        Object b4 = this.f18675a.b("isJiguangPush", 1);
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void M(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("accessToken", value);
    }

    public final void N(boolean z3) {
        this.f18675a.d("adOpen", Boolean.valueOf(z3));
    }

    public final void O(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("appId", value);
    }

    public final void P(int i4) {
        this.f18675a.d("bindType", Integer.valueOf(i4));
    }

    public final void Q(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("dept_id", value);
    }

    public final void R(boolean z3) {
        this.f18675a.d("floatActionButtonShow", Boolean.valueOf(z3));
    }

    public final void S(int i4) {
        this.f18675a.d("frequency", Integer.valueOf(i4));
    }

    public final void T(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("h5Url", value);
    }

    public final void U(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("lastExerciseExplanationDate", value);
    }

    public final void V(long j4) {
        this.f18677c = j4;
    }

    public final void W(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("lastUpdateTime", value);
    }

    public final void X(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("lastUploadTime", value);
    }

    public final void Y(boolean z3) {
        this.f18675a.d("isLogin", Boolean.valueOf(z3));
        if (G()) {
            b();
        } else {
            c();
        }
        Intent intent = new Intent();
        intent.setAction(f0.C(BaseApp.b().getPackageName(), ".LOGIN_OUT_SERVICE"));
        BaseApp.b().sendBroadcast(intent, f0.C(BaseApp.b().getPackageName(), ".sports.permissions.V3_Sports_BROADCAST"));
    }

    public final void Z(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f18679e = str;
    }

    public final void a0(int i4) {
        this.f18680f = i4;
    }

    public final void b0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f18681g = str;
    }

    public final void c0(int i4) {
        this.f18675a.d("nfcCardType", Integer.valueOf(i4));
    }

    @NotNull
    public final String d() {
        Object b4 = this.f18675a.b("accessToken", c.f18693a.a().b());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void d0(boolean z3) {
        this.f18675a.d("noPrompt", Boolean.valueOf(z3));
    }

    public final boolean e() {
        Object b4 = this.f18675a.b("adOpen", Boolean.TRUE);
        if (b4 != null) {
            return ((Boolean) b4).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final void e0(int i4) {
        this.f18675a.d("isOpenGGLBT", Integer.valueOf(i4));
    }

    @NotNull
    public final String f() {
        Object b4 = this.f18675a.b("appId", c.f18693a.a().c());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void f0(int i4) {
        this.f18675a.d("isOpenLive", Integer.valueOf(i4));
    }

    public final int g() {
        Object b4 = this.f18675a.b("bindType", Integer.valueOf(c.f18693a.a().d()));
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void g0(int i4) {
        this.f18675a.d("isOpenSQZS", Integer.valueOf(i4));
    }

    @NotNull
    public final String h() {
        Object b4 = this.f18675a.b("dept_id", c.f18693a.a().e());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void h0(int i4) {
        this.f18675a.d("queryStudentType", Integer.valueOf(i4));
    }

    public final boolean i() {
        Object b4 = this.f18675a.b("floatActionButtonShow", Boolean.TRUE);
        if (b4 != null) {
            return ((Boolean) b4).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final void i0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("refreshToken", value);
    }

    public final int j() {
        Object b4 = this.f18675a.b("frequency", Integer.valueOf(c.f18693a.a().f()));
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void j0(boolean z3) {
        if (z3) {
            BaseApp.b().startService(new Intent(BaseApp.b(), NettySocketService.class).putExtra("action", 1));
            Intent intent = new Intent();
            intent.setAction(f0.C(BaseApp.b().getPackageName(), ".REFRESH_TOKEN_FINISH"));
            BaseApp.b().sendBroadcast(intent, f0.C(BaseApp.b().getPackageName(), ".sports.permissions.V3_Sports_BROADCAST"));
        }
        this.f18676b = z3;
    }

    @NotNull
    public final String k() {
        boolean u22;
        boolean u23;
        Object b4 = this.f18675a.b("h5Url", f0.C("https://h.tsnkj.com/?school=", w()));
        if (b4 != null) {
            String str = (String) b4;
            u22 = w.u2(str, JPushConstants.HTTP_PRE, false, 2, null);
            if (u22) {
                return str;
            }
            u23 = w.u2(str, JPushConstants.HTTPS_PRE, false, 2, null);
            return !u23 ? f0.C("https://h.tsnkj.com/?school=", w()) : str;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void k0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("schoolCode", value);
    }

    @NotNull
    public final String l() {
        Object b4 = this.f18675a.b("lastExerciseExplanationDate", "");
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void l0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("schoolName", value);
    }

    public final long m() {
        return this.f18677c;
    }

    public final void m0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("schoolUrl", value);
    }

    @NotNull
    public final String n() {
        Object b4 = this.f18675a.b("lastUpdateTime", c.f18693a.a().g());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void n0(int i4) {
        this.f18678d = i4;
    }

    @NotNull
    public final String o() {
        Object b4 = this.f18675a.b("lastUploadTime", c.f18693a.a().h());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void o0(@NotNull Map<String, Object> value) {
        f0.p(value, "value");
        this.f18675a.d("sportsSetMap", JSON.toJSONString(value));
    }

    @NotNull
    public final String p() {
        return this.f18679e;
    }

    public final void p0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("userId", value);
    }

    public final int q() {
        return this.f18680f;
    }

    public final void q0(int i4) {
        this.f18675a.d("isJiguangPush", Integer.valueOf(i4));
    }

    @NotNull
    public final String r() {
        return this.f18681g;
    }

    public final void r0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("userNumber", value);
    }

    public final int s() {
        Object b4 = this.f18675a.b("nfcCardType", Integer.valueOf(c.f18693a.a().i()));
        if (b4 != null) {
            return ((Integer) b4).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void s0(@NotNull String value) {
        f0.p(value, "value");
        this.f18675a.d("username", value);
    }

    public final boolean t() {
        Object b4 = this.f18675a.b("noPrompt", Boolean.FALSE);
        if (b4 != null) {
            return ((Boolean) b4).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final void t0(boolean z3) {
        this.f18675a.d("voiceOpen", Boolean.valueOf(z3));
    }

    public final int u() {
        Object b4 = this.f18675a.b("queryStudentType", Integer.valueOf(c.f18693a.a().j()));
        if (b4 != null) {
            int intValue = ((Integer) b4).intValue();
            if (intValue > 3) {
                return 0;
            }
            return intValue;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void u0(int i4) {
        this.f18675a.d("voiceType", Integer.valueOf(i4));
    }

    @NotNull
    public final String v() {
        Object b4 = this.f18675a.b("refreshToken", c.f18693a.a().k());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    public final String w() {
        Object b4 = this.f18675a.b("schoolCode", c.f18693a.a().l());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @NotNull
    public final String x() {
        Object b4 = this.f18675a.b("schoolName", c.f18693a.a().m());
        if (b4 != null) {
            return (String) b4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r1 == false) goto L7;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String y() {
        /*
            r6 = this;
            cn.bluemobi.dylan.base.utils.r r0 = r6.f18675a
            java.lang.String r1 = "schoolUrl"
            java.lang.String r2 = "http://a.sxstczx.com/"
            java.lang.Object r0 = r0.b(r1, r2)
            if (r0 == 0) goto L30
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "http://"
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r1 = kotlin.text.n.u2(r0, r1, r3, r4, r5)
            if (r1 != 0) goto L22
            java.lang.String r1 = "https://"
            boolean r1 = kotlin.text.n.u2(r0, r1, r3, r4, r5)
            if (r1 != 0) goto L22
            goto L23
        L22:
            r2 = r0
        L23:
            java.lang.String r0 = "/"
            boolean r1 = kotlin.text.n.J1(r2, r0, r3, r4, r5)
            if (r1 != 0) goto L2f
            java.lang.String r2 = kotlin.jvm.internal.f0.C(r2, r0)
        L2f:
            return r2
        L30:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.data.a.y():java.lang.String");
    }

    public final int z() {
        return this.f18678d;
    }
}
