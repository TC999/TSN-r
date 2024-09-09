package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.databinding.V3FmInvalidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.vm.sports.record.RecordVM;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordInValidFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fJ\u001c\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R*\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00190\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR2\u0010\u001f\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmInvalidRecordListBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lkotlin/f1;", "N", "H", "D", "l", "E", "O", "p", "", "", "", "map", "m", "k", "j", "Ljava/lang/String;", "currentStatus", "", "I", "pageIndex", "", "", "Ljava/util/List;", "recordDateList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordInValidFragment extends BaseFragment<V3FmInvalidRecordListBinding, RecordVM> {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private String f24140j = "0";

    /* renamed from: k  reason: collision with root package name */
    private int f24141k = 1;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private List<Map<String, Object>> f24142l = new ArrayList();
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> f24143m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l<String, f1> {
        a() {
            super(1);
        }

        public final void a(@Nullable String str) {
            Context C = V3RecordInValidFragment.this.C();
            if (str == null) {
                str = "\u4e0a\u4f20\u6210\u529f";
            }
            ContextExtKt.q(C, str);
            com.bxkj.student.v2.common.data.b.a.b0(false);
            V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsHomeActivity.class);
            if (v3SportsHomeActivity != null) {
                v3SportsHomeActivity.t0();
            }
            V3RecordInValidFragment.this.O();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(String str) {
            a(str);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, d2 = {"", "", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l<List<Map<String, Object>>, f1> {
        b() {
            super(1);
        }

        public final void a(@NotNull List<Map<String, Object>> it) {
            f0.p(it, "it");
            if (V3RecordInValidFragment.this.f24141k == 1) {
                V3RecordInValidFragment.this.f24142l.clear();
            }
            V3RecordInValidFragment.this.f24142l.addAll(it);
            BaseAdapter baseAdapter = V3RecordInValidFragment.this.f24143m;
            if (baseAdapter == null) {
                return;
            }
            baseAdapter.notifyDataSetChanged();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(List<Map<String, Object>> list) {
            a(list);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends Lambda implements l1.a<f1> {
        c() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m79invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m79invoke() {
            V3RecordInValidFragment.this.M().refresh.y();
            V3RecordInValidFragment.this.M().refresh.h();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$d", "Ls0/e;", "Lr0/h;", "refreshlayout", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "s", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d implements s0.e {
        d() {
        }

        @Override // s0.d
        public void q(@Nullable h hVar) {
            V3RecordInValidFragment.this.f24141k = 1;
            V3RecordInValidFragment.this.l();
        }

        @Override // s0.b
        public void s(@Nullable h hVar) {
            V3RecordInValidFragment.this.f24141k++;
            V3RecordInValidFragment.this.l();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordInValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$e", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lkotlin/f1;", "onTabSelected", "onTabUnselected", "onTabReselected", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (tab != null) {
                int position = tab.getPosition();
                if (position == 0) {
                    V3RecordInValidFragment.this.f24140j = "0";
                } else if (position == 1) {
                    V3RecordInValidFragment.this.f24140j = "2";
                } else if (position == 2) {
                    V3RecordInValidFragment.this.f24140j = "-1";
                }
                V3RecordInValidFragment.this.M().refresh.a0();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    private final void D() {
        this.f24143m = new V3RecordInValidFragment$initAdapter$1(this, this.f24142l);
        M().recyclerView.setAdapter(this.f24143m);
        l();
    }

    private final void H() {
        M().refresh.n1(new d());
    }

    private final void N() {
        M().tb.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        x().D(this.f24140j, this.f24141k, new b(), new c());
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        N();
        H();
        D();
    }

    public final void O() {
        M().refresh.a0();
    }

    public final void k(@NotNull Map<String, ? extends Object> map) {
        f0.p(map, "map");
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        if (!TextUtils.isEmpty(lVar.t(map, "faceUrl"))) {
            i iVar = i.f23368a;
            FragmentActivity w3 = w();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", "\u6838\u5bf9\u4eba\u8138\u4fe1\u606f");
            linkedHashMap.put("linkUrl", lVar.t(map, "faceUrl"));
            f1 f1Var = f1.f55527a;
            iVar.b(w3, linkedHashMap);
            return;
        }
        x().K(lVar.t(map, "identify"), new a());
    }

    public final void m(@NotNull Map<String, ? extends Object> map) {
        f0.p(map, "map");
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        if (lVar.d(map, "isLocal")) {
            startActivity(new Intent(C(), V3RecordDetailActivity.class).putExtra("identify", lVar.t(map, "identify")));
        } else {
            startActivity(new Intent(C(), V3RecordDetailActivity.class).putExtra("exerciseRecordId", lVar.t(map, "id")));
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
