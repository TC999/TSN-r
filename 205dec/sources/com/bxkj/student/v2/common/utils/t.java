package com.bxkj.student.v2.common.utils;

import android.content.Context;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WechatUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/utils/t;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23404a = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f23405b = "wxc9214f296e1fba92";

    /* compiled from: WechatUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/v2/common/utils/t$a;", "", "Landroid/content/Context;", "mContext", "", "userName", "path", "Lkotlin/f1;", "a", "APP_ID", "Ljava/lang/String;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final void a(@NotNull Context mContext, @NotNull String userName, @Nullable String str) {
            f0.p(mContext, "mContext");
            f0.p(userName, "userName");
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(mContext, "wxc9214f296e1fba92");
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = userName;
            req.path = str;
            req.miniprogramType = 0;
            createWXAPI.sendReq(req);
        }
    }
}
