package com.bxkj.student.v2.ui.main;

import android.view.View;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.student.databinding.V2ItemForHomeMenuBinding;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HomeFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/v2/ui/main/HomeFragment$initUiData$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/V2ItemForHomeMenuBinding;", "itemBinding", "bean", "", "position", "Lkotlin/f1;", "n", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class HomeFragment$initUiData$1 extends BaseAdapter<Map<String, ? extends Object>, V2ItemForHomeMenuBinding> {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HomeFragment f23896b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$initUiData$1(HomeFragment homeFragment, List<Map<String, Object>> list) {
        super(list);
        this.f23896b = homeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(HomeFragment this$0, Map bean, View view) {
        f0.p(this$0, "this$0");
        f0.p(bean, "$bean");
        com.bxkj.student.v2.common.utils.j.f23369a.b(this$0.w(), bean, "1");
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: n */
    public void f(@NotNull V2ItemForHomeMenuBinding itemBinding, @NotNull final Map<String, ? extends Object> bean, int i4) {
        f0.p(itemBinding, "itemBinding");
        f0.p(bean, "bean");
        itemBinding.setMap(bean);
        itemBinding.setLoggedInUser(com.bxkj.base.v2.data.a.f18673h.a());
        View root = itemBinding.getRoot();
        final HomeFragment homeFragment = this.f23896b;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment$initUiData$1.o(HomeFragment.this, bean, view);
            }
        });
    }
}