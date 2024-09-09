package com.bxkj.student.v2.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.r;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.base.v2.data.ParcelableMap;
import com.bxkj.base.v2.data.a;
import com.bxkj.base.v2.netty4android.service.NettySocketService;
import com.bxkj.student.App;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.databinding.V2MainBinding;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;
import com.bxkj.student.v2.ui.main.ClassifyFragment;
import com.bxkj.student.v2.ui.main.DiscoveryFragment;
import com.bxkj.student.v2.ui.main.H5Fragment;
import com.bxkj.student.v2.ui.main.HomeFragment;
import com.bxkj.student.v2.ui.main.MsgFragment;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.bxkj.student.v2.vm.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import d2.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.z0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MainActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006*\u0001C\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0011H\u0014J\b\u0010\u001e\u001a\u00020\u0006H\u0014R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R*\u0010?\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010=0<0;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010>R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\"\u0010L\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010A\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006W"}, d2 = {"Lcom/bxkj/student/v2/ui/MainActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2MainBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "", "index", "Lkotlin/f1;", "T", "Landroidx/fragment/app/Fragment;", "from", "to", "", "tag", "b0", "N", "Q", "O", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "E", "Landroid/content/Intent;", "intent", "onNewIntent", "p", "onResume", "R", "onBackPressed", "outState", "onSaveInstanceState", "onDestroy", "Lcom/bxkj/student/v2/ui/main/HomeFragment;", "i", "Lcom/bxkj/student/v2/ui/main/HomeFragment;", "homeFragment", "Lcom/bxkj/student/v2/ui/main/ClassifyFragment;", "j", "Lcom/bxkj/student/v2/ui/main/ClassifyFragment;", "classifyFragment", "Lcom/bxkj/student/v2/ui/main/DiscoveryFragment;", "k", "Lcom/bxkj/student/v2/ui/main/DiscoveryFragment;", "discoveryFragment", "Lcom/bxkj/student/v2/ui/main/MsgFragment;", "l", "Lcom/bxkj/student/v2/ui/main/MsgFragment;", "msgFragment", "Lcom/bxkj/student/v2/ui/main/MyFragment;", "m", "Lcom/bxkj/student/v2/ui/main/MyFragment;", "myFragment", "", "Lcom/bxkj/student/v2/ui/main/H5Fragment;", "n", "Ljava/util/Map;", "h5FragmentList", "o", "Landroidx/fragment/app/Fragment;", "isFragment", "", "", "", "Ljava/util/List;", "navigationMenuList", CampaignEx.JSON_KEY_AD_Q, "I", "selectedItemId", "com/bxkj/student/v2/ui/MainActivity$refreshTokenBroadCastReceiver$1", "r", "Lcom/bxkj/student/v2/ui/MainActivity$refreshTokenBroadCastReceiver$1;", "refreshTokenBroadCastReceiver", "s", "P", "()I", "a0", "(I)V", "lastSelectIndex", "", "t", "Z", "checkUpdateSuccess", "", "u", "J", "time", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MainActivity extends BaseActivity<V2MainBinding, MainViewModel> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private HomeFragment f23717i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ClassifyFragment f23718j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private DiscoveryFragment f23719k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private MsgFragment f23720l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private MyFragment f23721m;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Fragment f23723o;

    /* renamed from: q  reason: collision with root package name */
    private int f23725q;

    /* renamed from: s  reason: collision with root package name */
    private int f23727s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f23728t;

    /* renamed from: u  reason: collision with root package name */
    private long f23729u;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private Map<String, H5Fragment> f23722n = new LinkedHashMap();
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private List<Map<String, Object>> f23724p = new ArrayList();
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final MainActivity$refreshTokenBroadCastReceiver$1 f23726r = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.MainActivity$refreshTokenBroadCastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            HomeFragment homeFragment;
            MsgFragment msgFragment;
            Map map;
            j.d("\u63a5\u6536\u5230\u4e86\u5237\u65b0Token\u6210\u529f\u901a\u77e5", new Object[0]);
            MainActivity.this.x().T();
            homeFragment = MainActivity.this.f23717i;
            if (homeFragment != null) {
                homeFragment.l();
            }
            msgFragment = MainActivity.this.f23720l;
            if (msgFragment != null) {
                msgFragment.g();
            }
            map = MainActivity.this.f23722n;
            for (Map.Entry entry : map.entrySet()) {
                ((H5Fragment) entry.getValue()).f();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MainActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends Lambda implements l<iOSTwoButtonDialog, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            r.b(MainActivity.this.w());
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MainActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/bxkj/student/v2/ui/MainActivity$b", "Lcom/bxkj/student/common/versionupdate/a$d;", "", "hasNewVersion", "", "versionName", "downLoadUrl", "instruction", "Lkotlin/f1;", "a", "b", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b implements a.d {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f23732b;

        b(com.bxkj.student.common.versionupdate.a aVar) {
            this.f23732b = aVar;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean z3, @NotNull String versionName, @NotNull String downLoadUrl, @NotNull String instruction) {
            f0.p(versionName, "versionName");
            f0.p(downLoadUrl, "downLoadUrl");
            f0.p(instruction, "instruction");
            MainActivity.this.f23728t = true;
            if (z3) {
                this.f23732b.d(versionName, downLoadUrl, instruction);
            }
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
            MainActivity.this.f23728t = false;
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/MainActivity$c", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            try {
                m mVar = m.a;
                String t3 = mVar.t(data, "schName");
                LoginUser.getLoginUser().setSysType(mVar.k(data, "sysType"));
                a.b bVar = com.bxkj.base.v2.data.a.f18673h;
                bVar.a().f0(mVar.k(data, "isOpenLive"));
                bVar.a().g0(mVar.l(data, "isOpenSQZS", 1));
                bVar.a().e0(mVar.l(data, "isOpenGGLBT", 1));
                bVar.a().l0(t3);
                bVar.a().k0(mVar.t(data, "schoolCode"));
                bVar.a().m0(mVar.u(data, "lan_url", "http://a.sxstczx.com/"));
                com.bxkj.student.v2.retrofit.c.f23705a.a();
                bVar.a().T(mVar.t(data, "urlSite"));
                if (LoginUser.getLoginUser().getSysType() == 1) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this.C(), com.bxkj.student.MainActivity.class));
                    MainActivity.this.finish();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    static {
        StubApp.interface11(6317);
    }

    private final void N() {
        if (Build.VERSION.SDK_INT < 19 || r.a(C())) {
            return;
        }
        ContextExtKt.h(C(), (String) null, "\u4e3a\u4e86\u80fd\u591f\u8ba9\u4f60\u4e0d\u9519\u8fc7\u91cd\u8981\u7684\u901a\u77e5\u6d88\u606f,\u5f3a\u70c8\u5efa\u8bae\u4f60\u5f00\u542f\u5141\u8bb8\u63a8\u9001\u901a\u77e5\u529f\u80fd", new a(), (l) null, "\u4e0d\u4e86", "\u53bb\u5f00\u542f", 9, (Object) null);
    }

    private final void O() {
        com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(C());
        aVar.b(new b(aVar));
    }

    private final void Q() {
        Http.with(C()).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((p.f) Http.getApiService(p.f.class)).k(LoginUser.getLoginUser().getSchoolId())).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(MainActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    private final void T(int i4) {
        this.f23727s = i4;
        String[] strArr = new String[this.f23724p.size()];
        int i5 = 0;
        for (Object obj : this.f23724p) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            Map map = (Map) obj;
            if (i4 == i5) {
                strArr[i5] = m.a.t(map, "iconS");
            } else {
                strArr[i5] = m.a.t(map, RewardPlus.ICON);
            }
            i5 = i6;
        }
        com.bxkj.student.v2.common.utils.f.a(M().navView, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(final MainActivity this$0, List menuList) {
        List<Map<String, Object>> J5;
        f0.p(this$0, "this$0");
        this$0.M().navView.getMenu().clear();
        f0.o(menuList, "menuList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : menuList) {
            if (f0.g(m.a.t((Map) obj, "isShow"), "1")) {
                arrayList.add(obj);
            }
        }
        J5 = kotlin.collections.f0.J5(arrayList);
        this$0.f23724p = J5;
        int i4 = 0;
        for (Object obj2 : J5) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            this$0.M().navView.getMenu().add(0, i4, i4, m.a.t((Map) obj2, "name"));
            i4 = i5;
        }
        this$0.T(0);
        this$0.M().navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: com.bxkj.student.v2.ui.f
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean V;
                V = MainActivity.V(MainActivity.this, menuItem);
                return V;
            }
        });
        this$0.M().navView.setSelectedItemId(this$0.f23725q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V(final MainActivity this$0, MenuItem it) {
        H5Fragment h5Fragment;
        f0.p(this$0, "this$0");
        f0.p(it, "it");
        j.d(f0.C(" mDataBinding.navView.setOnNavigationItemSelectedListener currentMenu->", Integer.valueOf(it.getItemId())), new Object[0]);
        Map<String, Object> map = this$0.f23724p.get(it.getItemId());
        m mVar = m.a;
        if (!f0.g(mVar.t(map, "isEnabled"), "1")) {
            this$0.M().navView.postDelayed(new Runnable() { // from class: com.bxkj.student.v2.ui.h
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.W(MainActivity.this);
                }
            }, 10L);
            ContextExtKt.r(this$0, "\u6682\u672a\u5f00\u901a\u6b64\u6743\u9650");
            return true;
        } else if (mVar.d(map, "isLogin") && !com.bxkj.base.v2.data.a.f18673h.a().G()) {
            this$0.startActivity(new Intent(this$0.w(), LoginActivity.class));
            this$0.M().navView.postDelayed(new Runnable() { // from class: com.bxkj.student.v2.ui.g
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.X(MainActivity.this);
                }
            }, 100L);
            return true;
        } else {
            this$0.T(it.getItemId());
            String t3 = mVar.t(map, "mkey");
            switch (t3.hashCode()) {
                case 1729495413:
                    if (t3.equals("navKey1")) {
                        if (this$0.f23717i == null) {
                            this$0.f23717i = new HomeFragment();
                        }
                        Fragment fragment = this$0.f23723o;
                        HomeFragment homeFragment = this$0.f23717i;
                        f0.m(homeFragment);
                        this$0.b0(fragment, homeFragment, "navKey1");
                        HomeFragment homeFragment2 = this$0.f23717i;
                        if (homeFragment2 != null) {
                            homeFragment2.Q();
                        }
                        return true;
                    }
                    break;
                case 1729495414:
                    if (t3.equals("navKey2")) {
                        if (this$0.f23718j == null) {
                            this$0.f23718j = new ClassifyFragment();
                        }
                        Fragment fragment2 = this$0.f23723o;
                        ClassifyFragment classifyFragment = this$0.f23718j;
                        f0.m(classifyFragment);
                        this$0.b0(fragment2, classifyFragment, "navKey2");
                        ClassifyFragment classifyFragment2 = this$0.f23718j;
                        if (classifyFragment2 != null) {
                            classifyFragment2.j();
                        }
                        return true;
                    }
                    break;
                case 1729495415:
                    if (t3.equals("navKey3")) {
                        if (this$0.f23719k == null) {
                            this$0.f23719k = new DiscoveryFragment();
                        }
                        Fragment fragment3 = this$0.f23723o;
                        DiscoveryFragment discoveryFragment = this$0.f23719k;
                        f0.m(discoveryFragment);
                        this$0.b0(fragment3, discoveryFragment, "navKey3");
                        return true;
                    }
                    break;
                case 1729495416:
                    if (t3.equals("navKey4")) {
                        if (this$0.f23720l == null) {
                            this$0.f23720l = new MsgFragment();
                        }
                        Fragment fragment4 = this$0.f23723o;
                        MsgFragment msgFragment = this$0.f23720l;
                        f0.m(msgFragment);
                        this$0.b0(fragment4, msgFragment, "navKey4");
                        return true;
                    }
                    break;
                case 1729495417:
                    if (t3.equals("navKey5")) {
                        if (this$0.f23721m == null) {
                            this$0.f23721m = new MyFragment();
                        }
                        MyFragment myFragment = this$0.f23721m;
                        if (myFragment != null) {
                            myFragment.k();
                        }
                        Fragment fragment5 = this$0.f23723o;
                        MyFragment myFragment2 = this$0.f23721m;
                        f0.m(myFragment2);
                        this$0.b0(fragment5, myFragment2, "navKey5");
                        return true;
                    }
                    break;
            }
            String t4 = mVar.t(map, "linkUrl");
            if (t4.length() > 0) {
                if (this$0.f23722n.containsKey(t3)) {
                    h5Fragment = this$0.f23722n.get(t3);
                } else {
                    H5Fragment h5Fragment2 = new H5Fragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", t4);
                    bundle.putString("title", mVar.t(map, "name"));
                    bundle.putString("isShowH5Title", mVar.t(map, "isShowH5Title"));
                    h5Fragment2.setArguments(bundle);
                    this$0.f23722n.put(t3, h5Fragment2);
                    h5Fragment = h5Fragment2;
                }
                if (h5Fragment != null) {
                    this$0.b0(this$0.f23723o, h5Fragment, t3);
                }
            } else {
                ContextExtKt.r(this$0, "\u6682\u672a\u5f00\u901a\u6b64\u6743\u9650");
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(MainActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.M().navView.setSelectedItemId(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(MainActivity this$0) {
        f0.p(this$0, "this$0");
        if ((this$0.M().navView.getSelectedItemId() != 0 ? this$0 : null) == null) {
            return;
        }
        this$0.M().navView.setSelectedItemId(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(MainActivity this$0, Map noticeMap) {
        Map J0;
        f0.p(this$0, "this$0");
        j.d(f0.C("latestUnreadNotice=", noticeMap), new Object[0]);
        NoticeDialog noticeDialog = new NoticeDialog();
        Bundle bundle = new Bundle();
        f0.o(noticeMap, "noticeMap");
        J0 = z0.J0(noticeMap);
        bundle.putParcelable("data", new ParcelableMap(J0));
        noticeDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        f0.o(supportFragmentManager, "supportFragmentManager");
        noticeDialog.h(supportFragmentManager, "TSNDialog", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(MainActivity this$0, Boolean bool) {
        f0.p(this$0, "this$0");
        this$0.M().navView.setSelectedItemId(0);
    }

    private final void b0(Fragment fragment, Fragment fragment2, String str) {
        if (this.f23723o != fragment2) {
            this.f23723o = fragment2;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            f0.o(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            f0.o(beginTransaction, "fm.beginTransaction()");
            if (fragment != null) {
                beginTransaction.hide(fragment);
            }
            if (fragment2.isAdded()) {
                beginTransaction.show(fragment2);
            } else {
                beginTransaction.add(2131231399, fragment2, str);
            }
            beginTransaction.commit();
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        if (!TsnSecret.f16433a.checkSignature(C())) {
            iOSOneButtonDialog m4 = ContextExtKt.m(this, "\u975e\u5b98\u65b9\u6b63\u7248\u5e94\u7528\uff0c\u8bf7\u5378\u8f7d\u540e\u4ece\u6b63\u89c4\u6e20\u9053\u4e0b\u8f7d\u4f7f\u7528");
            m4.setCancelable(false);
            m4.setClickAutoCancel(false);
            m4.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.S(MainActivity.this, view);
                }
            });
        }
        try {
            startService(new Intent(BaseApp.b(), NettySocketService.class).putExtra("action", 1));
        } catch (Exception e4) {
            j.e(f0.C("startService\uff1a", e4.getMessage()), new Object[0]);
        }
        N();
        Q();
        O();
        x().N();
        if ((com.bxkj.base.v2.data.a.f18673h.a().K() ? this : null) != null) {
            x().T();
        }
        registerReceiver(this.f23726r, new IntentFilter(f0.C(App.n().getPackageName(), ".REFRESH_TOKEN_FINISH")), "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST", null);
    }

    public final int P() {
        return this.f23727s;
    }

    public final void R() {
        Object obj;
        Iterator<T> it = this.f23724p.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (f0.g(m.a.t((Map) obj, "mkey"), "navKey2")) {
                break;
            }
        }
        Map map = (Map) obj;
        if (map == null) {
            return;
        }
        m mVar = m.a;
        if (!f0.g(mVar.t(map, "isEnabled"), "1")) {
            ContextExtKt.r(this, "\u6682\u672a\u5f00\u901a\u6b64\u6743\u9650");
        } else if (mVar.d(map, "isLogin") && !com.bxkj.base.v2.data.a.f18673h.a().G()) {
            startActivity(new Intent(w(), LoginActivity.class));
        } else {
            int i4 = 0;
            Iterator<Map<String, Object>> it2 = this.f23724p.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i4 = -1;
                    break;
                }
                if (f0.g(m.a.t(it2.next(), "mkey"), "navKey2")) {
                    break;
                }
                i4++;
            }
            M().navView.setSelectedItemId(i4);
        }
    }

    public final void a0(int i4) {
        this.f23727s = i4;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.f23729u > 2000) {
            ContextExtKt.r(this, "\u518d\u6309\u4e00\u6b21\u9000\u51fa\u7a0b\u5e8f");
            this.f23729u = System.currentTimeMillis();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f23726r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        MyFragment myFragment = this.f23721m;
        if (myFragment != null) {
            myFragment.g();
        }
        DiscoveryFragment discoveryFragment = this.f23719k;
        if (discoveryFragment != null) {
            discoveryFragment.k();
        }
        MsgFragment msgFragment = this.f23720l;
        if (msgFragment != null) {
            msgFragment.g();
        }
        x().T();
        HomeFragment homeFragment = this.f23717i;
        if (homeFragment != null) {
            homeFragment.l();
        }
        for (Map.Entry<String, H5Fragment> entry : this.f23722n.entrySet()) {
            entry.getValue().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f23728t) {
            return;
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        f0.p(outState, "outState");
        outState.putInt("selectedItemId", M().navView.getSelectedItemId());
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().V().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.Z(MainActivity.this, (Boolean) obj);
            }
        });
        x().J().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.U(MainActivity.this, (List) obj);
            }
        });
        x().S().observe(this, new Observer() { // from class: com.bxkj.student.v2.ui.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.Y(MainActivity.this, (Map) obj);
            }
        });
    }
}
