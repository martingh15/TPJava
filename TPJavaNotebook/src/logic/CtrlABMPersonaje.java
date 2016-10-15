package logic;
import java.util.ArrayList;

import utils.ApplicationException;

import data.DataPersonaje;
import entidades.Personaje;

public class CtrlABMPersonaje {
	
	ArrayList<Personaje> personajes;
	private data.DataPersonaje dataPer;
	
	
	public CtrlABMPersonaje ()
	{
		personajes = new ArrayList<Personaje>();
		dataPer = new DataPersonaje();
	}
	
	public void agregarPersonaje(Personaje p) throws ApplicationException
	{
		//En vez de agredarlo directamente hago un metodo para tirar la exception
		if(!dataPer.coincideNombre(p)) {
			dataPer.add(p);
		} else
		{
			throw new ApplicationException("Ya existe un personaje con ese nombre");
		}
	}
	
	public int recuperarID()
	{
		return dataPer.consultarMax();
	}
	
	public Personaje busca(Personaje p) throws ApplicationException
	{
		Personaje per = dataPer.getById(p);
		return per;
	}
	public void borrarPersonaje(Personaje p)
	{
		dataPer.delete(p);
	}

	public void modificar(Personaje p) {
		try {
			dataPer.update(p);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
