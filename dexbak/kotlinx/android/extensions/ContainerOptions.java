package kotlinx.android.extensions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* compiled from: ContainerOptions.kt */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/android/extensions/ContainerOptions;", "", "cache", "Lkotlinx/android/extensions/CacheImplementation;", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface ContainerOptions {
    CacheImplementation cache() default CacheImplementation.HASH_MAP;
}
