package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import p620m1.KMarkers;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH$J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\bH\u0004R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lkotlin/collections/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "e", "hasNext", "next", "()Ljava/lang/Object;", "Lkotlin/f1;", "a", DomainCampaignEx.LOOPBACK_VALUE, "d", "(Ljava/lang/Object;)V", "c", "Lkotlin/collections/m1;", "Lkotlin/collections/m1;", "state", "b", "Ljava/lang/Object;", "nextValue", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMarkers {

    /* renamed from: a */
    private EnumC14175m1 f40868a = EnumC14175m1.NotReady;

    /* renamed from: b */
    private T f40869b;

    /* renamed from: e */
    private final boolean m12316e() {
        this.f40868a = EnumC14175m1.Failed;
        mo7072a();
        return this.f40868a == EnumC14175m1.Ready;
    }

    /* renamed from: a */
    protected abstract void mo7072a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m12318c() {
        this.f40868a = EnumC14175m1.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final void m12317d(T t) {
        this.f40869b = t;
        this.f40868a = EnumC14175m1.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        EnumC14175m1 enumC14175m1 = this.f40868a;
        if (enumC14175m1 != EnumC14175m1.Failed) {
            int i = C14129b.f40832a[enumC14175m1.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return m12316e();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f40868a = EnumC14175m1.NotReady;
            return this.f40869b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
