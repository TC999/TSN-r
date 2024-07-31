package com.bxkj.student.p094v2.p098ui.main;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.p085v2.base.BaseMultiItemAdapter;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBinding;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBinding;
import com.bxkj.student.p094v2.common.utils.MenuOnclick;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassifyFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0012"}, m12616d2 = {"com/bxkj/student/v2/ui/main/ClassifyFragment$initUiData$1", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "", "", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/f1;", "onAttachedToRecyclerView", "", "position", "getItemViewType", "itemType", "j", "Landroidx/databinding/ViewDataBinding;", "itemBinding", "bean", "r", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.ClassifyFragment$initUiData$1 */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ClassifyFragment$initUiData$1 extends BaseMultiItemAdapter<Map<String, ? extends Object>> {

    /* renamed from: c */
    final /* synthetic */ ClassifyFragment f20491c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassifyFragment$initUiData$1(ClassifyFragment classifyFragment, List<Map<String, Object>> list) {
        super(list);
        this.f20491c = classifyFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static final void m38700s(Map bean, ClassifyFragment this$0, View view) {
        C14342f0.m8184p(bean, "$bean");
        C14342f0.m8184p(this$0, "this$0");
        if (C14342f0.m8193g(JsonGet.f15134a.m43760t(bean, "type"), "0")) {
            return;
        }
        MenuOnclick.f20125a.m39073b(this$0.mo43912w(), bean, "2");
    }

    @Override // com.bxkj.base.p085v2.base.BaseMultiItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return JsonGet.f15134a.m43768l(m43967i(i), "type", -1);
    }

    @Override // com.bxkj.base.p085v2.base.BaseMultiItemAdapter
    /* renamed from: j */
    public int mo38658j(int i) {
        return i == 0 ? C4215R.C4221layout.v2_item_for_classify_title : C4215R.C4221layout.v2_item_for_classify_menu;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        C14342f0.m8184p(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.bxkj.student.v2.ui.main.ClassifyFragment$initUiData$1$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    return (i < ClassifyFragment$initUiData$1.this.getItemCount() && ClassifyFragment$initUiData$1.this.getItemViewType(i) != 0) ? 1 : 5;
                }
            });
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseMultiItemAdapter
    /* renamed from: r */
    public void mo38659g(@NotNull ViewDataBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i) {
        C14342f0.m8184p(itemBinding, "itemBinding");
        C14342f0.m8184p(bean, "bean");
        String m43760t = JsonGet.f15134a.m43760t(bean, "name");
        View root = itemBinding.getRoot();
        final ClassifyFragment classifyFragment = this.f20491c;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassifyFragment$initUiData$1.m38700s(bean, classifyFragment, view);
            }
        });
        if (getItemViewType(i) == 0) {
            ((V2ItemForClassifyTitleBinding) itemBinding).tvName.setText(m43760t);
        } else {
            ((V2ItemForClassifyMenuBinding) itemBinding).setMap(bean);
        }
    }
}
