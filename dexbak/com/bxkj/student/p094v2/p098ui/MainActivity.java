package com.bxkj.student.p094v2.p098ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.data.ParcelableMap;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.NotificationsUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.versionupdate.VersionUpdate;
import com.bxkj.student.databinding.V2MainBinding;
import com.bxkj.student.p094v2.common.utils.BottomNavigationViewHelper;
import com.bxkj.student.p094v2.p098ui.dialog.NoticeDialog;
import com.bxkj.student.p094v2.p098ui.main.ClassifyFragment;
import com.bxkj.student.p094v2.p098ui.main.DiscoveryFragment;
import com.bxkj.student.p094v2.p098ui.main.HomeFragment;
import com.bxkj.student.p094v2.p098ui.main.MsgFragment;
import com.bxkj.student.p094v2.p098ui.main.MyFragment;
import com.bxkj.student.p094v2.p103vm.MainViewModel;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.C14239y0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p635q.MainApiService;

/* compiled from: MainActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0011H\u0014R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R*\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010706058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010;R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010;\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/MainActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2MainBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "", "index", "Lkotlin/f1;", "U", "Landroidx/fragment/app/Fragment;", Constants.FROM, "to", "", "tag", "c0", "N", "R", "P", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", ExifInterface.LONGITUDE_EAST, "Landroid/content/Intent;", "intent", "onNewIntent", "p", "onResume", ExifInterface.LATITUDE_SOUTH, "onBackPressed", "outState", "onSaveInstanceState", "Lcom/bxkj/student/v2/ui/main/HomeFragment;", "i", "Lcom/bxkj/student/v2/ui/main/HomeFragment;", "homeFragment", "Lcom/bxkj/student/v2/ui/main/ClassifyFragment;", "j", "Lcom/bxkj/student/v2/ui/main/ClassifyFragment;", "classifyFragment", "Lcom/bxkj/student/v2/ui/main/DiscoveryFragment;", "k", "Lcom/bxkj/student/v2/ui/main/DiscoveryFragment;", "discoveryFragment", "Lcom/bxkj/student/v2/ui/main/MsgFragment;", C7304t.f25048d, "Lcom/bxkj/student/v2/ui/main/MsgFragment;", "msgFragment", "Lcom/bxkj/student/v2/ui/main/MyFragment;", "m", "Lcom/bxkj/student/v2/ui/main/MyFragment;", "myFragment", "n", "Landroidx/fragment/app/Fragment;", "isFragment", "", "", "", "o", "Ljava/util/List;", "navigationMenuList", "I", "selectedItemId", CampaignEx.JSON_KEY_AD_Q, "Q", "()I", "b0", "(I)V", "lastSelectIndex", "", "r", "Z", "checkUpdateSuccess", "", "s", "J", RtspHeaders.Values.TIME, "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.MainActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MainActivity extends BaseActivity<V2MainBinding, MainViewModel> {
    @Nullable

    /* renamed from: i */
    private HomeFragment f20349i;
    @Nullable

    /* renamed from: j */
    private ClassifyFragment f20350j;
    @Nullable

    /* renamed from: k */
    private DiscoveryFragment f20351k;
    @Nullable

    /* renamed from: l */
    private MsgFragment f20352l;
    @Nullable

    /* renamed from: m */
    private MyFragment f20353m;
    @Nullable

    /* renamed from: n */
    private Fragment f20354n;
    @NotNull

    /* renamed from: o */
    private List<Map<String, Object>> f20355o = new ArrayList();

    /* renamed from: p */
    private int f20356p;

    /* renamed from: q */
    private int f20357q;

    /* renamed from: r */
    private boolean f20358r;

    /* renamed from: s */
    private long f20359s;

    /* compiled from: MainActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, m12616d2 = {"com/bxkj/student/v2/ui/MainActivity$a", "Lcom/bxkj/student/common/versionupdate/a$d;", "", "hasNewVersion", "", TTDownloadField.TT_VERSION_NAME, "downLoadUrl", "instruction", "Lkotlin/f1;", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.MainActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5599a implements VersionUpdate.InterfaceC4268d {

        /* renamed from: b */
        final /* synthetic */ VersionUpdate f20361b;

        C5599a(VersionUpdate versionUpdate) {
            this.f20361b = versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: a */
        public void mo38646a(boolean z, @NotNull String versionName, @NotNull String downLoadUrl, @NotNull String instruction) {
            C14342f0.m8184p(versionName, "versionName");
            C14342f0.m8184p(downLoadUrl, "downLoadUrl");
            C14342f0.m8184p(instruction, "instruction");
            MainActivity.this.f20358r = true;
            if (z) {
                this.f20361b.m42763d(versionName, downLoadUrl, instruction);
            }
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: b */
        public void mo38645b() {
            MainActivity.this.f20358r = false;
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/MainActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.MainActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5600b extends HttpCallBack {
        C5600b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            try {
                JsonGet jsonGet = JsonGet.f15134a;
                String m43760t = jsonGet.m43760t(data, "schName");
                LoginUser.getLoginUser().setSysType(jsonGet.m43769k(data, "sysType"));
                LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
                c3984b.m43634a().m43674Q(jsonGet.m43769k(data, "isOpenLive"));
                c3984b.m43634a().m43673R(jsonGet.m43768l(data, "isOpenSQZS", 1));
                c3984b.m43634a().m43675P(jsonGet.m43768l(data, "isOpenGGLBT", 1));
                c3984b.m43634a().m43669V(m43760t);
                c3984b.m43634a().m43670U(jsonGet.m43760t(data, "schoolCode"));
                c3984b.m43634a().m43668W(jsonGet.m43759u(data, "lan_url", "http://a.sxstczx.com/"));
                RetrofitClient.f20337a.m38889a();
                c3984b.m43634a().m43682I(jsonGet.m43760t(data, "urlSite"));
                if (LoginUser.getLoginUser().getSysType() == 1) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this.mo43926C(), com.bxkj.student.MainActivity.class));
                    MainActivity.this.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        StubApp.interface11(12450);
    }

    /* renamed from: N */
    private final void m38875N() {
        if (Build.VERSION.SDK_INT < 19 || NotificationsUtils.m44051a(mo43926C())) {
            return;
        }
        new iOSTwoButtonDialog(mo43926C()).setMessage("为了能够让你不错过重要的通知消息,强烈建议你开始允许推送通知功能").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.v2.ui.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                MainActivity.m38874O(MainActivity.this);
            }
        }).setLeftButtonText("不了").setRightButtonText("去开启").show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public static final void m38874O(MainActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        NotificationsUtils.m44050b(this$0.mo43912w());
    }

    /* renamed from: P */
    private final void m38873P() {
        VersionUpdate versionUpdate = new VersionUpdate(mo43926C());
        versionUpdate.m42765b(new C5599a(versionUpdate));
    }

    /* renamed from: R */
    private final void m38871R() {
        Http.with(mo43926C()).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2266k(LoginUser.getLoginUser().getSchoolId())).setDataListener(new C5600b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public static final void m38869T(MainActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.finish();
    }

    /* renamed from: U */
    private final void m38868U(int i) {
        this.f20357q = i;
        String[] strArr = new String[this.f20355o.size()];
        int i2 = 0;
        for (Object obj : this.f20355o) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (i == i2) {
                strArr[i2] = JsonGet.f15134a.m43760t(map, "iconS");
            } else {
                strArr[i2] = JsonGet.f15134a.m43760t(map, RewardPlus.ICON);
            }
            i2 = i3;
        }
        BottomNavigationViewHelper.m39134a(mo43920M().navView, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public static final void m38867V(final MainActivity this$0, List menuList) {
        List<Map<String, Object>> m12218L5;
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().navView.getMenu().clear();
        C14342f0.m8185o(menuList, "menuList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : menuList) {
            if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "isShow"), "1")) {
                arrayList.add(obj);
            }
        }
        m12218L5 = _Collections.m12218L5(arrayList);
        this$0.f20355o = m12218L5;
        int i = 0;
        for (Object obj2 : m12218L5) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            this$0.mo43920M().navView.getMenu().add(0, i, i, JsonGet.f15134a.m43760t((Map) obj2, "name"));
            i = i2;
        }
        this$0.m38868U(0);
        this$0.mo43920M().navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: com.bxkj.student.v2.ui.g
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean m38866W;
                m38866W = MainActivity.m38866W(MainActivity.this, menuItem);
                return m38866W;
            }
        });
        this$0.mo43920M().navView.setSelectedItemId(this$0.f20356p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public static final boolean m38866W(final MainActivity this$0, MenuItem it) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8184p(it, "it");
        C11792j.m20469d(C14342f0.m8216C(" mDataBinding.navView.setOnNavigationItemSelectedListener currentMenu->", Integer.valueOf(it.getItemId())), new Object[0]);
        Map<String, ? extends Object> map = this$0.f20355o.get(it.getItemId());
        JsonGet jsonGet = JsonGet.f15134a;
        if (!C14342f0.m8193g(jsonGet.m43760t(map, "isEnabled"), "1")) {
            this$0.mo43920M().navView.postDelayed(new Runnable() { // from class: com.bxkj.student.v2.ui.i
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.m38864Y(MainActivity.this);
                }
            }, 10L);
            ContextExt.m43846r(this$0, "暂未开通此权限");
            return true;
        } else if (jsonGet.m43776d(map, "isLogin") && !LoggedInUser.f15182b.m43634a().m43637y()) {
            this$0.startActivity(new Intent(this$0.mo43912w(), LoginActivity.class));
            this$0.mo43920M().navView.postDelayed(new Runnable() { // from class: com.bxkj.student.v2.ui.h
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.m38865X(MainActivity.this);
                }
            }, 100L);
            return true;
        } else {
            this$0.m38868U(it.getItemId());
            String m43760t = jsonGet.m43760t(map, "mkey");
            switch (m43760t.hashCode()) {
                case 1729495413:
                    if (m43760t.equals("navKey1")) {
                        if (this$0.f20349i == null) {
                            this$0.f20349i = new HomeFragment();
                        }
                        Fragment fragment = this$0.f20354n;
                        HomeFragment homeFragment = this$0.f20349i;
                        C14342f0.m8187m(homeFragment);
                        this$0.m38859c0(fragment, homeFragment, "navKey1");
                        HomeFragment homeFragment2 = this$0.f20349i;
                        if (homeFragment2 != null) {
                            homeFragment2.m38684Q();
                            break;
                        }
                    }
                    break;
                case 1729495414:
                    if (m43760t.equals("navKey2")) {
                        if (this$0.f20350j == null) {
                            this$0.f20350j = new ClassifyFragment();
                        }
                        Fragment fragment2 = this$0.f20354n;
                        ClassifyFragment classifyFragment = this$0.f20350j;
                        C14342f0.m8187m(classifyFragment);
                        this$0.m38859c0(fragment2, classifyFragment, "navKey2");
                        ClassifyFragment classifyFragment2 = this$0.f20350j;
                        if (classifyFragment2 != null) {
                            classifyFragment2.m38706j();
                        }
                        return true;
                    }
                    break;
                case 1729495415:
                    if (m43760t.equals("navKey3")) {
                        if (this$0.f20351k == null) {
                            this$0.f20351k = new DiscoveryFragment();
                        }
                        Fragment fragment3 = this$0.f20354n;
                        DiscoveryFragment discoveryFragment = this$0.f20351k;
                        C14342f0.m8187m(discoveryFragment);
                        this$0.m38859c0(fragment3, discoveryFragment, "navKey3");
                        return true;
                    }
                    break;
                case 1729495416:
                    if (m43760t.equals("navKey4")) {
                        if (this$0.f20352l == null) {
                            this$0.f20352l = new MsgFragment();
                        }
                        Fragment fragment4 = this$0.f20354n;
                        MsgFragment msgFragment = this$0.f20352l;
                        C14342f0.m8187m(msgFragment);
                        this$0.m38859c0(fragment4, msgFragment, "navKey4");
                        return true;
                    }
                    break;
                case 1729495417:
                    if (m43760t.equals("navKey5")) {
                        if (this$0.f20353m == null) {
                            this$0.f20353m = new MyFragment();
                        }
                        MyFragment myFragment = this$0.f20353m;
                        if (myFragment != null) {
                            myFragment.m38660k();
                        }
                        Fragment fragment5 = this$0.f20354n;
                        MyFragment myFragment2 = this$0.f20353m;
                        C14342f0.m8187m(myFragment2);
                        this$0.m38859c0(fragment5, myFragment2, "navKey5");
                        return true;
                    }
                    break;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public static final void m38865X(MainActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        if ((this$0.mo43920M().navView.getSelectedItemId() != 0 ? this$0 : null) == null) {
            return;
        }
        this$0.mo43920M().navView.setSelectedItemId(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public static final void m38864Y(MainActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().navView.setSelectedItemId(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public static final void m38863Z(MainActivity this$0, Map noticeMap) {
        Map m8915J0;
        C14342f0.m8184p(this$0, "this$0");
        C11792j.m20469d(C14342f0.m8216C("latestUnreadNotice=", noticeMap), new Object[0]);
        NoticeDialog noticeDialog = new NoticeDialog();
        Bundle bundle = new Bundle();
        C14342f0.m8185o(noticeMap, "noticeMap");
        m8915J0 = C14239y0.m8915J0(noticeMap);
        bundle.putParcelable("data", new ParcelableMap(m8915J0));
        noticeDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        C14342f0.m8185o(supportFragmentManager, "supportFragmentManager");
        noticeDialog.m43982d(supportFragmentManager, "TSNDialog", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public static final void m38862a0(MainActivity this$0, Boolean bool) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().navView.setSelectedItemId(0);
    }

    /* renamed from: c0 */
    private final void m38859c0(Fragment fragment, Fragment fragment2, String str) {
        if (this.f20354n != fragment2) {
            this.f20354n = fragment2;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            C14342f0.m8185o(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            C14342f0.m8185o(beginTransaction, "fm.beginTransaction()");
            if (fragment != null) {
                beginTransaction.hide(fragment);
            }
            if (fragment2.isAdded()) {
                beginTransaction.show(fragment2);
            } else {
                beginTransaction.add(C4215R.C4219id.fl_content, fragment2, str);
            }
            beginTransaction.commit();
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        if (!TsnSecret.f13210a.checkSignature(mo43926C())) {
            iOSOneButtonDialog m43851m = ContextExt.m43851m(this, "非官方正版应用，请卸载后从正规渠道下载使用");
            m43851m.setCancelable(false);
            m43851m.setClickAutoCancel(false);
            m43851m.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.m38869T(MainActivity.this, view);
                }
            });
        }
        m38875N();
        m38871R();
        m38873P();
        mo43911x().m38172N();
        mo43911x().m38166T();
    }

    /* renamed from: Q */
    public final int m38872Q() {
        return this.f20357q;
    }

    /* renamed from: S */
    public final void m38870S() {
        Object obj;
        Iterator<T> it = this.f20355o.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "mkey"), "navKey2")) {
                break;
            }
        }
        Map<String, ? extends Object> map = (Map) obj;
        if (map == null) {
            return;
        }
        JsonGet jsonGet = JsonGet.f15134a;
        if (!C14342f0.m8193g(jsonGet.m43760t(map, "isEnabled"), "1")) {
            ContextExt.m43846r(this, "暂未开通此权限");
        } else if (jsonGet.m43776d(map, "isLogin") && !LoggedInUser.f15182b.m43634a().m43637y()) {
            startActivity(new Intent(mo43912w(), LoginActivity.class));
        } else {
            int i = 0;
            Iterator<Map<String, Object>> it2 = this.f20355o.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                if (C14342f0.m8193g(JsonGet.f15134a.m43760t(it2.next(), "mkey"), "navKey2")) {
                    break;
                }
                i++;
            }
            mo43920M().navView.setSelectedItemId(i);
        }
    }

    /* renamed from: b0 */
    public final void m38861b0(int i) {
        this.f20357q = i;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.f20359s > 2000) {
            ContextExt.m43846r(this, "再按一次退出程序");
            this.f20359s = System.currentTimeMillis();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        MyFragment myFragment = this.f20353m;
        if (myFragment != null) {
            myFragment.m38664g();
        }
        DiscoveryFragment discoveryFragment = this.f20351k;
        if (discoveryFragment != null) {
            discoveryFragment.m38690k();
        }
        MsgFragment msgFragment = this.f20352l;
        if (msgFragment != null) {
            msgFragment.m38667g();
        }
        mo43911x().m38166T();
        HomeFragment homeFragment = this.f20349i;
        if (homeFragment == null) {
            return;
        }
        homeFragment.m38674l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f20358r) {
            return;
        }
        m38873P();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        C14342f0.m8184p(outState, "outState");
        outState.putInt("selectedItemId", mo43920M().navView.getSelectedItemId());
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m38164V().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.m38862a0(MainActivity.this, (Boolean) obj);
            }
        });
        mo43911x().m38176J().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.m38867V(MainActivity.this, (List) obj);
            }
        });
        mo43911x().m38167S().observe(this, new Observer() { // from class: com.bxkj.student.v2.ui.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.m38863Z(MainActivity.this, (Map) obj);
            }
        });
    }
}
