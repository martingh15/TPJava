package logic;
import entidades.Personaje;
import utils.ApplicationException;
import data.*;
import java.util.Random;

public class CtrlCombate {
	private Personaje pers1, pers2;
	private DataPersonaje dataPer = new DataPersonaje();
	private int vidaP1, vidaP2, energiaP1, energiaP2;
	
	
	public Personaje getPers1() {
		return pers1;
	}

	public void setPers1(Personaje pers1) {
		this.pers1 = pers1;
	}

	public Personaje getPers2() {
		return pers2;
	}

	public void setPers2(Personaje pers2) {
		this.pers2 = pers2;
	}

	public int getVidaP1() {
		return vidaP1;
	}

	public void setVidaP1(int vidaP1) {
		this.vidaP1 = vidaP1;
	}

	public int getVidaP2() {
		return vidaP2;
	}

	public void setVidaP2(int vidaP2) {
		this.vidaP2 = vidaP2;
	}

	public int getEnergiaP1() {
		return energiaP1;
	}

	public void setEnergiaP1(int energiaP1) {
		this.energiaP1 = energiaP1;
	}

	public int getEnergiaP2() {
		return energiaP2;
	}

	public void setEnergiaP2(int energiaP2) {
		this.energiaP2 = energiaP2;
	}

	public void seteaPer(Personaje p1, Personaje p2) {
		pers1 = p1;
		pers2 = p2;
		vidaP1 = pers1.getVida();
		vidaP2 = pers2.getVida();
		energiaP1 = pers1.getEnergia();
		energiaP2 = pers2.getEnergia();
		
	}

	public int quitaVida( String energia, int turno) {
		int vida;
		if (turno == 1)
		{
			vidaP2 = vidaP2 -  Integer.parseInt(energia) ;
			vida = vidaP2;
		
		}
		else 
		{
			vidaP1 = vidaP1 -  Integer.parseInt(energia) ;
			vida = vidaP1;
		}
		if(vida <= 0) { vida = 0;}
		return vida;
	}
	
	
	public int quitaEnergia( String energia,int turno) {
		int energiaRest;
		if (turno == 1)
		{
			energiaP1 = energiaP1 -  Integer.parseInt(energia) ;
			energiaRest = energiaP1;
		
		}
		else 
		{
			energiaP2 = energiaP2 -  Integer.parseInt(energia) ;
			energiaRest = energiaP2;
		}
		return energiaRest;
	}

	public boolean validaEnergia(int energia, int turno) {
		boolean valido=false;
		if (turno == 1)
		{
			if(energia <= energiaP1){ valido = true;}		
		}
		else 
		{
			if(energia <= energiaP2){ valido = true;}
		}
		
		if(energia<0) 
		{
			valido=false;
		}
		
		return valido;
	}

	public boolean validarPartida(int turno) {
		boolean valido = false;
		try {
			valido = false;
			if(turno==1) 
			{
				if(vidaP2 <= 0) 
				{
					valido = true;
					dataPer.updatePuntos(pers1);
				}
//				else {
//					throw new ApplicationException("Error en la Base de Datos");
//				}
			}
			else {
				if(vidaP1 <= 0) 
				{
					valido = true;
					dataPer.updatePuntos(pers2);
				}
//				else {
//					throw new ApplicationException("Error en la Base de Datos");
//				}
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valido;
	}

	public int recuperaEnergia(int turno) {
		int energ;
		if (turno ==1)
		{

			energiaP1 = energiaP1 + (pers1.getEnergia() * pers1.getDefensa())/100;
			energ = energiaP1;
			if (energ > pers1.getEnergia())
			{
				energiaP1 = pers1.getEnergia();
				energ = pers1.getEnergia();
			}
		}
		else
		{
	
			energiaP2 = energiaP2 + (pers2.getEnergia() * pers2.getDefensa())/100;
			energ = energiaP2;
			if (energ > pers2.getEnergia())
			{
				energiaP2 = pers2.getEnergia();
				energ = pers2.getEnergia();
			}
		}
		return energ;
	}

	public int recuperaVida(int turno) {
		int vida;
		if (turno ==1)
		{
			//vidaARecuperar = vidaOriginal * defensa / 250
			vidaP1 = vidaP1 + (pers1.getVida() * pers1.getDefensa())/250;
			vida = vidaP1;
			if (vida > pers1.getVida())
			{
				vidaP1 = pers1.getVida();
				vida = pers1.getVida();
			}
		}
		else
		{
		
			vidaP2 = vidaP2 + (pers2.getVida() * pers2.getDefensa())/250;
			vida = vidaP2;
			if (vida > pers2.getVida())
			{
				vidaP2 = pers2.getVida();
				vida = pers2.getVida();
			}
		}
		return vida;
	}

	public boolean evadir(int turno) {
		Random rnd = new Random();
		float numAle = rnd.nextFloat();

		boolean evade = false;
		if (turno == 1)
		{
			//(numAleatorio*100)>puntosDeEvasion
			if ((numAle*100)<pers2.getEvasion())
			{
				evade = true;
			}
		}
		
		else
		{
			//(numAleatorio*100)>puntosDeEvasion
			if ((numAle*100)<pers1.getEvasion())
			{
				evade = true;
			}
		}
		
		return evade;
	}
	
}
