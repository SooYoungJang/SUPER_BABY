package com.sooyoungjang.superbaby

import com.appmattus.kotlinfixture.kotlinFixture
import com.sooyoungjang.superbaby.main.MainViewModel
import com.sooyoungjang.superbaby.main.contract.MainState
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.orbitmvi.orbit.liveTest


@OptIn(ExperimentalCoroutinesApi::class)
class MainActivityViewModelTest : BehaviorSpec({
    coroutineTestScope = true
    isolationMode = IsolationMode.InstancePerLeaf
    val fixture = kotlinFixture()
    val testDispatcher = UnconfinedTestDispatcher()

    beforeSpec {
        Dispatchers.setMain(testDispatcher)
    }

    afterSpec {
        Dispatchers.resetMain()
    }

    Given("vm을 생성하고 ") {
        val vm = MainViewModel()
        val initState = MainState()

        When("init 이 완료 되면") {
            val testSubject = vm.liveTest(initState).also { it.runOnCreate() }

            Then("초기 상태 값을 같는다.") {
                testSubject.assert(initState) {
                    states(
                        {
                            copy(isLoading = false)
                        },
                    )
                }
            }
        }
    }
})