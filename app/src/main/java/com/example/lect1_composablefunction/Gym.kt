package com.example.lect1_composablefunction


data class Gym(val id: Int, val name: String, val place: String, var isFavourite: Boolean = false)

val listOfGyms = listOf<Gym>(
    Gym(1, "Gym 1", "The gem place in maxico city 👌"),
    Gym(2, "Gym 2", "The gem place in Spain country 👌"),
    Gym(3, "Gym 3", "The gem place in Ramalla city 👌"),
    Gym(4, "Gym 4", "The gem place in palestint country 👌"),
    Gym(5, "Gym 5", "The gem place in JezaEyjpt city 👌"),
    Gym(6, "Gym 6", "The gem place in Gaza city "),
    Gym(7, "Gym 7", "The gem place in Gaza city "),
    Gym(8, "Gym 8", "The gem place in Gaza city "),
    Gym(9, "Gym 9", "The gem place in Gaza city "),
    Gym(10,"Gym 10", "The gem place in Gaza city "),
    Gym(11, "Gym 11", "The gem place in Gaza city "),
    Gym(12, "Gym 12", "The gem place in Gaza city "),
    Gym(13, "Gym 13", "The gem place in Gaza city "),
    Gym(14, "Gym 14", "The gem place in Gaza city "),
    Gym(15, "Gym 15", "The gem place in Gaza city ")
)