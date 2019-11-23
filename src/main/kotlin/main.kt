import com.opencsv.CSVWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

fun main(){
    var fileNameLast = File("src/main/Names/","last.csv")
    var fileNameFPR = File("src/main/Names/","PR.TXT")
    var fileNameFTR = File("src/main/Names/", "TR.TXT")
    var names = ArrayList<name>()

    val firstNames = readFilesAsLinesUsingUseLines(fileNameFPR) as ArrayList<String>
    val firstNames1 = readFilesAsLinesUsingUseLines(fileNameFTR) as ArrayList<String>
    firstNames += firstNames1
    val lastNames = readFilesAsLinesUsingUseLines(fileNameLast) as ArrayList<String>

    var f = 0
    var l = 0

    firstNames.shuffle()
    lastNames.shuffle()

    for (i in 0..100){
        names.add(name(firstNames[f], lastNames[l]))
        f++
        l++
        if(f > firstNames.size){
            firstNames.shuffle()
            f = 0
        }
        if(l > lastNames.size){
            lastNames.shuffle()
            l = 0
        }
    }
    writeCSV(names)
    println("Finished")

}
fun readFileByLineUsingForEachLine(fileName: String)
        = File(fileName).forEachLine { println(it) }
fun readFilesAsLinesUsingUseLines(fileName: File): List<String>
        =fileName.useLines { it.toList() }
fun writeCSV(namesList: ArrayList<name>){
    var fileName = File("names.csv")

    var fileWriter = FileWriter(fileName)
    var csvWriter = CSVWriter(fileWriter)
    try{
        for(obj in namesList){
            csvWriter.writeNext(arrayOf(obj.first, obj.last))
        }
    }catch(e: IOException){

    }
}