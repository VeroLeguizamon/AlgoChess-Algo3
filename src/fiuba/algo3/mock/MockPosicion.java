package fiuba.algo3.mock;

import fiuba.algo3.mock.interfaces.IPosicion;

public class MockPosicion implements IPosicion{

	private int x = 0;
	private int y = 0;
	
	public MockPosicion(int xNueva, int yNueva) {
		this.x=xNueva;
		this.y=yNueva;
	}
	@Override
	public boolean equals (Object other) {
	    if (other == null) { return false; }
	    if (!(other instanceof IPosicion)) { return false; }
	    IPosicion m = (IPosicion)other;
	    return ((this.x == m.getX()) && (this.y == m.getY()) );
	}
	@Override
	public int getX() {
		return this.x;
	}
	@Override
	public int getY() {
		return this.y;
	}
}
