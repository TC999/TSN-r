package androidx.constraintlayout.solver.widgets;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f143x;

    /* renamed from: y  reason: collision with root package name */
    public int f144y;

    public boolean contains(int i4, int i5) {
        int i6;
        int i7 = this.f143x;
        return i4 >= i7 && i4 < i7 + this.width && i5 >= (i6 = this.f144y) && i5 < i6 + this.height;
    }

    public int getCenterX() {
        return (this.f143x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f144y + this.height) / 2;
    }

    void grow(int i4, int i5) {
        this.f143x -= i4;
        this.f144y -= i5;
        this.width += i4 * 2;
        this.height += i5 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i4;
        int i5;
        int i6 = this.f143x;
        int i7 = rectangle.f143x;
        return i6 >= i7 && i6 < i7 + rectangle.width && (i4 = this.f144y) >= (i5 = rectangle.f144y) && i4 < i5 + rectangle.height;
    }

    public void setBounds(int i4, int i5, int i6, int i7) {
        this.f143x = i4;
        this.f144y = i5;
        this.width = i6;
        this.height = i7;
    }
}
