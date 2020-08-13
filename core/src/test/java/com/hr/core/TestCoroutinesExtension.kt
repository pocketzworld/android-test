@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.hr.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

object TestCoroutinesExtension : BeforeEachCallback, AfterEachCallback {
    val dispatcher = TestCoroutineDispatcher()

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(dispatcher)
    }

    override fun afterEach(context: ExtensionContext?) {
        dispatcher.advanceUntilIdle()
        dispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}

fun coroutineTest(block: suspend TestCoroutineScope.() -> Unit) = runBlockingTest(TestCoroutinesExtension.dispatcher, block)