package kotlinx.coroutines.selects;

import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.Atomic;
import kotlinx.coroutines.internal.C15094s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Select.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&R\u0014\u0010\u0015\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m12616d2 = {"Lkotlinx/coroutines/selects/f;", "R", "", "", "o", "Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "otherOp", C7304t.f25048d, "Lkotlinx/coroutines/internal/b;", "desc", "u", "", "exception", "Lkotlin/f1;", UMCommonContent.f37782aL, "Lkotlinx/coroutines/i1;", "handle", "k", "i", "()Z", "isSelected", "Lkotlin/coroutines/c;", "s", "()Lkotlin/coroutines/c;", "completion", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.selects.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15197f<R> {
    /* renamed from: i */
    boolean mo3706i();

    /* renamed from: k */
    void mo3705k(@NotNull InterfaceC15064i1 interfaceC15064i1);

    @Nullable
    /* renamed from: l */
    Object mo3704l(@Nullable C15094s.C15098d c15098d);

    /* renamed from: o */
    boolean mo3703o();

    @NotNull
    /* renamed from: s */
    InterfaceC14268c<R> mo3702s();

    /* renamed from: t */
    void mo3701t(@NotNull Throwable th);

    @Nullable
    /* renamed from: u */
    Object mo3700u(@NotNull Atomic atomic);
}
