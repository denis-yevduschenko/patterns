package patterns;

public class AdapterApp {
	public static void main(String[] args) {
		//1.With help inheritance
		VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
		g1.drowLine();
		g1.drowSquare();
		//2.With help composition
		VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
		g2.drowLine();
		g2.drowSquare();
	}
}

interface VectorGraphicsInterface{
	void drowLine();
	void drowSquare();
}

class RasterGraphics{
	public void drowRasterLine() {
		System.out.println("Рисуем линию");
	}
	public void drowRasterSquare() {
		System.out.println("Рисуем квадрат");
	}
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
	@Override
	public void drowLine() {
		drowRasterLine();
	}
	@Override
	public void drowSquare() {
		drowRasterSquare();
	}
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
	RasterGraphics raster = null;//new RasterGraphics();
	public VectorAdapterFromRaster2(RasterGraphics raster) {
		this.raster = raster;
	}
	@Override
	public void drowLine() {
			raster.drowRasterLine();
	}
	@Override
	public void drowSquare() {
		raster.drowRasterSquare();
	}
}