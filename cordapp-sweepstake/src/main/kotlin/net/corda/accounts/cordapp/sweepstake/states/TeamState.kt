package net.corda.accounts.cordapp.sweepstake.states
import net.corda.accounts.cordapp.sweepstake.contracts.TournamentContract
import net.corda.accounts.cordapp.sweepstake.flows.WorldCupTeam
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.AnonymousParty
import java.security.PublicKey
import java.util.*

@BelongsToContract(TournamentContract::class)
data class TeamState(val team: WorldCupTeam,
                     val owningAccountId: UUID,
                     val assignedToPlayer: Boolean? = false,
                     val owningKey: PublicKey? = null,
                     override val linearId: UniqueIdentifier = UniqueIdentifier()) : LinearState {
    override val participants: List<AbstractParty>
        get() = listOfNotNull(owningKey).map { AnonymousParty(it) }
}