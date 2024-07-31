package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.AbstractSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import p620m1.InterfaceC15303h;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m12616d2 = {"Lkotlin/collections/i;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/AbstractSet;", "element", "", "add", "(Ljava/lang/Object;)Z", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractMutableSet<E> extends AbstractSet<E> implements Set<E>, InterfaceC15303h {
    /* renamed from: a */
    public abstract int mo5121a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return mo5121a();
    }
}