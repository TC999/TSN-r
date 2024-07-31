package kotlin.reflect;

import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KParameter.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u001aR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001b"}, m12616d2 = {"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/b;", "", "b", "()I", "index", "", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/r;", "getType", "()Lkotlin/reflect/r;", "type", "Lkotlin/reflect/KParameter$Kind;", "n", "()Lkotlin/reflect/KParameter$Kind;", "kind", "", "x", "()Z", "isOptional", IAdInterListener.AdReqParam.WIDTH, "isVararg$annotations", "()V", "isVararg", "Kind", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface KParameter extends KAnnotatedElement {

    /* compiled from: KParameter.kt */
    @Metadata(m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m12616d2 = {"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum Kind {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    /* compiled from: KParameter.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.KParameter$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14431a {
        @SinceKotlin(version = "1.1")
        /* renamed from: a */
        public static /* synthetic */ void m7379a() {
        }
    }

    /* renamed from: b */
    int m7383b();

    @Nullable
    String getName();

    @NotNull
    KType getType();

    @NotNull
    /* renamed from: n */
    Kind m7382n();

    /* renamed from: w */
    boolean m7381w();

    /* renamed from: x */
    boolean m7380x();
}
