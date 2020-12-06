
class MetodosOrdenamiento{
	
	static class Intercalacion{
		
		
		public static int []ordenar(int primero[], int segundo[]){
			
			int arrayOrdenado[] = new int[primero.length+segundo.length];
			
			int i=0, j=0, k=0;
			
			while(i<primero.length && j<segundo.length) {
				if(primero[i]<segundo[j]) {
					arrayOrdenado[k] = primero[i];
					k++;
					i++;
				}else {
					arrayOrdenado[k] = segundo[j];
					j++;
					k++;
					
				}
			}
			while(j<segundo.length) {
				arrayOrdenado[k] = segundo[j];
				j++;
				k++;
			}
			while(i<primero.length) {
				arrayOrdenado[k] = segundo[i];
				i++;
				k++;
			}
			
			return arrayOrdenado;
			
		}
	}
	
	
	
	static class MezclaDirecta{
		
		public static int[] ordenar(int numeros[]) {
			int i,j,k;
			if(numeros.length>1) {
				int numElementosIzq = numeros.length/2;
				int numElementosDer = numeros.length-numElementosIzq;
				
				int arregloIzquierdo[] = new int[numElementosIzq];
				int arregloDerecho[] = new int[numElementosDer];
				
				for (i=0; i<numElementosIzq; i++) {
					arregloIzquierdo[i] = numeros[i];
				}
				
				for (i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
					arregloDerecho[i-numElementosIzq]=numeros[i];
				}
				
				arregloIzquierdo = ordenar(arregloIzquierdo);
				arregloDerecho = ordenar(arregloDerecho);
				i=j=k=0;
				
				while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
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
				
				while(arregloIzquierdo.length!=j) {
					numeros[i]=arregloIzquierdo[j];
					i++;
					j++;
				}
				while(arregloDerecho.length!=k) {
					numeros[i]=arregloDerecho[k];
					i++;
					k++;
				}
			}
			return numeros;
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
