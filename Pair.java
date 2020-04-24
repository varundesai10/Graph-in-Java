public class Pair<A,B>{
	A a;
	B b;
	public Pair(A a, B b) {
		this.a = a; this.b = b;
	}
	public Pair() {
		a = null;
		b = null;
	}
	public A a() {
		return a;
	}
	public B b() {
		return b;
	}
}