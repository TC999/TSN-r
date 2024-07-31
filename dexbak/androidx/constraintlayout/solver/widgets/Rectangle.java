package androidx.constraintlayout.solver.widgets;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f120x;

    /* renamed from: y */
    public int f121y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f120x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f121y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.f120x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f121y + this.height) / 2;
    }

    void grow(int i, int i2) {
        this.f120x -= i;
        this.f121y -= i2;
        this.width += i * 2;
        this.height += i2 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.f120x;
        int i4 = rectangle.f120x;
        return i3 >= i4 && i3 < i4 + rectangle.width && (i = this.f121y) >= (i2 = rectangle.f121y) && i < i2 + rectangle.height;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f120x = i;
        this.f121y = i2;
        this.width = i3;
        this.height = i4;
    }
}
