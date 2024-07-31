package com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.common.utils.DataFormatUtils;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.V3ItemForValidRecordListTraceBinding;
import com.bxkj.student.p094v2.common.utils.SportsType;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: V3RecordValidFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordValidFragment$initAdapter$1$convert$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListTraceBinding;", "itemBinding", "bean", "", "position", "Lkotlin/f1;", "n", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment$initAdapter$1$convert$1 */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordValidFragment$initAdapter$1$convert$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForValidRecordListTraceBinding> {

    /* renamed from: b */
    final /* synthetic */ V3RecordValidFragment f20740b;

    /* renamed from: c */
    final /* synthetic */ List<Map<String, Object>> f20741c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public V3RecordValidFragment$initAdapter$1$convert$1(V3RecordValidFragment v3RecordValidFragment, List<? extends Map<String, ? extends Object>> list) {
        super(list);
        this.f20740b = v3RecordValidFragment;
        this.f20741c = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static final void m38348o(V3RecordValidFragment this$0, Map bean, View view) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8184p(bean, "$bean");
        this$0.startActivity(new Intent(this$0.mo43926C(), V3RecordDetailActivity.class).putExtra("exerciseRecordId", JsonGet.f15134a.m43760t(bean, "id")));
    }

    @Override // com.bxkj.base.p085v2.base.BaseAdapter
    /* renamed from: n */
    public void mo38351f(@NotNull V3ItemForValidRecordListTraceBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i) {
        C14342f0.m8184p(itemBinding, "itemBinding");
        C14342f0.m8184p(bean, "bean");
        JsonGet jsonGet = JsonGet.f15134a;
        int m43769k = jsonGet.m43769k(bean, "sportType");
        itemBinding.setSportType(m43769k);
        ImageView imageView = itemBinding.ivSportsType;
        SportsType.C5549a c5549a = SportsType.f20137a;
        imageView.setImageResource(c5549a.m39062b(m43769k));
        itemBinding.tvSportsTypeName.setText(c5549a.m39060d(m43769k));
        itemBinding.tvDistance.setText(DecimalFormatUtils.f15114a.m43806a(jsonGet.m43774f(bean, "sportRange")));
        itemBinding.tvDuration.setText(FormatUtils.m39630g(jsonGet.m43765o(bean, "sportTime")));
        itemBinding.tvStep.setText(String.valueOf(FormatUtils.m39617t(jsonGet.m43760t(bean, "stepNumbers"))));
        itemBinding.tvTime.setText(DataFormatUtils.m43808a(jsonGet.m43760t(bean, AnalyticsConfig.RTD_START_TIME)));
        View root = itemBinding.getRoot();
        final V3RecordValidFragment v3RecordValidFragment = this.f20740b;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordValidFragment$initAdapter$1$convert$1.m38348o(V3RecordValidFragment.this, bean, view);
            }
        });
    }
}
