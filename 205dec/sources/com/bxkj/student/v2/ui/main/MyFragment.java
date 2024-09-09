package com.bxkj.student.v2.ui.main;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebStorage;
import androidx.collection.ArrayMap;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.databinding.V2MainTabMyFragmentBinding;
import com.bxkj.student.v2.common.view.CardListMenuItemDecoration;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.MainViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MyFragment.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR*\u0010\u0013\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/bxkj/student/v2/ui/main/MyFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabMyFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "E", "g", "p", "h", "k", "", "", "", "", "j", "Ljava/util/List;", "menuListData", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MyFragment extends BaseFragment<V2MainTabMyFragmentBinding, MainViewModel> {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final List<Map<String, Object>> f23897j = new ArrayList();
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private BaseMultiItemAdapter<Map<String, Object>> f23898k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MyFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class a extends Lambda implements d2.l<iOSTwoButtonDialog, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            MyFragment.this.x().f0();
            WebStorage.getInstance().deleteAllData();
            MyFragment.this.startActivity(new Intent(MyFragment.this.w(), LoginActivity.class));
            MyFragment.this.x().V().postValue(Boolean.TRUE);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MyFragment this$0, Map map) {
        f0.p(this$0, "this$0");
        Context C = this$0.C();
        com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
        cn.bluemobi.dylan.base.utils.o.f(C, mVar.t(map, "imageRouteUrl"), this$0.M().ivHead, 2131559155, 2131559155);
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        bVar.a().s0(mVar.t(map, "nickName"));
        this$0.M().tvName.setText(bVar.a().D());
        this$0.M().tvUserNumber.setText(bVar.a().C());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(MyFragment this$0, List list) {
        f0.p(this$0, "this$0");
        this$0.f23897j.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                ArrayMap arrayMap = new ArrayMap();
                com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
                arrayMap.put("name", mVar.t(map, "typeName"));
                arrayMap.put("type", 0);
                this$0.f23897j.add(arrayMap);
                List n4 = mVar.n(map, "menus");
                ArrayList arrayList = new ArrayList();
                for (Object obj : n4) {
                    if (f0.g(com.bxkj.base.v2.common.utils.m.a.t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                this$0.f23897j.addAll(arrayList);
            }
        }
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter = this$0.f23898k;
        if (baseMultiItemAdapter == null) {
            return;
        }
        baseMultiItemAdapter.notifyDataSetChanged();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        d(w());
        M().setLoggedInUser(com.bxkj.base.v2.data.a.f18673h.a());
        M().setMyFragment(this);
        x().a0();
        x().W();
        this.f23898k = new MyFragment$initUiData$1(this, this.f23897j);
        M().rvMenu.setAdapter(this.f23898k);
        M().rvMenu.addItemDecoration(new CardListMenuItemDecoration());
    }

    public final void g() {
        MyFragment myFragment = b() ? this : null;
        if (myFragment == null) {
            return;
        }
        if ((com.bxkj.base.v2.data.a.f18673h.a().G() ? myFragment : null) == null) {
            return;
        }
        x().W();
    }

    public final void h() {
        ContextExtKt.h(w(), "\u63d0\u793a", "\u786e\u5b9a\u8981\u9000\u51fa\u767b\u5f55\u5417?", new a(), (d2.l) null, (CharSequence) null, (CharSequence) null, 56, (Object) null);
    }

    public final void k() {
        MyFragment myFragment = this.f23897j.isEmpty() ? this : null;
        if (myFragment == null) {
            return;
        }
        if ((b() ? myFragment : null) == null) {
            return;
        }
        x().a0();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().c0().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyFragment.i(MyFragment.this, (Map) obj);
            }
        });
        x().b0().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyFragment.j(MyFragment.this, (List) obj);
            }
        });
    }
}
