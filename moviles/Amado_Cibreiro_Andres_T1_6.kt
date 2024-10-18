package com.example.basickotlin

import java.util.Scanner

fun main(){

    fun sumarNumeros(){
        var suma = 0
        for (i in 1..100){
            suma += i
        }
        println("La suma de los números del 1 al 100 es $suma")
    }
    //sumarNumeros()

    fun contarNumerosPares(){
        var contadorPares = 0
        var numero = 1
        while (numero<50){
            numero++
            if (numero%2 == 0){
                contadorPares++
            }
        }
        println("Hay $contadorPares números pares del 1 al 50")
    }
    //contarNumerosPares()


    fun isInteger(opcion : String) : Boolean{
        return try {
            opcion.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }


    fun mostrarMenu(){
        val sc = Scanner(System.`in`)
        var opcion : String

        do {
            println("\nElije una de estas opciones: ")
            println("1. Sumar dos números")
            println("2. Restar dos números")
            println("3. Salir")
            opcion = sc.nextLine()
            if (isInteger(opcion)){
                when(opcion.toInt()){
                    1 -> {
                        println("Introduce el primer número:")
                        val num1 : Int = sc.nextInt()
                        println("Introduce el segundo número:")
                        val num2 : Int = sc.nextInt()
                        println("La suma es: ${num1 + num2}")
                        sc.nextLine()
                    }
                    2 -> {
                        println("Introduce el primer número:")
                        val num1 : Int = sc.nextInt()
                        println("Introduce el segundo número:")
                        val num2 : Int = sc.nextInt()
                        println("La resta es: ${num1 - num2}")
                        sc.nextLine()
                    }
                    3 -> {}
                    else -> println("La opción seleccionada no se reconoce, vuelve a intentarlo")
                }
            }else{
                println("La opción seleccionada no se reconoce, vuelve a intentarlo")
            }

        }while (opcion.toInt()!=3)

        println("Adiós!")

    }
    mostrarMenu()


    fun imprimirTablaMultiplicar(){

        println("Tablas de multiplicar:")
        for (i in 1 .. 10){
            println("\n____________\nTABLA DEL $i\n-----------")
            for (j in 1..10){
                println("$i*$j = ${i*j}")
            }
        }
    }
    imprimirTablaMultiplicar()


    fun invertirCadena(){
        val sc = Scanner(System.`in`)
        var cadena : String
        var cadenaInvertida = ""

        println("Dame una cadena para invertirla: ")
        cadena = sc.nextLine()

        //EJEMPLO: Dabale arroz a la zorra el abad
        for (i in cadena.length - 1 downTo 0){
            cadenaInvertida += cadena[i]
        }
        println(cadenaInvertida)
    }
    invertirCadena()



    fun primerMultiploDeSiete(){
        var numero : Int = 101

        while (numero%7 != 0){
            numero++
        }
        println("El primer múliplo de 7 mayor que 100 es $numero")

    }
    primerMultiploDeSiete()



    fun bucleConControl(){
        var numero : Int = 1
        for (i in 1..10){
            if(numero>8){
                println("$numero -Bucle roto al ser mayor que 8")
                numero++
                break
            }else if (numero%3 == 0){
                println("$numero -Numero multiplo de 3")
                numero++
                continue
            }else{
                println("$numero -Numero normal")
                numero++
            }

        }
    }
    bucleConControl()


}