package Proyecto;
import java.io.*;
import java.util.Scanner;

public class Dibujar {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void printearpers (int[][] x, int f, int c,File pro) {
		int i,j;
		int opcion = leerposicion(777,pro);
		for(i=0;i<=f-1;i++) {
			System.out.println(" ");
			for(j=0;j<=c-1;j++) {
				if(opcion==1) {
					if(x[i][j] ==1){
						System.out.print("\033[38;5;196;48;5;196m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==2){
						System.out.print("\033[38;5;34;48;5;34m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==3){
						System.out.print("\033[38;5;21;48;5;21m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==4){
						System.out.print("\033[38;5;226;48;5;226m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==5){
						System.out.print("\033[38;5;165;48;5;165m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==6){
						System.out.print("\033[38;5;45;48;5;45m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==7){
						System.out.print("\033[38;5;94;48;5;94m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==8){
						System.out.print("\033[37;47m"+x[i][j]+"\033[0m");
					}
				}
				if(opcion==2) {
					if(x[i][j] ==1){
						System.out.print("\033[38;5;196m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==2){
						System.out.print("\033[38;5;34m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==3){
						System.out.print("\033[38;5;21m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==4){
						System.out.print("\033[38;5;226m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==5){
						System.out.print("\033[38;5;165m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==6){
						System.out.print("\033[38;5;45m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==7){
						System.out.print("\033[38;5;94m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==8){
						System.out.print("\033[37m"+x[i][j]+"\033[0m");
					}
				}
				if(opcion==3) {
						System.out.print(""+x[i][j]);
				}
					System.out.print(" ");
					}
			System.out.println(" ");
		}
				System.out.print("  ");
			
			System.out.println(" ");
		

	}
	
	public static void editor (File pro) {
		Scanner in = new Scanner(System.in);
		System.out.println("Escribe el nombre del nivel");
        File Nivel = new File(in.nextLine());
        try {
            FileOutputStream escribir = new FileOutputStream(Nivel);
            if (Nivel.isFile()) {
            } else {
                Nivel.createNewFile();
            }
            System.out.println("Escribe el numero de filas");

            int f = sc.nextInt();
            escribir.write(f);
            System.out.println("Escribe el numero de columnas");

            int c = sc.nextInt();
            escribir.write(c);
            System.out.println("Escribe el numero de colores");

            int a = sc.nextInt();
            escribir.write(a);
            int [][] x = new int[f][c];
            while (leerposicion((f*c)+3,Nivel) == -1 ) {
            	for(int i=0;i<=f-1;i++) {
        			for(int j=0;j<=c-1;j++) {
        					System.out.println("Escribe un numero para la posicion ["+i+"]["+j+"]");
        					int y = sc.nextInt();
        					x[i][j] = y;
        					printearpers(x,f,c,pro);
        					escribir.write(y);
        			}
            	}
            }
            escribir.close();
            menus(6,pro);
            selE(pro);
            
        }catch (IOException e) {
        }

    }
	
	public static void jugarP (String s,File pro) {
		File save = new File(s);
		int cont = 1;
		int f = leerposicion(cont,save);
		cont++;
		int c = leerposicion(cont,save);
		cont++;
		int a = leerposicion(cont,save);
		cont++;
		juego(f,c,a,3,-1,pro,save);
	}
	
	public static int[][] crearnivel (File save) {
		System.out.println("Escribe el numero de columnas");
		
		int cont = 1;
		int f = leerposicion(cont,save);
		cont++;
		int c = leerposicion(cont,save);
		cont++;
		cont++;
		int [][] x= new int [f][c];
		for(int i=0;i<=f-1;i++) {
			for(int j=0;j<=c-1;j++) {
				
				int y = leerposicion(cont,save);
				x[i][j]=y;
				cont++;
			}
		}
		return x;
	}
	
	
	public static void iniciarstats(File estadisticas){
        try{
	        FileOutputStream escribir= new FileOutputStream(estadisticas);
	        int contador=0;
	        while(contador<1000){
	            
	            escribir.write(0);
	            contador++;
	        }
	        escribir.close();
        
        }catch(IOException e){}
        
    }
	
	public static void reiniciarstats(File estadisticas,String nombre){
        
        try{
	        estadisticas.delete();
	        estadisticas = new File(nombre);
	        if	(estadisticas.isFile()){
	        }else{
	            estadisticas.createNewFile();
	        }
	        iniciarstats(estadisticas);
        }catch(IOException e){}
    }
	
	public static int size(File archivo) {

		try {

			FileInputStream leer = new FileInputStream(archivo);

			int cont = 0;

			while(leer.read() != -1){
				
				cont++;
			}
			
			
			leer.close();
			return cont;

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

		return 0;
	}

	public static int leerposicion(int posicion, File archivo) {

		int a = 0;
		try {
			FileInputStream leer = new FileInputStream(archivo);
			
			int cont=0;
			while(posicion>cont){
			
				a = leer.read();
				cont++;
			}
			leer.close();
			return a;
		} catch (IOException e) {
		}
		return 0;
	}

	public static File duplicar(File primera, String nombre){
		try{
			
			File nuevo= new File(nombre);
			FileInputStream leer= new FileInputStream(primera);
			FileOutputStream escribir= new FileOutputStream(nuevo);			
			for(int cont=1;cont<=size(primera);cont++){

			escribir.write(leerposicion(cont,primera));
			
			
		}
			leer.close();
			escribir.close();
			return nuevo;
		}catch(IOException e){
			
			
		}
		return primera;
		
	} 
	
	public static File escribirposicion(int numero, int posicion, File archivo,String nombre) {
		 try {
            File auxiliar = new File("auxiliar.txt");
             
            if(archivo.isFile()){
            }else{
                archivo.createNewFile();
            }
             
            FileOutputStream escribir = new FileOutputStream(auxiliar);
            FileInputStream leer = new FileInputStream(archivo);
            int tama = 1;
            if (size(archivo) > posicion) {
 
                tama = size(archivo);
            } else {
                tama = posicion;
            }
 
            for (int cont = 1; cont <= tama; cont++) {
 
                if (cont != posicion) {
                        if(leerposicion(cont,archivo)!=-1)
                            escribir.write(leerposicion(cont,archivo));
                        else{
                            escribir.write(0);
                        }
                } else {
 
                    escribir.write(numero);
                }
 
            }
            leer.close();
            archivo.delete();
            escribir.close();
             
             
            archivo=duplicar(auxiliar,nombre);
            auxiliar.delete();
            return archivo;
             
        } catch (IOException e) {       
 
        }
        return archivo;
    }
	
	public static void menus (int smenu , File pro) {
		switch(smenu) {
		case 1:
		System.out.println("           MODO DE JUEGO");
		System.out.println("1. Modo Continuo ");
		System.out.println("2. Modo Progresivo ");
		System.out.println("3. Iniciar todas las estadisticas de juego ");
		System.out.println("4. Opciones");
		System.out.println("5. Editor de niveles");
		System.out.println("0. Salir ");
		break;
		case 2:System.out.println("¿NUEVO TABLERO?");
		System.out.println("1. Nuevo tablero con estas caracterÃ­sticas ");
		System.out.println("2. Cambiar tamaño ");
		System.out.println("3. Cambiar número de colores");
		System.out.println("0. Volver al menu de MODO DE JUEGO ");
		break;
		case 3:clear();
		System.out.println("TAMAÑO DEL TABLERO");
		System.out.println("1. PEQUEÑO(9x9) ");
		System.out.println("2. MEDIANO(11x11) ");
		System.out.println("3. GRANDE(15x15)");
		System.out.println("0. Volver al menu de MODO DE JUEGO ");
		break;
		case 4:System.out.println("MODO PROGRESIVO");
		System.out.println("0.Volver al menu de MODO DE JUEGO ");
		if(leerposicion(1,pro)==0){
			System.out.println("1.Nivel 1- Aún no hay estadisticas");
		}
		else {
			System.out.println("1.Nivel 1-Resuelto en "+leerposicion(1,pro)+" intentos");
		}
		if(leerposicion(2,pro)==0){
			System.out.println("2.Nivel 2- Aún no hay estadisticas");
		}
		else {
			System.out.println("2.Nivel 2-Resuelto en "+leerposicion(2,pro)+" intentos");
		}
		if(leerposicion(3,pro)==0){
			System.out.println("3.Nivel 3- Aún no hay estadisticas");
		}
		else {
			System.out.println("3.Nivel 3-Resuelto en "+leerposicion(3,pro)+" intentos");
		}
		if(leerposicion(4,pro)==0){
			System.out.println("4.Nivel 4- Aún no hay estadisticas");
		}
		else {
			System.out.println("4.Nivel 4-Resuelto en "+leerposicion(4,pro)+" intentos");
		}
		break;
		case 5:clear();
		System.out.println("1. Cuadrados de color");
		System.out.println("2. Números de color ");
		System.out.println("3. Números");
		System.out.println("0.Volver al menu de MODO DE JUEGO ");	
		break;	
		case 6:System.out.println("EDITOR DE NIVELES");
		System.out.println("1. Crear tablero ");
		System.out.println("2. Jugar tablero ");
		System.out.println("0. Volver al menu de MODO DE JUEGO ");
		default: break;
		}
	}
	
	public static void selE (File pro) {
		int caso = -1;
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
			caso = sc.nextInt();
			while(caso<0 || caso >3) {
				System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
				caso = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selE(pro);
		}
		switch(caso) {
			case 0: clear();menus(1,pro);selA(pro);break;
			case 1: clear();editor(pro);break;
			case 2:	clear();System.out.println("Escribe el nombre del nivel a jugar");jugarP(in.nextLine(),pro);break;
			default: break;
		}
		
	}
	
	
	public static void selO (File pro) {
		int caso = -1;
		try {
			System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
			caso = sc.nextInt();
			while(caso<0 || caso >3) {
				System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
				caso = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selO(pro);
		}
		switch(caso) {
			case 0: clear();menus(1,pro);selA(pro);break;
			case 1: clear();escribirposicion(1,777,pro,"progresivo.txt");menus(1,pro);selA(pro);break;
			case 2:	clear();escribirposicion(2,777,pro,"progresivo.txt");menus(1,pro);selA(pro);break;
			case 3:	clear();escribirposicion(3,777,pro,"progresivo.txt");menus(1,pro);selA(pro);break;
			default: break;
		}
		
	}
	
	public static void selP (File pro) {
		int caso = -1;
		try {
			System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
			caso = sc.nextInt();
			while(caso<0 || caso >4) {
				System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
				caso = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selP(pro);
		}
		switch(caso) {
			case 0: clear();menus(1,pro);selA(pro);break;
			case 1: clear();juego(9,9,2,2,1,pro,null);break;
			case 2:	clear();juego(9,9,3,2,2,pro,null);break;
			case 3:	clear();juego(9,9,3,2,3,pro,null);break;
			case 4: clear();juego(9,9,3,2,4,pro,null);break;
			default: break;
		}
	}
	
	public static int[][] nivelesP (int nivel) {
		int[][] x = null;
		if(nivel==1) {
			x = new int[9][9];
			int k,z;
			for(k=0;k<=8;k++) {
				for(z=0;z<=8;z++) {
					x[k][z] = 1;
				}
			}
			x[0][0] = 2;
		}
		if(nivel==2) {
			x = new int[9][9];
			int k,z;
			for(k=0;k<=8;k++) {
				for(z=0;z<=8;z++) {
					x[k][z] = 1;
				}
			}
			x[0][0] = 3;
			x[1][0] = 2;
			x[0][1] = 2;
		}
		if(nivel==3) {
			x = new int[9][9];
			int k,z;
			for(k=0;k<=8;k++) {
				for(z=0;z<=8;z++) {
					x[k][z] = 1;
					if(((k==4 || k==8) && z>3) || ((z==4 || z==8) && k>3)) {
						x[k][z] = 2;
					}
					if(((k==5 || k==7) && (z>4 && z<8) || ((z==5 || z==7) && (k>4 && k<8)))) {
						x[k][z] = 3;
					}
				}
			}
			k = 0;
			z = 5;
			while(z>=0) {
				x[k][z] = 2;
				k++;
				z--;
			}
			k = 0;
			z = 6;
			while(z>=0) {
				x[k][z] = 3;
				k++;
				z--;
			}
		}
		if(nivel==4) {
			x = new int[9][9];
			int k,z;
			for(k=0;k<=8;k++) {
				for(z=0;z<=8;z++) {
					x[k][z] = 1;
				}
			}
			k = 2;
			z = 0;
			while(k<=8) {
				x[k][z] = 3;
				k++;
			}
			k = 0;
			while(k<=7) {
				z = 1;
				if(k==0 || k%2==1) {
					while(z<=8) {
						x[k][z] = 2;
						z++;
					}
				}
				k++;	
			}
		}
		return x;
	}
	
	
	
	public static void selT (int a,File pro) {
		int caso = -1;
		int cont = 0;
		try {
			System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
			caso = sc.nextInt();
			while(caso<0 || caso >3) {
				System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
				caso = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selT(a,pro);
		}
		switch(caso) {
			case 0: clear();menus(1,pro);selA(pro);break;
			case 1: clear();info(1,9,9,a,cont,1,0,pro);menus(2,pro);selF1(9,9,a,pro);break;
			case 2: clear();info(1,11,11,a,cont,1,0,pro);menus(2,pro);selF1(11,11,a,pro);break;
			case 3: clear();info(1,15,15,a,cont,1,0,pro);menus(2,pro);selF1(15,15,a,pro);break;
			default: break;
		}
	}
	
	public static void selC (int f, int c,File pro) {
		int color = -1;
		try {
			System.out.println("Por favor, elija un nÃºmero de colores entre 2 y 6");
			color = sc.nextInt();
			while(color<2 || color >6) {
				System.out.println("Por favor, elija un nÃºmero de colores entre 2 y 6");
				color = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selC(f,c,pro);
		}
		int cont = 0;
		clear();
		info(1,f,c,color,cont,1,0,pro);
		menus(2,null);
		selF1(f,c,color,pro);
	}
	
	public static void selF1 (int f,int c, int a, File pro) {
		int caso = -1;
		try {
			System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
			caso = sc.nextInt();
			while(caso<0 || caso >3) {
				System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
				caso = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selF1(f,c,a,pro);
		}
		switch(caso) {
			case 0: clear();menus(1,pro);selA(pro);break;
			case 1: clear();juego(f,c,a,caso,0,pro,null);break;
			case 2: clear();menus(3,pro);selT(a,pro);break;
			case 3: clear();;selC(f,c,pro);break;
			default: break;
		}
		
	}
	
	public static void info (int caso,int f,int c,int a,int cont, int menu ,int nivel,File pro) {
		String size = null;
		if (f<=9)
			size = "PEQUEÑO";
		if (f>9 && f<=11)
			size = "MEDIANO";
		if (f>11)
			size = "GRANDE";
		
		switch(caso){
			case 1: if(menu==1) {
				System.out.println("MODO CONTINUO");
				info(2,f,c,a,cont,1,0,pro);
				break;
				}
				if(menu==2) {
				System.out.print("       MODO PROGRESIVO");
				break;
				}
				if(menu==3) {
					System.out.print("       MODO PERSONALIZADO");
					break;
					}
				System.out.print("       MODO CONTINUO");
				break;
			case 2: if(menu==1) {
				System.out.println("Tamaño de tablero: "+size+" ("+f+"x"+c+")");
				info(3,f,c,a,cont,1,0,pro);
				break;
				}
				if(menu==2) {
				System.out.print("       NIVEL "+nivel);
				break;
				}
				System.out.print("       Tamaño de tablero: "+size+" ("+f+"x"+c+")");
				break;
			case 3: if(menu==1) {
				System.out.println("Número de colores: "+a);
				info(4,f,c,a,cont,1,0,pro);
				break;
				}
				System.out.print("       Número de colores: "+a);
				break;
			case 4: if(menu==1) {
				System.out.println("Pasos empleados: "+cont);
				info(5,f,c,a,cont,1,0,pro);
				break;
				}
				System.out.print("       Pasos empleados: "+cont);
				break;
			case 5: 
				if(menu==1) {
					if(leerposicion(((((f+c)*4)+a)+20),pro)==0) {
						System.out.println("No hay estadisticas aún");
						System.out.println(" ");
					}
					else {
						System.out.println("Menor número de pasos empleados :"+leerposicion(((((f+c)*4)+a)+20),pro)); 
						System.out.println(" ");
					}
				break;
				}
				if(menu==2) {
					if(leerposicion((nivel),pro)==0) {
						System.out.print("No hay estadisticas aún");
						
					}
					else {
						System.out.print("Menor número de pasos empleados :"+leerposicion((nivel),pro)); 
						
					}
				break;
				}
				if(menu==3) {
					if(leerposicion((800+2*f+3*c+2*a+cont-7),pro)==0) {
						System.out.print("       No hay estadisticas aún");
						
					}
					else {
						System.out.print("       Menor número de pasos empleados :"+leerposicion((800+2*f+3*c+2*a+cont-7),pro)); 
						
					}
				break;
				}
				if(leerposicion(((((f+c)*4)+a)+20),pro)==0) {
					System.out.print("       No hay estadisticas aún");
					
				}
				else {
					System.out.print("       Menor número de pasos empleados :"+leerposicion(((((f+c)*4)+a)+20),pro)); 
					
				}
				break;
				
			default: break;
		}
		
	}
	
	public static int color (int a) {
		int color = -1;
		try {
			System.out.println("Por favor, elija un color entre 1 y "+a);
			color = sc.nextInt();
			while(color<1 || color>a) {
				System.out.println("Por favor, elija un color entre 1 y "+a);
				color = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			return color(a);
		}
		return color;
	}
	
	public static void juego (int f,int c, int a, int caso, int nivel,File pro,File level) {
		int cont = 0;
		if(caso==3) {
			int[][] x = crearnivel(level);
			printear(x,f,c,a,cont,nivel,pro);
			while(finalcheck(x,f,c)==false) {
				int z = x[0][0];
				int y = color(a);
				while(z==y) {
					System.out.println("Escoja un color distinto de "+z+" puesto que ya esta seleccionado");
					y = color(a);
				}
				x[0][0] = y;
				checkv3(x,0,0,z,f-1,c-1);
				cont++;
				clear();
				printear(x,f,c,a,cont,nivel,pro);
			}
			if(leerposicion((800+2*f+3*c+2*a+cont-7),pro)>cont || leerposicion((800+2*f+3*c+2*a+cont-7),pro)==0 ) {
				escribirposicion(cont,nivel,pro,"progresivo.txt");
			}
			clear();
			System.out.println(" ");
			menus(6,pro);
			selE(pro);
		}
		if(caso==2) {
			int[][] x = nivelesP(nivel);
			printear(x,f,c,a,cont,nivel,pro);
			while(finalcheck(x,f,c)==false) {
				int z = x[0][0];
				int y = color(a);
				while(z==y) {
					System.out.println("Escoja un color distinto de "+z+" puesto que ya esta seleccionado");
					y = color(a);
				}
				x[0][0] = y;
				checkv3(x,0,0,z,f-1,c-1);
				cont++;
				clear();
				printear(x,f,c,a,cont,nivel,pro);
			}
			if(leerposicion(nivel,pro)>cont || leerposicion(nivel,pro)==0 ) {
				escribirposicion(cont,nivel,pro,"progresivo.txt");
			}
			clear();
			System.out.println(" ");
			menus(4,pro);
			selP(pro);
		}
		if(caso==1) {
			int[][] x = crear(f,c,a);
			printear(x,f,c,a,cont,0,pro);
			while(finalcheck(x,f,c)==false) {
				int z = x[0][0];
				int y = color(a);
				while(z==y) {
					System.out.println("Escoja un color distinto de "+z+" puesto que ya esta seleccionado");
					y = color(a);
				}
				x[0][0] = y;
				checkv3(x,0,0,z,f-1,c-1);
				cont++;
				clear();
				printear(x,f,c,a,cont,0,pro);
			}
			if(leerposicion(((((f+c)*4)+a)+20),pro)>cont || leerposicion(((((f+c)*4)+a)+20),pro)==0) {
				escribirposicion(cont,((((f+c)*4)+a)+20),pro,"progresivo.txt");
			}
			clear();
			info(1,f,c,a,cont,1,0,pro);
			menus(2,null);
			selF1(f,c,a,pro);
		}
	}
	
	public static void clear () {
		for (int z=0;z<=50;z++) {
			System.out.println(" ");
		}
	}
	
	
	public static void selA (File progresivo) {
		int caso = -1;
		
		try {
			System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
			caso = sc.nextInt();
			while(caso<0 || caso >5) {
				System.out.println("Por favor, elija una de las opciones que se muestra en pantalla");
				caso = sc.nextInt();		
			}
		}
		catch(Exception e) {
			sc.next();
			selA(progresivo);
		}
		switch(caso) {
			case 0: clear();System.out.println("    FIN DEL JUEGO");break;
			case 1: clear();juego(9,9,2,caso,0,progresivo,null);break;
			case 2: clear();menus(4,progresivo);selP(progresivo);break;
			case 3: clear();reiniciarstats(progresivo,"progresivo.txt");
					System.out.println("ESTADISTICAS REINICIADAS");
					menus(1,progresivo);selA(progresivo);break;
			case 4: clear();menus(5,null);selO(progresivo);break;
			case 5: clear();menus(6,null);selE(progresivo);break;
			default: break;
		
		}
	}
	
	public static int[][] crear (int f, int c, int a) {
		int[][] x = new int[f][c];
		int k,z;
		for(k=0;k<=f-1;k++) {
			for(z=0;z<=c-1;z++) {
				x[k][z] = (int) Math.ceil((Math.random() * a));
			}
		}
		return x;
	}
	
	public static void chuleta (int caso) {
		
		int a=0;
		switch(caso){
			case 1: System.out.print("   Pulse 1 para escoger --> "+"\033[38;5;196;48;5;196m"+a+"\033[0m");
				break;
			case 2: System.out.print("   Pulse 2 para escoger --> "+"\033[38;5;34;48;5;34m"+a+"\033[0m");
				break;
			case 3: System.out.print("   Pulse 3 para escoger --> "+"\033[38;5;21;48;5;21m"+a+"\033[0m");
				break;
			case 4: System.out.print("   Pulse 4 para escoger --> "+"\033[38;5;226;48;5;226m"+a+"\033[0m");
				break;
			case 5: System.out.print("   Pulse 5 para escoger --> "+"\033[38;5;165;48;5;165m"+a+"\033[0m");
				break;
			case 6: System.out.print("   Pulse 6 para escoger --> "+"\033[38;5;45;48;5;45m"+a+"\033[0m");
				break;
			case 7: System.out.print("   Pulse 7 para escoger --> "+"\033[38;5;94;48;5;94m"+a+"\033[0m");
				break;
			case 8: System.out.print("   Pulse 8 para escoger --> "+"\033[37;47m"+a+"\033[0m");
				break;
			default: break;
		}
	}
	

	public static void printear (int[][] x, int f, int c,int a,int cont ,int nivel,File pro) {
		int i,j,caso=1,casoi=1;
		int opcion = leerposicion(777,pro);
		for(i=0;i<=f-1;i++) {
			System.out.println(" ");
			for(j=0;j<=c-1;j++) {
				if(opcion==1) {
					if(x[i][j] ==1){
						System.out.print("\033[38;5;196;48;5;196m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==2){
						System.out.print("\033[38;5;34;48;5;34m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==3){
						System.out.print("\033[38;5;21;48;5;21m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==4){
						System.out.print("\033[38;5;226;48;5;226m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==5){
						System.out.print("\033[38;5;165;48;5;165m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==6){
						System.out.print("\033[38;5;45;48;5;45m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==7){
						System.out.print("\033[38;5;94;48;5;94m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==8){
						System.out.print("\033[37;47m"+x[i][j]+"\033[0m");
					}
				}
				if(opcion==2) {
					if(x[i][j] ==1){
						System.out.print("\033[38;5;196m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==2){
						System.out.print("\033[38;5;34m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==3){
						System.out.print("\033[38;5;21m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==4){
						System.out.print("\033[38;5;226m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==5){
						System.out.print("\033[38;5;165m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==6){
						System.out.print("\033[38;5;45m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==7){
						System.out.print("\033[38;5;94m"+x[i][j]+"\033[0m");
					}
					if(x[i][j] ==8){
						System.out.print("\033[37m"+x[i][j]+"\033[0m");
					}
				}
				if(opcion==3) {
						System.out.print(""+x[i][j]);
				}
				if(j==c-1){
					if(caso<=a){
						chuleta(caso);
						caso++;
					}
				}
				if(j==c-1){
					if(casoi<=5 && casoi+1==caso){
						if(nivel<0) {
							info(casoi,f,c,a,cont,3,nivel,pro);
							casoi++;
						}
						else if(nivel>0) {
							info(casoi,f,c,a,cont,2,nivel,pro);
							casoi++;
						}
						else{
							info(casoi,f,c,a,cont,0,0,pro);
							casoi++;
						}
					}
					else if(caso>a && casoi <=5){
						for(int r=0;r<=28;r++){
							System.out.print(" ");
						}
						if(nivel<0) {
							info(casoi,f,c,a,cont,3,nivel,pro);
							casoi++;
						}
						else if(nivel>0) {
							info(casoi,f,c,a,cont,2,nivel,pro);
							casoi++;
						}
						else{
							info(casoi,f,c,a,cont,0,0,pro);
							casoi++;
						}
					}
				}
				System.out.print("  ");
			}
			System.out.println(" ");
		}
		while(caso<=a) {
			System.out.println(" ");
			for(int z=0;z<=(c*3)-3;z++) {
				System.out.print(" ");
			}
			chuleta(caso);
			System.out.println(" ");
			caso++;
		}
	}
	
	public static boolean finalcheck (int[][] x, int f, int c) {
		int i,j;
		boolean igual = true;
		int z = x[0][0];
		for(i=0;i<=f-1;i++) {
			if (igual==false) {
				break;				
			}
			for(j=0;j<=c-1;j++) {
				igual = z==x[i][j];
				if (igual==false) {
					break;
				}
				z = x[i][j];
			}	
		}
		return igual;		
	}
	public static void checkv3(int[][]x,int i,int j,int y,int f,int c) {
		if((i>=0 && i<=f)&&(j>=0 && j<=c)) {
			if(i!=0){
				if(x[i-1][j]==y) {
					x[i-1][j]=x[0][0];
					checkv3(x,i-1,j,y,f,c);
				}
			}
			if(i!=f){
				if(x[i+1][j]==y) {
					x[i+1][j]=x[0][0];
					checkv3(x,i+1,j,y,f,c);
				}
			}
			if(j!=0){
				if(x[i][j-1]==y) {
					x[i][j-1]=x[0][0];
					checkv3(x,i,j-1,y,f,c);
				}
			}
			if(j!=c){
				if(x[i][j+1]==y) {
					x[i][j+1]=x[0][0];
					checkv3(x,i,j+1,y,f,c);
				}
			}
		}	
	}

	public static void main (String[] args) {
		File progresivo = new File("progresivo.txt");
		if(leerposicion(1,progresivo)==-1) {
			reiniciarstats(progresivo,"progresivo.txt");
		}
		escribirposicion(1,777,progresivo,"progresivo.txt");
		menus(1,progresivo);
		selA(progresivo);
	}
}
