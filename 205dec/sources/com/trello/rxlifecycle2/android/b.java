package com.trello.rxlifecycle2.android;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.trello.rxlifecycle2.OutsideLifecycleException;
import com.trello.rxlifecycle2.d;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RxLifecycleAndroid.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Function<ActivityEvent, ActivityEvent> f52377a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Function<FragmentEvent, FragmentEvent> f52378b = new C1050b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RxLifecycleAndroid.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class a implements Function<ActivityEvent, ActivityEvent> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ActivityEvent apply(ActivityEvent activityEvent) throws Exception {
            switch (c.f52379a[activityEvent.ordinal()]) {
                case 1:
                    return ActivityEvent.DESTROY;
                case 2:
                    return ActivityEvent.STOP;
                case 3:
                    return ActivityEvent.PAUSE;
                case 4:
                    return ActivityEvent.STOP;
                case 5:
                    return ActivityEvent.DESTROY;
                case 6:
                    throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + activityEvent + " not yet implemented");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RxLifecycleAndroid.java */
    /* renamed from: com.trello.rxlifecycle2.android.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class C1050b implements Function<FragmentEvent, FragmentEvent> {
        C1050b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public FragmentEvent apply(FragmentEvent fragmentEvent) throws Exception {
            switch (c.f52380b[fragmentEvent.ordinal()]) {
                case 1:
                    return FragmentEvent.DETACH;
                case 2:
                    return FragmentEvent.DESTROY;
                case 3:
                    return FragmentEvent.DESTROY_VIEW;
                case 4:
                    return FragmentEvent.STOP;
                case 5:
                    return FragmentEvent.PAUSE;
                case 6:
                    return FragmentEvent.STOP;
                case 7:
                    return FragmentEvent.DESTROY_VIEW;
                case 8:
                    return FragmentEvent.DESTROY;
                case 9:
                    return FragmentEvent.DETACH;
                case 10:
                    throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + fragmentEvent + " not yet implemented");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RxLifecycleAndroid.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f52379a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f52380b;

        static {
            int[] iArr = new int[FragmentEvent.values().length];
            f52380b = iArr;
            try {
                iArr[FragmentEvent.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52380b[FragmentEvent.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52380b[FragmentEvent.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52380b[FragmentEvent.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52380b[FragmentEvent.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52380b[FragmentEvent.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52380b[FragmentEvent.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f52380b[FragmentEvent.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f52380b[FragmentEvent.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f52380b[FragmentEvent.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[ActivityEvent.values().length];
            f52379a = iArr2;
            try {
                iArr2[ActivityEvent.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f52379a[ActivityEvent.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f52379a[ActivityEvent.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f52379a[ActivityEvent.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f52379a[ActivityEvent.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f52379a[ActivityEvent.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    private b() {
        throw new AssertionError("No instances");
    }

    @NonNull
    @CheckResult
    public static <T> com.trello.rxlifecycle2.c<T> a(@NonNull Observable<ActivityEvent> observable) {
        return d.b(observable, f52377a);
    }

    @NonNull
    @CheckResult
    public static <T> com.trello.rxlifecycle2.c<T> b(@NonNull Observable<FragmentEvent> observable) {
        return d.b(observable, f52378b);
    }

    @NonNull
    @CheckResult
    public static <T> com.trello.rxlifecycle2.c<T> c(@NonNull View view) {
        x0.a.a(view, "view == null");
        return d.a(Observable.create(new com.trello.rxlifecycle2.android.c(view)));
    }
}
