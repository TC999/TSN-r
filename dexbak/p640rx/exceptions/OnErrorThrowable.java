package p640rx.exceptions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import p640rx.plugins.RxJavaPlugins;

/* renamed from: rx.exceptions.OnErrorThrowable */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    /* renamed from: rx.exceptions.OnErrorThrowable$OnNextValue */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.exceptions.OnErrorThrowable$OnNextValue$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15574a {

            /* renamed from: a */
            static final Set<Class<?>> f44788a = m1479a();

            C15574a() {
            }

            /* renamed from: a */
            private static Set<Class<?>> m1479a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th) {
                    obj = th.getMessage();
                }
            }
            this.value = obj;
        }

        static String renderValue(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (C15574a.f44788a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String m586b = RxJavaPlugins.m507c().m508b().m586b(obj);
            if (m586b != null) {
                return m586b;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object getValue() {
            return this.value;
        }
    }

    private OnErrorThrowable(Throwable th) {
        super(th);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable m1477b = C15575a.m1477b(th);
        if ((m1477b instanceof OnNextValue) && ((OnNextValue) m1477b).getValue() == obj) {
            return th;
        }
        C15575a.m1478a(th, new OnNextValue(obj));
        return th;
    }

    public static OnErrorThrowable from(Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable m1477b = C15575a.m1477b(th);
        if (m1477b instanceof OnNextValue) {
            return new OnErrorThrowable(th, ((OnNextValue) m1477b).getValue());
        }
        return new OnErrorThrowable(th);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    private OnErrorThrowable(Throwable th, Object obj) {
        super(th);
        this.hasValue = true;
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th2) {
                obj = th2.getMessage();
            }
        }
        this.value = obj;
    }
}
