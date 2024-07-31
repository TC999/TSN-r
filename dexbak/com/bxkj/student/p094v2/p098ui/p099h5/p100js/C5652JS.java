package com.bxkj.student.p094v2.p098ui.p099h5.p100js;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.common.utils.H5Utils;
import com.bxkj.student.p094v2.common.utils.ThirdLogin;
import com.bxkj.student.p094v2.common.utils.WechatUtils;
import com.bxkj.student.p094v2.p098ui.LoginActivity;
import com.bxkj.student.p094v2.p098ui.MainActivity;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.appeal.V3AppealActivity;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.orhanobut.logger.C11792j;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: JS.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u0012\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0007J&\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J:\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0007J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/h5/js/JS;", "Lcom/bxkj/student/v2/ui/h5/js/f;", "Lkotlin/f1;", "selectSchool", "", BidResponsed.KEY_TOKEN, "schoolCode", "username", "startExercise", "title", "url", "goDetails", "loginTimeout", "type", "content", RewardPlus.ICON, "share", "exerciseRecordId", "exerciseFeedBack", ConstantHelper.LOG_FINISH, "openWechat", "openQq", "path", "openApplet", "Landroidx/fragment/app/FragmentActivity;", "i", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "j", "Landroid/webkit/WebView;", "d", "()Landroid/webkit/WebView;", "f", "(Landroid/webkit/WebView;)V", "mWebView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.h5.js.JS */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C5652JS extends FaceJS {
    @NotNull

    /* renamed from: i */
    private FragmentActivity f20448i;
    @NotNull

    /* renamed from: j */
    private WebView f20449j;

    /* compiled from: JS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.JS$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5653a extends Lambda implements InterfaceC15280l<Map<String, ? extends String>, Unit> {
        C5653a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38734a(@NotNull Map<String, String> it) {
            C14342f0.m8184p(it, "it");
            WebView mo38732d = C5652JS.this.mo38732d();
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:bindQq('");
            JsonGet jsonGet = JsonGet.f15134a;
            sb.append(jsonGet.m43760t(it, "uid"));
            sb.append("','");
            sb.append(jsonGet.m43760t(it, "name"));
            sb.append("','");
            sb.append(jsonGet.m43760t(it, "iconurl"));
            sb.append("')");
            mo38732d.loadUrl(sb.toString());
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
            m38734a(map);
            return Unit.f41048a;
        }
    }

    /* compiled from: JS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.JS$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5654b extends Lambda implements InterfaceC15280l<Map<String, ? extends String>, Unit> {
        C5654b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38733a(@NotNull Map<String, String> it) {
            C14342f0.m8184p(it, "it");
            WebView mo38732d = C5652JS.this.mo38732d();
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:bindWechat('");
            JsonGet jsonGet = JsonGet.f15134a;
            sb.append(jsonGet.m43760t(it, "uid"));
            sb.append("','");
            sb.append(jsonGet.m43760t(it, "name"));
            sb.append("','");
            sb.append(jsonGet.m43760t(it, "iconurl"));
            sb.append("')");
            mo38732d.loadUrl(sb.toString());
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
            m38733a(map);
            return Unit.f41048a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5652JS(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mWebView, "mWebView");
        this.f20448i = mActivity;
        this.f20449j = mWebView;
    }

    @Override // com.bxkj.student.p094v2.p098ui.p099h5.p100js.FaceJS, com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS, com.bxkj.base.p085v2.p086h5.GPSJS
    @NotNull
    /* renamed from: c */
    public FragmentActivity mo38718c() {
        return this.f20448i;
    }

    @Override // com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS, com.bxkj.base.p085v2.p086h5.GPSJS
    @NotNull
    /* renamed from: d */
    public WebView mo38732d() {
        return this.f20449j;
    }

    @Override // com.bxkj.student.p094v2.p098ui.p099h5.p100js.FaceJS, com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS, com.bxkj.base.p085v2.p086h5.GPSJS
    /* renamed from: e */
    public void mo38717e(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f20448i = fragmentActivity;
    }

    @JavascriptInterface
    public final void exerciseFeedBack(@Nullable String str, @NotNull String exerciseRecordId) {
        C14342f0.m8184p(exerciseRecordId, "exerciseRecordId");
        mo38718c().startActivity(new Intent(mo38718c(), V3AppealActivity.class).putExtra("exerciseRecordId", exerciseRecordId));
    }

    @Override // com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS, com.bxkj.base.p085v2.p086h5.GPSJS
    /* renamed from: f */
    public void mo38731f(@NotNull WebView webView) {
        C14342f0.m8184p(webView, "<set-?>");
        this.f20449j = webView;
    }

    @JavascriptInterface
    public final void finish() {
        mo38718c().finish();
    }

    @JavascriptInterface
    public final void goDetails(@Nullable String str, @Nullable String str2) {
        H5Utils h5Utils = H5Utils.f20124a;
        FragmentActivity mo38718c = mo38718c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", str);
        linkedHashMap.put("linkUrl", str2);
        Unit unit = Unit.f41048a;
        h5Utils.m39075b(mo38718c, linkedHashMap);
    }

    @JavascriptInterface
    public final void loginTimeout() {
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        c3984b.m43634a().m43678M(false);
        c3984b.m43634a().m43666Y("");
        c3984b.m43634a().m43663a0("");
        c3984b.m43634a().m43688C("");
        c3984b.m43634a().m43671T("");
        c3984b.m43634a().m43676O(false);
        c3984b.m43634a().m43681J("");
        mo38718c().startActivity(new Intent(mo38718c(), LoginActivity.class));
        AppManager.m57776n().m57781i(H5AppActivity.class);
        MainActivity mainActivity = (MainActivity) AppManager.m57776n().getActivity(MainActivity.class);
        if (mainActivity != null) {
            mainActivity.mo43911x().m38164V().postValue(Boolean.TRUE);
        }
        mo38718c().finish();
    }

    @JavascriptInterface
    public final void openApplet(@NotNull String username, @Nullable String str) {
        C14342f0.m8184p(username, "username");
        C11792j.m20469d("username=" + username + " path=" + ((Object) str), new Object[0]);
        WechatUtils.f20152a.m39050a(mo38718c(), username, str);
    }

    @JavascriptInterface
    public final void openQq() {
        new ThirdLogin(mo38718c()).m39153b(new C5653a());
    }

    @JavascriptInterface
    public final void openWechat() {
        new ThirdLogin(mo38718c()).m39152c(new C5654b());
    }

    @JavascriptInterface
    public final void selectSchool() {
        mo38718c().startActivity(new Intent(mo38718c(), SelectSchoolV2Activity.class));
    }

    @JavascriptInterface
    public final void share(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        SHARE_MEDIA share_media;
        UMWeb uMWeb = new UMWeb(str5);
        uMWeb.setTitle(str2);
        uMWeb.setThumb(new UMImage(mo38718c(), str4));
        uMWeb.setDescription(str3);
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1779587763) {
                if (hashCode != 2592) {
                    if (hashCode == 77564797 && str.equals("QZONE")) {
                        share_media = SHARE_MEDIA.QZONE;
                    }
                } else if (str.equals(Constants.SOURCE_QQ)) {
                    share_media = SHARE_MEDIA.QQ;
                }
            } else if (str.equals("WEIXIN_CIRCLE")) {
                share_media = SHARE_MEDIA.WEIXIN_CIRCLE;
            }
            new ShareAction(mo38718c()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.h5.js.JS$share$1
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(@NotNull SHARE_MEDIA platform) {
                    C14342f0.m8184p(platform, "platform");
                    ContextExt.m43846r(C5652JS.this.mo38718c(), "分享取消了");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t) {
                    C14342f0.m8184p(platform, "platform");
                    C14342f0.m8184p(t, "t");
                    t.printStackTrace();
                    ContextExt.m43846r(C5652JS.this.mo38718c(), "分享失败啦");
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
        share_media = SHARE_MEDIA.WEIXIN;
        new ShareAction(mo38718c()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.h5.js.JS$share$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(@NotNull SHARE_MEDIA platform) {
                C14342f0.m8184p(platform, "platform");
                ContextExt.m43846r(C5652JS.this.mo38718c(), "分享取消了");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t) {
                C14342f0.m8184p(platform, "platform");
                C14342f0.m8184p(t, "t");
                t.printStackTrace();
                ContextExt.m43846r(C5652JS.this.mo38718c(), "分享失败啦");
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

    @JavascriptInterface
    public final void startExercise(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        c3984b.m43634a().m43678M(true);
        if (str != null) {
            c3984b.m43634a().m43688C(str);
        }
        if (str2 != null) {
            c3984b.m43634a().m43670U(str2);
        }
        if (str3 != null) {
            c3984b.m43634a().m43665Z(str3);
        }
        RetrofitClient.f20337a.m38889a();
        mo38718c().startActivity(new Intent(mo38718c(), V3SportsHomeActivity.class));
    }
}
