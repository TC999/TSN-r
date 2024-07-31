package com.bxkj.student.p094v2.common.utils;

import android.app.Activity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.orhanobut.logger.C11792j;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: ThirdLogin.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002J&\u0010\b\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0011"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/ThirdLogin;", "", "Lkotlin/Function1;", "", "", "Lkotlin/f1;", "bind", "b", "c", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", "mActivity", "<init>", "(Landroid/app/Activity;)V", "MyUMAuthListener", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.ThirdLogin */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ThirdLogin {
    @NotNull

    /* renamed from: a */
    private final Activity f20087a;

    /* compiled from: ThirdLogin.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0011\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R/\u0010\u0011\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/ThirdLogin$MyUMAuthListener;", "Lcom/umeng/socialize/UMAuthListener;", "Lcom/umeng/socialize/bean/SHARE_MEDIA;", Constants.PARAM_PLATFORM, "Lkotlin/f1;", "onStart", "", CcgConstant.f38549t, "", "", "data", "onComplete", "", UMCommonContent.f37782aL, "onError", "onCancel", "Lkotlin/Function1;", "bind", "Ll1/l;", "a", "()Ll1/l;", "<init>", "(Lcom/bxkj/student/v2/common/utils/ThirdLogin;Ll1/l;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.ThirdLogin$MyUMAuthListener */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public final class MyUMAuthListener implements UMAuthListener {
        @NotNull

        /* renamed from: a */
        private final InterfaceC15280l<Map<String, String>, Unit> f20088a;

        /* renamed from: b */
        final /* synthetic */ ThirdLogin f20089b;

        /* JADX WARN: Multi-variable type inference failed */
        public MyUMAuthListener(@NotNull ThirdLogin this$0, InterfaceC15280l<? super Map<String, String>, Unit> bind) {
            C14342f0.m8184p(this$0, "this$0");
            C14342f0.m8184p(bind, "bind");
            this.f20089b = this$0;
            this.f20088a = bind;
        }

        @NotNull
        /* renamed from: a */
        public final InterfaceC15280l<Map<String, String>, Unit> m39151a() {
            return this.f20088a;
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(@NotNull SHARE_MEDIA platform, int i) {
            C14342f0.m8184p(platform, "platform");
            ContextExt.m43848p(this.f20089b.m39154a(), "您取消了绑定");
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(@NotNull SHARE_MEDIA platform, int i, @NotNull Map<String, String> data) {
            C14342f0.m8184p(platform, "platform");
            C14342f0.m8184p(data, "data");
            C11792j.m20469d(C14342f0.m8216C("platform=", platform.name()), new Object[0]);
            C11792j.m20469d(C14342f0.m8216C("data=", data), new Object[0]);
            this.f20088a.invoke(data);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(@NotNull SHARE_MEDIA platform, int i, @NotNull Throwable t) {
            C14342f0.m8184p(platform, "platform");
            C14342f0.m8184p(t, "t");
            C11792j.m20470c(t.getMessage());
            C11792j.m20469d(C14342f0.m8216C("action=", Integer.valueOf(i)), new Object[0]);
            ContextExt.m43848p(this.f20089b.m39154a(), "绑定失败,请稍后再试");
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(@NotNull SHARE_MEDIA platform) {
            C14342f0.m8184p(platform, "platform");
        }
    }

    public ThirdLogin(@NotNull Activity mActivity) {
        C14342f0.m8184p(mActivity, "mActivity");
        this.f20087a = mActivity;
        UMShareConfig uMShareConfig = new UMShareConfig();
        uMShareConfig.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(mActivity).setShareConfig(uMShareConfig);
    }

    @NotNull
    /* renamed from: a */
    public final Activity m39154a() {
        return this.f20087a;
    }

    /* renamed from: b */
    public final void m39153b(@NotNull InterfaceC15280l<? super Map<String, String>, Unit> bind) {
        C14342f0.m8184p(bind, "bind");
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f20087a);
        Activity activity = this.f20087a;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(activity, share_media)) {
            ContextExt.m43848p(this.f20087a, "您还未安装QQ或QQ版本过低");
        } else {
            UMShareAPI.get(this.f20087a).getPlatformInfo(this.f20087a, share_media, new MyUMAuthListener(this, bind));
        }
    }

    /* renamed from: c */
    public final void m39152c(@NotNull InterfaceC15280l<? super Map<String, String>, Unit> bind) {
        C14342f0.m8184p(bind, "bind");
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f20087a);
        Activity activity = this.f20087a;
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(activity, share_media)) {
            ContextExt.m43848p(this.f20087a, "您还未安装微信或微信版本过低");
        } else {
            UMShareAPI.get(this.f20087a).getPlatformInfo(this.f20087a, share_media, new MyUMAuthListener(this, bind));
        }
    }
}
