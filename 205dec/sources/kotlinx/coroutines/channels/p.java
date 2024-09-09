package kotlinx.coroutines.channels;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Channel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0004\u001a\u00020\u0003H\u00a6B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00028\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00028\u0000H\u00a6\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/p;", "E", "", "", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "next", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface p<E> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Channel.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0006\b\u0000\u0010\u0000 \u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0097@"}, d2 = {"E", "Lkotlin/coroutines/c;", "continuation", "", "next0"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME}, m = "next", n = {"$this"}, s = {"L$0"})
        /* renamed from: kotlinx.coroutines.channels.p$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1199a extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f59478a;

            /* renamed from: b  reason: collision with root package name */
            int f59479b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ p f59480c;

            /* renamed from: d  reason: collision with root package name */
            Object f59481d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1199a(p pVar, kotlin.coroutines.c cVar) {
                super(cVar);
                this.f59480c = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f59478a = obj;
                this.f59479b |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @kotlin.jvm.JvmName(name = "next")
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ <E> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.p<? extends E> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.p.a.C1199a
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.p$a$a r0 = (kotlinx.coroutines.channels.p.a.C1199a) r0
                int r1 = r0.f59479b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f59479b = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.p$a$a r0 = new kotlinx.coroutines.channels.p$a$a
                r0.<init>(r4, r5)
            L18:
                java.lang.Object r5 = r0.f59478a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
                int r2 = r0.f59479b
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r4 = r0.f59481d
                kotlinx.coroutines.channels.p r4 = (kotlinx.coroutines.channels.p) r4
                kotlin.d0.n(r5)
                goto L43
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                kotlin.d0.n(r5)
                r0.f59481d = r4
                r0.f59479b = r3
                java.lang.Object r5 = r4.b(r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L50
                java.lang.Object r4 = r4.next()
                return r4
            L50:
                kotlinx.coroutines.channels.ClosedReceiveChannelException r4 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
                java.lang.String r5 = "Channel was closed"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.p.a.a(kotlinx.coroutines.channels.p, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = "next")
    @Nullable
    /* synthetic */ Object a(@NotNull kotlin.coroutines.c<? super E> cVar);

    @Nullable
    Object b(@NotNull kotlin.coroutines.c<? super Boolean> cVar);

    E next();
}
