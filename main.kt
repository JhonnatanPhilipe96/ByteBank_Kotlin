fun main() {
    println("Bem vindo ao Bytebank")
    println()

    var contaJhon = Conta(titular = "Jhonnatan", numero = 1001)
    contaJhon.deposita(100.00)

    var contaEdi = Conta(titular = "Ediane", numero = 1002)
    contaEdi.deposita(110.00)

    println("Titular da conta: ${contaJhon.titular}")
    println("Numero de conta: ${contaJhon.numero}")
    println("Saldo atual: ${contaJhon.saldo}")

    println()

    println("Titular da conta: ${contaEdi.titular}")
    println("Numero de conta: ${contaEdi.numero}")
    println("Saldo atual: ${contaEdi.saldo}")

    println()
    contaJhon.deposita(valor = 150.00)

    println()
    contaEdi.deposita(valor = 350.00)

    contaJhon.saca(valor = 150.00)

    println()
    if (contaEdi.transfere(valor = 200.00, destino = contaJhon)) {
        println("Comunicação checada...")
    }

    println("${contaJhon.titular} seu saldo atual e de: ${contaJhon.saldo}")
    println("${contaEdi.titular} seu saldo atual e de: ${contaEdi.saldo}")

}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        this.saldo += valor
        println("Deposito realizado na conta de: ${this.titular}")
        println("Seu saldo atual e de: ${this.saldo}")
        println()
    }

    fun saca(valor: Double) {
        if (valor <= this.saldo) {
            this.saldo -= valor
            println("${this.titular} sacou: $valor")
            println("${this.titular} Seu saldo atual e de: ${this.saldo}")
            println()
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        var executou = false

        if (valor <= this.saldo) {
            this.saldo -= valor
            println("Transferencia realizada da conta de: ${this.titular}")
            println("Valor de: $valor")
            println()
            destino.deposita(valor)
            executou = true
        }
        return executou
    }

}

fun testaCopiasERefencias() {
    var numeroA = 10
    var numeroB = numeroA

    numeroB = 20
    println(numeroA)
    println(numeroB)

    var contaJoao = Conta("Joao", 1003)
    var contaJessica = Conta("Jessica", 1004)

    println("Titular conta Joao ${contaJoao.titular}")
    println("Titular conta Jessica ${contaJessica.titular}")

    println(contaJoao)
    println(contaJessica)
}

fun testaCondicoes(saldo: Double) {
    when {
        saldo > 0.0 -> println("Seu saldo é positivo")
        saldo == 0.0 -> println("Seu saldo é neutro")
        else -> println("Seu saldo é negativo")
    }
}

fun testaLacos() {
    var i = 1
    var titular = "Jhonnatan "
    var numeroConta = 1000
    var saldo = 100.00

    for (i in 5 downTo 1) {
        titular = "Jhonnatan " + i
        numeroConta = 1000 + i
        saldo = 100.00 + i


        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")

        println()
    }

    while (i < 6) {
        titular = "Jhonnatan " + i
        numeroConta = 1000 + i
        saldo = 100.00 + i


        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")

        println()
        i++
    }
}