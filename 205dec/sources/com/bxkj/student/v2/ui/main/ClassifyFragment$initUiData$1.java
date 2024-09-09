package com.bxkj.student.v2.ui.main;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBinding;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBinding;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ClassifyFragment.kt */
@Metadata(bv = {}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0012"}, d2 = {"com/bxkj/student/v2/ui/main/ClassifyFragment$initUiData$1", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "", "", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/f1;", "onAttachedToRecyclerView", "", "position", "getItemViewType", "itemType", "j", "Landroidx/databinding/ViewDataBinding;", "itemBinding", "bean", "r", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ClassifyFragment$initUiData$1 extends BaseMultiItemAdapter<Map<String, ? extends Object>> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ClassifyFragment f23883c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassifyFragment$initUiData$1(ClassifyFragment classifyFragment, List<Map<String, Object>> list) {
        super(list);
        this.f23883c = classifyFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Map bean, ClassifyFragment this$0, View view) {
        f0.p(bean, "$bean");
        f0.p(this$0, "this$0");
        if (f0.g(com.bxkj.base.v2.common.utils.m.a.t(bean, "type"), "0")) {
            return;
        }
        com.bxkj.student.v2.common.utils.j.f23369a.b(this$0.w(), bean, "2");
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return com.bxkj.base.v2.common.utils.m.a.l(i(i4), "type", -1);
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    public int j(int i4) {
        return i4 == 0 ? 2131428110 : 2131428109;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        f0.p(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.bxkj.student.v2.ui.main.ClassifyFragment$initUiData$1$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i4) {
                    return (i4 < ClassifyFragment$initUiData$1.this.getItemCount() && ClassifyFragment$initUiData$1.this.getItemViewType(i4) != 0) ? 1 : 5;
                }
            });
        }
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    /* renamed from: r */
    public void g(@NotNull ViewDataBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i4) {
        f0.p(itemBinding, "itemBinding");
        f0.p(bean, "bean");
        String t3 = com.bxkj.base.v2.common.utils.m.a.t(bean, "name");
        View root = itemBinding.getRoot();
        final ClassifyFragment classifyFragment = this.f23883c;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassifyFragment$initUiData$1.s(bean, classifyFragment, view);
            }
        });
        if (getItemViewType(i4) == 0) {
            ((V2ItemForClassifyTitleBinding) itemBinding).tvName.setText(t3);
        } else {
            ((V2ItemForClassifyMenuBinding) itemBinding).setMap(bean);
        }
    }
}
