package sensores;

public enum Constantes {

	PH_MIN(5.50),
	PH_MAX(7.50),
	NITROGENIO_MIN(45.00),
	NITROGENIO_MAX(65.00),
	FOSFORO_MIN(2.80),
	FOSFORO_MAX(4.50),
	POTASSIO_MIN(18.00),
	POTASSIO_MAX(25.00),
	CALCIO_MIN(6.00),
	CALCIO_MAX(10.00),
	MAGNESIO_MIN(2.80),
	MAGNESIO_MAX(5.00),
	ENXOFRE_MIN(2.400),
	ENXOFRE_MAX(4.00);
	
	private double valor;
	Constantes(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
}
