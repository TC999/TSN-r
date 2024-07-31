package com.bxkj.student.p094v2.p098ui.main;

import android.view.View;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.databinding.V2ItemForHomeMenuBinding;
import com.bxkj.student.p094v2.common.utils.MenuOnclick;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: HomeFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, m12616d2 = {"com/bxkj/student/v2/ui/main/HomeFragment$initUiData$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/V2ItemForHomeMenuBinding;", "itemBinding", "bean", "", "position", "Lkotlin/f1;", "n", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.HomeFragment$initUiData$1 */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class HomeFragment$initUiData$1 extends BaseAdapter<Map<String, ? extends Object>, V2ItemForHomeMenuBinding> {

    /* renamed from: b */
    final /* synthetic */ HomeFragment f20500b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$initUiData$1(HomeFragment homeFragment, List<Map<String, Object>> list) {
        super(list);
        this.f20500b = homeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static final void m38670o(HomeFragment this$0, Map bean, View view) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8184p(bean, "$bean");
        MenuOnclick.f20125a.m39073b(this$0.mo43912w(), bean, "1");
    }

    @Override // com.bxkj.base.p085v2.base.BaseAdapter
    /* renamed from: n */
    public void mo38351f(@NotNull V2ItemForHomeMenuBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i) {
        C14342f0.m8184p(itemBinding, "itemBinding");
        C14342f0.m8184p(bean, "bean");
        itemBinding.setMap(bean);
        itemBinding.setLoggedInUser(LoggedInUser.f15182b.m43634a());
        View root = itemBinding.getRoot();
        final HomeFragment homeFragment = this.f20500b;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment$initUiData$1.m38670o(HomeFragment.this, bean, view);
            }
        });
    }
}
