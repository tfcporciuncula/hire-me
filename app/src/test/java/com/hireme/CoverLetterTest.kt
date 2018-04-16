package com.hireme

import com.hireme.coverletter.CoverLetter
import com.hireme.coverletter.CoverLetterPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * MVP-style unit tests!
 */
class CoverLetterTest {

    @Mock
    private lateinit var view: CoverLetter.View

    @Mock
    private lateinit var repository: CoverLetter.Repository

    private val presenter get() = CoverLetterPresenter(view, repository)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun shouldLoadCoverLetter() {
        given(repository.fetchCoverLetterContent()).willReturn("content")
        presenter.loadCoverLetter()
        verify(view).showCoverLetter("content")
    }
}
