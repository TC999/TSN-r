package kotlin.time;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;

/* compiled from: TimeSource.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m12616d2 = {"Lkotlin/time/n;", AdnName.OTHER, "Lkotlin/time/d;", "b", "(Lkotlin/time/n;Lkotlin/time/n;)J", "", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.time.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C14605p {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Annotations(level = DeprecationLevel.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    /* renamed from: a */
    private static final int m5978a(AbstractC14601n compareTo, AbstractC14601n abstractC14601n) {
        C14342f0.m8184p(compareTo, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Annotations(level = DeprecationLevel.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    /* renamed from: b */
    private static final long m5977b(AbstractC14601n minus, AbstractC14601n abstractC14601n) {
        C14342f0.m8184p(minus, "$this$minus");
        throw new Error("Operation is disallowed.");
    }
}
