package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@SinceKotlin(version = "1.4")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class AdaptedFunctionReference implements b0, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i4, Class cls, String str, String str2, int i5) {
        this(i4, CallableReference.NO_RECEIVER, cls, str, str2, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdaptedFunctionReference) {
            AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
            return this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && f0.g(this.receiver, adaptedFunctionReference.receiver) && f0.g(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.b0
    public int getArity() {
        return this.arity;
    }

    public kotlin.reflect.h getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? n0.g(cls) : n0.d(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((((((((hashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return n0.w(this);
    }

    public AdaptedFunctionReference(int i4, Object obj, Class cls, String str, String str2, int i5) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i5 & 1) == 1;
        this.arity = i4;
        this.flags = i5 >> 1;
    }
}
