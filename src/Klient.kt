import java.io.File

class Klient(sciezka: String,ileDoWyplaty:Int){

        val linie: List<String> = File(sciezka).readLines()
        val imieKlienta = linie[0]
        val nazwiskoKlienta = linie[1]
        var stanKonta = linie[2].toInt()
        var ileDoWyplaty = ileDoWyplaty
}