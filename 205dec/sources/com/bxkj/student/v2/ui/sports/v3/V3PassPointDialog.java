package com.bxkj.student.v2.ui.sports.v3;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBinding;
import com.bxkj.student.databinding.V3PassPointDialogBinding;
import com.bxkj.student.v2.vm.sports.SportsVM;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3PassPointDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R+\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R>\u0010\u001d\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3PassPointDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/V3PassPointDialogBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", "l", "i", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "E", "p", "", "", "", "", "Ljava/util/List;", "k", "()Ljava/util/List;", "dataList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "Lcom/bxkj/student/databinding/ItemForV3PassPointDialogBinding;", "j", "Lcom/bxkj/base/v2/base/BaseAdapter;", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "m", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "adapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3PassPointDialog extends BaseDialog<V3PassPointDialogBinding, SportsVM> {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final List<Map<String, Object>> f23956i = new ArrayList();
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> f23957j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
            g4 = kotlin.comparisons.b.g(Integer.valueOf(lVar.k((Map) t3, "sort")), Integer.valueOf(lVar.k((Map) t4, "sort")));
            return g4;
        }
    }

    private final void i() {
        List<Map<String, Object>> n4 = com.bxkj.base.v2.common.utils.l.f18624a.n(x().B(), "list");
        List<Map<String, Object>> s3 = com.bxkj.student.v2.common.data.b.a.s();
        ArrayList arrayList = new ArrayList(v.Y(s3, 10));
        Iterator<T> it = s3.iterator();
        while (it.hasNext()) {
            arrayList.add(com.bxkj.base.v2.common.utils.l.f18624a.t((Map) it.next(), "id"));
        }
        Set N5 = v.N5(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : n4) {
            if (!N5.contains(com.bxkj.base.v2.common.utils.l.f18624a.t((Map) obj, "id"))) {
                arrayList2.add(obj);
            }
        }
        for (Map<String, ? extends Object> map : v.h5(arrayList2, new a())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
            linkedHashMap.put("sort", lVar.t(map, "sort"));
            linkedHashMap.put("name", lVar.t(map, "content"));
            k().add(linkedHashMap);
        }
        BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter = this.f23957j;
        if (baseAdapter == null) {
            return;
        }
        baseAdapter.notifyDataSetChanged();
    }

    private final void l() {
        final List<Map<String, Object>> list = this.f23956i;
        this.f23957j = new BaseAdapter<Map<String, ? extends Object>, ItemForV3PassPointDialogBinding>(list) { // from class: com.bxkj.student.v2.ui.sports.v3.V3PassPointDialog$initAdapter$1
            @Override // com.bxkj.base.v2.base.BaseAdapter
            /* renamed from: m */
            public void f(@NotNull ItemForV3PassPointDialogBinding itemBinding, @NotNull Map<String, ? extends Object> bean, int i4) {
                f0.p(itemBinding, "itemBinding");
                f0.p(bean, "bean");
                com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                if (lVar.k(V3PassPointDialog.this.x().B(), "isSequencePoint") == 1) {
                    itemBinding.ivPoint.setImageBitmap(com.bxkj.student.v2.common.utils.e.f23349a.a(lVar.t(bean, "sort")));
                } else {
                    itemBinding.ivPoint.setImageBitmap(com.bxkj.student.v2.common.utils.e.f23349a.a("\u7ecf"));
                }
                itemBinding.tvPoint.setText(lVar.t(bean, "name"));
            }
        };
        M().rv.setAdapter(this.f23957j);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        x().G(com.bxkj.student.v2.common.data.b.a.v());
        M().setDialog(this);
        i();
        l();
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> j() {
        return this.f23957j;
    }

    @NotNull
    public final List<Map<String, Object>> k() {
        return this.f23956i;
    }

    public final void m(@Nullable BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter) {
        this.f23957j = baseAdapter;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131886649);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(2131034508);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
