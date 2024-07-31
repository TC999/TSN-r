package com.bxkj.student.p094v2.p098ui.p101my;

import android.content.Intent;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.versionupdate.VersionUpdate;
import com.bxkj.student.databinding.V2AboutUsBinding;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.p094v2.p103vm.p105my.AboutUsVM;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: AboutUsActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/my/AboutUsActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AboutUsBinding;", "Lcom/bxkj/student/v2/vm/my/AboutUsVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", ExifInterface.LATITUDE_SOUTH, "Q", "O", "P", "N", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.my.AboutUsActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AboutUsActivity extends BaseActivity<V2AboutUsBinding, AboutUsVM> {

    /* compiled from: AboutUsActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, m12616d2 = {"com/bxkj/student/v2/ui/my/AboutUsActivity$a", "Lcom/bxkj/student/common/versionupdate/a$d;", "", "hasNewVersion", "", TTDownloadField.TT_VERSION_NAME, "downLoadUrl", "instruction", "Lkotlin/f1;", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.my.AboutUsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5691a implements VersionUpdate.InterfaceC4268d {

        /* renamed from: a */
        final /* synthetic */ VersionUpdate f20527a;

        /* renamed from: b */
        final /* synthetic */ AboutUsActivity f20528b;

        /* compiled from: AboutUsActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, m12616d2 = {"", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.my.AboutUsActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        static final class C5692a extends Lambda implements InterfaceC15280l<Map<String, Object>, Unit> {

            /* renamed from: a */
            final /* synthetic */ AboutUsActivity f20529a;

            /* renamed from: b */
            final /* synthetic */ VersionUpdate f20530b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5692a(AboutUsActivity aboutUsActivity, VersionUpdate versionUpdate) {
                super(1);
                this.f20529a = aboutUsActivity;
                this.f20530b = versionUpdate;
            }

            /* renamed from: a */
            public final void m38644a(@NotNull Map<String, Object> it) {
                C14342f0.m8184p(it, "it");
                JsonGet jsonGet = JsonGet.f15134a;
                int m43769k = jsonGet.m43769k(it, "buildVersionNo");
                String m43760t = jsonGet.m43760t(it, "buildVersion");
                String m43760t2 = jsonGet.m43760t(it, "buildUpdateDescription");
                String m43760t3 = jsonGet.m43760t(it, "downloadURL");
                if (m43769k > TsnSecret.f13210a.getVersionCode(this.f20529a.mo43926C())) {
                    this.f20530b.m42763d(m43760t, m43760t3, m43760t2);
                } else {
                    ContextExt.m43851m(this.f20529a, "当前已是最新版本");
                }
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                m38644a(map);
                return Unit.f41048a;
            }
        }

        C5691a(VersionUpdate versionUpdate, AboutUsActivity aboutUsActivity) {
            this.f20527a = versionUpdate;
            this.f20528b = aboutUsActivity;
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: a */
        public void mo38646a(boolean z, @NotNull String versionName, @NotNull String downLoadUrl, @NotNull String instruction) {
            C14342f0.m8184p(versionName, "versionName");
            C14342f0.m8184p(downLoadUrl, "downLoadUrl");
            C14342f0.m8184p(instruction, "instruction");
            if (z) {
                this.f20527a.m42763d(versionName, downLoadUrl, instruction);
            } else {
                this.f20528b.mo43911x().m38101v(new C5692a(this.f20528b, this.f20527a));
            }
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: b */
        public void mo38645b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public static final void m38649R(final AboutUsActivity this$0, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        C14342f0.m8184p(this$0, "this$0");
        UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
        uMWeb.setTitle("校园生活如此简单");
        uMWeb.setThumb(new UMImage(this$0.mo43926C(), "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
        uMWeb.setDescription(this$0.getString(C4215R.C4224string.welcome_user_app));
        new ShareAction(this$0.mo43912w()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.my.AboutUsActivity$share$1$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(@NotNull SHARE_MEDIA platform) {
                C14342f0.m8184p(platform, "platform");
                Toast.makeText(AboutUsActivity.this.mo43926C(), " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t) {
                C14342f0.m8184p(platform, "platform");
                C14342f0.m8184p(t, "t");
                t.printStackTrace();
                Toast.makeText(AboutUsActivity.this.mo43926C(), " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(@NotNull SHARE_MEDIA platform) {
                C14342f0.m8184p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(@NotNull SHARE_MEDIA share_media2) {
                C14342f0.m8184p(share_media2, "share_media");
            }
        }).withMedia(uMWeb).share();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        if ((getIntent().hasExtra("title") ? this : null) != null) {
            mo43920M().setTitle(getIntent().getStringExtra("title"));
        }
        mo43920M().setBackEvent(this);
        mo43920M().setActivity(this);
    }

    /* renamed from: N */
    public final void m38653N() {
        startActivity(new Intent(mo43926C(), AdSwitchActivity.class));
    }

    /* renamed from: O */
    public final void m38652O() {
        startActivity(new Intent(mo43926C(), H5AppActivity.class).putExtra("title", "用户协议").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
    }

    /* renamed from: P */
    public final void m38651P() {
        startActivity(new Intent(mo43926C(), H5AppActivity.class).putExtra("title", "隐私政策").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
    }

    /* renamed from: Q */
    public final void m38650Q() {
        new ShareAction(mo43912w()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.v2.ui.my.a
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                AboutUsActivity.m38649R(AboutUsActivity.this, snsPlatform, share_media);
            }
        }).open();
    }

    /* renamed from: S */
    public final void m38648S() {
        VersionUpdate versionUpdate = new VersionUpdate(mo43926C());
        versionUpdate.m42765b(new C5691a(versionUpdate, this));
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
