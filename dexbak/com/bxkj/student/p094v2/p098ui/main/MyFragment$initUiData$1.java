package com.bxkj.student.p094v2.p098ui.main;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.p085v2.base.BaseMultiItemAdapter;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBinding;
import com.bxkj.student.databinding.V2ItemForMyMenuBinding;
import com.bxkj.student.p094v2.common.utils.MenuOnclick;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: MyFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, m12616d2 = {"com/bxkj/student/v2/ui/main/MyFragment$initUiData$1", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "", "", "", "", "position", "getItemViewType", "itemType", "j", "Landroidx/databinding/ViewDataBinding;", "itemBinding", "bean", "Lkotlin/f1;", "r", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.MyFragment$initUiData$1 */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MyFragment$initUiData$1 extends BaseMultiItemAdapter<Map<String, ? extends Object>> {

    /* renamed from: c */
    final /* synthetic */ MyFragment f20504c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFragment$initUiData$1(MyFragment myFragment, List<Map<String, Object>> list) {
        super(list);
        this.f20504c = myFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static final void m38655s(MyFragment this$0, Map bean, View view) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8184p(bean, "$bean");
        MenuOnclick.f20125a.m39073b(this$0.mo43912w(), bean, "5");
    }

    @Override // com.bxkj.base.p085v2.base.BaseMultiItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return JsonGet.f15134a.m43768l(m43967i(i), "type", -1);
    }

    @Override // com.bxkj.base.p085v2.base.BaseMultiItemAdapter
    /* renamed from: j */
    public int mo38658j(int i) {
        return i == 0 ? C4215R.C4221layout.v2_item_for_classify_title : C4215R.C4221layout.v2_item_for_my_menu;
    }

    @Override // com.bxkj.base.p085v2.base.BaseMultiItemAdapter
    /* renamed from: r */
    public void mo38659g(@NotNull ViewDataBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i) {
        C14342f0.m8184p(itemBinding, "itemBinding");
        C14342f0.m8184p(bean, "bean");
        JsonGet jsonGet = JsonGet.f15134a;
        String m43760t = jsonGet.m43760t(bean, "name");
        jsonGet.m43760t(bean, "mkey");
        if (getItemViewType(i) == 0) {
            ((V2ItemForClassifyTitleBinding) itemBinding).tvName.setText(m43760t);
            return;
        }
        V2ItemForMyMenuBinding v2ItemForMyMenuBinding = (V2ItemForMyMenuBinding) itemBinding;
        v2ItemForMyMenuBinding.setMap(bean);
        View root = v2ItemForMyMenuBinding.getRoot();
        final MyFragment myFragment = this.f20504c;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFragment$initUiData$1.m38655s(MyFragment.this, bean, view);
            }
        });
    }
}
