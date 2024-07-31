package com.bxkj.student.splash;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.SearchView;
import com.bxkj.student.databinding.AcSchoolListV2Binding;
import com.bxkj.student.databinding.ItemForSchoolListV2Binding;
import com.bxkj.student.p094v2.p103vm.splash.SelectSchoolVM;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: SelectSchoolV2Activity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\t*\u0001\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R*\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lcom/bxkj/student/splash/SelectSchoolV2Activity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcSchoolListV2Binding;", "Lcom/bxkj/student/v2/vm/splash/SelectSchoolVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "", "", "", "", "i", "Ljava/util/List;", "schoolList", "com/bxkj/student/splash/SelectSchoolV2Activity$adapter$2$1", "j", "Lkotlin/o;", "N", "()Lcom/bxkj/student/splash/SelectSchoolV2Activity$adapter$2$1;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SelectSchoolV2Activity extends BaseActivity<AcSchoolListV2Binding, SelectSchoolVM> {
    @NotNull

    /* renamed from: i */
    private List<? extends Map<String, Object>> f19845i;
    @NotNull

    /* renamed from: j */
    private final InterfaceC14378o f19846j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectSchoolV2Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, m12616d2 = {"", "", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.splash.SelectSchoolV2Activity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5456a extends Lambda implements InterfaceC15280l<List<Map<String, Object>>, Unit> {
        C5456a() {
            super(1);
        }

        /* renamed from: a */
        public final void m39393a(@NotNull List<Map<String, Object>> it) {
            List m12233I5;
            C14342f0.m8184p(it, "it");
            SelectSchoolV2Activity$adapter$2.C54571 m39402N = SelectSchoolV2Activity.this.m39402N();
            m12233I5 = _Collections.m12233I5(it);
            m39402N.m43987l(m12233I5);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(List<Map<String, Object>> list) {
            m39393a(list);
            return Unit.f41048a;
        }
    }

    public SelectSchoolV2Activity() {
        List<? extends Map<String, Object>> m12478E;
        InterfaceC14378o m7719c;
        m12478E = CollectionsKt__CollectionsKt.m12478E();
        this.f19845i = m12478E;
        m7719c = C14389r.m7719c(new InterfaceC15269a<SelectSchoolV2Activity$adapter$2.C54571>() { // from class: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2

            /* compiled from: SelectSchoolV2Activity.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, m12616d2 = {"com/bxkj/student/splash/SelectSchoolV2Activity$adapter$2$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/ItemForSchoolListV2Binding;", "itemBinding", "bean", "", "position", "Lkotlin/f1;", "n", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2$1 */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public static final class C54571 extends BaseAdapter<Map<String, Object>, ItemForSchoolListV2Binding> {

                /* renamed from: b */
                final /* synthetic */ SelectSchoolV2Activity f19849b;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SelectSchoolV2Activity.kt */
                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
                /* renamed from: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2$1$a */
                /* loaded from: E:\fuckcool\tsn\5141176.dex */
                public static final class C5458a extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

                    /* renamed from: a */
                    final /* synthetic */ Map<String, Object> f19850a;

                    /* renamed from: b */
                    final /* synthetic */ SelectSchoolV2Activity f19851b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C5458a(Map<String, Object> map, SelectSchoolV2Activity selectSchoolV2Activity) {
                        super(1);
                        this.f19850a = map;
                        this.f19851b = selectSchoolV2Activity;
                    }

                    /* renamed from: a */
                    public final void m39392a(@NotNull iOSTwoButtonDialog it) {
                        C14342f0.m8184p(it, "it");
                        JsonGet jsonGet = JsonGet.f15134a;
                        String m43760t = jsonGet.m43760t(this.f19850a, "school_name");
                        LoginUser.getLoginUser().setSchoolId(jsonGet.m43760t(this.f19850a, "school_id"));
                        LoginUser.getLoginUser().setSysType(jsonGet.m43769k(this.f19850a, "sysType"));
                        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
                        c3984b.m43634a().m43674Q(jsonGet.m43769k(this.f19850a, "isOpenLive"));
                        c3984b.m43634a().m43673R(jsonGet.m43768l(this.f19850a, "isOpenSQZS", 1));
                        c3984b.m43634a().m43675P(jsonGet.m43768l(this.f19850a, "isOpenGGLBT", 1));
                        if (LoginUser.getLoginUser().getSysType() == 2) {
                            c3984b.m43634a().m43669V(m43760t);
                            c3984b.m43634a().m43670U(jsonGet.m43760t(this.f19850a, "schoolCode"));
                            c3984b.m43634a().m43668W(jsonGet.m43759u(this.f19850a, "lan_url", "http://a.sxstczx.com/"));
                            RetrofitClient.f20337a.m38889a();
                            c3984b.m43634a().m43682I(jsonGet.m43760t(this.f19850a, "school_url"));
                        } else {
                            LoginUser.getLoginUser().setSchoolName(m43760t);
                            LoginUser.getLoginUser().setIsOpenKeep(jsonGet.m43769k(this.f19850a, "isOpenKeep"));
                            LoginUser.getLoginUser().setIsOpenEncry(jsonGet.m43760t(this.f19850a, "isOpenEncry"));
                            LoginUser.getLoginUser().setAppId(JsonParse.getString(this.f19850a, "openId"));
                            LoginUser.getLoginUser().setServerUrl(jsonGet.m43760t(this.f19850a, "school_url"));
                            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                        }
                        this.f19851b.mo43926C().startActivity(new Intent(this.f19851b.mo43926C(), SplashActivity.class));
                        new HashSet().add(m43760t);
                        this.f19851b.finish();
                    }

                    @Override // p617l1.InterfaceC15280l
                    public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
                        m39392a(iostwobuttondialog);
                        return Unit.f41048a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C54571(SelectSchoolV2Activity selectSchoolV2Activity, List<? extends Map<String, Object>> list) {
                    super(list);
                    this.f19849b = selectSchoolV2Activity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* renamed from: o */
                public static final void m39394o(SelectSchoolV2Activity this$0, Map bean, View view) {
                    C14342f0.m8184p(this$0, "this$0");
                    C14342f0.m8184p(bean, "$bean");
                    FragmentActivity mo43912w = this$0.mo43912w();
                    ContextExt.m43856h(mo43912w, null, "确定您要选择" + JsonGet.f15134a.m43760t(bean, "school_name") + "吗?", new C5458a(bean, this$0), null, null, null, 57, null);
                }

                @Override // com.bxkj.base.p085v2.base.BaseAdapter
                /* renamed from: n */
                public void mo38351f(@NotNull ItemForSchoolListV2Binding itemBinding, @NotNull final Map<String, Object> bean, int i) {
                    C14342f0.m8184p(itemBinding, "itemBinding");
                    C14342f0.m8184p(bean, "bean");
                    TextView textView = itemBinding.tvName;
                    StringBuilder sb = new StringBuilder();
                    JsonGet jsonGet = JsonGet.f15134a;
                    sb.append(jsonGet.m43760t(bean, "school_name"));
                    sb.append(" (");
                    sb.append(jsonGet.m43760t(bean, "provinceName"));
                    sb.append(')');
                    textView.setText(sb.toString());
                    TextView textView2 = itemBinding.tvName;
                    final SelectSchoolV2Activity selectSchoolV2Activity = this.f19849b;
                    textView2.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE  
                          (r4v1 'textView2' android.widget.TextView)
                          (wrap: android.view.View$OnClickListener : 0x003c: CONSTRUCTOR  (r0v2 android.view.View$OnClickListener A[REMOVE]) = 
                          (r6v4 'selectSchoolV2Activity' com.bxkj.student.splash.SelectSchoolV2Activity A[DONT_INLINE])
                          (r5v0 'bean' java.util.Map<java.lang.String, java.lang.Object> A[DONT_INLINE])
                         call: com.bxkj.student.splash.f.<init>(com.bxkj.student.splash.SelectSchoolV2Activity, java.util.Map):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.widget.TextView.setOnClickListener(android.view.View$OnClickListener):void in method: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2.1.n(com.bxkj.student.databinding.ItemForSchoolListV2Binding, java.util.Map<java.lang.String, java.lang.Object>, int):void, file: E:\fuckcool\tsn\5141176.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bxkj.student.splash.f, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r6 = "itemBinding"
                        kotlin.jvm.internal.C14342f0.m8184p(r4, r6)
                        java.lang.String r6 = "bean"
                        kotlin.jvm.internal.C14342f0.m8184p(r5, r6)
                        android.widget.TextView r6 = r4.tvName
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        com.bxkj.base.v2.common.utils.l r1 = com.bxkj.base.p085v2.common.utils.JsonGet.f15134a
                        java.lang.String r2 = "school_name"
                        java.lang.String r2 = r1.m43760t(r5, r2)
                        r0.append(r2)
                        java.lang.String r2 = " ("
                        r0.append(r2)
                        java.lang.String r2 = "provinceName"
                        java.lang.String r1 = r1.m43760t(r5, r2)
                        r0.append(r1)
                        r1 = 41
                        r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        r6.setText(r0)
                        android.widget.TextView r4 = r4.tvName
                        com.bxkj.student.splash.SelectSchoolV2Activity r6 = r3.f19849b
                        com.bxkj.student.splash.f r0 = new com.bxkj.student.splash.f
                        r0.<init>(r6, r5)
                        r4.setOnClickListener(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2.C54571.mo38351f(com.bxkj.student.databinding.ItemForSchoolListV2Binding, java.util.Map, int):void");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // p617l1.InterfaceC15269a
            @NotNull
            /* renamed from: a */
            public final C54571 invoke() {
                List list;
                list = SelectSchoolV2Activity.this.f19845i;
                return new C54571(SelectSchoolV2Activity.this, list);
            }
        });
        this.f19846j = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final SelectSchoolV2Activity$adapter$2.C54571 m39402N() {
        return (SelectSchoolV2Activity$adapter$2.C54571) this.f19846j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public static final void m39401O(SelectSchoolV2Activity this$0, String it) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8185o(it, "it");
        if (it.length() == 0) {
            this$0.m39402N().m43987l(new ArrayList());
        } else if (it.length() >= 4) {
            this$0.mo43911x().m38096v(it, new C5456a());
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setActivity(this);
        mo43920M().rvSchool.setAdapter(m39402N());
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43920M().searchView.setOnSearchListener(new SearchView.InterfaceC3998a() { // from class: com.bxkj.student.splash.e
            @Override // com.bxkj.base.view.SearchView.InterfaceC3998a
            /* renamed from: a */
            public final void mo39377a(String str) {
                SelectSchoolV2Activity.m39401O(SelectSchoolV2Activity.this, str);
            }
        });
    }
}
