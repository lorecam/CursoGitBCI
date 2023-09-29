package clases;

public class ExportCobre {
	private int nroExportacion; //123
	private String paisDestino; //Chile
	private String nombreCliente; //Domingo Saavedra Saavedra
	private int[] toneladasExportadas; //Array 
	
	//Constructor Vacio
	public ExportCobre(){
		
	}
	
	//Constructor con parametros
	public ExportCobre(int nroExportacion, String paisDestino, String nombreCliente){
		this.nroExportacion = nroExportacion;
		this.paisDestino = paisDestino;
		this.nombreCliente = nombreCliente;
		this.toneladasExportadas = new int[12];
		
		for(int i=0;i<toneladasExportadas.length;i++){
			
			toneladasExportadas[i] = (int) (Math.random()*(1500-0)+1);
		}
	}
	
	 /*a.	correo: Devolverá el correo del cliente. 
	 * El correo estará compuesto por las 5 primeras letras del nombre, 
	 * un guion bajo, las cuatro últimas letras del apellido paterno, 
	 * la segunda letra del país destino, más @exportcobre.cl (todo en minúscula).
	 *  Si el nombre o el apellido tiene menos letras de las que se necesitan, 
	 *  se les asignará a las letras faltantes el carácter x.	
		Ejemplo: Si el cliente es Luis Saa Cancino y país destino Grecia
		devolverá: luisx_saaxr@exportcobre.cl 
	 */public String correo(){
		 //Nombre = "Luis Saa Cancino"
		 String mail="";
		 
		 String[] w = this.nombreCliente.split(" ");
		 
		 if(w[0].length()>=5){ //tiene mas de 5 caracteres (domingo)
			 mail = w[0].substring(0,5); //domin
		 }else{ 
			 mail = w[0]; //joy
			 int dif = 5 -w[0].length(); 
			 for(int i=1; i<=dif;i++){
				 mail = mail.concat("x"); 
			 }
		 }
		 
		 mail = mail.concat("_");
		 
		 if(w[1].length()>=4){ //sanchez = 7
			 mail = mail + w[1].substring(w[1].length()-4);
		 }else{ //Lee
			 mail = mail + w[1];
			 int diff = 4 - w[1].length(); //1
			 for(int i=1; i<=diff;i++){
				 mail = mail.concat("x"); 
			 }
		 }
		 
		 //luisx_saax
		 mail = mail + this.paisDestino.substring(1,2)+"@exporcobre.cl";
		 
		 return mail.toLowerCase();
	 }
	
	//Accesadores y mutadores
	public int getNroExportacion() {
		return nroExportacion;
	}
	public void setNroExportacion(int nroExportacion) {
		this.nroExportacion = nroExportacion;
	}
	public String getPaisDestino() {
		return paisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public int[] getToneladasExportadas() {
		return toneladasExportadas;
	}
	public void setToneladasExportadas(int[] toneladasExportadas) {
		this.toneladasExportadas = toneladasExportadas;
	}
	

	public int mesMayorExportacion(){
		int max=-1;
		int mes=0;
		
		for(int i=0; i<this.toneladasExportadas.length;i++){
			if(this.toneladasExportadas[i]>max){
				max = toneladasExportadas[i];
				mes = (i+1);
			}
		}
		return mes;
	}
	
	/*c.totalOtoñoInvierno: devolverá el total de exportaciones realizada
	 * 	 en el periodo Otoño-Invierno (considerar los meses de abril a septiembre).*/
	
	public int totalOtonnoInvierno(){
		int suma=0;
		
		for(int i=3;i<9;i++){
			suma = suma + toneladasExportadas[i];
		}
		return suma;
	}
	
	/*d.	cantidadExportada: devolverá la cantidad que se exportó en un mes X. */
	public int cantidadExportada(int mes){ //12
		return this.toneladasExportadas[(mes-1)]; 
	}

}
