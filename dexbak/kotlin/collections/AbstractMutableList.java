package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import p620m1.InterfaceC15299e;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, m12616d2 = {"Lkotlin/collections/g;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/AbstractList;", "", "index", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "c", "(I)Ljava/lang/Object;", "Lkotlin/f1;", "add", "(ILjava/lang/Object;)V", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, InterfaceC15299e {
    /* renamed from: a */
    public abstract int mo11949a();

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i, E e);

    /* renamed from: c */
    public abstract E mo11948c(int i);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return mo11948c(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i, E e);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return mo11949a();
    }
}
