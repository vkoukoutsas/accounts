package com.r3.corda.lib.accounts.workflows.flows

import co.paralleluniverse.fibers.Suspendable
import com.r3.corda.lib.accounts.contracts.states.AccountInfo
import com.r3.corda.lib.accounts.workflows.accountService
import net.corda.core.contracts.StateAndRef
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.StartableByRPC
import java.security.PublicKey

/**
 * Returns the [AccountInfo] for a specified [PublicKey]
 *
 * @property publicKey the [PublicKey] to return the [AccountInfo] for
 */
@StartableByRPC
class AccountInfoByKey(private val publicKey: PublicKey) : FlowLogic<StateAndRef<AccountInfo>?>() {
    @Suspendable
    override fun call(): StateAndRef<AccountInfo>? {
        return accountService.accountInfo(publicKey)
    }
}
