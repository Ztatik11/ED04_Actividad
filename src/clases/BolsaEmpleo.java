package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BolsaEmpleo {
	private BolsaEmpleoData data = new BolsaEmpleoData();

	public BolsaEmpleo(List<Persona> listaVacantes, String nombreBolsa) {
		this.data.listaVacantes = new ArrayList<Persona>();
		this.data.nombreBolsa = nombreBolsa;
	}

	public List<Persona> getListaVacantes() {
		return data.listaVacantes;
	}

	public void setListaVacantes(List<Persona> listaVacantes) {
		this.data.listaVacantes = listaVacantes;
	}

	public String getNombreBolsa() {
		return data.nombreBolsa;
	}

	public void setNombreBolsa(String nombreBolsa) {
		this.data.nombreBolsa = nombreBolsa;
	}

// Método que añade una persona a la bolsa de trabajo si es mayor de edad y no se encuentra en ninguna otra bolsa de trabajo
	public void anyadirPersona(Persona persona, List<BolsaEmpleo> listaDeBolsas) {

		boolean estaEnBolsa = false;
		if (persona.obtenerEdad() >= 18) {
			for (BolsaEmpleo bolsa : listaDeBolsas) {
				if (bolsa.data.listaVacantes.contains(persona)) {
					estaEnBolsa = true;
				}
			}
			if (!estaEnBolsa) {
				this.data.listaVacantes.add(persona);
			}
		}
	}

	@Override
	public String toString() {
		return "Bolsa de empleo: " + data.nombreBolsa + "\n" + Arrays.toString(this.data.listaVacantes.toArray());
	}

}
