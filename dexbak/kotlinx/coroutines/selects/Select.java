package kotlinx.coroutines.selects;

import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J5\u0010\b\u001a\u00020\u0007*\u00020\u00032\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H¦\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJG\u0010\r\u001a\u00020\u0007\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00010\u000b2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH¦\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\u0012\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u000f\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH¦\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u0014\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u000f\"\u0004\b\u0002\u0010\n*\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00028\u00020\u00102\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J8\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H'ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m12616d2 = {"Lkotlinx/coroutines/selects/a;", "R", "", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "block", "Lkotlin/f1;", "c", "(Lkotlinx/coroutines/selects/c;Ll1/l;)V", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/selects/d;Ll1/p;)V", "P", "Lkotlinx/coroutines/selects/e;", "param", "b", "(Lkotlinx/coroutines/selects/e;Ljava/lang/Object;Ll1/p;)V", "n", "(Lkotlinx/coroutines/selects/e;Ll1/p;)V", "", "timeMillis", "m", "(JLl1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.selects.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Select<R> {

    /* compiled from: Select.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15187a {
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public static <R, P, Q> void m3720a(@NotNull Select<? super R> select, @NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            select.mo3682b(interfaceC15196e, null, interfaceC15284p);
        }
    }

    /* renamed from: b */
    <P, Q> void mo3682b(@NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, P p, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p);

    /* renamed from: c */
    void mo3681c(@NotNull InterfaceC15194c interfaceC15194c, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l);

    @ExperimentalCoroutinesApi
    /* renamed from: m */
    void mo3677m(long j, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l);

    /* renamed from: n */
    <P, Q> void mo3676n(@NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p);

    /* renamed from: w */
    <Q> void mo3675w(@NotNull InterfaceC15195d<? extends Q> interfaceC15195d, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p);
}
