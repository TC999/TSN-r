package com.bxkj.student.p094v2.common.utils;

import android.content.Context;
import com.tencent.p562mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.p562mm.opensdk.openapi.IWXAPI;
import com.tencent.p562mm.opensdk.openapi.WXAPIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/s;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class WechatUtils {
    @NotNull

    /* renamed from: a */
    public static final C5553a f20152a = new C5553a(null);
    @NotNull

    /* renamed from: b */
    public static final String f20153b = "wxc9214f296e1fba92";

    /* compiled from: WechatUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/s$a;", "", "Landroid/content/Context;", "mContext", "", "userName", "path", "Lkotlin/f1;", "a", "APP_ID", "Ljava/lang/String;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.s$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5553a {
        private C5553a() {
        }

        public /* synthetic */ C5553a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final void m39050a(@NotNull Context mContext, @NotNull String userName, @Nullable String str) {
            C14342f0.m8184p(mContext, "mContext");
            C14342f0.m8184p(userName, "userName");
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(mContext, WechatUtils.f20153b);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = userName;
            req.path = str;
            req.miniprogramType = 0;
            createWXAPI.sendReq(req);
        }
    }
}
