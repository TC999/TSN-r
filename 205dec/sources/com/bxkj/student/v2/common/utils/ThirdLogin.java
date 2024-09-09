package com.bxkj.student.v2.common.utils;

import android.app.Activity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ThirdLogin.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002J&\u0010\b\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/bxkj/student/v2/common/utils/ThirdLogin;", "", "Lkotlin/Function1;", "", "", "Lkotlin/f1;", "bind", "b", "c", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", "mActivity", "<init>", "(Landroid/app/Activity;)V", "MyUMAuthListener", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ThirdLogin {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f23331a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: ThirdLogin.kt */
    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0011\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R/\u0010\u0011\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/bxkj/student/v2/common/utils/ThirdLogin$MyUMAuthListener;", "Lcom/umeng/socialize/UMAuthListener;", "Lcom/umeng/socialize/bean/SHARE_MEDIA;", "platform", "Lkotlin/f1;", "onStart", "", "action", "", "", "data", "onComplete", "", "t", "onError", "onCancel", "Lkotlin/Function1;", "bind", "Ld2/l;", "a", "()Ld2/l;", "<init>", "(Lcom/bxkj/student/v2/common/utils/ThirdLogin;Ld2/l;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class MyUMAuthListener implements UMAuthListener {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final d2.l<Map<String, String>, f1> f23332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ThirdLogin f23333b;

        /* JADX WARN: Multi-variable type inference failed */
        public MyUMAuthListener(@NotNull ThirdLogin this$0, d2.l<? super Map<String, String>, f1> bind) {
            f0.p(this$0, "this$0");
            f0.p(bind, "bind");
            this.f23333b = this$0;
            this.f23332a = bind;
        }

        @NotNull
        public final d2.l<Map<String, String>, f1> a() {
            return this.f23332a;
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(@NotNull SHARE_MEDIA platform, int i4) {
            f0.p(platform, "platform");
            ContextExtKt.p(this.f23333b.a(), "\u60a8\u53d6\u6d88\u4e86\u7ed1\u5b9a");
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(@NotNull SHARE_MEDIA platform, int i4, @NotNull Map<String, String> data) {
            f0.p(platform, "platform");
            f0.p(data, "data");
            com.orhanobut.logger.j.d(f0.C("platform=", platform.name()), new Object[0]);
            com.orhanobut.logger.j.d(f0.C("data=", data), new Object[0]);
            this.f23332a.invoke(data);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(@NotNull SHARE_MEDIA platform, int i4, @NotNull Throwable t3) {
            f0.p(platform, "platform");
            f0.p(t3, "t");
            com.orhanobut.logger.j.c(t3.getMessage());
            com.orhanobut.logger.j.d(f0.C("action=", Integer.valueOf(i4)), new Object[0]);
            ContextExtKt.p(this.f23333b.a(), "\u7ed1\u5b9a\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(@NotNull SHARE_MEDIA platform) {
            f0.p(platform, "platform");
        }
    }

    public ThirdLogin(@NotNull Activity mActivity) {
        f0.p(mActivity, "mActivity");
        this.f23331a = mActivity;
        UMShareConfig uMShareConfig = new UMShareConfig();
        uMShareConfig.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(mActivity).setShareConfig(uMShareConfig);
    }

    @NotNull
    public final Activity a() {
        return this.f23331a;
    }

    public final void b(@NotNull d2.l<? super Map<String, String>, f1> bind) {
        f0.p(bind, "bind");
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f23331a);
        Activity activity = this.f23331a;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(activity, share_media)) {
            ContextExtKt.p(this.f23331a, "\u60a8\u8fd8\u672a\u5b89\u88c5QQ\u6216QQ\u7248\u672c\u8fc7\u4f4e");
        } else {
            UMShareAPI.get(this.f23331a).getPlatformInfo(this.f23331a, share_media, new MyUMAuthListener(this, bind));
        }
    }

    public final void c(@NotNull d2.l<? super Map<String, String>, f1> bind) {
        f0.p(bind, "bind");
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f23331a);
        Activity activity = this.f23331a;
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(activity, share_media)) {
            ContextExtKt.p(this.f23331a, "\u60a8\u8fd8\u672a\u5b89\u88c5\u5fae\u4fe1\u6216\u5fae\u4fe1\u7248\u672c\u8fc7\u4f4e");
        } else {
            UMShareAPI.get(this.f23331a).getPlatformInfo(this.f23331a, share_media, new MyUMAuthListener(this, bind));
        }
    }
}
