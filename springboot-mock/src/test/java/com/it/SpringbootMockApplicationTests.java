package com.it;

import com.it.entity.Book;
import com.it.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * The type Mock springboot application tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringbootMockApplicationTests {
	@Resource
	private MockMvc mockMvc;
	@MockBean
	private BookService bookService;

	@Test
	public void bookApiTest() throws Exception {
		String title = "java learning";
		// mockbean 开始模拟
		bookServiceMockBean(title);
		// mockbean 模拟完成
		String expect = "{\"title\":\"java learning\",\"author\":\"dax\",\"price\":78.56,\"releaseTime\":\"2018-03-22\"}";
		mockMvc.perform(MockMvcRequestBuilders.get("/book/get")
				.param("title", title))
				.andExpect(MockMvcResultMatchers.content()
						.json(expect))
				.andDo(MockMvcResultHandlers.print());
		// mockbean 重置
	}

	@Test
	public void bookServiceTest() {

		String title = "java learning";
		bookServiceMockBean(title);

		System.out.println(bookService.queryByTitle("java learning"));
		//Assertions.assertThat(bookService.queryByTitle("ss").getTitle()).isEqualTo(title);

	}

	private void bookServiceMockBean(String title) {

		Book book = new Book();
		book.setAuthor("dax");
		book.setPrice(78.56);
		book.setReleaseTime(LocalDate.of(2018, 3, 22));
		book.setTitle(title);

		BDDMockito.given(bookService.queryByTitle(title)).willReturn(book);
	}


}