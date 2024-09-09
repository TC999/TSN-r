package com.bxkj.student.v2.ui.sports.v3.record.tab;

import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.V3FmValidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.v2.vm.sports.record.RecordVM;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
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
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordValidFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR*\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R2\u0010\u0018\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordValidFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V3FmValidRecordListBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lkotlin/f1;", "l", "k", "j", "E", "m", "p", "", "I", "pageIndex", "", "", "", "", "Ljava/util/List;", "recordDateList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordValidFragment extends BaseFragment<V3FmValidRecordListBinding, RecordVM> {

    /* renamed from: j  reason: collision with root package name */
    private int f24152j = 1;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f24153k = new ArrayList();
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> f24154l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, d2 = {"", "", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l<List<Map<String, Object>>, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull List<Map<String, Object>> it) {
            f0.p(it, "it");
            if (V3RecordValidFragment.this.f24152j == 1) {
                V3RecordValidFragment.this.f24153k.clear();
            }
            V3RecordValidFragment.this.f24153k.addAll(it);
            BaseAdapter baseAdapter = V3RecordValidFragment.this.f24154l;
            if (baseAdapter != null) {
                baseAdapter.l(V3RecordValidFragment.this.f24153k);
            }
            BaseAdapter baseAdapter2 = V3RecordValidFragment.this.f24154l;
            if (baseAdapter2 == null) {
                return;
            }
            baseAdapter2.notifyDataSetChanged();
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
    /* compiled from: V3RecordValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l1.a<f1> {
        b() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m80invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m80invoke() {
            V3RecordValidFragment.this.M().refresh.y();
            V3RecordValidFragment.this.M().refresh.h();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordValidFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordValidFragment$c", "Ls0/e;", "Lr0/h;", "refreshlayout", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "s", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c implements e {
        c() {
        }

        @Override // s0.d
        public void q(@Nullable h hVar) {
            V3RecordValidFragment.this.f24152j = 1;
            V3RecordValidFragment.this.j();
        }

        @Override // s0.b
        public void s(@Nullable h hVar) {
            V3RecordValidFragment.this.f24152j++;
            V3RecordValidFragment.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        x().D("1", this.f24152j, new a(), new b());
    }

    private final void k() {
        this.f24154l = new V3RecordValidFragment$initAdapter$1(this, this.f24153k);
        M().recyclerView.setAdapter(this.f24154l);
        j();
    }

    private final void l() {
        M().refresh.n1(new c());
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        l();
        k();
    }

    public final void m() {
        M().refresh.a0();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
