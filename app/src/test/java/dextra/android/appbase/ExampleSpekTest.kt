package dextra.android.appbase

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

// https://github.com/spekframework/spek
// https://github.com/raniejade/spek-idea-plugin
// DOC -> http://spekframework.org/docs/latest/#_writing_specifications

class ExampleSpekTest : Spek({

    describe("A simple test.") {
        var x = 0
        var y = 0
        var sum : Int

        beforeGroup {
            x = 2
            y = 3
        }

        it("should be that x + y = 5") {
            sum = x + y
            assertEquals(5, sum)
        }

        context("when y is 0") {
            beforeGroup {
                y = 0
            }

            it("should be that x + y = x") {
                sum = x + y
                assertEquals(2, sum)
            }
        }
    }
})