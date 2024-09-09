package com.bxkj.student.v2.ui.my;

import android.content.Intent;
import android.widget.Toast;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.databinding.V2AboutUsBinding;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.vm.my.AboutUsVM;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AboutUsActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/v2/ui/my/AboutUsActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AboutUsBinding;", "Lcom/bxkj/student/v2/vm/my/AboutUsVM;", "Lkotlin/f1;", "E", "p", "S", "Q", "O", "P", "N", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class AboutUsActivity extends BaseActivity<V2AboutUsBinding, AboutUsVM> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AboutUsActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/bxkj/student/v2/ui/my/AboutUsActivity$a", "Lcom/bxkj/student/common/versionupdate/a$d;", "", "hasNewVersion", "", "versionName", "downLoadUrl", "instruction", "Lkotlin/f1;", "a", "b", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f23923a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AboutUsActivity f23924b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AboutUsActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.my.AboutUsActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        static final class C0312a extends Lambda implements l<Map<String, Object>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AboutUsActivity f23925a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.bxkj.student.common.versionupdate.a f23926b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0312a(AboutUsActivity aboutUsActivity, com.bxkj.student.common.versionupdate.a aVar) {
                super(1);
                this.f23925a = aboutUsActivity;
                this.f23926b = aVar;
            }

            public final void a(@NotNull Map<String, Object> it) {
                f0.p(it, "it");
                com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                int k4 = lVar.k(it, "buildVersionNo");
                String t3 = lVar.t(it, "buildVersion");
                String t4 = lVar.t(it, "buildUpdateDescription");
                String t5 = lVar.t(it, "downloadURL");
                if (k4 > TsnSecret.f16433a.getVersionCode(this.f23925a.C())) {
                    this.f23926b.d(t3, t5, t4);
                } else {
                    ContextExtKt.m(this.f23925a, "\u5f53\u524d\u5df2\u662f\u6700\u65b0\u7248\u672c");
                }
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(Map<String, Object> map) {
                a(map);
                return f1.f55527a;
            }
        }

        a(com.bxkj.student.common.versionupdate.a aVar, AboutUsActivity aboutUsActivity) {
            this.f23923a = aVar;
            this.f23924b = aboutUsActivity;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean z3, @NotNull String versionName, @NotNull String downLoadUrl, @NotNull String instruction) {
            f0.p(versionName, "versionName");
            f0.p(downLoadUrl, "downLoadUrl");
            f0.p(instruction, "instruction");
            if (z3) {
                this.f23923a.d(versionName, downLoadUrl, instruction);
            } else {
                this.f23924b.x().v(new C0312a(this.f23924b, this.f23923a));
            }
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final AboutUsActivity this$0, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        f0.p(this$0, "this$0");
        UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
        uMWeb.setTitle("\u6821\u56ed\u751f\u6d3b\u5982\u6b64\u7b80\u5355");
        uMWeb.setThumb(new UMImage(this$0.C(), "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
        uMWeb.setDescription(this$0.getString(2131821569));
        new ShareAction(this$0.w()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.my.AboutUsActivity$share$1$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(@NotNull SHARE_MEDIA platform) {
                f0.p(platform, "platform");
                Toast.makeText(AboutUsActivity.this.C(), " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t3) {
                f0.p(platform, "platform");
                f0.p(t3, "t");
                t3.printStackTrace();
                Toast.makeText(AboutUsActivity.this.C(), " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(@NotNull SHARE_MEDIA platform) {
                f0.p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(@NotNull SHARE_MEDIA share_media2) {
                f0.p(share_media2, "share_media");
            }
        }).withMedia(uMWeb).share();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        if ((getIntent().hasExtra("title") ? this : null) != null) {
            M().setTitle(getIntent().getStringExtra("title"));
        }
        M().setBackEvent(this);
        M().setActivity(this);
    }

    public final void N() {
        startActivity(new Intent(C(), AdSwitchActivity.class));
    }

    public final void O() {
        startActivity(new Intent(C(), H5AppActivity.class).putExtra("title", "\u7528\u6237\u534f\u8bae").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
    }

    public final void P() {
        startActivity(new Intent(C(), H5AppActivity.class).putExtra("title", "\u9690\u79c1\u653f\u7b56").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
    }

    public final void Q() {
        new ShareAction(w()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.v2.ui.my.a
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                AboutUsActivity.R(AboutUsActivity.this, snsPlatform, share_media);
            }
        }).open();
    }

    public final void S() {
        com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(C());
        aVar.b(new a(aVar, this));
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
