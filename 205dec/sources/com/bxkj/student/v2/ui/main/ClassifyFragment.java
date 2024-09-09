package com.bxkj.student.v2.ui.main;

import android.animation.ObjectAnimator;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.lifecycle.Observer;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBinding;
import com.bxkj.student.databinding.V2MainTabClassifyFragmentBinding;
import com.bxkj.student.v2.common.view.CardGridMenuItemDecoration;
import com.bxkj.student.v2.vm.MainViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ClassifyFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR(\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR*\u0010\u0014\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R>\u0010\u001c\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0017\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/bxkj/student/v2/ui/main/ClassifyFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabClassifyFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "k", "l", "E", "p", "D", "j", "", "", "", "", "Ljava/util/List;", "menuListData", "homeMenuList", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "adapter", "Lcom/bxkj/base/v2/base/BaseAdapter;", "Lcom/bxkj/student/databinding/V2ItemForClassifyMenuBinding;", "m", "Lcom/bxkj/base/v2/base/BaseAdapter;", "g", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "homeMenuAdapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ClassifyFragment extends BaseFragment<V2MainTabClassifyFragmentBinding, MainViewModel> {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final List<Map<String, Object>> f23879j = new ArrayList();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final List<Map<String, Object>> f23880k = new ArrayList();
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private BaseMultiItemAdapter<Map<String, Object>> f23881l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> f23882m;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ClassifyFragment this$0, List list) {
        Integer valueOf;
        f0.p(this$0, "this$0");
        this$0.f23880k.clear();
        if (list == null) {
            valueOf = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (f0.g(com.bxkj.base.v2.common.utils.m.a.t((Map) obj, "isShow"), "1")) {
                    arrayList.add(obj);
                }
            }
            valueOf = Integer.valueOf(arrayList.size());
        }
        TextView textView = this$0.M().tvHomeMenuCount;
        textView.setText("\u5df2\u6536\u8d77" + valueOf + "\u4e2a\u5e94\u7528");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ClassifyFragment this$0, List list) {
        f0.p(this$0, "this$0");
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter = this$0.f23881l;
        if (baseMultiItemAdapter != null) {
            baseMultiItemAdapter.notifyItemRangeRemoved(0, this$0.f23879j.size());
        }
        this$0.f23879j.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                ArrayMap arrayMap = new ArrayMap();
                com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
                arrayMap.put("name", mVar.t(map, "typeName"));
                arrayMap.put("type", 0);
                this$0.f23879j.add(arrayMap);
                List n4 = mVar.n(map, "menus");
                ArrayList arrayList = new ArrayList();
                for (Object obj : n4) {
                    if (f0.g(com.bxkj.base.v2.common.utils.m.a.t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                this$0.f23879j.addAll(arrayList);
            }
        }
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter2 = this$0.f23881l;
        if (baseMultiItemAdapter2 == null) {
            return;
        }
        baseMultiItemAdapter2.notifyItemRangeInserted(0, this$0.f23879j.size());
    }

    private final void k() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(M().tvHomeMenuArrow, "rotation", 0.0f, 90.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(M().tvHomeMenuArrow, "rotation", 90.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    public final void D() {
        BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter = this.f23882m;
        boolean z3 = false;
        if (baseAdapter != null && baseAdapter.getItemCount() == 0) {
            z3 = true;
        }
        if (z3) {
            List<Map<String, Object>> value = x().O().getValue();
            if (value != null) {
                ArrayList<Map<String, Object>> arrayList = new ArrayList();
                for (Object obj : value) {
                    if (f0.g(com.bxkj.base.v2.common.utils.m.a.t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                for (Map<String, Object> map : arrayList) {
                    this.f23880k.add(map);
                }
            }
            k();
        } else {
            this.f23880k.clear();
            l();
        }
        BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter2 = this.f23882m;
        if (baseAdapter2 == null) {
            return;
        }
        baseAdapter2.notifyDataSetChanged();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        d(w());
        M().setClassifyFragment(this);
        this.f23881l = new ClassifyFragment$initUiData$1(this, this.f23879j);
        M().rvMenu.setAdapter(this.f23881l);
        M().rvMenu.addItemDecoration(new CardGridMenuItemDecoration());
        x().K();
        this.f23882m = new ClassifyFragment$initUiData$2(this, this.f23880k);
        M().rvHomeMenu.setAdapter(this.f23882m);
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> g() {
        return this.f23882m;
    }

    public final void j() {
        ClassifyFragment classifyFragment = this.f23879j.isEmpty() ? this : null;
        if (classifyFragment == null) {
            return;
        }
        if ((b() ? classifyFragment : null) == null) {
            return;
        }
        x().K();
    }

    public final void m(@Nullable BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter) {
        this.f23882m = baseAdapter;
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().O().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassifyFragment.h(ClassifyFragment.this, (List) obj);
            }
        });
        x().L().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassifyFragment.i(ClassifyFragment.this, (List) obj);
            }
        });
    }
}
