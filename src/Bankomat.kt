class Bankomat () {

    val banknoty:List<Int> = listOf(500,200,100,50,20,10);
    val iloscBanknotow:MutableList<Int> = mutableListOf(5,5,5,5,5,5);
    val banknotyDoWyplacenia:MutableList<Int> = mutableListOf(0,0,0,0,0,0);
    var czyStanOK = true;
    val iloscPieniedzyWBanku = banknoty[0]*iloscBanknotow[0]+banknoty[1]*iloscBanknotow[1]+banknoty[2]*iloscBanknotow[2]+banknoty[3]*iloscBanknotow[3]+banknoty[4]*iloscBanknotow[4]+banknoty[5]*iloscBanknotow[5];

    fun Wyplata(iloscPieniedzyDoWyplatyTMP: Int, klient: Klient) {
        var iloscPieniedzyDoWyplaty = iloscPieniedzyDoWyplatyTMP

        println("Stan początkowy bankomatu: " + iloscPieniedzyWBanku + "PLN")

        while(iloscPieniedzyDoWyplaty>0) {

            if (klient.stanKonta.toInt() - iloscPieniedzyDoWyplaty < 0) {
                println(klient.imieKlienta + ", masz za mało na koncie!")
                break
            }
            else if (iloscPieniedzyDoWyplaty % 10 != 0) {
                println("Nieprawidłowa kwota!")
                break
            }

            else if (iloscPieniedzyWBanku - iloscPieniedzyDoWyplaty <= 0) {
                println("W bankomacie jest za mało pieniędzy!")
                break
            }

            else if (iloscPieniedzyDoWyplaty >= banknoty[0] && iloscBanknotow[0] > 0) {
                iloscPieniedzyDoWyplaty -= banknoty[0]
                banknotyDoWyplacenia[0]++
            }

            else if (iloscPieniedzyDoWyplaty >= banknoty[1] && iloscBanknotow[1] > 0) {
                iloscPieniedzyDoWyplaty -= banknoty[1]
                banknotyDoWyplacenia[1]++
            }

            else if (iloscPieniedzyDoWyplaty >= banknoty[2] && iloscBanknotow[2] > 0) {
                iloscPieniedzyDoWyplaty -= banknoty[2]
                banknotyDoWyplacenia[2]++
            }

            else if (iloscPieniedzyDoWyplaty >= banknoty[3] && iloscBanknotow[3] > 0) {
                iloscPieniedzyDoWyplaty -= banknoty[3]
                banknotyDoWyplacenia[3]++
            }

            else if (iloscPieniedzyDoWyplaty >= banknoty[4] && iloscBanknotow[4] > 0) {
                iloscPieniedzyDoWyplaty -= banknoty[4]
                banknotyDoWyplacenia[4]++
            }

            else if (iloscPieniedzyDoWyplaty >= banknoty[5] && iloscBanknotow[5] > 0) {
                iloscPieniedzyDoWyplaty -= banknoty[5]
                banknotyDoWyplacenia[5]++
            }
            else{
                czyStanOK = false;
                println("Brak odpowiednich srodkow w bankomacie")
                break
            }
        }
        if(czyStanOK == true) {
            println("Bankomat wypłacił\n500PLN x ${banknotyDoWyplacenia[0]}\n200PLN x ${banknotyDoWyplacenia[1]}\n100PLN x ${banknotyDoWyplacenia[2]}\n50PLN x ${banknotyDoWyplacenia[3]}\n20PLN x ${banknotyDoWyplacenia[4]}\n10PLN x ${banknotyDoWyplacenia[5]}\n");
            println("${klient.imieKlienta} ${klient.nazwiskoKlienta} wypłacił: ${iloscPieniedzyDoWyplatyTMP}PLN\nW banku zostało: "+(iloscPieniedzyWBanku-iloscPieniedzyDoWyplatyTMP)+"PLN")
        }
        else {
            println("Nie można wypłacić pieniędzy!")
        }
    }
}