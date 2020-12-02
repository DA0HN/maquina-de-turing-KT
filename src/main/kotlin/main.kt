import org.daohn.FileManager
import org.daohn.MachineLogging
import org.daohn.TuringMachine

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
fun main() {
    val fileManager = FileManager()
    val (configuration, turingTable) = fileManager.loadConfigurations(
        "src/main/resources/config.txt"
    )

    val turingMachine = TuringMachine(configuration, turingTable, MachineLogging())

    println("000111   -> Está valido? " + turingMachine.putOnTape("000111"))
    println("00001111 -> Está valido? " + turingMachine.putOnTape("00001111"))
    println("01       -> Está valido? " + turingMachine.putOnTape("01"))
    println("00000111 -> Está valido? " + turingMachine.putOnTape("00000111"))
    println("00011111 -> Está valido? " + turingMachine.putOnTape("00011111"))
}