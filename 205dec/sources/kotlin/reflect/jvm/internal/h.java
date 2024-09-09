package kotlin.reflect.jvm.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KClassImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u0006:\u0001oB\u0015\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0016J\u0013\u0010\u0017\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR9\u0010'\u001a$\u0012 \u0012\u001e \"*\u000e\u0018\u00010!R\b\u0012\u0004\u0012\u00028\u00000\u00000!R\b\u0012\u0004\u0012\u00028\u00000\u00000 8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010/R\u0016\u00106\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u00108\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00105R \u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000090\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010/R\u001e\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010/R\u0016\u0010@\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020A0(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010+R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020D0(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010+R\"\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010+R\u0016\u0010L\u001a\u0004\u0018\u00010I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010NR\u0014\u0010P\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010NR\u0014\u0010R\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010NR\u0014\u0010T\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010NR\u0014\u0010V\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010NR\u0014\u0010X\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010NR\u0014\u0010Z\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010NR\u001a\u0010^\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\\\u0010]\u001a\u0004\b[\u0010NR\u0014\u0010b\u001a\u00020_8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010l\u001a\u00020g8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bk\u0010i\u00a8\u0006p"}, d2 = {"Lkotlin/reflect/jvm/internal/h;", "", "T", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/d;", "Lkotlin/reflect/jvm/internal/i;", "Lkotlin/reflect/jvm/internal/w;", "", "b0", "Lkotlin/reflect/jvm/internal/impl/name/f;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "N", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "J", "", "index", "K", "value", "", "C", "other", "equals", "hashCode", "", "toString", "Ljava/lang/Class;", "d", "Ljava/lang/Class;", "()Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/h$a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/reflect/jvm/internal/y$b;", "X", "()Lkotlin/reflect/jvm/internal/y$b;", "data", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/c;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Collection;", "members", "Lkotlin/reflect/jvm/internal/impl/descriptors/j;", "I", "constructorDescriptors", "E", "()Ljava/lang/String;", "simpleName", "D", "qualifiedName", "Lkotlin/reflect/i;", "g", "constructors", "z", "nestedClasses", "A", "()Ljava/lang/Object;", "objectInstance", "Lkotlin/reflect/s;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/r;", "j", "supertypes", "m", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility", "isFinal", "()Z", "isOpen", "isAbstract", "p", "isSealed", "y", "isData", "n", "isInner", "B", "isCompanion", "t", "isFun", "v", "isValue$annotations", "()V", "isValue", "Lkotlin/reflect/jvm/internal/impl/name/b;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/d;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "<init>", "(Ljava/lang/Class;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h<T> extends KDeclarationContainerImpl implements kotlin.reflect.d<T>, i, w {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Class<T> f55960d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final y.b<h<T>.a> f55961e;

    /* compiled from: KClassImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u0014R-\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u00198FX\u0086\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\t\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR%\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u001dR#\u0010)\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010%\u0012\u0004\b(\u0010\u001f\u001a\u0004\b&\u0010'R!\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b+\u0010\u0011R!\u00100\u001a\b\u0012\u0004\u0012\u00020-0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u0011R)\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000!0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b2\u0010\u0011R%\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b1\u0010\u001dR%\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b5\u0010\u001dR%\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b9\u0010\u001dR%\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010\t\u001a\u0004\b;\u0010\u001dR%\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b\u001b\u0010\u001dR%\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b\"\u0010\u001dR%\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b.\u0010\u001dR%\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b\u0016\u0010\u001d\u00a8\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/h$a;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$b;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/Class;", "jClass", "", "f", "Lkotlin/reflect/jvm/internal/impl/descriptors/d;", "d", "Lkotlin/reflect/jvm/internal/y$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "", "", "e", "j", "()Ljava/util/List;", "annotations", "v", "()Ljava/lang/String;", "simpleName", "g", "t", "qualifiedName", "", "Lkotlin/reflect/i;", "h", "k", "()Ljava/util/Collection;", "getConstructors$annotations", "()V", "constructors", "Lkotlin/reflect/d;", "i", "r", "nestedClasses", "Lkotlin/reflect/jvm/internal/y$b;", "s", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "Lkotlin/reflect/s;", "x", "typeParameters", "Lkotlin/reflect/r;", "l", "w", "supertypes", "m", "u", "sealedSubclasses", "Lkotlin/reflect/jvm/internal/f;", "n", "declaredNonStaticMembers", "o", "declaredStaticMembers", "p", "inheritedNonStaticMembers", CampaignEx.JSON_KEY_AD_Q, "inheritedStaticMembers", "allNonStaticMembers", "allStaticMembers", "declaredMembers", "allMembers", "<init>", "(Lkotlin/reflect/jvm/internal/h;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends KDeclarationContainerImpl.b {

        /* renamed from: w  reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f55962w = {n0.u(new PropertyReference1Impl(n0.d(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "annotations", "getAnnotations()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final y.a f55963d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final y.a f55964e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final y.a f55965f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        private final y.a f55966g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final y.a f55967h;
        @NotNull

        /* renamed from: i  reason: collision with root package name */
        private final y.a f55968i;
        @NotNull

        /* renamed from: j  reason: collision with root package name */
        private final y.b f55969j;
        @NotNull

        /* renamed from: k  reason: collision with root package name */
        private final y.a f55970k;
        @NotNull

        /* renamed from: l  reason: collision with root package name */
        private final y.a f55971l;
        @NotNull

        /* renamed from: m  reason: collision with root package name */
        private final y.a f55972m;
        @NotNull

        /* renamed from: n  reason: collision with root package name */
        private final y.a f55973n;
        @NotNull

        /* renamed from: o  reason: collision with root package name */
        private final y.a f55974o;
        @NotNull

        /* renamed from: p  reason: collision with root package name */
        private final y.a f55975p;
        @NotNull

        /* renamed from: q  reason: collision with root package name */
        private final y.a f55976q;
        @NotNull

        /* renamed from: r  reason: collision with root package name */
        private final y.a f55977r;
        @NotNull

        /* renamed from: s  reason: collision with root package name */
        private final y.a f55978s;
        @NotNull

        /* renamed from: t  reason: collision with root package name */
        private final y.a f55979t;
        @NotNull

        /* renamed from: u  reason: collision with root package name */
        private final y.a f55980u;

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ h<T> f55981v;

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.h$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1116a extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55982a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1116a(h<T>.a aVar) {
                super(0);
                this.f55982a = aVar;
            }

            @Override // d2.a
            public final List<? extends kotlin.reflect.jvm.internal.f<?>> invoke() {
                List<? extends kotlin.reflect.jvm.internal.f<?>> o4;
                o4 = kotlin.collections.f0.o4(this.f55982a.h(), this.f55982a.i());
                return o4;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55983a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(h<T>.a aVar) {
                super(0);
                this.f55983a = aVar;
            }

            @Override // d2.a
            public final List<? extends kotlin.reflect.jvm.internal.f<?>> invoke() {
                List<? extends kotlin.reflect.jvm.internal.f<?>> o4;
                o4 = kotlin.collections.f0.o4(this.f55983a.m(), this.f55983a.p());
                return o4;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class c extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55984a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(h<T>.a aVar) {
                super(0);
                this.f55984a = aVar;
            }

            @Override // d2.a
            public final List<? extends kotlin.reflect.jvm.internal.f<?>> invoke() {
                List<? extends kotlin.reflect.jvm.internal.f<?>> o4;
                o4 = kotlin.collections.f0.o4(this.f55984a.n(), this.f55984a.q());
                return o4;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class d extends Lambda implements d2.a<List<? extends Annotation>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55985a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(h<T>.a aVar) {
                super(0);
                this.f55985a = aVar;
            }

            @Override // d2.a
            public final List<? extends Annotation> invoke() {
                return f0.e(this.f55985a.o());
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/i;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class e extends Lambda implements d2.a<List<? extends kotlin.reflect.i<? extends T>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55986a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(h<T> hVar) {
                super(0);
                this.f55986a = hVar;
            }

            @Override // d2.a
            public final List<kotlin.reflect.i<T>> invoke() {
                int Z;
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> I = this.f55986a.I();
                h<T> hVar = this.f55986a;
                Z = kotlin.collections.y.Z(I, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (kotlin.reflect.jvm.internal.impl.descriptors.j jVar : I) {
                    arrayList.add(new kotlin.reflect.jvm.internal.j(hVar, jVar));
                }
                return arrayList;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class f extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55987a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h<T>.a aVar) {
                super(0);
                this.f55987a = aVar;
            }

            @Override // d2.a
            public final List<? extends kotlin.reflect.jvm.internal.f<?>> invoke() {
                List<? extends kotlin.reflect.jvm.internal.f<?>> o4;
                o4 = kotlin.collections.f0.o4(this.f55987a.m(), this.f55987a.n());
                return o4;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class g extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55988a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(h<T> hVar) {
                super(0);
                this.f55988a = hVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final Collection<kotlin.reflect.jvm.internal.f<?>> invoke() {
                h<T> hVar = this.f55988a;
                return hVar.L(hVar.Z(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.h$a$h  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1117h extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55989a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1117h(h<T> hVar) {
                super(0);
                this.f55989a = hVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final Collection<kotlin.reflect.jvm.internal.f<?>> invoke() {
                h<T> hVar = this.f55989a;
                return hVar.L(hVar.a0(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlin/reflect/jvm/internal/impl/descriptors/d;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/d;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class i extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.d> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55990a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(h<T> hVar) {
                super(0);
                this.f55990a = hVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke() {
                kotlin.reflect.jvm.internal.impl.name.b W = this.f55990a.W();
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k a4 = this.f55990a.X().invoke().a();
                kotlin.reflect.jvm.internal.impl.descriptors.d b4 = W.k() ? a4.a().b(W) : kotlin.reflect.jvm.internal.impl.descriptors.v.a(a4.b(), W);
                if (b4 != null) {
                    return b4;
                }
                this.f55990a.b0();
                throw null;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class j extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55991a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(h<T> hVar) {
                super(0);
                this.f55991a = hVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final Collection<kotlin.reflect.jvm.internal.f<?>> invoke() {
                h<T> hVar = this.f55991a;
                return hVar.L(hVar.Z(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class k extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55992a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            k(h<T> hVar) {
                super(0);
                this.f55992a = hVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final Collection<kotlin.reflect.jvm.internal.f<?>> invoke() {
                h<T> hVar = this.f55992a;
                return hVar.L(hVar.a0(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u00000\u0003 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/h;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class l extends Lambda implements d2.a<List<? extends h<? extends Object>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55993a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            l(h<T>.a aVar) {
                super(0);
                this.f55993a = aVar;
            }

            @Override // d2.a
            public final List<? extends h<? extends Object>> invoke() {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h U = this.f55993a.o().U();
                kotlin.jvm.internal.f0.o(U, "descriptor.unsubstitutedInnerClassesScope");
                Collection a4 = k.a.a(U, null, null, 3, null);
                ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.k> arrayList = new ArrayList();
                for (T t3 : a4) {
                    if (!kotlin.reflect.jvm.internal.impl.resolve.d.B((kotlin.reflect.jvm.internal.impl.descriptors.k) t3)) {
                        arrayList.add(t3);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.descriptors.k kVar : arrayList) {
                    kotlin.reflect.jvm.internal.impl.descriptors.d dVar = kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar : null;
                    Class<?> p3 = dVar == null ? null : f0.p(dVar);
                    h hVar = p3 == null ? null : new h(p3);
                    if (hVar != null) {
                        arrayList2.add(hVar);
                    }
                }
                return arrayList2;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class m extends Lambda implements d2.a<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55994a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h<T> f55995b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            m(h<T>.a aVar, h<T> hVar) {
                super(0);
                this.f55994a = aVar;
                this.f55995b = hVar;
            }

            @Override // d2.a
            @Nullable
            public final T invoke() {
                Field declaredField;
                kotlin.reflect.jvm.internal.impl.descriptors.d o4 = this.f55994a.o();
                if (o4.i() != ClassKind.OBJECT) {
                    return null;
                }
                if (o4.a0() && !kotlin.reflect.jvm.internal.impl.builtins.d.a(kotlin.reflect.jvm.internal.impl.builtins.c.f56021a, o4)) {
                    declaredField = this.f55995b.d().getEnclosingClass().getDeclaredField(o4.getName().b());
                } else {
                    declaredField = this.f55995b.d().getDeclaredField("INSTANCE");
                }
                T t3 = (T) declaredField.get(null);
                if (t3 != null) {
                    return t3;
                }
                throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class n extends Lambda implements d2.a<String> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55996a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            n(h<T> hVar) {
                super(0);
                this.f55996a = hVar;
            }

            @Override // d2.a
            @Nullable
            /* renamed from: a */
            public final String invoke() {
                if (this.f55996a.d().isAnonymousClass()) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.name.b W = this.f55996a.W();
                if (W.k()) {
                    return null;
                }
                return W.b().b();
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003 \u0004*\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/h;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class o extends Lambda implements d2.a<List<? extends h<? extends T>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55997a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            o(h<T>.a aVar) {
                super(0);
                this.f55997a = aVar;
            }

            @Override // d2.a
            public final List<h<? extends T>> invoke() {
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m4 = this.f55997a.o().m();
                kotlin.jvm.internal.f0.o(m4, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.descriptors.d dVar : m4) {
                    if (dVar != null) {
                        Class<?> p3 = f0.p(dVar);
                        h hVar = p3 == null ? null : new h(p3);
                        if (hVar != null) {
                            arrayList.add(hVar);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                }
                return arrayList;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class p extends Lambda implements d2.a<String> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T> f55998a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h<T>.a f55999b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            p(h<T> hVar, h<T>.a aVar) {
                super(0);
                this.f55998a = hVar;
                this.f55999b = aVar;
            }

            @Override // d2.a
            @Nullable
            /* renamed from: a */
            public final String invoke() {
                if (this.f55998a.d().isAnonymousClass()) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.name.b W = this.f55998a.W();
                if (W.k()) {
                    return this.f55999b.f(this.f55998a.d());
                }
                String b4 = W.j().b();
                kotlin.jvm.internal.f0.o(b4, "classId.shortClassName.asString()");
                return b4;
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/u;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class q extends Lambda implements d2.a<List<? extends u>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f56000a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h<T> f56001b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: KClassImpl.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: kotlin.reflect.jvm.internal.h$a$q$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class C1118a extends Lambda implements d2.a<Type> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.e0 f56002a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ h<T>.a f56003b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ h<T> f56004c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1118a(kotlin.reflect.jvm.internal.impl.types.e0 e0Var, h<T>.a aVar, h<T> hVar) {
                    super(0);
                    this.f56002a = e0Var;
                    this.f56003b = aVar;
                    this.f56004c = hVar;
                }

                @Override // d2.a
                @NotNull
                /* renamed from: a */
                public final Type invoke() {
                    int ff;
                    kotlin.reflect.jvm.internal.impl.descriptors.f b4 = this.f56002a.H0().b();
                    if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                        Class<?> p3 = f0.p((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
                        if (p3 != null) {
                            if (kotlin.jvm.internal.f0.g(this.f56004c.d().getSuperclass(), p3)) {
                                Type genericSuperclass = this.f56004c.d().getGenericSuperclass();
                                kotlin.jvm.internal.f0.o(genericSuperclass, "{\n                      \u2026ass\n                    }");
                                return genericSuperclass;
                            }
                            Class<?>[] interfaces = this.f56004c.d().getInterfaces();
                            kotlin.jvm.internal.f0.o(interfaces, "jClass.interfaces");
                            ff = kotlin.collections.p.ff(interfaces, p3);
                            if (ff >= 0) {
                                Type type = this.f56004c.d().getGenericInterfaces()[ff];
                                kotlin.jvm.internal.f0.o(type, "{\n                      \u2026ex]\n                    }");
                                return type;
                            }
                            throw new KotlinReflectionInternalError("No superclass of " + this.f56003b + " in Java reflection for " + b4);
                        }
                        throw new KotlinReflectionInternalError("Unsupported superclass of " + this.f56003b + ": " + b4);
                    }
                    throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Supertype not a class: ", b4));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: KClassImpl.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 6, 0})
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class b extends Lambda implements d2.a<Type> {

                /* renamed from: a  reason: collision with root package name */
                public static final b f56005a = new b();

                b() {
                    super(0);
                }

                @Override // d2.a
                @NotNull
                /* renamed from: a */
                public final Type invoke() {
                    return Object.class;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            q(h<T>.a aVar, h<T> hVar) {
                super(0);
                this.f56000a = aVar;
                this.f56001b = hVar;
            }

            @Override // d2.a
            public final List<? extends u> invoke() {
                boolean z3;
                Collection<kotlin.reflect.jvm.internal.impl.types.e0> j4 = this.f56000a.o().j().j();
                kotlin.jvm.internal.f0.o(j4, "descriptor.typeConstructor.supertypes");
                ArrayList<u> arrayList = new ArrayList(j4.size());
                h<T>.a aVar = this.f56000a;
                h<T> hVar = this.f56001b;
                for (kotlin.reflect.jvm.internal.impl.types.e0 kotlinType : j4) {
                    kotlin.jvm.internal.f0.o(kotlinType, "kotlinType");
                    arrayList.add(new u(kotlinType, new C1118a(kotlinType, aVar, hVar)));
                }
                if (!kotlin.reflect.jvm.internal.impl.builtins.h.s0(this.f56000a.o())) {
                    boolean z4 = false;
                    if (!arrayList.isEmpty()) {
                        for (u uVar : arrayList) {
                            ClassKind i4 = kotlin.reflect.jvm.internal.impl.resolve.d.e(uVar.getType()).i();
                            kotlin.jvm.internal.f0.o(i4, "getClassDescriptorForType(it.type).kind");
                            if (i4 == ClassKind.INTERFACE || i4 == ClassKind.ANNOTATION_CLASS) {
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                            if (!z3) {
                                break;
                            }
                        }
                    }
                    z4 = true;
                    if (z4) {
                        m0 i5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(this.f56000a.o()).i();
                        kotlin.jvm.internal.f0.o(i5, "descriptor.builtIns.anyType");
                        arrayList.add(new u(i5, b.f56005a));
                    }
                }
                return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
            }
        }

        /* compiled from: KClassImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/v;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class r extends Lambda implements d2.a<List<? extends v>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<T>.a f56006a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h<T> f56007b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            r(h<T>.a aVar, h<T> hVar) {
                super(0);
                this.f56006a = aVar;
                this.f56007b = hVar;
            }

            @Override // d2.a
            public final List<? extends v> invoke() {
                int Z;
                List<a1> r3 = this.f56006a.o().r();
                kotlin.jvm.internal.f0.o(r3, "descriptor.declaredTypeParameters");
                h<T> hVar = this.f56007b;
                Z = kotlin.collections.y.Z(r3, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (a1 descriptor : r3) {
                    kotlin.jvm.internal.f0.o(descriptor, "descriptor");
                    arrayList.add(new v(hVar, descriptor));
                }
                return arrayList;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h this$0) {
            super(this$0);
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f55981v = this$0;
            this.f55963d = y.c(new i(this$0));
            this.f55964e = y.c(new d(this));
            this.f55965f = y.c(new p(this$0, this));
            this.f55966g = y.c(new n(this$0));
            this.f55967h = y.c(new e(this$0));
            this.f55968i = y.c(new l(this));
            this.f55969j = y.b(new m(this, this$0));
            this.f55970k = y.c(new r(this, this$0));
            this.f55971l = y.c(new q(this, this$0));
            this.f55972m = y.c(new o(this));
            this.f55973n = y.c(new g(this$0));
            this.f55974o = y.c(new C1117h(this$0));
            this.f55975p = y.c(new j(this$0));
            this.f55976q = y.c(new k(this$0));
            this.f55977r = y.c(new b(this));
            this.f55978s = y.c(new c(this));
            this.f55979t = y.c(new f(this));
            this.f55980u = y.c(new C1116a(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(Class<?> cls) {
            String p5;
            String p52;
            String o5;
            String name = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod == null) {
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor == null) {
                    kotlin.jvm.internal.f0.o(name, "name");
                    o5 = kotlin.text.x.o5(name, '$', null, 2, null);
                    return o5;
                }
                kotlin.jvm.internal.f0.o(name, "name");
                p52 = kotlin.text.x.p5(name, kotlin.jvm.internal.f0.C(enclosingConstructor.getName(), "$"), null, 2, null);
                return p52;
            }
            kotlin.jvm.internal.f0.o(name, "name");
            p5 = kotlin.text.x.p5(name, kotlin.jvm.internal.f0.C(enclosingMethod.getName(), "$"), null, 2, null);
            return p5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<kotlin.reflect.jvm.internal.f<?>> n() {
            T b4 = this.f55974o.b(this, f55962w[11]);
            kotlin.jvm.internal.f0.o(b4, "<get-declaredStaticMembers>(...)");
            return (Collection) b4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<kotlin.reflect.jvm.internal.f<?>> p() {
            T b4 = this.f55975p.b(this, f55962w[12]);
            kotlin.jvm.internal.f0.o(b4, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) b4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<kotlin.reflect.jvm.internal.f<?>> q() {
            T b4 = this.f55976q.b(this, f55962w[13]);
            kotlin.jvm.internal.f0.o(b4, "<get-inheritedStaticMembers>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.f<?>> g() {
            T b4 = this.f55980u.b(this, f55962w[17]);
            kotlin.jvm.internal.f0.o(b4, "<get-allMembers>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.f<?>> h() {
            T b4 = this.f55977r.b(this, f55962w[14]);
            kotlin.jvm.internal.f0.o(b4, "<get-allNonStaticMembers>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.f<?>> i() {
            T b4 = this.f55978s.b(this, f55962w[15]);
            kotlin.jvm.internal.f0.o(b4, "<get-allStaticMembers>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final List<Annotation> j() {
            T b4 = this.f55964e.b(this, f55962w[1]);
            kotlin.jvm.internal.f0.o(b4, "<get-annotations>(...)");
            return (List) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.i<T>> k() {
            T b4 = this.f55967h.b(this, f55962w[4]);
            kotlin.jvm.internal.f0.o(b4, "<get-constructors>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.f<?>> l() {
            T b4 = this.f55979t.b(this, f55962w[16]);
            kotlin.jvm.internal.f0.o(b4, "<get-declaredMembers>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.f<?>> m() {
            T b4 = this.f55973n.b(this, f55962w[10]);
            kotlin.jvm.internal.f0.o(b4, "<get-declaredNonStaticMembers>(...)");
            return (Collection) b4;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.d o() {
            T b4 = this.f55963d.b(this, f55962w[0]);
            kotlin.jvm.internal.f0.o(b4, "<get-descriptor>(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
        }

        @NotNull
        public final Collection<kotlin.reflect.d<?>> r() {
            T b4 = this.f55968i.b(this, f55962w[5]);
            kotlin.jvm.internal.f0.o(b4, "<get-nestedClasses>(...)");
            return (Collection) b4;
        }

        @Nullable
        public final T s() {
            return this.f55969j.b(this, f55962w[6]);
        }

        @Nullable
        public final String t() {
            return (String) this.f55966g.b(this, f55962w[3]);
        }

        @NotNull
        public final List<kotlin.reflect.d<? extends T>> u() {
            T b4 = this.f55972m.b(this, f55962w[9]);
            kotlin.jvm.internal.f0.o(b4, "<get-sealedSubclasses>(...)");
            return (List) b4;
        }

        @Nullable
        public final String v() {
            return (String) this.f55965f.b(this, f55962w[2]);
        }

        @NotNull
        public final List<kotlin.reflect.r> w() {
            T b4 = this.f55971l.b(this, f55962w[8]);
            kotlin.jvm.internal.f0.o(b4, "<get-supertypes>(...)");
            return (List) b4;
        }

        @NotNull
        public final List<kotlin.reflect.s> x() {
            T b4 = this.f55970k.b(this, f55962w[7]);
            kotlin.jvm.internal.f0.o(b4, "<get-typeParameters>(...)");
            return (List) b4;
        }
    }

    /* compiled from: KClassImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56008a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            f56008a = iArr;
        }
    }

    /* compiled from: KClassImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e \u0004*\u000e\u0018\u00010\u0002R\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002R\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "Lkotlin/reflect/jvm/internal/h$a;", "Lkotlin/reflect/jvm/internal/h;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/h$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<h<T>.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h<T> f56009a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(h<T> hVar) {
            super(0);
            this.f56009a = hVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final h<T>.a invoke() {
            return new a(this.f56009a);
        }
    }

    /* compiled from: KClassImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class d extends FunctionReference implements d2.p<kotlin.reflect.jvm.internal.impl.serialization.deserialization.u, ProtoBuf.Property, p0> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56010a = new d();

        d() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: d */
        public final p0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.u p02, @NotNull ProtoBuf.Property p12) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            kotlin.jvm.internal.f0.p(p12, "p1");
            return p02.l(p12);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(kotlin.reflect.jvm.internal.impl.serialization.deserialization.u.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }
    }

    public h(@NotNull Class<T> jClass) {
        kotlin.jvm.internal.f0.p(jClass, "jClass");
        this.f55960d = jClass;
        y.b<h<T>.a> b4 = y.b(new c(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Data() }");
        this.f55961e = b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.name.b W() {
        return b0.f55877a.c(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void b0() {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f.f56550c.a(d());
        KotlinClassHeader.Kind c4 = a4 == null ? null : a4.e().c();
        switch (c4 == null ? -1 : b.f56008a[c4.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Unresolved class: ", d()));
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
                throw new UnsupportedOperationException(kotlin.jvm.internal.f0.C("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: ", d()));
            case 4:
                throw new UnsupportedOperationException(kotlin.jvm.internal.f0.C("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: ", d()));
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + d() + " (kind = " + c4 + ')');
        }
    }

    @Override // kotlin.reflect.d
    @Nullable
    public T A() {
        return this.f55961e.invoke().s();
    }

    @Override // kotlin.reflect.d
    public boolean B() {
        return e().a0();
    }

    @Override // kotlin.reflect.d
    public boolean C(@Nullable Object obj) {
        Integer c4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.c(d());
        if (c4 == null) {
            Class g4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.g(d());
            if (g4 == null) {
                g4 = d();
            }
            return g4.isInstance(obj);
        }
        return t0.B(obj, c4.intValue());
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String D() {
        return this.f55961e.invoke().t();
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String E() {
        return this.f55961e.invoke().v();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> I() {
        List F;
        kotlin.reflect.jvm.internal.impl.descriptors.d e4 = e();
        if (e4.i() != ClassKind.INTERFACE && e4.i() != ClassKind.OBJECT) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g4 = e4.g();
            kotlin.jvm.internal.f0.o(g4, "descriptor.constructors");
            return g4;
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w> J(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        List o4;
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h Z = Z();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        o4 = kotlin.collections.f0.o4(Z.a(name, noLookupLocation), a0().a(name, noLookupLocation));
        return o4;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public p0 K(int i4) {
        Class<?> declaringClass;
        if (kotlin.jvm.internal.f0.g(d().getSimpleName(), "DefaultImpls") && (declaringClass = d().getDeclaringClass()) != null && declaringClass.isInterface()) {
            return ((h) c2.a.g(declaringClass)).K(i4);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d e4 = e();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e eVar = e4 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) e4 : null;
        if (eVar == null) {
            return null;
        }
        ProtoBuf.Class U0 = eVar.U0();
        GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = JvmProtoBuf.f57496j;
        kotlin.jvm.internal.f0.o(classLocalVariable, "classLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.b(U0, classLocalVariable, i4);
        if (property == null) {
            return null;
        }
        return (p0) f0.h(d(), property, eVar.T0().g(), eVar.T0().j(), eVar.W0(), d.f56010a);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<p0> N(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        List o4;
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h Z = Z();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        o4 = kotlin.collections.f0.o4(Z.c(name, noLookupLocation), a0().c(name, noLookupLocation));
        return o4;
    }

    @NotNull
    public final y.b<h<T>.a> X() {
        return this.f55961e;
    }

    @Override // kotlin.reflect.jvm.internal.i
    @NotNull
    /* renamed from: Y */
    public kotlin.reflect.jvm.internal.impl.descriptors.d e() {
        return this.f55961e.invoke().o();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h Z() {
        return e().q().p();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h k02 = e().k0();
        kotlin.jvm.internal.f0.o(k02, "descriptor.staticScope");
        return k02;
    }

    @Override // kotlin.jvm.internal.r
    @NotNull
    public Class<T> d() {
        return this.f55960d;
    }

    @Override // kotlin.reflect.d
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof h) && kotlin.jvm.internal.f0.g(c2.a.e(this), c2.a.e((kotlin.reflect.d) obj));
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.i<T>> g() {
        return this.f55961e.invoke().k();
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.f55961e.invoke().j();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.s> getTypeParameters() {
        return this.f55961e.invoke().x();
    }

    @Override // kotlin.reflect.d
    @Nullable
    public KVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = e().getVisibility();
        kotlin.jvm.internal.f0.o(visibility, "descriptor.visibility");
        return f0.q(visibility);
    }

    @Override // kotlin.reflect.d
    public int hashCode() {
        return c2.a.e(this).hashCode();
    }

    @Override // kotlin.reflect.d
    public boolean isAbstract() {
        return e().s() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.d
    public boolean isFinal() {
        return e().s() == Modality.FINAL;
    }

    @Override // kotlin.reflect.d
    public boolean isOpen() {
        return e().s() == Modality.OPEN;
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.r> j() {
        return this.f55961e.invoke().w();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.d<? extends T>> m() {
        return this.f55961e.invoke().u();
    }

    @Override // kotlin.reflect.d
    public boolean n() {
        return e().n();
    }

    @Override // kotlin.reflect.d
    public boolean p() {
        return e().s() == Modality.SEALED;
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> q() {
        return this.f55961e.invoke().g();
    }

    @Override // kotlin.reflect.d
    public boolean t() {
        return e().t();
    }

    @NotNull
    public String toString() {
        String j22;
        kotlin.reflect.jvm.internal.impl.name.b W = W();
        kotlin.reflect.jvm.internal.impl.name.c h4 = W.h();
        kotlin.jvm.internal.f0.o(h4, "classId.packageFqName");
        String C = h4.d() ? "" : kotlin.jvm.internal.f0.C(h4.b(), ".");
        String b4 = W.i().b();
        kotlin.jvm.internal.f0.o(b4, "classId.relativeClassName.asString()");
        j22 = kotlin.text.w.j2(b4, '.', '$', false, 4, null);
        return kotlin.jvm.internal.f0.C("class ", kotlin.jvm.internal.f0.C(C, j22));
    }

    @Override // kotlin.reflect.d
    public boolean v() {
        return e().v();
    }

    @Override // kotlin.reflect.d
    public boolean y() {
        return e().y();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.d<?>> z() {
        return this.f55961e.invoke().r();
    }
}
