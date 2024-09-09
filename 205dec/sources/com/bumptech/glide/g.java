package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.o;
import java.util.List;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ListPreloader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class g<T> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f16670a;

    /* renamed from: b  reason: collision with root package name */
    private final d f16671b;

    /* renamed from: c  reason: collision with root package name */
    private final j f16672c;

    /* renamed from: d  reason: collision with root package name */
    private final a<T> f16673d;

    /* renamed from: e  reason: collision with root package name */
    private final b<T> f16674e;

    /* renamed from: f  reason: collision with root package name */
    private int f16675f;

    /* renamed from: g  reason: collision with root package name */
    private int f16676g;

    /* renamed from: i  reason: collision with root package name */
    private int f16678i;

    /* renamed from: h  reason: collision with root package name */
    private int f16677h = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16679j = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ListPreloader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a<U> {
        @NonNull
        List<U> a(int i4);

        @Nullable
        i<?> b(@NonNull U u3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ListPreloader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b<T> {
        @Nullable
        int[] a(@NonNull T t3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ListPreloader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class c extends com.bumptech.glide.request.target.b<Object> {

        /* renamed from: b  reason: collision with root package name */
        int f16680b;

        /* renamed from: c  reason: collision with root package name */
        int f16681c;

        c() {
        }

        @Override // com.bumptech.glide.request.target.p
        public void b(@NonNull o oVar) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void k(@NonNull Object obj, @Nullable com.bumptech.glide.request.transition.f<? super Object> fVar) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void q(@NonNull o oVar) {
            oVar.e(this.f16681c, this.f16680b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ListPreloader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<c> f16682a;

        d(int i4) {
            this.f16682a = com.bumptech.glide.util.k.f(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                this.f16682a.offer(new c());
            }
        }

        public c a(int i4, int i5) {
            c poll = this.f16682a.poll();
            this.f16682a.offer(poll);
            poll.f16681c = i4;
            poll.f16680b = i5;
            return poll;
        }
    }

    public g(@NonNull j jVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i4) {
        this.f16672c = jVar;
        this.f16673d = aVar;
        this.f16674e = bVar;
        this.f16670a = i4;
        this.f16671b = new d(i4 + 1);
    }

    private void a() {
        for (int i4 = 0; i4 < this.f16670a; i4++) {
            this.f16672c.z(this.f16671b.a(0, 0));
        }
    }

    private void b(int i4, int i5) {
        int min;
        int i6;
        if (i4 < i5) {
            i6 = Math.max(this.f16675f, i4);
            min = i5;
        } else {
            min = Math.min(this.f16676g, i4);
            i6 = i5;
        }
        int min2 = Math.min(this.f16678i, min);
        int min3 = Math.min(this.f16678i, Math.max(0, i6));
        if (i4 < i5) {
            for (int i7 = min3; i7 < min2; i7++) {
                d(this.f16673d.a(i7), i7, true);
            }
        } else {
            for (int i8 = min2 - 1; i8 >= min3; i8--) {
                d(this.f16673d.a(i8), i8, false);
            }
        }
        this.f16676g = min3;
        this.f16675f = min2;
    }

    private void c(int i4, boolean z3) {
        if (this.f16679j != z3) {
            this.f16679j = z3;
            a();
        }
        b(i4, (z3 ? this.f16670a : -this.f16670a) + i4);
    }

    private void d(List<T> list, int i4, boolean z3) {
        int size = list.size();
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                e(list.get(i5), i4, i5);
            }
            return;
        }
        for (int i6 = size - 1; i6 >= 0; i6--) {
            e(list.get(i6), i4, i6);
        }
    }

    private void e(@Nullable T t3, int i4, int i5) {
        int[] a4;
        i<?> b4;
        if (t3 == null || (a4 = this.f16674e.a(t3, i4, i5)) == null || (b4 = this.f16673d.b(t3)) == null) {
            return;
        }
        b4.f1(this.f16671b.a(a4[0], a4[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        this.f16678i = i6;
        int i7 = this.f16677h;
        if (i4 > i7) {
            c(i5 + i4, true);
        } else if (i4 < i7) {
            c(i4, false);
        }
        this.f16677h = i4;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i4) {
    }
}
