package p640rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: rx.exceptions.CompositeException */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* renamed from: rx.exceptions.CompositeException$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15570a extends RuntimeException {

        /* renamed from: a */
        static final String f44785a = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        C15570a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return f44785a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.exceptions.CompositeException$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15571b {
        AbstractC15571b() {
        }

        /* renamed from: a */
        abstract Object mo1481a();

        /* renamed from: b */
        abstract void mo1480b(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.exceptions.CompositeException$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15572c extends AbstractC15571b {

        /* renamed from: a */
        private final PrintStream f44786a;

        C15572c(PrintStream printStream) {
            this.f44786a = printStream;
        }

        @Override // p640rx.exceptions.CompositeException.AbstractC15571b
        /* renamed from: a */
        Object mo1481a() {
            return this.f44786a;
        }

        @Override // p640rx.exceptions.CompositeException.AbstractC15571b
        /* renamed from: b */
        void mo1480b(Object obj) {
            this.f44786a.println(obj);
        }
    }

    /* renamed from: rx.exceptions.CompositeException$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15573d extends AbstractC15571b {

        /* renamed from: a */
        private final PrintWriter f44787a;

        C15573d(PrintWriter printWriter) {
            this.f44787a = printWriter;
        }

        @Override // p640rx.exceptions.CompositeException.AbstractC15571b
        /* renamed from: a */
        Object mo1481a() {
            return this.f44787a;
        }

        @Override // p640rx.exceptions.CompositeException.AbstractC15571b
        /* renamed from: b */
        void mo1480b(Object obj) {
            this.f44787a.println(obj);
        }
    }

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            appendStackTrace(sb, th.getCause(), "");
        }
    }

    private List<Throwable> getListOfCauses(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause.getCause();
            }
        }
        return arrayList;
    }

    private Throwable getRootCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause.getCause();
        }
        return cause;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.cause == null) {
            C15570a c15570a = new C15570a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            C15570a c15570a2 = c15570a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : getListOfCauses(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        c15570a2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    c15570a2 = getRootCause(c15570a2);
                }
            }
            this.cause = c15570a;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new C15572c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new C15573d(printWriter));
    }

    private void printStackTrace(AbstractC15571b abstractC15571b) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            appendStackTrace(sb, th, "\t");
            i++;
        }
        synchronized (abstractC15571b.mo1481a()) {
            abstractC15571b.mo1480b(sb.toString());
        }
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public CompositeException(Throwable... thArr) {
        List<Throwable> unmodifiableList;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th : thArr) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }
}
