package com.bxkj.student.p094v2.p098ui.main;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.common.view.CycleViewPager;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.UiUtil;
import com.bxkj.student.databinding.V2ItemForHomeMenuBinding;
import com.bxkj.student.databinding.V2MainTabHomeFragmentBinding;
import com.bxkj.student.p094v2.common.utils.H5Utils;
import com.bxkj.student.p094v2.common.utils.WechatUtils;
import com.bxkj.student.p094v2.p098ui.p099h5.p100js.C5652JS;
import com.bxkj.student.p094v2.p103vm.MainViewModel;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.C11792j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C14236x;
import kotlin.collections.C14239y0;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HomeFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016R6\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R>\u0010\u001d\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001f¨\u0006#"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/main/HomeFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabHomeFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "m", ExifInterface.LONGITUDE_EAST, "p", "onResume", C7304t.f25048d, "Q", "onDestroy", "", "", "", "", "j", "Ljava/util/List;", "k", "()Ljava/util/List;", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/List;)V", "menuListData", "Lcom/bxkj/base/v2/base/BaseAdapter;", "Lcom/bxkj/student/databinding/V2ItemForHomeMenuBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "R", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "adapter", "Lcom/beizi/fusion/NativeAd;", "Lcom/beizi/fusion/NativeAd;", "mNativeAd", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.HomeFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class HomeFragment extends BaseFragment<V2MainTabHomeFragmentBinding, MainViewModel> {
    @NotNull

    /* renamed from: j */
    private List<Map<String, Object>> f20496j = new ArrayList();
    @Nullable

    /* renamed from: k */
    private BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> f20497k;
    @Nullable

    /* renamed from: l */
    private NativeAd f20498l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public static final void m38689D(HomeFragment this$0, Map dataMap) {
        Map<String, ? extends Object> m8915J0;
        C14342f0.m8184p(this$0, "this$0");
        String m43760t = JsonGet.f15134a.m43760t(dataMap, "updateStatus");
        if ((C14342f0.m8193g(m43760t, "1") ? this$0 : null) == null) {
            return;
        }
        C14342f0.m8185o(dataMap, "dataMap");
        m8915J0 = C14239y0.m8915J0(dataMap);
        m8915J0.put("needUpdatePasswordStatus", m43760t);
        m8915J0.put("name", "修改密码");
        H5Utils.f20124a.m39075b(this$0.mo43926C(), m8915J0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public static final void m38688H(final HomeFragment this$0, final List adListMap) {
        int m8957Y;
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8185o(adListMap, "adListMap");
        m8957Y = C14236x.m8957Y(adListMap, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        Iterator it = adListMap.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonGet.f15134a.m43760t((Map) it.next(), "imageHttpUrl"));
        }
        if (adListMap.size() <= 1) {
            this$0.mo43920M().cpAd.setWheel(false);
        }
        this$0.mo43920M().cpAd.m43707w(arrayList, new CycleViewPager.InterfaceC3977c() { // from class: com.bxkj.student.v2.ui.main.l
            @Override // com.bxkj.base.p085v2.common.view.CycleViewPager.InterfaceC3977c
            public final void onImageClick(String str, int i, View view) {
                HomeFragment.m38687N(HomeFragment.this, adListMap, str, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public static final void m38687N(HomeFragment this$0, List list, String str, int i, View view) {
        C14342f0.m8184p(this$0, "this$0");
        JsonGet jsonGet = JsonGet.f15134a;
        this$0.mo43911x().m38185A(jsonGet.m43760t((Map) list.get(i), "id"));
        String m43760t = jsonGet.m43760t((Map) list.get(i), "bannerType");
        switch (m43760t.hashCode()) {
            case 49:
                if (m43760t.equals("1")) {
                    if ((TextUtils.isEmpty(jsonGet.m43760t((Map) list.get(i), "linkUrl")) ^ true ? this$0 : null) == null) {
                        return;
                    }
                    H5Utils h5Utils = H5Utils.f20124a;
                    FragmentActivity mo43912w = this$0.mo43912w();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("name", jsonGet.m43760t((Map) list.get(i), "articleTitle"));
                    linkedHashMap.put("linkUrl", jsonGet.m43760t((Map) list.get(i), "linkUrl"));
                    Unit unit = Unit.f41048a;
                    h5Utils.m39075b(mo43912w, linkedHashMap);
                    return;
                }
                return;
            case 50:
                if (m43760t.equals("2")) {
                    String m43760t2 = jsonGet.m43760t((Map) list.get(i), "appletId");
                    this$0.mo43911x().m38185A(jsonGet.m43760t((Map) list.get(i), "id"));
                    WechatUtils.f20152a.m39050a(this$0.mo43926C(), m43760t2, jsonGet.m43760t((Map) list.get(i), "appletPath"));
                    return;
                }
                return;
            case 51:
                if (m43760t.equals("3")) {
                    try {
                        String m43760t3 = jsonGet.m43760t((Map) list.get(i), "jdPath");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("openApp.jdMobile://virtual?params={\"category\":\"jump\",\"des\":\"productDetail\",\"skuId\":\"" + m43760t3 + "\",\"sourceType\":\"JSHOP_SOURCE_TYPE\",\"sourceValue\":\"JSHOP_SOURCE_VALUE\"}"));
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
    /* renamed from: O */
    public static final void m38686O(HomeFragment this$0, List list) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38675k().clear();
        if (list != null) {
            ArrayList<Map<String, Object>> arrayList = new ArrayList();
            for (Object obj : list) {
                if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "isShow"), "1")) {
                    arrayList.add(obj);
                }
            }
            for (Map<String, Object> map : arrayList) {
                this$0.m38675k().add(map);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", "更多");
        linkedHashMap.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.v2_home_menu_more));
        linkedHashMap.put("isEnabled", 1);
        linkedHashMap.put("isLogin", Boolean.FALSE);
        linkedHashMap.put("mkey", "app_home_menu_more");
        this$0.m38675k().add(linkedHashMap);
        BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> m38676j = this$0.m38676j();
        if (m38676j == null) {
            return;
        }
        m38676j.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public static final void m38685P(HomeFragment this$0, String it) {
        String m6568k2;
        C14342f0.m8184p(this$0, "this$0");
        SmartWebView smartWebView = this$0.mo43920M().smartWebView;
        C14342f0.m8185o(it, "it");
        m6568k2 = StringsJVM.m6568k2(it, "${school}", LoggedInUser.f15182b.m43634a().m43646p(), false, 4, null);
        smartWebView.m57493j(m6568k2);
    }

    /* renamed from: m */
    private final void m38673m() {
        this.f20498l = new NativeAd(mo43912w(), "103224", new C5672a(), 5000L, 1);
        float m42793d = UiUtil.m42793d(mo43912w()) - 36;
        NativeAd nativeAd = this.f20498l;
        if (nativeAd == null) {
            return;
        }
        nativeAd.loadAd(m42793d, 180.0f);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m43975d(mo43912w());
        mo43920M().smartWebView.getWebView().addJavascriptInterface(new C5652JS(mo43912w(), mo43920M().smartWebView.getWebView()), "tsn");
        mo43911x().m38178H();
        mo43920M().cpAd.m43732B(C4215R.C4218drawable.v2_dot_white, C4215R.C4218drawable.v2_dot_gey);
        mo43920M().cpAd.setDelay(8000);
        this.f20497k = new HomeFragment$initUiData$1(this, this.f20496j);
        mo43920M().rvMenu.setAdapter(this.f20497k);
        m38674l();
    }

    /* renamed from: Q */
    public final void m38684Q() {
        HomeFragment homeFragment = m43977b() ? this : null;
        if (homeFragment != null) {
            if (!m38675k().isEmpty()) {
                homeFragment = null;
            }
            if (homeFragment != null) {
                mo43911x().m38172N();
            }
        }
        HomeFragment homeFragment2 = m43977b() ? this : null;
        if (homeFragment2 == null) {
            return;
        }
        List<Map<String, Object>> value = mo43911x().m38177I().getValue();
        boolean z = false;
        if (value != null && value.isEmpty()) {
            z = true;
        }
        if ((z ? homeFragment2 : null) == null) {
            return;
        }
        mo43911x().m38178H();
    }

    /* renamed from: R */
    public final void m38683R(@Nullable BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> baseAdapter) {
        this.f20497k = baseAdapter;
    }

    /* renamed from: S */
    public final void m38682S(@NotNull List<Map<String, Object>> list) {
        C14342f0.m8184p(list, "<set-?>");
        this.f20496j = list;
    }

    @Nullable
    /* renamed from: j */
    public final BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> m38676j() {
        return this.f20497k;
    }

    @NotNull
    /* renamed from: k */
    public final List<Map<String, Object>> m38675k() {
        return this.f20496j;
    }

    /* renamed from: l */
    public final void m38674l() {
        HomeFragment homeFragment = m43977b() ? this : null;
        if (homeFragment == null) {
            return;
        }
        if ((LoggedInUser.f15182b.m43634a().m43637y() ? homeFragment : null) == null) {
            return;
        }
        mo43911x().m38156d0();
    }

    @Override // com.bxkj.base.p085v2.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        NativeAd nativeAd = this.f20498l;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m38674l();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m38177I().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m38688H(HomeFragment.this, (List) obj);
            }
        });
        mo43911x().m38171O().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m38686O(HomeFragment.this, (List) obj);
            }
        });
        mo43911x().m38170P().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m38685P(HomeFragment.this, (String) obj);
            }
        });
        mo43911x().m38155e0().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m38689D(HomeFragment.this, (Map) obj);
            }
        });
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, m12616d2 = {"com/bxkj/student/v2/ui/main/HomeFragment$a", "Lcom/beizi/fusion/NativeAdListener;", "", "code", "Lkotlin/f1;", "onAdFailed", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onAdLoaded", "onAdShown", "onAdClosed", IAdInterListener.AdCommandType.AD_CLICK, "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.main.HomeFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5672a implements NativeAdListener {
        C5672a() {
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClick() {
            C11792j.m20466g("BeiZisDemo->Native ad onAdClick", new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClosed() {
            HomeFragment.this.mo43920M().cpAd.m43714p();
            C11792j.m20466g("BeiZisDemo->Native ad onAdClosed", new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdFailed(int i) {
            C11792j.m20466g(C14342f0.m8216C("BeiZisDemo->Native ad onAdFailed ", Integer.valueOf(i)), new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdLoaded(@NotNull View view) {
            C14342f0.m8184p(view, "view");
            C11792j.m20466g("BeiZisDemo->Native ad onAdLoaded", new Object[0]);
            HomeFragment.this.mo43920M().cpAd.m43715o(view);
            HomeFragment.this.mo43920M().cpAd.setWheel(true);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdShown() {
            C11792j.m20466g("BeiZisDemo->Native ad onAdShown", new Object[0]);
        }

        @Override // com.beizi.fusion.NativeAdListener
        public void onAdClosed(@NotNull View view) {
            C14342f0.m8184p(view, "view");
            HomeFragment.this.mo43920M().cpAd.m43714p();
            C11792j.m20466g("BeiZisDemo->Native ad onAdClosed", new Object[0]);
        }
    }
}
