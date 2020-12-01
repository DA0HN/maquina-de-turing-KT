import org.daohn.FileManager

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
fun main() {
    val fileManager = FileManager()
    val (configuration, turingTable) = fileManager.loadConfigurations(
        "src/main/resources/config" +
                ".txt"
    )

}