/*
Ejercicio 4.4
Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. Crear el constructor del coche, así como el método toString().

Marca y modelo no podrán ser blancos ni nulos y no podrán modificarse.
Número de caballos, número de puertas y matrícula no podrán modificarse, ni podrán ser nulos.
Color podrá modificarse, pero no podrá ser nulo.
Recuerda que Kotlin añade los getters y setters con el comportamiento por defecto, por lo que no es necesario que los implementes, a no ser que tengas que añadir alguna funcionalidad extra.

Modifica el atributo matricula para que no permita actualizar la matrícula con un valor que no tenga 7 caracteres.
Los atributos de modelo la marca siempre se devolverán con la primera letra en mayúscula.
Realiza también una modificación del atributo número de caballos, para que no permita actualizar el atributo numCaballos con un valor interior a 70, ni superior a 700.
Realiza una modificación del atributo número de puertas, para que no permita actualizar el atributo numPuertas con un valor inferior a 3, ni superior a 5.
Ten en cuenta todas estas condiciones a la hora de crear el constructor de la clase.
En el programa principal, instancia varios coches y muéstralos por pantalla. Probar las modificaciones anteriores, modifica el número de caballos para un coche y haz lo mismo para el número de puertas, el color, la marca y modelo. Vuelve a mostrarlos por pantalla.

Intenta instanciar y modificar con la marca y modelo con valores nulos o blancos y comprueba que no es posible.
Intenta instanciar y modificar con el número de caballos con un valor inferior a 70 o superior a 700 y comprueba que no es posible.
Intenta instanciar y modificar con el número de puertas con un valor inferior a 3 o superior a 5 y comprueba que no es posible.
Intenta instanciar y modificar con la matrícula con un valor que no tenga 7 caracteres y comprueba que no es posible.
Intenta instanciar y modificar con el color, el número de caballos, el número de puertas y la matrícula con valores nulos/blancos y comprueba que no es posible.
 */


/**
 * Clase que representa un objeto Coche con atributos como marca, modelo, número de caballos,
 * número de puertas, matrícula y color.
 *
 * @property marca Marca del coche.
 * @property modelo Modelo del coche.
 * @property numCaballos Número de caballos del coche (rango permitido: 70 a 700).
 * @property numPuertas Número de puertas del coche (rango permitido: 3 a 5).
 * @property matricula Matrícula del coche (debe tener exactamente 7 caracteres).
 * @property color Color del coche.
 */
class Coche(marca: String,
            modelo: String,
            private val numCaballos: Int,
            private val numPuertas: Int,
            private val matricula: String,
            color: String)
{


    /**
     * Propiedad que representa la marca del coche, con formato de capitalización.
     */
    private var marca: String = marca
        get() = field.lowercase().replaceFirstChar { it.uppercase() }

    private var modelo: String = modelo
        get() = field.lowercase().replaceFirstChar { it.uppercase() }


    /**
     * Propiedad que representa el color del coche, con validación.
     */
    var color: String = color
        set(value) {
            requireColor()
            field = value
        }


    /**
     * Inicializador principal de la clase. Realiza validaciones iniciales.
     */
    init {
        require(this.marca.isNotEmpty()) {"La marca no puede estar vacía."}
        require(this.modelo.isNotEmpty()) {"El modelo no puede estar vacío."}
    }


    /**
     * Segundo inicializador de la clase. Realiza validaciones adicionales para los atributos.
     */
    init{
        require(this.numCaballos >= 70 || this.numCaballos <= 700) {"El número de caballos debe estar entre 70 y 700"}
        require(this.numPuertas >= 3 || this.numPuertas <= 5) {"El número de puertas debe ser de 3 a 5"}
        require(this.matricula.length == 7) {"La matrícula debe tener 7 caracteres"}
        requireColor()
    }


    /**
     * Método privado que valida que el color no sea nulo ni vacío.
     */
    private fun requireColor() {
        require(this.color.isNotBlank()) {"El color no puede ser nulo"}
    }


    /**
     * Sobrescribe el método toString para proporcionar una representación de cadena del objeto Coche.
     *
     * @return Cadena que describe las características del coche.
     */
    override fun toString(): String {
        return "El coche con la matrícula ${this.matricula} es un ${this.marca} ${this.modelo} con ${this.numCaballos}cv, ${this.numPuertas} puertas y de color ${this.color}."
    }
}


fun main() {

    val coche1 = Coche("Ford", "Focus", 120, 5, "4568GHR", "Blanco")
    val coche2 = Coche("Renault", "Megane", 115, 5, "5449ERF", "Gris")
    val coche3 = Coche("Seat", "Leon", 100, 3, "4697UIG", "Rojo")

    val coches = arrayListOf(coche1, coche2, coche3)

    for (coche in coches) {
        println(coche)
    }

}