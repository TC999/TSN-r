package com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.p094v2.common.utils.SportsType;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.google.android.material.card.MaterialCardView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: V3RecordInValidFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000f"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$initAdapter$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/V3ItemForValidRecordListBinding;", "itemBinding", "", "isExpand", "Lkotlin/f1;", "p", "bean", "", "position", "n", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$initAdapter$1 */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordInValidFragment$initAdapter$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForValidRecordListBinding> {

    /* renamed from: b */
    final /* synthetic */ V3RecordInValidFragment f20730b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V3RecordInValidFragment$initAdapter$1(V3RecordInValidFragment v3RecordInValidFragment, List<Map<String, Object>> list) {
        super(list);
        this.f20730b = v3RecordInValidFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static final void m38371o(Ref.BooleanRef isExpand, V3RecordInValidFragment this$0, String date, List recordList, V3RecordInValidFragment$initAdapter$1 this$1, V3ItemForValidRecordListBinding itemBinding, View view) {
        C14342f0.m8184p(isExpand, "$isExpand");
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8184p(date, "$date");
        C14342f0.m8184p(recordList, "$recordList");
        C14342f0.m8184p(this$1, "this$1");
        C14342f0.m8184p(itemBinding, "$itemBinding");
        isExpand.element = !isExpand.element;
        this$0.mo43911x().m37960A().put(date, Boolean.valueOf(isExpand.element));
        this$0.mo43911x().m37953H(date);
        if (recordList.isEmpty()) {
            this$0.m38375l();
        } else {
            this$1.m38370p(itemBinding, isExpand.element);
        }
    }

    /* renamed from: p */
    private final void m38370p(V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, boolean z) {
        v3ItemForValidRecordListBinding.rvTrace.setVisibility(z ? 0 : 8);
        v3ItemForValidRecordListBinding.ivArrow.setRotation(z ? 180.0f : 0.0f);
    }

    /* renamed from: q */
    static /* synthetic */ void m38369q(V3RecordInValidFragment$initAdapter$1 v3RecordInValidFragment$initAdapter$1, V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        v3RecordInValidFragment$initAdapter$1.m38370p(v3ItemForValidRecordListBinding, z);
    }

    @Override // com.bxkj.base.p085v2.base.BaseAdapter
    /* renamed from: n */
    public void mo38351f(@NotNull final V3ItemForValidRecordListBinding itemBinding, @NotNull Map<String, ? extends Object> bean, int i) {
        C14342f0.m8184p(itemBinding, "itemBinding");
        C14342f0.m8184p(bean, "bean");
        JsonGet jsonGet = JsonGet.f15134a;
        final String m43760t = jsonGet.m43760t(bean, "date");
        itemBinding.tvDate.setText(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(m43760t)));
        itemBinding.tvCountDistance.setText(C14342f0.m8216C(DecimalFormatUtils.f15114a.m43806a(jsonGet.m43774f(bean, "totalRange")), "公里"));
        itemBinding.tvCountTime.setText(FormatUtils.m39630g((long) jsonGet.m43774f(bean, "totalTime")));
        itemBinding.tvCountNumber.setText(C14342f0.m8216C(jsonGet.m43760t(bean, "count"), "次"));
        final List<Map<String, Object>> m43766n = jsonGet.m43766n(this.f20730b.mo43911x().m37956E(), m43760t);
        RecyclerView recyclerView = itemBinding.rvTrace;
        final V3RecordInValidFragment v3RecordInValidFragment = this.f20730b;
        recyclerView.setAdapter(new BaseAdapter<Map<String, ? extends Object>, V3ItemForInvalidRecordListBinding>(m43766n) { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment$initAdapter$1$convert$1

            /* renamed from: c */
            final /* synthetic */ List<Map<String, Object>> f20732c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(m43766n);
                this.f20732c = m43766n;
            }

            @Override // com.bxkj.base.p085v2.base.BaseAdapter
            /* renamed from: m */
            public void mo38351f(@NotNull V3ItemForInvalidRecordListBinding itemBinding2, @NotNull Map<String, ? extends Object> bean2, int i2) {
                C14342f0.m8184p(itemBinding2, "itemBinding");
                C14342f0.m8184p(bean2, "bean");
                itemBinding2.setMActivity(V3RecordInValidFragment.this);
                itemBinding2.setMap(bean2);
                Map<String, ? extends Object> map = itemBinding2.getMap();
                if (map != null) {
                    JsonGet jsonGet2 = JsonGet.f15134a;
                    if (!(jsonGet2.m43760t(map, "sportTypeName").length() == 0)) {
                        map = null;
                    }
                    if (map != null) {
                        map.put("sportTypeName", SportsType.f20137a.m39060d(jsonGet2.m43769k(map, "sportType")));
                    }
                }
                JsonGet jsonGet3 = JsonGet.f15134a;
                if (jsonGet3.m43776d(bean2, "isLocal")) {
                    itemBinding2.btAppeal.setVisibility(0);
                    itemBinding2.btAppeal.setText("立即上传");
                } else if (!TextUtils.isEmpty(jsonGet3.m43760t(bean2, "faceUrl"))) {
                    itemBinding2.btAppeal.setVisibility(0);
                    itemBinding2.btAppeal.setText("核对人脸信息");
                } else {
                    itemBinding2.btAppeal.setVisibility(8);
                }
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean m43775e = jsonGet.m43775e(this.f20730b.mo43911x().m37960A(), m43760t, false);
        booleanRef.element = m43775e;
        m38370p(itemBinding, m43775e);
        MaterialCardView materialCardView = itemBinding.card1;
        final V3RecordInValidFragment v3RecordInValidFragment2 = this.f20730b;
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordInValidFragment$initAdapter$1.m38371o(Ref.BooleanRef.this, v3RecordInValidFragment2, m43760t, m43766n, this, itemBinding, view);
            }
        });
    }
}
