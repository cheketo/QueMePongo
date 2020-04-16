enum Categoria {
	ACCESORIO,
	SUPERIOR,
	INFERIOR,
	CALZADO
}

enum Color {
	AMARILLO,
	AZUL,
	BLANCO,
	GRIS,
	NEGRO,
	ROJO,
	VERDE
}
class PrendaInvalida extends Exception {
	new( String msg ) {
		super( msg );
	}
}

class Atuendo {
	ArrayList<Prenda> prendas;
	public void agregarPrenda( Prenda prenda, Categoria categoria ) {
		try{
			prenda.validarCategoria( categoria );
			prenda.validarDatos();
			this.prendas.add( prenda );
		}catch( PrendaInvalida e ){
			System.out.println( e.getMessage() );
		}
	}
	public void agregarPrendaSuperior( Prenda prenda )
	{
		this.agregarPrenda( prenda, Categoria.SUPERIOR );
	}
	public void agregarPrendaInferior( Prenda prenda )
	{
		this.agregarPrenda( prenda, Categoria.INFERIOR );
	}
	public void agregarPrendaCalzado( Prenda prenda )
	{
		this.agregarPrenda( prenda, Categoria.CALZADO );
	}
	public void agregarPrendaAccesorio( Prenda prenda )
	{
		this.agregarPrenda( prenda, Categoria.ACCESORIO );
	}
}

public abstract class Prenda {
	Color colorPrincipal;
	Color colorSecundario;
	String material;
	String tipo;
	Categoria categoria;
	public abstract Categoria getCategoria();
	public void setColorSecundario( Color color ) {
		this.colorSecundario = color;
	}
	public void validarCategoria( Categoria categoria )
	{
		if( this.getCategoria() != categoria )
		{
			throw new PrendaInvalida( "No fue posible agregar la prenda. La categoría de la prenda " + this.getTipo() + " debe ser " + categoria.name() );
		}
	}
	public void validarDatos() {
		if( this.getTipo() == null || this.getColorPrincipal() == null || this.getMaterial() == null )
		{
			throw new PrendaInvalida( "No fue posible agregar la prenda. Verifique que el tipo, el materia y el color principal de la prenda estén completos " );
		}
	}
}

class PrendaSuperior extends Prenda {
	PrendaSuperior( String tipo, String material, Color color )
	{
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = color;
		this.categoria = Categoria.SUPERIOR;
	}
	public Categoria getCategoria() {
		return Categoria.SUPERIOR;
	}
}

class PrendaInferior extends Prenda {
	PrendaInferior( String tipo, String material, Color color )
	{
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = color;
		this.categoria = Categoria.INFERIOR;
	}
	public Categoria getCategoria() {
		return Categoria.INFERIOR;
	}
}

class PrendaCalzado extends Prenda {
	PrendaCalzado( String tipo, String material, Color color )
	{
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = color;
		this.categoria = Categoria.CALZADO;
	}
	public Categoria getCategoria() {
		return Categoria.CALZADO;
	}
}

class PrendaAccesorio extends Prenda {
	PrendaAccesorio( String tipo, String material, Color color )
	{
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = color;
		this.categoria = Categoria.ACCESORIO;
	}
	public Categoria getCategoria() {
		return Categoria.ACCESORIO;
	}
}

// Ejecución
PrendaInferior pantalonRojo = new PrendaInferior( "Pantalon", "Materiales.GABARDINA", Color.ROJO );
pantalonRojo.setColorSecundario( Color.NEGRO );
Atuendo atuendo = new Atuendo();
atuendo.agregarParteSuperior( pantalonRojo );
atuendo.agregarParteInferior( pantalonRojo );
atuendo.agregarCalzado( pantalonRojo );
atuendo.agregarAccesorio( pantalonRojo );
