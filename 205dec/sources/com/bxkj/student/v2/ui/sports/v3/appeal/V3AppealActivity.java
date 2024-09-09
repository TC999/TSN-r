package com.bxkj.student.v2.ui.sports.v3.appeal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.adapter.c;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.k;
import com.bxkj.student.databinding.AcV3SportsAppealBinding;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment;
import com.bxkj.student.v2.vm.sports.appeal.AppealVM;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.text.x;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3AppealActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/appeal/V3AppealActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsAppealBinding;", "Lcom/bxkj/student/v2/vm/sports/appeal/AppealVM;", "Lkotlin/f1;", "E", "p", "", "", "i", "Ljava/util/List;", "paths", "Lcn/bluemobi/dylan/base/adapter/c;", "j", "Lcn/bluemobi/dylan/base/adapter/c;", "gridViewAddImagesAdapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3AppealActivity extends BaseActivity<AcV3SportsAppealBinding, AppealVM> {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f24079i = new ArrayList();
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private c f24080j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3AppealActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l<File, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull File it) {
            f0.p(it, "it");
            List list = V3AppealActivity.this.f24079i;
            String path = it.getPath();
            f0.o(path, "it.path");
            list.add(path);
            c cVar = V3AppealActivity.this.f24080j;
            f0.m(cVar);
            cVar.c(V3AppealActivity.this.f24079i);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(File file) {
            a(file);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3AppealActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l<String, f1> {
        b() {
            super(1);
        }

        public final void a(@Nullable String str) {
            if (str == null) {
                str = "\u7533\u8bc9\u63d0\u4ea4\u6210\u529f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85\u5ba1\u6838";
            }
            ContextExtKt.q(V3AppealActivity.this, str);
            H5AppActivity h5AppActivity = (H5AppActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(H5AppActivity.class);
            if (h5AppActivity != null) {
                h5AppActivity.O();
            }
            V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsHomeActivity.class);
            if (v3SportsHomeActivity != null) {
                v3SportsHomeActivity.t0();
            }
            V3RecordDetailActivity v3RecordDetailActivity = (V3RecordDetailActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3RecordDetailActivity.class);
            if (v3RecordDetailActivity != null) {
                v3RecordDetailActivity.N();
            }
            V3RecordValidFragment v3RecordValidFragment = (V3RecordValidFragment) cn.bluemobi.dylan.base.utils.a.n().o(V3RecordValidFragment.class);
            if (v3RecordValidFragment != null) {
                v3RecordValidFragment.m();
            }
            V3RecordInValidFragment v3RecordInValidFragment = (V3RecordInValidFragment) cn.bluemobi.dylan.base.utils.a.n().o(V3RecordInValidFragment.class);
            if (v3RecordInValidFragment != null) {
                v3RecordInValidFragment.O();
            }
            V3AppealActivity.this.finish();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(String str) {
            a(str);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(V3AppealActivity this$0, AdapterView adapterView, View view, int i4, long j4) {
        f0.p(this$0, "this$0");
        k.f18613a.p(this$0.w(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(V3AppealActivity this$0, View view) {
        CharSequence E5;
        f0.p(this$0, "this$0");
        AppealVM x3 = this$0.x();
        String obj = this$0.M().etReason.getText().toString();
        if (obj != null) {
            E5 = x.E5(obj);
            x3.x(E5.toString(), this$0.f24079i, new b());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setBackEvent(this);
        c cVar = new c(this.f24079i, C(), 4, u.a(10.0f, C()));
        cVar.e(3);
        f1 f1Var = f1.f55527a;
        this.f24080j = cVar;
        M().gvImages.setAdapter((ListAdapter) this.f24080j);
        M().gvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.appeal.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                V3AppealActivity.g(V3AppealActivity.this, adapterView, view, i4, j4);
            }
        });
        if (getIntent().hasExtra("exerciseRecordId")) {
            x().F(getIntent().getStringExtra("exerciseRecordId"));
        }
        if (getIntent().hasExtra("identify")) {
            x().G(getIntent().getStringExtra("identify"));
        }
        M().btCommit.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.appeal.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3AppealActivity.h(V3AppealActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
