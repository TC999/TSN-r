package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import com.bumptech.glide.util.C3771k;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private final int f13326a;

    /* renamed from: b */
    private final C3553d f13327b;

    /* renamed from: c */
    private final C3558j f13328c;

    /* renamed from: d */
    private final InterfaceC3550a<T> f13329d;

    /* renamed from: e */
    private final InterfaceC3551b<T> f13330e;

    /* renamed from: f */
    private int f13331f;

    /* renamed from: g */
    private int f13332g;

    /* renamed from: i */
    private int f13334i;

    /* renamed from: h */
    private int f13333h = -1;

    /* renamed from: j */
    private boolean f13335j = true;

    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3550a<U> {
        @NonNull
        /* renamed from: a */
        List<U> m45623a(int i);

        @Nullable
        /* renamed from: b */
        RequestBuilder<?> m45622b(@NonNull U u);
    }

    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.g$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3551b<T> {
        @Nullable
        /* renamed from: a */
        int[] mo44367a(@NonNull T t, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.g$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3552c extends BaseTarget<Object> {

        /* renamed from: b */
        int f13336b;

        /* renamed from: c */
        int f13337c;

        C3552c() {
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: b */
        public void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: k */
        public void mo44364k(@NonNull Object obj, @Nullable InterfaceC3759f<? super Object> interfaceC3759f) {
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: q */
        public void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.mo44365e(this.f13337c, this.f13336b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.g$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3553d {

        /* renamed from: a */
        private final Queue<C3552c> f13338a;

        C3553d(int i) {
            this.f13338a = C3771k.m44385f(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f13338a.offer(new C3552c());
            }
        }

        /* renamed from: a */
        public C3552c m45621a(int i, int i2) {
            C3552c poll = this.f13338a.poll();
            this.f13338a.offer(poll);
            poll.f13337c = i;
            poll.f13336b = i2;
            return poll;
        }
    }

    public ListPreloader(@NonNull C3558j c3558j, @NonNull InterfaceC3550a<T> interfaceC3550a, @NonNull InterfaceC3551b<T> interfaceC3551b, int i) {
        this.f13328c = c3558j;
        this.f13329d = interfaceC3550a;
        this.f13330e = interfaceC3551b;
        this.f13326a = i;
        this.f13327b = new C3553d(i + 1);
    }

    /* renamed from: a */
    private void m45628a() {
        for (int i = 0; i < this.f13326a; i++) {
            this.f13328c.m45490z(this.f13327b.m45621a(0, 0));
        }
    }

    /* renamed from: b */
    private void m45627b(int i, int i2) {
        int min;
        int i3;
        if (i < i2) {
            i3 = Math.max(this.f13331f, i);
            min = i2;
        } else {
            min = Math.min(this.f13332g, i);
            i3 = i2;
        }
        int min2 = Math.min(this.f13334i, min);
        int min3 = Math.min(this.f13334i, Math.max(0, i3));
        if (i < i2) {
            for (int i4 = min3; i4 < min2; i4++) {
                m45625d(this.f13329d.m45623a(i4), i4, true);
            }
        } else {
            for (int i5 = min2 - 1; i5 >= min3; i5--) {
                m45625d(this.f13329d.m45623a(i5), i5, false);
            }
        }
        this.f13332g = min3;
        this.f13331f = min2;
    }

    /* renamed from: c */
    private void m45626c(int i, boolean z) {
        if (this.f13335j != z) {
            this.f13335j = z;
            m45628a();
        }
        m45627b(i, (z ? this.f13326a : -this.f13326a) + i);
    }

    /* renamed from: d */
    private void m45625d(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                m45624e(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            m45624e(list.get(i3), i, i3);
        }
    }

    /* renamed from: e */
    private void m45624e(@Nullable T t, int i, int i2) {
        int[] mo44367a;
        RequestBuilder<?> m45622b;
        if (t == null || (mo44367a = this.f13330e.mo44367a(t, i, i2)) == null || (m45622b = this.f13329d.m45622b(t)) == null) {
            return;
        }
        m45622b.m45554f1(this.f13327b.m45621a(mo44367a[0], mo44367a[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f13334i = i3;
        int i4 = this.f13333h;
        if (i > i4) {
            m45626c(i2 + i, true);
        } else if (i < i4) {
            m45626c(i, false);
        }
        this.f13333h = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
