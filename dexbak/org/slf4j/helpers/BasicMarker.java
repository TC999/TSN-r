package org.slf4j.helpers;

import io.netty.handler.codec.http.HttpConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.slf4j.Marker;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class BasicMarker implements Marker {
    private static String CLOSE = " ]";
    private static String OPEN = "[ ";
    private static String SEP = ", ";
    private static final long serialVersionUID = 1803952589649545191L;
    private final String name;
    private List<Marker> referenceList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicMarker(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("A marker name cannot be null");
    }

    @Override // org.slf4j.Marker
    public synchronized void add(Marker marker) {
        if (marker != null) {
            if (contains(marker)) {
                return;
            }
            if (marker.contains(this)) {
                return;
            }
            if (this.referenceList == null) {
                this.referenceList = new Vector();
            }
            this.referenceList.add(marker);
            return;
        }
        throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
    }

    @Override // org.slf4j.Marker
    public boolean contains(Marker marker) {
        if (marker != null) {
            if (equals(marker)) {
                return true;
            }
            if (hasReferences()) {
                for (Marker marker2 : this.referenceList) {
                    if (marker2.contains(marker)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        throw new IllegalArgumentException("Other cannot be null");
    }

    @Override // org.slf4j.Marker
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Marker)) {
            return this.name.equals(((Marker) obj).getName());
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.Marker
    public boolean hasChildren() {
        return hasReferences();
    }

    @Override // org.slf4j.Marker
    public synchronized boolean hasReferences() {
        boolean z;
        List<Marker> list = this.referenceList;
        if (list != null) {
            z = list.size() > 0;
        }
        return z;
    }

    @Override // org.slf4j.Marker
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // org.slf4j.Marker
    public synchronized Iterator<Marker> iterator() {
        List<Marker> list = this.referenceList;
        if (list != null) {
            return list.iterator();
        }
        return Collections.emptyList().iterator();
    }

    @Override // org.slf4j.Marker
    public synchronized boolean remove(Marker marker) {
        List<Marker> list = this.referenceList;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (marker.equals(this.referenceList.get(i))) {
                this.referenceList.remove(i);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (!hasReferences()) {
            return getName();
        }
        Iterator<Marker> it = iterator();
        StringBuilder sb = new StringBuilder(getName());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(OPEN);
        while (it.hasNext()) {
            sb.append(it.next().getName());
            if (it.hasNext()) {
                sb.append(SEP);
            }
        }
        sb.append(CLOSE);
        return sb.toString();
    }

    @Override // org.slf4j.Marker
    public boolean contains(String str) {
        if (str != null) {
            if (this.name.equals(str)) {
                return true;
            }
            if (hasReferences()) {
                for (Marker marker : this.referenceList) {
                    if (marker.contains(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        throw new IllegalArgumentException("Other cannot be null");
    }
}
