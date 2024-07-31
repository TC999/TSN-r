package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m12616d2 = {"Lkotlin/sequences/c;", ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", SocialConstants.PARAM_SOURCE, "Lkotlin/Function1;", "keySelector", "<init>", "(Lkotlin/sequences/m;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14497c<T, K> implements Sequence<T> {

    /* renamed from: a */
    private final Sequence<T> f41425a;

    /* renamed from: b */
    private final InterfaceC15280l<T, K> f41426b;

    /* JADX WARN: Multi-variable type inference failed */
    public C14497c(@NotNull Sequence<? extends T> source, @NotNull InterfaceC15280l<? super T, ? extends K> keySelector) {
        C14342f0.m8184p(source, "source");
        C14342f0.m8184p(keySelector, "keySelector");
        this.f41425a = source;
        this.f41426b = keySelector;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Sequences(this.f41425a.iterator(), this.f41426b);
    }
}
