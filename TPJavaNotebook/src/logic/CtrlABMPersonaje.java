package logic;
import java.util.ArrayList;
import java.util.*;
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
	
	public void agregarPersonaje(Personaje p)
	{
		dataPer.add(p);
	}
	
	public int recuperarID()
	{
		return personajes.size();
	}
	
	public Personaje busca(int id)
	{
		Personaje p = new Personaje();
		p = personajes.get(id);
		return p;
	}
	public void borrarPersonaje(int id)
	{
		Personaje p = this.busca(id);
		personajes.remove(id);
	}

	public void modificar(Personaje p) {
		
		
	}
}
