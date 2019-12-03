import java.io.File

fun main(args: Array<String>) {
    try {
        val plikKartaPlatnicza = "src/klient.txt"
        val linie: List<String> = File(plikKartaPlatnicza).readLines()
        val klient = Klient(plikKartaPlatnicza, 760)
        val bankomat = Bankomat()

        val pin = linie[3]

        if (pin == "2137") {
            println("Zalogowano jako: " + klient.imieKlienta + " " + klient.nazwiskoKlienta + "\nPIN: **** \nStan konta: " + klient.stanKonta + "PLN\nKwota do wypłaty: " + klient.ileDoWyplaty + "PLN")
            bankomat.Wyplata(klient.ileDoWyplaty, klient)
        } else {
            println("Zły pin!")
        }
    }
    catch(e: Exception){
        println(e)
    }
}