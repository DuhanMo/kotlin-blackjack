package blackjack.domain

class GameTable(
    private val participants: List<Participant>,
    private val deck: Deck,
) {
    fun dealInitCard(): List<Participant> {
        return participants.map { participant ->
            (1..INIT_CARD_DRAW_COUNT).fold(participant) { acc, _ ->
                acc.hit(deck.draw())
            }
        }
    }

    fun hit(participant: Participant): Participant {
        return participant.hit(deck.draw())
    }

    companion object {
        const val INIT_CARD_DRAW_COUNT = 2
    }
}
