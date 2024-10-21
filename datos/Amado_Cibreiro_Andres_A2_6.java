public class Main {

    // 3. y 7. Utilizando throws
    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("La edad debe ser mayor o igual a 18.");
        } else {
            System.out.println("Acceso permitido: eres mayor de edad.");
        }
    }

    public static void main(String[] args) {
        // 3. Utilizando try-catch
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println("Excepción capturada: " + e.getMessage());

        } finally {   // 3. y 8. Utilizar finally
            System.out.println("Bloque finally: finalizando el proceso de verificación.");
        }

        // 3. Otro ejemplo para demostrar múltiples excepciones (ArrayIndexOutOfBoundsException)
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } finally {
            System.out.println("Bloque finally: liberando recursos.");
        }

        // 6. y 8. Ejemplo adicional con throw para excepciones personalizadas
        try {
            validarNumero(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } finally {
            System.out.println("Bloque finally: limpieza final.");
        }
    }

    // 6. y .8 Excepción personalizada
    public static void validarNumero(int numero) {
        if (numero < 0) {
            // Lanza una excepción personalizada
            throw new IllegalArgumentException("El número no puede ser negativo.");// 3. Utilizando throw
        } else {
            System.out.println("El número es válido.");
        }
    }
}