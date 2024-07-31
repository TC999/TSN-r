package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import p640rx.Completable;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Single;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    @Nullable
    private final Scheduler scheduler;

    private RxJavaCallAdapterFactory(@Nullable Scheduler scheduler, boolean z) {
        this.scheduler = scheduler;
        this.isAsync = z;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory(null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            return new RxJavaCallAdapterFactory(scheduler, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        boolean z3 = rawType == Single.class;
        boolean z4 = rawType == Completable.class;
        if (rawType == Observable.class || z3 || z4) {
            if (z4) {
                return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
            }
            if (!(type instanceof ParameterizedType)) {
                String str = z3 ? "Single" : "Observable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
            if (rawType2 == Response.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    z = false;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (rawType2 == Result.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    z = true;
                } else {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
            } else {
                type2 = parameterUpperBound;
                z = false;
                z2 = true;
                return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z, z2, z3, false);
            }
            z2 = false;
            return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z, z2, z3, false);
        }
        return null;
    }
}
