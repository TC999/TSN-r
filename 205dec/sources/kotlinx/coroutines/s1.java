package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Executors.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H&R\u0014\u0010\b\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/l0;", "Ljava/io/Closeable;", "Lkotlin/f1;", "close", "Ljava/util/concurrent/Executor;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/concurrent/Executor;", "executor", "<init>", "()V", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class s1 extends l0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60554a = new a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Executors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/s1$a;", "Lkotlin/coroutines/b;", "Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/s1;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    @ExperimentalStdlibApi
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.coroutines.b<l0, s1> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Executors.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/coroutines/f$b;", "it", "Lkotlinx/coroutines/s1;", "a", "(Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/s1;"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.s1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1220a extends Lambda implements d2.l<f.b, s1> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1220a f60555a = new C1220a();

            C1220a() {
                super(1);
            }

            @Override // d2.l
            @Nullable
            /* renamed from: a */
            public final s1 invoke(@NotNull f.b bVar) {
                if (!(bVar instanceof s1)) {
                    bVar = null;
                }
                return (s1) bVar;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        private a() {
            super(l0.Key, C1220a.f60555a);
        }
    }

    public abstract void close();

    @NotNull
    public abstract Executor q();
}
