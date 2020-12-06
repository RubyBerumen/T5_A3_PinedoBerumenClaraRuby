
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
		public static void ordenar(int[]nums, int primero[], int segundo[]){
			int numeros [] = nums.clone();
			
			int arrayOrdenado[] = new int[primero.length+segundo.length];
			tInicio = System.nanoTime();
			int i=0, j=0, k=0;
			recorridos+=1;
			while(i<primero.length && j<segundo.length) {
				comparaciones+=1;
				if(primero[i]<segundo[j]) {
					comparaciones+=1;
					arrayOrdenado[k] = primero[i];
					k++;
					i++;
				}else {
					arrayOrdenado[k] = segundo[j];
					j++;
					k++;
					
				}
			}
			recorridos+=1;
			while(j<segundo.length) {
				comparaciones+=1;
				arrayOrdenado[k] = segundo[j];
				intercambios+=1;
				j++;
				k++;
			}
			recorridos+=1;
			while(i<primero.length) {
				comparaciones+=1;
				arrayOrdenado[k] = segundo[i];
				intercambios+=1;
				i++;
				k++;
			}
			tFin = System.nanoTime();
			
			
			tiempo = tFin-tInicio;
			System.out.print("Intercalación:	");
			System.out.print(tiempo + "        ");
			System.out.print(recorridos + "    ");
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
			System.out.print("Intercalación:	");
			System.out.print(tiempo + "        ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "     ");
			System.out.println(intercambios);
		}
		
	}
	
	
	
	static class MezclaNatural{
		public static int[] mezclaDirecta (int[] vector) {
			int i,j,k;
			if(vector.length>1) {
				int nElementosIzquierda = vector.length/2;
				int nElementosDerecha = vector.length - nElementosIzquierda;
				int vectorI[] = new int [nElementosIzquierda];
				int vectorD[] = new int [nElementosDerecha];
				
				for (i = 0; i < nElementosIzquierda; i++) {
					vectorI[i]=vector[i];
				}
				
				for (i = nElementosIzquierda; i < nElementosIzquierda+nElementosDerecha; i++){
					vectorD[i-nElementosIzquierda] = vector[i];
				}
				vectorI = mezclaDirecta(vectorI);
				vectorD = mezclaDirecta(vectorD);
				i=0;
				j=0;
				k=0;
				while(vectorI.length!=j && vectorD.length!=k) {
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
				while(vectorI.length!=j) {
					vector[i] = vectorI[j];
					i++;
					j++;
				}
				while(vectorD.length!=k) {
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
				
				for (i = 0; i < nElementosIzquierda; i++) {
					vectorI[i]=vector[i];
				}
				
				for (i = nElementosIzquierda; i < nElementosIzquierda+nElementosDerecha; i++){
					vectorD[i-nElementosIzquierda] = vector[i];
				}
				vectorI = mezclaDirecta(vectorI);
				vectorD = mezclaDirecta(vectorD);
				i=0;
				j=0;
				k=0;
				while(vectorI.length!=j && vectorD.length!=k) {
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
					
				while(vectorI.length!=j) {
					vector[i] = vectorI[j];
					i++;
					j++;
				}
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
			int derecha = numeros.length-1;//Sin el error de nullPointerExepcion
			int der = derecha;
			boolean ordenado = false;
			do {
				ordenado = true;
				izquierda = 0;
				while(izquierda<derecha) {
					izq =izquierda;
					while(izq < derecha && numeros[izq]<=numeros[izq+1]) {
						izq++;
					}
					der = izq +1;
					while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {
						der++;
					}
					if(der<=derecha) {
						mezclaDirecta2(numeros);
						
						ordenado = false;
					}
					izquierda=izq;
					
				}
			}while(!ordenado);	
		}	
	}

	
	
	
}//metodos ordenamiento

public class PruebasEstres {

	public static void main(String[] args) {
	

	}

}
