package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j extends f implements m2.e {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f56595c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Object[] values) {
        super(fVar, null);
        f0.p(values, "values");
        this.f56595c = values;
    }

    @Override // m2.e
    @NotNull
    public List<f> c() {
        Object[] objArr = this.f56595c;
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i4 = 0;
        while (i4 < length) {
            Object obj = objArr[i4];
            i4++;
            f.a aVar = f.f56592b;
            f0.m(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
