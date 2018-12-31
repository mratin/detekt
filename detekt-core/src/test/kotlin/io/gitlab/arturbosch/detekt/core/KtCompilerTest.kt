package io.gitlab.arturbosch.detekt.core

import io.gitlab.arturbosch.detekt.api.internal.RELATIVE_PATH
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

/**
 * @author Artur Bosch
 */
class KtCompilerTest : Spek({

	it("ktFileHasExtraUserData") {
		val ktCompiler = KtCompiler()

		val ktFile = ktCompiler.compile(path, path.resolve("Default.kt"))

		assertThat(ktFile.getUserData(LINE_SEPARATOR)).isEqualTo("\n")
		assertThat(ktFile.getUserData(RELATIVE_PATH))
				.isEqualTo(path.fileName.resolve("Default.kt").toString())
	}
})
