package com.bxkj.student.p094v2.p098ui.main;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebStorage;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.MyImageLoader;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.base.BaseMultiItemAdapter;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.V2MainTabMyFragmentBinding;
import com.bxkj.student.p094v2.common.view.CardListMenuItemDecoration;
import com.bxkj.student.p094v2.p098ui.LoginActivity;
import com.bxkj.student.p094v2.p103vm.MainViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: MyFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR*\u0010\u0013\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/main/MyFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabMyFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "g", "p", "h", "k", "", "", "", "", "j", "Ljava/util/List;", "menuListData", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.MyFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MyFragment extends BaseFragment<V2MainTabMyFragmentBinding, MainViewModel> {
    @NotNull

    /* renamed from: j */
    private final List<Map<String, Object>> f20501j = new ArrayList();
    @Nullable

    /* renamed from: k */
    private BaseMultiItemAdapter<Map<String, Object>> f20502k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.main.MyFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5673a extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {
        C5673a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38654a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            MyFragment.this.mo43911x().m38154f0();
            WebStorage.getInstance().deleteAllData();
            MyFragment.this.startActivity(new Intent(MyFragment.this.mo43912w(), LoginActivity.class));
            MyFragment.this.mo43911x().m38164V().postValue(Boolean.TRUE);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38654a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m38662i(MyFragment this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        Context mo43926C = this$0.mo43926C();
        JsonGet jsonGet = JsonGet.f15134a;
        MyImageLoader.m57719f(mo43926C, jsonGet.m43760t(map, "imageRouteUrl"), this$0.mo43920M().ivHead, C4215R.mipmap.v3_head_icon, C4215R.mipmap.v3_head_icon);
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        c3984b.m43634a().m43663a0(jsonGet.m43760t(map, "nickName"));
        this$0.mo43920M().tvName.setText(c3984b.m43634a().m43640v());
        this$0.mo43920M().tvUserNumber.setText(c3984b.m43634a().m43641u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38661j(MyFragment this$0, List list) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.f20501j.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                ArrayMap arrayMap = new ArrayMap();
                JsonGet jsonGet = JsonGet.f15134a;
                arrayMap.put("name", jsonGet.m43760t(map, "typeName"));
                arrayMap.put("type", 0);
                this$0.f20501j.add(arrayMap);
                List<Map<String, Object>> m43766n = jsonGet.m43766n(map, "menus");
                ArrayList arrayList = new ArrayList();
                for (Object obj : m43766n) {
                    if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                this$0.f20501j.addAll(arrayList);
            }
        }
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter = this$0.f20502k;
        if (baseMultiItemAdapter == null) {
            return;
        }
        baseMultiItemAdapter.notifyDataSetChanged();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m43975d(mo43912w());
        mo43920M().setLoggedInUser(LoggedInUser.f15182b.m43634a());
        mo43920M().setMyFragment(this);
        mo43911x().m38159a0();
        mo43911x().m38163W();
        this.f20502k = new MyFragment$initUiData$1(this, this.f20501j);
        mo43920M().rvMenu.setAdapter(this.f20502k);
        mo43920M().rvMenu.addItemDecoration(new CardListMenuItemDecoration());
    }

    /* renamed from: g */
    public final void m38664g() {
        MyFragment myFragment = m43977b() ? this : null;
        if (myFragment == null) {
            return;
        }
        if ((LoggedInUser.f15182b.m43634a().m43637y() ? myFragment : null) == null) {
            return;
        }
        mo43911x().m38163W();
    }

    /* renamed from: h */
    public final void m38663h() {
        ContextExt.m43856h(mo43912w(), "提示", "确定要退出登录吗?", new C5673a(), null, null, null, 56, null);
    }

    /* renamed from: k */
    public final void m38660k() {
        MyFragment myFragment = this.f20501j.isEmpty() ? this : null;
        if (myFragment == null) {
            return;
        }
        if ((m43977b() ? myFragment : null) == null) {
            return;
        }
        mo43911x().m38159a0();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m38157c0().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyFragment.m38662i(MyFragment.this, (Map) obj);
            }
        });
        mo43911x().m38158b0().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyFragment.m38661j(MyFragment.this, (List) obj);
            }
        });
    }
}
