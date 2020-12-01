import org.daohn.FileManager

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
fun main(args: Array<String>) {
    val fileManager = FileManager()
    fileManager.loadConfigurations("src/main/resources/config.txt")
}