package app.traductor.traductor.modelo;

import app.traductor.traductor.R;

public class Conjugaciones {
    /**
     *
     * Esta clase contiene un método el cuál sirve para buscar el recurso asociado a todas y cada
     * una de las palabras registradas en este Software. No es la mejor manera, claro está. Lo ideal
     * sería una base de datos. Ahora, por efectos de practicidad y de tiempo se implementó este
     * sistema de búsqueda mediante un gigantesco Switch, lo sé, no es fácil depurar pero para las pocas
     * palabras que maneja este prototipo está más que tolerable.
     *
     * La forma de diferenciar las palabras es mediante los primeros 3 caracteres, puesto que, después
     * de una investigación se llegó a la conclusión que, las palabras pueden cambiar entre pasado, presente
     * tercera persona, etc. Pero los primeros 4 caracteres nunca cambian. Partiendo de ese punto
     * es como elegí diferenciar las palabras, en cada case se retorna la imágen asociada a esa palabra.
     *
     * El caso de los verbos es el más exitoso, puesto que con las primeras 3 letras podemos incluso
     * sacar los verbos conjugados. Ejemplo:
     *
     * COMEr, COMía, COMieron
     * OLVidó, OLVidaron, OLVidaban
     *
     * Si no se encontró ningún dato a traducir, el método simplemente retornará 0, hay que validar
     * eso cuando se mane a llamar este método.
     */

    public static int obtenerRecurso(String verbo) {

        final char espacio = 32;

        switch (verbo.toLowerCase()) {

            /**------------------------ VERBOS ----------------------------------- */

            case "come":
            case "comi":
                return R.drawable.comer;
            case "dorm":
                return R.drawable.dormir;
            case "llor":
                return R.drawable.llorar;
            case "mira":
                return R.drawable.mirar;
            case "olvi":
                return R.drawable.olvidar;
            case "quer":
            case "quie":
                return R.drawable.querera;
            case "reir":
            case "rien":
            case "rier":
            case "rio_":
            case "rei_":
            case "rie_":
                return R.drawable.reir;
            case "sabe":
                return R.drawable.saber;
            /**------------------------ FIN VERBOS ----------------------------------- */

            /**------------------------ COLORES ----------------------------------- */
            case "amar":
                return R.drawable.amarillo;
            case "anar":
                return R.drawable.anaranjado;
            case "azul":
                return R.drawable.azul;
            case "blan":
                return R.drawable.blanco;
            case "bril":
                return R.drawable.brillante;
            case "cafe":
                return R.drawable.cafe;
            case "clar":
                return R.drawable.claro;
            case "gris":
                return R.drawable.gris;
            case "mora":
                return R.drawable.morado;
            case "negr":
                return R.drawable.negro;
            case "oro_":
                return R.drawable.oro;
            case "oscu":
                return R.drawable.oscuro;
            case "plat":
                return R.drawable.plata;
            case "rojo":
                return R.drawable.rojo;
            case "rosa":
                return R.drawable.rosa;
            case "verd":
                return R.drawable.verde;
            /**------------------------ FIN COLORES ----------------------------------- */

            /**------------------------ DIAS ----------------------------------- */
            case "domi":
                return R.drawable.domingo;
            case "juev":
                return R.drawable.jueves;
            case "lune":
                return R.drawable.lunes;
            case "mart":
                return R.drawable.martes;
            case "mier":
                return R.drawable.miercoles;
            case "saba":
                return R.drawable.sabado;
            case "vier":
                return R.drawable.viernes;

            /**------------------------ EXPRESIONES ----------------------------------- */
            case "vece":
                return R.drawable.aveces;
            case "dife":
                return R.drawable.diferente;
            case "perm":
                return R.drawable.permiso;
            case "favo":
                return R.drawable.porfavor;
            case "siem":
                return R.drawable.siempre;
            /**------------------------ FIN EXPRESIONES ----------------------------------- */

            /**------------------------ MESES ----------------------------------- */
            case "ener":
                return R.drawable.enero;
            case "febr":
                return R.drawable.febrero;
            case "marz":
                return R.drawable.marzo;
            case "abri":
                return R.drawable.abril;
            case "mayo":
                return R.drawable.mayo;
            case "juni":
                return R.drawable.junio;
            case "juli":
                return R.drawable.julio;
            case "agos":
                return R.drawable.agosto;
            case "sept":
                return R.drawable.septiembre;
            case "octu":
                return R.drawable.octubre;
            case "novi":
                return R.drawable.noviembre;
            case "dici":
                return R.drawable.diciembre;
            /**------------------------ FIN MESES ----------------------------------- */

            /**------------------------ PRONOMBRES ----------------------------------- */

            case "él__":
                return R.drawable.el;
            case "ello":
                return R.drawable.ellos;
            case "noso":
                return R.drawable.nosotros;
            case "tu__":
            case "te__":
                return R.drawable.tu;
            case "uste":
                return R.drawable.usted;
            case "yo__":
                return R.drawable.yo;
            default:
                return 0;
            /**------------------------ FIN PRONOMBRES ----------------------------------- */
        }
    }

    /**
     *  Excepciones:
     *
     *  Excepciones a tratar: Usted - Ustedes (Por ahora están usando el mismo recurso).
     *
     * */
}
