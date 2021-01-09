package com.github.felbinger.kotlintemplate

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class AppTest {
    @Transient
    private val out = ByteArrayOutputStream()

    @Transient
    private val originalOut = System.out

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(out, false, StandardCharsets.UTF_8))
    }

    @Test
    fun testMain() {
        main()
        Assertions.assertEquals("Hello World${System.lineSeparator()}", out.toString(StandardCharsets.UTF_8))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }
}