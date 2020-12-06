
class NumerosAleatorios{
	
	public static int[] generarNumeros(int cantidad){
		int[] nums = new int[cantidad];
		for (int i = 0; i < nums.length; i++) {
			nums[i]=(int)(Math.random()*cantidad);
		}
	    return nums;
	}
}

class MetodosOrdenamiento{
	
	static class Intercalacion{
		
		static long tInicio, tFin;
		static long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
		public static void complementoIntercalacion(int numeros[]){
			int aux;
			for (int i = 1; i < numeros.length; i++) {
				aux=numeros[i];
				for (int j=i-1; j>=0 && numeros[j]>aux ; j--) {
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
				}
			}
		}
		
		public static void ordenar(int nums[]) {
			tInicio=System.nanoTime();
			int numeros[]=nums.clone();
			long comparaciones=0,intercambios=0,recorridos=0;
			
			int[] arregloA,arregloB;
			
			if (numeros.length%2==0) {
				arregloA=new int[numeros.length/2];
				arregloB=new int[numeros.length/2];
			}else {
				arregloA=new int[numeros.length/2];
				arregloB=new int[(numeros.length/2)+1];
			}
			for (int i = 0; i < numeros.length; i++) {
				if (i<numeros.length/2) {
					arregloA[i]=numeros[i];
				}else {
					arregloB[i-arregloA.length]=numeros[i];
				}
			}
			complementoIntercalacion(arregloA);
			complementoIntercalacion(arregloB);
			
			long ini = System.nanoTime();
			
			int arregloC[] = new int[arregloA.length+arregloB.length];
			
			int i,k,j;
			recorridos+=1;
			for(i=j=k=0; i<arregloA.length && j<arregloB.length; k++){
				comparaciones+=1;
				intercambios+=1;
				if(arregloA[i]<arregloB[j]) {
					arregloC[k] = arregloA[i];
					i++;
				}else {
					arregloC[k] = arregloB[j];
					j++;
				}
			}
			recorridos+=1;
			for(;i<arregloA.length; i++,k++) {
				arregloC[k] = arregloA[i];
				intercambios+=1;
			}
			recorridos+=1;
			for(;j<arregloB.length; j++,k++) {
				arregloC[k] = arregloB[j];
				intercambios+=1;
			}
			tFin = System.nanoTime();
			
			
			tiempo = tFin-tInicio;
			System.out.print("Intercalación:	");
			System.out.print(tiempo + "       ");
			System.out.print(recorridos + "      ");
			System.out.print(comparaciones + "     ");
			System.out.println(intercambios);
		}
		

		
	}
	
	
	
	static class MezclaDirecta{
		
		static long tInicio, tFin;
		static long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
		
		public static int[] ordenar(int numeros[]) {
			int i,j,k;
			if(numeros.length>1) {
				int numElementosIzq = numeros.length/2;
				int numElementosDer = numeros.length-numElementosIzq;
				
				int arregloIzquierdo[] = new int[numElementosIzq];
				int arregloDerecho[] = new int[numElementosDer];
				recorridos+=1;
				for (i=0; i<numElementosIzq; i++) {
					arregloIzquierdo[i] = numeros[i];
					intercambios+=1;
				}
				recorridos+=1;
				for (i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
					arregloDerecho[i-numElementosIzq]=numeros[i];
					intercambios+=1;
				}
				
				arregloIzquierdo = ordenar(arregloIzquierdo);
				arregloDerecho = ordenar(arregloDerecho);
				i=j=k=0;
				recorridos+=1;
				while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
					comparaciones+=1;
					intercambios+=1;
					if(arregloIzquierdo[j]<arregloDerecho[k]) {
						numeros[i] = arregloIzquierdo[j];
						i++;
						j++;
					}else {
						numeros[i] = arregloDerecho[k];
						i++;
						k++;
						
					}

				}
				recorridos+=1;
				while(arregloIzquierdo.length!=j) {
					numeros[i]=arregloIzquierdo[j];
					intercambios+=1;
					i++;
					j++;
				}
				recorridos+=1;
				while(arregloDerecho.length!=k) {
					numeros[i]=arregloDerecho[k];
					intercambios+=1;
					i++;
					k++;
				}
			}
			return numeros;
		}
		
		
		public static void llamadaOrdenamientoMezclaDirecto(int nums[]) {
			int numeros[]=nums.clone();
			
			tInicio = System.nanoTime();
			ordenar(numeros);
			tFin = System.nanoTime();
			
			tiempo = tFin-tInicio;
			System.out.print("Mezcla directa:	");
			System.out.print(tiempo + "     ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "     ");
			System.out.println(intercambios);
		}
		
	}
	
	
	
	static class MezclaNatural{
		
		static long tInicio, tFin;
		static long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
		
		public static int[] mezclaDirecta (int[] vector) {
			int i,j,k;
			if(vector.length>1) {
				int nElementosIzquierda = vector.length/2;
				int nElementosDerecha = vector.length - nElementosIzquierda;
				int vectorI[] = new int [nElementosIzquierda];
				int vectorD[] = new int [nElementosDerecha];
				recorridos+=1;
				for (i = 0; i < nElementosIzquierda; i++) {
					intercambios+=1;
					vectorI[i]=vector[i];
				}
				recorridos+=1;
				for (i = nElementosIzquierda; i < nElementosIzquierda+nElementosDerecha; i++){
					intercambios+=1;
					vectorD[i-nElementosIzquierda] = vector[i];
				}
				vectorI = mezclaDirecta(vectorI);
				vectorD = mezclaDirecta(vectorD);
				i=0;
				j=0;
				k=0;
				recorridos+=1;
				while(vectorI.length!=j && vectorD.length!=k) {
					comparaciones+=1;
					intercambios+=1;
					if(vectorI[j]<vectorD[k]) {
						vector[i]=vectorI[j];
						i++;
						j++;
					}else {
						vector[i]=vectorD[k];
						i++;
						k++;
					}//Else
				}//While	
				recorridos+=1;
				while(vectorI.length!=j) {
					intercambios+=1;
					vector[i] = vectorI[j];
					i++;
					j++;
				}
				recorridos+=1;
				while(vectorD.length!=k) {
					intercambios+=1;
					vector[i] = vectorD[k];
					i++;
					k++;
				}	
			}
			return vector;
		}
		//MezclaDirecta2
		public static void mezclaDirecta2 (int[] vector) {
			int i,j,k;
			if(vector.length>1) {
				int nElementosIzquierda = vector.length/2;
				int nElementosDerecha = vector.length - nElementosIzquierda;
				int vectorI[] = new int [nElementosIzquierda];
				int vectorD[] = new int [nElementosDerecha];
				recorridos+=1;
				for (i = 0; i < nElementosIzquierda; i++) {
					vectorI[i]=vector[i];
				}
				recorridos+=1;
				for (i = nElementosIzquierda; i < nElementosIzquierda+nElementosDerecha; i++){
					intercambios+=1;
					vectorD[i-nElementosIzquierda] = vector[i];
				}
				vectorI = mezclaDirecta(vectorI);
				vectorD = mezclaDirecta(vectorD);
				i=0;
				j=0;
				k=0;
				recorridos+=1;
				while(vectorI.length!=j && vectorD.length!=k) {
					comparaciones+=1;
					if(vectorI[j]<vectorD[k]) {
						vector[i]=vectorI[j];
						i++;
						j++;
					}else {
						vector[i]=vectorD[k];
						i++;
						k++;
					}//Else
				}//While
				recorridos+=1;	
				while(vectorI.length!=j) {
					vector[i] = vectorI[j];
					i++;
					j++;
				}
				recorridos+=1;
				while(vectorD.length!=k) {
					vector[i] = vectorD[k];
					i++;
					k++;
				}	
			}
		}
		
		public static void mezclaNatural(int[] numeros) {
			int izquierda =0;
			int izq =0;
			int derecha = numeros.length-1;
			int der = derecha;
			boolean ordenado = false;
			tInicio = System.nanoTime();
			do {
				ordenado = true;
				izquierda = 0;
				while(izquierda<derecha) {
					izq =izquierda;
					recorridos+=1;
					while(izq < derecha && numeros[izq]<=numeros[izq+1]) {
						izq++;
					}
					der = izq +1;
					recorridos+=1;
					while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {
						der++;
					}
					comparaciones+=1;
					if(der<=derecha) {
						mezclaDirecta2(numeros);
						
						ordenado = false;
					}
					izquierda=izq;
					
				}
			}while(!ordenado);	
			tFin = System.nanoTime();
			
			tiempo = tFin-tInicio;
			System.out.print("Mezcla natural:	");
			System.out.print(tiempo + "     ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "     ");
			System.out.println(intercambios);
			
		}	
	}
	
	
}//metodos ordenamiento

class LlamadaMetodos{
	public static void llamar(int []n) {
		
		MetodosOrdenamiento.Intercalacion.ordenar(n);
		MetodosOrdenamiento.MezclaDirecta.llamadaOrdenamientoMezclaDirecto(n);
		MetodosOrdenamiento.MezclaNatural.mezclaNatural(n);
		
	}
}



public class PruebasEstres {

	public static void main(String[] args) {
		
		System.out.println("----------------------1000 números----------------------");
		System.out.println("Método          Tiempo     Rec     Comp      Int");
		LlamadaMetodos.llamar(NumerosAleatorios.generarNumeros(1000));
		System.out.println();
		System.out.println("----------------------10000 números---------------------");
		System.out.println("Método          Tiempo       Rec      Comp      Int");
		LlamadaMetodos.llamar(NumerosAleatorios.generarNumeros(10000));
		System.out.println();
		System.out.println("----------------------100000 números--------------------");
		System.out.println("Método          Tiempo         Rec      Comp        Int");
		LlamadaMetodos.llamar(NumerosAleatorios.generarNumeros(100000));
	

	}

}
