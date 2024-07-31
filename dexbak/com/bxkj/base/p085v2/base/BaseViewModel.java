package com.bxkj.base.p085v2.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.asm.Opcodes;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: BaseViewModel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;JE\u0010\f\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032$\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJØ\u0002\u0010\u0016\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e2&\b\u0002\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0012\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0013\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052 \b\u0002\u0010\u0014\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000e2H\b\u0002\u0010\u0015\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017Jð\u0002\u0010\u001c\u001a\u00020\u001b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e2&\b\u0002\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0012\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0013\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052 \b\u0002\u0010\u0014\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000e2H\b\u0002\u0010\u0015\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0004ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#\"\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b\u0004\u0010#\"\u0004\b*\u0010(R(\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010(R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010!\u001a\u0004\b/\u0010#\"\u0004\b0\u0010(R(\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010!\u001a\u0004\b2\u0010#\"\u0004\b3\u0010(R$\u00109\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00105\u001a\u0004\b%\u00106\"\u0004\b7\u00108\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Lkotlin/Function2;", "Lcom/bxkj/base/v2/http/exception/ApiException;", "Lkotlin/coroutines/c;", "", "", "otherCode", "Lkotlin/f1;", "m", "(Ljava/lang/Exception;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "success", "Lkotlin/ParameterName;", "name", "error", CommonNetImpl.CANCEL, CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, CommonNetImpl.FAIL, "k", "(Ll1/l;Ll1/p;Ll1/p;Ll1/p;Ll1/l;Ll1/p;)V", "isShowLoading", "", "loadingMsg", "Lkotlinx/coroutines/e2;", "i", "(Ll1/l;Ll1/p;Ll1/p;Ll1/p;Ll1/l;Ll1/p;Ljava/lang/Boolean;Ljava/lang/String;)Lkotlinx/coroutines/e2;", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "c", "()Landroidx/lifecycle/MutableLiveData;", "loadingLiveData", "b", "d", "o", "(Landroidx/lifecycle/MutableLiveData;)V", "loadingMessage", "p", "networkRequestStatus", "h", "s", "showOkToast", "g", "r", "showErrorToast", "f", CampaignEx.JSON_KEY_AD_Q, "showDialog", "Lkotlinx/coroutines/e2;", "()Lkotlinx/coroutines/e2;", "n", "(Lkotlinx/coroutines/e2;)V", "jobs", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.BaseViewModel */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BaseViewModel extends ViewModel {
    @NotNull

    /* renamed from: a */
    private final MutableLiveData<Integer> f15000a = new MutableLiveData<>();
    @NotNull

    /* renamed from: b */
    private MutableLiveData<String> f15001b = new MutableLiveData<>("Loading...");
    @NotNull

    /* renamed from: c */
    private MutableLiveData<String> f15002c = new MutableLiveData<>();
    @NotNull

    /* renamed from: d */
    private MutableLiveData<String> f15003d = new MutableLiveData<>();
    @NotNull

    /* renamed from: e */
    private MutableLiveData<String> f15004e = new MutableLiveData<>();
    @NotNull

    /* renamed from: f */
    private MutableLiveData<String> f15005f = new MutableLiveData<>();
    @Nullable

    /* renamed from: g */
    private Job f15006g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.base.v2.base.BaseViewModel$launch$job$1", m8638f = "BaseViewModel.kt", m8637i = {2, 4}, m8636l = {93, 114, 95, 99, 104, 106, 114, 114}, m8635m = "invokeSuspend", m8634n = {"e", "e"}, m8633s = {"L$0", "L$0"})
    /* renamed from: com.bxkj.base.v2.base.BaseViewModel$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3921a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f15007a;

        /* renamed from: b */
        int f15008b;

        /* renamed from: c */
        final /* synthetic */ String f15009c;

        /* renamed from: d */
        final /* synthetic */ Boolean f15010d;

        /* renamed from: e */
        final /* synthetic */ BaseViewModel f15011e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> f15012f;

        /* renamed from: g */
        final /* synthetic */ InterfaceC15284p<Exception, InterfaceC14268c<? super Unit>, Object> f15013g;

        /* renamed from: h */
        final /* synthetic */ InterfaceC15284p<Exception, InterfaceC14268c<? super Unit>, Object> f15014h;

        /* renamed from: i */
        final /* synthetic */ InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> f15015i;

        /* renamed from: j */
        final /* synthetic */ InterfaceC15284p<ApiException, InterfaceC14268c<? super Boolean>, Object> f15016j;

        /* renamed from: k */
        final /* synthetic */ InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> f15017k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C3921a(String str, Boolean bool, BaseViewModel baseViewModel, InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15280l, InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p2, InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p3, InterfaceC15284p<? super ApiException, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p4, InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15280l2, InterfaceC14268c<? super C3921a> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f15009c = str;
            this.f15010d = bool;
            this.f15011e = baseViewModel;
            this.f15012f = interfaceC15280l;
            this.f15013g = interfaceC15284p;
            this.f15014h = interfaceC15284p2;
            this.f15015i = interfaceC15284p3;
            this.f15016j = interfaceC15284p4;
            this.f15017k = interfaceC15280l2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C3921a(this.f15009c, this.f15010d, this.f15011e, this.f15012f, this.f15013g, this.f15014h, this.f15015i, this.f15016j, this.f15017k, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C3921a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0119 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:7:0x001d, B:10:0x0026, B:69:0x0115, B:71:0x0119, B:73:0x0123, B:13:0x002f, B:55:0x00e3, B:57:0x00e7, B:60:0x00f7, B:63:0x0103, B:66:0x0109, B:16:0x0039, B:33:0x0086, B:49:0x00d2, B:52:0x00d7), top: B:106:0x0009, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0132 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0169  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 468
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.p085v2.base.BaseViewModel.C3921a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseViewModel.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.base.v2.base.BaseViewModel", m8638f = "BaseViewModel.kt", m8637i = {3, 3}, m8636l = {180, 180, 180, Opcodes.NEWARRAY}, m8635m = "onError", m8634n = {"this", "e"}, m8633s = {"L$0", "L$1"})
    /* renamed from: com.bxkj.base.v2.base.BaseViewModel$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3922b extends ContinuationImpl {

        /* renamed from: a */
        Object f15018a;

        /* renamed from: b */
        Object f15019b;

        /* renamed from: c */
        /* synthetic */ Object f15020c;

        /* renamed from: e */
        int f15022e;

        C3922b(InterfaceC14268c<? super C3922b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f15020c = obj;
            this.f15022e |= Integer.MIN_VALUE;
            return BaseViewModel.this.m43946m(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j */
    public static /* synthetic */ Job m43949j(BaseViewModel baseViewModel, InterfaceC15280l interfaceC15280l, InterfaceC15284p interfaceC15284p, InterfaceC15284p interfaceC15284p2, InterfaceC15284p interfaceC15284p3, InterfaceC15280l interfaceC15280l2, InterfaceC15284p interfaceC15284p4, Boolean bool, String str, int i, Object obj) {
        if (obj == null) {
            return baseViewModel.m43950i(interfaceC15280l, (i & 2) != 0 ? null : interfaceC15284p, (i & 4) != 0 ? null : interfaceC15284p2, (i & 8) != 0 ? null : interfaceC15284p3, (i & 16) != 0 ? null : interfaceC15280l2, (i & 32) == 0 ? interfaceC15284p4 : null, (i & 64) != 0 ? Boolean.TRUE : bool, (i & 128) != 0 ? "Loading.." : str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l */
    public static /* synthetic */ void m43947l(BaseViewModel baseViewModel, InterfaceC15280l interfaceC15280l, InterfaceC15284p interfaceC15284p, InterfaceC15284p interfaceC15284p2, InterfaceC15284p interfaceC15284p3, InterfaceC15280l interfaceC15280l2, InterfaceC15284p interfaceC15284p4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchWithOutLoading");
        }
        baseViewModel.m43948k(interfaceC15280l, (i & 2) != 0 ? null : interfaceC15284p, (i & 4) != 0 ? null : interfaceC15284p2, (i & 8) != 0 ? null : interfaceC15284p3, (i & 16) != 0 ? null : interfaceC15280l2, (i & 32) == 0 ? interfaceC15284p4 : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m43946m(java.lang.Exception r11, p617l1.InterfaceC15284p<? super com.bxkj.base.p085v2.http.exception.ApiException, ? super kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean>, ? extends java.lang.Object> r12, kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.p085v2.base.BaseViewModel.m43946m(java.lang.Exception, l1.p, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: b */
    public final Job m43957b() {
        return this.f15006g;
    }

    @NotNull
    /* renamed from: c */
    public final MutableLiveData<Integer> m43956c() {
        return this.f15000a;
    }

    @NotNull
    /* renamed from: d */
    public final MutableLiveData<String> m43955d() {
        return this.f15001b;
    }

    @NotNull
    /* renamed from: e */
    public final MutableLiveData<String> m43954e() {
        return this.f15002c;
    }

    @NotNull
    /* renamed from: f */
    public final MutableLiveData<String> m43953f() {
        return this.f15005f;
    }

    @NotNull
    /* renamed from: g */
    public final MutableLiveData<String> m43952g() {
        return this.f15004e;
    }

    @NotNull
    /* renamed from: h */
    public final MutableLiveData<String> m43951h() {
        return this.f15003d;
    }

    @NotNull
    /* renamed from: i */
    protected final Job m43950i(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> success, @Nullable InterfaceC15284p<? super ApiException, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p, @Nullable InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p2, @Nullable InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p3, @Nullable InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15280l, @Nullable InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p4, @Nullable Boolean bool, @Nullable String str) {
        Job m4126f;
        C14342f0.m8184p(success, "success");
        m4126f = C15111j.m4126f(ViewModelKt.getViewModelScope(this), null, null, new C3921a(str, bool, this, success, interfaceC15284p4, interfaceC15284p3, interfaceC15284p2, interfaceC15284p, interfaceC15280l, null), 3, null);
        this.f15006g = m4126f;
        return m4126f;
    }

    /* renamed from: k */
    protected final void m43948k(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> success, @Nullable InterfaceC15284p<? super ApiException, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p, @Nullable InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p2, @Nullable InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p3, @Nullable InterfaceC15280l<? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15280l, @Nullable InterfaceC15284p<? super Exception, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p4) {
        C14342f0.m8184p(success, "success");
        this.f15006g = m43949j(this, success, interfaceC15284p, interfaceC15284p2, interfaceC15284p3, interfaceC15280l, interfaceC15284p4, Boolean.FALSE, null, 128, null);
    }

    /* renamed from: n */
    public final void m43945n(@Nullable Job job) {
        this.f15006g = job;
    }

    /* renamed from: o */
    public final void m43944o(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f15001b = mutableLiveData;
    }

    /* renamed from: p */
    public final void m43943p(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f15002c = mutableLiveData;
    }

    /* renamed from: q */
    public final void m43942q(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f15005f = mutableLiveData;
    }

    /* renamed from: r */
    public final void m43941r(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f15004e = mutableLiveData;
    }

    /* renamed from: s */
    public final void m43940s(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f15003d = mutableLiveData;
    }
}
