package com.bxkj.student.v2.ui.main;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBinding;
import com.bxkj.student.databinding.V2ItemForMyMenuBinding;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MyFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"com/bxkj/student/v2/ui/main/MyFragment$initUiData$1", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "", "", "", "", "position", "getItemViewType", "itemType", "j", "Landroidx/databinding/ViewDataBinding;", "itemBinding", "bean", "Lkotlin/f1;", "r", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MyFragment$initUiData$1 extends BaseMultiItemAdapter<Map<String, ? extends Object>> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MyFragment f23900c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFragment$initUiData$1(MyFragment myFragment, List<Map<String, Object>> list) {
        super(list);
        this.f23900c = myFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MyFragment this$0, Map bean, View view) {
        f0.p(this$0, "this$0");
        f0.p(bean, "$bean");
        com.bxkj.student.v2.common.utils.j.f23369a.b(this$0.w(), bean, "5");
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return com.bxkj.base.v2.common.utils.m.a.l(i(i4), "type", -1);
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    public int j(int i4) {
        return i4 == 0 ? 2131428110 : 2131428112;
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    /* renamed from: r */
    public void g(@NotNull ViewDataBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i4) {
        f0.p(itemBinding, "itemBinding");
        f0.p(bean, "bean");
        com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
        String t3 = mVar.t(bean, "name");
        mVar.t(bean, "mkey");
        if (getItemViewType(i4) == 0) {
            ((V2ItemForClassifyTitleBinding) itemBinding).tvName.setText(t3);
            return;
        }
        V2ItemForMyMenuBinding v2ItemForMyMenuBinding = (V2ItemForMyMenuBinding) itemBinding;
        v2ItemForMyMenuBinding.setMap(bean);
        View root = v2ItemForMyMenuBinding.getRoot();
        final MyFragment myFragment = this.f23900c;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFragment$initUiData$1.s(MyFragment.this, bean, view);
            }
        });
    }
}
