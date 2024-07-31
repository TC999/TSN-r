package com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.student.databinding.V3FmValidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordVM;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
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

/* compiled from: V3RecordValidFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\fR*\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R2\u0010\u0018\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u001b"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordValidFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmValidRecordListBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lkotlin/f1;", C7304t.f25048d, "k", "j", ExifInterface.LONGITUDE_EAST, "m", "p", "", "I", "pageIndex", "", "", "", "", "Ljava/util/List;", "recordDateList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordValidFragment extends BaseFragment<V3FmValidRecordListBinding, RecordVM> {

    /* renamed from: j */
    private int f20733j = 1;
    @NotNull

    /* renamed from: k */
    private List<Map<String, Object>> f20734k = new ArrayList();
    @Nullable

    /* renamed from: l */
    private BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> f20735l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3RecordValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, m12616d2 = {"", "", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5795a extends Lambda implements InterfaceC15280l<List<Map<String, Object>>, Unit> {
        C5795a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38347a(@NotNull List<Map<String, Object>> it) {
            C14342f0.m8184p(it, "it");
            if (V3RecordValidFragment.this.f20733j == 1) {
                V3RecordValidFragment.this.f20734k.clear();
            }
            V3RecordValidFragment.this.f20734k.addAll(it);
            BaseAdapter baseAdapter = V3RecordValidFragment.this.f20735l;
            if (baseAdapter != null) {
                baseAdapter.m43987l(V3RecordValidFragment.this.f20734k);
            }
            BaseAdapter baseAdapter2 = V3RecordValidFragment.this.f20735l;
            if (baseAdapter2 == null) {
                return;
            }
            baseAdapter2.notifyDataSetChanged();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(List<Map<String, Object>> list) {
            m38347a(list);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3RecordValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5796b extends Lambda implements InterfaceC15269a<Unit> {
        C5796b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            V3RecordValidFragment.this.mo43920M().refresh.mo2078B();
            V3RecordValidFragment.this.mo43920M().refresh.mo2041g();
        }
    }

    /* compiled from: V3RecordValidFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordValidFragment$c", "Ls0/e;", "Lr0/h;", "refreshlayout", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "s", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5797c implements OnRefreshLoadmoreListener {
        C5797c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(@Nullable RefreshLayout refreshLayout) {
            V3RecordValidFragment.this.f20733j = 1;
            V3RecordValidFragment.this.m38360j();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(@Nullable RefreshLayout refreshLayout) {
            V3RecordValidFragment.this.f20733j++;
            V3RecordValidFragment.this.m38360j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public final void m38360j() {
        mo43911x().m37957D("1", this.f20733j, new C5795a(), new C5796b());
    }

    /* renamed from: k */
    private final void m38359k() {
        this.f20735l = new V3RecordValidFragment$initAdapter$1(this, this.f20734k);
        mo43920M().recyclerView.setAdapter(this.f20735l);
        m38360j();
    }

    /* renamed from: l */
    private final void m38358l() {
        mo43920M().refresh.mo2019v(new C5797c());
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m38358l();
        m38359k();
    }

    /* renamed from: m */
    public final void m38357m() {
        mo43920M().refresh.mo2052a0();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
