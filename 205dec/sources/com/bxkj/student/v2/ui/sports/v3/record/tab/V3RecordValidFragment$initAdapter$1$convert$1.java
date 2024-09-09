package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.databinding.V3ItemForValidRecordListTraceBinding;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.utils.o;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordValidFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordValidFragment$initAdapter$1$convert$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListTraceBinding;", "itemBinding", "bean", "", "position", "Lkotlin/f1;", "n", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordValidFragment$initAdapter$1$convert$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForValidRecordListTraceBinding> {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ V3RecordValidFragment f24159b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List<Map<String, Object>> f24160c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public V3RecordValidFragment$initAdapter$1$convert$1(V3RecordValidFragment v3RecordValidFragment, List<? extends Map<String, ? extends Object>> list) {
        super(list);
        this.f24159b = v3RecordValidFragment;
        this.f24160c = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(V3RecordValidFragment this$0, Map bean, View view) {
        f0.p(this$0, "this$0");
        f0.p(bean, "$bean");
        this$0.startActivity(new Intent(this$0.C(), V3RecordDetailActivity.class).putExtra("exerciseRecordId", l.f18624a.t(bean, "id")));
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: n */
    public void f(@NotNull V3ItemForValidRecordListTraceBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i4) {
        f0.p(itemBinding, "itemBinding");
        f0.p(bean, "bean");
        l lVar = l.f18624a;
        int k4 = lVar.k(bean, "sportType");
        itemBinding.setSportType(k4);
        ImageView imageView = itemBinding.ivSportsType;
        o.a aVar = o.a;
        imageView.setImageResource(aVar.b(k4));
        itemBinding.tvSportsTypeName.setText(aVar.d(k4));
        itemBinding.tvDistance.setText(e.f18604a.a(lVar.f(bean, "sportRange")));
        itemBinding.tvDuration.setText(i.g(lVar.o(bean, "sportTime")));
        itemBinding.tvStep.setText(String.valueOf(i.t(lVar.t(bean, "stepNumbers"))));
        itemBinding.tvTime.setText(com.bxkj.base.v2.common.utils.d.a(lVar.t(bean, "startTime")));
        View root = itemBinding.getRoot();
        final V3RecordValidFragment v3RecordValidFragment = this.f24159b;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordValidFragment$initAdapter$1$convert$1.o(V3RecordValidFragment.this, bean, view);
            }
        });
    }
}
