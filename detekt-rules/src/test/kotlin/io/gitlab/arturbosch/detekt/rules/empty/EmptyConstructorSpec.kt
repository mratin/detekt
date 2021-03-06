package io.gitlab.arturbosch.detekt.rules.empty

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.test.assertThat
import io.gitlab.arturbosch.detekt.test.lint
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

/**
 * @author Artur Bosch
 */
class EmptyConstructorSpec : Spek({

	it("should not report empty constructors for annotation classes with expect or actual keyword - #1362") {
		val code = """
			expect annotation class NeedsConstructor()
			actual annotation class NeedsConstructor actual constructor()

			@NeedsConstructor
			fun annotatedFunction() = Unit
		""".trimIndent()

		val findings = EmptyDefaultConstructor(Config.empty).lint(code)

		assertThat(findings).isEmpty()
	}
})
