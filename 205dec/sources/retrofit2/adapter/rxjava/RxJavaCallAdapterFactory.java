package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.b;
import rx.e;
import rx.h;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    @Nullable
    private final h scheduler;

    private RxJavaCallAdapterFactory(@Nullable h hVar, boolean z3) {
        this.scheduler = hVar;
        this.isAsync = z3;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory(null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(h hVar) {
        if (hVar != null) {
            return new RxJavaCallAdapterFactory(hVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        boolean z3;
        boolean z4;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        boolean z5 = rawType == i.class;
        boolean z6 = rawType == b.class;
        if (rawType == e.class || z5 || z6) {
            if (z6) {
                return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
            }
            if (!(type instanceof ParameterizedType)) {
                String str = z5 ? "Single" : "Observable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
            if (rawType2 == Response.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    z3 = false;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (rawType2 == Result.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    z3 = true;
                } else {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
            } else {
                type2 = parameterUpperBound;
                z3 = false;
                z4 = true;
                return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z3, z4, z5, false);
            }
            z4 = false;
            return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z3, z4, z5, false);
        }
        return null;
    }
}
