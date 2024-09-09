package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.utils.o;
import com.google.android.material.card.MaterialCardView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordInValidFragment.kt */
@Metadata(bv = {}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$initAdapter$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListBinding;", "itemBinding", "", "isExpand", "Lkotlin/f1;", "p", "bean", "", "position", "n", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordInValidFragment$initAdapter$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForValidRecordListBinding> {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ V3RecordInValidFragment f24149b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V3RecordInValidFragment$initAdapter$1(V3RecordInValidFragment v3RecordInValidFragment, List<Map<String, Object>> list) {
        super(list);
        this.f24149b = v3RecordInValidFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Ref.BooleanRef isExpand, V3RecordInValidFragment this$0, String date, List recordList, V3RecordInValidFragment$initAdapter$1 this$1, V3ItemForValidRecordListBinding itemBinding, View view) {
        f0.p(isExpand, "$isExpand");
        f0.p(this$0, "this$0");
        f0.p(date, "$date");
        f0.p(recordList, "$recordList");
        f0.p(this$1, "this$1");
        f0.p(itemBinding, "$itemBinding");
        isExpand.element = !isExpand.element;
        this$0.x().A().put(date, Boolean.valueOf(isExpand.element));
        this$0.x().H(date);
        if (recordList.isEmpty()) {
            this$0.l();
        } else {
            this$1.p(itemBinding, isExpand.element);
        }
    }

    private final void p(V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, boolean z3) {
        v3ItemForValidRecordListBinding.rvTrace.setVisibility(z3 ? 0 : 8);
        v3ItemForValidRecordListBinding.ivArrow.setRotation(z3 ? 180.0f : 0.0f);
    }

    static /* synthetic */ void q(V3RecordInValidFragment$initAdapter$1 v3RecordInValidFragment$initAdapter$1, V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        v3RecordInValidFragment$initAdapter$1.p(v3ItemForValidRecordListBinding, z3);
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: n */
    public void f(@NotNull final V3ItemForValidRecordListBinding itemBinding, @NotNull Map<String, ? extends Object> bean, int i4) {
        f0.p(itemBinding, "itemBinding");
        f0.p(bean, "bean");
        l lVar = l.f18624a;
        final String t3 = lVar.t(bean, "date");
        itemBinding.tvDate.setText(new SimpleDateFormat("yyyy\u5e74MM\u6708").format(new SimpleDateFormat("yyyy-MM").parse(t3)));
        itemBinding.tvCountDistance.setText(f0.C(e.f18604a.a(lVar.f(bean, "totalRange")), "\u516c\u91cc"));
        itemBinding.tvCountTime.setText(i.g((long) lVar.f(bean, "totalTime")));
        itemBinding.tvCountNumber.setText(f0.C(lVar.t(bean, "count"), "\u6b21"));
        final List<Map<String, Object>> n4 = lVar.n(this.f24149b.x().E(), t3);
        RecyclerView recyclerView = itemBinding.rvTrace;
        final V3RecordInValidFragment v3RecordInValidFragment = this.f24149b;
        recyclerView.setAdapter(new BaseAdapter<Map<String, ? extends Object>, V3ItemForInvalidRecordListBinding>(n4) { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$initAdapter$1$convert$1

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ List<Map<String, Object>> f24151c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(n4);
                this.f24151c = n4;
            }

            @Override // com.bxkj.base.v2.base.BaseAdapter
            /* renamed from: m */
            public void f(@NotNull V3ItemForInvalidRecordListBinding itemBinding2, @NotNull Map<String, ? extends Object> bean2, int i5) {
                f0.p(itemBinding2, "itemBinding");
                f0.p(bean2, "bean");
                itemBinding2.setMActivity(V3RecordInValidFragment.this);
                itemBinding2.setMap(bean2);
                Map<String, ? extends Object> map = itemBinding2.getMap();
                if (map != null) {
                    l lVar2 = l.f18624a;
                    if (!(lVar2.t(map, "sportTypeName").length() == 0)) {
                        map = null;
                    }
                    if (map != null) {
                        map.put("sportTypeName", o.a.d(lVar2.k(map, "sportType")));
                    }
                }
                l lVar3 = l.f18624a;
                if (lVar3.d(bean2, "isLocal")) {
                    itemBinding2.btAppeal.setVisibility(0);
                    itemBinding2.btAppeal.setText("\u7acb\u5373\u4e0a\u4f20");
                } else if (!TextUtils.isEmpty(lVar3.t(bean2, "faceUrl"))) {
                    itemBinding2.btAppeal.setVisibility(0);
                    itemBinding2.btAppeal.setText("\u6838\u5bf9\u4eba\u8138\u4fe1\u606f");
                } else {
                    itemBinding2.btAppeal.setVisibility(8);
                }
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean e4 = lVar.e(this.f24149b.x().A(), t3, false);
        booleanRef.element = e4;
        p(itemBinding, e4);
        MaterialCardView materialCardView = itemBinding.card1;
        final V3RecordInValidFragment v3RecordInValidFragment2 = this.f24149b;
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordInValidFragment$initAdapter$1.o(Ref.BooleanRef.this, v3RecordInValidFragment2, t3, n4, this, itemBinding, view);
            }
        });
    }
}
