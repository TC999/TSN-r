package com.bxkj.base.v2.netty4android.client.command;

import com.bxkj.base.util.z;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: CommandData.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/command/b;", "", "a", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f18734a = a.f18747a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte f18735b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final byte f18736c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static final byte f18737d = 6;

    /* renamed from: e  reason: collision with root package name */
    public static final byte f18738e = 7;

    /* renamed from: f  reason: collision with root package name */
    public static final byte f18739f = 8;

    /* renamed from: g  reason: collision with root package name */
    public static final byte f18740g = 16;

    /* renamed from: h  reason: collision with root package name */
    public static final byte f18741h = 18;

    /* renamed from: i  reason: collision with root package name */
    public static final byte f18742i = 20;

    /* renamed from: j  reason: collision with root package name */
    public static final byte f18743j = 21;

    /* renamed from: k  reason: collision with root package name */
    public static final byte f18744k = 22;

    /* renamed from: l  reason: collision with root package name */
    public static final byte f18745l = 24;

    /* renamed from: m  reason: collision with root package name */
    public static final byte f18746m = 25;

    /* compiled from: CommandData.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b&\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001f\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0013R\u0014\u0010#\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0014\u0010%\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0013R\u0014\u0010'\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0013R\u0014\u0010)\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0013R\u0014\u0010+\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0013R\u0014\u0010-\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0013R\u0014\u0010/\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0013R\u0014\u00101\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0013R\u0014\u00103\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0013R\u0014\u00105\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010\u0013\u00a8\u00068"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/command/b$a;", "", "Lcom/bxkj/base/v2/netty4android/client/command/a;", "b", "", "userName", "basUserId", "secret", "appVersion", "schoolCode", "a", "", "Z", "c", "()Z", "d", "(Z)V", "AUTH_SUCCESS", "", "B", "AUTH_REQUEST", "AUTH_RESPONSE", "e", "HEART_REQUEST", "f", "HEART_RESPONSE", "g", "REBOOT_DEVICE", "h", "REFRESH_DEVICE", "i", "FACE_READY_START", "j", "NOTICE_REQUEST", "k", "NOTICE", "l", "FACE_REQUEST", "m", "FACE_RESPONSE", "n", "SAVE_FACE_SUCCESS", "o", "UPDATE_VERSION", "p", "OPEN_GATE", CampaignEx.JSON_KEY_AD_Q, "NEED_DELETE_FACE", "r", "FACE_DELETE_REQUEST", "s", "FACE_DELETE_RESPONSE", "t", "FACE_DELETE_CONFIRM", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f18747a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static boolean f18748b = false;

        /* renamed from: c  reason: collision with root package name */
        private static final byte f18749c = 1;

        /* renamed from: d  reason: collision with root package name */
        public static final byte f18750d = 2;

        /* renamed from: e  reason: collision with root package name */
        private static final byte f18751e = 33;

        /* renamed from: f  reason: collision with root package name */
        public static final byte f18752f = 4;

        /* renamed from: g  reason: collision with root package name */
        public static final byte f18753g = 6;

        /* renamed from: h  reason: collision with root package name */
        public static final byte f18754h = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final byte f18755i = 8;

        /* renamed from: j  reason: collision with root package name */
        private static final byte f18756j = 9;

        /* renamed from: k  reason: collision with root package name */
        public static final byte f18757k = 16;

        /* renamed from: l  reason: collision with root package name */
        private static final byte f18758l = 17;

        /* renamed from: m  reason: collision with root package name */
        public static final byte f18759m = 18;

        /* renamed from: n  reason: collision with root package name */
        private static final byte f18760n = 19;

        /* renamed from: o  reason: collision with root package name */
        public static final byte f18761o = 20;

        /* renamed from: p  reason: collision with root package name */
        public static final byte f18762p = 21;

        /* renamed from: q  reason: collision with root package name */
        public static final byte f18763q = 22;

        /* renamed from: r  reason: collision with root package name */
        private static final byte f18764r = 23;

        /* renamed from: s  reason: collision with root package name */
        public static final byte f18765s = 24;

        /* renamed from: t  reason: collision with root package name */
        public static final byte f18766t = 25;

        private a() {
        }

        @NotNull
        public final com.bxkj.base.v2.netty4android.client.command.a a(@NotNull String userName, @NotNull String basUserId, @NotNull String secret, @NotNull String appVersion, @NotNull String schoolCode) {
            f0.p(userName, "userName");
            f0.p(basUserId, "basUserId");
            f0.p(secret, "secret");
            f0.p(appVersion, "appVersion");
            f0.p(schoolCode, "schoolCode");
            String jSONObject = new JSONObject().put("userName", userName).put("basUserId", basUserId).put("secret", secret).put("type", z.f()).put("appVersion", appVersion).put("schoolCode", schoolCode).toString();
            f0.o(jSONObject, "JSONObject()\n           \u2026              .toString()");
            return new com.bxkj.base.v2.netty4android.client.command.a((byte) 1, jSONObject.length(), jSONObject);
        }

        @NotNull
        public final com.bxkj.base.v2.netty4android.client.command.a b() {
            return new com.bxkj.base.v2.netty4android.client.command.a((byte) 33, 0, "");
        }

        public final boolean c() {
            return f18748b;
        }

        public final void d(boolean z3) {
            f18748b = z3;
        }
    }
}
