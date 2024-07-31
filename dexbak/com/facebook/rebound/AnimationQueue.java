package com.facebook.rebound;

import com.facebook.rebound.ChoreographerCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AnimationQueue {

    /* renamed from: g */
    private boolean f23422g;

    /* renamed from: b */
    private final Queue<Double> f23417b = new LinkedList();

    /* renamed from: c */
    private final Queue<Double> f23418c = new LinkedList();

    /* renamed from: d */
    private final List<Callback> f23419d = new ArrayList();

    /* renamed from: e */
    private final ArrayList<Double> f23420e = new ArrayList<>();

    /* renamed from: a */
    private final ChoreographerCompat f23416a = ChoreographerCompat.m35613e();

    /* renamed from: f */
    private final ChoreographerCompat.FrameCallback f23421f = new ChoreographerCompat.FrameCallback() { // from class: com.facebook.rebound.AnimationQueue.1
        @Override // com.facebook.rebound.ChoreographerCompat.FrameCallback
        /* renamed from: a */
        public void mo35609a(long j) {
            AnimationQueue.this.m35645g(j);
        }
    };

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface Callback {
        /* renamed from: a */
        void m35642a(Double d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m35645g(long j) {
        int max;
        Double poll = this.f23417b.poll();
        if (poll != null) {
            this.f23418c.offer(poll);
            max = 0;
        } else {
            max = Math.max(this.f23419d.size() - this.f23418c.size(), 0);
        }
        this.f23420e.addAll(this.f23418c);
        int size = this.f23420e.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Double d = this.f23420e.get(size);
            int size2 = ((this.f23420e.size() - 1) - size) + max;
            if (this.f23419d.size() > size2) {
                this.f23419d.get(size2).m35642a(d);
            }
        }
        this.f23420e.clear();
        while (this.f23418c.size() + max >= this.f23419d.size()) {
            this.f23418c.poll();
        }
        if (this.f23418c.isEmpty() && this.f23417b.isEmpty()) {
            this.f23422g = false;
        } else {
            this.f23416a.m35612f(this.f23421f);
        }
    }

    /* renamed from: i */
    private void m35643i() {
        if (this.f23422g) {
            return;
        }
        this.f23422g = true;
        this.f23416a.m35612f(this.f23421f);
    }

    /* renamed from: b */
    public void m35650b(Collection<Double> collection) {
        this.f23417b.addAll(collection);
        m35643i();
    }

    /* renamed from: c */
    public void m35649c(Callback callback) {
        this.f23419d.add(callback);
    }

    /* renamed from: d */
    public void m35648d(Double d) {
        this.f23417b.add(d);
        m35643i();
    }

    /* renamed from: e */
    public void m35647e() {
        this.f23419d.clear();
    }

    /* renamed from: f */
    public void m35646f() {
        this.f23417b.clear();
    }

    /* renamed from: h */
    public void m35644h(Callback callback) {
        this.f23419d.remove(callback);
    }
}
