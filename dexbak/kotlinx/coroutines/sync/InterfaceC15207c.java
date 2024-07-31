package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.selects.InterfaceC15196e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Mutex.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&J\u001f\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&J\u0014\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&R\u0014\u0010\f\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/sync/c;", "", "owner", "", "a", "Lkotlin/f1;", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "e", "b", "()Z", "isLocked", "Lkotlinx/coroutines/selects/e;", "g", "()Lkotlinx/coroutines/selects/e;", "onLock", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15207c {

    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15208a {
        /* renamed from: a */
        public static /* synthetic */ Object m3637a(InterfaceC15207c interfaceC15207c, Object obj, InterfaceC14268c interfaceC14268c, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return interfaceC15207c.mo3632c(obj, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        /* renamed from: b */
        public static /* synthetic */ boolean m3636b(InterfaceC15207c interfaceC15207c, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return interfaceC15207c.mo3634a(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        /* renamed from: c */
        public static /* synthetic */ void m3635c(InterfaceC15207c interfaceC15207c, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                interfaceC15207c.mo3630e(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    /* renamed from: a */
    boolean mo3634a(@Nullable Object obj);

    /* renamed from: b */
    boolean mo3633b();

    @Nullable
    /* renamed from: c */
    Object mo3632c(@Nullable Object obj, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    /* renamed from: e */
    void mo3630e(@Nullable Object obj);

    /* renamed from: f */
    boolean mo3629f(@NotNull Object obj);

    @NotNull
    /* renamed from: g */
    InterfaceC15196e<Object, InterfaceC15207c> mo3628g();
}
