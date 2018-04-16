package com.hireme

import android.app.Application
import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.hireme.resume.ResumeItem
import com.hireme.resume.ResumeRepository
import com.hireme.resume.ResumeViewModel
import com.hireme.util.EmailManager
import com.hireme.util.ExternalUrlManager
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * More tests!
 */
class ResumeTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var application: Application

    @Mock
    private lateinit var resumeRepository: ResumeRepository

    @Mock
    private lateinit var emailManagerMock: EmailManager

    @Mock
    private lateinit var externalUrlManagerMock: ExternalUrlManager

    private val viewModel
        get() = ResumeViewModel(application).apply {
            repository = resumeRepository
            emailManager = emailManagerMock
            externalUrlManager = externalUrlManagerMock
        }

    @Before
    fun setup() = MockitoAnnotations.initMocks(this)

    @Test
    fun shouldLoadResume() {
        val resumeItems = listOf(
            ResumeItem("title", "description", R.drawable.ic_resume, "url"),
            ResumeItem("title2", "description2", R.drawable.ic_resume, "url2")
        )
        given(resumeRepository.fetchResumeItems()).willReturn(resumeItems)
        val resumeItemsLiveData = viewModel.loadResumeItems()
        assertEquals(resumeItems, resumeItemsLiveData.value)
    }

    @Test
    fun openLinkedinTest() {
        viewModel.openLinkedin()
        verify(externalUrlManagerMock).openLinkedin()
    }

    @Test
    fun openStackoverflowTest() {
        viewModel.openStackoverflow()
        verify(externalUrlManagerMock).openStackoverflow()
    }

    @Test
    fun openGithubTest() {
        viewModel.openGithub()
        verify(externalUrlManagerMock).openGithub()
    }
}
