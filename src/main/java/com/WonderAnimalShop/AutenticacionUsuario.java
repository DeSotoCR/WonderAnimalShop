/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WonderAnimalShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutenticacionUsuario {
    public static boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        // Obtener la ruta del directorio de trabajo actual del proyecto
        String rutaProyecto = System.getProperty("user.dir");

        // Combinar la ruta del proyecto con el nombre del archivo
        String rutaArchivo = rutaProyecto + "/usuarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Separar el nombre de usuario y la contraseña de la línea actual
                String[] datosUsuario = linea.split(":");
                // Verificar si el nombre de usuario y la contraseña coinciden
                if (datosUsuario.length == 2 && datosUsuario[0].trim().equals(nombreUsuario) && datosUsuario[1].trim().equals(contraseña)) {
                    return true; // Las credenciales son correctas
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false; // Las credenciales son incorrectas o el archivo no se pudo leer
    }

    public static void main(String[] args) {
        String nombreUsuario = "usuario";
        String contraseña = "contraseña";
        if (autenticarUsuario(nombreUsuario, contraseña)) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Credenciales incorrectas. Por favor, intenta de nuevo.");
        }
    }
}
