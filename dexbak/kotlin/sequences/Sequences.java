package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0014R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, m12616d2 = {"Lkotlin/sequences/b;", ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/collections/c;", "Lkotlin/f1;", "a", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "c", "Ljava/util/HashSet;", "observed", "", "d", "Ljava/util/Iterator;", SocialConstants.PARAM_SOURCE, "Lkotlin/Function1;", "keySelector", "<init>", "(Ljava/util/Iterator;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class Sequences<T, K> extends AbstractIterator<T> {

    /* renamed from: c */
    private final HashSet<K> f41422c;

    /* renamed from: d */
    private final Iterator<T> f41423d;

    /* renamed from: e */
    private final InterfaceC15280l<T, K> f41424e;

    /* JADX WARN: Multi-variable type inference failed */
    public Sequences(@NotNull Iterator<? extends T> source, @NotNull InterfaceC15280l<? super T, ? extends K> keySelector) {
        C14342f0.m8184p(source, "source");
        C14342f0.m8184p(keySelector, "keySelector");
        this.f41423d = source;
        this.f41424e = keySelector;
        this.f41422c = new HashSet<>();
    }

    @Override // kotlin.collections.AbstractIterator
    /* renamed from: a */
    protected void mo7072a() {
        while (this.f41423d.hasNext()) {
            T next = this.f41423d.next();
            if (this.f41422c.add(this.f41424e.invoke(next))) {
                m12317d(next);
                return;
            }
        }
        m12318c();
    }
}
