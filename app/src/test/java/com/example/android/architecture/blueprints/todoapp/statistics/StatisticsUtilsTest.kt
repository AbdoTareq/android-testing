package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Given
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {

        // Given
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)
        )
        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }


    @Test
    fun getActiveAndCompletedStats_fortyPercentCompleted_returnsFortyPercent() {

        // Given
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )
        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZero() {

        // Given
        val tasks = listOf<Task>(
        )
        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty2_returnsZero() {

        // Given
        val tasks = null
        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }


}