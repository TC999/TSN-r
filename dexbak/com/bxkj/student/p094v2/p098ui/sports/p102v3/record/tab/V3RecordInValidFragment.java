package com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.V3FmInvalidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.utils.H5Utils;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordVM;
import com.google.android.material.tabs.TabLayout;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* compiled from: V3RecordInValidFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fJ\u001c\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R*\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00190\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR2\u0010\u001f\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001e¨\u0006\""}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmInvalidRecordListBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lkotlin/f1;", "N", "H", "D", C7304t.f25048d, ExifInterface.LONGITUDE_EAST, "O", "p", "", "", "", "map", "m", "k", "j", "Ljava/lang/String;", "currentStatus", "", "I", "pageIndex", "", "", "Ljava/util/List;", "recordDateList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordInValidFragment extends BaseFragment<V3FmInvalidRecordListBinding, RecordVM> {
    @NotNull

    /* renamed from: j */
    private String f20721j = "0";

    /* renamed from: k */
    private int f20722k = 1;
    @NotNull

    /* renamed from: l */
    private List<Map<String, Object>> f20723l = new ArrayList();
    @Nullable

    /* renamed from: m */
    private BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> f20724m;

    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, m12616d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5790a extends Lambda implements InterfaceC15280l<String, Unit> {
        C5790a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38367a(@Nullable String str) {
            Context mo43926C = V3RecordInValidFragment.this.mo43926C();
            if (str == null) {
                str = "上传成功";
            }
            ContextExt.m43847q(mo43926C, str);
            SportsDataAgent.f19899a.m39277b0(false);
            V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) AppManager.m57776n().getActivity(V3SportsHomeActivity.class);
            if (v3SportsHomeActivity != null) {
                v3SportsHomeActivity.m38498t0();
            }
            V3RecordInValidFragment.this.m38383O();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            m38367a(str);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, m12616d2 = {"", "", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5791b extends Lambda implements InterfaceC15280l<List<Map<String, Object>>, Unit> {
        C5791b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38366a(@NotNull List<Map<String, Object>> it) {
            C14342f0.m8184p(it, "it");
            if (V3RecordInValidFragment.this.f20722k == 1) {
                V3RecordInValidFragment.this.f20723l.clear();
            }
            V3RecordInValidFragment.this.f20723l.addAll(it);
            BaseAdapter baseAdapter = V3RecordInValidFragment.this.f20724m;
            if (baseAdapter == null) {
                return;
            }
            baseAdapter.notifyDataSetChanged();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(List<Map<String, Object>> list) {
            m38366a(list);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5792c extends Lambda implements InterfaceC15269a<Unit> {
        C5792c() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            V3RecordInValidFragment.this.mo43920M().refresh.mo2078B();
            V3RecordInValidFragment.this.mo43920M().refresh.mo2041g();
        }
    }

    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$d", "Ls0/e;", "Lr0/h;", "refreshlayout", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "s", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5793d implements OnRefreshLoadmoreListener {
        C5793d() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(@Nullable RefreshLayout refreshLayout) {
            V3RecordInValidFragment.this.f20722k = 1;
            V3RecordInValidFragment.this.m38375l();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(@Nullable RefreshLayout refreshLayout) {
            V3RecordInValidFragment.this.f20722k++;
            V3RecordInValidFragment.this.m38375l();
        }
    }

    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$e", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lkotlin/f1;", "onTabSelected", "onTabUnselected", "onTabReselected", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5794e implements TabLayout.OnTabSelectedListener {
        C5794e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (tab != null) {
                int position = tab.getPosition();
                if (position == 0) {
                    V3RecordInValidFragment.this.f20721j = "0";
                } else if (position == 1) {
                    V3RecordInValidFragment.this.f20721j = "2";
                } else if (position == 2) {
                    V3RecordInValidFragment.this.f20721j = "-1";
                }
                V3RecordInValidFragment.this.mo43920M().refresh.mo2052a0();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    /* renamed from: D */
    private final void m38386D() {
        this.f20724m = new V3RecordInValidFragment$initAdapter$1(this, this.f20723l);
        mo43920M().recyclerView.setAdapter(this.f20724m);
        m38375l();
    }

    /* renamed from: H */
    private final void m38385H() {
        mo43920M().refresh.mo2019v(new C5793d());
    }

    /* renamed from: N */
    private final void m38384N() {
        mo43920M().f16286tb.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C5794e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final void m38375l() {
        mo43911x().m37957D(this.f20721j, this.f20722k, new C5791b(), new C5792c());
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m38384N();
        m38385H();
        m38386D();
    }

    /* renamed from: O */
    public final void m38383O() {
        mo43920M().refresh.mo2052a0();
    }

    /* renamed from: k */
    public final void m38376k(@NotNull Map<String, ? extends Object> map) {
        C14342f0.m8184p(map, "map");
        JsonGet jsonGet = JsonGet.f15134a;
        if (!TextUtils.isEmpty(jsonGet.m43760t(map, "faceUrl"))) {
            H5Utils h5Utils = H5Utils.f20124a;
            FragmentActivity mo43912w = mo43912w();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", "核对人脸信息");
            linkedHashMap.put("linkUrl", jsonGet.m43760t(map, "faceUrl"));
            Unit unit = Unit.f41048a;
            h5Utils.m39075b(mo43912w, linkedHashMap);
            return;
        }
        mo43911x().m37950K(jsonGet.m43760t(map, "identify"), new C5790a());
    }

    /* renamed from: m */
    public final void m38374m(@NotNull Map<String, ? extends Object> map) {
        C14342f0.m8184p(map, "map");
        JsonGet jsonGet = JsonGet.f15134a;
        if (jsonGet.m43776d(map, "isLocal")) {
            startActivity(new Intent(mo43926C(), V3RecordDetailActivity.class).putExtra("identify", jsonGet.m43760t(map, "identify")));
        } else {
            startActivity(new Intent(mo43926C(), V3RecordDetailActivity.class).putExtra("exerciseRecordId", jsonGet.m43760t(map, "id")));
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
