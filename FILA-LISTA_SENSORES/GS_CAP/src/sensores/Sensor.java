package sensores;

import java.util.Random;

public class Sensor {

	private String coordenadas;
	private double ph;
	private double nitrogenio;
	private double fosforo;
	private double potassio;
	private double calcio;
	private double magnesio;
	private double enxofre;
	private int qtd;
	private int numeSensor;

	public Sensor() {

	}

	public Sensor(String coordenada, int indice) {
		Random r = new Random();
		this.coordenadas = coordenada;
		this.ph = formatarDecimal(r.nextDouble(4.0, 9.0));
		this.nitrogenio = formatarDecimal(r.nextDouble(40.0, 70.0));
		this.fosforo = formatarDecimal(r.nextDouble(1.3, 6.0));
		this.potassio = formatarDecimal(r.nextDouble(13.0, 30.0));
		this.calcio = formatarDecimal(r.nextDouble(4.0, 12.0));
		this.magnesio = formatarDecimal(r.nextDouble(1.3, 6.5));
		this.enxofre = formatarDecimal(r.nextDouble(0.9, 5.5));
		this.numeSensor = indice;

	}

	private Double formatarDecimal(Double valor) {
		double valorFormatado = Math.floor(valor * 100) / 100;
		return valorFormatado;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public double getPh() {
		return ph;
	}

	public double getNitrogenio() {
		return nitrogenio;
	}

	public double getFosforo() {
		return fosforo;
	}

	public double getPotassio() {
		return potassio;
	}

	public double getCalcio() {
		return calcio;
	}

	public double getMagnesio() {
		return magnesio;
	}

	public double getEnxofre() {
		return enxofre;
	}

	protected int getQtd() {
		return qtd;
	}

	protected void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	protected int getNumeroSensor() {
		return this.numeSensor;
	}

	public String mostrarValidosInvalidos(Double txt, boolean b, String nome) {
		StringBuffer sbf = new StringBuffer();
		if (b) {
			sbf.append(nome);
			sbf.append(txt);
			sbf.append("......: FORA DO NORMAL!");
		} else {
			sbf.append(nome);
			sbf.append(txt);
			sbf.append("......: DENTRO DO NORMAL!");
		}

		return sbf.toString();
	}

	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("\n============================================================================================");
		sbf.append("\n\n\t>> SENSOR ");
		sbf.append(getNumeroSensor());
		sbf.append(" <<");
		sbf.append("\n\tCOORDENADAS......: ");
		sbf.append(getCoordenadas());
		sbf.append("\n\tPH......: ");
		sbf.append(getPh());
		sbf.append("\n\tNITROGÊNIO......: ");
		sbf.append(getNitrogenio());
		sbf.append(" g/kg");
		sbf.append("\n\tFÓSFORO........: ");
		sbf.append(getFosforo());
		sbf.append(" g/kg");
		sbf.append("\n\tPOTÁSSIO........: ");
		sbf.append(getPotassio());
		sbf.append(" g/kg");
		sbf.append("\n\tCÁLCIO........: ");
		sbf.append(getCalcio());
		sbf.append(" g/kg");
		sbf.append("\n\tMAGNÉSIO........: ");
		sbf.append(getMagnesio());
		sbf.append(" g/kg");
		sbf.append("\n\tENXOFRE........: ");
		sbf.append(getEnxofre());
		sbf.append(" g/kg");
	
		return sbf.toString();
	}

}
