/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WonderAnimalShop;

/**
 *
 * @author NightFox
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistroUsuario {
    public static void main(String[] args) {
        // Obtener la ruta del directorio de trabajo actual del proyecto
        String rutaProyecto = System.getProperty("user.dir");

        // Combinar la ruta del proyecto con el nombre del archivo
        String rutaArchivo = rutaProyecto + "/usuarios.txt";

        // Obtener los valores del formulario HTML
        String nombreUsuario = "Nombre de usuario obtenido del formulario";
        String correo = "Correo Obtenido del formulario";
        String contraseña = "Contraseña obtenida del formulario";
        String confirmarContraseña = "Confirmar Contraseña obtenida del formulario";

        // Verificar que la contraseña y la confirmación de contraseña coincidan
        if (!contraseña.equals(confirmarContraseña)) {
            System.out.println("Las contraseñas no coinciden. Por favor, inténtelo de nuevo.");
            return; // Sale del programa si las contraseñas no coinciden
        }

        // Escribir los valores en el archivo de texto
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("Nombre de usuario: " + nombreUsuario);
            out.println("Contraseña: " + contraseña);
            out.println("Correo: " + correo);
            out.println("----------------------------------------");
            System.out.println("Usuario registrado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
