package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.p353f.C9490b;
import com.kwad.framework.filedownloader.p353f.C9498d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* renamed from: com.kwad.framework.filedownloader.event.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9483a {
    private final Executor ahb = C9490b.m28551o(10, "EventPool");
    private final HashMap<String, LinkedList<AbstractC9486c>> ahc = new HashMap<>();

    /* renamed from: a */
    public final boolean m28565a(String str, AbstractC9486c abstractC9486c) {
        boolean add;
        if (C9498d.ail) {
            C9498d.m28533e(this, "setListener %s", str);
        }
        if (abstractC9486c != null) {
            LinkedList<AbstractC9486c> linkedList = this.ahc.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = this.ahc.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<AbstractC9486c>> hashMap = this.ahc;
                        LinkedList<AbstractC9486c> linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(abstractC9486c);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    /* renamed from: b */
    public final boolean m28563b(AbstractC9485b abstractC9485b) {
        if (C9498d.ail) {
            C9498d.m28533e(this, "publish %s", abstractC9485b.getId());
        }
        if (abstractC9485b != null) {
            String id = abstractC9485b.getId();
            LinkedList<AbstractC9486c> linkedList = this.ahc.get(id);
            if (linkedList == null) {
                synchronized (id.intern()) {
                    linkedList = this.ahc.get(id);
                    if (linkedList == null) {
                        if (C9498d.ail) {
                            C9498d.m28535c(this, "No listener for this event %s", id);
                        }
                        return false;
                    }
                }
            }
            m28564a(linkedList, abstractC9485b);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    /* renamed from: c */
    public final void m28562c(final AbstractC9485b abstractC9485b) {
        if (C9498d.ail) {
            C9498d.m28533e(this, "asyncPublishInNewThread %s", abstractC9485b.getId());
        }
        this.ahb.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C9483a.this.m28563b(abstractC9485b);
                } catch (Exception unused) {
                }
            }
        });
    }

    /* renamed from: a */
    private static void m28564a(LinkedList<AbstractC9486c> linkedList, AbstractC9485b abstractC9485b) {
        Object[] array;
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((AbstractC9486c) obj).mo28561a(abstractC9485b);
            }
        }
        Runnable runnable = abstractC9485b.ahh;
        if (runnable != null) {
            runnable.run();
        }
    }
}
