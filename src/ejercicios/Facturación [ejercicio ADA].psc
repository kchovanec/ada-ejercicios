Funcion variable_de_retorno <- Nombre ( Argumentos )
	
Fin Funcion
//	Desarrollar un sistema que permita el ingreso de totales recaudados de lunes a viernes, 
//	donde ademas se pueda modificar uno de los valores ingresados seleccionando el numero de dia.
//	Tambien se deberan poder listar los valores ingresados.(opcional ordenado de mayor a menor)
//	Todas las funciones se codificaran en un menu con valores enteros hasta que el usuario ingrese 
// cero para salir. (1. agregar  2. listar 3. modificar 4. salir)


Algoritmo facturacion
	
	Definir opciones Como Entero
	Definir salir Como Logico
	Definir modificar Como Caracter
	Definir ordenar Como Caracter
	Dimension dias[5] 
	salir = Falso
	
	
	Repetir
		Escribir ""
		Escribir "***** ¡BIENVENIDA AL SISTEMA! *****"
		Escribir ""
		Escribir "       OPCIONES       "
		Escribir "----------------------"
		Escribir "(1) Agregar"
		Escribir "(2) Listar"
		Escribir "(3) Modificar"
		Escribir "(0) Salir"
		Escribir "Elija una opción del 1 al 3 (0 para salir)...." Sin Saltar
		Leer opciones
		Borrar Pantalla
		
		Segun opciones Hacer
			 1:
				Escribir "Ingrese el día: Lun: 1; Mar: 2, Miér: 3; Jues: 4, Vier: 5 (0 terminar)" Sin Saltar
				Leer dia
				Mientras dia <> 0 y dia < 6 Hacer
					Escribir "Ingrese el monto del día ", dia 
					Leer monto
					dias[dia-1]=monto
					Mostrar "Ingrese día: " Sin Saltar
					Leer dia 
					
				Fin Mientras
				
				Volver
			 2:
				Para i = 0 hasta 4 Con paso 1 Hacer
					Escribir "El día " (i+1) " tuvo una ganancia de $", dias[i] 					
					
				FinPara
				
				Mostrar "¿Desea ver la recaudación ordenda de mayor a menor? (S/N) " Sin Saltar
				Leer ordenar
				Si ordenar == 's' o ordenar == 'S' Entonces
					
					// ordenar
					cant=5
					Para i=0 Hasta cant-2 Con Paso 1 Hacer
						// busca el menor entre i y cant
						pos_menor=i
						Para j=i+1 Hasta cant-1 Con Paso 1 Hacer
							Si dias[j]<dias[pos_menor] Entonces
								pos_menor=j
							FinSi
						FinPara
						// intercambia el que estaba en i con el menor que encontro
						aux=dias[i]
						dias[i]=dias[pos_menor]
						dias[pos_menor]=aux
					FinPara
					
					// mostrar como queda la lista
					Escribir "La lista ordenada es:"
					Para i=cant-1 Hasta 0 Con paso -1 Hacer
						Escribir "   ",dias[i]
					FinPara
				SiNo
					Mostrar "      " "Ok, volverá al Menú principal"
				Fin Si
				
				
				Volver
			 3:	
				Escribir "Ingrese el día a modificar: Lun: 1; Mar: 2, Miér: 3; Jues: 4, Vier: 5"
				Leer dia
				Mostrar "El día ", dia, " tuvo una recaudación de $", dias[dia-1]
				Escribir "¿Está seguro que quiere modificar ese monto? (S/N) " Sin Saltar
				Leer modificar
				Si modificar == 'S' o modificar == 's' Entonces
					Escribir "Ingrese el nuevo monto: "
					Leer monto
					dias[dia-1]=monto
					Mostrar "Ahora el día " dia " tiene cargada la recaudación de $ " monto
				SiNo
					Mostrar "Ok, de acuerdo!"
				Fin Si
				
				Volver
			 0:
				salir = Verdadero
			De Otro Modo:
				Escribir "Opción incorrecta"
				Volver
		FinSegun
	Hasta Que salir
	
	
FinAlgoritmo

Funcion Volver
	Escribir "Pulse una tecla para continuar..."
	Esperar Tecla
	Borrar Pantalla
	FinFuncion
	
	


