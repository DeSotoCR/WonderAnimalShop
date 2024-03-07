/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WonderAnimalShop;

/**
 *
 * @author NightFox
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class RegistroController {

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String nombreUsuario, @RequestParam String contraseña, @RequestParam String confirmarContraseña,@RequestParam String correo, Model model) {
        // Verificar que la contraseña y la confirmación de contraseña coincidan
        if (!contraseña.equals(confirmarContraseña)) {
            // Redirige a una página de error o muestra un mensaje de error
            return "redirect:/error-contrasena.html";
        }

        // Escribir los valores en un archivo de texto
        try (FileWriter fw = new FileWriter("usuarios.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("Nombre de usuario:" + nombreUsuario);
            out.println("Contraseña:" + contraseña);
            out.println("Correo: " + correo);
            out.println("----------------------------------------");
        } catch (IOException e) {
            // Manejo de errores, redirige a una página de error o muestra un mensaje de error
            return "redirect:/error-guardar.html";
        }

        // Agregar mensaje de éxito al modelo
        model.addAttribute("mensajeExito", "¡Registro exitoso!");

        // Devolver la vista de registro con el mensaje de éxito
        return "redirect:/registro-exitoso.html";
    }
}
