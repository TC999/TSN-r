package com.facebook.rebound;

import com.facebook.rebound.ChoreographerCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class AnimationQueue {

    /* renamed from: g  reason: collision with root package name */
    private boolean f37018g;

    /* renamed from: b  reason: collision with root package name */
    private final Queue<Double> f37013b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private final Queue<Double> f37014c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    private final List<Callback> f37015d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<Double> f37016e = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private final ChoreographerCompat f37012a = ChoreographerCompat.e();

    /* renamed from: f  reason: collision with root package name */
    private final ChoreographerCompat.FrameCallback f37017f = new ChoreographerCompat.FrameCallback() { // from class: com.facebook.rebound.AnimationQueue.1
        @Override // com.facebook.rebound.ChoreographerCompat.FrameCallback
        public void a(long j4) {
            AnimationQueue.this.g(j4);
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface Callback {
        void a(Double d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j4) {
        int max;
        Double poll = this.f37013b.poll();
        if (poll != null) {
            this.f37014c.offer(poll);
            max = 0;
        } else {
            max = Math.max(this.f37015d.size() - this.f37014c.size(), 0);
        }
        this.f37016e.addAll(this.f37014c);
        int size = this.f37016e.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Double d4 = this.f37016e.get(size);
            int size2 = ((this.f37016e.size() - 1) - size) + max;
            if (this.f37015d.size() > size2) {
                this.f37015d.get(size2).a(d4);
            }
        }
        this.f37016e.clear();
        while (this.f37014c.size() + max >= this.f37015d.size()) {
            this.f37014c.poll();
        }
        if (this.f37014c.isEmpty() && this.f37013b.isEmpty()) {
            this.f37018g = false;
        } else {
            this.f37012a.f(this.f37017f);
        }
    }

    private void i() {
        if (this.f37018g) {
            return;
        }
        this.f37018g = true;
        this.f37012a.f(this.f37017f);
    }

    public void b(Collection<Double> collection) {
        this.f37013b.addAll(collection);
        i();
    }

    public void c(Callback callback) {
        this.f37015d.add(callback);
    }

    public void d(Double d4) {
        this.f37013b.add(d4);
        i();
    }

    public void e() {
        this.f37015d.clear();
    }

    public void f() {
        this.f37013b.clear();
    }

    public void h(Callback callback) {
        this.f37015d.remove(callback);
    }
}
