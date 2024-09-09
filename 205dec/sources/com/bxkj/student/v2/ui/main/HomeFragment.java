package com.bxkj.student.v2.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.common.view.CycleViewPager;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2ItemForHomeMenuBinding;
import com.bxkj.student.databinding.V2MainTabHomeFragmentBinding;
import com.bxkj.student.v2.common.utils.t;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.MainViewModel;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.collections.z0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HomeFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016R6\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R>\u0010\u001d\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/bxkj/student/v2/ui/main/HomeFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabHomeFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "m", "E", "p", "onResume", "l", "Q", "onDestroy", "", "", "", "", "j", "Ljava/util/List;", "k", "()Ljava/util/List;", "S", "(Ljava/util/List;)V", "menuListData", "Lcom/bxkj/base/v2/base/BaseAdapter;", "Lcom/bxkj/student/databinding/V2ItemForHomeMenuBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "R", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "adapter", "Lcom/beizi/fusion/NativeAd;", "Lcom/beizi/fusion/NativeAd;", "mNativeAd", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class HomeFragment extends BaseFragment<V2MainTabHomeFragmentBinding, MainViewModel> {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private List<Map<String, Object>> f23892j = new ArrayList();
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> f23893k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private NativeAd f23894l;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(HomeFragment this$0, Map dataMap) {
        Map<String, ? extends Object> J0;
        f0.p(this$0, "this$0");
        String t3 = com.bxkj.base.v2.common.utils.m.a.t(dataMap, "updateStatus");
        if ((f0.g(t3, "1") ? this$0 : null) == null) {
            return;
        }
        f0.o(dataMap, "dataMap");
        J0 = z0.J0(dataMap);
        J0.put("needUpdatePasswordStatus", t3);
        J0.put("name", "\u4fee\u6539\u5bc6\u7801");
        com.bxkj.student.v2.common.utils.i.f23368a.b(this$0.C(), J0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final HomeFragment this$0, final List adListMap) {
        int Z;
        f0.p(this$0, "this$0");
        f0.o(adListMap, "adListMap");
        Z = y.Z(adListMap, 10);
        ArrayList arrayList = new ArrayList(Z);
        Iterator it = adListMap.iterator();
        while (it.hasNext()) {
            arrayList.add(com.bxkj.base.v2.common.utils.m.a.t((Map) it.next(), "imageHttpUrl"));
        }
        if (adListMap.size() <= 1) {
            this$0.M().cpAd.setWheel(false);
        }
        this$0.M().cpAd.w(arrayList, new CycleViewPager.c() { // from class: com.bxkj.student.v2.ui.main.l
            @Override // com.bxkj.base.v2.common.view.CycleViewPager.c
            public final void onImageClick(String str, int i4, View view) {
                HomeFragment.N(HomeFragment.this, adListMap, str, i4, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(HomeFragment this$0, List list, String str, int i4, View view) {
        f0.p(this$0, "this$0");
        com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
        this$0.x().A(mVar.t((Map) list.get(i4), "id"));
        String t3 = mVar.t((Map) list.get(i4), "bannerType");
        switch (t3.hashCode()) {
            case 49:
                if (t3.equals("1")) {
                    if ((TextUtils.isEmpty(mVar.t((Map) list.get(i4), "linkUrl")) ^ true ? this$0 : null) == null) {
                        return;
                    }
                    com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f23368a;
                    FragmentActivity w3 = this$0.w();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("name", mVar.t((Map) list.get(i4), "articleTitle"));
                    linkedHashMap.put("linkUrl", mVar.t((Map) list.get(i4), "linkUrl"));
                    f1 f1Var = f1.f55527a;
                    iVar.b(w3, linkedHashMap);
                    return;
                }
                return;
            case 50:
                if (t3.equals("2")) {
                    String t4 = mVar.t((Map) list.get(i4), "appletId");
                    this$0.x().A(mVar.t((Map) list.get(i4), "id"));
                    t.f23404a.a(this$0.C(), t4, mVar.t((Map) list.get(i4), "appletPath"));
                    return;
                }
                return;
            case 51:
                if (t3.equals("3")) {
                    try {
                        String t5 = mVar.t((Map) list.get(i4), "jdPath");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("openApp.jdMobile://virtual?params={\"category\":\"jump\",\"des\":\"productDetail\",\"skuId\":\"" + t5 + "\",\"sourceType\":\"JSHOP_SOURCE_TYPE\",\"sourceValue\":\"JSHOP_SOURCE_VALUE\"}"));
                        intent.addFlags(268435456);
                        this$0.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(HomeFragment this$0, List list) {
        f0.p(this$0, "this$0");
        this$0.k().clear();
        if (list != null) {
            ArrayList<Map<String, Object>> arrayList = new ArrayList();
            for (Object obj : list) {
                if (f0.g(com.bxkj.base.v2.common.utils.m.a.t((Map) obj, "isShow"), "1")) {
                    arrayList.add(obj);
                }
            }
            for (Map<String, Object> map : arrayList) {
                this$0.k().add(map);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", "\u66f4\u591a");
        linkedHashMap.put(RewardPlus.ICON, 2131559137);
        linkedHashMap.put("isEnabled", 1);
        linkedHashMap.put("isLogin", Boolean.FALSE);
        linkedHashMap.put("mkey", "app_home_menu_more");
        this$0.k().add(linkedHashMap);
        BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> j4 = this$0.j();
        if (j4 == null) {
            return;
        }
        j4.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(HomeFragment this$0, String it) {
        String k22;
        f0.p(this$0, "this$0");
        SmartWebView smartWebView = this$0.M().smartWebView;
        f0.o(it, "it");
        k22 = w.k2(it, "${school}", com.bxkj.base.v2.data.a.f18673h.a().w(), false, 4, null);
        smartWebView.j(k22);
    }

    private final void m() {
        this.f23894l = new NativeAd(w(), "103224", new a(), 5000L, 1);
        float d4 = com.bxkj.student.common.utils.m.d((Context) w()) - 36;
        NativeAd nativeAd = this.f23894l;
        if (nativeAd == null) {
            return;
        }
        nativeAd.loadAd(d4, 180.0f);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        d(w());
        M().smartWebView.getWebView().addJavascriptInterface(new JS(w(), M().smartWebView.getWebView()), "tsn");
        x().H();
        M().cpAd.B(R.drawable.v2_dot_white, R.drawable.v2_dot_gey);
        M().cpAd.setDelay(AVMDLDataLoader.KeyIsLiveSetLoaderType);
        this.f23893k = new HomeFragment$initUiData$1(this, this.f23892j);
        M().rvMenu.setAdapter(this.f23893k);
        l();
    }

    public final void Q() {
        HomeFragment homeFragment = b() ? this : null;
        if (homeFragment != null) {
            if (!k().isEmpty()) {
                homeFragment = null;
            }
            if (homeFragment != null) {
                x().N();
            }
        }
        HomeFragment homeFragment2 = b() ? this : null;
        if (homeFragment2 == null) {
            return;
        }
        List<Map<String, Object>> value = x().I().getValue();
        boolean z3 = false;
        if (value != null && value.isEmpty()) {
            z3 = true;
        }
        if ((z3 ? homeFragment2 : null) == null) {
            return;
        }
        x().H();
    }

    public final void R(@Nullable BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> baseAdapter) {
        this.f23893k = baseAdapter;
    }

    public final void S(@NotNull List<Map<String, Object>> list) {
        f0.p(list, "<set-?>");
        this.f23892j = list;
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> j() {
        return this.f23893k;
    }

    @NotNull
    public final List<Map<String, Object>> k() {
        return this.f23892j;
    }

    public final void l() {
        HomeFragment homeFragment = b() ? this : null;
        if (homeFragment == null) {
            return;
        }
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        if (!bVar.a().G()) {
            homeFragment = null;
        }
        if (homeFragment == null) {
            return;
        }
        if ((bVar.a().K() ? homeFragment : null) == null) {
            return;
        }
        x().d0();
    }

    @Override // com.bxkj.base.v2.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        NativeAd nativeAd = this.f23894l;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        l();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().I().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.H(HomeFragment.this, (List) obj);
            }
        });
        x().O().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.O(HomeFragment.this, (List) obj);
            }
        });
        x().P().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.P(HomeFragment.this, (String) obj);
            }
        });
        x().e0().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.D(HomeFragment.this, (Map) obj);
            }
        });
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: HomeFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/v2/ui/main/HomeFragment$a", "Lcom/beizi/fusion/NativeAdListener;", "", "code", "Lkotlin/f1;", "onAdFailed", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onAdLoaded", "onAdShown", "onAdClosed", "onAdClick", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a implements NativeAdListener {
        a() {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClick() {
            com.orhanobut.logger.j.g("BeiZisDemo->Native ad onAdClick", new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClosed() {
            HomeFragment.this.M().cpAd.p();
            com.orhanobut.logger.j.g("BeiZisDemo->Native ad onAdClosed", new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdFailed(int i4) {
            com.orhanobut.logger.j.g(f0.C("BeiZisDemo->Native ad onAdFailed ", Integer.valueOf(i4)), new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdLoaded(@NotNull View view) {
            f0.p(view, "view");
            com.orhanobut.logger.j.g("BeiZisDemo->Native ad onAdLoaded", new Object[0]);
            HomeFragment.this.M().cpAd.o(view);
            HomeFragment.this.M().cpAd.setWheel(true);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdShown() {
            com.orhanobut.logger.j.g("BeiZisDemo->Native ad onAdShown", new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClosed(@NotNull View view) {
            f0.p(view, "view");
            HomeFragment.this.M().cpAd.p();
            com.orhanobut.logger.j.g("BeiZisDemo->Native ad onAdClosed", new Object[0]);
        }
    }
}
