package com.hireme

import com.hireme.coverletter.CoverLetter
import com.hireme.coverletter.CoverLetterPresenter
import com.hireme.coverletter.CoverLetterRepository
import com.hireme.util.EmailManager
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
    private lateinit var repository: CoverLetterRepository

    @Mock
    private lateinit var emailManager: EmailManager

    private val presenter get() = CoverLetterPresenter(view, repository, emailManager)

    @Before
    fun setup() = MockitoAnnotations.initMocks(this)

    @Test
    fun shouldLoadCoverLetter() {
        given(repository.fetchCoverLetterContent()).willReturn("content")
        presenter.loadCoverLetter()
        verify(view).showCoverLetter("content")
    }
}
