package com.example.translateit_android.data

import javax.inject.Inject
import kotlin.random.Random

class GameRepository @Inject constructor() {

    private val map = mapOf(
        "apple" to "maçã",
        "house" to "casa",
        "book" to "livro",
        "car" to "carro",
        "water" to "água",
        "food" to "comida",
        "love" to "amor",
        "friend" to "amigo",
        "family" to "família",
        "dog" to "cachorro",
        "cat" to "gato",
        "computer" to "computador",
        "phone" to "telefone",
        "music" to "música",
        "sun" to "sol",
        "moon" to "lua",
        "star" to "estrela",
        "sky" to "céu",
        "earth" to "terra",
        "fire" to "fogo",
        "tree" to "árvore",
        "flower" to "flor",
        "river" to "rio",
        "mountain" to "montanha",
        "sea" to "mar",
        "rain" to "chuva",
        "snow" to "neve",
        "wind" to "vento",
        "child" to "criança",
        "school" to "escola",
        "teacher" to "professor",
        "student" to "estudante",
        "work" to "trabalho",
        "money" to "dinheiro",
        "time" to "tempo",
        "day" to "dia",
        "night" to "noite",
        "morning" to "manhã",
        "evening" to "noite",
        "happy" to "feliz",
        "sad" to "triste",
        "big" to "grande",
        "small" to "pequeno",
        "fast" to "rápido",
        "slow" to "devagar",
        "new" to "novo",
        "old" to "velho",
        "clean" to "limpo",
        "dirty" to "sujo",
        "hot" to "quente"
    )

    fun generateQuestion(): Triple<String, String, List<String>> {
        val en = map.keys.random()
        val correct = map[en]!!

        val options = map.values
            .shuffled(Random(System.nanoTime()))
            .filterNot { it == correct }
            .take(3) + correct

        return Triple(en, correct, options.shuffled())
    }
}
