package cn.jiguang.cd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final k f3313a;

    public l(k kVar) {
        this.f3313a = kVar;
    }

    private cn.jiguang.ce.g a(boolean z3, StackTraceElement[] stackTraceElementArr, Thread thread) {
        cn.jiguang.ce.g gVar = new cn.jiguang.ce.g();
        gVar.a(thread.getName());
        gVar.a(Integer.valueOf(thread.getPriority()));
        gVar.a(Long.valueOf(thread.getId()));
        gVar.c(Boolean.valueOf(thread.isDaemon()));
        gVar.b(thread.getState().name());
        gVar.a(Boolean.valueOf(z3));
        gVar.b(Boolean.valueOf(cn.jiguang.cj.a.a(thread)));
        cn.jiguang.ce.f fVar = new cn.jiguang.ce.f(this.f3313a.a(stackTraceElementArr));
        fVar.a(Boolean.TRUE);
        gVar.a(fVar);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<cn.jiguang.ce.g> a(List<Long> list) {
        return a(Thread.getAllStackTraces(), list);
    }

    List<cn.jiguang.ce.g> a(Map<Thread, StackTraceElement[]> map, List<Long> list) {
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(a(key == currentThread || (list != null && list.contains(Long.valueOf(key.getId()))), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}
