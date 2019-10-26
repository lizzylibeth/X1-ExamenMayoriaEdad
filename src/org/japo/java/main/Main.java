/* 
 * Copyright 2019 Elísabet Palomino .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Elísabet Palomino
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        //FECHA ACTUAL        
        int dActual = cal.get(Calendar.DAY_OF_MONTH);
        int mActual = cal.get(Calendar.MONTH) + 1; //Los meses empiezan por 0, asique hay que sumarle 1
        int aActual = cal.get(Calendar.YEAR);

        //Mensaje
        System.out.println("Análisis Edad");
        System.out.println("=============");

        try {

            //Pedir al usuario su fecha de nacimiento
            System.out.print("Día nacimiento ....: ");
            int dNacim = SCN.nextInt();
            System.out.print("Mes nacimiento ....: ");
            int mNacim = SCN.nextInt();
            System.out.print("Año nacimiento ....: ");
            int aNacim = SCN.nextInt();

            //separador
            System.out.println("---");

            //Mostrar por pantalla Fecha Actual y Fecha introducida por el usuario
            System.out.printf("Fecha nacimiento ..: %02d/%02d/%d - Manual%n", dNacim, mNacim, aNacim);
            System.out.printf("Fecha actual ......: %02d/%02d/%d - Sistema%n", dActual, mActual, aActual);

            //separador
            System.out.println("---");

            //Comprobar si es mayor de edad.
            boolean mayorEdad = aActual - aNacim > 18 || aActual - aNacim == 18 && mActual > mNacim
                    || aActual - aNacim == 18 && mActual == mNacim && dActual >= dNacim;

            //Mostrar por pantalla si es mayor de edad
            System.out.printf("Mayoría de edad ...: %S%n", mayorEdad == true ? "SI" : "NO");

        } catch (Exception e) {

            System.out.println("Error, Valor Incorrecto");

        } finally {

            SCN.nextLine(); //Borrar buffer     
        }

    }//main

}//class
