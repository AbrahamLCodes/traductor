package app.traductor.traductor.modelo;

import app.traductor.traductor.R;

public class Conjugaciones {

    /**
     * Cada método de esta clase sirve para retornar valores. Los primeros 3 caracteres
     * de todas las palabras a traducir tienen combinaciones diferentes, por lo que, podemos
     * usar esta ventaja de diferenciador de combinación para diferenciar las palabras.
     *
     * El caso de los verbos es el más exitoso, puesto que con las primeras 3 letras podemos incluso
     * sacar los verbos conjugados. Ejemplo:
     *
     * COMer, COMía, COMieron
     * OLVidó, OLVidaron, OLVidaban
     *
     * Si no se encontró ningún dato a traducir, el método simplemente retornará 0, hay que validar
     * eso cuando se mane a llamar este método.
     * */

    public static int convertirVerbo(String verbo) {

        switch (verbo.toLowerCase()) {
            case "com":
                return R.drawable.comer;
            case "dor":
                return R.drawable.dormir;
            case "llo":
                return R.drawable.llorar;
            case "mir":
                return R.drawable.mirar;
            case "olv":
                return R.drawable.olvidar;
            case "que":
                return R.drawable.querera;
            case "rei":
                return R.drawable.reir;
            case "sab":
                return R.drawable.saber;
            default:
                return 0;
        }
    }
}
