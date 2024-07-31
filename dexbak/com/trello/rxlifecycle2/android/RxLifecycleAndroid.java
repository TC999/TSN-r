package com.trello.rxlifecycle2.android;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.OutsideLifecycleException;
import com.trello.rxlifecycle2.RxLifecycle;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import p657x0.C16238a;

/* renamed from: com.trello.rxlifecycle2.android.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RxLifecycleAndroid {

    /* renamed from: a */
    private static final Function<ActivityEvent, ActivityEvent> f37479a = new C13084a();

    /* renamed from: b */
    private static final Function<FragmentEvent, FragmentEvent> f37480b = new C13085b();

    /* compiled from: RxLifecycleAndroid.java */
    /* renamed from: com.trello.rxlifecycle2.android.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13084a implements Function<ActivityEvent, ActivityEvent> {
        C13084a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ActivityEvent apply(ActivityEvent activityEvent) throws Exception {
            switch (C13086c.f37481a[activityEvent.ordinal()]) {
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

    /* compiled from: RxLifecycleAndroid.java */
    /* renamed from: com.trello.rxlifecycle2.android.b$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13085b implements Function<FragmentEvent, FragmentEvent> {
        C13085b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public FragmentEvent apply(FragmentEvent fragmentEvent) throws Exception {
            switch (C13086c.f37482b[fragmentEvent.ordinal()]) {
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
    /* compiled from: RxLifecycleAndroid.java */
    /* renamed from: com.trello.rxlifecycle2.android.b$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C13086c {

        /* renamed from: a */
        static final /* synthetic */ int[] f37481a;

        /* renamed from: b */
        static final /* synthetic */ int[] f37482b;

        static {
            int[] iArr = new int[FragmentEvent.values().length];
            f37482b = iArr;
            try {
                iArr[FragmentEvent.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37482b[FragmentEvent.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37482b[FragmentEvent.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37482b[FragmentEvent.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37482b[FragmentEvent.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37482b[FragmentEvent.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37482b[FragmentEvent.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37482b[FragmentEvent.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37482b[FragmentEvent.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37482b[FragmentEvent.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[ActivityEvent.values().length];
            f37481a = iArr2;
            try {
                iArr2[ActivityEvent.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f37481a[ActivityEvent.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f37481a[ActivityEvent.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f37481a[ActivityEvent.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f37481a[ActivityEvent.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f37481a[ActivityEvent.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    private RxLifecycleAndroid() {
        throw new AssertionError("No instances");
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public static <T> LifecycleTransformer<T> m14890a(@NonNull Observable<ActivityEvent> observable) {
        return RxLifecycle.m14872b(observable, f37479a);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static <T> LifecycleTransformer<T> m14889b(@NonNull Observable<FragmentEvent> observable) {
        return RxLifecycle.m14872b(observable, f37480b);
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public static <T> LifecycleTransformer<T> m14888c(@NonNull View view) {
        C16238a.m40a(view, "view == null");
        return RxLifecycle.m14873a(Observable.create(new ViewDetachesOnSubscribe(view)));
    }
}
