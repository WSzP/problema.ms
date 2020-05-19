package com.example.tgmuresproblema.data.startup.steps

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */
interface Step {

    fun execute(successListener: StepSuccessListener)

}